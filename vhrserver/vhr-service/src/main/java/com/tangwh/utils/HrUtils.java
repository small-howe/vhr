package com.tangwh.utils;

import com.tangwh.pojo.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

public class HrUtils {


    /**
     * 当前用户对象
     * @return
     */
    public static Hr getCurrenHr(){
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
