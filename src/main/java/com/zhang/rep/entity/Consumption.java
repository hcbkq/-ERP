package com.zhang.rep.entity;

import java.util.Objects;

public class Consumption {
    private Integer id;
    private String productionId;
    private String productId;
    private String productName;
    private String mid;
    private String name;
    private Integer quantity;
    private String remarks;

    @Override
    public String toString() {
        return "Consumption{" +
                "id=" + id +
                ", productionId='" + productionId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", mid='" + mid + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consumption that = (Consumption) o;
        return Objects.equals(id, that.id) && Objects.equals(productionId, that.productionId) && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(mid, that.mid) && Objects.equals(name, that.name) && Objects.equals(quantity, that.quantity) && Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productionId, productId, productName, mid, name, quantity, remarks);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
