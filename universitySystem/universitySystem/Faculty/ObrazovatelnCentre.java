package universitySystem.Faculty;


import java.util.Vector;

import universitySystem.Faculty.PaidCourse;
import universitySystem.User.Student;

public class ObrazovatelnCentre {

  public String name;
  public static Vector<PaidCourse> courses;
  public static Vector<Student> teachers;
  
  static {
    courses = new Vector<PaidCourse>();
    teachers = new Vector<Student>();
  }
  
}