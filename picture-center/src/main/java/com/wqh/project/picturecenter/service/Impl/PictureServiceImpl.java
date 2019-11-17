package com.wqh.project.picturecenter.service.Impl;

import com.wqh.project.picturecenter.domain.dto.RefundDto;
import com.wqh.project.picturecenter.domain.entity.Picture;
import com.wqh.project.picturecenter.mapper.PictureMapper;
import com.wqh.project.picturecenter.service.IPictureService;
import com.wqh.project.picturecenter.utils.UploadUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

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

    @Override
    public String saveImg(MultipartFile[] files, RefundDto refundDto) {
        UploadUtils utils = new UploadUtils();
        String relativePath = null;

        Date date = new Date();
        String timePrefix = DateFormatUtils.format(date, "yyyyMMddHHmmss");

        relativePath = refundDto.getUId()+File.separator
                +refundDto.getOId()+File.separator
                +refundDto.getGId();

        String realPath = utils.saveImgNoName(files, relativePath);

        return null;
    }


}
