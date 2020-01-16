package com.tangwh.service;

import com.tangwh.mapper.HrMapper;
import com.tangwh.mapper.extmapper.HrExtMapper;
import com.tangwh.pojo.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2019/12/29 13:40
 */
@Service
public class HrService implements UserDetailsService {


    @Autowired
    HrExtMapper hrextMapper;

    @Autowired
    HrMapper hrMapper;

    /**
     * 根据用户名加载对象
     *
     * @param
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr1 = hrMapper.selectByPrimaryKey(1);

        Hr hr = hrextMapper.loadUserByUsername(username);
        System.out.println(hr.toString());
        if (hr == null) {

            throw new UsernameNotFoundException("用户名不存在");
        }
        // 如果登录成功的话 给用户角色
        hr.setRoles(hrextMapper.getRolesById(hr.getId()));
            return hr;


    }
}
