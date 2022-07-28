package com.zhang.rep.controller;

import com.zhang.rep.entity.Contract;
import com.zhang.rep.service.IContractService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController extends BaseController{

    @Autowired
    private IContractService iContractService;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping("updateContract")
    public JsonResult<Void> updateContract(Contract contract, HttpSession httpSession){
        iContractService.updateContract(contract,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("contractSettlement")
    public JsonResult<Void> contractSettlement(Integer orderCompletion, String orderOid,HttpSession httpSession){
        iContractService.contractSettlement(orderCompletion,orderOid,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("getContract")
    public JsonResult<List<Contract>> getContract(@Param("customerCid") String customerCid ,
                                                  @Param("customerUsername") String customerUsername,
                                                  @Param("orderOid") String orderOid,
                                                  @Param("orderCompletion") Integer orderCompletion,
                                                  @Param("reviewer")String reviewer){
        List<Contract> data = iContractService.getContract(customerCid, customerUsername, orderOid, orderCompletion, reviewer);
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("getContracts")
    public JsonResult<List<Contract>> getContracts(){
        List<Contract> data = iContractService.getContracts();
        return new JsonResult<>(ok,data);
    }


}
