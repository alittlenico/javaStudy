package com.nico.case_2.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/21 11:08
 */
@Data
public class ProductInfoVo {
    @NotEmpty(message = "商品名称不允许为空")
    private String productName;

    @Min(value = 0, message = "商品价格不允许为负数")
    private BigDecimal productPrice;

    private Integer productStatus;
}
