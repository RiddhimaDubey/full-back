package com.example.testing.testing.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing.testing.Repository.PersonRepository;
import com.example.testing.testing.entity.Person;
import com.example.testing.testing.models.PersonDto;
import com.example.testing.testing.models.PersonResponse;
import com.example.testing.testing.models.ReferralValidationResponse;
import com.example.testing.testing.models.RegistrationRequest;
import com.example.testing.testing.models.RegistrationResponse;

@Service
public class PersonServiceImplementaion implements PersonService {
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public PersonResponse getList() {
	    List<Person> personList = personRepository.findAll();

	    List<PersonDto> personDtoList = personList.stream()
	            .map(p -> modelMapper.map(p, PersonDto.class))
	            .toList();

	    PersonResponse personResponse = new PersonResponse();
	    personResponse.setContaint(personDtoList);
	    return personResponse;
	}

	@Override
	public PersonResponse getPersonById(Long id) {
		List<Person> personList = personRepository.findAll();
		List<PersonDto> personDtoList = personList.stream()
			 .map(p -> modelMapper.map(p, PersonDto.class))
			 .toList();
		  PersonResponse personResponse = new PersonResponse();
		  personResponse.setContaint(personDtoList);
		  return personResponse;
	}

	@Override
	public PersonResponse deletPersonById(Long id) {
		Person person = personRepository.findById(id).orElse(null);
	 if (person != null) {
		 personRepository.delete(person);
	 }

	 PersonResponse personResponse = new PersonResponse();
	 personResponse.setMessage("Person with ID " + id + " deleted successfully.");
	 return personResponse;											
	}

	@Override
	public PersonResponse deletePersonById(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deletePersonById'");
	}

	@Override
	public RegistrationResponse registerUser(RegistrationRequest request) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'registerUser'");
	}

	@Override
	public PersonResponse getPersonByEmail(String email) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPersonByEmail'");
	}

	@Override
	public PersonResponse getReferredUsers(String referralCode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getReferredUsers'");
	}

	@Override
	public ReferralValidationResponse validateReferralCode(String referralCode) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'validateReferralCode'");
	}

}
