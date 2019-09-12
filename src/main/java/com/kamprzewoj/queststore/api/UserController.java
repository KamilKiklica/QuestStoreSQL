package com.kamprzewoj.queststore.api;

//todo ask mentor this is bad ? I still have connection between classes
import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@GetMapping
	public List<UserClass> getAllUserClasses() {
		return userClassService.getAllUserClasses();
	}
}
