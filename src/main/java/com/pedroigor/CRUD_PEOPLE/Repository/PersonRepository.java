package com.pedroigor.CRUD_PEOPLE.Repository;

import com.pedroigor.CRUD_PEOPLE.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
