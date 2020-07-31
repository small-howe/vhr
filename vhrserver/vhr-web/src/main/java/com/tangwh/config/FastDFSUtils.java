package com.tangwh.config;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;

/**
 * 上传文件工具类
 */
public class FastDFSUtils {

    private static StorageClient1 client1;

    // 加载配置文件
    static {

        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");

            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            client1 = new StorageClient1(trackerServer, null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件操作
     * @param file
     * @return
     */
    public static String upload(MultipartFile file){
          //拿到文件的旧的名字
        String oldName = file.getOriginalFilename();

        //上传文件  文件数组  扩展名  文件的源数据信息
        try {
            return client1.upload_file1(file.getBytes(), oldName.substring(oldName.lastIndexOf(".") + 1), null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;


    }
}
