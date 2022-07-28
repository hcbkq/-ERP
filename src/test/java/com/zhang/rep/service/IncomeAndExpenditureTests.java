package com.zhang.rep.service;

import com.zhang.rep.entity.IncomeAndExpenditure;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class IncomeAndExpenditureTests {

    @Autowired
    public IIncomeAndExpenditureService incomeAndExpenditureService;


    @Test
    public void getTest(){
        List<IncomeAndExpenditure> incomeAndExpenditures = incomeAndExpenditureService.getIncomeAndExpenditures(null, null, null,
                null, null,
                null, null, null);
        System.out.println(incomeAndExpenditures);
    }
}
