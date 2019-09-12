package com.kamprzewoj.queststore.dao;

import com.kamprzewoj.queststore.model.UserClass;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


// todo ------------------------------------------------------------------------------------------------------------------------
@Repository
public class UserClassDaoImpl implements UserClassDao {


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(UserClass userClass) {
		sessionFactory.getCurrentSession().save(userClass);
		return userClass.getId();
	}

	@Override
	public UserClass get(long id) { //todo Optional
		return sessionFactory.getCurrentSession().get(UserClass.class, id);
	}

	@Override
	public List<UserClass> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<UserClass> criteriaQuery = criteriaBuilder.createQuery(UserClass.class);
		Root<UserClass> root = criteriaQuery.from(UserClass.class);
		criteriaQuery.select(root);
		Query<UserClass> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void update(long id, UserClass userClass) {
		Session session = sessionFactory.getCurrentSession();
		UserClass userClassLocal = session.byId(UserClass.class).load(id);
		userClassLocal.setName(userClass.getName());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Session session = sessionFactory.getCurrentSession();
		UserClass userClass = session.byId(UserClass.class).load(id);
		session.delete(userClass);
	}
}
