package com.brightflag.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.Subject;

@Repository
public class SubjectRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Subject> getSubjects() {
		return jdbcTemplate.query("SELECT subjectID, subjectName FROM subject;",
				new BeanPropertyRowMapper<Subject>(Subject.class));
	}

	public int setStudentWithStudent(int sub, int stu) {
		return jdbcTemplate.update(
			    "INSERT INTO studSub VALUES(null, ?, ?);",
			    sub, stu
			);
	}

	public int addSubject(String sub) {
		return jdbcTemplate.update(
			    "INSERT INTO subject VALUES(null, ?);",
			    sub
			);
	}

}