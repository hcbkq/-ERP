package com.zhang.rep.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class IncomeAndExpenditure {
    private Integer iid;
    private String voucher;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date occurrence;
    private String oppositeUnit;
    private String account;
    private Integer incomeOrExpenditure;
    private Integer classification;
    private BigDecimal amount;
    private Integer reviewer;
    private String remarks;
    private String created_user;
    private Date created_time;

    @Override
    public String toString() {
        return "IncomeAndExpenditure{" +
                "iid=" + iid +
                ", voucher='" + voucher + '\'' +
                ", occurrence=" + occurrence +
                ", oppositeUnit='" + oppositeUnit + '\'' +
                ", account='" + account + '\'' +
                ", incomeOrExpenditure=" + incomeOrExpenditure +
                ", classification=" + classification +
                ", amount=" + amount +
                ", reviewer=" + reviewer +
                ", remarks='" + remarks + '\'' +
                ", created_user='" + created_user + '\'' +
                ", created_time=" + created_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeAndExpenditure that = (IncomeAndExpenditure) o;
        return Objects.equals(iid, that.iid) && Objects.equals(voucher, that.voucher) && Objects.equals(occurrence, that.occurrence) && Objects.equals(oppositeUnit, that.oppositeUnit) && Objects.equals(account, that.account) && Objects.equals(incomeOrExpenditure, that.incomeOrExpenditure) && Objects.equals(classification, that.classification) && Objects.equals(amount, that.amount) && Objects.equals(reviewer, that.reviewer) && Objects.equals(remarks, that.remarks) && Objects.equals(created_user, that.created_user) && Objects.equals(created_time, that.created_time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iid, voucher, occurrence, oppositeUnit, account, incomeOrExpenditure, classification, amount, reviewer, remarks, created_user, created_time);
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Date getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(Date occurrence) {
        this.occurrence = occurrence;
    }

    public String getOppositeUnit() {
        return oppositeUnit;
    }

    public void setOppositeUnit(String oppositeUnit) {
        this.oppositeUnit = oppositeUnit;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getIncomeOrExpenditure() {
        return incomeOrExpenditure;
    }

    public void setIncomeOrExpenditure(Integer incomeOrExpenditure) {
        this.incomeOrExpenditure = incomeOrExpenditure;
    }

    public Integer getClassification() {
        return classification;
    }

    public void setClassification(Integer classification) {
        this.classification = classification;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Integer reviewer) {
        this.reviewer = reviewer;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreated_user() {
        return created_user;
    }

    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }
}
