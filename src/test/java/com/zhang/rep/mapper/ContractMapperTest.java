package com.zhang.rep.mapper;

import com.zhang.rep.entity.Contract;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ContractMapperTest {

    @Autowired
    private ContractMapper contractMapper;
//
//    @Test
//    void insertNewContract() {
//        Contract contract = new Contract();
//        contract.setCustomerCid("220219093303");
//        contract.setCustomerUsername("何尝不可求");
//        contract.setOrderOid("6396220214064708");
//        contract.setOrderProduct("君を想う");
//        contract.setOrderCompletion(0);
//        contract.setAmountMoney(new BigDecimal(100));
//        contract.setFirstMoney(new BigDecimal(100));
//        contract.setMiddleMoney(new BigDecimal(1000));
//        contract.setMyLiquidatedDamages(new BigDecimal(1000));
//        contract.setCustomerLiquidatedDamages(new BigDecimal(1000));
//        Date date = new Date();
//        contract.setCreatedUser("他");
//        contract.setCreatedTime(date);
//        contract.setModifiedUser("那个");
//        contract.setModifiedTime(date);
//
//        Integer integer = contractMapper.insertNewContract(contract);
//        System.out.println(integer);
//    }


    @Test
    void updateContract() {

        Contract contract = new Contract();
        contract.setOrderOid("6396220214064708");
        contract.setAmountMoney(new BigDecimal(5000));
        contractMapper.updateContract(contract);
    }

    @Test
    void updateOrderCompletion() {
        contractMapper.updateOrderCompletion(1, "张三", "6396220214064708");
    }

    @Test
    void getContract() {
        List<Contract> contract = contractMapper.getContract(null, null, null, 1, null);
        System.out.println(contract);
    }
}
