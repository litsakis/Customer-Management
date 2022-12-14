package com.litsakis.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.litsakis.crm.entity.Task;

@RepositoryRestResource (path="tasks")
public interface TaskRestRepository extends JpaRepository<Task, Integer> {

}
/*
@RepositoryRestResource (path="task")
public interface EmployeeRepository extends JpaRepository<Customer, Integer> {

}*/