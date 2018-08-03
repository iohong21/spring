package com.gura.spring03.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dao.MemberDao;
import com.gura.spring03.member.dto.MemberDto;

@Controller
public class MemberController {
	@Autowired
	private MemberDao dao;
	
	@RequestMapping("/member/list")
	public ModelAndView list() {
		
		List<MemberDto> list = dao.getList();
//		MemberDto dto = dao.getData(1);
//		List<MemberDto> list = new ArrayList<>(); 
//		list.add(dto);
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("member/list");
		
		return mView;
	}
}
