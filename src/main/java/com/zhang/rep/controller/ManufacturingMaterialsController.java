package com.zhang.rep.controller;


import com.zhang.rep.entity.ManufacturingMaterials;
import com.zhang.rep.service.IManufacturingMaterialsService;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("manufacturingMaterials")
public class ManufacturingMaterialsController extends BaseController{

    @Autowired
    private IManufacturingMaterialsService manufacturingMaterialsService;



    @RequestMapping("addManufacturingMaterials")
    public JsonResult<Void> addManufacturingMaterials(List<ManufacturingMaterials> manufacturingMaterials,
                                                      HttpSession session){
        manufacturingMaterialsService.addManufacturingMaterials(manufacturingMaterials,
                getuidFormSession(session),getUsernameFromSession(session));

        return new JsonResult<>(ok);
    }

    @RequestMapping("getManufacturingMaterials")
    public JsonResult<List<ManufacturingMaterials>> getManufacturingMaterials(String productId,
                                                      String productName){
        List<ManufacturingMaterials> manufacturingMaterials = manufacturingMaterialsService.getManufacturingMaterials(productId, productName);

        return new JsonResult<>(ok,manufacturingMaterials);
    }

    @RequestMapping("changeManufacturingMaterials")
    public JsonResult<Void> changeManufacturingMaterials(Integer quantity,String remarks,String productId,String mid,
                                                         HttpSession session){
        manufacturingMaterialsService.changeManufacturingMaterials(quantity,remarks,productId,mid,
                getuidFormSession(session),getUsernameFromSession(session));

        return new JsonResult<>(ok);

    }

    @RequestMapping("deleteManufacturingMaterials")
    public JsonResult<Void> deleteManufacturingMaterials(String productId,String mid,
                                                         HttpSession session){
        manufacturingMaterialsService.deleteManufacturingMaterials(productId,mid,
                getuidFormSession(session),getUsernameFromSession(session));

        return new JsonResult<>(ok);
    }

}
