package com.zhang.rep.service.impl;

import com.zhang.rep.entity.Journalism;
import com.zhang.rep.mapper.JournalismMapper;
import com.zhang.rep.service.IJournalismService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalismServiceImpl implements IJournalismService {

    @Autowired
    private JournalismMapper journalismMapper;
    @Override
    public List<Journalism> getByJournalism() {

        return journalismMapper.getByJournalism();
    }
}
