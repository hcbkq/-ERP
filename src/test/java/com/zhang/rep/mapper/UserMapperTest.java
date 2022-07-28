package com.zhang.rep.mapper;

import com.zhang.rep.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@SpringBootTest
public class UserMapperTest {

    //idea有检查的功能，接口是不能够直接创建bean的
    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void insert() {
//        User user = new User();
//        user.setUsername("zhangsan");
//        user.setPassword("123456");
//
//        Integer insert = userMapper.insert(user);
//        System.out.println(insert);
//    }

    @Test
    public void findByUsername() {
        User user = userMapper.findByUsername("test1");
        System.out.println(user);
    }

    @Test
    public void updatePasswordByUid(){
         userMapper.updatePasswordByUid(1,"321");
    }
    @Test
    public void findByUid(){
        System.out.println( userMapper.findByUid(1));
    }

    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(1);
        user.setPhone("17683990137");
        user.setEmail("test1@qq.com");
        user.setGender(0);
        userMapper.updateInfoByUid(user);
    }
    @Test
    public void test(){
        try {
            System.out.println(Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void updateAvatarByUid(){
        System.out.println(userMapper.updateAvatarByUid(12,"/ud/avatar"));
    }
}
