package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}