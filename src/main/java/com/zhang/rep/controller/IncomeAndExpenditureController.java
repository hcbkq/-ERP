package com.zhang.rep.controller;


import com.zhang.rep.entity.IncomeAndExpenditure;
import com.zhang.rep.service.IIncomeAndExpenditureService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("incomeAndExpenditure")
public class IncomeAndExpenditureController extends BaseController {

    @Autowired
    private IIncomeAndExpenditureService incomeAndExpenditureService;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping("addIncomeAndExpenditure")
    public JsonResult<Void> addIncomeAndExpenditure(IncomeAndExpenditure incomeAndExpenditure, HttpSession session) {

        incomeAndExpenditureService.addIncomeAndExpenditure(incomeAndExpenditure, (Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("getIncomeAndExpenditures")
    public JsonResult<List<IncomeAndExpenditure>> getIncomeAndExpenditures(String voucher, String oppositeUnit, String account, Integer incomeOrExpenditure,
                                                                           Integer classification, Integer reviewer, String remarks,Integer pageNo) {
        List<IncomeAndExpenditure> data =
                incomeAndExpenditureService.getIncomeAndExpenditures
                        (voucher, oppositeUnit, account, incomeOrExpenditure, classification, reviewer, remarks,pageNo);
        return new JsonResult<>(ok, data);
    }

    @RequestMapping("changeIncomeAndExpenditures")
    public JsonResult<Void> changeIncomeAndExpenditures(Integer reviewer, String remarks, String voucher, HttpSession session) {
        incomeAndExpenditureService.changeIncomeAndExpenditures(reviewer, remarks, voucher,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("deleteIncomeAndExpenditures")
    public JsonResult<Void> deleteIncomeAndExpenditures(List<String> voucher, HttpSession session) {
        incomeAndExpenditureService.deleteIncomeAndExpenditures(voucher, (Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }


}
