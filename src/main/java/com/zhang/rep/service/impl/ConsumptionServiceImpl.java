package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Consumption;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.ConsumptionMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.IConsumptionService;
import com.zhang.rep.service.ex.Consumption.UpdateConsumptionException;
import com.zhang.rep.service.ex.ManufacturingMaterials.DeleteManufacturingMaterialsException;
import com.zhang.rep.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionServiceImpl implements IConsumptionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ConsumptionMapper consumptionMapper;

    @Override
    public void addConsumption(Consumption consumption, Integer uid, String username) {

    }

    @Override
    public List<Consumption> getConsumption(String productionId, String productName) {
        return consumptionMapper.select( productionId, productName);
    }

    @Override
    public void changeConsumption(String remarks, String productionId, Integer uid) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("添加备注时用户不存在");
        }
        Integer row = consumptionMapper.update(remarks, productionId);
        if (row == 1){
            throw new UpdateConsumptionException("修改备注时产生未知错误");
        }
    }

    @Override
    public void deleteConsumption(String productionId,Integer uid) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("删除时用户不存在");
        }

        Integer row = consumptionMapper.delete(productionId);
        if (row <= 0){
            throw new DeleteManufacturingMaterialsException("删除时产生未知错误");
        }
    }
}
