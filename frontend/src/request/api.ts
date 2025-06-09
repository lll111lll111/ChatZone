import type { ApiResponse } from "@/dto/CommonDto";
import type { GetFriendResponse, GetPrivateChatListResponse } from "@/dto/FriendDto";
import type { GetImageRequest, ImageResource } from "@/dto/ImageDto";
import type { PrivateChatMessage, PrivateMessage } from "@/dto/MessageDto";
import type { GetUserInfoResponse, LoginRequest, LoginResponse, SignupRequest, UpdateUserInfoRequest } from "@/dto/UserDto";
import axios, { type AxiosResponse } from "axios";

export const api = axios.create()

export const loginApi = (r: LoginRequest) =>
  api.post<LoginRequest, AxiosResponse<ApiResponse<LoginResponse>>>('/api/login', r)

export const signupApi = (r: SignupRequest) =>
  api.post<SignupRequest, AxiosResponse<ApiResponse<null>>>('/api/signup', r)

export const getUserInfoApi = (r?:string) =>
  api.post<string | null, AxiosResponse<ApiResponse<GetUserInfoResponse>>>('/api/getUserInfo',r)

export const checkLoginApi = () =>
  api.post<null, AxiosResponse<ApiResponse<boolean>>>('/api/checkLogin')

export const getImageApi = (filename: string): Promise<AxiosResponse<Blob>> =>
  api.get('/api' + filename, {
    responseType: 'blob'
  });

export const logoutApi = () =>
  api.post<void, AxiosResponse<ApiResponse<null>>>('/api/logout')

export const updateUserInfoApi = (formData: FormData, config?: any) =>
  api.post<FormData, AxiosResponse<ApiResponse<null>>>('/api/updateUserInfo', formData, config);

export const getFriendListApi = () =>
  api.post<void, AxiosResponse<ApiResponse<GetFriendResponse[]>>>('/api/getFriendList')

export const addFriendApi = (r?:string) =>
  api.post<string, AxiosResponse<ApiResponse<null>>>('/api/addFriend',r)

export const deleteFriendApi = (r?:string) =>
  api.post<string, AxiosResponse<ApiResponse<null>>>('/api/deleteFriend',r)

export const getPrivateChatHistoryApi = (r:string)=>
  api.post<string, AxiosResponse<ApiResponse<PrivateMessage[]>>>('/api/getPrivateChatHistory', r)

export const getPrivateChatListApi = () =>
  api.post<void, AxiosResponse<ApiResponse<GetPrivateChatListResponse[]>>>('/api/getPrivateChatList')