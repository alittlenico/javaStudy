package com.nico.case_3.mapper;

import com.nico.case_3.A;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/30 22:19
 */
@Mapper
public interface AMapper {
    List<A> findAList();
}
