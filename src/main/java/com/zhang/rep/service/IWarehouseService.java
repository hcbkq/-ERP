package com.zhang.rep.service;

import com.zhang.rep.entity.Warehouse;

import java.util.List;

public interface IWarehouseService {


    List<Warehouse> getByWarehouses(Integer kid,
                                    String goodsId,
                                    String goodsName,
                                    Integer productsOrMaterials,
                                    Integer pageNo);


    void deleteWarehouse(int kid,Integer uid, String username);

    void changeWarehouse(String goodsId,
                         String remarks,Integer uid, String username);
}
