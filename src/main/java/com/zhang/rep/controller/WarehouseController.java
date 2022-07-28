package com.zhang.rep.controller;

import com.zhang.rep.entity.Warehouse;
import com.zhang.rep.service.IWarehouseService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("warehouse")
public class WarehouseController extends BaseController {

    @Autowired
    private IWarehouseService warehouseService;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping("getByWarehouses")
    public JsonResult<List<Warehouse>> getByWarehouses(Integer kid,
                                                       String goodsId,
                                                       String goodsName,
                                                       Integer productsOrMaterials,
                                                       Integer pageNo) {
        List<Warehouse> data = warehouseService.getByWarehouses(kid, goodsId, goodsName, productsOrMaterials,pageNo);

        return new JsonResult<>(ok,data);
    }

    @RequestMapping("deleteWarehouse")
    public JsonResult<Void> deleteWarehouse(Integer kid, HttpSession httpSession){
        warehouseService.deleteWarehouse(kid,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }
    @RequestMapping("changeWarehouse")
    public JsonResult<Void> changeWarehouse(String goodsId,String remarks,HttpSession httpSession){
        warehouseService.changeWarehouse(goodsId,remarks,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }
}
