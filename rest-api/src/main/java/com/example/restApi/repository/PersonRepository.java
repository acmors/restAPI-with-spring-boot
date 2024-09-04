package com.example.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restApi.model.PersonVO;

@Repository
public interface PersonRepository extends JpaRepository<PersonVO, Long>{}
