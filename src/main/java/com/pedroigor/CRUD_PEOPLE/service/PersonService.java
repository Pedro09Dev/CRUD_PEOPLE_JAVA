package com.pedroigor.CRUD_PEOPLE.service;

import com.pedroigor.CRUD_PEOPLE.dto.request.PersonRequestDTO;
import com.pedroigor.CRUD_PEOPLE.dto.response.PersonResponseDTO;

import java.util.List;

public interface PersonService {

    PersonResponseDTO findById(Long id);

    List<PersonResponseDTO> FindAll();

    PersonResponseDTO register(PersonRequestDTO personDTO);

    PersonResponseDTO update(Long id, PersonRequestDTO personDTO);

    String delete(Long id);
}
