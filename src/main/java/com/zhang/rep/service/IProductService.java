package com.zhang.rep.service;

import com.zhang.rep.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IProductService {

    void addProduct(Product product, Integer uid,String username);

    List<Product> getProducts(@Param("pid") Integer pid,
                              @Param("productId") String productId,
                              @Param("productName") String productName,
                              @Param("workingProcedure") String workingProcedure,
                              @Param("haltTheSales") Integer haltTheSales,
                              Integer pageNo);

    void changeProduct(@Param("productId") String productId,
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
                        Integer uid, String username);

    void deleteProduct(List<String> productId,Integer uid,String username);

    Integer calProductCount();

}
