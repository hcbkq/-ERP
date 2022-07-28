package com.zhang.rep.service;

import com.zhang.rep.entity.Warehousing;

import java.util.List;

public interface IWarehousingService {

    List<Warehousing> getByWarehousing(String documentNumber,
                                       String documentType,
                                       String uniqueIdentifier,
                                       String productName,
                                       Integer inAndOut,
                                       Integer implement,
                                       Integer pageNo);

    void addWarehousing(Warehousing warehousing, Integer InAndOut, Integer uid, String username);

    void changeWarehousing(String remarks,Integer implement, String documentNumber, Integer uid, String username);

    void deleteWarehousing(List<String> documentNumber, Integer uid, String username);

    Integer calWarehousingCount();

}
