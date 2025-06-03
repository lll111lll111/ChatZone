<template>
    <div class="comment">
        <div class="header">
            <template v-if="!isLoggedIn">
                <img src="../../public/微博.png" alt="头像" class="avatar">
                <router-link to="/landding" class="landding">登录</router-link>
                <router-link to="/login" class="login">注册</router-link>
            </template>
            <template v-else>
                <div class="user-info">
                    <img src="../../public/哆啦a梦.png" alt="头像" class="touxiang" @click="gotoprofile">
                    <span class="username">欢迎用户：{{ username }}</span>
                </div>
            </template>
            <el-divider class="divider"/>
        </div>
        <div class="pulish">
            <el-input 
            v-model="textarea"
            style="width: 550px"
            :rows="7"
            type="textarea"
            placeholder="Please input"
            class="input_text"/>
            <el-button text class="pulish_blog" @click="publish()">发表</el-button>
        </div>
        <div class="post-list">
            <div class="post" v-for="(post, index) in posts" :key="index">
                <div class="post-touxiang"><img src="../../public/哆啦a梦.png" alt="" width="50px" height="50px"></div>
                <div class="post-user">{{ post.username }}</div>
                <div class="post-content">{{ post.content }}</div>
                <div class="post-time">{{ getFormattedTime(post.timestamp) }}</div>
                <div class="likes">点赞数：{{ +post.likes }}</div>
                <el-dropdown class="post-more">
                    <span class="el-dropdown-link">
                        <img src="../../public/更多.svg" alt="" width="30px">
                    </span>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item @click="dianzan(post.id)">点赞</el-dropdown-item>
                            <el-dropdown-item @click="comment()">评论</el-dropdown-item>
                            <el-dropdown-item @click="Delete(post.id,post.username)">删除</el-dropdown-item>
                        </el-dropdown-menu>
                    </template>
                </el-dropdown>
            </div>
        </div>
    </div>
</template>

<script setup> 
import { ref, onMounted, onBeforeUnmount } from 'vue';
import router from '@/router';
import { ElMessage, ElMessageBox, ElNotification } from 'element-plus';

const textarea = ref('');
const isLoggedIn = ref(false);
const username = ref("");
const store = localStorage.getItem('username');
const posts = ref([]);

// 从本地存储加载评论
const loadComments = () => {
    const savedComments = localStorage.getItem('comments');
    if (savedComments) {
        posts.value = JSON.parse(savedComments);
    }
};

// 保存评论到本地存储
const saveComments = () => {
    const updatedData = JSON.stringify(posts.value);
    console.log('本地存储更新后：', updatedData);
    localStorage.setItem('comments', updatedData);
};

const gotoprofile = () => {
    router.push('/profile');
};

onMounted(() => {
    const storedUsername = localStorage.getItem('username');
    if (storedUsername) {
        isLoggedIn.value = true;
        username.value = storedUsername;
    }
    loadComments(); // 页面加载时读取本地评论
    
});

const publish = async () => {
    if (!store) {
        ElNotification({
            title: '提示',
            message: '亲，你还未登录，不能使用此功能哦！',
            duration: 2000,
        })
    } else {
        const content = textarea.value.trim();
        if (content === '') {
            ElNotification({
                title: '提示',
                message: "发表内容不可为空",
                duration: 2500,
                type: 'warning',
            })
            return;
        }

        if (content.length > 200) {
            ElNotification({
                title: '提示',
                message: "发表内容不可超过200字",
                duration: 2500,
                type: 'warning',
            })
            return;
        }

        // 构建评论数据（本地存储版），添加likes属性并初始化为0
        const newPost = {
            id: Date.now(), 
            content,
            username: store,
            timestamp: new Date().getTime(),
            likes: 0, // 新增点赞数属性，初始值为0
            UsersId:[],
        };

        posts.value.push(newPost);
        textarea.value = '';
        saveComments(); // 保存到本地存储
        ElMessage.success("发送成功");
    }
};

