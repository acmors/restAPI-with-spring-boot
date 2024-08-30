package com.example.restApi.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restApi.model.Person;
import com.example.restApi.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	private PersonServices service;

	public PersonController(PersonServices service) {
		super();
		this.service = service;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() 
	{
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable(value = "id") Long id)
	{
		return service.findById(id);
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person create(@RequestBody Person person)
	{
		return service.create(person);
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Person update(@RequestBody Person person)
	{
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id")Long id)
	{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
