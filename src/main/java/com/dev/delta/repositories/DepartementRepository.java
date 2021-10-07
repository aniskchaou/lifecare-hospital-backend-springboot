package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.delta.entities.Departement;


@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement, Long>  {

}
