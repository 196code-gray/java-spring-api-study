package com.project.springapistudy.menu.controller;

import com.project.springapistudy.menu.dto.MenuPostDto;
import com.project.springapistudy.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public ResponseEntity postMenu (@RequestBody @Valid MenuPostDto post) {
        menuService.savedMenu(post);
        return ResponseEntity.created(URI.create("/menu")).build();
    }
}
