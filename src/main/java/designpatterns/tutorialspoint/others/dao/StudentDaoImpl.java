package designpatterns.tutorialspoint.others.dao;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
	// List is working as a database
	private List<Student> students;

	public StudentDaoImpl() {
		this.students		= new ArrayList<Student>();
		Student student1	= new Student("Robert", 0);
		Student student2	= new Student("John", 1);
		this.students.add(student1);
		this.students.add(student2);		
	}

	@Override
	public void deleteStudent(Student student) {
		this.students.remove(student.getRollNo());
		System.out.println("Student: Roll No [" + student.getRollNo() + "], deleted from database");
	}

	// Retrieve list of students from the database
	@Override
	public List<Student> getAllStudents() {
		return this.students;
	}

	@Override
	public Student getStudent(int rollNo) {
		return this.students.get(rollNo);
	}

	@Override
	public void updateStudent(Student student) {
		this.students.get(student.getRollNo()).setName(student.getName());
		System.out.println("Student: Roll No [" + student.getRollNo() + "], updated in the database");
	}
}
