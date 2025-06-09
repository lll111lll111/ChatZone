package com.chatzone.handler;

import com.chatzone.common.MessageType;
import com.chatzone.common.SystemMessageType;
import com.chatzone.model.PrivateChatMessage;
import com.chatzone.model.ServerMessage;
import com.chatzone.model.SystemMessage;
import com.chatzone.model.WebsocketMessage;
import com.chatzone.service.MessageService;
import com.chatzone.service.UserService;
import com.chatzone.session.WebSocketSessionManager;
import com.chatzone.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Date;

@Component
public class MessageHandler extends TextWebSocketHandler {
    private final WebSocketSessionManager sessionManager;
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    public MessageHandler(WebSocketSessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    //TYPE类型错误异常处理
    public void sendErrorMessage(WebSocketSession webSocketSession, String errorMessage) {
        try {
            WebsocketMessage<String> websocketMessage = new WebsocketMessage<>(MessageType.ERROR, errorMessage,new Date());
            webSocketSession.sendMessage(new TextMessage(JsonUtil.messgeToJsonString(websocketMessage)));
        } catch (IOException e) {
            System.out.println("发送错误消息失败," + e);
        }
    }

    // 连接建立时调用
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        Long loginId = (Long) session.getAttributes().get("user");
        sessionManager.getSessionMap().put(loginId, session);
        System.out.println("新连接：" + session.getId());
        //改写登陆状态
        userService.statusOn(loginId);
        //成功连接消息
        session.sendMessage(
                new TextMessage(JsonUtil.messgeToJsonString(
                        new WebsocketMessage<SystemMessage>(MessageType.SYSTEM,
                                new SystemMessage<String>(SystemMessageType.CONNECTION_STATUS_UPDATE,"连接成功"),new Date()))));
        //广播给所有会话用户好友状态更新
//        System.out.println("有用户上线");
//        for (WebSocketSession s : sessionManager.getSessionMap().values()) {
//            if (s.isOpen()) {
////                System.out.println("发个消息");
//                session.sendMessage(
//                        new TextMessage(JsonUtil.messgeToJsonString(
//                                new WebsocketMessage<SystemMessage>(MessageType.SYSTEM,
//                                        new SystemMessage<String>(SystemMessageType.FRIEND_STATUS_UPDATE,"好友状态更新"),new Date()))));
//                System.out.println("发送上线消息:"+new TextMessage(JsonUtil.messgeToJsonString(
//                        new WebsocketMessage<SystemMessage>(MessageType.SYSTEM,
//                                new SystemMessage<String>(SystemMessageType.FRIEND_STATUS_UPDATE,"好友状态更新"),new Date()))).getPayload());
//            }
//        }
    }

    // 接收消息时调用
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        //反序列化
        WebsocketMessage<?> websocketMessage = new ObjectMapper().readValue(payload, WebsocketMessage.class);
        System.out.println("收到消息：" + payload);
        switch (websocketMessage.type()) {
            case MessageType.PRIVATE_CHAT:
                handlePrivateChatMessage(session, (WebsocketMessage<PrivateChatMessage>) websocketMessage);
                break;
            case MessageType.SYSTEM:
                SystemMessage systemMessage = new ObjectMapper().convertValue(websocketMessage.data(), SystemMessage.class);
                handleSystemMessage(session,(WebsocketMessage<SystemMessage<String>>) websocketMessage);
            default:
                sendErrorMessage(session, "不支持此消息类型");
                break;
        }

    }

    //处理私聊消息
    protected void handlePrivateChatMessage(WebSocketSession session, WebsocketMessage<PrivateChatMessage> websocketMessage) throws IOException {
        //持久化
        messageService.handlePrivateChatMessage(websocketMessage);
        //发送ws消息给接收方
        PrivateChatMessage privateChatMessage = new ObjectMapper().convertValue(websocketMessage.data(), PrivateChatMessage.class);
        long receiverId = userService.getIdByUserName(privateChatMessage.receiverUsername());
        WebSocketSession receiverSession = sessionManager.getSessionMap().get(receiverId);
        if (receiverSession != null) {
            TextMessage textMessage = new TextMessage(JsonUtil.messgeToJsonString(websocketMessage));
            receiverSession.sendMessage(textMessage);
            System.out.println("转发消息：" + textMessage.getPayload());
        }

    }

    //系统消息处理
    protected void handleSystemMessage(WebSocketSession session, WebsocketMessage<SystemMessage<String>> websocketMessage) throws IOException {
    }

    // 连接关闭时调用
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Long loginId = (Long) session.getAttributes().get("user");
        userService.statusOff(loginId);
        sessionManager.getSessionMap().remove(session.getAttributes().get("user"));
        //广播给所有会话用户好友状态更新
//        for (WebSocketSession s : sessionManager.getSessionMap().values()) {
//            if (s.isOpen() && s!=session) {
////                System.out.println("发个消息");
//                session.sendMessage(
//                        new TextMessage(JsonUtil.messgeToJsonString(
//                                new WebsocketMessage<SystemMessage>(MessageType.SYSTEM,
//                                        new SystemMessage<String>(SystemMessageType.FRIEND_STATUS_UPDATE,"好友状态更新"),new Date()))));
//                System.out.println("发送下线消息:"+new TextMessage(JsonUtil.messgeToJsonString(
//                        new WebsocketMessage<SystemMessage>(MessageType.SYSTEM,
//                                new SystemMessage<String>(SystemMessageType.FRIEND_STATUS_UPDATE,"好友状态更新"),new Date()))).getPayload());
//            }
//        }
        System.out.println("连接关闭：" + session.getId());
    }
}

