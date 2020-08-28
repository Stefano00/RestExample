package com.edutecno.restopcional.service;

import java.util.List;

import com.edutecno.restopcional.model.Pet;

public interface IPetService {
	void createPet(Pet pet);
	List<Pet> findAll();
}
