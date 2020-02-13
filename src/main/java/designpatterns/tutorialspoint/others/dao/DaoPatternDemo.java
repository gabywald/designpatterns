package designpatterns.tutorialspoint.others.dao;

public class DaoPatternDemo {
	
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();

		// Print all students
		for (Student student : studentDao.getAllStudents()) {
			System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");
		}

		// Update student
		Student student =studentDao.getAllStudents().get(0);
		student.setName("Michael");
		studentDao.updateStudent(student);

		// Get the student
		studentDao.getStudent(0);
		System.out.println("Student: [RollNo : " + student.getRollNo() + ", Name : " + student.getName() + " ]");		
	}
}
