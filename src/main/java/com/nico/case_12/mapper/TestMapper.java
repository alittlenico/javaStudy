package com.nico.case_12.mapper;

import com.nico.case_12.entity.Test;

public interface TestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Test row);

    int insertSelective(Test row);

    Test selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Test row);

    int updateByPrimaryKey(Test row);
}