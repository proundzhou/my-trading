package com.wqh.project.picturecenter.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author wen
 * 10:58
 */
public interface IPictureService {
    String savePic(MultipartFile[] files) throws IOException;
}
