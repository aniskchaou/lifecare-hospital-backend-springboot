package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.delta.entities.Doctor;


@RepositoryRestResource
public interface DoctorRepository  extends JpaRepository<Doctor, Long>  {

}
