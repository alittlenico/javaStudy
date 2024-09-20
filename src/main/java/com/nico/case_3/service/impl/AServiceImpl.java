package com.nico.case_3.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nico.case_3.mapper.A;
import com.nico.case_3.service.AService;
import com.nico.case_3.mapper.AMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author liuyi
* @description 针对表【a】的数据库操作Service实现
* @createDate 2023-04-06 21:35:14
*/
@Service
public class AServiceImpl extends ServiceImpl<AMapper, A>
    implements AService{

    @Autowired
    AMapper mapper;

    @Override
    public List<A> list1() {
        //把分页信息保存到ThreadLocal当中
        PageHelper.startPage(1,5);
        List<A> list = mapper.list();
        PageInfo<A> aPageInfo = new PageInfo<>(list);
        return null;
    }
}




