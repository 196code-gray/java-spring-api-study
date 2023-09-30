package com.project.springapistudy.menu.domain;

import com.project.springapistudy.base.BaseAuditing;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity @Getter @NoArgsConstructor
public class Menu extends BaseAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(unique = true)
    @NotBlank
    private String name;

    @Column
    @NotNull
    private int price;

    @Builder
    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void updateName (String name) {
        this.name = name;
    }
    public void updatePrice(int price) {
        this.price = price;
    }
}
