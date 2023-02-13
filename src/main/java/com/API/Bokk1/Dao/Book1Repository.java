package com.API.Bokk1.Dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.API.Bokk1.Entities.Book1;

public interface Book1Repository extends CrudRepository<Book1, Integer> {

	
	public Optional<Book1> findById(int id);


	
}
