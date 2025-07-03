package com.onetouch.boards.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDto {
    private Integer id;
    private String username;

    // 기본 생성자 필요 (JSON 매핑용)
    public UserInfoDto() {
    }
}
