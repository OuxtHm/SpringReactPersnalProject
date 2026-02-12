package com.sist.web.service;

import java.util.List;

import com.sist.web.dto.CoffeeDTO;

public interface CoffeeService {
	public List<CoffeeDTO.main> main_list();
	public List<CoffeeDTO.main> menuListData(int page);
	public int coffeeTotalPage();
	public CoffeeDTO.detail menuDetailData(int id);
}
