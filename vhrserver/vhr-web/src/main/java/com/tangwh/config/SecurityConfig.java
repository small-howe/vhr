package com.tangwh.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tangwh.pojo.Hr;
import com.tangwh.pojo.RespEntity;
import com.tangwh.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2019/12/29 17:35
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    HrService hrService;

    @Autowired
    MyFilter myFilter;

    @Autowired
    MyDecisionManager myDecisionManager;
    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }


    /**
     * 使用postMan 测试 没登录的情况下 如果访问其他login如果被拦截
     *  设置  如果访问login 不用经过security  直接过
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login");
    }

    /**
     * 所有的请求认证之后才可以访问
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // 所有请求认证之后才可以访问
//                .anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(myDecisionManager);
                        object.setSecurityMetadataSource(myFilter);

                        return object;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                // 登录处理的Url
                .loginProcessingUrl("/doLogin")
                // 登录页面
                .loginPage("/login")
                // 登录成功的回调
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override  //req :请求  resp:响应  authentication:用户登录成功的 信息
                    public void onAuthenticationSuccess(HttpServletRequest req,
                                                        HttpServletResponse resp, Authentication authentication) throws IOException, ServletException {

                        resp.setContentType("application/json;charset=UTF-8");
                        PrintWriter out = resp.getWriter();

                        // 登录成功hr对象 将要返回给前台
                        Hr hr = (Hr) authentication.getPrincipal();
                          // 密码不能封返回
                        hr.setPassword(null);
                        RespEntity ok = RespEntity.ok("登录成功", hr);

                        String s = new ObjectMapper().writeValueAsString(ok);

                        out.write(s);
                        out.flush();
                        out.close();

                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp
                            , AuthenticationException e) throws IOException, ServletException {
                        resp.setContentType("application/json;charset=UTF-8");
                        PrintWriter out = resp.getWriter();

                        RespEntity error = RespEntity.error("登录失败");
                        if (e instanceof LockedException) {
                            error.setMsg("账户被锁定,请联系管理员");
                        } else if (e instanceof CredentialsExpiredException) {
                            error.setMsg("密码过期,请联系管理员");
                        } else if (e instanceof AccountExpiredException) {
                            error.setMsg("账户过期,请联系管理员");
                        } else if (e instanceof DisabledException) {
                            error.setMsg("账户被禁用,请联系管理员");
                        }else if (e instanceof BadCredentialsException) {
                            error.setMsg("用户名或密码输入错误,请重新输入");
                        }
                        out.write(new ObjectMapper().writeValueAsString(error));
                        out.flush();
                        out.close();
                    }
                })
                // 跟这里相关的接口都能直接返回
                .permitAll()

                //注销登录
                .and()
                .logout()
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest req, HttpServletResponse resp,
                                                Authentication authentication) throws IOException, ServletException {

                        resp.setContentType("application/json;charset=utf-8");
                        PrintWriter out = resp.getWriter();

                        out.write(new ObjectMapper().writeValueAsString(RespEntity.ok("注销成功")));

                        out.flush();
                        out.close();


                    }
                })
                .permitAll()
                .and()

                // 使用POSTMAN测试
                .csrf().disable()
                 // 异常处理  没有认证  不要重定向  // 如果配置了这个 上面的login 登录页面就不需要了
                .exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
            @Override
            public void commence(HttpServletRequest request, HttpServletResponse response,
                                 AuthenticationException e) throws IOException, ServletException {
                // 在这个方法 可以设置 你是重定向还是
                response.setContentType("application/json;charset=UTF-8");
                // 401 没有认证
                response.setStatus(401);

                PrintWriter out = response.getWriter();

                RespEntity error = RespEntity.error("访问失败");
                if (e instanceof InsufficientAuthenticationException) {
                    error.setMsg("请求失败,请联系管理员");
                }
                out.write(new ObjectMapper().writeValueAsString(error));
                out.flush();
                out.close();
            }
        });
    }
}