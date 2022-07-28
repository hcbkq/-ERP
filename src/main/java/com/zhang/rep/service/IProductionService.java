package com.zhang.rep.service;

import com.zhang.rep.entity.Production;

import java.util.Date;
import java.util.List;

public interface IProductionService {

    void addProduction(Production production,Integer uid,String username);

    List<Production> getProduction(String productionId,
                                   Date startOrderDate,Date endOrderDate,
                                   Date startDeliveryDate,Date endDeliveryDate,
                                   String productId,String productName,
                                   String documentNumber,String preparer,
                                   Integer complete,Integer examine,Integer pageNo);

    void changeProduction(Production production,
                          Integer uid,String username);

    void deleteProduction(List<String> productionId,Integer uid,String username);

    Integer calProductionCount();
}
