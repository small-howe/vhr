package com.tangwh.controller;

import com.mysql.cj.protocol.Security;
import com.tangwh.config.FastDFSUtils;
import com.tangwh.pojo.Hr;
import com.tangwh.pojo.RespEntity;
import com.tangwh.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HrInfoController {


    @Autowired
    HrService hrService;


    @Value("${fastdfs.nginx.host}")
    String nginxHost;

    /**
     * 获取Hr 当前登录的信息
     * @return
     */
    @GetMapping("/hr/info")
    public Hr getCurrentHr(Authentication authentication){

        return (Hr)authentication.getPrincipal();



    }

    /**
     * 修改用户信息
     * @param hr
     * @return
     */
    @PutMapping("hr/info")
    public RespEntity updateHr(@RequestBody Hr hr,Authentication authentication){

        if (hrService.updateHr(hr) == 1){

            //更新用户信息
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(hr,
                    authentication.getCredentials(),authentication.getAuthorities()));

            return RespEntity.ok("更新成功");

        }
        return RespEntity.error("更新失败");
    }



    @PostMapping("/hr/userface")
    public RespEntity updateHrUserface(MultipartFile file,Integer id){

        String fileId = FastDFSUtils.upload(file);
        
//        String url = ngixHost+fileId;

        return RespEntity.error("jjajaj");
    }

}
