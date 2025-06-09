export interface LoginRequest {
  username: string
  password: string
}

export interface LoginResponse {
  userId: number
  username: string
  name: string
  avatar: string
  signature: string
  email: string
}

export interface SignupRequest {
  username: string
  password: string
  confirmPassword: string
  email: string
}

export interface GetUserInfoResponse{
  username: string
  nickname: string
  avatar: string
  signature: string
  email: string
  age: number
  gender: string
  status: number
}

export interface UpdateUserInfoRequest {
  nickname: string
  avatar: Blob
  signature: string
  age: number
  gender: string
}