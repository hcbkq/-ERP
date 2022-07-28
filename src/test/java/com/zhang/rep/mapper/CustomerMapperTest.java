package com.zhang.rep.mapper;

import com.zhang.rep.entity.Customer;
import com.zhang.rep.service.impl.hE.HelpEncapsulatingImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class CustomerMapperTest {

    @Autowired
    private CustomerMapper customerMapper;

    @Test
    public void getByCustomer(){
        List<Customer> byCustomer = customerMapper.getByCustomer();
        System.out.println(byCustomer);
    }

    @Test
    public void Insert(){
        Customer customer = new Customer();
        customer.setUsername("张三");
        customer.setCid("31231231");

//        System.out.println(customer);
        customerMapper.insert(customer);
    }

    @Test
    public void findByCustomer(){
        Customer byCustomer = customerMapper.findByCustomer("220214062444");
        System.out.println(byCustomer);
    }

    @Test
    public void countByTotal(){
        Integer integer = customerMapper.countByTotal();
        System.out.println(integer);


    }

    @Test
    public void deleteCustomer(){
        Integer integer = customerMapper.deleteCustomer("220214062444");
        System.out.println(integer);
    }

    @Test
    public void findByCustomers(){
        List<Customer> byCustomers = customerMapper.findByCustomers(null, null,"王",
                null,null,null,
                null,null,null,null,null,null,0);

    }

    @Test
    public void updateCustomer(){

        Customer customer = new Customer();
        customer.setCid("8633");
        customer.setEmail("521231231231231");
        Integer integer = customerMapper.updateCustomer(customer);
        System.out.println(integer);
    }

    @Test
    public void updateCustomerAvatar(){

        Integer row = customerMapper.updateCustomerAvatar("220219093303", "im.jpg", "test1", new Date());
        System.out.println(row);
    }


    @Test
    public void test(){
        Date date = new Date();
        long time = date.getTime();
        String timeID = String.valueOf(time);
        String identifierId = "220405024921" + timeID.substring(timeID.length() - 4);

        System.out.println(identifierId);
    }
}
