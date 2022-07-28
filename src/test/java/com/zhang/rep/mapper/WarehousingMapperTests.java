package com.zhang.rep.mapper;

import com.zhang.rep.entity.Warehousing;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class WarehousingMapperTests {

    @Autowired
    private WarehousingMapper warehousingMapper;


    @Test
    public void insert(){
        Warehousing warehousing = new Warehousing();
        Date date = new Date();
        warehousing.setDocumentType("入库");
        warehousing.setProductType("F");
        long time = date.getTime();
        String s = warehousing.getProductType() + time;
        warehousing.setDocumentNumber(s);
        warehousing.setProductName("冰箱");
        warehousing.setUniqueIdentifier("F802887310001");
        warehousing.setSpecification("m-12-7-5-16-kg");
        warehousing.setCompany("kg");
        warehousing.setQuantity(50);
        warehousing.setInAndOut(0);
        warehousing.setCreatedTime(date);
        warehousing.setCreatedUser("HCBKQ");
        warehousingMapper.insert(warehousing);
    }

    @Test
    public void select(){
//        List<Warehousing> list = warehousingMapper.select("F1649770902360", null, null, "箱", null);
//        System.out.println(list);
    }


    @Test
    public void delete(){
        List<String> list = new ArrayList<>();
        list.add("F1649770996645");
        Integer integer = warehousingMapper.delete(list);
        System.out.println(integer);
    }

    @Test
    public void update(){
        Integer update = warehousingMapper.update("没问题",null, "F1649770902360");
        System.out.println(update);
    }
}
