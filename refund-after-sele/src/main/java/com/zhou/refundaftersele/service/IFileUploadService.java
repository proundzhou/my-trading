package com.zhou.refundaftersele.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("wqh-pic-center")
public interface IFileUploadService {

    @RequestMapping(value = "test" , method = RequestMethod.POST)
    String ImgUpload(@RequestParam MultipartFile[] files);
}
