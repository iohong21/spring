package com.shong.spring03.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shong.spring03.user.dto.UserDto;
import com.shong.spring03.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@RequestMapping("/users/loginform")
	public String userLoginForm( ) {
		return "users/loginform";
	}

	@RequestMapping("/users/login")
	public ModelAndView userLogin(HttpServletRequest request, @RequestParam String id, @RequestParam String pwd) {
		UserDto dto = uService.getData(id);
		Boolean isRegisterUser = false; 
		if(dto != null) {
			String dtoPwd = dto.getPwd();
			isRegisterUser = BCrypt.checkpw(pwd, dtoPwd);
		}
		ModelAndView mView = new ModelAndView();
		mView.addObject("isRegisterUser", isRegisterUser);
		if(isRegisterUser) {
			request.getSession().setAttribute("id", id);
			mView.setViewName("redirect:/home.do");
		} else {
			mView.setViewName("users/insertform");
		}
		return mView;
	}
	
	@RequestMapping("/users/insertform")
	public String userInsertForm(@ModelAttribute UserDto dto) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pwd = dto.getPwd();
		if(pwd != null) {
			dto.setPwd(encoder.encode(pwd));
			uService.insert(dto);
		}
		
		return "redirect:/home.do";
	}
	
	@RequestMapping("/users/list")
	public ModelAndView authUserList(HttpServletRequest request) {
		List<UserDto> list = uService.getList();
		ModelAndView mView = new ModelAndView();
		mView.addObject("list", list);
		mView.setViewName("users/list");
		return mView;
	}
}
