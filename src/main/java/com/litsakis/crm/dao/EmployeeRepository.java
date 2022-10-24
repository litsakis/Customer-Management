package com.litsakis.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.litsakis.crm.entity.Customer;

@RepositoryRestResource (path="api")
public interface EmployeeRepository extends JpaRepository<Customer, Integer> {

}
