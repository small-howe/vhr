package com.tangwh.pojo;

import lombok.Data;

/**
 * 没有的字段
 *
 */
@Data
public class Meta {

    /**
     * 从Menu表过来的
     */
    private Boolean keepAlive;

    /**
     *从Menu表过来的
     */
    private Boolean requireAuth;
}
