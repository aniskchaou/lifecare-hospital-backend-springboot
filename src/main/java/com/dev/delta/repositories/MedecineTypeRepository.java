package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.dev.delta.entities.MedecineType;

@RepositoryRestResource
public interface MedecineTypeRepository extends JpaRepository<MedecineType, Long>
{
	
}