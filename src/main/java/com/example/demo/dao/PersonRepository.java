package com.example.demo.dao;

import com.example.demo.model.Person;
import com.example.demo.model.Protocol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select a from Person a where a.name = :name")
    Person findByName(@Param("name") String name);

    @Query("select b from Person b where b.surname = :surname")
    Person findBySurname(@Param("surname") String surname);

    @Query("select c from Person c where c.patroymic = :patroymic")
    Person findByPatroymic(@Param("patroymic") String patroymic);

    @Query("select d from Person d where d.name = :name and d.surname = :surname and d.patroymic = :patroymic")
    Person findPersonByFullName(
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("patroymic") String patroymic

    );
}
