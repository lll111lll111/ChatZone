//引入createApp用于创建应用
import { createApp } from "vue";
import App from "./App.vue"
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'
//引入路由器
import router from './router'

import axios from 'axios'
import { createPinia } from "pinia";

import { useUserStat } from "./stores/userStat.ts";
import { checkLoginApi } from "./request/api";

//创建一个应用
const app = createApp(App)
const pinia = createPinia()
app.use(ElementPlus)

// localStorage.clear();
//使用路由器
app.use(router)
app.use(pinia)
//挂载整个应用到app容器中去
app.mount('#app')

const userStat = useUserStat()
checkLoginApi().then((res) => {
  userStat.set(res.data.code == 200)
}).catch((err) => {
  console.log(err)
}
)