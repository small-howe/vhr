package com.tangwh.pojo;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
// 用户类(表)
@Data
public class Hr implements UserDetails {
    /**
    * hrID
    */
    private Integer id;

    /**
    * 姓名
    */
    private String name;

    /**
    * 手机号码
    */
    private String phone;

    /**
    * 住宅电话
    */
    private String telephone;

    /**
    * 联系地址
    */
    private String address;

    /**
    * 
    */

    private Boolean enabled;

    /**
    * 用户名
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 
    */
    private String userface;

    /**
    * 
    */
    private String remark;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /**
     * 账户是否没有过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    /**
     * 账户是否被没有被锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {

        return true;
    }

    /**
     * 密码是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}