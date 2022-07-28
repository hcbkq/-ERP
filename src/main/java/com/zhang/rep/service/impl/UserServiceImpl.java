package com.zhang.rep.service.impl;

import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.IUserService;
import com.zhang.rep.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * 用户模块业务层的实现类
 */
@Service
//将当前类交给spring进行管理
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if (result != null) {
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //密码加密处理的实现 MD5算法
        // 字符串 + password + 字符串  === MD5算法进行加密，连续三次
        //盐值：随机字符串
        String oldPassword = user.getPassword();

        //获取盐值(随机生产一个盐值)
        String salt = UUID.randomUUID().toString().toUpperCase();
        //j记录盐值
        user.setSalt(salt);
        //将密码和盐值作为一个整体进行加密处理
        String md5Password = getMD5Password(oldPassword, salt);

        user.setPassword(md5Password);

        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知异常,请联系管理员进行修复");
        }
    }

    @Override
    public User login(String username, String password) {

        User result = userMapper.findByUsername(username);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }

        //获取到用户密码
        String oldPassword = result.getPassword();
        //获取到用户盐值
        String salt = result.getSalt();
        //获取到用户输入的密码加密后的md5密码
        String md5Password = getMD5Password(password, salt);

        //比较用户输入的密码是否正确
        if (!md5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码验证错误");
        }

        if (result.getIsDelete() == 1) {
            throw new UserNotFoundException("用户已注销");
        }
        User user = new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());

        return user;
    }

    @Override
    public void changePassword(Integer uid, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        //原始密码和数据库中密码进行比较
        String oldMD5Password = getMD5Password(oldPassword, result.getSalt());
        if (!result.getPassword().equals(oldMD5Password)) {
            throw new PasswordNotMatchException("密码错误");
        }
        //将新密码设置到数据库中，将新的密码进行加密再去更新
        String newMd5Password = getMD5Password(newPassword, result.getSalt());
        Integer row = userMapper.updatePasswordByUid(uid, newMd5Password);
        if (row != 1) {
            throw new UpdateException("更新时产生未知的异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)) {
            throw new UserNotFoundException("用户数据不存在");
        }
        User user = new User();
        user.setAvatar(result.getAvatar());
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    /**
     *user对象中的数据phone，email，gender，手动添加uid进行封装
     */
    @Override
    public void changeInfo(Integer uid,String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1) ){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setUsername(username);
        Integer row = userMapper.updateInfoByUid(user);
        if (row != 1){
            throw new UpdateException("更新数据时产生未知异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar) {
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete().equals(1)){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer row = userMapper.updateAvatarByUid(uid, avatar);
        if (row != 1){
            throw new UpdateException("修改用户头像时产生未知异常");
        }
    }

    private String getMD5Password(String password, String salt) {
        //md5加密算法的调用
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        //返回加密的密码
        return password;
    }
}
