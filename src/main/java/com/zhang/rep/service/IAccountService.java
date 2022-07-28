package com.zhang.rep.service;

import com.zhang.rep.entity.Account;

import java.util.List;

public interface IAccountService {
    void addAccount(Account account,Integer uid,String username);

    List<Account> getAccount(Integer aid,String accountName,
                             String accountNumber,String bankOfDeposit);

    void changeAccount(String remarks,Integer aid,
                       Integer uid,String username);

    void deleteAccount(Integer aid,Integer uid,String username);
}
