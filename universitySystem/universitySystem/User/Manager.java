package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Map;

import universitySystem.Faculty.Lesson;

/**
* @generated
*/

public class Manager extends Employee{
  public boolean done = true;
    
    private static final long serialVersionUID = 1L;

  public Manager(String firstName, String middleName, String secondName, double salary) {
    super(firstName, middleName, secondName, salary);
  }

  public void viewScheduleOfTeacher(Integer id) {
        for (Employee t: CreateSingleton.getEmployees()) {
          if (t.getId() == id && t instanceof Teacher) {
            System.out.println(((Teacher) t).getSchedule());
          }
        }
    }
    
    public void viewScheduleOfStudent(Integer id) {
        for (Student s: CreateSingleton.getStudents()) {
          if (s.getId() == id) {
            System.out.println(s.getSchedule());
          }
        }
    }
    
    public void viewAttestationsOfStudent(Integer id) {
      for (Student s: CreateSingleton.getStudents()) {
        if (s.getId() == id) {
            System.out.println(s.returnAttestations());
          }
        }
    }
    
    public void checkForRetake() {
        for (Student s: CreateSingleton.getStudents()) {
          for (Lesson l: s.getDisciplinesGrades().keySet()) {
            if (s.getDisciplinesGrades().get(l).calculateAbsents() > l.amountOfAbsents || (s.getDisciplinesGrades().get(l).calculateFirstAttestation() + s.getDisciplinesGrades().get(l).calculateSecondAttestation()) < 30) 
              System.out.println(s.getFirstName() + " has retake on " + l.name);
          }
        }
    }

    public void vieweMenu() throws IOException, NullPointerException {
      String st = "";
      st = st+"1.View Schedule of Teacher"+ "\n"+"2.View Schedule of Student"+"\n"+"3.View news"+"\n"+"4.View attestations of student"+"\n"+"5.View finance cabinet"+"\n"+"6.Check for retake";
      while (done) {
        System.out.println(st);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number == 1) {
          System.out.println("Please, enter ID of teacher who's schedule you want to see: ");
          int id = Integer.parseInt(reader.readLine());
          viewScheduleOfTeacher(id);
        }
        else if (number == 2) {
          System.out.println("Please, enter ID of student who's schedule you want to see: ");
          int id = Integer.parseInt(reader.readLine());
          viewScheduleOfStudent(id);
        }
        else if (number == 3) {
          System.out.println(checkNews());
        }
        else if (number == 4) {
          System.out.println("Please, enter ID of student who's attestation you want to see: ");
          int id = Integer.parseInt(reader.readLine());
          viewAttestationsOfStudent(id);
        }
        else if (number == 5) {
          System.out.println(getFinanceCabinet());
        }
        else if (number == 6) {
          checkForRetake();
        }
      }
    }
    
}
