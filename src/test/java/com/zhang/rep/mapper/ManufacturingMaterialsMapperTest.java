package com.zhang.rep.mapper;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManufacturingMaterialsMapperTest {

    @Autowired
    private ManufacturingMaterialsMapper manufacturingMaterialsMapper;


    @Test
    public void delete(){
        manufacturingMaterialsMapper.delete("11",null);
    }
}
