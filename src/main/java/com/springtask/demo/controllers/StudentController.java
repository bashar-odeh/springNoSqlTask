package com.springtask.demo.controllers;

import com.springtask.demo.student.Student;
import com.springtask.demo.student.StudentEmail;
import com.springtask.demo.student.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return null;
    }

    @GetMapping("/get")
    @ResponseBody
    public Student getStudent(@RequestBody StudentEmail email) {
        return studentService.getStudent(email.getEmail());

    }

    @PostMapping("/update")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudentName(student);
    }

    @PostMapping("/delete")
    public void deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student);
    }

}
