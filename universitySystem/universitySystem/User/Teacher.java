package universitySystem.User;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.Vector;

import universitySystem.Faculty.DayOfWeeks;
import universitySystem.Faculty.Faculty;
import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.Mark;
import universitySystem.Faculty.Semester;
import universitySystem.Faculty.Time;

/**
* @generated
*/

@SuppressWarnings("serial")
public class Teacher extends Employee implements Comparable<Object>, Anketa, Teach, Serializable {
	public Faculty f;
	private Vector<Integer> evaluationOfTeacher = new Vector<Integer>();
	private Vector<Lesson> teachingDisciplines = new Vector<Lesson>();
    private Map<Lesson, Time> Schedule = new HashMap<Lesson, Time>();
    private TeachingStatus status;
    boolean done = true;
    boolean stud = true;
    
    public Teacher(String firstName, String middleName, String secondName, double salary, TeachingStatus status) {
		super(firstName, middleName, secondName, salary);
		this.status = status;
		setF();
	}
    
    public void setF() {
    	for (Faculty f : CreateSingleton.getFaculties()) {
    		for (Teacher t : f.getTeachingStaff()) {
    			if (t == this) this.f = f;
    		}
    	}
    }
    
    public Vector<Integer> getEvaluationOfTeacher() {
        return this.evaluationOfTeacher;
    }
    public Vector<Lesson> getTeachingDisciplines() {
        return this.teachingDisciplines;
    }
    
    public void setTeachingDisciplines(Vector<Lesson> teachingDisciplines) {
        this.teachingDisciplines = teachingDisciplines;
    }
    
    public Map<Lesson, Time> getSchedule() {
        return this.Schedule;
    }
    
    public void setSchedule(Map<Lesson, Time> Schedule) {
        this.Schedule = Schedule;
    }
    
    public TeachingStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(TeachingStatus status) {
        this.status = status;
    }
    
    public void viewSchedule() {
        for (Map.Entry<Lesson, Time> m: Schedule.entrySet()){
               System.out.println("Lesson: "+ m.getKey() + ", Date: " + m.getValue());
           }
    }
    
    public String toString() {
        return super.toString() + ", the degree is " + this.status;
    }
    @Override
//    takeSurvey - it is used to participate in survey and rate other employee, for example, deans. Rating as integer parameter goes to exact employee as object parameter. Void.
	public void takeSurvey(Object o,Integer num) {
		Employee e = (Employee) o;
		e.getEvaluationOfEmployee().add(num);
	}
    
	public Teacher(String firstName, String middleName, String secondName) {
    	super(firstName, middleName, secondName);
	}
	
//	 @Override
//	putMark - It is used to put mark of discrete lesson for exact student, on first or second attestation, depending on current week. Mark object goes to Student object in exact integer week and discrete semester. Void.
	 public void putMark(Student s, Lesson lesson, Mark mark, int week, Semester st){
		 
	     if (week <= 8) s.getDisciplinesGrades().get(lesson).getFirstAttestation().add(mark);
	     else s.getDisciplinesGrades().get(lesson).getSecondAttestation().add(mark);
	     
//	     s.setDisciplinesGrades(s.getDisciplinesGrades().put(lesson, null));
	 }
	 
