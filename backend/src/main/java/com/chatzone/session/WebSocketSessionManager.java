package com.chatzone.session;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketSessionManager {
    private static final Map<Long, WebSocketSession> sessionMap = new ConcurrentHashMap<>();

    public Map<Long, WebSocketSession> getSessionMap() {
        return this.sessionMap;
    }
}
