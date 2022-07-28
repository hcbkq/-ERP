package com.zhang.rep.service.impl;

import com.zhang.rep.entity.*;
import com.zhang.rep.mapper.*;
import com.zhang.rep.service.IOrderService;
import com.zhang.rep.service.ex.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private WarehousingServiceImpl warehousingService;

    @Autowired
    private ProductMapper productMapper;


    @Value("${order..cid.max-count}")
    private Integer maxNumber;

    @Override
    public List<Order> getByOrders() {
        return orderMapper.getByOrders();
    }

    @Override
    public List<Order> getByCidOrders(String identifierId) {

        Customer customer = customerMapper.findByCustomer(identifierId);
        if (customer == null) {
            throw new CustomerNotExistenceException("客户数据不存在");
        }

        return orderMapper.findByCid(customer.getCid());
    }

    @Transactional(rollbackFor = ServiceException.class)
    @Override
    public Map<String, String> OrderNetOrder(Order order, String cid, Integer uid, String username) {

        Map<String, String> stringStringMap = new HashMap<>();

        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("创建时用户管理员不存在错误");
        }

        Customer rs = customerMapper.findByCustomer(cid);
        if (rs == null) {
            throw new CustomerNotExistenceException("客户不存在");
        }
        Integer row = orderMapper.countByCid(cid);
        if (row == 0) {
            Integer integer = customerMapper.updateIFOrderByCid(cid, 1);
            if (integer == 0) {
                throw new CustomerUpdateIFOrderException("改变客户是否含有订单异常");
            }
        }
        if (row > maxNumber) {
            throw new OrderCountLimitException("客户订单量以达到上限");
        }

        Product product = productMapper.fidByProduct(order.getOrderProduct());
        System.out.println("112"+product);
        if (product == null){
            throw new SelectProductException("订单所需产品不存在");
        }
        order.setStatement(0);
        order.setCid(cid);

        Date date = new Date();
        long time = date.getTime();
        String timeID = String.valueOf(time);
        String identifierId = cid + timeID.substring(timeID.length() - 4);
        order.setIdentifierId(identifierId);
        order.setReviewer(username);
        order.setOrderDate(date);

        String orderProduct = order.getOrderProduct();

        Integer result = orderMapper.insert(order);
        if (result != 1) {
            throw new InsertException("插入时产生异常");
        }



        Contract contract = new Contract();
        contract.setCustomerCid(rs.getCid());
        contract.setCustomerUsername(rs.getUsername());
        contract.setOrderOid(identifierId);
        contract.setOrderProduct(order.getOrderProduct());
        contract.setOrderCompletion(0);
        contract.setAmountMoney(new BigDecimal(0));
        contract.setFirstMoney(new BigDecimal(0));
        contract.setMiddleMoney(new BigDecimal(0));
        contract.setMyLiquidatedDamages(new BigDecimal(0));
        contract.setCustomerLiquidatedDamages(new BigDecimal(0));
        contract.setCreatedUser(username);
        contract.setCreatedTime(date);
        contract.setModifiedUser(username);
        contract.setModifiedTime(date);

        Integer integer = contractMapper.insertNewContract(contract);
        if (integer == 0) {
            throw new InsertNewContractException("创建合同时产生错误");
        }
        stringStringMap.put("合同","合同创建成功需审核提交");


        Warehousing warehousing = new Warehousing();
        warehousing.setUniqueIdentifier(product.getProductId());
        warehousing.setProductName(product.getProductName());
        warehousing.setProductType(product.getProductType());
        warehousing.setCompany(product.getCompany());
        warehousing.setQuantity(order.getOrderQuantity());
        warehousingService.addWarehousing(warehousing,1,uid,username);

        System.out.println(warehousing);
        stringStringMap.put("出库单","订单创建成功待审核");

        return stringStringMap;
    }

    @Override
    public void deleteOrder(String identifierId, Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("删除时用户管理员不存在错误");
        }

        Integer row = orderMapper.deleteOrder(identifierId);
        if (row == 0) {
            throw new DeleteOrderException("删除客户时产生错误");
        }
    }

    @Override
    public void updateNotesDocument(String notesDocuments, String identifierId) {
        Integer row = orderMapper.updateNotesDocuments(notesDocuments, identifierId);
        if (row == 0) {
            throw new UpdateNotesDocumentException("修改订单备注错误");
        }
    }

    @Override
    public List<Order> findByOrders(String cid, String identifierId, Date startOrderDate,  Date endOrderDate,
                                    Date startDeliveryDate,  Date endDeliveryDate,
                                    String orderCustomer, String reviewer, Integer statement,Integer pageNo) {
        if (pageNo == null){
            pageNo = 0;
        }
        System.out.println(pageNo);
        return orderMapper.findByOrders(cid, identifierId, startOrderDate, endOrderDate,
                startDeliveryDate, endDeliveryDate,
                orderCustomer, reviewer, statement,pageNo);
    }

    @Override
    public void updateStatement(Integer statement,String identifierId, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("修改时用户管理员不存在错误");
        }

        Integer row = orderMapper.updateStatement(statement, username, identifierId);
        if (row == 0){
            throw new UpdateStatementException("结单时产生未知错误");
        }
    }

    @Override
    public Integer calOrderCount() {
        return orderMapper.calOrderCount();
    }

}
