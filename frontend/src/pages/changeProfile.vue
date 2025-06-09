<template>
  <div class="user-info-container">
    <div class="user-card">
      <div class="avatar-container">
        <img :src="avatarUrl" alt="用户头像" class="avatar" />
        <el-button 
          size="small" 
          type="primary" 
          class="edit-avatar-btn"
          @click="handleChooseAvatar"
        >
          <i class="el-icon-camera" /> 修改头像
        </el-button>
        <!-- 隐藏的文件输入框 -->
        <input 
          type="file" 
          ref="avatarInput" 
          accept="image/jpg,image/jpeg,image/png,image/gif"
          @change="handleFileChange"
          style="display: none;"
        />
      </div>

      <div class="user-details">
        <!-- 其他字段保持不变 -->
        <div class="info-row">
          <span class="label">用户名</span>
          <span class="value">{{ userInfo.username }}</span>
        </div>

        <div class="info-row">
          <span class="label">邮箱</span>
          <span class="value">
            <i class="el-icon-message" /> {{ userInfo.email }}
          </span>
        </div>

        <!-- 昵称可编辑 -->
        <div class="info-row">
          <span class="label">昵称</span>
          <el-input 
            v-model="editedInfo.nickname" 
            size="small" 
            class="editable-input"
            style="width: 200px;"
          />
        </div>

        <!-- 性别可编辑 -->
        <div class="info-row">
          <span class="label">性别</span>
          <el-radio-group 
            v-model="editedInfo.gender" 
            class="gender-radio-group"
            style="display: flex; gap: 20px;"
          >
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </div>

        <!-- 年龄可编辑 -->
        <div class="info-row">
          <span class="label">年龄</span>
          <el-input 
            v-model.number="editedInfo.age" 
            size="small" 
            type="number" 
            class="editable-input"
            style="width: 100px;"
          />
        </div>

        <!-- 个性签名可编辑 -->
        <div class="info-row signature">
          <span class="label">个性签名</span>
          <el-input 
            v-model="editedInfo.signature" 
            size="small" 
            type="textarea" 
            :rows="3" 
            class="editable-input"
            style="width: 300px;"
          />
        </div>
      </div>

      <!-- 按钮组保持不变 -->
      <div class="btn-group" style="margin-top: 20px;">
        <el-button type="primary" class="save-btn" @click="saveChanges">
          <i class="el-icon-save" /> 保存修改
        </el-button>
        <el-button type="default" class="cancel-btn" @click="cancelEdit">
          <i class="el-icon-refresh-right" /> 取消修改
        </el-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { getImageApi, getUserInfoApi, logoutApi, updateUserInfoApi } from '@/request/api'
import { ref, onMounted, reactive } from 'vue'
import type { GetUserInfoResponse } from "@/dto/UserDto";
import { useUserStat } from '@/stores/userStat';
import router from '@/router';

// 用户信息数据
const userInfo = ref<GetUserInfoResponse>({
  avatar: 'https://picsum.photos/200/200',
  username: 'test_user',
  email: 'test@example.com',
  nickname: '测试用户',
  gender: 'male', // male 或 female
  age: 25,
  signature: '生活不止眼前的苟且，还有诗和远方'
})

const avatarUrl = ref<string>('https://picsum.photos/200/200');
const avatarInput = ref<HTMLInputElement | null>(null); // 引用文件输入框
const selectedAvatarFile = ref<File | null>(null); // 新增：存储选中的文件

// 模拟获取用户信息
const fetchUserInfo = async () => {
  // 这里应该是调用API获取用户信息
  const response = await getUserInfoApi();
  if(response.data.code == 200){
    userInfo.value = response.data.data;
    editedInfo.nickname = userInfo.value.nickname
    editedInfo.gender = userInfo.value.gender
    editedInfo.age = userInfo.value.age
    editedInfo.signature = userInfo.value.signature
    //获取头像
    const avatarResponse = await getImageApi(response.data.data.avatar);
    avatarUrl.value = URL.createObjectURL(avatarResponse.data);
  } else{
    alert(response.data.message);
  }
}

onMounted(() => {
  fetchUserInfo()
})

// 编辑时的临时数据，用于双向绑定
const editedInfo = reactive({
  nickname: userInfo.value.nickname,
  gender: userInfo.value.gender,
  age: userInfo.value.age,
  signature: userInfo.value.signature
})

