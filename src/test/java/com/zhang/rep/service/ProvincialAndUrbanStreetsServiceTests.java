package com.zhang.rep.service;

import com.zhang.rep.entity.Area;
import com.zhang.rep.entity.City;
import com.zhang.rep.entity.Province;
import com.zhang.rep.service.impl.ProvincialAndUrbanStreetsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProvincialAndUrbanStreetsServiceTests {

    @Autowired
    private ProvincialAndUrbanStreetsServiceImpl provincialAndUrbanStreetsService;

    @Test
    public void findByProvince(){
        List<Province> list = provincialAndUrbanStreetsService.findByProvince();
        for (Province province : list) {
            System.out.println(province);
        }
    }

    @Test
    public void findByCity(){
        List<City> list = provincialAndUrbanStreetsService.findByCity("420000");
        for (City city : list) {
            System.out.println(city);
        }
    }

    @Test
    public void findByArea(){
        List<Area> area = provincialAndUrbanStreetsService.findByArea("421000");
        for (Area area1 : area) {
            System.out.println(area1);
        }
    }
}
