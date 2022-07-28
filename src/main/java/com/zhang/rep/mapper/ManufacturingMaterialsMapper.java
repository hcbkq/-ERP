package com.zhang.rep.mapper;

import com.zhang.rep.entity.ManufacturingMaterials;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManufacturingMaterialsMapper {

    /**
     * 创建产品生产所需原料单
     * @param manufacturingMaterials 原料单对象
     * @return 改变行数
     */
    Integer insert(List<ManufacturingMaterials> manufacturingMaterials);

    /**
     * 查询所需产品原料单
     * @param productId 产品id
     * @param productName 产品名字
     * @return 相关原料单
     */
    List<ManufacturingMaterials> select(String productId,
                                        String productName);

    /**
     * 修改所需产品的原料单
     * @param quantity 材料数量
     * @param remarks 备注
     * @param productId 产品唯一标识符
     * @param mid 材料唯一标识符
     * @return 改变行数
     */
    Integer update(Integer quantity,String remarks,String productId,String mid);

    /**
     * 删除产品里面不需要的原料
     * @param productId 产品id
     * @param mid 原料id
     * @return 改变行数
     */
    Integer delete(String productId,String mid);
}
