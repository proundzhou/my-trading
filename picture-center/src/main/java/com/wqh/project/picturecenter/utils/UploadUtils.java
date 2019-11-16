package com.wqh.project.picturecenter.utils;

import com.wqh.project.picturecenter.configuration.FileInfoProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wen
 * 17:59
 */
@Component
public class UploadUtils {
    @Resource
    FileInfoProperties properties;
    private String ImagePath="\\imgs";
    private String RootPath="D:\\JAVA\\pic";
    private String prefixImg="IMG_";
    private int a=1;

    public String getImageRootPath() {
        return ImagePath + File.separator + DateFormatUtils.format(new Date(), "yyyyMMdd");
    }

    public String getFileName(String prefix, String oldFileName) {
        //  .png  或者.jpg
        String suffixName = oldFileName.substring(oldFileName.indexOf("."));
        //IMG_201910311717.png
        return prefix + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss")+ "_"+ ++a + suffixName;
    }

    public String saveImageFile(MultipartFile[] files) throws IOException {
        String save = new String();
        for (MultipartFile multipartFile:files) {
            String imageRootName = getImageRootPath();
            String fileName = getFileName(prefixImg, multipartFile.getOriginalFilename());
            //  生成保存图片的数据库路径
            String imageFile = getImageRootPath() + File.separator + fileName;
            // 生成完成的保存图片的路径
            File file = new File(RootPath + File.separator + imageFile);
            //生成文件
            FileUtils.touch(file);
            // 保存到服务器
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
            save = save + imageFile + ",";
        }
        a = 1;
        return save.substring(0,save.length()-1);
    }
}
