package com.chatzone.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class PrivateMessage {
    private long sender_id;
    private long receiver_id;
    private String sender_username;
    private String receiver_username;
    private String content;
    private Date create_time;
}
