package com.tangwh.mapper.extmapper;

import org.apache.ibatis.annotations.Param;

public interface MenuRoleExtMapper {
    void deleeByRid(Integer rid);

    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
