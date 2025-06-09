<template>
  <div class="user-profile-container">
    <div class="profile-card">
      <!-- 用户头像 -->
      <div class="avatar-container">
        <el-avatar :size="120" :src="avatarUrl" shape="circle" />
      </div>
      
      <!-- 基本信息 -->
      <div class="info-container">
        <h2 class="nickname">{{ userInfo.nickname }}</h2>
        <p class="username">{{ userInfo.username }}</p>
        
        
        <div class="attribute-list">
          <div class="attribute-item">
            <el-icon><User /></el-icon>
            <span>{{ userInfo.username }}</span>
          </div>
          
          <div class="attribute-item">
            <el-icon><UserFilled/></el-icon>
            <span>{{ userInfo.nickname }}</span>
          </div>
          
          <div class="attribute-item">
            <el-icon><Calendar /></el-icon>
            <span>{{ userInfo.age }} 岁</span>
          </div>
          
          <div class="attribute-item">
              <el-icon v-if="userInfo.gender === '男'"><Male /></el-icon>
              <el-icon v-else><Female /></el-icon>
            <span>{{ userInfo.gender }}</span>
          </div>
          
          <div class="attribute-item">
            <el-icon><Edit /></el-icon>
            <span>{{ userInfo.signature || '这个人很懒，还没有设置签名' }}</span>
          </div>
        </div>
      </div>
      
      <!-- 操作按钮 -->
      <div class="action-buttons">
        <el-button type="primary" icon="ChatLine" @click="handlePrivateChat">
          私聊
        </el-button>
        <el-button type="danger" icon="Delete" @click="handleDeleteFriend">
          删除好友
        </el-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { onMounted, ref, watch } from 'vue';
import { User,  Calendar, Male, Female, Edit, Delete, UserFilled } from '@element-plus/icons-vue';
import { deleteFriendApi, getImageApi, getUserInfoApi } from '@/request/api';
import type { GetUserInfoResponse } from '@/dto/UserDto';
import { useRoute } from 'vue-router';
import router from '@/router';

const props = defineProps({
  username: String
});

const avatarUrl = ref<string>('https://picsum.photos/200/200');
const userInfo = ref<GetUserInfoResponse>({
  avatar: 'https://picsum.photos/200/200',
  username: 'test_user',
  email: 'test@example.com',
  nickname: '测试用户',
  gender: '男', // male 或 female
  age: 25,
  signature: '生活不止眼前的苟且，还有诗和远方',
  status: 0
});

const fetchUserInfo = async () => {
  if (props.username) {
    // 这里应该是调用API获取用户信息
    const response = await getUserInfoApi(props.username);
    if (response.data.code == 200) {
      userInfo.value = response.data.data;
      // 获取头像
      const avatarResponse = await getImageApi(response.data.data.avatar);
      avatarUrl.value = URL.createObjectURL(avatarResponse.data);
    } else {
      alert(response.data.message);
    }
  }
};

onMounted(async () => {
  await fetchUserInfo();
});

// 监听 props.username 的变化
watch(() => props.username, (newUsername) => {
  if (newUsername) {
    fetchUserInfo();
  }
});

// 按钮点击事件处理
const handlePrivateChat = () => {
  console.log('发起私聊:', userInfo.value.username);
  router.push({
    name: 'PrivateChat',
    params: { username: userInfo.value.username }
  });
};

const handleDeleteFriend = async () => {
  console.log('删除好友:', userInfo.value.username);
  const response =  await deleteFriendApi(userInfo.value.username);
  if(response.data.code === 200) {
    alert('删除好友成功');
  } else {
    alert(response.data.message);
  }
};
</script>

<style scoped>
.user-profile-container {
  display: flex;
  justify-content: center;
  padding: 20px;
}

.profile-card {
  width: 400px;
  height: 130%;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.1);
  background-color: #fff;
}

.avatar-container {
  display: flex;
  justify-content: center;
  margin-bottom: 20px;
}

.info-container {
  text-align: center;
  margin-bottom: 20px;
}

.username {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 5px;
}

.nickname {
  font-size: 16px;
  color: #606266;
  margin-bottom: 20px;
}

.attribute-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
  text-align: left;
}

.attribute-item {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 5px 0;
}

.attribute-item el-icon {
  color: #909399;
  width: 20px;
  text-align: center;
}

.action-buttons {
  display: flex;
  justify-content: center;
  gap: 20px;
  margin-top: 20px;
}

.el-icon-male {
  color: #409eff;
  margin-right: 5px;
}

.el-icon-female {
  color: #f56c6c;
  margin-right: 5px;
}
</style>