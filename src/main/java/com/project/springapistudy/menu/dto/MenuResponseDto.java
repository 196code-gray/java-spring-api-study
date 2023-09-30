package com.project.springapistudy.menu.dto;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class MenuResponseDto {
    private String name;
    private int price;
}
