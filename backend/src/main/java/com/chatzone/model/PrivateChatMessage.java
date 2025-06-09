package com.chatzone.model;

import java.time.LocalDateTime;
import java.util.Date;

public record PrivateChatMessage(String senderUsername, String receiverUsername, String content) {
}
