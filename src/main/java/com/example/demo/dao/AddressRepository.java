package com.example.demo.dao;

import com.example.demo.model.Addres;
import com.example.demo.model.Person;
import com.example.demo.model.Protocol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Addres, String> {

    @Query("select d from Addres d where d.country = :country and d.city = :city and d.street = :street")
    Addres findAddressByFullName(
            @Param("country") String country,
            @Param("city") String city,
            @Param("street") String street

    );
}
