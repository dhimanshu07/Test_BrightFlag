package com.brightflag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightflag.domain.Grade;
import com.brightflag.repository.GradeRepository;

@Service
public class GradeService {

	@Autowired
	GradeRepository gradeRepo;

	public int setGrade(int sub, int stu, int grade) {
		return gradeRepo.setGrade(sub, stu, grade);
	}

	public List<Grade> getGrades() {
		return gradeRepo.getGrades();
	}
}
