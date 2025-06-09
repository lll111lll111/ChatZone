// stores/websocket.js
import { defineStore } from 'pinia';
import { ref, computed, watch, onBeforeUnmount } from 'vue';


// 导入持久化插件
import 'pinia-plugin-persistedstate'

export const useWebSocketStore = defineStore('websocket', () => {
  // 状态
  const socket = ref<WebSocket | null>(null);
  const isConnected = ref(false);
  const connectionAttempts = ref(0);
  const maxReconnectAttempts = ref(5);
  const reconnectInterval = ref(3000); // 3秒
  const reconnectTimer = ref<number | null>(null);
  
  
  // 计算属性：获取未读消息数量
  // const unreadCount = computed(() => {
  //   return messages.value.filter(msg => !msg.read).length;
  // });
  
  // 连接WebSocket
  const connect = () => {
    if (socket.value) return;
    
    try {
      // 使用原生WebSocket
      socket.value = new WebSocket('ws://localhost:8080/ws');
      
      // 连接成功
      socket.value.onopen = () => {
        isConnected.value = true;
        connectionAttempts.value = 0;
        console.log('WebSocket连接成功');
        
        // 发送初始消息或认证信息
        sendMessage({ type: 'SYSTEM' });
      };
      
      // 接收消息
      // socket.value.onmessage = (event) => {
      //   try {
      //     // const message = JSON.parse(event.data);
      //     // return messages;
      //     console.log('接收到WebSocket消息:', event.data);
      //     return event.data;
      //   } catch (error) {
      //     console.error('解析WebSocket消息失败:', error);
      //   }
      // };
      
      // 连接关闭
      socket.value.onclose = (event) => {
        isConnected.value = false;
        console.log('WebSocket连接已关闭:', event.code, event.reason);
        
        // 自动重连（非主动关闭）
        if (event.code !== 1000) { // 1000表示正常关闭
          scheduleReconnect();
        }
      };
      
      // 连接错误
      socket.value.onerror = (error) => {
        isConnected.value = false;
        console.error('WebSocket连接错误:', error);
        scheduleReconnect();
      };
      
    } catch (error) {
      console.error('创建WebSocket连接失败:', error);
      scheduleReconnect();
    }
  };
  
  // 安排重连
  const scheduleReconnect = () => {
    if (connectionAttempts.value >= maxReconnectAttempts.value) {
      console.log('达到最大重连次数，停止尝试');
      return;
    }
    
    connectionAttempts.value++;
    console.log(`尝试重连 ${connectionAttempts.value}/${maxReconnectAttempts.value}`);
    
    reconnectTimer.value = setTimeout(() => {
      connect();
    }, reconnectInterval.value);
  };
  
  // 发送消息
  const sendMessage = (message: any) => {
    if (!isConnected.value || !socket.value) {
      console.error('WebSocket未连接，无法发送消息');
      return false;
    }
    
    try {
      const messageJson = JSON.stringify(message);
      socket.value.send(messageJson);
      return true;
    } catch (error) {
      console.error('发送消息失败:', error);
      return false;
    }
  };
  
  
  // 标记消息为已读
  // const markMessageAsRead = (messageId) => {
  //   const index = messages.value.findIndex(msg => msg.id === messageId);
  //   if (index !== -1) {
  //     messages.value[index].read = true;
  //   }
  // };
  
  // 断开连接
  const disconnect = () => {
    if (socket.value) {
      if (reconnectTimer.value !== null) {
        clearTimeout(reconnectTimer.value);
      }
      socket.value.close(1000); // 正常关闭
      socket.value = null;
    }
  };
  
  // 监听用户登录状态变化
  // watch(() => userStore.token, (newToken) => {
  //   if (newToken) {
  //     // 用户已登录，连接WebSocket
  //     connect();
  //   } else {
  //     // 用户已登出，断开WebSocket
  //     disconnect();
  //   }
  // });
  
  // 组件卸载时清理
  onBeforeUnmount(() => {
    disconnect();
  });
  
  return {
    socket,
    isConnected,
    connect,
    disconnect,
    sendMessage,
  };
}, {
  // 启用持久化存储（可选）
  persist: true
});