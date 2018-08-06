package com.gura.spring03.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring03.member.dto.MemberDto;
import com.gura.spring03.member.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService mService;
	
	@RequestMapping("/member/list")
	public ModelAndView list() {
		ModelAndView mView = new ModelAndView();
		
		// MemberService 객체를 이용해서 비즈니스 로직 ㅓㅊ리하고
		mService.list(mView);
		
		// 뷰 페이지의 정보 설정
		mView.setViewName("member/list");
		
		return mView;
	}
	
	// 회원 추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertForm() {
		return "member/insertform";
	}
	
//	// 회원 추가 요청 처리
//	@RequestMapping("/member/insert")
//	public String insert(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
//		MemberDto dto = new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr);
//		
//		mService.insert(dto);
//		
//		return "redirect:/member/list.do";
//	}
	
//	// 회원 추가 요청 처리
//	@RequestMapping("/member/insert")
//	public String insert(@RequestParam String name, @RequestParam String addr) {
//		MemberDto dto = new MemberDto();
//		dto.setName(name);
//		dto.setAddr(addr);
//		
//		mService.insert(dto);
//		
//		return "redirect:/member/list.do";
//	}
	
	// 회원 추가 요청 처리
	@RequestMapping("/member/insert")
	public String insert(@ModelAttribute MemberDto dto) {
		/*
		 * 회원정보가 담긴 MemberDto 객체를 MemberService 객체를
		 * 이용해서 DB 에 저장하기
		 */
		mService.insert(dto);
		
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/delete")
	public String delete(@RequestParam int num) {
		mService.delete(num);
		return "redirect:/member/list.do";
	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(@RequestParam int num) {
		ModelAndView mView = new ModelAndView();
		mService.getData(mView, num);
		mView.setViewName("member/updateform");
		
		return mView;
	}
	
	@RequestMapping("/member/update")
	public String update(@ModelAttribute MemberDto dto) {
		System.out.println("num: " + dto.getNum());
		System.out.println("name: " + dto.getName());
		System.out.println("addr: " + dto.getAddr());
		mService.update(dto);
		return "redirect:/member/list.do";
	}
}
