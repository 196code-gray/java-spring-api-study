package com.project.springapistudy.menu.service;

import com.project.springapistudy.menu.domain.Menu;
import com.project.springapistudy.menu.dto.MenuPostDto;
import com.project.springapistudy.menu.dto.MenuResponseDto;
import com.project.springapistudy.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public void savedMenu (MenuPostDto postDto) {

        Menu menu = postDto.toEntity(
                postDto.getName(),
                postDto.getPrice()
        );

        menuRepository.save(menu);
    }
}