const cancelEdit = () => {
  router.push('/profile'); // 取消编辑，返回个人信息页面
}

// 修改头像相关逻辑（修改部分）
const handleChooseAvatar = () => {
  avatarInput.value?.click(); // 触发文件选择框
}

const handleFileChange = (e: Event) => {
  const file = (e.target as HTMLInputElement)?.files?.[0];
  if (!file) return; // 未选择文件时返回

  // 校验文件类型（支持 jpg/jpeg/png/gif）
  const isValid = /\.(jpg|jpeg|png|gif)$/i.test(file.name);
  if (!isValid) {
    alert('仅支持 JPG/JPEG/PNG/GIF 格式的图片');
    (e.target as HTMLInputElement).value = ''; // 清空文件选择
    return;
  }

  // 存储选中的文件并生成预览
  selectedAvatarFile.value = file;
  
  // 生成预览 URL
  const reader = new FileReader();
  reader.onload = (event) => {
    if (event.target?.result) {
      avatarUrl.value = event.target.result as string;
    }
  };
  reader.readAsDataURL(file);
}

// 保存修改逻辑（修改部分）
const saveChanges = async () => {
  try {
    // 创建 FormData 对象用于上传文件
    const formData = new FormData();
    
    // 添加常规字段
    formData.append('nickname', editedInfo.nickname);
    formData.append('age', editedInfo.age.toString());
    formData.append('gender', editedInfo.gender);
    formData.append('signature', editedInfo.signature);
    
    // 处理头像上传
    if (selectedAvatarFile.value) {
      // 用户选择了新头像，添加到 FormData
      formData.append('avatar', selectedAvatarFile.value);
    } else {
      // 用户未选择新头像，使用原有头像标识
      formData.append('avatar', userInfo.value.avatar);
    }
    
    // 调用 API 上传数据
    const response = await updateUserInfoApi(formData, {
      headers: {
        'Content-Type': 'multipart/form-data' // 重要：指定表单数据类型
      }
    });
    
    if (response.data.code === 200) {
      alert('保存成功');
      router.push('/profile'); // 保存成功后跳转回个人信息页面
    } else {
      alert(response.data.message || '保存失败');
    }
  } catch (error) {
    console.error('保存修改失败:', error);
    alert('保存过程中发生错误');
  }
};

// 移除了 urlToBlob 函数，不再需要将 URL 转换为 Blob
</script>

<style scoped>
/* 样式保持完全不变 */
.user-info-container {
  display: flex;
  justify-content: center;
  padding: 20px;
}

.user-card {
  width: 100%;
  max-width: 500px;
  background-color: #fff;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  padding: 30px;
}

.avatar-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 30px;
}

.avatar {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  object-fit: cover;
  margin-bottom: 15px;
  border: 3px solid #f0f0f0;
  transition: transform 0.3s ease;
}

.avatar:hover {
  transform: scale(1.05);
}

.edit-avatar-btn {
  background-color: #409eff;
  color: white;
  border: none;
  padding: 8px 16px;
  border-radius: 6px;
  cursor: pointer;
  transition: all 0.3s;
}

.edit-avatar-btn:hover {
  background-color: #66b1ff;
}

.user-details {
  width: 100%;
}

.info-row {
  display: flex;
  align-items: center;
  padding: 12px 0;
  border-bottom: 1px solid #f0f0f0;
}

.info-row:last-child {
  border-bottom: none;
}

.label {
  width: 80px;
  color: #909399;
  font-weight: 500;
}

.value {
  flex: 1;
  color: #303133;
}

.signature .value {
  min-height: 40px;
  line-height: 1.5;
}

.btn-group {
  display: flex;
  justify-content: space-between;
  margin-top: 30px;
}

.save-btn {
  background-color: #409eff;
  color: white;
  border: none;
  padding: 10px 20px;
  border-radius: 6px;
  font-weight: 500;
  transition: all 0.3s;
}

.save-btn:hover {
  background-color: #66b1ff;
}

.cancel-btn {
  background-color: #f5f7fa;
  color: #606266;
  border: 1px solid #dcdfe6;
  padding: 10px 20px;
  border-radius: 6px;
  font-weight: 500;
  transition: all 0.3s;
}

.cancel-btn:hover {
  background-color: #f0f2f5;
}

.editable-input {
  margin-left: 10px; 
}
</style>