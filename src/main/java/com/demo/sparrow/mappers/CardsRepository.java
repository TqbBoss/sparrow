package com.demo.sparrow.mappers;

import com.demo.sparrow.domains.Cards;

public interface CardsRepository {
    int deleteByPrimaryKey(Long id);

    int insert(Cards record);

    int insertSelective(Cards record);

    Cards selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cards record);

    int updateByPrimaryKey(Cards record);
}