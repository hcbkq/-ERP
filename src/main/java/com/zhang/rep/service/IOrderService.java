package com.zhang.rep.service;

import com.zhang.rep.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IOrderService {

    List<Order> getByOrders();

    Map<String, String> OrderNetOrder(Order order, String cid, Integer uid, String username);

    List<Order> getByCidOrders(String cid);

    void deleteOrder(String identifierId,Integer uid,String username);

    void updateNotesDocument(String notesDocuments, String identifierId);

    List<Order> findByOrders(@Param("cid") String cid, @Param("identifierId") String identifierId,
                             @Param("startOrderDate")Date startOrderDate,@Param("endOrderDate") Date endOrderDate,
                             @Param("startDeliveryDate")Date startDeliveryDate,@Param("endDeliveryDate") Date endDeliveryDate,
                             @Param("orderCustomer") String orderCustomer, @Param("reviewer") String reviewer,
                             @Param("statement") Integer statement,Integer pageNo);

    void updateStatement(Integer statement, String identifierId,Integer uid,String username);

    Integer calOrderCount();
}
