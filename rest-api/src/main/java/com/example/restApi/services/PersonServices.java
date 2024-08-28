package com.example.restApi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.restApi.model.Person;

//essa anotation ajuda a não ficar instanciando classes por aí, basta criar a variavel
// e usar a anotation @Autowired
@Service 
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public List<Person> findAll() 
	{
		logger.info("finding all people!");
		List<Person> persons = new ArrayList<>();
		for (int i = 0; i < 8; i++ ) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person findById(String id) 
	{
		logger.info("finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marcos");
		person.setLasttName("Silva");
		person.setAddress("São Paulo");
		person.setGender("Male");
		return person;
	}
	
	public Person create(Person person) 
	{
		logger.info("creating one person!");
		return person;
	}
	
	public Person update(Person person) 
	{
		logger.info("updating one person!");
		return person;
	}
	
	public void delete(String id) 
	{
		logger.info("deleting one person!");
	}
	
	private Person mockPerson(int i) 
	{
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLasttName("Last name " + i);
		person.setAddress("Address " + i);
		person.setGender("Gender " + i);
		return person;
	}
}
