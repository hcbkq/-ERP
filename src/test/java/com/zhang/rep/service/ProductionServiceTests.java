package com.zhang.rep.service;

import com.zhang.rep.entity.Production;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductionServiceTests {

    @Autowired IProductionService productionService;

    @Test
    public void Test(){
        List<Production> production = productionService.getProduction(null, null, null, null,
                null, null, null, null, null, null
                , null,0);
        System.out.println(production);
    }
}
