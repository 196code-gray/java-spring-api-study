package com.project.springapistudy.exception;

import lombok.Getter;

public enum ErrorCode {
    SAME_NAME("이미 같은 이름이 있습니다."),
    MENU_NOT_FOUND("해당 메뉴를 찾을 수 없습니다.");

    @Getter
    private String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
