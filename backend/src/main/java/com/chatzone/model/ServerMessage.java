package com.chatzone.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ServerMessage {
    // 使用枚举替代字符串常量
    public enum Type {
        CHAT, CONNECT, FRIEND_UPDATE, FRIEND_STATUS_CHANGE
    }

    // getter 和 setter
    private Type type; // 类型改为枚举
    private String message;

    public ServerMessage(Type type, String message) {
        this.type = type;
        this.message = message;
    }
}
