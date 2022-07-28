package com.zhang.rep.service.impl;

import com.zhang.rep.mapper.IncomeAndExpenditureMapper;
import com.zhang.rep.mapper.OrderMapper;
import com.zhang.rep.service.IHeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class HeadServiceImpl implements IHeadService {

    @Autowired
    private OrderMapper orderMapper;


    @Autowired
    private IncomeAndExpenditureMapper incomeAndExpenditureMapper;


    @Override
    public Map<String, Integer> todayAndMonth() {

        Map<String, Integer> todayAndMonth = new HashMap<>();

        Integer monthly = orderMapper.monthly();
        todayAndMonth.put("本月完成量",monthly);

        Integer toDay = orderMapper.toDay();
        todayAndMonth.put("本日完成量",toDay);

        return todayAndMonth;
    }

    @Override
    public Map<String, Integer> NoCompletionAndReview() {
        Map<String, Integer> noCompletionAndReview = new HashMap<>();
        Integer noCompletion = orderMapper.NoCompletion();
        noCompletionAndReview.put("未完成订单量",noCompletion);
        Integer review = orderMapper.Review();
        noCompletionAndReview.put("待审核订单量",review);

        return noCompletionAndReview;
    }

    @Override
    public Map<String, BigDecimal> monthRevenueAndExpenditureAndNetProfit() {
        Map<String, BigDecimal> monthRevenueAndExpenditureAndNetProfit = new HashMap<>();
        BigDecimal revenue = incomeAndExpenditureMapper.RevenueAndExpenditure(0);
        monthRevenueAndExpenditureAndNetProfit.put("月收入",revenue);
        BigDecimal expenditure = incomeAndExpenditureMapper.RevenueAndExpenditure(1);
        monthRevenueAndExpenditureAndNetProfit.put("月支出",expenditure);

        monthRevenueAndExpenditureAndNetProfit.put("月利润",revenue.subtract(expenditure));
        return monthRevenueAndExpenditureAndNetProfit;
    }

    @Override
    public List<Map<Integer, Integer>> monthOrder() {

        List<Map<Integer, Integer>> maps = orderMapper.monthOrder();

        return maps;
    }

    @Override
    public List<List<Map<BigDecimal, Integer>>> monthRevenueAndExpenditure() {
        List<List<Map<BigDecimal, Integer>>> date = new ArrayList<>();
        List<Map<BigDecimal, Integer>> revenue = incomeAndExpenditureMapper.monthRevenueAndExpenditure(0);
        date.add(revenue);
        List<Map<BigDecimal, Integer>> expenditure = incomeAndExpenditureMapper.monthRevenueAndExpenditure(1);
        System.out.println(expenditure);
        date.add(revenue);
        return date;
    }


}
