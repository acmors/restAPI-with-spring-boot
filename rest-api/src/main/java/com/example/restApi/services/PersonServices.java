package com.example.restApi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restApi.exceptions.ResourceNotFoundException;
import com.example.restApi.model.Person;
import com.example.restApi.repository.PersonRepository;

//essa anotation ajuda a não ficar instanciando classes por aí, basta criar a variavel
// e usar a anotation @Autowired
@Service 
public class PersonServices {


	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;

	public List<Person> findAll() 
	{
		logger.info("finding all people!");
		return repository.findAll();
	}
	
	public Person findById(Long id) 
	{
		logger.info("finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("None of this ID!"));
	}
	
	public Person create(Person person) 
	{
		logger.info("creating one person!");
		return repository.save(person);
	}
	
	public Person update(Person person) 
	{
		logger.info("updating one person!");
		var entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("None of this ID!"));
	
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) 
	{
		logger.info("deleting one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("None of this ID!"));
		repository.delete(entity);
	}
	
}
