package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.StudentDao;
import com.demo.model.Student;
@Service
public class StudentServiceImpl  implements StudentService{

	@Autowired
	private StudentDao dao;
	
	@Override
	public String saveEmp(Student s) {
			dao.save(s);
		return "Student Save SuccessFully";
	}

	@Override
	public Student getStudent(int rollno) {
			Optional<Student> id = dao.findById(rollno);
			if (id.isPresent()) {
				return id.get();
			}
		return new Student();
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public String deletStudent(int rollno) {
		// TODO Auto-generated method stub
		dao.deleteById(rollno);
		return "Student Delete With Id "+rollno;
	}

	@Override
	public String updateStudent(Student s) {
		Optional<Student> id = dao.findById(s.getRollno());
		
		if(id.isPresent()) {
			dao.save(s);
		return "Student Data Updated";	
		}
		else {
		return "Student Not Found With Id "+s.getRollno();
		}
	}

}
