package com.project.springapistudy.menu.service;

import com.project.springapistudy.exception.BusinessExceptionHandler;
import com.project.springapistudy.exception.ErrorCode;
import com.project.springapistudy.menu.domain.Menu;
import com.project.springapistudy.menu.dto.MenuPatchDto;
import com.project.springapistudy.menu.dto.MenuPostDto;
import com.project.springapistudy.menu.dto.MenuResponseDto;
import com.project.springapistudy.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateMenu (long menuId, MenuPatchDto patchDto) {
        Menu menu = existMenu(menuId);

        if (!existName(patchDto.getName()).isEmpty()) {
            throw new BusinessExceptionHandler(ErrorCode.SAME_NAME);
        }
        Optional.ofNullable(patchDto.getName()).ifPresent(menu::updateName);
        if (patchDto.getPrice() != 0) {
            menu.updatePrice(patchDto.getPrice());
        }
        menuRepository.save(menu);
    }
    public MenuResponseDto findMenu(long menuId) {
        Menu menu = existMenu(menuId);
        return MenuResponseDto.builder()
                .name(menu.getName())
                .price(menu.getPrice())
                .build();
    }

    private Menu existMenu(long menuId) {
        Optional<Menu> op = menuRepository.findById(menuId);
        Menu menu = op.orElseThrow(() -> new BusinessExceptionHandler(ErrorCode.MENU_NOT_FOUND));
        return menu;
    }

    protected List<Menu> existName (String name) {
        List<Menu> menus = menuRepository.findByName(name);
        return menus;
    }
}
