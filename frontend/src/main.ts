//引入createApp用于创建应用
import { createApp } from "vue";
import App from "./App.vue"
import 'element-plus/dist/index.css'
import ElementPlus from 'element-plus'
//引入路由器
import router from './router'

import axios from 'axios'

import { ErrorHandler } from './plugins/errorHandler';

import { createPinia } from "pinia";

//创建一个应用
const app = createApp(App)

const pinia = createPinia()
app.use(ElementPlus)
app.use(ErrorHandler);
app.use(pinia)
// localStorage.clear();

axios.interceptors.request.use(config => {
    const token = localStorage.getItem('token')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  })

//使用路由器
app.use(router)
//挂载整个应用到app容器中去
app.mount('#app')