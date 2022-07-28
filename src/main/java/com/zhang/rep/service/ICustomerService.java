package com.zhang.rep.service;

import com.zhang.rep.entity.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;

public interface ICustomerService {

    List<Customer> getByCustomer();

    void customerNewCustomer(Customer customer, Integer uid, String username);

    List<Customer> findByCustomers(@Param("id") Integer id, @Param("cid") String cid,
                                   @Param("username") String username,
                                   @Param("provinceName") String provinceName,
                                   @Param("provinceCode") String provinceCode,
                                   @Param("cityName") String cityName,
                                   @Param("cityCode") String cityCode,
                                   @Param("areaName") String areaName,
                                   @Param("areaCode") String areaCode,
                                   @Param("order") Integer order,
                                   @Param("createdUser") String createdUser,
                                   @Param("modifiedUser") String modifiedUser,
                                   Integer page);

    void deleteCustomer(String cid,Integer uid, String username);

    void updateCustomer(Customer customer, Integer uid, String username);

    void updateCustomerAvatar(Integer uid,String username,String cid,String avatar);

    Integer calCustomerCount();

    ArrayList<Object> findCustomerList(Integer pageNo);

}
