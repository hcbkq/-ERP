package com.zhang.rep.entity;

import java.util.Objects;

public class Warehouse {
    private Integer kid;
    private String goodsId;
    private String goodsName;
    private Integer quantity;
    private Integer maxQuantity;
    private String company;
    private Integer productsOrMaterials;
    private Integer ifDelete;
    private String remarks;

    @Override
    public String toString() {
        return "Warehouse{" +
                "kid=" + kid +
                ", goodsId='" + goodsId + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", quantity=" + quantity +
                ", maxQuantity=" + maxQuantity +
                ", company='" + company + '\'' +
                ", productsOrMaterials=" + productsOrMaterials +
                ", ifDelete=" + ifDelete +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(kid, warehouse.kid) && Objects.equals(goodsId, warehouse.goodsId) && Objects.equals(goodsName, warehouse.goodsName) && Objects.equals(quantity, warehouse.quantity) && Objects.equals(maxQuantity, warehouse.maxQuantity) && Objects.equals(company, warehouse.company) && Objects.equals(productsOrMaterials, warehouse.productsOrMaterials) && Objects.equals(ifDelete, warehouse.ifDelete) && Objects.equals(remarks, warehouse.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kid, goodsId, goodsName, quantity, maxQuantity, company, productsOrMaterials, ifDelete, remarks);
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Integer maxQuantity) {
        this.maxQuantity = maxQuantity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getProductsOrMaterials() {
        return productsOrMaterials;
    }

    public void setProductsOrMaterials(Integer productsOrMaterials) {
        this.productsOrMaterials = productsOrMaterials;
    }

    public Integer getIfDelete() {
        return ifDelete;
    }

    public void setIfDelete(Integer ifDelete) {
        this.ifDelete = ifDelete;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
