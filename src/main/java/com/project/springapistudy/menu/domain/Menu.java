package com.project.springapistudy.menu.domain;

import com.project.springapistudy.base.BaseAuditing;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class Menu extends BaseAuditing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(unique = true)
    private String name;

    @Column
    private int price;

    @Builder
    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
