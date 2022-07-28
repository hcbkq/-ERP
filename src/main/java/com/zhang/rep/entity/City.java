package com.zhang.rep.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 市实体类
 */
public class City {
    private String cityCode;
    private String cityName;
    private String shortName;
    private String provinceCode;
    private String lng;
    private String lat;
    private Integer sort;
    private Date gmtCreate;
    private Date gmtModified;
    private String memo;
    private Integer dataState;
    private String tenantCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityCode, city.cityCode) && Objects.equals(cityName, city.cityName) && Objects.equals(shortName, city.shortName) && Objects.equals(provinceCode, city.provinceCode) && Objects.equals(lng, city.lng) && Objects.equals(lat, city.lat) && Objects.equals(sort, city.sort) && Objects.equals(gmtCreate, city.gmtCreate) && Objects.equals(gmtModified, city.gmtModified) && Objects.equals(memo, city.memo) && Objects.equals(dataState, city.dataState) && Objects.equals(tenantCode, city.tenantCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityCode, cityName, shortName, provinceCode, lng, lat, sort, gmtCreate, gmtModified, memo, dataState, tenantCode);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityCode='" + cityCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
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
}
