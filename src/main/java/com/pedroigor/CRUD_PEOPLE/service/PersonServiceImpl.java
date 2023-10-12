package com.pedroigor.CRUD_PEOPLE.service;

import com.pedroigor.CRUD_PEOPLE.Repository.PersonRepository;
import com.pedroigor.CRUD_PEOPLE.dto.request.PersonRequestDTO;
import com.pedroigor.CRUD_PEOPLE.dto.response.PersonResponseDTO;
import com.pedroigor.CRUD_PEOPLE.dto.util.PersonMapper;
import com.pedroigor.CRUD_PEOPLE.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {

        return personMapper.toPersonDTO(returnPerson(id));
    }

    @Override
    public List<PersonResponseDTO> FindAll() {

        return personMapper.toPeopleDTO(personRepository.findAll());
    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {

        Person person = personMapper.toPerson(personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));
    }

    @Override
    public PersonResponseDTO update(Long id, PersonRequestDTO personDTO) {

        Person person = returnPerson(id);

        personMapper.updatePersonData(person, personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));



    }

    @Override
    public String delete(Long id) {
        personRepository.deleteById(id);
        return "Person id: " + id + " deleted";
    }

    private Person returnPerson(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person wasn't fount on database"));
    }


}