	 public void vieweMenu() throws IOException {
		    String st = "";
		    st = st+"1.View Schedule"+ "\n"+"2.View news"+"\n"+"3.View finance cabinet"+"\n"+"4.Take survey" + "\n" + "5. Add a course";
		    while (true) {
		    System.out.println(st);
		    
		    System.out.println("0 - log in");
	    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    	int number = Integer.parseInt(reader.readLine());
	    	if (number == 0) {
	    		while (stud) {
	    			System.out.println("Enter your login and password");
	    		String login = reader.readLine();
	    		String password = reader.readLine();
	    		for (Student sss: CreateSingleton.getStudents()) {
	    			if (sss.getPassword().equals(password) && sss.getLogin().equals(login)) {
	    				sss.vieweMenu(sss);
	    				done = false;
	        			stud = false;
	    			}
	    		}
	    		if (stud) {
	    			for (Employee e : CreateSingleton.getEmployees()) {
	        			if (e.getPassword().equals(password) && e.getLogin().equals(login)) {
//	        				e.vieweMenu(e);
	        				done = false;
	            			stud = false;
	            			if (e instanceof Teacher) {
	            				Teacher t = (Teacher)e;
	            				t.vieweMenu();
	            			}
	        			}
	        		}
	    		}
	    		if (done) System.out.println("Sorry, login or password are incorrect. Try for the second time");
	    		}
	    	}
		    
		    if (number == 1) {
		    	if (Schedule.isEmpty()) {
		    		System.out.println("We are sorry, your schedule is still empty. But you can add courses to teach");
		    	}
		    	else viewSchedule();
		    }
		    else if (number == 2) {
		      checkNews();
		    }
		    else if (number == 3) {
		      getFinanceCabinet();
		    }
		    else if (number == 4) {
		        System.out.println("We are glad to welcome you to the questionnair!Please,write down the employee firstname");
		          String firstname = reader.readLine();
		          System.out.println("Please,write down the employee middle name:");
		          String middlename = reader.readLine();
		          System.out.println("Please,write down the employee second name:");
		          String secondname = reader.readLine();
		          Employee e = new Employee(firstname,middlename,secondname);
		          System.out.println("Please write a rating from 0 to 10:");
		          int numm = Integer.parseInt(reader.readLine());
		          takeSurvey(e,numm);
		      }else if (number == 5) {
		    	  System.out.println("Great! Please write the name of the course");
		    	  String name = reader.readLine();
		    	  System.out.println("Please add the full information about the course int this order: number of lectures, practices and labs per week");
		    	  int num1 = Integer.parseInt(reader.readLine());
		    	  int num2 = Integer.parseInt(reader.readLine());
		    	  int num3 = Integer.parseInt(reader.readLine());
		    	 
		    	  
		    	  System.out.println("Does it have any prerequisite of this subjects?");
		    	  
		    	  for (Faculty f: CreateSingleton.getFaculties()) {
		    		  for (Lesson l : f.getDisciplines()) {
		    			  System.out.println(l.name);
		    		  }for (Lesson l : f.getElectives()) {
		    			  System.out.println(l.name);
		    		  }
		    	  }
		    	  
		    	  System.out.println("Please write the name of prerequisite (or just type 'null' if subject has no prerequisite");
		    	  String prereq = reader.readLine();
		    	  Lesson l = new Lesson(name, num1, num2, num3);
		    	  f.getDisciplines().add(l);
		    	  if (prereq != "null") {
		    		  for (Faculty ff: CreateSingleton.getFaculties()) {
			    		  for (Lesson ll : ff.getDisciplines()) {
			    			  if (ll.name.equals(prereq)) {
			    				  l.setPrerequisite(ll);
			    				  break;
			    			  }
			    		  }for (Lesson ll : ff.getElectives()) {
			    			  if (ll.name.equals(prereq)) {
			    				  l.setPrerequisite(ll);
			    				  break;
			    			  }
			    		  }
			    	  }
		    	  }
		    	  System.out.println("Please choose the day of week for it: 1 - mon, 2 - tue, 3 - wed, 4 - thu, 5 - fri");
		    	  int d = Integer.parseInt(reader.readLine());
		    	  DayOfWeek day;
		    	  if (d == 1) {
		    		  day = DayOfWeek.MONDAY;
		    	  }else if (d == 2) {
		    		  day = DayOfWeek.TUESDAY;
		    	  }else if (d == 3) {
		    		  day = DayOfWeek.WEDNESDAY;
		    	  }else if (d == 4) {
		    		  day = DayOfWeek.THURSDAY;
		    	  }else {
		    		  day = DayOfWeek.FRIDAY;
		    	  }
		    	  System.out.println("Please choose the time for it");
		    	  int hour = Integer.parseInt(reader.readLine());
		    	  int min = Integer.parseInt(reader.readLine());
		    	  LocalTime time = LocalTime.of(hour, min);
		    	  Time dayy = new Time(time, day);
		    	  Schedule.put(l, dayy);
		    	  System.out.println("Your schedule was updated");
		      }
		    	  
		      }
		  }
    
}
