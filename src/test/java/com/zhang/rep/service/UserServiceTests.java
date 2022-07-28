package com.zhang.rep.service;

import com.zhang.rep.entity.User;
import com.zhang.rep.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private IUserService userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("test1");
            user.setPassword("123456");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User user = userService.login("test1", "123456");
        System.out.println(user);
    }

    @Test
    public void changePassword() {
        userService.changePassword(9, "123456", "654321");
    }

    @Test
    public void getByUid() {
        System.out.println(userService.getByUid(12));
    }

    @Test
    public void changeInfo(){
        User user = new User();

        user.setPhone("1008611");
        user.setEmail("10086@qq.com");
        user.setGender(0);
        userService.changeInfo(12,"test1",user);
    }
//
//    @Test
//    public void changeAvatar(){
//        userService.changeAvatar(12,"/up/test.png");
//    }
}
