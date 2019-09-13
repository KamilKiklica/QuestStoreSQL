package com.kamprzewoj.queststore.api;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


//todo ask mentor RESFull api should return what if ERROR ?
//todo GET /api/customers
//todo GET /api/customers/1
//todo PUT /api/customers/1  {"name": "Andrju"}  <--- edit
//todo DELETE /api/customers/1
//todo POST /api/customers  {"name": "Andrju"}  <--- ADD !!!



//@RepositoryRestController
@RequestMapping(path = "/api/userClass")
@RestController
@Slf4j
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
		log.trace("A TRACE Message");
		log.debug("A DEBUG Message");
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message");
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

