package com.wqh.project.picturecenter.controller;

import com.sun.org.apache.xpath.internal.operations.Mult;
import com.wqh.project.picturecenter.service.IPictureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author wen
 * 9:02
 */
@RestController
public class FileController {
    @Resource
    IPictureService pictureService;

    @RequestMapping("test")
    public String test(@RequestParam MultipartFile[] files) throws IOException {
        pictureService.savePic(files);
        return "OK";
    }
}
