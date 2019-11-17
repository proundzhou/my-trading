package com.wqh.project.picturecenter.controller;

import com.wqh.project.picturecenter.domain.dto.RefundDto;
import com.wqh.project.picturecenter.service.IPictureService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author wen
 * 9:02
 */
@RestController
public class FileController {
    @Resource
    IPictureService pictureService;

    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String ImgUpload(@RequestBody Map<String,Object> data){
        MultipartFile[] files = (MultipartFile[])data.get("files");
        RefundDto refundDto = (RefundDto)data.get("refundDto");
        return pictureService.saveImg(files,refundDto);
    }

    @RequestMapping("test")
    public String test(@RequestParam MultipartFile[] files) throws IOException {
        pictureService.savePic(files);
        return "OK";
    }
}
