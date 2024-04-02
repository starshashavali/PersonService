package com.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.domain.Person;

public interface PersonRepository  extends JpaRepository<Person,Long>{

}
