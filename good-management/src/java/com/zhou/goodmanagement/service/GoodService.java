package com.zhou.goodmanagement.service;

import com.zhou.goodmanagement.domain.dto.GoodsDto;

import java.util.ArrayList;
import java.util.List;

public class GoodService {

    public List<GoodsDto> getGoodsList(){
        ArrayList<GoodsDto> goodsDtos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            GoodsDto.builder()
                    .gId(i)
                    .gName("商品"+i)
                    .price(34.5)
                    .specification("高级版")
                    .build();
        }
        return goodsDtos;
    }

    public GoodsDto getGoods(Integer i) {
        return GoodsDto.builder()
                .gId(i)
                .gName("商品"+i)
                .price(34.5)
                .specification("高级版")
                .build();
    }
}
