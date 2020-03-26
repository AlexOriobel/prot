package com.example.demo.dao;

import com.example.demo.model.Organization;
import com.example.demo.model.Protocol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
}
