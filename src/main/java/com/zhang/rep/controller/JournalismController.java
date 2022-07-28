package com.zhang.rep.controller;

import com.zhang.rep.entity.Journalism;
import com.zhang.rep.service.IJournalismService;
import com.zhang.rep.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journalism")
public class JournalismController extends BaseController{

    @Autowired
    private IJournalismService iJournalismMapper;


    @RequestMapping("/getByJournalism")
    public JsonResult<List<Journalism>> getByJournalism(){
        List<Journalism> result = iJournalismMapper.getByJournalism();

        return new JsonResult<>(ok,result);
    }

}
