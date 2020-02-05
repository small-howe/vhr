package com.tangwh.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 消息发送的类
 */
@Data
public class ChatMsg {

    // 消息从哪来
    private String from;

    //消息到哪去
    private String to;

    // 消息的内容
    private String content;

    // 消息发送的时间
    private Date date;

    // 发消息的人名字
    private String fromNickname;
}
