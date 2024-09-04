package com.example.restApi.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restApi.exceptions.ResourceNotFoundException;
import com.example.restApi.model.PersonVO;
import com.example.restApi.repository.PersonRepository;

//essa anotation ajuda a não ficar instanciando classes por aí, basta criar a variavel
// e usar a anotation @Autowired
@Service 
public class PersonServices {


	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() 
	{
		logger.info("finding all people!");
		return repository.findAll();
	}
	
	public PersonVO findById(Long id) 
	{
		logger.info("finding one person!");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("None of this ID!"));
	}
	
	public PersonVO create(PersonVO personVO) 
	{
		logger.info("creating one person!");
		return repository.save(personVO);
	}
	
	public PersonVO update(PersonVO personVO) 
	{
		logger.info("updating one person!");
		var entity = repository.findById(personVO.getId()).orElseThrow(() -> new ResourceNotFoundException("None of this ID!"));
	
		entity.setFirstName(personVO.getFirstName());
		entity.setLastName(personVO.getLastName());
		entity.setAddress(personVO.getAddress());
		entity.setGender(personVO.getGender());
		
		return repository.save(personVO);
	}
	
	public void delete(Long id) 
	{
		logger.info("deleting one person!");
		var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("None of this ID!"));
		repository.delete(entity);
	}
	
}
