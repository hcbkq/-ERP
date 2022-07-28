package com.zhang.rep.controller;

import com.zhang.rep.entity.Warehousing;
import com.zhang.rep.service.IWarehousingService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("warehousing")
public class WarehousingController extends BaseController{

    @Autowired
    private IWarehousingService warehousingService;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping("getByWarehousing")
    public JsonResult<List<Warehousing>> getByWarehousing(String documentNumber,
                                                          String documentType,
                                                          String uniqueIdentifier,
                                                          String productName,
                                                          Integer InAndOut,
                                                          Integer implement,
                                                          Integer pageNo){
        List<Warehousing> data = warehousingService.getByWarehousing(documentNumber, documentType, uniqueIdentifier,
                productName, InAndOut,implement,pageNo);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("addWarehousing")
    public JsonResult<Void> addWarehousing(Warehousing warehousing, Integer InAndOut, HttpSession session){
        warehousingService.addWarehousing(warehousing,
                InAndOut,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("changeWarehousing")
    public JsonResult<Void> changeWarehousing(String remarks,Integer implement,String documentNumber, HttpSession session){
        warehousingService.changeWarehousing(remarks,implement,documentNumber,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("deleteWarehousing")
    public JsonResult<Void> deleteWarehousing(List<String> documentNumber,HttpSession session){
        warehousingService.deleteWarehousing(documentNumber,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }
}
