package com.zhang.rep.mapper;

import com.zhang.rep.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    Integer insert(Category category);

    List<Category> select(String name);
}
