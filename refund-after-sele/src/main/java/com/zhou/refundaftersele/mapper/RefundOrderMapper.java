package com.zhou.refundaftersele.mapper;

import com.zhou.refundaftersele.domain.entity.RefundOrder;import java.util.List;

public interface RefundOrderMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(RefundOrder record);

    int insertSelective(RefundOrder record);

    RefundOrder selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(RefundOrder record);

    int updateByPrimaryKey(RefundOrder record);

    List<RefundOrder> selectOrderByPrimaryKey(Integer rId);
}