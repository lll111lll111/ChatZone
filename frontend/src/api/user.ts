// src/api/user.js
import type { SignupRequest } from '@/dto/userDto';
import api from './axiosInstance';
import axios, { type AxiosResponse } from 'axios';
import type { ApiResponse } from '@/dto/apiDto';


// // 用户登录
// export const login = () => {
//   return service.post('/user/login');
// };

// // 获取用户信息
// export const getUserInfo = () => {
//   return service.get('/user/info');
// };

// 用户注册
export const signupApi = (r : SignupRequest) => 
  api.post<SignupRequest,AxiosResponse<ApiResponse<null>>>('/api/user/signup', r,)