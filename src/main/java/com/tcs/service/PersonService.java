package com.tcs.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.binding.PersonCounts;
import com.tcs.domain.Person;
import com.tcs.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	
	public Person savePerson(Person person) {
		calculateAndSetAge(person);

		return personRepository.save(person);
	}
//age calculate
	private void calculateAndSetAge(Person person) {
		LocalDate birthDate = person.getDateOfBirth();
		LocalDate currentDate = LocalDate.now();
		int age = Period.between(birthDate, currentDate).getYears();
		person.setAge(age);
	}
	
	 public PersonCounts getCountOfPersons() {
	        List<Person> allPersons = personRepository.findAll();
	        
	        Integer maleCount = (int) allPersons.stream()
	                .filter(person -> person.getGender().equalsIgnoreCase("Male"))
	                .count();

	        Integer femaleCount = (int) allPersons.stream()
	                .filter(person -> person.getGender().equalsIgnoreCase("Female"))
	                .count();

	        Integer childrenCount = (int) allPersons.stream()
	                .filter(person -> person.getAge() < 18)
	                .count();

	        Integer seniorCitizenCount = (int) allPersons.stream()
	                .filter(person -> person.getAge() >= 60)
	                .count();

	        return new PersonCounts(maleCount, femaleCount, childrenCount, seniorCitizenCount);
	    }

}


