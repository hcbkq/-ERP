package com.zhang.rep.service;


import com.zhang.rep.entity.Material;
import com.zhang.rep.service.impl.MaterialServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MaterialServiceImplTests {

    @Autowired
    private MaterialServiceImpl materialService;

    @Test
    public void getMaterials(){
        List<Material> materials = materialService.getMaterials(null, null, null,0);
        System.out.println(materials);
    }
}
