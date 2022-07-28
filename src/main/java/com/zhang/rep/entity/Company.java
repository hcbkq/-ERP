package com.zhang.rep.entity;

import java.util.Objects;

public class Company {
    private Integer id;
    private String company;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", company='" + company + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company1 = (Company) o;
        return Objects.equals(id, company1.id) && Objects.equals(company, company1.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company);
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
}
