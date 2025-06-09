package com.chatzone.model;

import com.chatzone.common.SystemMessageType;

import java.util.Date;

public record SystemMessage<T>(SystemMessageType type, String message) {

}
