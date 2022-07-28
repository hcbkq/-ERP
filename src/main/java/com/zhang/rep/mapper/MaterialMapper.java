package com.zhang.rep.mapper;

import com.zhang.rep.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Mapper
public interface MaterialMapper {

    /**
     * 插入原材料
     *
     * @param material 原材料数据
     * @return 改变行数
     */
    Integer insertMaterial(Material material);

    /**
     * 根据参数查询对应的材料
     * @param mid 唯一标识符
     * @param label 赋予标号
     * @param name 材料名字
     * @return 对应的材料
     */
    List<Material> getMaterials(@Param("mid") String mid,
                                @Param("label") String label,
                                @Param("name") String name,
                                Integer pageNo);

    /**
     * 更新材料字段
     * @param  mid 材料id
     * @param materialStatus 材料状态
     * @param storageTemperature 储存温度
     * @param storageMode 储存方式
     * @param ifFlammable 材料是否易燃
     * @param ifPoisonous 材料是否有毒
     * @param modifiedUser  修改人
     * @param modifiedTime  修改时间
     * @return 改变的行数
     */
    Integer updateMaterial(@Param("mid") String mid,
                           @Param("purchase") BigDecimal purchase,
                           @Param("materialStatus") Integer materialStatus,
                           @Param("storageTemperature") Integer storageTemperature,
                           @Param("storageMode") Integer storageMode,
                           @Param("ifFlammable") Integer ifFlammable,
                           @Param("ifPoisonous") Integer ifPoisonous,
                           @Param("modifiedUser") String modifiedUser,
                           @Param("modifiedTime") Date modifiedTime);

    Integer selectMaterial(String label);

    /**
     * 删除材料
     * @param mids 材料id集合
     * @return 改变的行数
     */
    Integer deleteMaterial(List<String> mids);
}
