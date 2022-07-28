package com.zhang.rep.mapper;

import com.zhang.rep.entity.IncomeAndExpenditure;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface IncomeAndExpenditureMapper {
    /**
     * 创建收支单
     * @param incomeAndExpenditure 收支单数据
     * @return 改变行数
     */
    Integer insert(IncomeAndExpenditure incomeAndExpenditure);

    /**
     * 查询对应的收支单
     * @param voucher 凭证
     * @param oppositeUnit 对方单位
     * @param account 账户
     * @param incomeOrExpenditure 收入=0，支出=1
     * @param classification 收入支出分类
     * @param reviewer reviewer 审核 1完成，未完成
     * @param remarks 备注
     * @param pageNo 页码
     * @return 返回对应的收支单
     */
    List<IncomeAndExpenditure> select(String voucher,String oppositeUnit,String account,Integer incomeOrExpenditure,
                                      Integer classification,Integer reviewer,String remarks,Integer pageNo);

    /**
     * 更新收支单
     * @param reviewer 审核人
     * @param remarks 备注
     * @param voucher 凭证
     * @return 改变的行数
     */
    Integer update(Integer reviewer,String remarks,String voucher);

    /**
     * 删除选中凭证的收支单
     * @param voucher 凭证
     * @return 改变行数
     */
    Integer delete(List<String> voucher);

    /**
     *
     * @param incomeOrExpenditure 收支
     * @return 收支单总收入支出,纯收入
     */
    BigDecimal RevenueAndExpenditure(Integer incomeOrExpenditure);

    /**
     *
     * @return 返回 近六个月每月的收入或者支出；
     */
//    ArrayList<BigDecimal> monthRevenueAndExpenditure(Integer incomeOrExpenditure);
    List<Map<BigDecimal, Integer>> monthRevenueAndExpenditure(Integer incomeOrExpenditure);
}
