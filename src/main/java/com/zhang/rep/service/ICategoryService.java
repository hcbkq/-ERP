package com.zhang.rep.service;

import com.zhang.rep.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategory();

    void addCategory(Category category,Integer uid, String username);
}
