package designpatterns.tutorialspoint.others.mvc;

public class MVCPatternDemo {
	
	public static void main(String[] args) {
		// Fetch student record based on his roll no from the database
		Student model  = MVCPatternDemo.retrieveStudentFromDatabase();

		// Create a view : to write student details on console
		StudentView view = new StudentView();

		StudentController controller = new StudentController(model, view);

		controller.updateView();

		// Update model data
		controller.setStudentName("John");

		controller.updateView();
	}

	private static Student retrieveStudentFromDatabase() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}
}
