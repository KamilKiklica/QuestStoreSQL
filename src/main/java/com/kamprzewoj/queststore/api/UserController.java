package com.kamprzewoj.queststore.api;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


//todo ask mentor RESFull api should return what if ERROR ?
//todo GET /api/customers
//todo GET /api/customers/1
//todo PUT /api/customers/1  {"name": "Andrju"}  <--- edit
//todo DELETE /api/customers/1
//todo POST /api/customers  {"name": "Andrju"}  <--- ADD !!!


//@RepositoryRestController

//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@Slf4j(topic = "UserController --->")
@RequestMapping(path = "/UserClass")
@RestController
public class UserController {

	private final UserClassService userClassService;

	@Autowired
	public UserController(@Qualifier("UserClassService") UserClassService userClassService) {
		this.userClassService = userClassService;
	}

//	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
//@RequestMapping(value = "/products", method = RequestMethod.POST)
//public ResponseEntity<Object> createProduct(@RequestBody Product product) {
//	productRepo.put(product.getId(), product);
//	return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
//}
//@RequestParam(name = "name", required = false, defaultValue = "")String name
	@PostMapping
	public void addUserClass(@Valid @RequestBody UserClass userClass) {
		log.info(userClass.toString());
		userClassService.addUserClass(userClass);
	}



	@GetMapping
	public ResponseEntity<List<UserClass>> getAllUserClasses() {
		log.info("An INFO Message");
		log.warn("A WARN Message");
		log.error("An ERROR Message <---");
		List<UserClass> users = userClassService.getAllUserClasses();
		log.info(String.valueOf(users));
		return new ResponseEntity<>(users, HttpStatus.OK);
//		return users;
	}

//	@ResponseStatus(HttpStatus.OK)
	@GetMapping(path = "{id}")    //todo @GetMapping(path ="/hello/{if}, params = "text)
	public ResponseEntity<Optional<UserClass>> getUserById(@PathVariable("id") Integer id) {
//		return userClassService.getUserClassById(id);
		return new ResponseEntity<>(userClassService.getUserClassById(id),
				(userClassService.getUserClassById(id).isEmpty())? HttpStatus.BAD_REQUEST: HttpStatus.OK);
	}

//	@GetMapping(path = "{id}")    //todo @GetMapping(path ="/hello/{if}, params = "text)
//	public Optional<UserClass> getUserById(@PathVariable("id") Integer id) {
//		return userClassService.getUserClassById(id);
//	}

	@DeleteMapping(path = "{id}")
	public void deleteClassUserById(@PathVariable("id") Integer id) {
		userClassService.deleteUserClassById(id);
	}

	@PutMapping()
	public void updateClassUserById(@RequestBody UserClass userClass) {
		userClassService.addUserClass(userClass);
	}
}
