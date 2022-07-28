package com.zhang.rep.mapper;


import com.zhang.rep.entity.Journalism;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.util.List;

@SpringBootTest
public class JournalismMapperTest {

    @Autowired
    private JournalismMapper journalismMapper;

    @Test
    public void getByJournalism(){
        System.out.println(SpringVersion.getVersion());
    }
}
