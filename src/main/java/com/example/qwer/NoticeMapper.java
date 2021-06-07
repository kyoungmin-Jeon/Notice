package com.example.qwer;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    //CRUD

    void save(Notice notice);
    Notice read(long noticeId);
    List<Notice> readAll();
    int update(Notice notice);
    int delete(long noticeId);

    //sorting
    List<Notice> sortedNotice();

    //paging & sorting
    int total();
    List<Notice> pagedNotice(PageRequest pageRequest);
}
