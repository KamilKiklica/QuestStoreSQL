package com.kamprzewoj.queststore.dao;

import com.kamprzewoj.queststore.model.UserClass;

import java.util.List;

public interface UserClassDao {
	long save(UserClass userClass);

	UserClass get(long id);

	List<UserClass> list();

	void update(long id, UserClass userClass);

	void delete(long id);
}