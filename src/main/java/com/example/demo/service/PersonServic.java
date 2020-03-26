package com.example.demo.service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonServic {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean isReal(String name, String surname, String patroymic){

        ResponseEntity<Person>(personRepository.findByName(name)

    }
}
