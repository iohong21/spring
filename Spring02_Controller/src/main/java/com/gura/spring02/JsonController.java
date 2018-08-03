package com.gura.spring02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring02.dto.MemberDto;

@Controller
public class JsonController {
	@RequestMapping("/json/test01")
	@ResponseBody	// @ResponseBody 로 설정하고 String 을 리턴하면
	public String json01() {
		
		// 리턴되는 문자열이 클라이언트에게 그대로 출력된다.
		return "{\"msg\":\"hello!\"}";
	}
	
	@RequestMapping("/json/test02")
	@ResponseBody	// @ResponseBody 로 설정하고 Map 을 리턴하면
	public Map<String, Object> json02() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("addr", "노량진");
		map.put("isMan", true);
		
		return map;
	}
	
	
	@RequestMapping("/json/test03")
	@ResponseBody	// @ResponseBody 로 설정하고 List 를 리턴하면
	public List<String> json03() {
		List<String> list = new ArrayList<>();
		
		list.add("김구라");
		list.add("해골");
		
		return list;
	}	
	
	@RequestMapping("/json/test04")
	@ResponseBody	// @ResponseBody 로 설정하고 List 를 리턴하면
	public List<Map<String, Object>> json04() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		list.add(map1);

		Map<String, Object> map2 = new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "해골");
		list.add(map2);
		
		return list;
	}
	
	@RequestMapping("/json/test05")
	@ResponseBody	// @ResponseBody 로 설정하고 List 를 리턴하면
	public MemberDto json05() {
		MemberDto dto = new MemberDto(1, "김구라", "서울");
		
		return dto;
	}	
	
	@RequestMapping("/json/test06")
	@ResponseBody	// @ResponseBody 로 설정하고 List 를 리턴하면
	public List<MemberDto> json06() {
		
		List<MemberDto> list = new ArrayList<>();
		
		MemberDto dto1 = new MemberDto(1,"김구라", "서울");
		MemberDto dto2 = new MemberDto(2,"해골", "부산");
		MemberDto dto3 = new MemberDto(3,"원숭이", "대구");
		
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		return list;
	}	
	
}
