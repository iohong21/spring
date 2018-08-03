package com.gura.spring02;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/fortune")
	public String showFortune(HttpServletRequest request) {
		String fortuneToday = "동쪽으로 가면 귀인을 만나요";
		
		request.setAttribute("fortuneToday", fortuneToday);
		
		return "fortune";
	}

	@RequestMapping("/person")
	public ModelAndView showPerson() {
		String personToday = "김유신";
		
		// request 에 담을 Model 과 view 페이지 정보를 가지는 객체
		ModelAndView mView = new ModelAndView();
		mView.addObject("personToday", personToday);
		mView.setViewName("person");	// views 의 person.jsp를 가리킴
		
		return mView;
	}

	@RequestMapping("/test")
	public ModelAndView showPerson(ModelAndView mView) {
		String personToday = "김유신";
		
		// request 에 담을 Model 과 view 페이지 정보를 가지는 객체
		mView.addObject("personToday", personToday);
		mView.setViewName("test");	// views 의 person.jsp를 가리킴
		
		return mView;
	}
}
