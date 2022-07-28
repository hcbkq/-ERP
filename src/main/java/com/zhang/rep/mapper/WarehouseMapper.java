package com.zhang.rep.mapper;

import com.zhang.rep.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    /**
     * 创建货品库存
     *
     * @param warehouse 货品库存数据
     * @return 改变行数
     */
    Integer insert(Warehouse warehouse);


    /**
     * 查询货品库存
     *
     * @param kid       库存id
     * @param goodsId   货品id
     * @param goodsName 货品名字
     * @param productsOrMaterials 是货品或者材料
     * @param pageNo 页脚
     * @return 关于的货品库存
     */
    List<Warehouse> select(Integer kid,
                           String goodsId,
                           String goodsName,
                           Integer productsOrMaterials,
                           Integer pageNo);

    /**
     * 更新货品库存信息
     * @param goodsId 货品id
     * @param goodsName   货品名称
     * @param quantity    货品数量
     * @param maxQuantity 货品名称
     * @param company     货品单位
     * @param remarks     备注
     * @param ifDelete    是否删除 0=是，1=不是
     * @return 改变行数
     */
    Integer update(String goodsId,
                   String goodsName,
                   Integer quantity,
                   Integer maxQuantity,
                   String company,
                   Integer ifDelete,
                   String remarks);

    /**
     * 删除货品库存信息
     *
     * @param kid 库存id
     * @return 改变行数
     */
    Integer delete(int kid);
}
