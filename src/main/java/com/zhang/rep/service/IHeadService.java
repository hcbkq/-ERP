package com.zhang.rep.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IHeadService {
    /**
     * today: 今天
     * month： 月
     * @return 返回今日和本月度完成订单量
     */
    Map<String, Integer> todayAndMonth();

    /**
     * NoCompletion：未完成的订单量
     * Review：待审核订单量
     * @return 返回未完成的订单量和待审核的订单量
     */
    Map<String, Integer> NoCompletionAndReview();

    /**
     *
     * @return 返回本月收入支出和纯利润
     */
    Map<String, BigDecimal> monthRevenueAndExpenditureAndNetProfit();

    /**
     *
     * @return 返回近六个月的每月的订单数
     */
    List<Map<Integer, Integer>> monthOrder();

    /**
     *
     * @return 返回 近六个月每月的收入或者支出；
     */
    List<List<Map<BigDecimal, Integer>>> monthRevenueAndExpenditure();
}
