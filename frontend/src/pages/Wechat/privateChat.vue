<template>
  <div class="chat-container">
    <!-- 聊天头部 -->
    <div class="chat-header">
      <el-avatar :size="40" :src="friendAvatarUrl" />
      <div class="header-info">
        <h3>{{ friendInfo.nickname }}</h3>
        <p>{{ friendInfo.status ? '在线' : '离线' }}</p>
      </div>
    </div>
    
    <!-- 聊天消息区域 -->
    <div class="chat-messages" ref="messagesRef">
      <!-- 消息列表 -->
      <div 
        v-for="(message, index) in messages" 
        :key="index"
        class="message-item"
        :class="{ 'self-message': message.data.senderUsername === userInfo.username }"
      >
        <el-avatar 
          :size="36" 
          :src="message.data.senderUsername === friendInfo.username ? friendAvatarUrl : userAvatarUrl" 
        />
        <div class="message-content">
          <div class="message-bubble">
            <p>{{ message.data.content }}</p>
          </div>
          <span class="message-time">{{ formatTime(message.createTime) }}</span>
        </div>
      </div>
    </div>
    
    <!-- 固定在路由视图底部的输入区域 -->
    <div class="fixed-chat-input">
      <el-input
        v-model="messageInput"
        type="textarea"
        :rows="4"
        resize="none"
        maxlength="160"
        placeholder="输入消息..."
        @keyup.enter.native="sendMessage"
      ></el-input>
      <el-button 
        type="primary" 
        @click="sendMessage"
        :disabled="!messageInput.trim()"
      >
        发送
      </el-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import type { PrivateChatMessage, SystemMessage, WebSocketMessage } from '@/dto/MessageDto';
import type { GetUserInfoResponse } from '@/dto/UserDto';
import { getImageApi, getPrivateChatHistoryApi, getUserInfoApi } from '@/request/api';
import { useWebSocketStore } from '@/stores/webSocket';
import { get } from 'lodash';
import { ref, onMounted, watch } from 'vue';
// 导出websocket
const socket = useWebSocketStore();
// 消息类型定义

const props = defineProps({
  username: String
});

//拉取好友信息
const friendAvatarUrl = ref<string>('https://picsum.photos/200/200');
const friendInfo = ref<GetUserInfoResponse>({
  avatar: 'https://picsum.photos/200/200',
  username: 'test_user',
  email: 'test@example.com',
  nickname: '测试用户',
  gender: '男', // male 或 female
  age: 25,
  signature: '生活不止眼前的苟且，还有诗和远方',
  status : 0
});

const fetchFriendInfo = async () => {
  if (props.username) {
    // 这里应该是调用API获取用户信息
    const response = await getUserInfoApi(props.username);
    if (response.data.code == 200) {
      friendInfo.value = response.data.data;
      // 获取头像
      const avatarResponse = await getImageApi(response.data.data.avatar);
      friendAvatarUrl.value = URL.createObjectURL(avatarResponse.data);
    } else {
      alert(response.data.message);
    }
  }
};

//拉取用户信息
const userAvatarUrl = ref<string>('https://picsum.photos/200/200');
const userInfo = ref<GetUserInfoResponse>({
  avatar: 'https://picsum.photos/200/200',
  username: 'test_user',
  email: 'test@example.com',
  nickname: '测试用户',
  gender: '男', // male 或 female
  age: 25,
  signature: '生活不止眼前的苟且，还有诗和远方',
  status : 0
});

const fetchUserInfo = async () => {
  if (props.username) {
    // 这里应该是调用API获取用户信息
    const response = await getUserInfoApi();
    if (response.data.code == 200) {
      userInfo.value = response.data.data;
      // 获取头像
      const avatarResponse = await getImageApi(response.data.data.avatar);
      userAvatarUrl.value = URL.createObjectURL(avatarResponse.data);
    } else {
      alert(response.data.message);
    }
  }
};

const fetchHistoryMessages = async() => {
  if(props.username == null) return ;
  // 获取历史消息
  const response = await getPrivateChatHistoryApi(props.username);
  if(response.data.code == 200) {
    for(let i = 0; i < response.data.data.length; i++){
      const message = response.data.data[i];
       // 确保消息格式正确
      console.log('获取到的历史消息:', message.sender_username);
        addMessage({
          type: 'PRIVATE_CHAT',
          data: {
            senderUsername: message.sender_username,
            receiverUsername: message.receiver_username,
            content: message.content,
          },
          createTime: message.create_time,
        } as WebSocketMessage<PrivateChatMessage>);
      
    }
    
    return;
  }else {
    console.log('获取历史消息失败:', response.data.message);
  }
  // historyMessages.forEach(message => addMessage(message));
}
// 响应式数据
const messages = ref<WebSocketMessage<PrivateChatMessage>[]>([]);
const messageInput = ref('');
const isOnline = ref(true);
const messagesRef = ref<HTMLElement | null>(null);

