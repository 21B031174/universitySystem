package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import universitySystem.Faculty.Library;

/**
* @generated
*/

public class Librarian extends Employee {
  
  public boolean done = true;
    
    public Librarian(String firstName, String middleName, String secondName, double salary) {
    super(firstName, middleName, secondName, salary);
  }
    public Librarian(String firstName, String middleName, String secondName) {
    super(firstName, middleName, secondName);
  }
    
    public Vector<Student> checkForDebtOfBooks() {
        //TODO
        return null;
    }
    
    public void vieweMenu() throws IOException, NullPointerException {
      String st = "";
      st = st+"1.Check news"+ "\n"+"2.View finance cabinet"+"\n"+"3.Check debts";
      while (done) {
        System.out.println(st);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        if (number == 1) {
          System.out.println(checkNews());
        }
        else if (number == 2) {
          for (Student s : checkForDebtOfBooks()) {
            System.out.println(s.getEmail());
          }
        }
      }
    }
}