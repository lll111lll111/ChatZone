package com.chatzone.dto;

/**
 * @param code    后端返回给前端的代码
 * @param data    后端返回给前端的数据
 * @param message 后端返回给前端的描述信息
 */
public record ApiResponse<T>(int code, T data, String message) {

}