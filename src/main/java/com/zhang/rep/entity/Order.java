package com.zhang.rep.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

public class Order {

    private Integer oid;
    private String cid;
    private String identifierId;
    private String orderProduct;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deliveryDate;
    private String orderCustomer;
    private Integer orderQuantity;
    private Integer money;
    private String reviewer;
    private Integer statement;
    private String notesDocuments;

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", cid='" + cid + '\'' +
                ", identifierId='" + identifierId + '\'' +
                ", orderProduct='" + orderProduct + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", orderCustomer='" + orderCustomer + '\'' +
                ", orderQuantity=" + orderQuantity +
                ", money=" + money +
                ", reviewer='" + reviewer + '\'' +
                ", statement=" + statement +
                ", notesDocuments='" + notesDocuments + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(oid, order.oid) && Objects.equals(cid, order.cid) && Objects.equals(identifierId, order.identifierId) && Objects.equals(orderProduct, order.orderProduct) && Objects.equals(orderDate, order.orderDate) && Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(orderCustomer, order.orderCustomer) && Objects.equals(orderQuantity, order.orderQuantity) && Objects.equals(money, order.money) && Objects.equals(reviewer, order.reviewer) && Objects.equals(statement, order.statement) && Objects.equals(notesDocuments, order.notesDocuments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, cid, identifierId, orderProduct, orderDate, deliveryDate, orderCustomer, orderQuantity, money, reviewer, statement, notesDocuments);
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getIdentifierId() {
        return identifierId;
    }

    public void setIdentifierId(String identifierId) {
        this.identifierId = identifierId;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderCustomer() {
        return orderCustomer;
    }

    public void setOrderCustomer(String orderCustomer) {
        this.orderCustomer = orderCustomer;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public Integer getStatement() {
        return statement;
    }

    public void setStatement(Integer statement) {
        this.statement = statement;
    }

    public String getNotesDocuments() {
        return notesDocuments;
    }

    public void setNotesDocuments(String notesDocuments) {
        this.notesDocuments = notesDocuments;
    }
}
