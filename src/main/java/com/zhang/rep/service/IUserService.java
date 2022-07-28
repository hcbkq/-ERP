package com.zhang.rep.service;

import com.zhang.rep.entity.User;

public interface IUserService {

    /**
     * 用户注册方法
     * @param user  用户的数据对象
     */
    void reg(User user);

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password  用户密码
     * @return 返回当前匹配的用户数据，没有则null
     */
    User login(String username,String password);

    /**
     * 修改密码
     * @param uid 用户id
     * @param oldPassword 原密码
     * @param newPassword 新密码
     */
    void changePassword(Integer uid,
                        String oldPassword,
                        String newPassword);

    /**
     * 根据用户的id查询数据
     * @param uid   用户id
     * @return  用户数据
     */
    User getByUid(Integer uid);

    /**
     * 更新用户数据
     * @param uid   用户的id
     * @param user  用户对象的数据
     * @param username 用户名
     */
    void changeInfo(Integer uid,String username,User user);

    /**
     * 修改用户头像
     * @param uid 用户的id
     * @param avatar 用户的头像
     */
    void changeAvatar(Integer uid,String avatar);
}
