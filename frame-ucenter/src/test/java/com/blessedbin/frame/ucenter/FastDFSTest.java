package com.blessedbin.frame.ucenter;

import com.github.tobato.fastdfs.domain.GroupState;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.github.tobato.fastdfs.service.TrackerClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by xubin on 2018/9/20.
 *
 * @author 37075
 * @date 2018/9/20
 * @time 14:37
 * @tool intellij idea
 */

public class FastDFSTest extends FrameUcenterApplicationTests {


    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private TrackerClient trackerClient;


    /**
     * 测试文件上传
     */
    @Test
    public void upload() {

        try {
            File file = new File("D:\\xubin\\Pictures\\壁纸\\1449818180455.jpg");

            FileInputStream inputStream = new FileInputStream(file);

            StorePath storePath = fastFileStorageClient.uploadSlaveFile("group1", "M00/00/00/wKiAjVlpNjiAK5IHAADGA0F72jo578.jpg"
                    , inputStream, inputStream.available(), "a_", null);

            System.out.println(storePath.getPath());

            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 测试上传缩略图
     */
    @Test
    public void uploadCrtThumbImage() {
        try {
            File file = new File("D:\\xubin\\Pictures\\壁纸\\1449818180455.jpg");

            FileInputStream inputStream = new FileInputStream(file);
            // 测试上传 缩略图
            StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, file.length(),
                    "jpg", null);

            System.out.println(storePath.getGroup() + "  " + storePath.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void contextLoads() {
        List<GroupState> groupStates = trackerClient.listGroups();
        for (GroupState groupState : groupStates) {
            System.out.println(groupState);
        }

    }
}
