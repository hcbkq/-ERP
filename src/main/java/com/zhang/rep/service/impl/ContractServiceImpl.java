package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Contract;
import com.zhang.rep.entity.Order;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.ContractMapper;
import com.zhang.rep.mapper.OrderMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.IContractService;
import com.zhang.rep.service.ex.ListContractNotException;
import com.zhang.rep.service.ex.UpdateContractException;
import com.zhang.rep.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void updateContract(Contract contract, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("管理员数据不存在");
        }
        Date date = new Date();
        contract.setModifiedUser(username);
        contract.setModifiedTime(date);

        Integer row = contractMapper.updateContract(contract);
        if (row == 0) {
            throw new UpdateContractException("合同修改产生错误");
        }
    }

    @Override
    public void contractSettlement(Integer orderCompletion, String orderOid, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("管理员数据不存在");
        }
        List<Order> orders = orderMapper.findByIdentifierId(orderOid);
        Integer statement = null;
        for (Order order : orders) {
            statement = order.getStatement();
        }
        assert statement != null;
        if (statement == 0){
            throw new UpdateContractException("订单还未结单，无法结算");
        }

        Integer row = contractMapper.updateOrderCompletion(orderCompletion, username, orderOid);
        if (row == 0) {
            throw new UpdateContractException("修改合成结算失败");
        }
    }

    @Override
    public List<Contract> getContract(String customerCid, String customerUsername, String orderOid, Integer orderCompletion, String reviewer) {
        return contractMapper.getContract(customerCid, customerUsername, orderOid, orderCompletion, reviewer);
    }

    @Override
    public List<Contract> getContracts() {
        List<Contract> contracts = contractMapper.getContracts();
        if (contracts == null) {
            throw new ListContractNotException("返回合同时产生错误");
        }
        return contracts;
    }
}
