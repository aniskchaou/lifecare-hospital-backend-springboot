package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.delta.entities.Blood;

@RepositoryRestResource
public interface BloodRepository extends JpaRepository<Blood, Long>
{
	
}