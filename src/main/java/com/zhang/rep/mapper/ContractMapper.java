package com.zhang.rep.mapper;

import com.zhang.rep.entity.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractMapper {

    /**
     * 创建新合同
     * @param contract 合同数据
     * @return 受影响行数
     */
    Integer insertNewContract(Contract contract);

    /**
     * 修改合同
     * @param contract 合同数据
     * @return 受影响的行数
     */
    Integer updateContract(Contract contract);

    /**
     * 结算合同
     * @param orderCompletion 订单是否结算0=未结算，1=结算
     * @param reviewer 审核人
     * @return 受影响的行数
     */
    Integer updateOrderCompletion(Integer orderCompletion,String reviewer,String orderOid);

    /**
     *
     * @param customerCid 客户唯一标识符
     * @param customerUsername 客户名字
     * @param orderOid 订单唯一标识符
     * @param orderCompletion 订单是否结算0=未结算，1=结算
     * @param reviewer varchar
     * @return List<Contract>
     */
    List<Contract> getContract(@Param("customerCid") String customerCid ,
                               @Param("customerUsername") String customerUsername,
                               @Param("orderOid") String orderOid,
                               @Param("orderCompletion") Integer orderCompletion,
                               @Param("reviewer")String reviewer);

    /**
     *
     * @return 返回所有合同
     */
    List<Contract> getContracts();
}
