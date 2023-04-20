package universitySystem.Faculty;

import java.util.Map;
import java.util.Vector;

import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.Time;
import universitySystem.User.Abiturient;
import universitySystem.User.Student;

public class PaidCourse {
  
  public String name;
  public double price;
  public String description;
  public Map<Lesson, Time> schedule;
  public Vector<Student> students = new Vector<Student>();
  public Vector<Abiturient> abitur = new Vector<Abiturient>();
  
  public void addStudent(Student s) {
	  students.add(s);
  }
  
  public void addAbitur(Abiturient a) {
	  abitur.add(a);
  }
  
  public String toString() {
    return "A course named " + name + ", it costs " + price + ". The short description: " + description + "\n" + "The schedule is " + schedule.toString();
  }
  
  public void pay() {
    for (Student s : students) {
      s.getFinanceCabinet().addToBalance(price * (-1));
    }
    for (Abiturient a : abitur) {
      a.getFinanceCabinet().addToBalance(price * (-1));
    }
  }
}