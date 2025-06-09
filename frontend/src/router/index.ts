//创建一个路由器，并暴露出去
//at.alicdn.com/t/c/font 4909217 xzy1d2bs71f.js
//第一步：引入createRouter
import {createRouter,createWebHistory} from 'vue-router'
//引入一个一个可能要呈现的组件
import signup from "@/pages/signup.vue";
import login from '../pages/login.vue'
import profile from '@/pages/profile.vue'
import index from '@/pages/index.vue'
import Wechat from '@/pages/Wechat.vue'
import changeProfile from '@/pages/changeProfile.vue'
import OtherProfile from '@/pages/Wechat/otherProfile.vue';
import PrivateChat from '@/pages/Wechat/privateChat.vue';

//第二步：创建路由器
const router = createRouter({
    history:createWebHistory(),
    routes:[ //一个一个的路由规则
        {
            path:'/',
            component:index
        },
        {
            path:'/signup',
            component:signup
        },
        {
            path:'/login',
            component:login
        },
        {
            path:'/Wechat',
            component:Wechat,
            children:[
                {
                    path: 'otherProfile/:username',
                    name: 'OtherProfile',
                    component: OtherProfile,
                    props: true,
                },{
                    path: 'privateChat/:username',
                    name: 'PrivateChat',
                    component: PrivateChat,
                    props: true,
                },
            ]
        },
        {
            path:'/profile',
            component:profile
        },
        {
            path:'/changeProfile',
            component:changeProfile
        },

    ]
})

//暴露出去router
export default router



