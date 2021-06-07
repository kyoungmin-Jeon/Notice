package com.example.qwer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(value = false)
class NoticeMapperTest {

    private NoticeMapper noticeMapper;

    public NoticeMapperTest(@Autowired NoticeMapper noticeMapper){
        this.noticeMapper = noticeMapper;
    }

    @Test
    void save() {
        for (int i = 55; i < 155; i++) {
            Notice notice = new Notice("title"+i, "content"+i, "writer"+i, LocalDateTime.now());
            noticeMapper.save(notice);
        }
    }

    @Test
    void read() {
        Notice notice = noticeMapper.read(1l);

        assertEquals(notice.getNoticeId(), 1l);
    }

    @Test
    void readAll() {
        List<Notice> notices = noticeMapper.readAll();
        notices.stream().forEach(
                notice -> log.info(notice.toString())
        );
    }

    @Test
    void update() {
        Notice notice = noticeMapper.read(1l);
        notice.setContent("Update content");
        int update = noticeMapper.update(notice);
        log.info("update return value: "+update);
    }

    @Test
    void delete() {
        int delete = noticeMapper.delete(55l);
        log.info("delete return value: "+delete);

    }

    @Test
    void sortedNotice() {
        List<Notice> notices = noticeMapper.sortedNotice();
        notices.forEach(
                notice -> log.info(notice.toString())
        );
    }

    @Test
    void pagedNotice(){
        log.info("===== current page is 1 =====");
        PageRequest pageRequest = new PageRequest(1, 10, "ASC", "noticeId");
        int total = noticeMapper.total();
        List<Notice> notices = noticeMapper.pagedNotice(pageRequest);
        Page<Notice> page = new Page<>(1, total, notices);
        log.info(page.toString());
        List<Notice> results = page.getResults();
        results.forEach(notice -> log.info(notice.toString()));

        log.info("===== current page is 2 =====");
        PageRequest pageRequest2 = new PageRequest(2, 10, "ASC", "noticeId");
        int total2 = noticeMapper.total();
        List<Notice> notices2 = noticeMapper.pagedNotice(pageRequest2);
        Page<Notice> page2 = new Page<>(2, total, notices2);
        log.info(page2.toString());
        List<Notice> results2 = page2.getResults();
        results2.forEach(notice -> log.info(notice.toString()));

        log.info("===== current page is 11 =====");
        PageRequest pageRequest11 = new PageRequest(11, 10, "ASC", "noticeId");
        int total11 = noticeMapper.total();
        List<Notice> notices11 = noticeMapper.pagedNotice(pageRequest11);
        Page<Notice> page11 = new Page<>(11, total, notices11);
        log.info(page11.toString());
        List<Notice> results11 = page11.getResults();
        results11.forEach(notice -> log.info(notice.toString()));
    }
}