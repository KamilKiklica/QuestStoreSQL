package com.kamprzewoj.queststore.service;

import com.kamprzewoj.queststore.dao.UserClassDao;
import com.kamprzewoj.queststore.model.UserClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserClassImpl implements UserClassService {

	//todo ask mentor this is wrong ?!?!?
	@Autowired
	private UserClassDao userClassDao;

	@Transactional
	@Override
	public long save(UserClass userClass) {
		return userClassDao.save(userClass);
	}

	@Override
	public UserClass get(long id) {
		return userClassDao.get(id);
	}

	@Override
	public List<UserClass> list() {
		return userClassDao.list();
	}

	@Transactional
	@Override
	public void update(long id, UserClass userClass) {
		userClassDao.update(id, userClass);
	}

	@Transactional
	@Override
	public void delete(long id) {
		userClassDao.delete(id);
	}
}
