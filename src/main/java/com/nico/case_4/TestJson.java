package com.nico.case_4;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author liuyi
 * @version 1.0
 * @description: TODO
 * @date 2022/8/12 15:26
 */
@TableName("test_json")
@Data
@NoArgsConstructor
//@AllArgsConstructor
public class TestJson {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("js")
    private String jsonText;

    public TestJson(String s) {
        this.jsonText = s;
    }
}
