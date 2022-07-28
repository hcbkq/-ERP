package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Category;
import com.zhang.rep.entity.User;
import com.zhang.rep.mapper.CategoryMapper;
import com.zhang.rep.mapper.UserMapper;
import com.zhang.rep.service.ICategoryService;
import com.zhang.rep.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Category> getCategory() {
        return categoryMapper.select(null);
    }

    @Override
    public void addCategory(Category category,Integer uid, String username) {

        User user = userMapper.findByUid(uid);
        if (user == null){
            throw new UserNotFoundException("添加时用户不存在异常");
        }

        categoryMapper.insert(category);
    }
}
