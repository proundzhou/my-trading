package com.wqh.project.picturecenter;

import com.wqh.project.picturecenter.configuration.FileInfoProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PictureCenterApplicationTests {

    @Test
    void contextLoads() {
        FileInfoProperties fileInfoProperties = new FileInfoProperties();
        System.out.println(fileInfoProperties.toString());
    }

}
