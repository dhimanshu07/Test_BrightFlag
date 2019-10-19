package com.brightflag.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.Grade;


@Repository
public class GradeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int setGrade(int sub, int stu, int grade) {
		return jdbcTemplate.update(
			    "INSERT INTO grades VALUES(?, ?, ?);",
			    stu, sub, grade
			);
	}

	public List<Grade> getGrades() {
		return jdbcTemplate.query("select g.grade, st.firstName, st.lastName, su.subjectName from grades as g, student as st, subject as su where st.studentID = g.studentID and su.subjectID = g.subjectID",
				new BeanPropertyRowMapper<Grade>(Grade.class));
	}
}
