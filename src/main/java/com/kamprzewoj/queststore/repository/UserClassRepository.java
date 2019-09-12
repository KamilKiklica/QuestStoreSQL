package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("UserClassRepository")
public interface UserClassRepository extends CrudRepository<UserClass, Integer> {
}
