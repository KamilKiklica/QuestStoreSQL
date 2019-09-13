//package com.kamprzewoj.queststore.repository;
//
//import com.kamprzewoj.queststore.model.Level;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//import org.springframework.data.rest.webmvc.RepositoryRestController;
//
//import java.util.Optional;
//
//@Qualifier("LevelRepository")
//@RepositoryRestResource
//public interface LevelRepository extends CrudRepository<Level, Integer> {
//	Optional<Level> findByName(String name);
//}
//
//
////      GET /foos
////		POST /foos
////		GET /foos/{id}
////		PUT /foos/{id}
////		POST /foos/{id}
////		PATCH /foos/{id}
////		DELETE /foos/{id}
////		HEAD /foos/{id}