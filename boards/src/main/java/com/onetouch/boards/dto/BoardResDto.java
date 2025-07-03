package com.onetouch.boards.dto;

import lombok.*;

@Getter
@Setter
@Builder
public class BoardResDto {
    private Long id;
    private String title;
    private String content;
    private String authorUsername;  // 이건 user 서비스에서 가져옴
}
