package com.zhang.rep.service;

import com.zhang.rep.entity.Order;
import com.zhang.rep.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderServiceTests {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void insert(){
        Order order = new Order();
        order.setOrderProduct("冰箱");
        order.setOrderDate(new Date());
        order.setDeliveryDate(new Date(2022, Calendar.JUNE,21,13,20,21));
        order.setOrderCustomer("何尝不可求");
        order.setOrderQuantity(1000);
        order.setMoney(2000);
        orderService.OrderNetOrder(order,"220414102610",12,"test1");
    }





}
