package com.wqh.project.picturecenter.service.Impl;

import com.wqh.project.picturecenter.domain.entity.Picture;
import com.wqh.project.picturecenter.mapper.PictureMapper;
import com.wqh.project.picturecenter.service.IPictureService;
import com.wqh.project.picturecenter.utils.UploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author wen
 * 18:53
 */
@Service
public class PictureServiceImpl implements IPictureService {
    @Resource
    PictureMapper pictureMapper;

    @Override
    public String savePic(MultipartFile[] files) throws IOException {
        UploadUtils utils = new UploadUtils();
        String s = utils.saveImageFile(files);
        Picture picture = new Picture();
        picture.setUrl(s);
        int insert = pictureMapper.insert(picture);
        return null;
    }
}
