package com.nico.case_12.entity;

import lombok.Data;

/**
 * 电表数据表
 *
 * create by qsm
 * meter_data
 */
@Data
public class MeterData {
    /**
     * 主键
     */
    private Long id;

    /**
     * 设备id
     */
    private String meterId;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 正向有功总电能(kWh)
     */
    private String zxygzdn;

    /**
     * 正向有功费率1电能(kWh)
     */
    private String zxygfl1dn;

    /**
     * 正向有功费率2电能(kWh)
     */
    private String zxygfl2dn;

    /**
     * 正向有功费率3电能(kWh)
     */
    private String zxygfl3dn;

    /**
     * 正向有功费率4电能(kWh)
     */
    private String zxygfl4dn;

    /**
     * 正向无功总电能(kvarh)
     */
    private String zxwgzdn;

    /**
     * 正向无功费率1电能(kvarh)
     */
    private String zxwgfl1dn;

    /**
     * 正向无功费率2电能(kvarh)
     */
    private String zxwgfl2dn;

    /**
     * 正向无功费率3电能(kvarh)
     */
    private String zxwgfl3dn;

    /**
     * 正向无功费率4电能(kvarh)
     */
    private String zxwgfl4dn;

    /**
     * 反向有功总电能(kWh)
     */
    private String fxygzdn;

    /**
     * 反向有功费率1电能(kWh)
     */
    private String fxygfl1dn;

    /**
     * 反向有功费率2电能(kWh)
     */
    private String fxygfl2dn;

    /**
     * 反向有功费率3电能(kWh)
     */
    private String fxygfl3dn;

    /**
     * 反向有功费率4电能(kWh)
     */
    private String fxygfl4dn;

    /**
     * 反向无功总电能(kvarh)
     */
    private String fxwgzdn;

    /**
     * 反向无功费率1电能(kvarh)
     */
    private String fxwgfl1dn;

    /**
     * 反向无功费率2电能(kvarh)
     */
    private String fxwgfl2dn;

    /**
     * 反向无功费率3电能(kvarh)
     */
    private String fxwgfl3dn;

    /**
     * 反向无功费率4电能(kvarh)
     */
    private String fxwgfl4dn;

    /**
     * A相电压(V)
     */
    private String axdy;

    /**
     * B相电压(V)
     */
    private String bxdy;

    /**
     * C相电压(V)
     */
    private String cxdy;

    /**
     * A相电流(A)
     */
    private String axdl;

    /**
     * B相电流(A)
     */
    private String bxdl;

    /**
     * C相电流(A)
     */
    private String cxdl;

    /**
     * 总有功功率(kW)
     */
    private String zyggl;

    /**
     * A相有功功率(kW)
     */
    private String axyggl;

    /**
     * B相有功功率(kW)
     */
    private String bxyggl;

    /**
     * B相有功功率(kW)
     */
    private String cxyggl;

    /**
     * 总无功功率(kW)
     */
    private String zwggl;

    /**
     * A相无功功率(kW)
     */
    private String axwggl;

    /**
     * B相无功功率(kW)
     */
    private String bxwggl;

    /**
     * C相无功功率(kW)
     */
    private String cxwggl;

    /**
     * 总功率因素
     */
    private String zglys;

    /**
     * A相功率因素
     */
    private String axgglys;

    /**
     * B相功率因素
     */
    private String bxgglys;

    /**
     * C相功率因素
     */
    private String cxgglys;

    /**
     * 总视在功率
     */
    private String zszgl;

    /**
     * A相视在功率
     */
    private String axszgl;

    /**
     * B相视在功率
     */
    private String bxszgl;

    /**
     * C相视在功率
     */
    private String cxszgl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId == null ? null : meterId.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getZxygzdn() {
        return zxygzdn;
    }

    public void setZxygzdn(String zxygzdn) {
        this.zxygzdn = zxygzdn == null ? null : zxygzdn.trim();
    }

    public String getZxygfl1dn() {
        return zxygfl1dn;
    }

    public void setZxygfl1dn(String zxygfl1dn) {
        this.zxygfl1dn = zxygfl1dn == null ? null : zxygfl1dn.trim();
    }

