package com.zhang.rep.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 街道实体类
 */
public class Street {
    private String streetCode;
    private String areaCode;
    private String streetName;
    private String shortName;
    private String lng;
    private String lat;
    private Integer sort ;
    private Date gmtCreate;
    private Date gmtModified;
    private String memo;
    private Integer dataState;
    private String tenant;

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Street street = (Street) o;
        return Objects.equals(streetCode, street.streetCode) && Objects.equals(areaCode, street.areaCode) && Objects.equals(streetName, street.streetName) && Objects.equals(shortName, street.shortName) && Objects.equals(lng, street.lng) && Objects.equals(lat, street.lat) && Objects.equals(sort, street.sort) && Objects.equals(gmtCreate, street.gmtCreate) && Objects.equals(gmtModified, street.gmtModified) && Objects.equals(memo, street.memo) && Objects.equals(dataState, street.dataState) && Objects.equals(tenant, street.tenant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetCode, areaCode, streetName, shortName, lng, lat, sort, gmtCreate, gmtModified, memo, dataState, tenant);
    }

    @Override
    public String toString() {
        return "street{" +
                "streetCode='" + streetCode + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", sort=" + sort +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", memo='" + memo + '\'' +
                ", dataState=" + dataState +
                ", tenant='" + tenant + '\'' +
                '}';
    }
}
