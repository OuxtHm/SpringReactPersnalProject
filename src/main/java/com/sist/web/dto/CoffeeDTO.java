package com.sist.web.dto;

public interface CoffeeDTO {
	
	interface main
	{
		public int getId();
		public String getMenuname();
		public String getImage();
		public String getCategory();
	}
	
	interface detail
	{
		public int getId();
		public String getMenuname();
		public String getImage();
		public int getCapacity();
		public int getCaffeine();
		public int getCalories();
		public int getSodium();
		public int getCarbohydrate();
		public int getSugar();
		public int getFat();
		public int getSaturatedfat();
		public int getProtein();
	}
	
	/*
	public int getId();
	public String getMenuName();
	public String getImage();
	public String getCategory();
	public int getCapacity();
	public int getCaffeine();
	public int getCalories();
	public int getSodium();
	public int getCarbohydrate();
	public int getSugar();
	public int getFat();
	public int getSaturatedFat();
	public int getProtein();
	*/
}