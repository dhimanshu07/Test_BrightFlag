package com.brightflag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brightflag.domain.Grade;
import com.brightflag.domain.Student;
import com.brightflag.domain.Subject;
import com.brightflag.service.GradeService;
import com.brightflag.service.StudentService;

@RestController
public class GradeController {

	@Autowired
	GradeService gradeService;

	@RequestMapping("api/setGrade")
	public int setGrade(
			@RequestParam("sub") int sub,
			@RequestParam("stu") int stu,
			@RequestParam("grade") int grade) {
		return gradeService.setGrade(sub, stu, grade);
	}

	@RequestMapping("api/getGrades")
	public List<Grade> getGrades() {
		return gradeService.getGrades();
	}
}
