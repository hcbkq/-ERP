package com.zhang.rep.controller;

import com.zhang.rep.service.IHeadService;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("head")
public class HeadController extends BaseController{
    @Autowired
    private IHeadService headService;


    @RequestMapping("todayAndMonth")
    public JsonResult<Map<String, Integer>> todayAndMonth(){
        Map<String, Integer> stringIntegerMap = headService.todayAndMonth();
        return new JsonResult<>(ok,stringIntegerMap);
    }

    @RequestMapping("noCompletionAndReview")
    public JsonResult<Map<String, Integer>> noCompletionAndReview(){
        Map<String, Integer> stringIntegerMap = headService.NoCompletionAndReview();
        return new JsonResult<>(ok,stringIntegerMap);
    }

    @RequestMapping("monthRevenueAndExpenditureAndNetProfit")
    public JsonResult<Map<String, BigDecimal>> monthRevenueAndExpenditureAndNetProfit(){
        Map<String, BigDecimal> monthRevenueAndExpenditureAndNetProfit
                = headService.monthRevenueAndExpenditureAndNetProfit();

        return new JsonResult<>(ok,monthRevenueAndExpenditureAndNetProfit);

    }

    @RequestMapping("viewData")
    public JsonResult<ArrayList<Object>> viewData(){
        List<Map<Integer, Integer>> maps = headService.monthOrder();
//        List<List<Map<BigDecimal, Integer>>> data = headService.monthRevenueAndExpenditure();
        List<List<Map<BigDecimal, Integer>>> data = headService.monthRevenueAndExpenditure();
        ArrayList<Object> list = new ArrayList<>();;
        list.add(maps);
        list.add(data.get(0));
        list.add(data.get(1));

        return new JsonResult<>(ok,list);
    }
}
