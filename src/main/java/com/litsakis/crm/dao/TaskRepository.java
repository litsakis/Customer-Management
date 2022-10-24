package com.litsakis.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.litsakis.crm.entity.Task;

@RepositoryRestResource (path="api-tasks")
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
/*
@RepositoryRestResource (path="task")
public interface EmployeeRepository extends JpaRepository<Customer, Integer> {

}*/