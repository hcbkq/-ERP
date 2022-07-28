package com.zhang.rep.mapper;

import com.zhang.rep.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 插入产品
     *
     * @param product 产品属性
     * @return 改变行数
     */
    Integer insert(Product product);

    /**
     * 查询指定产品
     *
     * @param pid              产品id
     * @param productId        产品唯一标识符
     * @param productName      产品名称
     * @param workingProcedure 产品工序有无
     * @param haltTheSales     是否停售
     * @param pageNo 页脚
     * @return 返回指定产品
     */
    List<Product> select(@Param("pid") Integer pid,
                         @Param("productId") String productId,
                         @Param("productName") String productName,
                         @Param("workingProcedure") String workingProcedure,
                         @Param("haltTheSales") Integer haltTheSales,
                         Integer pageNo);


    Product fidByProduct(@Param("productName") String productName);
    /**
     * 更新产品
     * @param productId 产品唯一标识符
     * @param avatar 产品图片
     * @param productName 产品名称
     * @param productType 产品类型
     * @param company 产品单位
     * @param workingProcedure 有无工序0无，1有
     * @param lowestSelling 最低单件售价
     * @param recentPurchase 最近采购价：取总价平均值
     * @param recentBid 最近出价：取总价平均值
     * @param specifyCost 指定成本价
     * @param specifySales 指定销售价
     * @param maximumStock 最高库存
     * @param rawMaterial 原料各种原料组成的
     * @param remarks 备注
     * @param haltTheSales 停售 0=售，1=停售
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @return 改变行数
     */
    Integer update(@Param("productId") String productId,
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
                   @Param("modifiedUser") String modifiedUser,
                   @Param("modifiedTime") Date modifiedTime);

    /**
     * 删除选中的产品
     * @param productId 产品唯一标识符
     * @return 改变行数
     */
    Integer delete(List<String> productId);

    /**
     * 查询数据行数
     * @return 数据行数
     */
    Integer calProductCount();

}
