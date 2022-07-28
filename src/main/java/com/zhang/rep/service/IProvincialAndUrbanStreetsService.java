package com.zhang.rep.service;

import com.zhang.rep.entity.Area;
import com.zhang.rep.entity.City;
import com.zhang.rep.entity.Province;
import com.zhang.rep.entity.Street;

import java.util.List;

public interface IProvincialAndUrbanStreetsService {

    List<Province> findByProvince();

    List<City> findByCity(String provinceCode);

    List<Area> findByArea(String cityCode);

    List<Street> findByStreet(String areaCode);
}
