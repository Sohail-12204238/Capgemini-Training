package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	public StudentRepository studentRepository;
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student getStudentById(Long id) {
		 return studentRepository.findById(id).orElseThrow(() 
				-> new StudentNotFoundException("Student Not Found with Id: " + id));
	}
	
	public Student updateStudent(Long id,Student student) {
		Student fetchedStudent = studentRepository.findById(id).orElseThrow(() -> 
		new StudentNotFoundException("Student Not Found with Id: " + id));
		fetchedStudent.setName(student.getName());
		fetchedStudent.setCity(student.getCity());
		return studentRepository.save(fetchedStudent);
	}
	
	public void deleteStudent(Long id) {
		Student fetchedStudent = studentRepository.findById(id).orElseThrow(
				() -> new StudentNotFoundException("Student Not Found with Id: " + id));
		studentRepository.delete(fetchedStudent);
	}
	
}
