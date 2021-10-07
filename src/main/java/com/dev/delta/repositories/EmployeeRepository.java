package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.delta.entities.Employee;


@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}
