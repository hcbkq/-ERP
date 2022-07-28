package com.zhang.rep.service.impl;

import com.zhang.rep.entity.ManufacturingMaterials;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.ManufacturingMaterialsMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.IManufacturingMaterialsService;
import com.zhang.rep.service.ex.ManufacturingMaterials.DeleteManufacturingMaterialsException;
import com.zhang.rep.service.ex.ManufacturingMaterials.InsertManufacturingMaterialsException;
import com.zhang.rep.service.ex.ServiceException;
import com.zhang.rep.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ManufacturingMaterialsServiceImpl implements IManufacturingMaterialsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ManufacturingMaterialsMapper manufacturingMaterialsMapper;

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void addManufacturingMaterials(List<ManufacturingMaterials> manufacturingMaterials, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("添加时用户不存在");
        }
        Date date = new Date();
        for (ManufacturingMaterials manufacturingMaterial : manufacturingMaterials) {
            manufacturingMaterial.setCreatedTime(date);
            manufacturingMaterial.setCreatedUser(username);
            manufacturingMaterial.setModifiedTime(date);
            manufacturingMaterial.setModifiedUser(username);
        }

        Integer row = manufacturingMaterialsMapper.insert(manufacturingMaterials);
        if (row <= 0){
            throw new InsertManufacturingMaterialsException("创建所需时产生未知错误");
        }
    }

    @Override
    public List<ManufacturingMaterials> getManufacturingMaterials(String productId, String productName) {
        return manufacturingMaterialsMapper.select(productId, productName);
    }

    @Override
    public void changeManufacturingMaterials(Integer quantity, String remarks, String productId, String mid, Integer uid, String username) {

    }

    @Override
    public void deleteManufacturingMaterials(String productId, String mid, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("删除时用户不存在");
        }

        Integer row = manufacturingMaterialsMapper.delete(productId, mid);
        if (row <= 0){
            throw new DeleteManufacturingMaterialsException("删除时产生未知错误");
        }
    }
}
