package com.zhang.rep.service;

import com.zhang.rep.entity.ManufacturingMaterials;

import java.util.List;

public interface IManufacturingMaterialsService {
    void addManufacturingMaterials(List<ManufacturingMaterials> manufacturingMaterials,Integer uid,String username);

    List<ManufacturingMaterials> getManufacturingMaterials(String productId,
                                                           String productName);

    void changeManufacturingMaterials(Integer quantity,String remarks,String productId,String mid,
                                      Integer uid,String username);

    void deleteManufacturingMaterials(String productId,String mid,
                                      Integer uid,String username);

}
