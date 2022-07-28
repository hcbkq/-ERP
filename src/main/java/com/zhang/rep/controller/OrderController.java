package com.zhang.rep.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.zhang.rep.entity.Order;
import com.zhang.rep.mapper.OrderMapper;
import com.zhang.rep.service.IOrderService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.zhang.rep.controller.BaseController.ok;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private IOrderService iOrderService;

    @Autowired
    private GlobalSession globalSession;


//    @RequestMapping("/getByOrders")
//    public JsonResult<List<Order>> getByOrders() {
//        List<Order> data = iOrderService.getByOrders();
//
//        return new JsonResult<>(ok, data);
//    }

    @RequestMapping("/deleteOrder")
    public JsonResult<Void> deleteOrder(String identifierId,HttpSession session) {
        iOrderService.deleteOrder(identifierId,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("/OrderNetOrder")
    public JsonResult<Map<String, String>> OrderNetOrder(Order order, HttpSession session) {

        Map<String, String> stringStringMap =
                iOrderService.OrderNetOrder(order, order.getCid(), (Integer) globalSession.get("loginSession").getAttribute("uid"),
                        (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }

    @RequestMapping("updateNotesDocument")
    public JsonResult<Void> updateNotesDocument(String notesDocuments, String identifierId) {
        iOrderService.updateNotesDocument(notesDocuments, identifierId);
        return new JsonResult<>(ok);
    }

    @RequestMapping("findByOrders")
    public JsonResult<List<Order>> findByOrders(@Param("cid") String cid, @Param("identifierId") String identifierId,
                                                @Param("startOrderDate")Date startOrderDate,@Param("endOrderDate") Date endOrderDate,
                                                @Param("startDeliveryDate")Date startDeliveryDate,@Param("endDeliveryDate") Date endDeliveryDate,
                                                @Param("orderCustomer") String orderCustomer, @Param("reviewer") String reviewer,
                                                @Param("statement") Integer statement,
                                                @Param("page") Integer page) {

        List<Order> orders = iOrderService.findByOrders(cid, identifierId,
                startOrderDate, endOrderDate,
                startDeliveryDate, endDeliveryDate,
                orderCustomer, reviewer, statement,page);
        return new JsonResult<>(ok, orders);
    }

    @RequestMapping("updateStatement")
    public JsonResult<Void> updateStatement(Integer statement,String identifierId,HttpSession session){
        iOrderService.updateStatement(statement,identifierId,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));

        return new JsonResult<>(ok);
    }
}
