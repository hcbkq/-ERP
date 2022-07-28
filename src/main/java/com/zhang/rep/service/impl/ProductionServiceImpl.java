package com.zhang.rep.service.impl;

import com.zhang.rep.entity.*;
import com.zhang.rep.mapper.*;
import com.zhang.rep.service.IProductionService;
import com.zhang.rep.service.ex.Consumption.InsertConsumptionException;
import com.zhang.rep.service.ex.SelectProductException;
import com.zhang.rep.service.ex.ServiceException;
import com.zhang.rep.service.ex.UserNotFoundException;
import com.zhang.rep.service.ex.production.DeleteProductionException;
import com.zhang.rep.service.ex.production.InsertProductionException;
import com.zhang.rep.service.ex.production.UpdateProductionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductionServiceImpl implements IProductionService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductionMapper productionMapper;

    @Autowired
    private ConsumptionMapper consumptionMapper;

    @Autowired
    private ManufacturingMaterialsMapper manufacturingMaterialsMapper;

    @Autowired
    private ProductMapper productMapper;

    @Value("${production.production.id.head}")
    private String productionIdHead;


    @Override
    public void addProduction(Production production, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("创建生产订单时，用户不存在");
        }

        Date date = new Date();
        production.setOrderDate(date);
        production.setProductionId(productionIdHead + String.valueOf(date.getTime()).substring(4));
        production.setCreatedUser(username);
        production.setCreatedTime(date);
        production.setComplete(0);

        Integer row = productionMapper.insert(production);
        if (row != 1) {
            throw new InsertProductionException("创建生产订单时，产生未知错误");
        }
    }

    @Override
    public List<Production> getProduction(String productionId,
                                          Date startOrderDate, Date endOrderDate,
                                          Date startDeliveryDate, Date endDeliveryDate,
                                          String productId, String productName,
                                          String documentNumber, String preparer,
                                          Integer complete, Integer examine, Integer pageNo) {
        if (pageNo == null) {
            pageNo = 0;
        }

        return productionMapper.select(productionId, startOrderDate, endOrderDate, startDeliveryDate, endDeliveryDate,
                productId, productName, documentNumber, preparer, complete, examine, pageNo);
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public void changeProduction(Production production, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("修改生产订单时，用户不存在");
        }

        Product product = productMapper.fidByProduct(production.getProductName());
        if (product == null) {
            throw new SelectProductException("产品不存在异常");
        }
        production.setProductId(product.getProductId());

        Date date = new Date();
        production.setModifiedUser(username);
        production.setModifiedTime(date);
        Integer row = productionMapper.update(production);

        if (row != 1) {
            throw new UpdateProductionException("修改订单时产生未知错误");
        }

        if (product.getWorkingProcedure() == 1) {
            if (production.getExamine() == 1) {
                List<ManufacturingMaterials> manufacturingMaterials =
                        manufacturingMaterialsMapper.select(production.getProductId(), production.getProductName());

                for (ManufacturingMaterials manufacturingMaterial : manufacturingMaterials) {
                    Consumption consumption = new Consumption();
                    consumption.setProductionId(production.getProductionId());
                    consumption.setProductId(production.getProductId());
                    consumption.setProductName(production.getProductName());
                    consumption.setMid(manufacturingMaterial.getMid());
                    consumption.setName(manufacturingMaterial.getName());
                    consumption.setQuantity(manufacturingMaterial.getQuantity() * production.getQuantity());
                    Integer rows = consumptionMapper.insert(consumption);
                    if (rows != 1) {
                        throw new InsertConsumptionException("创建生产所用材料单失败");
                    }
                }
            }
        }


    }

    @Override
    public void deleteProduction(List<String> productionId, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("修改生产订单时，用户不存在");
        }

        Integer row = productionMapper.delete(productionId);
        if (row <= 0) {
            throw new DeleteProductionException("删除生产单时产生未知错误");
        }
    }

    @Override
    public Integer calProductionCount() {
        return productionMapper.calProduction();
    }
}
