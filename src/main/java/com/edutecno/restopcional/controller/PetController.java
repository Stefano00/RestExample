package com.edutecno.restopcional.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edutecno.restopcional.model.Pet;
import com.edutecno.restopcional.service.IPetService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/pet")
public class PetController {

	@Autowired
	IPetService petService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.OK)
	public List<Pet> findAll() {
		return petService.findAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Pet pet) {
		petService.createPet(pet);
	}
}
