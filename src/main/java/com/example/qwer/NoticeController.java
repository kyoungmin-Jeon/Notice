package com.example.qwer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

}
