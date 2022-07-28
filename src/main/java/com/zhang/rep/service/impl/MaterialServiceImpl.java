package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Material;
import com.zhang.rep.entity.User;
import com.zhang.rep.entity.Warehouse;
import com.zhang.rep.mapper.MaterialMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.mapper.WarehouseMapper;
import com.zhang.rep.service.IMaterialService;
import com.zhang.rep.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Material> getMaterials(String mid, String label, String name,Integer pageNo) {

        if (pageNo == null){
            pageNo = 0;
        }
        List<Material> materials = materialMapper.getMaterials(mid, label, name,pageNo);
        for (Material material : materials) {
            material.setCreatedUser(null);
            material.setCreatedUser(null);
            material.setModifiedUser(null);
            material.setModifiedTime(null);
        }

        return materials;
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void addMaterial(Material material, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("账户不存在异常");
        }
        String mid = "";
        Integer materialStatus = material.getMaterialStatus();
        if (materialStatus == 0){
            mid = mid + "S";
        }else if (materialStatus == 1){
            mid = mid + "L";
        }else if (materialStatus == 2){
            mid = mid + "G";
        }else {
            throw new AddMaterialException("添加材料时materialStatus产生异常");
        }
        Date date = new Date();
        long time = date.getTime();
        String s = String.valueOf(time);
        String stamp = s.substring(s.length() - 4);
        if (stamp.length() != 4){
            throw new AddMaterialException("添加材料时stamp产生异常");
        }
        mid = mid + stamp;

        String label = material.getLabel();
        if (label.length() != 4){
            throw new AddMaterialException("添加材料时label产生异常");
        }
        Integer integer = materialMapper.selectMaterial(label);
        if (integer != 0){
            throw new AddMaterialException("添加材料时label定义重复产生异常");
        }
        mid += label;

        Integer storageTemperature = material.getStorageTemperature();

        if (storageTemperature == 0){
            mid = mid + "C";
        }else if (storageTemperature == 1){
            mid = mid + "N";
        }else {
            throw new AddMaterialException("添加材料时storageTemperature产生异常");
        }
        Integer storageMode = material.getStorageMode();
        if (storageMode == 0){
            mid += "N";
        }else if (storageMode == 1){
            mid += "S";
        }

        Integer ifFlammable = material.getIfFlammable();
        if (ifFlammable == 0){
            mid = mid + "I";
        }else if (ifFlammable == 1){
            mid = mid + "N";
        }else {
            throw new AddMaterialException("添加材料时ifFlammable产生异常");
        }

        Integer ifPoisonous = material.getIfPoisonous();
        if (ifPoisonous == 0){
            mid = mid + "T";
        }else if (ifPoisonous == 1){
            mid = mid + "N";
        }else {
            throw new AddMaterialException("添加材料时ifPoisonous产生异常");
        }

        material.setMid(mid);
        material.setCreatedTime(date);
        material.setCreatedUser(username);
        material.setModifiedTime(date);
        material.setModifiedUser(username);

        Integer row = materialMapper.insertMaterial(material);
        if (row == 0){
            throw new AddMaterialException("添加材料时产生异常");
        }

        Warehouse warehouse = new Warehouse();
        warehouse.setGoodsId(material.getMid());
        warehouse.setGoodsName(material.getName());
        warehouse.setCompany(material.getUnit());
        warehouse.setIfDelete(1);
        warehouse.setProductsOrMaterials(0);
        Integer wro = warehouseMapper.insert(warehouse);
        if (wro == 0){
            throw new InsertWarehouseException("创建对应仓库时产生错误");
        }

    }

    @Override
    public void changeMaterial(String mid,BigDecimal purchase, Integer materialStatus, Integer storageTemperature,
                               Integer storageMode, Integer ifFlammable, Integer ifPoisonous,
                               Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("账户不存在异常");
        }
        Integer row = materialMapper.updateMaterial(mid,purchase,materialStatus,storageTemperature,storageMode,
                ifFlammable,ifPoisonous,username,new Date());
        if (row == 0){
            throw new UpdateMaterialException("修改时产生异常");
        }

    }

    @Override
    public void deleteMaterial(List<String> mids,Integer uid,String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("账户不存在异常");
        }

        Integer row = materialMapper.deleteMaterial(mids);
        if (row == 0){
            throw new DeleteMaterialException("删除时产生异常");
        }

        for (String mid : mids) {
            Integer wro = warehouseMapper.update(mid, null, null, null, null, 0, null);
            if (wro == 0){
                throw new UpdateWarehouseException("更新仓库数据标记删除时产生错误");
            }
        }
    }


}
