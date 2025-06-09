export interface GetFriendResponse {
  username: string;
  nickname: string;
  avatar: string;
  status:number
}

export interface GetPrivateChatListResponse {
  avatar: string; // 好友的头像
  nickname: string; // 好友的昵称
  content: string; // 最近一条消息内容
  username: string; // 好友的用户名
}