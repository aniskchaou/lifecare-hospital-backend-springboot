package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.dev.delta.entities.DoctorSpeciality;

@RepositoryRestResource
public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality, Long>
{
	
}