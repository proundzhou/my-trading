package com.zhou.refundaftersele.service;

import com.zhou.refundaftersele.domain.dto.RefundDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@FeignClient("wqh-pic-center")
public interface IFileUploadService {

    //@RequestMapping(value = "/uploadFile",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    //String ImgUpload(@RequestPart(value = "img") MultipartFile[] files,RefundDto refundDto);
    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String ImgUpload(@RequestBody Map<String,Object> data);
}
