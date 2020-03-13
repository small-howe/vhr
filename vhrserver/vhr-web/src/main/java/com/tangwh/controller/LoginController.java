package com.tangwh.controller;

import com.tangwh.config.VerificationCode;
import com.tangwh.pojo.RespEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2020/1/1 11:07
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    // @CrossOrigin("*") 跨域问题
    public RespEntity login(){
        return RespEntity.error("尚未登录,请登录后再试");
    }


    /**
     * 生成 二维码 照片
     * @param session
     * @param response
     * @throws IOException
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse response) throws IOException {


        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();

        session.setAttribute("verify_code", text);



        // 把照片写出去

        VerificationCode.output(image, response.getOutputStream());

    }
}
