package com.zhang.rep.mapper;


import com.zhang.rep.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ProductMapperTest {

    @Autowired
    private ProductMapper productMapper;

//    @Test
//    public void insert() {
//        Product product = new Product();
//        Date date = new Date();
//        String s = String.valueOf(date.getTime());
//        String substring = s.substring(s.length() - 8);
//        String md = "0001";
//        product.setProductId("F" + substring + md);
//        product.setAvatar("1.jpg");
//        product.setProductName("冰箱");
//        product.setProductType("成品");
//        product.setCompany("台");
//        product.setWorkingProcedure(1);
//        product.setLowestSelling(new BigDecimal(5000));
//        product.setRecentPurchase(new BigDecimal(3500));
//        product.setRecentBid(new BigDecimal(4700));
//        product.setSpecifyCost(new BigDecimal(4000));
//        product.setSpecifySales(new BigDecimal(5700));
//        product.setMinimumStock(0);
//        product.setMaximumStock(60);
//        product.setHaltTheSales(1);
//        product.setCreatedTime(date);
//        product.setCreatedUser("HCBKQ");
//        product.setModifiedTime(date);
//        product.setModifiedUser("何尝不可求");
//
//        productMapper.insert(product);
//    }

    @Test
    public void update() {
        Integer row = productMapper.update("F802887310001",null, "冰箱", null, null
                , null, null, null, null, null,
                null, 10,
                null, null, null, null,
                null, null
        );
        System.out.println(row);
    }

    @Test
    public void select(){
//        List<Product> select = productMapper.select(null, "F802887310001", null, null, null);
//        System.out.println(select);
        Product fid = productMapper.fidByProduct("冰箱");
        System.out.println(fid);
    }
}
