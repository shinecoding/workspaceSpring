package com.bitcamp.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//@Controller 어노테이션을 표기하면 현재 클래스는 컨트롤러 클래스가 된다.
@Controller
public class HomeController {

	// @RequestMapping : 접속자 주소를 매핑하는 메소드가 된다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		//ModelAndView : 클라이언트로 보내는 데이터와 뷰파일명을 가진다.
		ModelAndView mav = new ModelAndView();
		
		String name = "홍길동";
		int[] data = {12, 56, 88, 35, 765, 253, 91, 23};
		
		mav.addObject("username", name);
		mav.addObject("data", data);
		
		mav.setViewName("home");
		return mav;
	}
}
