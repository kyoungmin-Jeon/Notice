package com.example.qwer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeMapper noticeMapper;

    public void save(Notice notice){
        noticeMapper.save(notice);
    }

    public Notice read(long noticeId){
        Notice notice = noticeMapper.read(noticeId);
        return notice;
    }

    public List<Notice> readAll(){
        List<Notice> notices = noticeMapper.readAll();
        return notices;
    }

    public int update(Notice notice){
        int update = noticeMapper.update(notice);
        return update;
    }

    public int delete(long noticeId){
        int delete = noticeMapper.delete(noticeId);
        return delete;
    }

    public List<Notice> sortedNotice(){
        List<Notice> notices = noticeMapper.sortedNotice();
        return notices;
    }
}
