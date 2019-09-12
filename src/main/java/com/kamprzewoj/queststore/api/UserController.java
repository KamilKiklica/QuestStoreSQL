package com.kamprzewoj.queststore.api;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//todo ask mentor RESFull api should return what if ERROR ?
//todo GET /api/customers
//todo GET /api/customers/1
//todo PUT /api/customers/1  {"name": "Andrju"}  <--- edit
//todo DELETE /api/customers/1
//todo POST /api/customers  {"name": "Andrju"}  <--- ADD !!!




@RequestMapping("api/userClass")
@RestController
public class UserController {

	private final UserClassService userClassService;

	@Autowired
	public UserController(@Qualifier("UserClassService") UserClassService userClassService) {
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

	@GetMapping(path = "{id}")    //todo @GetMapping(path ="/hello/{if}, params = "text)
	public Optional<UserClass> getUserById(@PathVariable("id") Integer id) {
		return userClassService.getUserClassById(id);
	}

	@DeleteMapping(path = "{id}")
	public void deleteClassUserById(@PathVariable("id") Integer id) {
		userClassService.deleteUserClassById(id);
	}

	@PutMapping()
	public void updateClassUserById(@RequestBody UserClass userClass) {
		userClassService.addUserClass(userClass);
	}
}
