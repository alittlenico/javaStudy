package com.nico.case_14.mapper;

import com.nico.case_14.domain.MeterDataFactorBaseMapping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author liuyi
* @description 针对表【t_meter_data_factor_base_mapping(仪表数据因子映射关系表)】的数据库操作Mapper
* @createDate 2022-11-15 22:03:59
* @Entity com.nico.case_14.domain.MeterDataFactorBaseMapping
*/
@Mapper
public interface MeterDataFactorBaseMappingMapper extends BaseMapper<MeterDataFactorBaseMapping> {
    void addBatch(@Param("list") List<MeterDataFactorBaseMapping> list);
}




