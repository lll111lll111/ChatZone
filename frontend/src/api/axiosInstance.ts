// src/api/axiosInstance.js
import axios from 'axios';

// 创建axios实例
const api = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || '/api', // 基础API地址
  timeout: 5000, // 请求超时时间
  headers: {
    'Content-Type': 'application/json',
  },
});


// 请求拦截器
api.interceptors.request.use(
  (config) => {
    return config;
  },
  (error) => {
    // 对请求错误做些什么
    console.error('请求错误:', error);
    return Promise.reject(error);
  }
);

// 响应拦截器
api.interceptors.response.use(
  (response) => {
    // 对响应数据做些什么
    const res = response.data;
    if (res.code !== 200) { // 根据实际接口规范调整
      console.error('响应错误:', res.message);
      return Promise.reject(new Error(res.message || 'Error'));
    }
    return res;
  },
  (error) => {
    // 对响应错误做些什么
    console.error('响应错误:', error.message);
    return Promise.reject(error);
  }
);

export default api;