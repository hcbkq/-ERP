package com.zhang.rep.entity;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * 区实体类
 */
public class Area {
    private String areaCode;
    private String cityCode;
    private String areaName;
    private String shortName;
    private String lng;
    private String lat;
    private Integer sort;
    private Date gmtCreate;
    private Date gmtModified;
    private String memo;
    private Integer dataState;
    private String tenantCode;

    @Override
    public String toString() {
        return "Area{" +
                "areaCode='" + areaCode + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", sort=" + sort +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", memo='" + memo + '\'' +
                ", dataState=" + dataState +
                ", tenantCode='" + tenantCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(areaCode, area.areaCode) && Objects.equals(cityCode, area.cityCode) && Objects.equals(areaName, area.areaName) && Objects.equals(shortName, area.shortName) && Objects.equals(lng, area.lng) && Objects.equals(lat, area.lat) && Objects.equals(sort, area.sort) && Objects.equals(gmtCreate, area.gmtCreate) && Objects.equals(gmtModified, area.gmtModified) && Objects.equals(memo, area.memo) && Objects.equals(dataState, area.dataState) && Objects.equals(tenantCode, area.tenantCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, cityCode, areaName, shortName, lng, lat, sort, gmtCreate, gmtModified, memo, dataState, tenantCode);
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
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

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }
}
