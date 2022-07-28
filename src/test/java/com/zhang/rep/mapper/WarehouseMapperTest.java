package com.zhang.rep.mapper;

import com.zhang.rep.entity.Warehouse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WarehouseMapperTest {

    @Autowired
    private WarehouseMapper warehouseMapper;

//    @Test
//    public void insert(){
//        Warehouse warehouse = new Warehouse();
//        warehouse.setGoodsName("冰箱");
//        warehouse.setGoodsId("F802887310001");
//        warehouse.setQuantity(30);
//        warehouse.setMaxQuantity(100);
//        warehouse.setCompany("台");
//        warehouse.setIfDelete(1);
//        warehouseMapper.insert(warehouse);
//    }

    @Test
    public void select(){
        Integer quantity = null;
        List<Warehouse> list = warehouseMapper.select(2,null, null,null,0);
        for (Warehouse warehouse : list) {
             quantity = warehouse.getQuantity();
        }
        System.out.println(quantity);
    }

    @Test
    public void update(){
        warehouseMapper.update("F802887310001","null",20,null,null,null,null);
    }
}
