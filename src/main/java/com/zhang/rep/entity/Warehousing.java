package com.zhang.rep.entity;

import java.util.Date;
import java.util.Objects;

public class Warehousing {
    private Integer wid;
    private String documentNumber;
    private String documentType;
    private String uniqueIdentifier;
    private String productName;
    private String specification;
    private String productType;
    private String company;
    private Integer quantity;
    private Integer InAndOut;
    private Integer implement;
    private String remarks;
    private String createdUser;
    private Date createdTime;

    @Override
    public String toString() {
        return "Warehousing{" +
                "wid=" + wid +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentType='" + documentType + '\'' +
                ", uniqueIdentifier='" + uniqueIdentifier + '\'' +
                ", productName='" + productName + '\'' +
                ", specification='" + specification + '\'' +
                ", productType='" + productType + '\'' +
                ", company='" + company + '\'' +
                ", quantity=" + quantity +
                ", InAndOut=" + InAndOut +
                ", implement=" + implement +
                ", remarks='" + remarks + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehousing that = (Warehousing) o;
        return Objects.equals(wid, that.wid) && Objects.equals(documentNumber, that.documentNumber) && Objects.equals(documentType, that.documentType) && Objects.equals(uniqueIdentifier, that.uniqueIdentifier) && Objects.equals(productName, that.productName) && Objects.equals(specification, that.specification) && Objects.equals(productType, that.productType) && Objects.equals(company, that.company) && Objects.equals(quantity, that.quantity) && Objects.equals(InAndOut, that.InAndOut) && Objects.equals(implement, that.implement) && Objects.equals(remarks, that.remarks) && Objects.equals(createdUser, that.createdUser) && Objects.equals(createdTime, that.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wid, documentNumber, documentType, uniqueIdentifier, productName, specification, productType, company, quantity, InAndOut, implement, remarks, createdUser, createdTime);
    }

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(String uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getInAndOut() {
        return InAndOut;
    }

    public void setInAndOut(Integer inAndOut) {
        InAndOut = inAndOut;
    }

    public Integer getImplement() {
        return implement;
    }

    public void setImplement(Integer implement) {
        this.implement = implement;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
