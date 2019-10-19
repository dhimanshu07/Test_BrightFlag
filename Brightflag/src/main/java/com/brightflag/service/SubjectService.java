package com.brightflag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brightflag.domain.Student;
import com.brightflag.domain.Subject;
import com.brightflag.repository.StudentRepository;
import com.brightflag.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	SubjectRepository subjectRepo;

	public List<Subject> getSubjects() {
		return subjectRepo.getSubjects();
	}

	public int setStudentWithStudent(int sub, int stu) {
		return subjectRepo.setStudentWithStudent(sub,stu);
	}

	public int addSubject(String sub) {
		return subjectRepo.addSubject(sub);
		
	}

}
