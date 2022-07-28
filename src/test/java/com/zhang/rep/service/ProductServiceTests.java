package com.zhang.rep.service;


import com.zhang.rep.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private IProductService productService;

    @Test
    public void test(){
        List<Product> list = productService.getProducts(null, null, null, null, null,0);
        System.out.println(list);
    }
}
