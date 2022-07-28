package com.zhang.rep.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Material extends BaseEntity {
    private Integer id;
    private String mid;
    private String label;
    private String name;
    private String unit;
    private BigDecimal purchase;
    private Integer materialStatus;
    private Integer storageTemperature;
    private Integer storageMode;
    private Integer ifFlammable;
    private Integer ifPoisonous;
    private String remarks;

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", mid='" + mid + '\'' +
                ", label='" + label + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", purchase=" + purchase +
                ", materialStatus=" + materialStatus +
                ", storageTemperature=" + storageTemperature +
                ", storageMode=" + storageMode +
                ", ifFlammable=" + ifFlammable +
                ", ifPoisonous=" + ifPoisonous +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id) && Objects.equals(mid, material.mid) && Objects.equals(label, material.label) && Objects.equals(name, material.name) && Objects.equals(unit, material.unit) && Objects.equals(purchase, material.purchase) && Objects.equals(materialStatus, material.materialStatus) && Objects.equals(storageTemperature, material.storageTemperature) && Objects.equals(storageMode, material.storageMode) && Objects.equals(ifFlammable, material.ifFlammable) && Objects.equals(ifPoisonous, material.ifPoisonous) && Objects.equals(remarks, material.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mid, label, name, unit, purchase, materialStatus, storageTemperature, storageMode, ifFlammable, ifPoisonous, remarks);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getPurchase() {
        return purchase;
    }

    public void setPurchase(BigDecimal purchase) {
        this.purchase = purchase;
    }

    public Integer getMaterialStatus() {
        return materialStatus;
    }

    public void setMaterialStatus(Integer materialStatus) {
        this.materialStatus = materialStatus;
    }

    public Integer getStorageTemperature() {
        return storageTemperature;
    }

    public void setStorageTemperature(Integer storageTemperature) {
        this.storageTemperature = storageTemperature;
    }

    public Integer getStorageMode() {
        return storageMode;
    }

    public void setStorageMode(Integer storageMode) {
        this.storageMode = storageMode;
    }

    public Integer getIfFlammable() {
        return ifFlammable;
    }

    public void setIfFlammable(Integer ifFlammable) {
        this.ifFlammable = ifFlammable;
    }

    public Integer getIfPoisonous() {
        return ifPoisonous;
    }

    public void setIfPoisonous(Integer ifPoisonous) {
        this.ifPoisonous = ifPoisonous;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
