package com.bitcamp.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	//매핑
	//@RequestMapping(value="/aLink", method=RequestMethod.GET) //get방식일 땐 아래처럼 생략가능 post방식일 땐 이렇게 씀
	@RequestMapping("/aLink")
	public String aLinkTest(HttpServletRequest req, Model model) {
		
		String no = req.getParameter("no") + 666;
		String name = req.getParameter("name") + "님";
		
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		
		return "test";
	}
	//폼의 데이터를 서버로 전송하기
	@RequestMapping(value="/form1" , method=RequestMethod.POST)
	public ModelAndView formTest1(HttpServletRequest r) {
		TestVO vo = new TestVO();
		vo.setUsername(r.getParameter("username"));
		//String name = r.getParameter("username");
		vo.setTel(r.getParameter("tel"));
		vo.setAddr(r.getParameter("addr"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		//	/WEB-INF/views/formView.jsp
		mav.setViewName("sample/formView");
		return mav;
	}
	//폼의 데이터를 서버로 전송하기1
	@RequestMapping(value="/form2", method=RequestMethod.POST)
	public ModelAndView formTest2(@RequestParam("username") String name, 
			@RequestParam("tel") String tel, @RequestParam("addr") String addr) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("username", name);
		mav.addObject("tel", tel);
		mav.addObject("addr", addr);
		
		mav.setViewName("sample/formView");
		return mav;
	}
	@RequestMapping(value="form3", method=RequestMethod.POST)
	public ModelAndView formTest3(TestVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("sample/formView");
		return mav;
	}
}
