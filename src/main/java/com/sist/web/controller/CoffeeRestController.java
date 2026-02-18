package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpServletRequest;
import java.util.*;
import com.sist.web.dto.CoffeeDTO;
import com.sist.web.service.CoffeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CoffeeRestController {
	private final CoffeeService cService;
	
	@GetMapping("/")
	public ResponseEntity<Map> main_list_react(HttpServletRequest request)
	{
		log.info("[Main List Request] IP: {}", request.getRemoteAddr());
		Map map = new HashMap();
		try {
			List<CoffeeDTO.main> list = cService.main_list();
			map.put("list", list);
		} catch (Exception e) {
			log.error("Main List Error 발생 사유: ", e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/menu/list_react/{page}")
	public ResponseEntity<Map> menu_list_react(@PathVariable("page") int page, HttpServletRequest request)
	{
		log.info("[Menu List Request] Page: {}, IP: {}", page, request.getRemoteAddr());
		Map map = new HashMap();
		try {
			List<CoffeeDTO.main> list = cService.menuListData((page - 1) * 9);
			int totalPage = cService.coffeeTotalPage();
			
			final int BLOCK = 9;
			
			int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
			int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
			
			if(endPage > totalPage) endPage = totalPage;
			
			map.put("list", list);
			map.put("totalPage", totalPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
		} catch (Exception e) {
			log.error("[Menu List Error] 요청 페이지: {} | 사유: ", page, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/menu/detail_react/{id}")
	public ResponseEntity<Map> menu_detail_react(@PathVariable("id") int id, HttpServletRequest request)
	{
		log.info("[Detail Request] Coffee ID: {}, IP: {}", id, request.getRemoteAddr());
		Map map = new HashMap();
		
		try {
			CoffeeDTO.detail dto = cService.menuDetailData(id);
			map.put("coffeeDto", dto);
		} catch (Exception e) {
			log.error("[Detail Error] 상품 ID: {} | 사유: ", id, e);
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
}
