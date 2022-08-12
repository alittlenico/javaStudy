package com.nico.case_4;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/12 15:02
 */
@Data
@NoArgsConstructor
public class City {
    private Long id;
    private String province;
    private String city;
    private String area;

    public City(Long id, String province, String city, String area) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.area = area;
    }
}
