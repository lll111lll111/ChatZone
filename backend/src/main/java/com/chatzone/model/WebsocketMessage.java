package com.chatzone.model;

import com.chatzone.common.MessageType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record WebsocketMessage<T>(MessageType type, T data,
                                  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", // 注意转义符 'T' 和 'Z'
                                          timezone = "UTC"                         // 指定 UTC 时区
                                  ) Date createTime) {
}
