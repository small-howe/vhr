package com.tangwh.receiver;

import com.tangwh.pojo.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.PushbackInputStream;
import java.util.Date;

/**
 * 消息接受
 */
@Component
public class MailReceiver {
    // 日志打印
    public static final Logger logger = LoggerFactory.getLogger(MailReceiver.class);


    @Autowired
    JavaMailSenderImpl javaMailSender;

    @Autowired
    MailProperties mailProperties;

    @Autowired
    SpringTemplateEngine springTemplateEngine;



    @RabbitListener(queues = "javaboy.mail")
    public void handler(Employee employee) {



        // 收到的消息,发送邮件
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message);



        try {
            // 给谁发送
            helper.setTo(employee.getEmail());
            // 谁发送的
            helper.setFrom(mailProperties.getUsername());

            helper.setSubject("入职欢迎");

            // 设置时间
            helper.setSentDate(new Date());

            // 渲染模板对象
            Context context = new Context();
            context.setVariable("name", employee.getName());
            context.setVariable("posName", employee.getPosition().getName());
            context.setVariable("joblevelName", employee.getJoblevel().getName());
            context.setVariable("departmentName", employee.getDepartment().getName());
            String mail = springTemplateEngine.process("mail", context);

            helper.setText(mail,true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error("邮件发送失败",e.getMessage());
        }

    }
}
