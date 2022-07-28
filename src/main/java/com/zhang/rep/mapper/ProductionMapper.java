package com.zhang.rep.mapper;

import com.zhang.rep.entity.Production;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ProductionMapper {

    /**
     * 创建生产单
     * @param production 生产单对象
     * @return 改变行数
     */
    Integer insert(Production production);


    /**
     * 查询生产单
     * @param productionId 生产单id
     * @param productId 产品id
     * @param productName 产品名称
     * @param documentNumber 出库单id
     * @param preparer 制单人
     * @param complete 完成或者未完成
     * @param examine 审核
     * @param  pageNo 页码
     * @return 对应的生产单
     */
    List<Production> select(String productionId,
                            Date startOrderDate,Date endOrderDate,
                            Date startDeliveryDate,Date endDeliveryDate,
                            String productId,String productName,
                            String documentNumber,String preparer,
                            Integer complete,Integer examine,Integer pageNo);

    /**
     * 更新生产单数据
     * @param production 生产单对象
     * @return 改变行数
     */
    Integer update(Production production);

    /**
     * 删除生产单
     * @param productionId 生产单id
     * @return 改变行数
     */
    Integer delete(List<String> productionId);

    Integer calProduction();

}
