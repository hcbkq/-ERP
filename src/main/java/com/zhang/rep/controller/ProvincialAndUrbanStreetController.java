package com.zhang.rep.controller;

import com.zhang.rep.entity.Area;
import com.zhang.rep.entity.City;
import com.zhang.rep.entity.Province;
import com.zhang.rep.entity.Street;
import com.zhang.rep.service.IProvincialAndUrbanStreetsService;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ProvincialAndUrbanStreet")
public class ProvincialAndUrbanStreetController extends BaseController {

    @Autowired
    private IProvincialAndUrbanStreetsService iProvincialAndUrbanStreetsService;

    @RequestMapping("/getByProvince")
    public JsonResult<List<Province>> getByProvince() {
        List<Province> data = iProvincialAndUrbanStreetsService.findByProvince();
        return new JsonResult<>(ok, data);
    }

    @RequestMapping("/getByCity")
    public JsonResult<List<City>> getByCity(String provinceCode) {
        List<City> data = iProvincialAndUrbanStreetsService.findByCity(provinceCode);
        return new JsonResult<>(ok, data);
    }

    @RequestMapping("/getByArea")
    public JsonResult<List<Area>> getByArea(String cityCode){
        List<Area> data = iProvincialAndUrbanStreetsService.findByArea(cityCode);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("/getByStreet")
    public JsonResult<List<Street>> getByStreet(String areaCode){
        List<Street> data = iProvincialAndUrbanStreetsService.findByStreet(areaCode);
        return new JsonResult<>(ok,data);
    }
}
