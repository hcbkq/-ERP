package com.zhang.rep.service;

import com.zhang.rep.entity.Customer;
import com.zhang.rep.entity.hp.PageInformation;
import com.zhang.rep.service.impl.CustomerServiceImpl;

import org.apache.poi.ss.formula.functions.T;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerServiceTests {

    @Autowired
    private CustomerServiceImpl customerService;


    @Test
    void getByCustomer() {
        List<Customer> customer = customerService.getByCustomer();
        System.out.println(customer);
    }

//    @Test
//    void  customerNewCustomer(){
//        Customer customer = new Customer();
//        customer.setUsername("何尝不可求");
//        customer.setProvinceCode("420000");
//        customer.setCityCode("421000");
//        customer.setAreaCode("421024");
//        customerService.customerNewCustomer(customer,12,"test1");
//
//
//    }

    @Test
    void deleteCustomer(){
        customerService.deleteCustomer("31231231",12,"test1");
    }

    @Test
    void updateCustomer(){

        Customer customer = new Customer();
        customer.setCid("220219093303");
        customer.setAge(17);
        customer.setEmail("522780940@qq.com");
        customerService.updateCustomer(customer,1,"zhangsan");
    }

    @Test
    void updateIFOrderByCid(){
        List<Customer> byCustomers = customerService.findByCustomers(null, null, null, null, null, null,
                null, null, null, 1, null, null,null);
        System.out.println(byCustomers);
    }

    @Test
    void  tests(){
        Integer PAGING_SIZE = 8;
        Integer pageNo = 1;
        Integer count = 7;
        PageInformation pageInformation = new PageInformation();


        if (pageNo == null) {
            pageNo = 1;
        }

        Integer pageCount = count % PAGING_SIZE == 0 ? count / PAGING_SIZE : count / PAGING_SIZE + 1;
        if (pageNo > pageCount || pageNo < 1){
            pageNo=1;
        }

        pageNo = (pageNo - 1) * PAGING_SIZE;
        pageInformation.setLibraryPageNo(pageNo);
        pageInformation.setDisplayPageNo(pageNo/PAGING_SIZE+1);
        pageInformation.setPageCount(pageCount);

//        List<T> customerList = customerService.findCustomerList(pageInformation.getLibraryPageNo());
//        pageInformation.setList(customerList);
//        System.out.println(pageInformation);
    }
}
