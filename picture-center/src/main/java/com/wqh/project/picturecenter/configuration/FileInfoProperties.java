package com.wqh.project.picturecenter.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author wen
 * 19:01
 */
@Component
@Data
@ConfigurationProperties("fileupload")
public class FileInfoProperties {
    private String rootPath;
    private String imagePath;
    private String pdfPath;
    private String prefixImg;
}
