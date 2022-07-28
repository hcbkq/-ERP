package com.zhang.rep.entity;

import java.io.Serializable;
import java.util.Objects;

//客户数据实体类
public class Customer extends BaseEntity implements Serializable {
    private Integer id;
    //定义的客户id
    private String cid;
    private String username;
    private String provinceName;
    private String provinceCode;
    private String cityName;
    private String cityCode;
    private String areaName;
    private String areaCode;
    private String zip;
    private String address;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private String handler;
    private Integer associated;;
    private String documentType;
    private String identification;
    private Integer age;
    private Integer order;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", username='" + username + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", provinceCode='" + provinceCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", handler='" + handler + '\'' +
                ", associated=" + associated +
                ", documentType='" + documentType + '\'' +
                ", identification='" + identification + '\'' +
                ", age=" + age +
                ", order=" + order +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(cid, customer.cid) && Objects.equals(username, customer.username) && Objects.equals(provinceName, customer.provinceName) && Objects.equals(provinceCode, customer.provinceCode) && Objects.equals(cityName, customer.cityName) && Objects.equals(cityCode, customer.cityCode) && Objects.equals(areaName, customer.areaName) && Objects.equals(areaCode, customer.areaCode) && Objects.equals(zip, customer.zip) && Objects.equals(address, customer.address) && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email) && Objects.equals(gender, customer.gender) && Objects.equals(avatar, customer.avatar) && Objects.equals(handler, customer.handler) && Objects.equals(associated, customer.associated) && Objects.equals(documentType, customer.documentType) && Objects.equals(identification, customer.identification) && Objects.equals(age, customer.age) && Objects.equals(order, customer.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cid, username, provinceName, provinceCode, cityName, cityCode, areaName, areaCode, zip, address, phone, email, gender, avatar, handler, associated, documentType, identification, age, order);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
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

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Integer getAssociated() {
        return associated;
    }

    public void setAssociated(Integer associated) {
        this.associated = associated;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
