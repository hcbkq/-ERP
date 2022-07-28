package com.zhang.rep.service;

import com.zhang.rep.entity.Consumption;

import java.util.List;

public interface IConsumptionService {

    void addConsumption(Consumption consumption, Integer uid, String username);

    List<Consumption> getConsumption(String productionId,
                                     String productName);

    void changeConsumption(String remarks,
                           String productionId, Integer uid);

    void deleteConsumption(String productionId, Integer uid);
}
