package com.example.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student Maria = new Student("Maria", "Jeanne", "mariajeanne@edu.com", 21);

            Student Ahmed = new Student("Ahmed", "Ali", "ahmedali@edu.com", 21);

            Student Ahmed2 = new Student("Ahmed", "Ali2", "ahmedali2@edu.com", 18);

            System.out.println("Adding MARIA and AHMED");
            studentRepository.saveAll(List.of(Maria, Ahmed, Ahmed2));

            String email = "ahmedali@edu.com";
            studentRepository.findStudentsByEmail(email).ifPresentOrElse(
                    System.out::println, () -> {
                        System.out.printf("Student with email %s doesn't exist", email);
                    }
            );

            studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThanEqual("Ahmed", 10)
                    .forEach(System.out::println);

        };
    }
}
