package com.brightflag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.Subject;
import com.brightflag.service.SubjectService;

@RestController
public class SubjectAPIController {

	@Autowired
	SubjectService subjectService;

	@RequestMapping("api/getSubjects")
	public List<Subject> getStudents() {
		// TODO populate students subjects list
		return subjectService.getSubjects();
	}

	@RequestMapping("api/setStudentWithStudent")
	public int setStudentWithStudent(
			@RequestParam("sub") int sub,
			@RequestParam("stu") int stu) {
		return subjectService.setStudentWithStudent(sub,stu);
	}
	
	@RequestMapping("api/addSubject")
	public int addSubject(
			@RequestParam("sub") String sub) {
		return subjectService.addSubject(sub);
	}
}
