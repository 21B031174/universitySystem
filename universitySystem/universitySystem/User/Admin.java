package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import universitySystem.Faculty.Faculty;

/**
* @generated
*/

public class Admin extends Employee{
	
	public boolean done = true;
	public boolean aa = true;
	
	private static final long serialVersionUID = 1L;

	public Admin(String firstName, String middleName, String secondName, double salary) {
		super(firstName, middleName, secondName, salary);
	}

	public void addUser(String usertype,String firstname,String middlename,String secondname) {
       FactoryUser.getUser(usertype,firstname, middlename,secondname);
    }
    
    /**
    * @generated
    */
	
    public void block() {
       for(Student s : CreateSingleton.getStudents()) {
    	   if(s.getBadBehaviourCnt() > 2) {
    		   s.setIsBlocked(true);
    	   }
       }
    }
    
    public void vieweMenu(Admin a)throws IOException {
    	String st = "";
    	st = st+"1.View news"+"\n"+"2.View finance cabinet"+"\n"+"3.Add user"+"\n" + "4.Sign in (for students and employees" + "\n" + "5. Sign up (for abiturient)" + "\n" + "6. Add new faculty";
    	while (done) {
    	System.out.println(st);
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int number = Integer.parseInt(reader.readLine());
    	if (number == 4) {
    		while (aa) {
    		String login = reader.readLine();
    		String password = reader.readLine();
    		for (Student s: CreateSingleton.getStudents()) {
    			if (s.getPassword().equals(password) && s.getLogin().equals(login)) {
    				s.vieweMenu(s);
    				done = false;
        			aa = false;
    			}
    		}if (done) System.out.println("Sorry, login or password are incorrect. Try for the second time");
    		}
    	}else if (number == 6) {
    		System.out.println("Please enter the faculty`s name");
    		String fName = reader.readLine();
    		Faculty f = new Faculty(fName);
    		CreateSingleton.getFaculties().add(f);
    	}else if(number == 1) {
    		CreateSingleton.getNews();
    	}else if(number == 2) {
    		a.getFinanceCabinet();
    	}else if(number == 3) {
    		if (CreateSingleton.getFaculties().isEmpty()) {
    			System.out.println("Sorry, first of all you have to add faculties");
    		}
    		else {
    		System.out.println("Please,write down the user type:"+"\n"+"1-Student, 2-Employee, 3-Teacher, 4-OR, 5-Librarian, 6-Accounter, 7-Abiturient, 8-DisciplinaryCommittee");
    		int num = Integer.parseInt(reader.readLine());
    		String type = "";
    		if(num == 1) {
    			type = "STUDENT";
    		}else if (num == 2) {
    			type = "EMPLOYEE";
    		}else if(num == 3) {
    			type = "TEACHER";
    		}else if(num == 4) {
    			type = "OR";
    		}else if (num == 5) {
    			type = "LIBRARIAN";
    		}else if(num == 6) {
    			type = "ACCOUNTER";
    		}else if(num == 7) {
    			type = "ABITURIENT";
    		}else if(num == 8) {
    			type = "DISCIPCOMMIT";
    		}
    		System.out.println("Please,write down the user first name:");
    		String firstname = reader.readLine();
    		System.out.println("Please,write down the user middle name:");
    		String middlename = reader.readLine();
    		System.out.println("Please,write down the user second name:");
    		String secondname = reader.readLine();
    		a.addUser(type, firstname, middlename, secondname);
    		}}
    	}
    }
   
}
