package com.edutecno.restopcional.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.restopcional.model.Pet;
import com.edutecno.restopcional.repository.IPetRepository;

@Service
public class PetServiceImpl implements IPetService {

	@Autowired
	IPetRepository petRepository;
	
	@Override
	public void createPet(Pet pet) {
		petRepository.save(pet);
	}

	@Override
	public List<Pet> findAll() {
		return (List<Pet>) petRepository.findAll();
	}

	

}
