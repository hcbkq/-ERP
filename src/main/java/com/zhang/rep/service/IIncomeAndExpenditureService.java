package com.zhang.rep.service;

import com.zhang.rep.entity.IncomeAndExpenditure;

import java.util.List;

public interface IIncomeAndExpenditureService {

    void addIncomeAndExpenditure(IncomeAndExpenditure incomeAndExpenditure,Integer uid,String username);

    List<IncomeAndExpenditure> getIncomeAndExpenditures(String voucher,String oppositeUnit,String account,Integer incomeOrExpenditure,
                                                        Integer classification,Integer reviewer,String remarks,Integer pageNo);

    void changeIncomeAndExpenditures(Integer reviewer,String remarks,String voucher,
                                     Integer uid,String username);

    void deleteIncomeAndExpenditures(List<String> voucher,Integer uid,String username);
}
