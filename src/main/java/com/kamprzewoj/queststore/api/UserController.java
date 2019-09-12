package com.kamprzewoj.queststore.api;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/userClass")
@RestController
public class UserController {

	private final UserClassService userClassService;

	@Autowired
	public UserController(@Qualifier("UserClassService")UserClassService userClassService) {
		this.userClassService = userClassService;
	}

	@PostMapping
	public void addUserClass(@RequestBody UserClass userClass) {
		userClassService.addUserClass(userClass);
	}
}
