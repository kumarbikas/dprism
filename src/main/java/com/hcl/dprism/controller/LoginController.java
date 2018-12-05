package com.hcl.dprism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public String loginPage(Model model) {
		 	System.out.println("came to controller for login");
	        return "login";
	    }
	
	
	
	
	//@RequestMapping(value =  {"/", "/welcome"}, method = RequestMethod.GET)
	@RequestMapping(value =  {"/"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
	 	System.out.println("came to welcome controller ");
	 	model.addAttribute("message", "Welcome to Demo Application");
       // return "welcome";
	 	 return "help";
    }
	
	
	//Spring Security methods starts
	 
		
			/* @RequestMapping(value = "/admin", method = RequestMethod.GET)
			    public String adminPage(Model model, Principal principal) {
			         
			        User loginedUser = (User) ((Authentication) principal).getPrincipal();
			 
			        String userInfo = WebUtils.toString(loginedUser);
			        model.addAttribute("userInfo", userInfo);
			         
			        return "adminPage";
			    }
			 
			 
			 
			 @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
			    public String logoutSuccessfulPage(Model model) {
				 System.out.println("came to controller for login");
			        model.addAttribute("title", "Logout");
			        return "logoutSuccessfulPage";
			    }
			 
			 
			 @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
			 public String userInfo(Model model, Principal principal) {

				 System.out.println("user info controller");
				 // After user login successfully.
				 String userName = principal.getName();

				 System.out.println("User Name: " + userName);

				 User loginedUser = (User) ((Authentication) principal).getPrincipal();

				 String userInfo = WebUtils.toString(loginedUser);
				 model.addAttribute("userInfo", userInfo);

				 return "userInfoPage";
			 }
			 
			 @RequestMapping(value = "/403", method = RequestMethod.GET)
			 public String accessDenied(Model model, Principal principal) {

				 if (principal != null) {
					 User loginedUser = (User) ((Authentication) principal).getPrincipal();

					 String userInfo = WebUtils.toString(loginedUser);

					 model.addAttribute("userInfo", userInfo);

					 String message = "Hi " + principal.getName() //
					 + "<br> You do not have permission to access this page!";
					 model.addAttribute("message", message);

				 }

				 return "403Page";
			 }*/
	

}
