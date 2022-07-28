package com.zhang.rep.controller;

import com.zhang.rep.entity.Consumption;
import com.zhang.rep.service.IConsumptionService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("consumption")
public class ConsumptionController extends BaseController{

    @Autowired
    private IConsumptionService consumptionService;

    @Autowired
    private GlobalSession globalSession;


    @RequestMapping("getConsumption")
    public JsonResult<List<Consumption>> getConsumption(String productionId,
                                                        String productName){
        List<Consumption> data = consumptionService.getConsumption(productionId,productName);
        return new JsonResult<>(ok,data);
    }



}
