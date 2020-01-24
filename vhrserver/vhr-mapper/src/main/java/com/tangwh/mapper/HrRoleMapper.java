package com.tangwh.mapper;

import com.tangwh.pojo.Hr;
import com.tangwh.pojo.HrRole;

/**
 * @author  Tangweihao
 * @date  2019/12/29 13:13
 * @version 1.0
 */
public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);


}