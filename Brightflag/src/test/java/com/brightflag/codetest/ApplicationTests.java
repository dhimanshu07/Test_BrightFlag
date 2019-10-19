package com.brightflag.codetest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.brightflag.domain.Subject;
import com.brightflag.repository.StudentRepository;
import com.brightflag.repository.SubjectRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {	 

	@Autowired
	SubjectRepository subjectRepo;

	@Autowired
	StudentRepository studentRepo;

	@Test
	public void testSubjectAdded() throws Exception {
		
		//Test Case for Adding Assigning subject to a student.

		subjectRepo.setStudentWithStudent(4, 3);

		List<Subject> listOfSubjects = studentRepo.getStudentsSubject(3);

		assertNotNull(listOfSubjects);
		assertTrue(listOfSubjects.stream().anyMatch(object -> object.getSubjectID() == 4));
	}
	
	
}