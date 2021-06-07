package com.example.qwer;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {
    private long noticeId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdDate;

    public Notice(String title, String content, String writer, LocalDateTime createdDate) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdDate = createdDate;
    }
}
