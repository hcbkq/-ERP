package com.zhang.rep.controller;

import com.zhang.rep.entity.BaseEntity;
import com.zhang.rep.entity.Category;
import com.zhang.rep.service.ICategoryService;
import com.zhang.rep.util.GlobalSession;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("category")
public class CategoryController extends BaseController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private GlobalSession globalSession;

    @RequestMapping("getCategory")
    public JsonResult<List<Category>> getCategory(){
        List<Category> data = categoryService.getCategory();
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("addCategory")
    public JsonResult<Void> addCategory(Category category, HttpSession session){
        categoryService.addCategory(category,(Integer) globalSession.get("loginSession").getAttribute("uid"),
                (String) globalSession.get("loginSession").getAttribute("username"));
        return new JsonResult<>(ok);
    }

}
