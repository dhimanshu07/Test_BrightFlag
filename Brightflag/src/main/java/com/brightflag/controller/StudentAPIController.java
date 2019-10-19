package com.brightflag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.Student;
import com.brightflag.domain.Subject;
import com.brightflag.service.StudentService;

@RestController
public class StudentAPIController {

	@Autowired
	StudentService studentService;

	@RequestMapping("api/getStudents")
	public List<Student> getStudents() {
		// TODO populate students subjects list
		return studentService.getStudents();
	}

	@RequestMapping("api/getSubjectsForStudent")
	public List<Subject> getStudentsSubject(
			@RequestParam("id") int stu) {
		return studentService.getStudentsSubject(stu);
	}
}
