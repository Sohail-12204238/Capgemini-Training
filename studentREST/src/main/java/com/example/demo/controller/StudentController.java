package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/restAPI/student")
public class StudentController {

    private final StudentRepository studentRepository;
	public StudentService studentService;

	public StudentController(StudentService studentService, StudentRepository studentRepository) {
		this.studentService = studentService;
		this.studentRepository = studentRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(studentService.getAllStudents());
	}
	
	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student savedStudent = studentService.createStudent(student);
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id){
		Student student = studentService.getStudentById(id);
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
		return ResponseEntity.ok(studentService.updateStudent(id,student));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Deleted Student Successfully");
	}
	
	
}
