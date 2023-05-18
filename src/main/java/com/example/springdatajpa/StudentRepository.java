package com.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    List<Student> findStudentsByFirstNameEqualsAndAgeEquals(
            String name, Integer age);
    List<Student> findStudentsByFirstNameEqualsAndAgeGreaterThan(
            String name, Integer age);
}