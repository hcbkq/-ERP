package com.zhang.rep.service.impl;

import com.zhang.rep.entity.*;
import com.zhang.rep.mapper.CategoryMapper;
import com.zhang.rep.mapper.ProductMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.mapper.WarehouseMapper;
import com.zhang.rep.service.IProductService;
import com.zhang.rep.service.ex.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void addProduct(Product product, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user != null) {
            throw new UserNotFoundException("添加时用户不存在异常");
        }

        Date date = new Date();
        product.setCreatedUser(username);
        product.setCreatedTime(date);
        product.setModifiedUser(username);
        product.setModifiedTime(date);

        Calendar calendar = Calendar.getInstance();


        long time = date.getTime();
        String timeID = String.valueOf(time);
        String substring = timeID.substring(timeID.length() - 7);
        String code = null;
        List<Category> list = categoryMapper.select(product.getProductType());
        for (Category category : list) {
             code = category.getCode();
        }
        product.setProductId(code + substring + calendar.get(Calendar.YEAR) +
                calendar.get(Calendar.MONTH) + calendar.get(Calendar.DATE));


        Integer row = productMapper.insert(product);
        if (row == 0) {
            throw new AddProductException("添加货品时产生异常");
        }

        Warehouse warehouse = new Warehouse();
        warehouse.setGoodsId(product.getProductId());
        warehouse.setGoodsName(product.getProductName());

        if (product.getMaximumStock() !=null){
            warehouse.setMaxQuantity(product.getMaximumStock());
        }
        if (product.getCompany() != null){
            warehouse.setCompany(product.getCompany());
        }
        warehouse.setIfDelete(1);
        warehouse.setProductsOrMaterials(1);
        Integer rs = warehouseMapper.insert(warehouse);
        if (rs == 0){
            throw new InsertWarehouseException("创建对应仓库时产生错误");
        }

    }

    @Override
    public List<Product> getProducts(@Param("pid") Integer pid,
                                     @Param("productId") String productId,
                                     @Param("productName") String productName,
                                     @Param("workingProcedure") String workingProcedure,
                                     @Param("haltTheSales") Integer haltTheSales,
                                     Integer pageNo) {
        if (pageNo == null){
            pageNo = 0;
        }
        return productMapper.select(pid, productId, productName, workingProcedure, haltTheSales,pageNo);
    }

    @Override
    public void changeProduct(@Param("productId")String productId,
                              @Param("avatar") String avatar,
                              @Param("productName") String productName,
                              @Param("productType") String productType,
                              @Param("company") String company,
                              @Param("workingProcedure") String workingProcedure,
                              @Param("lowestSelling") BigDecimal lowestSelling,
                              @Param("recentPurchase") BigDecimal recentPurchase,
                              @Param("recentBid") BigDecimal recentBid,
                              @Param("specifyCost") BigDecimal specifyCost,
                              @Param("specifySales") BigDecimal specifySales,
                              @Param("minimumStock") Integer minimumStock,
                              @Param("maximumStock") Integer maximumStock,
                              @Param("rawMaterial") String rawMaterial,
                              @Param("remarks") String remarks,
                              @Param("haltTheSales") String haltTheSales,
                              Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user != null) {
            throw new UserNotFoundException("更新时用户不存在异常");
        }

        Integer row = productMapper.update(productId,avatar, productName, productType, company, workingProcedure, lowestSelling, recentPurchase,
                recentBid, specifyCost, specifySales, minimumStock, maximumStock, rawMaterial, remarks, haltTheSales,
                username, new Date());
        if (row != 1) {
            throw new UpdateProductException("更新产品数据时产生错误");
        }

        Integer wro = warehouseMapper.update(productId,productName, null, maximumStock, company, null, null);
        if (wro != 1){
            throw new UpdateWarehouseException("更新仓库数据时产生错误");
        }
    }

    @Override
    public void deleteProduct(List<String> productId, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user != null) {
            throw new UserNotFoundException("删除时用户不存在异常");
        }

        Integer row = productMapper.delete(productId);
        if (row == 0) {
            throw new DeleteProductException("删除时产生错误");
        }

        for (String s : productId) {
            Integer wr = warehouseMapper.update(s, null, null, null, null, 0, null);
            if (wr == 0){
                throw new UpdateWarehouseException("更新仓库数据标记删除时产生错误");
            }
        }
    }

    @Override
    public Integer calProductCount() {
        return productMapper.calProductCount();
    }
}
