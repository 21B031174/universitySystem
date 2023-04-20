package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Vector;

/**
* @generated
*/

public class Accounter extends Employee {
    
    private static final long serialVersionUID = 1L;

	public Accounter(String firstName, String middleName, String secondName, double salary) {
		super(firstName, middleName, secondName, salary);
	}
	public Accounter(String firstName, String middleName, String secondName) {
		super(firstName, middleName, secondName);
	}

	public Vector<Student> checkForDebts() {
		Vector<Student> v = new Vector<Student>();
        for (Student s: CreateSingleton.getStudents()) {
        	if (s.getFinanceCabinet().getBalance() <= 0) v.add(s);
        }return v;
    }
    
    public void calculateSalary() {
        for (Employee e: CreateSingleton.getEmployees()) {
        	e.getFinanceCabinet().addToBalance(e.getSalary());
        }
    }

    public void vieweMenu()throws IOException,NullPointerException {
        String st = "";
        st = st+"1.View news"+"\n"+"2.View finance cabinet"+"\n"+"3.Check for debts"+"\n"+"3.Calculate salary";
        while (done) {
               System.out.println(st);
               BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
               int number = Integer.parseInt(reader.readLine());
               if(number == 1) {
                   System.out.println(CreateSingleton.getNews());
               }else if(number == 2) {
                   System.out.println(getFinanceCabinet());
               }else if(number == 3) {
                   System.out.println(checkForDebts());
               }else if(number == 4) {
                calculateSalary();
                   System.out.println("Done!");
               }
           }
       }
    
}
