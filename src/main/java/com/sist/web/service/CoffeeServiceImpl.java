package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dto.CoffeeDTO;
import com.sist.web.dto.CoffeeDTO.detail;
import com.sist.web.dto.CoffeeDTO.main;
import com.sist.web.repository.CoffeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService{
	private final CoffeeRepository cRepo;
	
	@Override
	public List<CoffeeDTO.main> main_list() {
		return cRepo.main_list();
	}
	
	@Override
	public List<main> menuListData(int page) {
		return cRepo.menuListData(page);
	}

	@Override
	public int coffeeTotalPage() {
		return cRepo.coffeeTotalPage();
	}
	
	@Override
	public CoffeeDTO.detail menuDetailData(int id) {
		return cRepo.menuDetailData(id);
	}
}
