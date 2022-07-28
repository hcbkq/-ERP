package com.zhang.rep.controller;

import com.zhang.rep.entity.Production;
import com.zhang.rep.service.IProductionService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("production")
public class ProductionController extends BaseController{

    @Autowired
    private IProductionService productionService;

    @Autowired
    private GlobalSession globalSession;


    @RequestMapping("addProduction")
    public JsonResult<Void> addProduction(Production production, HttpSession session){
        productionService.addProduction(production,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }

    @RequestMapping("getProduction")
    public JsonResult<List<Production>> getProduction(String productionId,
                                                      Date startOrderDate,Date endOrderDate,
                                                      Date startDeliveryDate,Date endDeliveryDate,
                                                      String productId,String productName,
                                                      String documentNumber,String preparer,
                                                      Integer complete,Integer examine,Integer pageNo){
        System.out.println(productionId);
        List<Production> data = productionService.getProduction(productionId, startOrderDate, endOrderDate,startDeliveryDate,endDeliveryDate, productId, productName,
                documentNumber, preparer, complete, examine,pageNo);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("changeProduction")
    public JsonResult<Void> changeProduction(Production production,
                                             HttpSession session){
        productionService.changeProduction(production,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }

    @RequestMapping("deleteProduction")
    public JsonResult<Void> deleteProduction(List<String> productionId,HttpSession session){
        productionService.deleteProduction(productionId,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }
}
