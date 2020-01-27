package com.tangwh.mapper.extmapper;

import org.apache.ibatis.annotations.Param;

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
