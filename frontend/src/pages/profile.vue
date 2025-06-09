<template>
  <div class="user-info-container">
    <div class="user-card">
      <el-icon @click="goBack" class="back-icon">
                    <svg t="1748609671667" class="icon" viewBox="0 0 1024 1024" version="1.1"
                        xmlns="http://www.w3.org/2000/svg" p-id="5087" width="30" height="20">
                        <path
                            d="M980.65 468.6H130.25l360.1-360.2c17-17 17-44.5 0-61.4-17-17-44.5-17-61.4 0L25.35 450.6c-33.8 33.8-33.8 88.9 0 122.8L428.95 977c8.5 8.5 19.6 12.7 30.7 12.7 11.1 0 22.2-4.2 30.7-12.7 17-17 17-44.5 0-61.4L130.25 555.4h850.4c24 0 43.4-19.5 43.4-43.4s-19.5-43.4-43.4-43.4z"
                            fill="#1296db" p-id="5088"></path>
                    </svg>
                </el-icon>

      <div class="avatar-container">
        <img :src="avatarUrl" alt="用户头像" class="avatar" />
      </div>
      
      <div class="user-details">
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
        
        <div class="info-row">
          <span class="label">昵称</span>
          <span class="value">{{ userInfo.nickname }}</span>
        </div>
        
        <div class="info-row">
          <span class="label">性别</span>
          <span class="value">
            <i v-if="userInfo.gender === '男'" class="el-icon-male" />
            <i v-else class="el-icon-female" />
            {{ userInfo.gender }}
          </span>
        </div>
        
        <div class="info-row">
          <span class="label">年龄</span>
          <span class="value">{{ userInfo.age }}</span>
        </div>
        
        <div class="info-row signature">
          <span class="label">个性签名</span>
          <span class="value">{{ userInfo.signature || '这家伙很懒，什么都没留下' }}</span>
        </div>
      </div>
      
      <div class="btn-group">
        <el-button type="primary" class="edit-info-btn" @click="() => router.push('/changeProfile')">
          <i class="el-icon-edit" /> 修改信息
        </el-button>
        <el-button type="danger" class="logout-btn" @click="logout">
          <i class="el-icon-switch-button" /> 退出登录
        </el-button>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { checkLoginApi, getImageApi, getUserInfoApi, logoutApi } from '@/request/api'
import { ref, onMounted } from 'vue'
import type { GetUserInfoResponse } from "@/dto/UserDto";
import { useUserStat } from '@/stores/userStat';
import router from '@/router';
import Wechat from './Wechat.vue';
import { useWebSocketStore } from '@/stores/webSocket';

// 用户信息数据
const userInfo = ref<GetUserInfoResponse>({
  avatar: 'https://picsum.photos/200/200',
  username: 'test_user',
  email: 'test@example.com',
  nickname: '测试用户',
  gender: 'male', // male 或 female
  age: 25,
  signature: '生活不止眼前的苟且，还有诗和远方',
  status: 0
})

const avatarUrl = ref<string>('https://picsum.photos/200/200');

const fetchUserInfo = async () => {
  // 这里应该是调用API获取用户信息
  const response = await getUserInfoApi();
  if(response.data.code == 200){
    userInfo.value = response.data.data;
    //获取头像
    const avatarResponse = await getImageApi(response.data.data.avatar);
    avatarUrl.value = URL.createObjectURL(avatarResponse.data);
  } else{
    alert(response.data.message);
  }
}

onMounted(async () => {
  const isLogin = await checkLoginApi();
  if(isLogin.data.code !== 200 || !isLogin.data.data) {
    await router.push('/login');
    return;
  }
  await fetchUserInfo()
  await useWebSocketStore().connect();
})

const logout = async() => {
  const response = await logoutApi();
  if(response.data.code == 200){
    useUserStat().set(false);
    alert("已成功退出登录");
    router.push('/login');
  } else {
    alert("退出登录失败，请稍后再试");
  }
}

const goBack = () => {
  router.push('/Wechat')// 返回上一页
}
</script>

<style scoped>
.user-info-container {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20px;
}

.user-card {
  width: 100%;
  max-width: 500px;
  background-color: #fff;
  border-radius: 12px;
  align-items: center;
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

.edit-info-btn,
.logout-btn {
  padding: 10px 20px;
  border-radius: 6px;
  font-weight: 500;
  transition: all 0.3s;
}

.edit-info-btn {
  background-color: #409eff;
  color: white;
  border: none;
}

.edit-info-btn:hover {
  background-color: #66b1ff;
}

.logout-btn {
  background-color: #f56c6c;
  color: white;
  border: none;
}

.logout-btn:hover {
  background-color: #f78989;
}

.el-icon-male {
  color: #409eff;
  margin-right: 5px;
}

.el-icon-female {
  color: #f56c6c;
  margin-right: 5px;
}

.el-icon-message {
  margin-right: 5px;
}
</style>    
    