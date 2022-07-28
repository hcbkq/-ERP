package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Area;
import com.zhang.rep.entity.City;
import com.zhang.rep.entity.Province;
import com.zhang.rep.entity.Street;
import com.zhang.rep.mapper.ProvincialAndUrbanStreetsMapper;
import com.zhang.rep.service.IProvincialAndUrbanStreetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvincialAndUrbanStreetsServiceImpl implements IProvincialAndUrbanStreetsService {

    @Autowired
    private ProvincialAndUrbanStreetsMapper provincialAndUrbanStreetsMapper;


    @Override
    public List<Province> findByProvince() {
        List<Province> list = provincialAndUrbanStreetsMapper.findByProvince();
        for (Province province : list) {
            province.setLat("null");
            province.setLng("null");
            province.setMemo("null");
            province.setTenantCode("null");
        }
        return list;
    }

    @Override
    public List<City> findByCity(String provinceCode) {
        List<City> list = provincialAndUrbanStreetsMapper.findByCity(provinceCode);
        for (City city : list) {
            city.setLat("null");
            city.setLng("null");
            city.setMemo("null");
            city.setTenantCode("null");
        }
        return list;
    }

    @Override
    public List<Area> findByArea(String cityCode) {
        List<Area> list = provincialAndUrbanStreetsMapper.findByArea(cityCode);
        for (Area area : list) {
            area.setLat("null");
            area.setLng("null");
            area.setMemo("null");
            area.setTenantCode("null");
        }
        return list;
    }

    @Override
    public List<Street> findByStreet(String areaCode) {
        List<Street> list = provincialAndUrbanStreetsMapper.findByStreet(areaCode);
        for (Street street : list) {
            street.setLat("null");
            street.setLng("null");
            street.setMemo("null");
        }
        return list;
    }
}
