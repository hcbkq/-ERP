package com.zhang.rep.service.impl;

import com.zhang.rep.entity.*;
import com.zhang.rep.mapper.*;
import com.zhang.rep.service.IProductionService;
import com.zhang.rep.service.IWarehousingService;
import com.zhang.rep.service.ex.*;
import com.zhang.rep.service.ex.warehousing.DeleteWarehousingException;
import com.zhang.rep.service.ex.warehousing.InAndOutException;
import com.zhang.rep.service.ex.warehousing.InsertWarehousingException;
import com.zhang.rep.service.ex.warehousing.UpdateWarehousingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class WarehousingServiceImpl implements IWarehousingService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WarehousingMapper warehousingMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private IProductionService productionService;

    @Override
    public List<Warehousing> getByWarehousing(String documentNumber, String documentType,
                                              String uniqueIdentifier, String productName,
                                              Integer InAndOut, Integer implement,Integer pageNo) {

        if (pageNo == null){
            pageNo = 0;
        }

        return warehousingMapper.select(documentNumber, documentType, uniqueIdentifier, productName, InAndOut, implement,pageNo);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void addWarehousing(Warehousing warehousing, Integer inAndOut, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("创建时用户管理员不存在");
        }

        if (warehousing.getProductType() == null){
            throw new InsertWarehousingException("创建时无法识别单据类型");
        }

        Date date = new Date();
        warehousing.setInAndOut(inAndOut);
        warehousing.setCreatedUser(username);
        warehousing.setCreatedTime(date);
        warehousing.setDocumentNumber(warehousing.getProductType() + String.valueOf(date.getTime()).substring(4));
        warehousing.setImplement(1);
        Integer row = warehousingMapper.insert(warehousing);
        if (row == 0) {
            throw new InsertWarehousingException("创建时产生未知错误");
        }

        List<Warehouse> list = warehouseMapper.select(null, warehousing.getUniqueIdentifier(),
                warehousing.getProductName(), null,0);

        Integer warehouseQuantity = null;
        String warehouseGoodsName = null;
        String warehouseGoodsId = null;
        for (Warehouse warehouse : list) {
            warehouseGoodsName = warehouse.getGoodsName();
            warehouseGoodsId = warehouse.getGoodsId();
            warehouseQuantity = warehouse.getQuantity();
        }

        if (warehouseGoodsId == null) {
            Warehouse warehouse = new Warehouse();
            warehouse.setGoodsId(warehousing.getUniqueIdentifier());
            warehouse.setGoodsName(warehousing.getProductName());
            warehouse.setCompany(warehousing.getCompany());
            warehouse.setQuantity(0);
            warehouse.setRemarks("进行入库出库操作时，仓库未识别有相同货品。请仔细识别是否有错误");
            Integer warehouseRow = warehouseMapper.insert(warehouse);
            if (warehouseRow != null) {
                throw new InsertWarehousingException("创建货品仓库时出现未知错误");
            }
        }

        if (warehouseQuantity == null) {
            throw new SelectWarehouseException("查询" + warehouseGoodsName + "相关数量时产生未知错误");
        }
        if (warehousing.getInAndOut() == 0) {
            warehouseMapper.update(warehousing.getUniqueIdentifier(), null,
                    warehouseQuantity + warehousing.getQuantity(),
                    null, null, null, null);
        } else if (warehousing.getInAndOut() == 1) {
            if (warehouseQuantity >= warehousing.getQuantity()) {
                warehouseMapper.update(warehousing.getUniqueIdentifier(), null,
                        warehouseQuantity - warehousing.getQuantity(),
                        null, null, null, null);
            } else {
                Integer executeRow = warehousingMapper.Execute(1, warehousing.getDocumentNumber());
                Integer update = warehousingMapper.update("仓库获取缺少，未成功执行",null, warehousing.getDocumentNumber());
                if (executeRow != 1 || update != 1) {
                    throw new UpdateWarehousingException("更新出库执行时出现未知错误");
                }

                Integer uniqueIdentifierWorkingProcedure = 0;
                List<Product> select = productMapper.select(null, warehousing.getUniqueIdentifier(),
                        null, null, null,0);
                for (Product product : select) {
                    uniqueIdentifierWorkingProcedure= product.getWorkingProcedure();
                }
                if (uniqueIdentifierWorkingProcedure == 1){
                    Production production = new Production();
                    production.setProductName(warehousing.getProductName());
                    production.setProductionId(warehousing.getUniqueIdentifier());
                    production.setDocumentNumber(warehousing.getDocumentNumber());
                    production.setQuantity(warehousing.getQuantity() - warehouseQuantity);
                    production.setExamine(0);
                    productionService.addProduction(production,uid,username);
                }

            }
        } else {
            throw new InAndOutException("无法判断单据是入库或出库异常");
        }
    }

    @Override
    public void changeWarehousing(String remarks, Integer implement,String documentNumber, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("更新时用户管理员不存在");
        }

        Integer row = warehousingMapper.update(remarks,implement, documentNumber);
        if (row != 1) {
            throw new UpdateWarehousingException("更新时产生未知错误");
        }
    }

    @Override
    public void deleteWarehousing(List<String> documentNumber, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("删除时用户管理员不存在");
        }

        Integer row = warehousingMapper.delete(documentNumber);
        if (row != 1) {
            throw new DeleteWarehousingException("删除时产生未知错误");
        }
    }

    @Override
    public Integer calWarehousingCount() {
        return warehousingMapper.calWarehousingCount();
    }
}
