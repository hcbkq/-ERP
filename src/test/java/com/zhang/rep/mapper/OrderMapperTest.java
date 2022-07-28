package com.zhang.rep.mapper;

import com.zhang.rep.entity.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void getByOrders(){
        List<Order> list = orderMapper.getByOrders();
        System.out.println(list);
    }

//    @Test
//    public void insert(){
//        Order order = new Order();
//        order.setCid("2020000213");
//        order.setIdentifierId("20200123100213");
//        order.setOrderProduct("君を想う");
//        order.setOrderDate(new Date());
////        order.setDeliveryDate(new Date(2022, Calendar.JUNE,21,13,20,21));
//        order.setOrderCustomer("何尝不可求");
//        order.setOrderQuantity(1000);
//        order.setMoney(2000);
//        orderMapper.insert(order);
//    }
    @Test
    public void countByUid(){
        Integer integer = orderMapper.countByCid("220214064708");
        System.out.println(integer);
    }


    @Test
    public void findByCid(){
        List<Order> list = orderMapper.findByCid("220214064708");
        System.out.println(list);
    }

    @Test
    public void updateNotesDocuments(){
        Integer integer = orderMapper.updateNotesDocuments("aini", "6396220214064708");
        System.out.println(integer);
    }

    @Test
    public void test(){
        List<Order> byOrders = orderMapper.findByOrders(null, null, null,
                null, null, null, null, null, 0,0);
        System.out.println(byOrders);
    }
}
