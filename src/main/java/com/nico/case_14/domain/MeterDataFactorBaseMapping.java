package com.nico.case_14.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

/**
 * 仪表数据因子映射关系表
 * @TableName t_meter_data_factor_base_mapping
 */
@TableName(value ="t_meter_data_factor_base_mapping")
@Data
public class MeterDataFactorBaseMapping implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 因子编码
     */
    private Long meterDataFactorBaseId;

    /**
     * 10日冻结数据接口20瞬读数据接口30分钟周期数据接口
     */
    private String interfaceType;

    /**
     * 接口编码:因子接口编码
     */
    private String interfaceCode;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新人
     */
    private Long updateUser;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 状态:10正常20停用
     */
    private String status;

    /**
     * 删除标识:0 正常 2:删除
     */
    private String delFlag;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}