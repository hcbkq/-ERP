package com.zhang.rep.mapper;

import com.zhang.rep.entity.Journalism;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JournalismMapper {
    List<Journalism> getByJournalism();
}
