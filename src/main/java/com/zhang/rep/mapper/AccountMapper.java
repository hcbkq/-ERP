package com.zhang.rep.mapper;

import com.zhang.rep.entity.Account;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface AccountMapper {

    /**
     * 插入一个账户
     * @param account 账户属性
     * @return 改变行数
     */
    Integer insert(Account account);

    /**
     * 按条件查询账户信息
     * @param aid id
     * @param accountName 账户名
     * @param accountNumber 账号
     * @param bankOfDeposit 开户行
     * @return 满足条件的账户
     */
    List<Account> select(Integer aid,String accountName,
                         String accountNumber,String bankOfDeposit);

    /**
     * 更新备注
     * @param remarks 备注
     * @param aid id
     * @return 改变行数
     */
    Integer update(String remarks,Integer aid);

    /**
     * 删除所选账户
     * @param aid id
     * @return 改变行数
     */
    Integer delete(Integer aid);


    /**
     * 金钱的出入
     * @param existingBalance 余额
     * @return 变化行数
     */
    Integer existing(BigDecimal existingBalance, Integer aid);

    /**
     * 查询账户
     * @param accountNumber 账户号码
     * @return 对应账户
     */
    Account findAccount(String accountNumber);

}