    public String getZxygfl2dn() {
        return zxygfl2dn;
    }

    public void setZxygfl2dn(String zxygfl2dn) {
        this.zxygfl2dn = zxygfl2dn == null ? null : zxygfl2dn.trim();
    }

    public String getZxygfl3dn() {
        return zxygfl3dn;
    }

    public void setZxygfl3dn(String zxygfl3dn) {
        this.zxygfl3dn = zxygfl3dn == null ? null : zxygfl3dn.trim();
    }

    public String getZxygfl4dn() {
        return zxygfl4dn;
    }

    public void setZxygfl4dn(String zxygfl4dn) {
        this.zxygfl4dn = zxygfl4dn == null ? null : zxygfl4dn.trim();
    }

    public String getZxwgzdn() {
        return zxwgzdn;
    }

    public void setZxwgzdn(String zxwgzdn) {
        this.zxwgzdn = zxwgzdn == null ? null : zxwgzdn.trim();
    }

    public String getZxwgfl1dn() {
        return zxwgfl1dn;
    }

    public void setZxwgfl1dn(String zxwgfl1dn) {
        this.zxwgfl1dn = zxwgfl1dn == null ? null : zxwgfl1dn.trim();
    }

    public String getZxwgfl2dn() {
        return zxwgfl2dn;
    }

    public void setZxwgfl2dn(String zxwgfl2dn) {
        this.zxwgfl2dn = zxwgfl2dn == null ? null : zxwgfl2dn.trim();
    }

    public String getZxwgfl3dn() {
        return zxwgfl3dn;
    }

    public void setZxwgfl3dn(String zxwgfl3dn) {
        this.zxwgfl3dn = zxwgfl3dn == null ? null : zxwgfl3dn.trim();
    }

    public String getZxwgfl4dn() {
        return zxwgfl4dn;
    }

    public void setZxwgfl4dn(String zxwgfl4dn) {
        this.zxwgfl4dn = zxwgfl4dn == null ? null : zxwgfl4dn.trim();
    }

    public String getFxygzdn() {
        return fxygzdn;
    }

    public void setFxygzdn(String fxygzdn) {
        this.fxygzdn = fxygzdn == null ? null : fxygzdn.trim();
    }

    public String getFxygfl1dn() {
        return fxygfl1dn;
    }

    public void setFxygfl1dn(String fxygfl1dn) {
        this.fxygfl1dn = fxygfl1dn == null ? null : fxygfl1dn.trim();
    }

    public String getFxygfl2dn() {
        return fxygfl2dn;
    }

    public void setFxygfl2dn(String fxygfl2dn) {
        this.fxygfl2dn = fxygfl2dn == null ? null : fxygfl2dn.trim();
    }

    public String getFxygfl3dn() {
        return fxygfl3dn;
    }

    public void setFxygfl3dn(String fxygfl3dn) {
        this.fxygfl3dn = fxygfl3dn == null ? null : fxygfl3dn.trim();
    }

    public String getFxygfl4dn() {
        return fxygfl4dn;
    }

    public void setFxygfl4dn(String fxygfl4dn) {
        this.fxygfl4dn = fxygfl4dn == null ? null : fxygfl4dn.trim();
    }

    public String getFxwgzdn() {
        return fxwgzdn;
    }

    public void setFxwgzdn(String fxwgzdn) {
        this.fxwgzdn = fxwgzdn == null ? null : fxwgzdn.trim();
    }

    public String getFxwgfl1dn() {
        return fxwgfl1dn;
    }

    public void setFxwgfl1dn(String fxwgfl1dn) {
        this.fxwgfl1dn = fxwgfl1dn == null ? null : fxwgfl1dn.trim();
    }

    public String getFxwgfl2dn() {
        return fxwgfl2dn;
    }

    public void setFxwgfl2dn(String fxwgfl2dn) {
        this.fxwgfl2dn = fxwgfl2dn == null ? null : fxwgfl2dn.trim();
    }

    public String getFxwgfl3dn() {
        return fxwgfl3dn;
    }

    public void setFxwgfl3dn(String fxwgfl3dn) {
        this.fxwgfl3dn = fxwgfl3dn == null ? null : fxwgfl3dn.trim();
    }

