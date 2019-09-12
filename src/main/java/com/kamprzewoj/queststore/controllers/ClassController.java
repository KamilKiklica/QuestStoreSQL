package com.kamprzewoj.queststore.controllers;

//todo move to api

//todo ask mentor this is bad practice true ?
import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.service.UserClassService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
public class ClassController {

	@Autowired
	private UserClassService userClassService;

	@PostMapping("/userClass")
	public ResponseEntity<?> save(@RequestBody UserClass userClass) {
		long id = userClassService.save(userClass);
		return ResponseEntity.ok().body("New UserClass has been saved with ID:" + id);
	}

	@GetMapping("/userClass/{id}")
	public ResponseEntity<UserClass> get(@PathVariable("id") long id) {
		UserClass userClass = userClassService.get(id);
		return ResponseEntity.ok().body(userClass);
	}

	@GetMapping("/userClass")
	public ResponseEntity<List<UserClass>> list() {
		List<UserClass> userClasses = userClassService.list();
		return ResponseEntity.ok().body(userClasses);
	}

	@PutMapping("/userClass/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody UserClass userClass) {
		userClassService.update(id, userClass);
		return ResponseEntity.ok().body("UserClass has been updated successfully.");
	}

	@DeleteMapping("/userClass/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		userClassService.delete(id);
		return ResponseEntity.ok().body("UserClass has been deleted successfully.");
	}
}
