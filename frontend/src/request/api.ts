import type { ApiResponse } from "@/dto/CommonDto";
import type { LoginRequest, LoginResponse } from "@/dto/UserDto";
import axios, { type AxiosResponse } from "axios";

export const api = axios.create()

export const loginApi = (r: LoginRequest) =>
  api.post<LoginRequest, AxiosResponse<ApiResponse<LoginResponse>>>('/api/login', r)