package com.zhang.rep.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 省级
 */
public class Province {

    private String provinceCode;
    private String provinceName;
    private String shortName;
    private String lng;
    private String lat;
    private Integer sort;

    //创建人
    private Date gmtCreate;
    //创建时间
    private Date gmtModified;
    private String memo;
    private String dataState;
    private String tenantCode;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Province province = (Province) o;
        return Objects.equals(provinceCode, province.provinceCode) && Objects.equals(provinceName, province.provinceName) && Objects.equals(shortName, province.shortName) && Objects.equals(lng, province.lng) && Objects.equals(lat, province.lat) && Objects.equals(sort, province.sort) && Objects.equals(gmtCreate, province.gmtCreate) && Objects.equals(gmtModified, province.gmtModified) && Objects.equals(memo, province.memo) && Objects.equals(dataState, province.dataState) && Objects.equals(tenantCode, province.tenantCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(provinceCode, provinceName, shortName, lng, lat, sort, gmtCreate, gmtModified, memo, dataState, tenantCode);
    }

    @Override
    public String toString() {
        return "Province{" +
                "provinceCode='" + provinceCode + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", sort=" + sort +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", memo='" + memo + '\'' +
                ", dataState='" + dataState + '\'' +
                ", tenantCode='" + tenantCode + '\'' +
                '}';
    }
}
