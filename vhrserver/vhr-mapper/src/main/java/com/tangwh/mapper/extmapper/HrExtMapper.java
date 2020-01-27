package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Hr;
import com.tangwh.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Tangweihao
 * @version 1.0
 * @date 2019/12/29 15:13
 */
@Mapper
public interface HrExtMapper {
    /**
     * 自 通过用户名查询
     * @param username
     * @return
     */
    Hr loadUserByUsername(String username);

    /**
     * 根据用户Id查 用户权限
     * @param id
     * @return
     */
    List<Role> getRolesById(Integer id);

    /**
     * 查询所有hr 信息 除过自己的
     * @param hrid
     * @return
     */
    List<Hr> getAllHrs(@Param("hrid") Integer hrid,@Param("keywords") String keywords);
}
