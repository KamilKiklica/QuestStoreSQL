package com.kamprzewoj.queststore.repository;

import com.kamprzewoj.queststore.model.UserClass;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

//import java.util.Optional;


//@Qualifier("UserClassRepository")
//@RepositoryRestResource
@Repository("UserClassRepository")
public interface UserClassRepository extends CrudRepository<UserClass, Integer> {
//	Optional<UserClass> findByNameAnd(String name);
}
