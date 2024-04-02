package com.tcs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.binding.PersonCounts;
import com.tcs.domain.Person;
import com.tcs.service.PersonService;

@RestController

public class PersonController {

	@Autowired
	private PersonService personService;

	@PostMapping("/savePerson")
	public ResponseEntity<Person> savePersonDtls(@RequestBody Person person) {
		Person entity = personService.savePerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(entity);

	}

	@GetMapping("/counts")
	public ResponseEntity<?> getPersonCounts() {
		PersonCounts countOfPersons = personService.getCountOfPersons();
		return ResponseEntity.status(HttpStatus.OK).body(countOfPersons);

	}

}
