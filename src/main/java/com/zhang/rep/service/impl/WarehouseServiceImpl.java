package com.zhang.rep.service.impl;

import com.zhang.rep.entity.User;
import com.zhang.rep.entity.Warehouse;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.mapper.WarehouseMapper;
import com.zhang.rep.service.IWarehouseService;
import com.zhang.rep.service.ex.DeleteWarehouseException;
import com.zhang.rep.service.ex.SelectWarehouseException;
import com.zhang.rep.service.ex.UpdateWarehouseException;
import com.zhang.rep.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements IWarehouseService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> getByWarehouses(Integer kid, String goodsId, String goodsName, Integer productsOrMaterials,Integer pageNo) {
        if (pageNo == null){
            pageNo = 0;
        }
       return warehouseMapper.select(kid, goodsId, goodsName, productsOrMaterials,pageNo);
    }

    @Override
    public void deleteWarehouse(int kid,Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("删除时用户管理员不存在异常");
        }

        Integer row = warehouseMapper.delete(kid);

        if (row == 0){
            throw new DeleteWarehouseException("删除相关仓库时产生错误");
        }
    }

    @Override
    public void changeWarehouse(String goodsId, String remarks, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("备注时用户管理员不存在异常");
        }

        Integer row = warehouseMapper.update(goodsId, null, null, null, null, null, remarks);
        if (row == 0){
            throw new UpdateWarehouseException("备注时产生未知错误");
        }
    }
}
