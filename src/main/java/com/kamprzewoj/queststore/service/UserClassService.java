package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.UserClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service("UserClassService")
public class UserClassService {

	private final UserClassRepository userClassRepository;

	@Autowired
	public UserClassService(@Qualifier("UserClassRepository") UserClassRepository userClassRepository) {
		this.userClassRepository = userClassRepository;
	}

	public void addUserClass(UserClass userClass) {
		userClassRepository.save(userClass);
	}

	public List<UserClass> getAllUserClasses() {
		return StreamSupport.stream(userClassRepository.findAll().spliterator(), false).collect(Collectors.toList());
	}
}
