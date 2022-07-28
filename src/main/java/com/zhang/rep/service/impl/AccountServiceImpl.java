package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Account;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.AccountMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.IAccountService;
import com.zhang.rep.service.ex.UserNotFoundException;
import com.zhang.rep.service.ex.account.DeleteAccountException;
import com.zhang.rep.service.ex.account.InsertAccountException;
import com.zhang.rep.service.ex.account.UpdateAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public void addAccount(Account account, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("创建时账户不存在异常");
        }

        account.setCreatedTime(new Date());
        account.setCreatedUser(username);

        Integer row = accountMapper.insert(account);
        if (row == 0){
            throw new InsertAccountException("创建时产生未知异常");
        }

    }

    @Override
    public List<Account> getAccount(Integer aid, String accountName, String accountNumber, String bankOfDeposit) {

        return accountMapper.select(aid, accountName, accountNumber, bankOfDeposit);
    }

    @Override
    public void changeAccount(String remarks, Integer aid, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("修改时账户不存在异常");
        }

        Integer row = accountMapper.update(remarks, aid);
        if (row == 0){
            throw new UpdateAccountException("修改备注时出现未知异常");
        }
    }

    @Override
    public void deleteAccount(Integer aid, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("删除账户不存在异常");
        }

        Integer row = accountMapper.delete(aid);
        if (row == 0){
            throw new DeleteAccountException("删除时产生未知异常");
        }
    }
}
