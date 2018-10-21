package com.example.mySQL.service;

import com.example.mySQL.domain.Person;
import com.example.mySQL.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author lyner
 */
@Service
public class SimpleService implements PersonService {

    @Autowired
    private SimpleRepository simpleRepository;

    @Autowired
    private DataSource dataSource;

    String sql;

    @Override
    public void createPerson(Person person) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sql = "INSERT INTO person(id,name,age,maritial,birth,description)VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql, person.getId(), person.getName(), person.getAge(), person.getMaritial(), person.getBirth(), person.getDescription());
    }

    @Override
    public void deletePerson(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sql = "DELETE FROM person WHERE id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Person getPersonById(int personId) {
        Person person = simpleRepository.findById(personId).get();
        return person;
    }

    @Override
    public void updatePerson(int id, Person person) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sql = "UPDATE person SET name=?, age=?, maritial=?, birth=?, description=?  WHERE id=?";
        jdbcTemplate.update(sql, person.getName(), person.getAge(), person.getMaritial(), person.getBirth(), person.getDescription(), id);
    }

    @Override
    public List<Person> getAllPersons() {
        return simpleRepository.findAll();
    }
}