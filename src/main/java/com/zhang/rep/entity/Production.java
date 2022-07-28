package com.zhang.rep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Production extends BaseEntity{
    private int pid;
    private String productionId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date expected;
    private String productId;
    private String productName;
    private String documentNumber;
    private Integer quantity;
    private String preparer;
    private String remarks;
    private Integer complete;
    private Integer examine;

    @Override
    public String toString() {
        return "Production{" +
                "pid=" + pid +
                ", productionId='" + productionId + '\'' +
                ", orderDate=" + orderDate +
                ", expected=" + expected +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", quantity=" + quantity +
                ", preparer='" + preparer + '\'' +
                ", remarks='" + remarks + '\'' +
                ", complete=" + complete +
                ", examine=" + examine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Production that = (Production) o;
        return pid == that.pid && Objects.equals(productionId, that.productionId) && Objects.equals(orderDate, that.orderDate) && Objects.equals(expected, that.expected) && Objects.equals(productId, that.productId) && Objects.equals(productName, that.productName) && Objects.equals(documentNumber, that.documentNumber) && Objects.equals(quantity, that.quantity) && Objects.equals(preparer, that.preparer) && Objects.equals(remarks, that.remarks) && Objects.equals(complete, that.complete) && Objects.equals(examine, that.examine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, productionId, orderDate, expected, productId, productName, documentNumber, quantity, preparer, remarks, complete, examine);
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductionId() {
        return productionId;
    }

    public void setProductionId(String productionId) {
        this.productionId = productionId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getExpected() {
        return expected;
    }

    public void setExpected(Date expected) {
        this.expected = expected;
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

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPreparer() {
        return preparer;
    }

    public void setPreparer(String preparer) {
        this.preparer = preparer;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }
}
