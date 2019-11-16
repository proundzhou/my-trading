package com.wqh.project.evaluate.service.Impl;

import com.wqh.project.evaluate.domain.entity.Evaluate;
import com.wqh.project.evaluate.mapper.EvaluateMapper;
import com.wqh.project.evaluate.service.ICommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wen
 * 13:13
 */
@Service
public class CommentServiceImpl implements ICommentService {
    @Resource
    EvaluateMapper evaluateMapper;
    
    @Override
    public Integer insert(Evaluate evaluate) {
        return evaluateMapper.insert(evaluate);
    }
}
