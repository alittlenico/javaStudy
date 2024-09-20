package com.nico.case_3.service;

import com.nico.case_3.mapper.A;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author liuyi
* @description 针对表【a】的数据库操作Service
* @createDate 2023-04-06 21:35:14
*/
public interface AService extends IService<A> {
    List<A> list1();
}
