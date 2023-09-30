package com.project.springapistudy.menu.controller;

import com.project.springapistudy.menu.dto.MenuPatchDto;
import com.project.springapistudy.menu.dto.MenuPostDto;
import com.project.springapistudy.menu.dto.MenuResponseDto;
import com.project.springapistudy.menu.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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

    @PatchMapping("/{menu-id}")
    public ResponseEntity patchMenu (@PathVariable ("menu-id") @Positive long menuId,
                                     @RequestBody MenuPatchDto patchDto) {
        menuService.updateMenu(menuId, patchDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{menu-id}")
    public ResponseEntity getMenu (@PathVariable("menu-id") @Positive long menuId) {
        MenuResponseDto responseDto = menuService.findMenu(menuId);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }
}
