package com.nico.case_2.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/7/21 11:24
 */
@Data
public class ProductInfo {
    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStatus;
}
