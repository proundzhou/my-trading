package com.wqh.project.evaluate.controller;

import com.wqh.project.evaluate.domain.dto.CommentDto;
import com.wqh.project.evaluate.domain.entity.Evaluate;
import com.wqh.project.evaluate.domain.vo.CommentShowVo;
import com.wqh.project.evaluate.domain.vo.CommentVo;
import com.wqh.project.evaluate.service.ICommentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wen
 * 13:02
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    @Resource
    ICommentService commentService;

    @RequestMapping(value = "put",method = RequestMethod.POST)
    public String show(@RequestBody CommentDto dto){
        Evaluate evaluate = new Evaluate();
        System.out.println(dto.toString());
        evaluate.setUId(dto.getUId());
        evaluate.setGId(dto.getGId());
        evaluate.setEType(dto.getType());
        evaluate.setContext(dto.getContext());
        //System.out.println(evaluate);
        //Integer insert = commentService.insert(evaluate);
        return "OK";
    }
}
