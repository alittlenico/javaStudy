package com.nico.case_12.mapper;

import com.nico.case_12.entity.MeterData;

public interface MeterDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MeterData row);

    int insertSelective(MeterData row);

    MeterData selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MeterData row);

    int updateByPrimaryKey(MeterData row);
}