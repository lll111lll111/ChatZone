// WebSocketConfig.java
package com.chatzone.config;

import com.chatzone.handler.MessageHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket // 启用 WebSocket 支持
public class WebSocketConfig implements WebSocketConfigurer {

    private final MessageHandler messageHandler;

    public WebSocketConfig(MessageHandler handler) {
        this.messageHandler = handler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(messageHandler, "/ws") // 注册端点 "/ws"
                .setAllowedOrigins("*") // 允许所有跨域（生产环境需指定具体域名）
                .addInterceptors(new WebSocketHandshakeInterceptor()) // 添加握手拦截器
        ;
    }

}