    public String getFxwgfl4dn() {
        return fxwgfl4dn;
    }

    public void setFxwgfl4dn(String fxwgfl4dn) {
        this.fxwgfl4dn = fxwgfl4dn == null ? null : fxwgfl4dn.trim();
    }

    public String getAxdy() {
        return axdy;
    }

    public void setAxdy(String axdy) {
        this.axdy = axdy == null ? null : axdy.trim();
    }

    public String getBxdy() {
        return bxdy;
    }

    public void setBxdy(String bxdy) {
        this.bxdy = bxdy == null ? null : bxdy.trim();
    }

    public String getCxdy() {
        return cxdy;
    }

    public void setCxdy(String cxdy) {
        this.cxdy = cxdy == null ? null : cxdy.trim();
    }

    public String getAxdl() {
        return axdl;
    }

    public void setAxdl(String axdl) {
        this.axdl = axdl == null ? null : axdl.trim();
    }

    public String getBxdl() {
        return bxdl;
    }

    public void setBxdl(String bxdl) {
        this.bxdl = bxdl == null ? null : bxdl.trim();
    }

    public String getCxdl() {
        return cxdl;
    }

    public void setCxdl(String cxdl) {
        this.cxdl = cxdl == null ? null : cxdl.trim();
    }

    public String getZyggl() {
        return zyggl;
    }

    public void setZyggl(String zyggl) {
        this.zyggl = zyggl == null ? null : zyggl.trim();
    }

    public String getAxyggl() {
        return axyggl;
    }

    public void setAxyggl(String axyggl) {
        this.axyggl = axyggl == null ? null : axyggl.trim();
    }

    public String getBxyggl() {
        return bxyggl;
    }

    public void setBxyggl(String bxyggl) {
        this.bxyggl = bxyggl == null ? null : bxyggl.trim();
    }

    public String getCxyggl() {
        return cxyggl;
    }

    public void setCxyggl(String cxyggl) {
        this.cxyggl = cxyggl == null ? null : cxyggl.trim();
    }

    public String getZwggl() {
        return zwggl;
    }

    public void setZwggl(String zwggl) {
        this.zwggl = zwggl == null ? null : zwggl.trim();
    }

    public String getAxwggl() {
        return axwggl;
    }

    public void setAxwggl(String axwggl) {
        this.axwggl = axwggl == null ? null : axwggl.trim();
    }

    public String getBxwggl() {
        return bxwggl;
    }

    public void setBxwggl(String bxwggl) {
        this.bxwggl = bxwggl == null ? null : bxwggl.trim();
    }

    public String getCxwggl() {
        return cxwggl;
    }

    public void setCxwggl(String cxwggl) {
        this.cxwggl = cxwggl == null ? null : cxwggl.trim();
    }

    public String getZglys() {
        return zglys;
    }

    public void setZglys(String zglys) {
        this.zglys = zglys == null ? null : zglys.trim();
    }

    public String getAxgglys() {
        return axgglys;
    }

    public void setAxgglys(String axgglys) {
        this.axgglys = axgglys == null ? null : axgglys.trim();
    }

    public String getBxgglys() {
        return bxgglys;
    }

    public void setBxgglys(String bxgglys) {
        this.bxgglys = bxgglys == null ? null : bxgglys.trim();
    }

    public String getCxgglys() {
        return cxgglys;
    }

    public void setCxgglys(String cxgglys) {
        this.cxgglys = cxgglys == null ? null : cxgglys.trim();
    }

    public String getZszgl() {
        return zszgl;
    }

    public void setZszgl(String zszgl) {
        this.zszgl = zszgl == null ? null : zszgl.trim();
    }

    public String getAxszgl() {
        return axszgl;
    }

    public void setAxszgl(String axszgl) {
        this.axszgl = axszgl == null ? null : axszgl.trim();
    }

    public String getBxszgl() {
        return bxszgl;
    }

    public void setBxszgl(String bxszgl) {
        this.bxszgl = bxszgl == null ? null : bxszgl.trim();
    }

    public String getCxszgl() {
        return cxszgl;
    }

    public void setCxszgl(String cxszgl) {
        this.cxszgl = cxszgl == null ? null : cxszgl.trim();
    }
}