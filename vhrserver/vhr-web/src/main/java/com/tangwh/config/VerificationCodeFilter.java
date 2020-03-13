package com.tangwh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangwh.pojo.RespEntity;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 过滤器
 */
@Component
public class VerificationCodeFilter extends GenericFilter {
    /**
     * 校验 验证码 是否正确
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 如果这个请求是登录请求
        if ("POST".equals(request.getMethod()) && "/doLogin".equals(request.getServletPath())) {

            // 登录请求

            String code = request.getParameter("code");


            String verify_code = (String) request.getSession().getAttribute("verify_code");



            if (code == null || "".equals(code) || !verify_code.toLowerCase().equals(code.toLowerCase())){

                // 验证码不正确
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                out.write(new ObjectMapper().writeValueAsString(RespEntity.error("验证码填写错误")));

                out.flush();
                out.close();

                return;


            }else {
                // 过滤器 直接过

                filterChain.doFilter(request, response);
            }

        } else {
            // 不是登录请求 直接过
            filterChain.doFilter(request, response);
        }


    }
}
