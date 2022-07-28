package com.zhang.rep.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * 合同数据
 */
public class Contract extends BaseEntity {
    private Integer hid;
    private String customerCid;
    private String customerUsername;
    private String orderOid;
    private String orderProduct;
    private BigDecimal amountMoney;
    private BigDecimal firstMoney;
    private BigDecimal middleMoney;
    private BigDecimal balanceMoney;
    private BigDecimal myLiquidatedDamages;
    private BigDecimal customerLiquidatedDamages;
    private Integer orderCompletion;
    private String reviewer;

    @Override
    public String toString() {
        return "Contract{" +
                "hid=" + hid +
                ", customerCid='" + customerCid + '\'' +
                ", customerUsername='" + customerUsername + '\'' +
                ", orderOid='" + orderOid + '\'' +
                ", orderProduct='" + orderProduct + '\'' +
                ", amountMoney=" + amountMoney +
                ", firstMoney=" + firstMoney +
                ", middleMoney=" + middleMoney +
                ", balanceMoney=" + balanceMoney +
                ", myLiquidatedDamages=" + myLiquidatedDamages +
                ", customerLiquidatedDamages=" + customerLiquidatedDamages +
                ", orderCompletion=" + orderCompletion +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return Objects.equals(hid, contract.hid) && Objects.equals(customerCid, contract.customerCid) && Objects.equals(customerUsername, contract.customerUsername) && Objects.equals(orderOid, contract.orderOid) && Objects.equals(orderProduct, contract.orderProduct) && Objects.equals(amountMoney, contract.amountMoney) && Objects.equals(firstMoney, contract.firstMoney) && Objects.equals(middleMoney, contract.middleMoney) && Objects.equals(balanceMoney, contract.balanceMoney) && Objects.equals(myLiquidatedDamages, contract.myLiquidatedDamages) && Objects.equals(customerLiquidatedDamages, contract.customerLiquidatedDamages) && Objects.equals(orderCompletion, contract.orderCompletion) && Objects.equals(reviewer, contract.reviewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, customerCid, customerUsername, orderOid, orderProduct, amountMoney, firstMoney, middleMoney, balanceMoney, myLiquidatedDamages, customerLiquidatedDamages, orderCompletion, reviewer);
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getCustomerCid() {
        return customerCid;
    }

    public void setCustomerCid(String customerCid) {
        this.customerCid = customerCid;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getOrderOid() {
        return orderOid;
    }

    public void setOrderOid(String orderOid) {
        this.orderOid = orderOid;
    }

    public String getOrderProduct() {
        return orderProduct;
    }

    public void setOrderProduct(String orderProduct) {
        this.orderProduct = orderProduct;
    }

    public BigDecimal getAmountMoney() {
        return amountMoney;
    }

    public void setAmountMoney(BigDecimal amountMoney) {
        this.amountMoney = amountMoney;
    }

    public BigDecimal getFirstMoney() {
        return firstMoney;
    }

    public void setFirstMoney(BigDecimal firstMoney) {
        this.firstMoney = firstMoney;
    }

    public BigDecimal getMiddleMoney() {
        return middleMoney;
    }

    public void setMiddleMoney(BigDecimal middleMoney) {
        this.middleMoney = middleMoney;
    }

    public BigDecimal getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(BigDecimal balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    public BigDecimal getMyLiquidatedDamages() {
        return myLiquidatedDamages;
    }

    public void setMyLiquidatedDamages(BigDecimal myLiquidatedDamages) {
        this.myLiquidatedDamages = myLiquidatedDamages;
    }

    public BigDecimal getCustomerLiquidatedDamages() {
        return customerLiquidatedDamages;
    }

    public void setCustomerLiquidatedDamages(BigDecimal customerLiquidatedDamages) {
        this.customerLiquidatedDamages = customerLiquidatedDamages;
    }

    public Integer getOrderCompletion() {
        return orderCompletion;
    }

    public void setOrderCompletion(Integer orderCompletion) {
        this.orderCompletion = orderCompletion;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
