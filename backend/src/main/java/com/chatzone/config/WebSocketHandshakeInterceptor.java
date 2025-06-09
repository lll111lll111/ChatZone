package com.chatzone.config;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.List;
import java.util.Map;

public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

//        // 从 URL 参数中获取 Token
//        String token = extractTokenFromRequest(request);
//
//        // 验证 Token（示例逻辑，实际需根据项目安全机制实现）
//        if (token != null && validateToken(token)) {
//            // 验证通过，将用户信息存入 WebSocket 会话
//            attributes.put("user", StpUtil.getLoginIdByToken(token));
//            return true;
//        }
        // 从 HTTP 请求头中获取 Cookie（自动携带）
        HttpHeaders headers = request.getHeaders();
        List<String> cookieHeaders = headers.get(HttpHeaders.COOKIE);

        if (cookieHeaders != null) {
            String cookieString = cookieHeaders.getFirst();
            String token = extractTokenFromCookie(cookieString);

            if (token != null && validateToken(token)) {
                attributes.put("user", Long.parseLong((String) StpUtil.getLoginIdByToken(token)));
                return true;
            }
        }

        // 验证失败，拒绝连接
        System.out.println("WebSocket 连接验证失败，无效 Token: " + cookieHeaders);
        return false;
    }

//    private String extractTokenFromRequest(ServerHttpRequest request) {
//        // 从 URL 参数中获取 token（例如：ws://localhost:8080/ws?token=xxx）
//        String query = request.getURI().getQuery();
//        if (query != null) {
//            String[] params = query.split("&");
//            for (String param : params) {
//                String[] keyValue = param.split("=");
//                if (keyValue.length == 2 && "token".equals(keyValue[0])) {
//                    return keyValue[1];
//                }
//            }
//        }
//        return null;
//    }

    private String extractTokenFromCookie(String cookieString) {
        // 解析 Cookie 字符串获取 token
        String[] cookies = cookieString.split("; ");
        for (String cookie : cookies) {
            if (cookie.startsWith("token=")) {
                return cookie.split("=")[1];
            }
        }
        return null;
    }

    private boolean validateToken(String token) {
        // 验证token
        return StpUtil.isLogin(StpUtil.getLoginIdByToken(token)); // 示例：简单验证非空
    }

}
