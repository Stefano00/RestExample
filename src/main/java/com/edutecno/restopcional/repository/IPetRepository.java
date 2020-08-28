package com.edutecno.restopcional.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.restopcional.model.Pet;

@Repository
public interface IPetRepository extends CrudRepository<Pet, Integer>{
	
}
