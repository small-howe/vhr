package com.tangwh.mapper.extmapper;

import com.tangwh.pojo.Hr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HrRoleExtMapper {
    /**
     * 根据hr 删除 信息
     * @param hrid
     */
    void deleteByHrid(Integer hrid);



    /**
     * 添加
     * @param hrid
     * @param rids
     * @return
     */

    Integer addRole(@Param("hrid") Integer hrid,@Param("rids") Integer[] rids);


}