onMounted(async () => {
  await fetchFriendInfo();
  await fetchUserInfo();
  await fetchHistoryMessages();
});

// 添加消息方法
const addMessage = (message: WebSocketMessage<PrivateChatMessage>) => {
  messages.value.push(message as WebSocketMessage<PrivateChatMessage>);
  scrollToBottom();
};

// 发送消息方法
const sendMessage = () => {
  const content = messageInput.value.trim();
  if (!content) return;
  
  const newMessage: WebSocketMessage<PrivateChatMessage> = {
    type: 'PRIVATE_CHAT',
    data: {
      senderUsername: userInfo.value.username,
      receiverUsername: friendInfo.value.username,
      content,
    },
    createTime: new Date(),
  };
  
  // 添加自己发送的消息
  addMessage(newMessage);
  
  // 清空输入框
  messageInput.value = '';

  //检查链接
  if(socket.socket == null || socket.socket.readyState !== WebSocket.OPEN) {
    console.error('连接失败，请重新尝试');
    //尝试重连
    socket.connect();
    console.log('尝试重新连接WebSocket');
    return;
  }
  
  //发给websocket服务器
  socket.sendMessage(<WebSocketMessage<PrivateChatMessage>>newMessage);

  console.log('发送消息:', newMessage);
};

//处理连接后信息接受 -- 只处理PRIVATE_CHAT消息
if (socket.socket) {
    socket.socket.onmessage = (event: MessageEvent) => {
        const message = <WebSocketMessage<Object>>JSON.parse(event.data);
        // 根据消息类型处理不同的事件
        switch (message.type) {                 
            case 'PRIVATE_CHAT':
                //私聊消息
                const data = message.data as PrivateChatMessage;
                console.log('接收到私聊消息:', data);
                addMessage(message as WebSocketMessage<PrivateChatMessage>);
                break;
            case 'SYSTEM':
            //系统消息
            const sdata = message.data as SystemMessage;
            switch(sdata.type){
                case 'FRIEND_STATUS_UPDATE':
                  console.log('好友状态更新');
                    fetchFriendInfo();
                    break;
            }
        break;
        }
    };
}

// 格式化时间
const formatTime = (date: Date | string) => {
  let dateObj: Date;
  if (date instanceof Date) {
    dateObj = date;
  } else {
    dateObj = new Date(date);
  }
  const yyyy = dateObj.getFullYear();
  const mm = String(dateObj.getMonth() + 1).padStart(2, '0');
  const dd = String(dateObj.getDate()).padStart(2, '0');
  const hh = String(dateObj.getHours()).padStart(2, '0');
  const min = String(dateObj.getMinutes()).padStart(2, '0');
  return `${yyyy}-${mm}-${dd} ${hh}:${min}`;
};

// 滚动到底部
const scrollToBottom = () => {
  if (messagesRef.value) {
    messagesRef.value.scrollTop = messagesRef.value.scrollHeight;
  }
};

// 监听消息变化，自动滚动到底部
watch(messages, () => {
  scrollToBottom();
});


</script>

<style scoped>
.chat-container {
  display: flex;
  flex-direction: column;
  min-height: 100%;
}

.chat-header {
  display: flex;
  align-items: center;
  gap: 10px;
  padding: 10px 16px;
  border-bottom: 1px solid #ebeef5;
  background-color: #f5f7fa;
}

.header-info h3 {
  margin: 0;
  font-size: 16px;
  font-weight: 500;
}

.header-info p {
  margin: 0;
  font-size: 12px;
  color: #909399;
}

.chat-messages {
  flex: 1; /* 消息区域占据剩余空间 */
  overflow-y: auto;
  padding: 16px;
  display: flex;
  flex-direction: column;
  gap: 16px;
}

.message-item {
  display: flex;
  align-items: flex-start;
  gap: 10px;
}

.self-message {
  flex-direction: row-reverse;
}

.message-content {
  max-width: 70%;
}

.message-bubble {
  padding: 8px 12px;
  border-radius: 4px;
  background-color: #e4e6eb;
  display: inline-block;
}

.self-message .message-bubble {
  background-color: #409eff;
  color: white;
}

.message-time {
  display: block;
  font-size: 12px;
  color: #909399;
  text-align: center;
  margin-top: 4px;
}

/* 固定在路由视图底部的输入区域 */
.fixed-chat-input {
  padding: 16px;
  border-top: 1px solid #ebeef5;
  background-color: white;
  box-sizing: border-box;
  height: 20%;
  flex-shrink: 0; /* 防止被压缩 */
}

.fixed-chat-input el-input {
  flex: 1;
  max-height: 64px; /* 限制输入框最大高度 */
}
</style>