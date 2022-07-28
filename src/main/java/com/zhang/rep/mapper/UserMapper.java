package com.zhang.rep.mapper;

import com.zhang.rep.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * 插入用户数据
     * @param user 用户数据
     * @return 受影响的行数（增删改查都受影响的行数作为返回值，根据值判断是否成功）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户数据
     * @param username  用户名
     * @return  返回相当于的用户属性，如果没找到返回null值
     */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改用户密码
     * @param uid 用户的id
     * @return 返回值为受影响的行数
     */
    Integer updatePasswordByUid(Integer uid,String password);

    /**
     * 根据用户的id查询用户的数据
     * @param uid   用户的id
     * @return  如果找到则返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     * 更新用户数据
     * @param user  用户数据
     * @return  返回受影响的行数
     */
    Integer updateInfoByUid(User user);

    /**
     * @Param(SQL映射文件中#{}的占位符的变量名)解决不一致问题
     * 修改用户头像
     * @param uid 用户id
     * @param avatar 用户头像
     * @return 返回受影响的行数
     */
    Integer updateAvatarByUid(@Param("uid") Integer uid,
                              @Param("avatar") String avatar);
}
