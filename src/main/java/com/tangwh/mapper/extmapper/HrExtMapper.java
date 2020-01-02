package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Hr;
import org.apache.ibatis.annotations.Mapper;

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
}
