package com.demo.controller;

import java.util.List;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Student;
import com.demo.service.StudentService;

@RestController 
@RequestMapping("/StuApp")
@CrossOrigin("*")
public class Controller {

	@Autowired
	private StudentService service;
	
	public String check() {
		return "Student App Working";
	}
	
	@PostMapping("/insertStudent")
	public String AddStudent(@RequestBody Student s) {
		
		 service.saveEmp(s);
		 return "Student Save";
	}
	
	@GetMapping("/getAllStu")
	public List<Student> getAllStu(){
		return service.getAllStudent();
	}
	
	@GetMapping("/getSingle/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student student = service.getStudent(id);
		return student;
	}
	
	@DeleteMapping("/deletStu/{id}")
	public String deleteStu(@PathVariable int id) {
		
		String string = service.deletStudent(id);
		return string;
	}
	@PutMapping("/updateStu")
	public String updateStudent(@RequestBody Student s) {
		String string = service.updateStudent(s);
		return string;
	}
	
}
