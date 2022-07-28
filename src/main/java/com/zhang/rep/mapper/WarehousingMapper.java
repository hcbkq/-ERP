package com.zhang.rep.mapper;

import com.zhang.rep.entity.Warehousing;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WarehousingMapper {

    /**
     * 创建入库,出库单
     * @param warehousing 入库单
     * @return 改变行数
     */
    Integer insert(Warehousing warehousing);

    /**
     * 查询出库入库单
     * @param documentNumber 单据唯一标识符：单据号码
     * @param documentType 单据类型
     * @param uniqueIdentifier 货品唯一标识符
     * @param productName 货品名称
     * @param InAndOut 0=入库，1=出库
     * @param implement 执行或者未执行
     * @param pageNo 页码
     * @return 出库或入库单
     */
    List<Warehousing> select(String documentNumber,
                             String documentType,
                             String uniqueIdentifier,
                             String productName,
                             Integer InAndOut,
                             Integer implement,
                             Integer pageNo);

    /**
     * 修改备注
     * @param remarks 修改备注
     * @param documentNumber 唯一标识符
     * @param implement 判断依据
     * @return 改变行数
     */
    Integer update(String remarks,Integer implement,String documentNumber);

    /**
     * 更新货品是否执行成功
     * @param implement 判断依据
     * @param documentNumber 货品唯一标识符
     * @return 改变行数
     */
    Integer Execute(Integer implement,String documentNumber);
    /**
     * 删除
     * @param documentNumber 唯一标识符
     * @return 改变行数
     */
    Integer delete(List<String> documentNumber);

    /**
     *
     * @return 总行数
     */
    Integer calWarehousingCount();


}
