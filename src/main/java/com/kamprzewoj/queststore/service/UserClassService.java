package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.model.UserClass;
import com.kamprzewoj.queststore.repository.UserClassRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
}
