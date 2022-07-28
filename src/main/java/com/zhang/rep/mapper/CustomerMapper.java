package com.zhang.rep.mapper;

import com.zhang.rep.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**客户属性接口*/
@Mapper
public interface CustomerMapper {


    /**
     * 返回
     * @return 所有客户信息
     */
    List<Customer> getByCustomer();

    /**
     * 插入客户数据
     * @param customer 客户数据
     * @return  受影响的行数
     */
    Integer insert(Customer customer);

    /**
     * 查询总客户数
     * @return 返回总客户数
     */
    Integer countByTotal();

    /**
     * 查询指定id的客户信息
     * @param cid 客户唯一标识符
     * @return 返回指定id的数据
     */
    Customer findByCustomer(String cid);

    /**
     * 动态查询用户信息
     * @param id 客户唯一id
     * @param cid 客户唯一标识符
     * @param username 客户名字
     * @param provinceName 省-名称
     * @param provinceCode 省-行政代号
     * @param cityName 市-行政名称
     * @param cityCode 市-行政代号
     * @param areaName 区-行政名称
     * @param areaCode 区-行政代号
     * @param createdUser 创建人
     * @param modifiedUser 修改人
     * @return 返回相关客户
     */
    List<Customer> findByCustomers(@Param("id") Integer id,@Param("cid") String cid
                                    ,@Param("username") String username,
                                   @Param("provinceName") String provinceName,
                                   @Param("provinceCode") String provinceCode,
                                   @Param("cityName") String cityName,
                                   @Param("cityCode") String cityCode,
                                   @Param("areaName") String areaName,
                                   @Param("areaCode") String areaCode,
                                   @Param("order") Integer order,
                                   @Param("createdUser") String createdUser,
                                   @Param("modifiedUser") String modifiedUser,
                                   Integer page);

    /**
     * 检查客户是否存在订单,更新订单是否存在状态状态
     * @param cid 客户唯一标识符
     * @param order 客户订单是否存在状态
     * @return 返回改变行数
     */
    Integer updateIFOrderByCid(String cid, Integer order);

    Integer deleteCustomer(String cid);

    /**
     * 修改客户头像
     * @param avatar 头像
     * @param cid 客户唯一id
     * @return 返回改变行数
     */
    Integer updateCustomerAvatar(String cid, String avatar, String modifiedUser, Date modifiedTime);

    /**
     * 修改客户数据
     * @param customer 客户数据
     * @return 返回改变行数
     */
    Integer updateCustomer(Customer customer);


    /**
     *
     * @return 返回页面总行数
     */
    Integer calCustomerCount();

    /**
     * 分页操作
     * @param pageNo 从那条数据开始
     * @return 对应页面的数据
     */
    ArrayList<Object> findCustomerList(Integer pageNo);

}
