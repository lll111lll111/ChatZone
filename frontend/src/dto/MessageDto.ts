export interface WebSocketMessage<T> {
  type: string; // 消息类型
  data: T; // 消息数据
  createTime: Date
}

export interface PrivateChatMessage{
  senderUsername: string; // 发送者的用户名
  receiverUsername: string; // 接收者的用户名
  content: string; // 消息内容
}

export interface SystemMessage{
  type: string; // 系统消息类型
  message: string; // 系统消息内容
}

export interface PrivateMessage{
  sender_username: string; // 发送者的用户名
  receiver_username: string; // 接收者的用户名
  content: string; // 消息内容
  create_time: Date; // 消息发送时间
}