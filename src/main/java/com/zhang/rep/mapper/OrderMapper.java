package com.zhang.rep.mapper;


import com.zhang.rep.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单持久层接口
 */
@Mapper
public interface OrderMapper {

    /**
     * @return 返回所有订单数据
     */
    List<Order> getByOrders();

    /**
     * 创建订单数据
     *
     * @param order 订单数据
     * @return 受影响的行数
     */
    Integer insert(Order order);

    /**
     * 根据客户唯一标识符查询客户订单数
     *
     * @param cid 客户唯一标识符
     * @return 返回订单数
     */
    Integer countByCid(String cid);

    /**
     * 根据客户唯一唯一表示符查询客户订单
     *
     * @param cid 客户唯一标识符
     * @return 返回订单数据
     */
    List<Order> findByCid(String cid);

    /**
     * 删除订单
     *
     * @param identifierId 订单唯一标识符
     * @return 返回受影响行数
     */
    Integer deleteOrder(String identifierId);

    /**
     * 修改订单备注
     *
     * @param notesDocuments 订单备注属性
     * @param identifierId   订单唯一标识符
     * @return 受影响的行数
     */
    Integer updateNotesDocuments(String notesDocuments, String identifierId);

    /**
     * 根据订单唯一标识符返回订单属性
     *
     * @param identifierId 订单唯一标识符
     * @return 受影响的行数
     */
    List<Order> findByIdentifierId(String identifierId);

    /**
     *
     * @param cid 客户唯一标识符
     * @param identifierId 订单唯一标识符
     * @param startOrderDate 从什么时间开始的下单日期 到
     * @param endOrderDate 从什么时间结束的下单日期
     * @param startDeliveryDate 从什么时间开始的交货日期 到
     * @param endDeliveryDate 从什么时间结束的交货日期
     * @param orderCustomer 订单客户
     * @param reviewer  审核人
     * @param statement 结单
     * @param pageNo 页码
     * @return List<Order
     */
    List<Order> findByOrders(@Param("cid") String cid, @Param("identifierId") String identifierId,
                             @Param("startOrderDate")Date startOrderDate,@Param("endOrderDate") Date endOrderDate,
                             @Param("startDeliveryDate")Date startDeliveryDate,@Param("endDeliveryDate") Date endDeliveryDate,
                             @Param("orderCustomer") String orderCustomer,@Param("reviewer") String reviewer,
                             @Param("statement") Integer statement,
                             Integer pageNo);

    /**
     * 结单
     * @param statement 结单字段
     * @param identifierId 订单唯一标识符
     * @param reviewer 审核人
     * @return 受影响行数
     */
    Integer updateStatement(Integer statement,String reviewer, String identifierId);

    /**
     * month: 本月
     * @return 返回月度完成订单量
     */
    Integer monthly();

    /**
     * day 今天
     * @return 本日完成订单量
     */
    Integer toDay();

    /**
     * NoCompletion：未完成的订单量
     * @return 返回未完成的订单量
     */
    Integer NoCompletion();

    /**
     * 待审核订单量
     * @return 返回审核订单量
     */
    Integer Review();

    /**
     *
     * @return 返回近六个月的每月的订单数
     */
    List<Map<Integer, Integer>> monthOrder();
//    List<Map<Integer, Integer>> monthOrder();

    /**
     * 返回总行数
     * @return
     */
    Integer calOrderCount();
}
