package com.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.service.LoginServiceImpl;

@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginRequest(HttpServletRequest request, HttpServletResponse response, Model model)
	{
		return "login";
	}
	
	@Autowired 
	LoginServiceImpl loginService;
	
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public String loginCheck(HttpServletRequest request, HttpServletResponse response, @CookieValue(value="user",defaultValue="") String usrName,boolean rememberMe, Model model)
	{
		response.setContentType("text/html;charset=UTF-8");

        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        
		if(loginService.checkLogin(userName, password))
		{
			if(rememberMe)
			{
				Cookie cookieObj = new Cookie("user", userName);
				cookieObj.setMaxAge(60*60*24*30);
				response.addCookie(cookieObj);
			}
			else
			{
				Cookie cookieObj = new Cookie("user", null);
				cookieObj.setMaxAge(0);
				response.addCookie(cookieObj);
			}
            HttpSession session = request.getSession();
			session.setAttribute("user", userName);
			


			model.addAttribute("message", userName);
			return "welcome";
		}
		model.addAttribute("error", "Invalid username or password!");

		return "redirect:/login";
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.POST)
	public String logOut(HttpServletRequest request)
	{
        request.getSession().invalidate();
        return "redirect:/login";
	}
}
