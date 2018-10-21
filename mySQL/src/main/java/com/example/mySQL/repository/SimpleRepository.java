package com.example.mySQL.repository;

import com.example.mySQL.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleRepository extends JpaRepository<Person, Integer> {
}
