package com.zhang.rep.mapper;

import com.zhang.rep.entity.Material;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
public class MaterialMapperTest {

    @Autowired
    private MaterialMapper materialMapper;
    @Test
    public void insertMaterial() {
        Material material = new Material();

        material.setName("原铁石");
        material.setUnit("KG");
        material.setMaterialStatus(0);
        material.setStorageTemperature(0);
        material.setStorageMode(0);
        material.setIfFlammable(0);
        material.setIfPoisonous(0);

        Date date = new Date();
        long time = date.getTime();
        String s = String.valueOf(time);
        String substring = s.substring(s.length() - 4);
        material.setMid("S" + substring + "0001" + "NNNN");
        material.setCreatedUser("test1");
        material.setCreatedTime(date);
        material.setModifiedUser("test1");
        material.setModifiedTime(date);

        Integer integer = materialMapper.insertMaterial(material);

    }

    @Test
    public void getMaterials() {
        List<Material> materials = materialMapper.getMaterials(null, null, null,0);
        for (Material material : materials) {
            System.out.println(material);
        }
    }

    @Test
    public  void  updateMaterial(){
        Integer integer = materialMapper.updateMaterial("S96170001NNNN",null, 1, null, null, null,null,null,null);
        System.out.println(integer);
    }

    @Test
    public void selectMaterial(){
        Integer integer = materialMapper.selectMaterial("341341");
        System.out.println(integer);
    }

    @Test
    public void deleteMaterial(){
        List<String> list = new ArrayList<>();
        list.add("S90660001NNNN");
        list.add("S10710001NNNN");
        Integer row = materialMapper.deleteMaterial(list);
        System.out.println(row);
    }
}
