package com.zhang.rep.service;

import com.zhang.rep.entity.Journalism;
import com.zhang.rep.service.impl.JournalismServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JournalismServiceTests {

    @Autowired
    private JournalismServiceImpl journalismService;

    @Test
    public void getByJournalism(){
        List<Journalism> byJournalism = journalismService.getByJournalism();
        System.out.println(byJournalism);
    }
}
