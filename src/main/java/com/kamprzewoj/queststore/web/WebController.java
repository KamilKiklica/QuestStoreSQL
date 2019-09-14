package com.kamprzewoj.queststore.web;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class WebController {

	UserClassService userClassService;

	@Autowired
	public WebController(@Qualifier("UserClassService") UserClassService userClassService) {
		this.userClassService = userClassService;
	}


	@GetMapping("/hello")
	public String mainWithParam(Model model) {
		List<UserClass> userClasses = userClassService.getAllUserClasses();
		model.addAttribute("userClasses", userClasses);
		model.addAttribute("message", "Message from BACKEND");
		return "welcome";
	}

	@GetMapping("/")
	public String mainWithParam() {
		return "index.html";
	}

}



//public class UserController {
//
//	private final UserClassService userClassService;
//
//	@Autowired
//	public UserController(@Qualifier("UserClassService") UserClassService userClassService) {
//		this.userClassService = userClassService;
//	}