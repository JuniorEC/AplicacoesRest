package com.jdj.restjava.model.repositorio;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jdj.restjava.model.Person;
import com.jdj.restjava.model.Usuario;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Long> {

	List<Person> findByusername(@Param("username") String name);

}
