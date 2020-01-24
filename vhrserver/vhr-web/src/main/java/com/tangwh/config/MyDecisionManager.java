package com.tangwh.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 去判断 当前用户是否具备 MyFilter类分析出来的角色 是否具备的角色 如果具备 那就过
 */
@Component
public class MyDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        //authentication 当前用户的信息 object:当前请求对象  collection:是MyFilter 第一个方法的返回值
        // 拿出所需要的角色
        for (ConfigAttribute configAttribute : collection) {
            // 需要的角色
            String needRole = configAttribute.getAttribute();
            // 如果需要的角色是这个 那么 让她去登录 ROLE_LOGIN是MyFile 类做好的标记
            if ("ROLE_LOGIN".equals(needRole)) {
                // 判断是是否登录 如果是匿名实例 说明没登陆
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录请登录");
                } else {
                    // 如果登录了
                    return;
                }
            }
            // 获取当前用户的角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            // 判断  查询的角色 collection  是否包含其中的任意一项
            for (GrantedAuthority authority : authorities) {
                // 如果相等 那么 我需要你具备的角色
                if (authority.getAuthority().equals(needRole)) {
                 return;
                }
            }

            // 如果需要的角色你都不具备 那么
            throw new AccessDeniedException("权限不足,请联系管理员");
        }


    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
