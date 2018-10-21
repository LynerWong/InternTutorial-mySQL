package com.example.mySQL.service;

import com.example.mySQL.domain.Person;

import java.util.List;

public interface PersonService {

    void createPerson(Person person);
    Person getPersonById(int personId);
    void updatePerson(int id, Person person);
    void deletePerson(int id);
    List<Person> getAllPersons();
}
