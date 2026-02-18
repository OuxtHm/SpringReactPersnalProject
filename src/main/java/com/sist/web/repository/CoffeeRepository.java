package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.sist.web.dto.*;
import com.sist.web.entity.CoffeeEntity;

public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Integer>{
    
    @Query(value = "SELECT id, menu_name as menuname, image_url as image, category_name as category "
            + "FROM compose_menus "
            + "WHERE category_name = '커피/더치' "
            + "LIMIT 9", nativeQuery = true) 
    public List<CoffeeDTO.main> main_list();
    
    @Query(value = "SELECT id, menu_name as menuname, image_url as image, category_name as category "
            + "FROM compose_menus "
            + "ORDER BY id ASC "
            + "LIMIT :page, 9", nativeQuery = true) 
    public List<CoffeeDTO.main> menuListData(@Param("page") int page);
    
    @Query(value = "SELECT CEIL(COUNT(*) / 9) FROM compose_menus", nativeQuery = true)
    public int coffeeTotalPage();
    
    @Query(value = "SELECT id, menu_name as menuname, image_url as image, category_name as category, "
            + "capacity_ml as capacity, caffeine_mg as caffeine, calories_kcal as calories, "
            + "sodium_mg as sodium, carbohydrate_g as carbohydrate, sugar_g as sugar, fat_g as fat, "
            + "saturated_fat_g as saturatedfat, protein_g as protein "
            + "FROM compose_menus "
            + "WHERE id = :id", nativeQuery = true)
    public CoffeeDTO.detail menuDetailData(@Param("id") int id);
}