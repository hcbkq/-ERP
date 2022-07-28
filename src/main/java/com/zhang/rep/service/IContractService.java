package com.zhang.rep.service;

import com.zhang.rep.entity.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IContractService {

    void updateContract(Contract contract,Integer uid,String username);


    void contractSettlement(Integer orderCompletion,String orderOid,
                            Integer uid,String username);
    List<Contract> getContract(@Param("customerCid") String customerCid ,
                               @Param("customerUsername") String customerUsername,
                               @Param("orderOid") String orderOid,
                               @Param("orderCompletion") Integer orderCompletion,
                               @Param("reviewer")String reviewer);

    List<Contract> getContracts();
}
