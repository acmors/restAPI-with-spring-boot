package com.example.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.example.model.Person;

//essa anotation ajuda a não ficar instanciando classes por aí, basta criar a variavel
// e usar a anotation @Autowired
@Service 
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {
		logger.info("finding one person!");
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marcos");
		person.setLasttName("Silva");
		person.setAddress("São Paulo");
		person.setGender("Male");
		
		return person;
	}
}
