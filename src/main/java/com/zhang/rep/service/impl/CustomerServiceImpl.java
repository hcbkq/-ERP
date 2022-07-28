package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Customer;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.CustomerMapper;
import com.zhang.rep.mapper.OrderMapper;
import com.zhang.rep.mapper.ProvincialAndUrbanStreetsMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.ICustomerService;
import com.zhang.rep.service.ex.*;
import com.zhang.rep.service.impl.hE.HelpEncapsulatingImpl;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ProvincialAndUrbanStreetsMapper provincialAndUrbanStreetsMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper userMapper;

    @Value("${customer.cid.max-count}")
    private Integer maxNumber;


    @Override
    public List<Customer> getByCustomer() {
        List<Customer> result = customerMapper.getByCustomer();

        if (result == null) {
            throw new ListCustomerNotException("返回客户数据异常");
        }
        for (Customer customer : result) {
            customer.setId(null);
            customer.setCreatedUser(null);
            customer.setCreatedTime(null);
            customer.setModifiedTime(null);
            customer.setModifiedUser(null);
        }

        return result;
    }

    @Override
    public void customerNewCustomer(Customer customer, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("管理员账户异常");
        }
        Integer integer = customerMapper.countByTotal();
        if (integer > maxNumber) {
            throw new CustomerCountLimitException("客户数据超出上限异常");
        }
        customer.setHandler(username);

        try {
            if (customer.getProvinceCode() != null) {
                customer.setProvinceName(provincialAndUrbanStreetsMapper
                        .findByProvinceCode(customer.getProvinceCode()).getProvinceName());
            }
        } catch (Exception e) {
            throw new AddressCodeException("省级code错误");
        }
        try {
            if (customer.getCityCode() != null) {
                customer.setCityName(provincialAndUrbanStreetsMapper
                        .findByCityCode(customer.getCityCode()).getCityName());
            }
        } catch (Exception e) {
            throw new AddressCodeException("市级code错误");
        }
        try {
            if (customer.getAreaCode() != null) {
                customer.setAreaName(provincialAndUrbanStreetsMapper
                        .findByAreaCode(customer.getAreaCode()).getAreaName());
            }
        } catch (Exception e) {
            throw new AddressCodeException("区级code错误");
        }

        customer.setOrder(0);
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        HelpEncapsulatingImpl helpEncapsulating = new HelpEncapsulatingImpl();
        String sYear = helpEncapsulating.KeepSum(2, year);
        String sMonth = helpEncapsulating.KeepSum(2, month);
        String sDay = helpEncapsulating.KeepSum(2, day);
        String sHour = helpEncapsulating.KeepSum(2, hour);
        String sMinute = helpEncapsulating.KeepSum(2, minute);
        String sSecond = helpEncapsulating.KeepSum(2, second);

        customer.setCid(sYear + sMonth + sDay + sHour + sMinute + sSecond);

        Date date = new Date();
        customer.setCreatedUser(username);
        customer.setCreatedTime(date);
        customer.setModifiedUser(username);
        customer.setModifiedTime(date);

        Integer row = customerMapper.insert(customer);
        if (row != 1) {
            throw new InsertException("插入时产生异常");
        }
    }

    @Override
    public List<Customer> findByCustomers(@Param("id") Integer id, @Param("cid") String cid,
                                          @Param("username") String username,
                                          @Param("provinceName") String provinceName,
                                          @Param("provinceCode") String provinceCode,
                                          @Param("cityName") String cityName,
                                          @Param("cityCode") String cityCode,
                                          @Param("areaName") String areaName,
                                          @Param("areaCode") String areaCode,
                                          @Param("order") Integer order,
                                          @Param("createdUser") String createdUser,
                                          @Param("modifiedUser") String modifiedUser,
                                          Integer pageNo) {
        if (pageNo == null){
            pageNo = 0;
        }

        List<Customer> result = customerMapper.findByCustomers(id, cid, username, provinceName, provinceCode, cityName,
                cityCode, areaName, areaCode,order, createdUser, modifiedUser,pageNo);
        for (Customer customer : result) {
            customer.setId(null);
            customer.setCreatedUser(null);
            customer.setCreatedTime(null);
            customer.setModifiedTime(null);
            customer.setModifiedUser(null);
        }
        return result;
    }

    @Override
    public void deleteCustomer(String cid,Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("删除客户时用户管理员不存在");
        }

        Integer row = customerMapper.deleteCustomer(cid);

        if (row != 1) {
            throw new DeleteCustomerException("删除时产生异常");
        }
    }

    @Override
    public void updateCustomer(Customer customer, Integer uid, String username) {
        User user = userMapper.findByUid(uid);
        if (user == null) {
            throw new UserNotFoundException("管理员账户异常");
        }
        try {
            if (customer.getProvinceCode() != null) {
                customer.setProvinceName(provincialAndUrbanStreetsMapper
                        .findByProvinceCode(customer.getProvinceCode()).getProvinceName());
            }
        } catch (Exception e) {
            throw new AddressCodeException("省级code错误");
        }
        try {
            if (customer.getCityCode() != null) {
                customer.setCityName(provincialAndUrbanStreetsMapper
                        .findByCityCode(customer.getCityCode()).getCityName());
            }
        } catch (Exception e) {
            throw new AddressCodeException("市级code错误");
        }
        try {
            if (customer.getAreaCode() != null) {
                customer.setAreaName(provincialAndUrbanStreetsMapper
                        .findByAreaCode(customer.getAreaCode()).getAreaName());
            }
        } catch (Exception e) {
            throw new AddressCodeException("区级code错误");
        }
        Date date = new Date();
        customer.setModifiedUser(username);
        customer.setModifiedTime(date);

        Integer row = customerMapper.updateCustomer(customer);
        if (row == 0){
            throw new CustomerUpdateException("修改用户数据错误");
        }
    }

    @Override
    public void updateCustomerAvatar(Integer uid,String username,String cid,String avatar) {
        Customer customer = customerMapper.findByCustomer(cid);
        if (customer == null){
            throw new CustomerNotExistenceException("客户不存在异常");
        }
        Date date = new Date();
        Integer row = customerMapper.updateCustomerAvatar(cid, avatar,username, date);
        if (row != 1){
            throw new CustomerUpdateAvatarException("修改用户头像错误");
        }
    }

    @Override
    public Integer calCustomerCount() {
        return customerMapper.calCustomerCount();
    }

    @Override
    public ArrayList<Object> findCustomerList(Integer pageNo) {
        ArrayList<Object> customers = customerMapper.findCustomerList(pageNo);

        return customers;
    }
}
