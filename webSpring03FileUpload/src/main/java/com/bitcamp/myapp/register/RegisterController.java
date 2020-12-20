package com.bitcamp.myapp.register;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {

@RequestMapping("/login")
public String login() {
	return "register/login";
}


@RequestMapping(value="/loginOk", method=RequestMethod.POST)
public ModelAndView loginOk(RegisterVO vo, HttpSession ses) {
	RegisterDAO dao = new RegisterDAO();
	RegisterVO rVo = dao.login(vo);
	
	ModelAndView mav = new ModelAndView();
	if(rVo == null) {
		
		mav.setViewName("register/login");
		return mav;
	}else {
		
	ses.setAttribute("logId", rVo.getUserid());
	ses.setAttribute("logName", rVo.getUsername());
	ses.setAttribute("logStatus", "Y");
		mav.setViewName("home");
		return mav;
	}
	
}

@RequestMapping("/logout")
public ModelAndView logout(HttpSession ses) {
	ses.invalidate();
	ModelAndView mav = new ModelAndView();
	mav.setViewName("redirect:/");
	return mav;
}

}


