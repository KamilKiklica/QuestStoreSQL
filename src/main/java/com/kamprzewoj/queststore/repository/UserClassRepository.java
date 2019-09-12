package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserClassModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserClassRepository extends CrudRepository<UserClassModel, Integer> {
}
