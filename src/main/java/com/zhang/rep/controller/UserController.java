package com.zhang.rep.controller;

import com.zhang.rep.controller.ex.*;
import com.zhang.rep.entity.User;
import com.zhang.rep.service.IUserService;
import com.zhang.rep.service.ex.InsertException;
import com.zhang.rep.service.ex.UsernameDuplicatedException;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;


    @Autowired
    private GlobalSession globalSession;

    /**
     * 约定大于配置
     * 1.接受数据方式：请求处理方法的参数列表设置为pojo类型来接受前端的数据
     * SpringBoot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果
     * 者两个名称项目，则将值注入到pojo类中对应的属性上
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        userService.reg(user);
        return new JsonResult<Void>(ok);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password ,HttpSession session){

        User data = userService.login(username, password);
        Integer uid = data.getUid();
        String username1 = data.getUsername();
        session.setAttribute("uid",uid);
        session.setAttribute("username",username);
        globalSession.set("loginSession",session);
        return new JsonResult<>(ok);
    }



    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword,
                                           String newPassword,
                                           HttpSession session){

        userService.changePassword((Integer) globalSession.get("loginSession").getAttribute("uid"),
                oldPassword,newPassword);
        return new JsonResult<>(ok);

    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session){


        User data = userService.getByUid((Integer) globalSession.get("loginSession").getAttribute("uid"));
        System.out.println("======date======");
        System.out.println(data);
        System.out.println(new JsonResult<>(ok,data));
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user,HttpSession session){
        userService.changeInfo((Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"),user);
        return new JsonResult<>(ok);
    }

    /** 头像文件大小的上限值(10MB) */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /** 允许上传的头像的文件类型 */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }
    /**
     * MultipartFile是SpringMVC中的一个封装类，可以用来获取任何类型的文件
     * Springboot会自动将文件数据赋值给此参数
     *
     * RequestParam解决前后端命名不一致问题
     * @param session
     * @param file
     * @return
     */
    @RequestMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session,
                                           @RequestParam("file") MultipartFile file){

        // 判断上传的文件是否为空
        if (file.isEmpty()) {
            // 是：抛出异常
            throw new FileEmptyException("上传的头像文件不允许为空");
        }

        // 判断上传的文件大小是否超出限制值
        if (file.getSize() > AVATAR_MAX_SIZE) { // getSize()：返回文件的大小，以字节为单位
            // 是：抛出异常
            throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的头像文件");
        }

        // 判断上传的文件类型是否超出限制
        String contentType = file.getContentType();
        // boolean contains(Object o)：当前列表若包含某元素，返回结果为true；若不包含该元素，返回结果为false
        if (!AVATAR_TYPES.contains(contentType)) {
            // 是：抛出异常
            throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：" + AVATAR_TYPES);
        }
        // 获取当前项目的绝对磁盘路径
//        String parent = session.getServletContext().getRealPath("upload");
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        String parent = jarF.getParentFile().toString()+"/classes/static/images/user/";
        System.out.println(parent);
        // 保存头像文件的文件夹
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 保存的头像文件的文件名
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
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
            // 抛出异常
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            // 抛出异常
            throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
        }

        // 头像路径
        String avatar = "images/user/" + filename;
        // 从Session中获取uid和username
        Integer uid = (Integer) globalSession.get("loginSession").getAttribute("uid");
        String username = (String) globalSession.get("loginSession").getAttribute("username");
        // 将头像写入到数据库中
        userService.changeAvatar(uid, avatar);
        System.out.println(parent);
        // 返回成功头像路径
        return new JsonResult<String>(ok, avatar);
    }

}
