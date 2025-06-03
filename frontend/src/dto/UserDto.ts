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