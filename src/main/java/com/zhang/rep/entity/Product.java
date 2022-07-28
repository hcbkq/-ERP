package com.zhang.rep.entity;

import java.math.BigDecimal;
import java.util.Objects;


/**
 * 产品实体类
 */
public class Product extends BaseEntity{
    private int pid;
    private String productId;
    private String avatar;
    private String productName;
    private String productType;
    private String company;
    private Integer workingProcedure;
    private BigDecimal lowestSelling;
    private BigDecimal recentPurchase;
    private BigDecimal recentBid;
    private BigDecimal specifyCost;
    private BigDecimal specifySales;
    private Integer minimumStock;
    private Integer maximumStock;
    //一长串关于原料的字符串（由原料id组成）
    private String rawMaterial;
    private String remarks;
    private Integer haltTheSales;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", productId='" + productId + '\'' +
                ", avatar='" + avatar + '\'' +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", company='" + company + '\'' +
                ", workingProcedure=" + workingProcedure +
                ", lowestSelling=" + lowestSelling +
                ", recentPurchase=" + recentPurchase +
                ", recentBid=" + recentBid +
                ", specifyCost=" + specifyCost +
                ", specifySales=" + specifySales +
                ", minimumStock=" + minimumStock +
                ", maximumStock=" + maximumStock +
                ", rawMaterial='" + rawMaterial + '\'' +
                ", remarks='" + remarks + '\'' +
                ", haltTheSales=" + haltTheSales +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return pid == product.pid && Objects.equals(productId, product.productId) && Objects.equals(avatar, product.avatar) && Objects.equals(productName, product.productName) && Objects.equals(productType, product.productType) && Objects.equals(company, product.company) && Objects.equals(workingProcedure, product.workingProcedure) && Objects.equals(lowestSelling, product.lowestSelling) && Objects.equals(recentPurchase, product.recentPurchase) && Objects.equals(recentBid, product.recentBid) && Objects.equals(specifyCost, product.specifyCost) && Objects.equals(specifySales, product.specifySales) && Objects.equals(minimumStock, product.minimumStock) && Objects.equals(maximumStock, product.maximumStock) && Objects.equals(rawMaterial, product.rawMaterial) && Objects.equals(remarks, product.remarks) && Objects.equals(haltTheSales, product.haltTheSales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, productId, avatar, productName, productType, company, workingProcedure, lowestSelling, recentPurchase, recentBid, specifyCost, specifySales, minimumStock, maximumStock, rawMaterial, remarks, haltTheSales);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public Integer getWorkingProcedure() {
        return workingProcedure;
    }

    public void setWorkingProcedure(Integer workingProcedure) {
        this.workingProcedure = workingProcedure;
    }

    public BigDecimal getLowestSelling() {
        return lowestSelling;
    }

    public void setLowestSelling(BigDecimal lowestSelling) {
        this.lowestSelling = lowestSelling;
    }

    public BigDecimal getRecentPurchase() {
        return recentPurchase;
    }

    public void setRecentPurchase(BigDecimal recentPurchase) {
        this.recentPurchase = recentPurchase;
    }

    public BigDecimal getRecentBid() {
        return recentBid;
    }

    public void setRecentBid(BigDecimal recentBid) {
        this.recentBid = recentBid;
    }

    public BigDecimal getSpecifyCost() {
        return specifyCost;
    }

    public void setSpecifyCost(BigDecimal specifyCost) {
        this.specifyCost = specifyCost;
    }

    public BigDecimal getSpecifySales() {
        return specifySales;
    }

    public void setSpecifySales(BigDecimal specifySales) {
        this.specifySales = specifySales;
    }

    public Integer getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(Integer minimumStock) {
        this.minimumStock = minimumStock;
    }

    public Integer getMaximumStock() {
        return maximumStock;
    }

    public void setMaximumStock(Integer maximumStock) {
        this.maximumStock = maximumStock;
    }

    public String getRawMaterial() {
        return rawMaterial;
    }

    public void setRawMaterial(String rawMaterial) {
        this.rawMaterial = rawMaterial;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getHaltTheSales() {
        return haltTheSales;
    }

    public void setHaltTheSales(Integer haltTheSales) {
        this.haltTheSales = haltTheSales;
    }
}
