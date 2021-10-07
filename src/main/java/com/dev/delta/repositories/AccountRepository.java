package com.dev.delta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dev.delta.entities.Account;


@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long>  {

}
