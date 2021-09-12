package com.springtask.demo.student;

import com.springtask.demo.student.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository
        extends MongoRepository<Student,String> {

    Optional<Student> findByEmail(String email  );
    void deleteStudentByEmail(String email);
}
