package com.zhang.rep.mapper;

import com.zhang.rep.entity.Province;
import com.zhang.rep.service.ex.AddressCodeException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProvincialAndUrbanStreetsMapperTest {

    @Autowired
    private ProvincialAndUrbanStreetsMapper provincialAndUrbanStreetsMapper;

    @Test
    public void findByProvinceCode(){
        try {
            Province province = provincialAndUrbanStreetsMapper.findByProvinceCode("zz");
            System.out.println( province);
        } catch (Exception e) {
            throw new AddressCodeException("地址信息错误");
        }


    }
}
