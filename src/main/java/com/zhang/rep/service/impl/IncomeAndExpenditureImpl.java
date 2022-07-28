package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Account;
import com.zhang.rep.entity.IncomeAndExpenditure;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.AccountMapper;
import com.zhang.rep.mapper.IncomeAndExpenditureMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.IIncomeAndExpenditureService;
import com.zhang.rep.service.ex.ServiceException;
import com.zhang.rep.service.ex.UserNotFoundException;
import com.zhang.rep.service.ex.account.LackOfMoneyException;
import com.zhang.rep.service.ex.account.SelectAccountException;
import com.zhang.rep.service.ex.account.UpdateAccountException;
import com.zhang.rep.service.ex.incomeAndExpenditure.DeleteIncomeAndExpenditureException;
import com.zhang.rep.service.ex.incomeAndExpenditure.InsertIncomeAndExpenditureException;
import com.zhang.rep.service.ex.incomeAndExpenditure.NotIncomeAndExpenditureException;
import com.zhang.rep.service.ex.incomeAndExpenditure.UpdateIncomeAndExpenditureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service
public class IncomeAndExpenditureImpl implements IIncomeAndExpenditureService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IncomeAndExpenditureMapper incomeAndExpenditureMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void addIncomeAndExpenditure(IncomeAndExpenditure incomeAndExpenditure, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("插入时用户不存在异常");
        }

        String account = incomeAndExpenditure.getAccount();
        Integer incomeOrExpenditure = incomeAndExpenditure.getIncomeOrExpenditure();
        BigDecimal amount = incomeAndExpenditure.getAmount();
        Date date = new Date();
        if (incomeAndExpenditure.getIncomeOrExpenditure() == 0){
            incomeAndExpenditure.setVoucher("S" + String.valueOf(date.getTime()).substring(4) );
        }else if (incomeAndExpenditure.getIncomeOrExpenditure() == 1){
            incomeAndExpenditure.setVoucher("C" + String.valueOf(date.getTime()).substring(4) );
        }else {
            throw new NotIncomeAndExpenditureException("无法辨别是收款单还是付款单");
        }

        incomeAndExpenditure.setRemarks(username);
        incomeAndExpenditure.setOccurrence(date);
        incomeAndExpenditure.setCreated_time(date);
        incomeAndExpenditure.setCreated_user(username);
        Integer rw = incomeAndExpenditureMapper.insert(incomeAndExpenditure);
        if (rw != 1){
            throw new InsertIncomeAndExpenditureException("插入时产生未知错误");
        }

        Account ars = accountMapper.findAccount(account);
        if (ars == null){
            throw new SelectAccountException("账户不存在异常");
        }

        Integer aid = ars.getAid();
        BigDecimal existingBalance = ars.getExistingBalance();
        if (incomeOrExpenditure == 0){
            Integer row = accountMapper.existing(existingBalance.add(amount), aid);
            if (row == 0){
                throw new UpdateAccountException("更新余额时产生错误");
            }
        }else if (incomeOrExpenditure == 1){
            int i = existingBalance.compareTo(amount);
            if (i >= 0){
                Integer row = accountMapper.existing(existingBalance.subtract(amount), aid);
                if (row == 0){
                    throw new UpdateAccountException("更新余额时产生错误");
                }
            }else {
                throw new LackOfMoneyException("余额不足产业异常");
            }
        }

    }

    @Override
    public List<IncomeAndExpenditure> getIncomeAndExpenditures(String voucher, String oppositeUnit, String account,
                                                               Integer incomeOrExpenditure, Integer classification,
                                                               Integer reviewer, String remarks,Integer pageNo) {
        if (pageNo == null){
            pageNo = 0;
        }
            return incomeAndExpenditureMapper.select(voucher, oppositeUnit, account, incomeOrExpenditure,
                    classification, reviewer, remarks,pageNo);
    }

    @Override
    public void changeIncomeAndExpenditures(Integer reviewer, String remarks, String voucher, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("更新时用户不存在异常");
        }
        Integer row = incomeAndExpenditureMapper.update(reviewer, remarks, voucher);
        if (row == 0){
            throw new UpdateIncomeAndExpenditureException("更新时产生未知错误");
        }
    }

    @Override
    public void deleteIncomeAndExpenditures(List<String> voucher, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("删除时用户不存在异常");
        }

        Integer row = incomeAndExpenditureMapper.delete(voucher);
        if (row == 0){
            throw new DeleteIncomeAndExpenditureException("删除时产生未知异常");
        }
    }
}
