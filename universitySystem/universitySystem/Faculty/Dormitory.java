package universitySystem.Faculty;

import java.util.Vector;

import universitySystem.User.Student;

public class Dormitory {
	public String address;
	public static Integer amountOfStudents = 900;
	public double price;

	public Vector<Student> student;
	
	Dormitory(String address,double price){
		this.address = address;
		this.price = price;
	}
	public void addStud(Student s) {
		if(amountOfStudents > student.size()) {
			student.add(s);
		}else {
			System.out.println("Sorry,this is no place for you");
		}
	}
}
