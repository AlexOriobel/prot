package com.example.demo.controller;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personal")
public class PersonRestController {

    private final PersonRepository personRepository;

    public PersonRestController(PersonRepository personRepository) {

        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> getPersonList() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonId(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findById(id).orElseThrow(RuntimeException::new), HttpStatus.OK);
    }

    @GetMapping("/findPerson")
    public ResponseEntity<Person> getByFullName(@RequestParam(value = "name") String name,
                                                @RequestParam(value = "surname") String surname,
                                                @RequestParam(value = "patronymic") String patronymic) {
        if (personRepository.findPersonByFullName(name, surname, patronymic) == null) {
            System.out.printf("Error");
        }
        return new ResponseEntity<>(personRepository.findPersonByFullName(name, surname, patronymic), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Person> getByName(@RequestParam(value = "name") String name,
                                            @RequestParam(value = "surname") String surname,
                                            @RequestParam(value = "patronymic") String patronymic) {
        if (personRepository.findPersonByFullName(name, surname, patronymic) != null) {
            personRepository.delete(personRepository.findPersonByFullName(name, surname, patronymic));
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savePerson = personRepository.save(person);
        return new ResponseEntity<>(savePerson, HttpStatus.CREATED);
    }
}
