package com.zhang.rep.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Account {
    private Integer aid;
    private String accountName;
    private String accountNumber;
    private String bankOfDeposit;
    private BigDecimal initialAmount;
    private BigDecimal existingBalance;
    private String remarks;
    private String createdUser;
    private Date createdTime;

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", accountName='" + accountName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankOfDeposit='" + bankOfDeposit + '\'' +
                ", initialAmount=" + initialAmount +
                ", existingBalance=" + existingBalance +
                ", remarks='" + remarks + '\'' +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(aid, account.aid) && Objects.equals(accountName, account.accountName) && Objects.equals(accountNumber, account.accountNumber) && Objects.equals(bankOfDeposit, account.bankOfDeposit) && Objects.equals(initialAmount, account.initialAmount) && Objects.equals(existingBalance, account.existingBalance) && Objects.equals(remarks, account.remarks) && Objects.equals(createdUser, account.createdUser) && Objects.equals(createdTime, account.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aid, accountName, accountNumber, bankOfDeposit, initialAmount, existingBalance, remarks, createdUser, createdTime);
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankOfDeposit() {
        return bankOfDeposit;
    }

    public void setBankOfDeposit(String bankOfDeposit) {
        this.bankOfDeposit = bankOfDeposit;
    }

    public BigDecimal getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BigDecimal initialAmount) {
        this.initialAmount = initialAmount;
    }

    public BigDecimal getExistingBalance() {
        return existingBalance;
    }

    public void setExistingBalance(BigDecimal existingBalance) {
        this.existingBalance = existingBalance;
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
