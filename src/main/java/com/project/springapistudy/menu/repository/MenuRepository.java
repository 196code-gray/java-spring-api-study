package com.project.springapistudy.menu.repository;

import com.project.springapistudy.menu.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "select name from Menu where name = :menuName", nativeQuery = true)
    List<Menu> findByName(@Param("menuName") String menuName);
}
