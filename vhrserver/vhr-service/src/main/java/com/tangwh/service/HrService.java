package com.tangwh.service;

import com.tangwh.mapper.HrMapper;
import com.tangwh.mapper.extmapper.HrExtMapper;
import com.tangwh.mapper.extmapper.HrRoleExtMapper;
import com.tangwh.pojo.Hr;
import com.tangwh.utils.HrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    HrRoleExtMapper hrRoleExtMapper;

    /**
     * 根据用户名加载对象
     *
     * @param
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr1 = hrMapper.selectByPrimaryKey(3);

//        System.out.println(hr.toString());

        Hr hr = hrextMapper.loadUserByUsername(username);
      //  System.out.println(hr.toString());



//       hr.setPassword("$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm");
//        String password = hr.getPassword();
//        System.err.println("密码是"+password);

//      hr.setPassword("$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm");
        if (hr == null) {

            throw new UsernameNotFoundException("用户名不存在");
        }
        // 如果登录成功的话 给用户角色
        hr.setRoles(hrextMapper.getRolesById(hr.getId()));
        return hr;


    }

    /**
     * 获取Hr 的信息  除过自己的信息
     *
     * @return
     */
    public List<Hr> getAllHrs(String keywords) {

        return hrextMapper.getAllHrs(HrUtils.getCurrenHr().getId(),keywords);
    }

    /**
     * 更新操作
     * @param hr
     * @return
     */
    public Integer updateHr(Hr hr) {
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    /**
     * 更新Hr 角色 先删除原有的 再重新添加
     * @param hrid
     * @param rids
     * @return
     */
    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
          // 先删除
        hrRoleExtMapper.deleteByHrid(hrid);
      // 添加
        return hrRoleExtMapper.addRole(hrid, rids) == rids.length;

    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    public Integer deleteHrById(Integer id) {
        return hrMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询hr 不包含自己
     * @return
     */
    public List<Hr> getAllHrsExceptCurrentHr() {

        return hrextMapper.getAllHrsExceptCurrentHr(HrUtils.getCurrenHr().getId());

    }
}
