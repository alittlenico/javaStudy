package com.nico.case_2.web;

import com.nico.case_2.annotation.NotControllerResponseAdvice;
import com.nico.case_2.domain.ProductInfo;
import com.nico.case_2.domain.ProductInfoVo;
import com.nico.case_2.domain.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/21 11:23
 */
@RestController
public class ProductController {
    @PostMapping(value = "/findByVo")
    public ResultVo findByVo(@RequestBody @Validated ProductInfoVo vo) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        productInfo.setId(1L);
        return new ResultVo(productInfo);
    }

    //ResponseAdvice返回结果体之前会判断是不是ResultVo 如果不是会自动封装
    @PostMapping(value = "/findByVo1")
    public ProductInfo findByVo1(@RequestBody @Validated ProductInfoVo vo) {
        ProductInfo productInfo = new ProductInfo();
        BeanUtils.copyProperties(vo, productInfo);
        productInfo.setId(1L);
        System.out.println("vo1");
        return productInfo;
    }

    //针对有些已经设计好的接口，他并不要返回ResultVo
    @GetMapping("/success")
    @NotControllerResponseAdvice
    public String success() {
        return "success";
    }
}
