package com.project.springapistudy.menu.dto;

import com.project.springapistudy.menu.domain.Menu;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
public class MenuPostDto {
    @NotBlank(message = "메뉴 이름은 필수입니다.")
    private String name;

    @NotNull(message = "가격은 필수입니다.")
    private int price;

    @Builder
    public Menu toEntity(String name, int price) {
        return Menu.builder()
                .price(price)
                .name(name)
                .build();
    }
}
