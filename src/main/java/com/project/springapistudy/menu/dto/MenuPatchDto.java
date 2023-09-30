package com.project.springapistudy.menu.dto;

import lombok.Getter;

import javax.validation.constraints.Positive;

@Getter
public class MenuPatchDto {
    private String name;
    @Positive
    private int price;
}
