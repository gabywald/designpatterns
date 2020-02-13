package designpatterns.tutorialspoint.others;

import java.util.ArrayList;
import java.util.List;

public class TransferObjectPatternDemo {
	public static void main(String[] args) {
		StudentBO studentBusinessObject = new StudentBO();

		// Print all students
		for (StudentVO student : studentBusinessObject.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}

		// Update student
		StudentVO student = studentBusinessObject.getAllStudents().get(0);
		student.setName("Michael");
		studentBusinessObject.updateStudent(student);

		// Get the student
		student = studentBusinessObject.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
	}
}

/** POJO / Projection / Transferred */
class StudentVO {
	private String name;
	private int rollNo;

	StudentVO(String name, int rollNo){
		this.name = name;
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
}

/** Business service / Server-side */
class StudentBO {
	// List is working as a database
	List<StudentVO> students;

	public StudentBO() {
		this.students = new ArrayList<StudentVO>();
		StudentVO student1 = new StudentVO("Robert", 0);
		StudentVO student2 = new StudentVO("John", 1);
		this.students.add(student1);
		this.students.add(student2);		
	}
	
	public void deleteStudent(StudentVO student) {
		this.students.remove(student.getRollNo());
		System.out.println("Student: Roll No " + student.getRollNo() + ", deleted from database");
	}

	// Retrieve list of students from the database
	public List<StudentVO> getAllStudents() {
		return this.students;
	}

	public StudentVO getStudent(int rollNo) {
		return this.students.get(rollNo);
	}

	public void updateStudent(StudentVO student) {
		this.students.get(student.getRollNo()).setName(student.getName());
		System.out.println("Student: Roll No " + student.getRollNo() +", updated in the database");
	}
}
