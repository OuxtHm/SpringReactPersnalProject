package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
ID              NOT NULL NUMBER         
CATEGORY_NAME   NOT NULL VARCHAR2(100)  
MENU_NAME       NOT NULL VARCHAR2(255)  
IMAGE_URL                VARCHAR2(2048) 
CAPACITY_ML              NUMBER         
CAFFEINE_MG              NUMBER         
CALORIES_KCAL            NUMBER         
SODIUM_MG                NUMBER         
CARBOHYDRATE_G           NUMBER         
SUGAR_G                  NUMBER         
FAT_G                    NUMBER         
SATURATED_FAT_G          NUMBER         
PROTEIN_G                NUMBER
*/
@Entity
@Table(name="compose_menus")
@Data
public class CoffeeEntity {
	@Id
	@Column(name = "id")
	private int id;
	
	private String category_name;
	private String menu_name;
	private String image_url;
	private int capacity_ml;
	private int caffeine_mg;
	private int calories_kcal;
	private int sodium_mg;
	private int carbohydrate_g;
	private int sugar_g;
	private int fat_g;
	private int saturated_fat_g;
	private int protein_g;
}