const getFormattedTime = (timestamp) => {
    const date = new Date(timestamp);
    const year = date.getFullYear();
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const day = String(date.getDate()).padStart(2, '0');
    const hour = String(date.getHours()).padStart(2, '0');
    const minute = String(date.getMinutes()).padStart(2, '0');
    return `${year}-${month}-${day} ${hour}:${minute}`;
};

// 组件卸载时保存评论（可选，增强数据安全性）
onBeforeUnmount(() => {
    saveComments();
});

const dianzan = (index) => {
    // 根据传入的索引找到对应的评论
    const userId = localStorage.getItem('userId');
    console.log(`${userId}`);
    if(!store){
        ElNotification({
            title: '提示',
            message: '亲，你还未登录，不能点赞哦！',
            duration: 2000,
        });
    }
    


    const postIndex = posts.value.findIndex((post) => post.id === index);
    if(postIndex===-1) return;
 
    const post = posts.value[postIndex];

    if(post.UsersId.includes(userId)){
        ElMessage.info("您已经点过赞了");
        return;
    }

        post.UsersId.push(userId);
        // 点赞数加1
        posts.value[postIndex].likes++;
        // 保存更新后的评论数据到本地存储
        saveComments();
        ElMessage.success('点赞成功');
};

const comment = () => {
    // 评论功能逻辑，此处可按需完善
    ElMessage.info('请输入评论内容');
};

const Delete = (postId,postUsername) => {
    const currentUser = localStorage.getItem("username");

    if(currentUser!==postUsername){
        ElNotification({
            title: '提示',
            message: '您没有权限删除他人的帖子',
            duration: 2000,
        });
        return;
    }

    ElMessageBox.confirm("确定要删除这一个帖子吗？",'提示',{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(()=>{
        posts.value = posts.value.filter(post => post.id !== postId);
        saveComments();
        ElMessage.success('成功删除');
    }).catch(()=>{
        ElMessage.info("已取消删除");
    });
    
};
</script>

<style scoped>
.username{
    position: absolute;
    top: 20px;
    right: 150px;
}
.comment{
    border-radius: 10px;
}
.touxiang{
    position: absolute;
    width: 60px;
    height: 60px;
    top: 5px;
    right: 25px;
    border-color: black;
    border-style: solid;
    border-radius: 50%;
    object-fit: cover;
    box-shadow: 0 0 5px ;
}
.touxiang:hover{
    box-shadow: 0 0 10px;
}
.avatar{
    border-radius: 50%;
    border-color: black;
    width: 50px;
    height: 50px;
    object-fit: cover;
}
a{
    text-decoration: none;
    color: black;
    cursor: pointer;
}
.landding{
    position: absolute;
    top: 20px;
    right: 200px;
}
.login{
    position: absolute;
    top: 20px;
    right: 140px;
}
.divider{
    position: absolute;
    top: 50px;
}
.pulish{
    position: relative;
    background-color: white;
    top: 100px;
    height: 250px;
    width: 700px;
    left: 50%;
    transform: translateX(-50%);
}
.input_text{
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
}
.pulish_blog{
    position: relative;
    top: 125px;
    left: 570px;
}
.post-touxiang{
    position: absolute;
    left:0px;
    bottom: 29px;
}
.post-list {
    position: relative;
    top: 100px;
}
.post {
    position: relative;
    margin-bottom: 40px;
    padding-left: 60px;
    left: 50%;
    border-bottom: solid  0.1px;
    width: 600px;
    transform: translateX(-50%);
}
.post-user {
    font-weight: bold;
    margin-bottom: 5px;
}
.post-content {
    margin-bottom: 5px;
}
.post-time {
    color: #666;
    font-size: 12px;
}
.likes {
    color: #666;
    font-size: 12px;
}
.post-more{
    border: none;
    position: absolute;
    cursor: pointer;
    z-index: 10;
    margin-top: -22px;
    margin-left: 558px;
    width: 30px;
}
.post-more img {
    width: 100%;
    height: 100%;
    object-fit: contain;
}
</style>