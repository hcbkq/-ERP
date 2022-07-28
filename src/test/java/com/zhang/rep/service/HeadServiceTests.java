package com.zhang.rep.service;

import com.zhang.rep.mapper.OrderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class HeadServiceTests {

    @Autowired
    private IHeadService headService;

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void Test() {

        List<List<Map<BigDecimal, Integer>>> lists = headService.monthRevenueAndExpenditure();
        System.out.println(lists);
    }
}
