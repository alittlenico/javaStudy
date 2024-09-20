package com.nico.case_3.mapper;

import com.nico.case_3.mapper.A;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author liuyi
* @description 针对表【a】的数据库操作Mapper
* @createDate 2023-04-06 21:35:14
* @Entity com.nico.case_3.mapper.A
*/
@Mapper
public interface AMapper extends BaseMapper<A> {
    List<A> list();
}




