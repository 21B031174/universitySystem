package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Vector;

import universitySystem.Faculty.DayOfWeeks;
import universitySystem.Faculty.FinanceCabinet;
import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.Time;

/**
* @generated
*/

public class Employee extends User implements Comparable<Object> {

	private static final long serialVersionUID = 1L;
	private double salary;
	private Vector<Integer> evaluationOfEmployee;
	boolean done = true;
	public Employee(String firstName, String middleName, String secondName, double salary) {
		super(firstName, middleName, secondName);
		this.salary = salary;
	}
	
	public Vector<Integer> getEvaluationOfEmployee() {
        return this.evaluationOfEmployee;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
  
    
    public Employee(String firstName, String middleName, String secondName) {
    	super(firstName, middleName, secondName);
	}
    
    public String toString() {
        return super.toString();
    }

	@Override
	public int compareTo(Object o) {
		Employee e = (Employee) o;
		if (this.salary > e.salary) return 1;
		else if (this.salary < e.salary) return -1;
		else return 0;
	}


    
    public void viewMenu()throws IOException,NullPointerException {
    	String st = "";
    	st = st+"1.View news"+"\n"+"2.View finance cabinet";
    	while (done) {
            System.out.println(st);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int number = Integer.parseInt(reader.readLine());
            if(number == 1) {
                System.out.println(CreateSingleton.getNews());
            }else if(number == 2) {
            	System.out.println(getFinanceCabinet());
            }
        }
    }
    
}
