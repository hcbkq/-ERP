package com.zhang.rep.service;

import com.zhang.rep.entity.Material;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IMaterialService {

    List<Material> getMaterials(@Param("mid") String mid,
                                @Param("label") String label,
                                @Param("name") String name,
                                Integer pageNo);

    void addMaterial(Material material, Integer uid, String username);

    void changeMaterial(@Param("mid") String mid,
                        @Param("purchase") BigDecimal purchase,
                        @Param("materialStatus") Integer materialStatus,
                        @Param("storageTemperature") Integer storageTemperature,
                        @Param("storageMode") Integer storageMode,
                        @Param("ifFlammable") Integer ifFlammable,
                        @Param("ifPoisonous") Integer ifPoisonous,
                        Integer uid, String username);

    void deleteMaterial(List<String> mids, Integer uid, String username);
}
