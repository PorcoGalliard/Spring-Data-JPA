package com.example.springdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s from Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
    List<Student> findStudentsByFirstNameEqualsAndAgeEquals(
            String name, Integer age);
    List<Student> findStudentsByFirstNameEqualsAndAgeGreaterThan(
            String name, Integer age);
}
