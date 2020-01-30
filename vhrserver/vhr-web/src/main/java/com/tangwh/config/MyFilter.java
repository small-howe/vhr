package com.tangwh.config;

import com.tangwh.pojo.Menu;
import com.tangwh.pojo.Role;
import com.tangwh.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 这个类的作用 主要是根据 用户传来的请求地址 分析出请求需要的角色
 */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;

    // 对比工具
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 根据用户的请求地址 分析他所需要的角色
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
       // Collection:就是当前请求所需要的角色

        // 获取到请求的地址
        String requestUrl = ((FilterInvocation) object).getRequestUrl();

         // 获取所有的请求链接项
        List<Menu> menus = menuService.getAllMenusWithRole();
        // 遍历菜单项
        for (Menu menu : menus) {
            // 然后做和请求的地址作对比 参数一:规则  参数二:对比的url
            if (antPathMatcher.match(menu.getUrl(),requestUrl)){
                // 如果匹配上 获取当前请求需要的角色
                List<Role> roles = menu.getRoles();
                // 返回需要Collection格式 所以需要转换
                String[] str = new String[roles.size()];
                for (int i = 0; i <roles.size() ; i++) {
                     str[i] =roles.get(i).getName();
                }

                return SecurityConfig.createList(str);

            }
        }
        // 如果以上都没匹配上 那么我让他登录之后都能访问  ROLE_LOGIN只是一个标记
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
