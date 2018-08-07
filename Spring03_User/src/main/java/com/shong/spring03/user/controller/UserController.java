package com.shong.spring03.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shong.spring03.user.dto.UserDto;
import com.shong.spring03.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	
	@RequestMapping("/users/loginform")
	public ModelAndView userLoginForm(HttpServletRequest request ) {
		String strUrl = request.getParameter("url");
		String url = "";
		if(strUrl != null) {
			url = strUrl;
		}
		
		ModelAndView mView = new ModelAndView();
		mView.addObject("url", url);
		mView.setViewName("users/loginform");
		
		return mView;
	}

	@RequestMapping("/users/login")
	public ModelAndView userLogin(HttpServletRequest request, @RequestParam String id, @RequestParam String pwd) {
		String strUrl = request.getParameter("url");
		String url = "";
		if(strUrl != null) {
			url = strUrl;
			url = url.replace(request.getContextPath(), "");
		}
		
		UserDto dto = uService.getData(id);
		Boolean isRegisterUser = false; 
		if(dto != null) {
			String dtoPwd = dto.getPwd();
			isRegisterUser = BCrypt.checkpw(pwd, dtoPwd);
		}
		ModelAndView mView = new ModelAndView();
		if(isRegisterUser) {
			request.getSession().setAttribute("id", id);
			if(url.isEmpty()) {
				mView.setViewName("redirect:/home.do");
			} else {
				mView.setViewName("redirect:"+url);
			}
		} else {
			//mView.setViewName("redirect:/users/loginform.do?url="+url);
			mView.addObject("url", url);
			mView.setViewName("users/loginError");
		}
		
		return mView;
	}
	
	@RequestMapping("/users/insertform")
	public String userInsertForm(HttpServletRequest request) {
		return "users/insertform";
	}
	
	@RequestMapping("/users/insert")
	public String userInsert(@ModelAttribute UserDto dto) {
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
	
	@RequestMapping("/users/logout")
	public String Logout(HttpServletRequest request ) {
		request.getSession().invalidate();
		return "redirect:/home.do";
	}
}
