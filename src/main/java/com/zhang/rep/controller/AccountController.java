package com.zhang.rep.controller;

import com.zhang.rep.entity.Account;
import com.zhang.rep.service.impl.AccountServiceImpl;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController extends BaseController{

    @Autowired
    private AccountServiceImpl accountService;

    @Autowired
    private GlobalSession globalSession;
    @RequestMapping("addAccount")
    public JsonResult<Void> addAccount(Account account, HttpSession session){
        accountService.addAccount(account,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("getAccount")
    public JsonResult<List<Account>> getAccount(Integer aid,String accountName,
                                          String accountNumber,String bankOfDeposit){
        List<Account> data = accountService.getAccount(aid, accountName, accountNumber, bankOfDeposit);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("changeAccount")
    public JsonResult<Void> changeAccount(String remarks,Integer aid,HttpSession session){
        accountService.changeAccount(remarks,aid,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }

    @RequestMapping("deleteAccount")
    public JsonResult<Void> deleteAccount(Integer aid,HttpSession session){
        accountService.deleteAccount(aid,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }
}
