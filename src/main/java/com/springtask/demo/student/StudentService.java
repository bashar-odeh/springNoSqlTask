package com.springtask.demo.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        if (student != null) {
            studentRepository.insert(student);
            return;
        }
        throw new IllegalArgumentException("No Data");
    }

    public Student getStudent(String email) {
        Optional<Student> opt = studentRepository.findByEmail(email);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    public void updateStudentName(Student student) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(student.getEmail());
        optionalStudent.ifPresentOrElse(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            studentRepository.save(student1);
        }, () -> {
            throw new IllegalArgumentException("Student Not Found");
        });

    }
    public void deleteStudent(Student student) {
    studentRepository.deleteStudentByEmail(student.getEmail());

    }
}
