package com.zhang.rep.mapper;

import com.zhang.rep.entity.Consumption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsumptionMapper {
    /**
     * 创建对应生产材料消耗单
     * @param consumption 消耗单对象
     * @return 改变行数
     */
    Integer insert(Consumption consumption);

    /**
     * 查询材料消耗单
     * @param productionId 生产单id
     * @param productName 生产货品id
     * @return 对应的消耗单
     */
    List<Consumption> select(String productionId,
                             String productName);

    /**
     * 编写材料消耗单备注
     * @param remarks 备注
     * @param productionId 生产单id
     * @return 改变行数
     */
    Integer update(String remarks,
                   String productionId);

    /**
     * 删除消耗单
     * @param productionId 生产单id
     * @return 改变行数
     */
    Integer delete(String productionId);
}
