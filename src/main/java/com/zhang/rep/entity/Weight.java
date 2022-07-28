package com.zhang.rep.entity;

import java.util.Objects;

public class Weight {
    private Integer id;
    private String company;
    private String cName;

    @Override
    public String toString() {
        return "Weight{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", cName='" + cName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return Objects.equals(id, weight.id) && Objects.equals(company, weight.company) && Objects.equals(cName, weight.cName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, cName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
