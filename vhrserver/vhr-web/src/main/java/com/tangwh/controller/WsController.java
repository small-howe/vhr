package com.tangwh.controller;


import com.tangwh.pojo.ChatMsg;
import com.tangwh.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * 消息处理类
 */
@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    // 处理前端发送消息的方法

                        //principal 获取当前 的用户
    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg){
        Hr hr = (Hr) authentication.getPrincipal();
        // 获取消息从哪来
        chatMsg.setFrom(hr.getUsername());
        chatMsg.setFromNickname(hr.getName());
        // 消息的发送时间
        chatMsg.setDate(new Date());
     // 参数一: 给谁发送 参数二 监听的队列 参数三 : 消息对象
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),"/queue/chat" , chatMsg);
    }
}
