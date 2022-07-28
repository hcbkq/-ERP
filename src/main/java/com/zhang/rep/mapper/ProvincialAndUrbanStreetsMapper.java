package com.zhang.rep.mapper;

import com.zhang.rep.entity.Area;
import com.zhang.rep.entity.City;
import com.zhang.rep.entity.Province;
import com.zhang.rep.entity.Street;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvincialAndUrbanStreetsMapper {

    /**
     *
     * @return 返回中国所有省
     */
    List<Province> findByProvince();

    /**
     * 根据省代号查询省名称
     * @param provinceCode 省代号
     * @return 返回省名称
     */
    Province findByProvinceCode(String provinceCode);

    /**
     * 更具省级代号查询市级信息
     * @param provinceCode  省级code
     * @return 关于省级代号的所有市
     */
    List<City> findByCity(String provinceCode);

    /**
     * 根据市级代号查询市级信息
     * @param CityCode  市级代号
     * @return 返回市级名称
     */
    City findByCityCode(String CityCode);
    /**
     * 更具市级代号查询区级信息
     * @param cityCode 市级code
     * @return 返回关于市级代号的所有区
     */
    List<Area> findByArea(String cityCode);

    /**
     * 根据区级代号查询区级信息
     * @param areaCode 区级code
     * @return 反思区级名称
     */
    Area findByAreaCode(String areaCode);

    /**
     * 根据区级代号查询街道信息
     * @param areaCode 街道code
     * @return 返回关于区级代号的街道
     */
    List<Street> findByStreet(String areaCode);

    /**
     * 根据街道代号查询街道信息
     * @param streetCode 街道code
     * @return 街道名称
     */
    Street findByStreetCode(String streetCode);
}
