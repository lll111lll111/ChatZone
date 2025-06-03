<template>
    <div class="container">
        <div class="profile">
            
            <div class="header">
                <h2>账户信息</h2>
                <el-icon @click="goBack" class="back-icon">
                    <svg t="1748609671667" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5087" width="30" height="20"><path d="M980.65 468.6H130.25l360.1-360.2c17-17 17-44.5 0-61.4-17-17-44.5-17-61.4 0L25.35 450.6c-33.8 33.8-33.8 88.9 0 122.8L428.95 977c8.5 8.5 19.6 12.7 30.7 12.7 11.1 0 22.2-4.2 30.7-12.7 17-17 17-44.5 0-61.4L130.25 555.4h850.4c24 0 43.4-19.5 43.4-43.4s-19.5-43.4-43.4-43.4z" fill="#1296db" p-id="5088"></path></svg>
                </el-icon>
            </div>
           
            
            <hr class="divider">
            
            <div class="image">
                <label for="image-upload">
                    <img :src="avatarUrl" class="image-1" alt="">
                </label>
                <input type="file" id="image-upload" @change="handleImageUpload" style="display: none;">
                <input v-model="avatarUrl" type="text" placeholder="请输入图片URL或上传图片" style="margin-top:10px;width:80%;">
            </div>
            
            <section class="bottom_information">
               
                <div class="input-group">
                    <span class="prefix">用户名：</span>
                    <input v-model="username" type="text" placeholder="请输入用户名">
                </div>
                
                <div class="input-group">
                    <span class="prefix">密码：</span>
                    <input v-model="password" type="password" placeholder="请输入密码">
                </div>
               
                <div class="input-group">
                    <span class="prefix">电话：</span>
                    <input v-model="phone" type="text" placeholder="请输入电话">
                </div>
               
                <div class="input-group">
                    <span class="prefix">邮箱：</span>
                    <input v-model="email" type="email" placeholder="请输入邮箱">
                </div>
            </section>

            <el-button text class="tuichu_blog" @click="tuichu()">退出登录</el-button>
            <el-button text class="editor" @click="editor()">保存信息</el-button>
            
        </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import router from '@/router';
import axios from 'axios';
import { onMounted } from 'vue';

const username = ref('');
const password = ref('');
const phone = ref('');
const email = ref('');
const avatarUrl = ref('/淘公仔.svg');
const storedUsername = localStorage.getItem('username');
const id = ref("");

const handleImageUpload = (event) => {
    const file = event.target.files[0];
    if (file) {
        // 本地预览
        avatarUrl.value = URL.createObjectURL(file);
        // 提示用户
        alert('本地预览成功！如需跨设备显示头像，请将图片上传到图床后粘贴URL。');
    }
};

const get_information = async() => {
    if (storedUsername) {
        username.value = storedUsername;
        try {
            const response = await axios.get(`http://localhost:3000/users?username=${username.value}`);
            if (response.data.length > 0) {
                const userData = response.data[0];
                username.value = userData.username;
                password.value = userData.password;
                phone.value = userData.phone;
                email.value = userData.email;
                id.value =  +userData.id;
                avatarUrl.value = userData.avatar && userData.avatar !== 'default_avatar.png' ? userData.avatar : '/淘公仔.svg';
            } else {
                alert("未找到该用户名");
            }
        } catch (error) {
            alert("获取用户信息失败" + error.message);
        }
    } else {
        alert("未找到存储的用户名");
    }
};

    onMounted(() => {
        get_information();
    });


    const editor = async() => {
        if (!id.value || isNaN(id.value)) {
            alert("用户ID无效，无法保存！");
            return;
        }
        // 如果avatarUrl是blob:开头，提示用户用图床URL
        if (avatarUrl.value.startsWith('blob:')) {
            alert('当前头像仅本地可见，如需跨设备显示，请将图片上传到图床后粘贴URL。');
            return;
        }
        let avatarToSave = avatarUrl.value && avatarUrl.value !== '' ? avatarUrl.value : '/淘公仔.svg';
        console.log('保存用户信息:', id.value, username.value, avatarToSave);
        try{    
            const response = await axios({
                method: "PUT",
                url:`http://localhost:3000/users/${id.value}`,
                data:{
                    username:username.value,
                    password:password.value,
                    phone:phone.value,
                    email:email.value,
                    avatar:avatarToSave
                }
            });
            localStorage.setItem('username',username.value);
            alert("信息保存成功");
        }catch(error){
            alert("信息保存失败: " + (error.response?.data || error.message));
        }     
    }

    const tuichu = () => {
        // 清除 localStorage 中的 username
        localStorage.removeItem('username');
        // 跳转到主界面，假设主界面的路由名称是 'home'
        router.push('/');
    };

    const goBack = () => {
        router.push('/Wechat');
    }
</script>

<style scoped>
/* 整体容器样式 */
.container {
    font-family: 'Inter', sans-serif;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    margin: 0;
}

/* 个人信息卡片样式 */
.profile {
    background-color: #fff;
    width: 500px;
    height: 700px;
    border-radius: 12px;
    box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
    position: relative;
    top: auto;
    overflow: hidden;
}

/* 头部样式 */
.header {
    text-align: center;
    padding: 20px 0;
    background-color: #fafafa;
    border-bottom: 1px solid #eaeaea;
}

.header h2 {
    color: #333;
    font-size: 24px;
    margin: 0;
}

/* 分割线样式 */
.divider {
    border: none;
    height: 1px;
    background-color: #eaeaea;
    box-shadow: 0 0 1px rgba(0, 0, 0, 0.2);
    margin: 0;
}

/* 头像样式 */
.image {
    position: relative;
    text-align: center;
    padding: 30px 0;
}

.image-1 {
    width: 120px;
    height: 120px;
    border: 4px solid #fff;
    border-radius: 50%;
    object-fit: cover;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    position: static;
    transform: none;
    transition: transform 0.3s ease;
    cursor: pointer;
}

.image-1:hover {
    transform: scale(1.05);
}

/* 底部信息样式 */
.bottom_information {
    position: absolute;
    left: 15px;
    padding: 20px;
    display: flex;
    flex-direction: column;
    gap: 20px;
}

.input-group {
    display: flex;
    align-items: center;
}

.prefix {
    color: #666;
    font-size: 16px;
    margin-right: 10px;
}

.bottom_information input {
    color: #666;
    font-size: 16px;
    margin: 0;
    padding: 10px 0;
    border: none;
    border-bottom: 1px solid #f0f0f0;
    background-color: #fff; /* 设置背景色为白色 */
    /* transition: background-color 0.3s ease; */
    flex: 1;
}

.bottom_information input:last-child {
    border-bottom: none;
}

.bottom_information input:hover {
    background-color: #fafafa;
}

/* 退出登录按键 */
.tuichu_blog{
    position: absolute;
    bottom: 20px;
    right: 20px;
}

.editor{
    position: absolute;
    bottom: 20px;
    right: 100px;
}

.back-icon{
    position: absolute;
    left: 15px;
    top: 30px;
}
</style>    