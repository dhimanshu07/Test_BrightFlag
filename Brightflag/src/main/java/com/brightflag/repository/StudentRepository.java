package com.brightflag.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brightflag.domain.Student;
import com.brightflag.domain.Subject;

@Repository
public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Student> getStudents() {
		return jdbcTemplate.query("SELECT studentID, firstName, lastName FROM student;",
				new BeanPropertyRowMapper<Student>(Student.class));
	}

	public List<Subject> getStudentsSubject(int stu) {
		return jdbcTemplate.query("SELECT st.subjectID as subjectID, su.subjectName as subjectName FROM studSub as st, subject as su where st.studentID="+stu+" and st.subjectID = su.subjectID",
				new BeanPropertyRowMapper<Subject>(Subject.class));
	}

}
