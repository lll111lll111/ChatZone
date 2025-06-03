//创建一个路由器，并暴露出去
//at.alicdn.com/t/c/font 4909217 xzy1d2bs71f.js
//第一步：引入createRouter
import {createRouter,createWebHistory} from 'vue-router'
//引入一个一个可能要呈现的组件
import landding from "@/pages/landding.vue";
import login from '../pages/login.vue'
import Comment from '@/pages/comment.vue'
import profile from '@/pages/profile.vue'
import Interface from '@/pages/Interface.vue'
import Wechat from '@/pages/Wechat.vue'

//第二步：创建路由器
const router = createRouter({
    history:createWebHistory(),
    routes:[ //一个一个的路由规则
        {
            path:'/',
            component:Interface
        },
        {
            path:'/landding',
            component:landding
        },
        {
            path:'/login',
            component:login
        },
        {
            path:'/Wechat',
            component:Wechat
        },
        {
            path:'/profile',
            component:profile
        },
        {
            path:'/comment',
            component:Comment
        }
    ]
})

//暴露出去router
export default router



