package com.zhang.rep.controller;




import com.zhang.rep.controller.ex.*;
import com.zhang.rep.entity.Customer;
import com.zhang.rep.entity.hp.PageInformation;
import com.zhang.rep.mapper.CustomerMapper;
import com.zhang.rep.service.ICustomerService;

import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import io.swagger.models.Model;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseController{

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private GlobalSession globalSession;

//    @RequestMapping("/getByCustomer")
//    public JsonResult<Object> getByCustomer(){
//        List<Customer> data = customerService.getByCustomer();
//        return new JsonResult<>(ok,data);
//    }

//   @RequestMapping("/getByCustomerPage")
//    public JsonResult<PageInformation> getByCustomerPage(@Param("page") Integer page){
//       Integer count = customerService.calCustomerCount();
//       PageInformation pageInformation = TotalPages(page, count);
//       ArrayList<Object> customerList = customerService.findCustomerList(pageInformation.getLibraryPageNo());
//       pageInformation.setList(customerList);
//       return new JsonResult<>(ok,pageInformation);
//   }

   @RequestMapping("getBuCustomerPages")
   public JsonResult<Map<String, Integer>> getBuCustomerPages(){
       Map<String, Integer> map = new HashMap<>();
       Integer count = customerService.calCustomerCount();
       map.put("total",count);
       map.put("PageSize",8);

       return new JsonResult<>(ok,map);

   }

    @RequestMapping("/customer_new_customer")
    public JsonResult<Void> customerNewCustomer(Customer customer, HttpSession session){
        customerService.customerNewCustomer(customer,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("/findByCustomers")
    public JsonResult<PageInformation> findByCustomers(@Param("id") Integer id, @Param("cid") String cid,
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
                                                          @Param("page") Integer page){


        Integer calCustomerCount = customerService.calCustomerCount();
        PageInformation pageInformation = TotalPages(page, calCustomerCount);
        List<Customer> data = customerService.findByCustomers(id, cid, username, provinceName,
                provinceCode, cityName, cityCode, areaName, areaCode,order, createdUser,
                modifiedUser, pageInformation.getLibraryPageNo());
        pageInformation.setList(Collections.singletonList(data));
        return new JsonResult<>(ok,pageInformation);

    }

    @RequestMapping("/deleteCustomer")
    public JsonResult<Void> deleteCustomer(String cid, HttpSession session){
        System.out.println(cid);
        customerService.deleteCustomer(cid,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("updateCustomer")
    public JsonResult<Void> updateCustomer(Customer customer,HttpSession httpSession){
        customerService.updateCustomer(customer,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

    @RequestMapping("updateCustomerAvatar")
    public JsonResult<String> updateCustomerAvatar(HttpSession session,String cid,@RequestParam("file") MultipartFile file){

        if (file.isEmpty()) {
            throw new FileEmptyException("上传的头像文件不允许为空");
        }

        if (file.getSize() > AVATAR_MAX_SIZE) {
            throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的头像文件");
        }
        String contentType = file.getContentType();
        if (!AVATAR_TYPES.contains(contentType)) {
            // 是：抛出异常
            throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：" + AVATAR_TYPES);
        }
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String parent = jarF.getParentFile().toString()+"/classes/static/images/customer/";
        System.out.println(parent);
        // 保存头像文件的文件夹
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 保存的头像文件的文件名
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString() + suffix;

        // 创建文件对象，表示保存的头像文件
        File dest = new File(dir, filename);  //是一个空文件
        // 执行保存头像文件
        try {
            file.transferTo(dest);  //将file中的文件写入dest中
        } catch (IllegalStateException e) {
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
        }

        // 头像路径
        String avatar = "images/customer/" + filename;
        // 从Session中获取uid和username
        Integer uid = getuidFormSession(session);
        String username = getUsernameFromSession(session);
        customerService.updateCustomerAvatar((Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"),cid,avatar);
        System.out.println(parent);
        // 返回成功头像路径
        return new JsonResult<String>(ok, avatar);
    }

}
