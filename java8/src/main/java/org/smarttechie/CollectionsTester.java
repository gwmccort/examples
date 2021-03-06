package org.smarttechie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTester {

	public static void main(String[] args) {
		
		Student s1 = new Student();
		s1.setRollNumber("100");
		s1.setStudentName("ABC_1");
		s1.setTotalMarks(100);

		Student s2 = new Student();
		s2.setRollNumber("101");
		s2.setStudentName("ABC_2");
		s2.setTotalMarks(300);

		Student s3 = new Student();
		s3.setRollNumber("102");
		s3.setStudentName("ABC_3");
		s3.setTotalMarks(50);

		Student s4 = new Student();
		s4.setRollNumber("103");
		s4.setStudentName("ABC_4");
		s4.setTotalMarks(320);

		List<Student> students = new ArrayList<Student>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		Collections.sort(students, new MarksComparator());
		System.out.println(students);
	}

}
