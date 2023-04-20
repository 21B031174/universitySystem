package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;

import universitySystem.Faculty.Attendance;
import universitySystem.Faculty.Book;
import universitySystem.Faculty.DayOfWeeks;
import universitySystem.Lesson.Probability;
import universitySystem.Faculty.StudentMark;
import universitySystem.Faculty.Time;
import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.PaidCourse;
import universitySystem.Faculty.ReaderDiary;
import universitySystem.Faculty.Requests;
import universitySystem.Faculty.Faculty;
import universitySystem.Faculty.FinanceCabinet;
import universitySystem.Faculty.Rup;

/**
* @generated
*/

@SuppressWarnings("serial")
public class Student extends User implements Anketa {
    
    private Integer course;
    private Map<Lesson, Time> Schedule = new HashMap<Lesson, Time>();
    private Faculty faculty;
    private double gpa;
    private Boolean isBlocked;
    private Map<Lesson, StudentMark> disciplinesGrades = new HashMap<Lesson, StudentMark>();
    private Rup rup;
    private Integer badBehaviourCnt;
    private Probability probability;
    private Degree degree;
    private ReaderDiary readerDiary = new ReaderDiary();
    public Vector<Lesson> registrDisc = new Vector<Lesson>();
    boolean stud = true;
    boolean done = true;
    
    
    public Integer getCourse() {
        return this.course;
    }
    
    public void setCourse(Integer course) {
        this.course = course;
    }
    
    public Map<Lesson, Time> getSchedule() {
        return this.Schedule;
    }
    
    public void setSchedule(Map<Lesson, Time> Schedule) {
        this.Schedule = Schedule;
    }
    
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    
    public double getGpa() {
        return this.gpa;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public Boolean getIsBlocked() {
        return this.isBlocked;
    }
    
    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }
    
    public Student(String firstName, String middleName, String secondName, Integer course, Faculty faculty, Degree degree) {
    	super(firstName, middleName, secondName);
    	this.course = course;
    	this.faculty = faculty;
    	this.degree = degree;
    }
    
    public Student(String firstName, String middleName, String secondName) {
    	super(firstName, middleName, secondName);
    	this.setId(CreateSingleton.cnt);
	}

	public Map<Lesson, StudentMark> getDisciplinesGrades() {
        return this.disciplinesGrades;
    }
    
    public void setDisciplinesGrades(Map<Lesson, StudentMark> disciplinesGrades) {
        this.disciplinesGrades = disciplinesGrades;
    }
    
    public Rup getRup() {
        return this.rup;
    }
    
    public void setRup(Rup rup) {
        this.rup = rup;
    }
    
    public Integer getBadBehaviourCnt() {
        return this.badBehaviourCnt;
    }
    
    public void setBadBehaviourCnt(Integer badBehaviourCnt) {
        this.badBehaviourCnt = badBehaviourCnt;
    }
    
    public Probability getProbability() {
        return this.probability;
    }
    
    public void setProbability(Probability probability) {
        this.probability = probability;
    }
    
    public Degree getDegree() {
        return this.degree;
    }
    
    public void setDegree(Degree degree) {
        this.degree = degree;
    }
    
    public ReaderDiary getReaderDiary() {
        return this.readerDiary;
    }
    
    public void setReaderDiary(ReaderDiary readerDiary) {
        this.readerDiary = readerDiary;
    }
    
//    This method shows schedule of student.It does not take any parameters, because each students has a schedule like a field.
    public void viewSchedule() {
    	for (Map.Entry<Lesson, Time> m: Schedule.entrySet()){
            System.out.println("Lesson: "+ m.getKey() + ", Date: " + m.getValue());
        }
    }
    
//  This method schows List Of Registered Disciplines.It does not take any parameters, because each students has a schedule like a field.
    public void viewListOfRegisteredDisciplines() {
        System.out.println(Schedule.keySet());
    }
    
//    t shows transcript of student. It doesn`t have any parameters. As transcript is a map of lesson and total mark from StudentMark class.
    public void viewTranscript() {
    	for (Lesson l : Schedule.keySet()) {
    		System.out.println(l.toString() + " " + disciplinesGrades.get(l).getTotalMark());
    	}
    }
    
//    This method is used to attend at lessons. It takes one parameter - lesson. It is based on the current time. According to it the attendance is put.
    public void attend(Lesson l) {
    	if (LocalDateTime.now().getDayOfWeek() == Schedule.get(l).day && LocalDateTime.now().getHour() == Schedule.get(l).t.getHour() && (LocalDateTime.now().getMinute() - Schedule.get(l).t.getMinute()) <= 5)
        	disciplinesGrades.get(l).getAttendance().add(Attendance.PRESENT);
        else if (LocalDateTime.now().getMinute() - Schedule.get(l).t.getMinute() > 5 && LocalDateTime.now().getMinute() - Schedule.get(l).t.getMinute() < 15) {
        	disciplinesGrades.get(l).getAttendance().add(Attendance.LATE);
        }else {
        	disciplinesGrades.get(l).getAttendance().add(Attendance.ABSENT);
        }
    }
    
//   This method helps students to register on disciplines. And to do this it takes 1 parameter - lesson.
    public void registerOnDisciplines(Lesson lesson) {
    	this.registrDisc.add(lesson);
    }
    
//    
    public Probability getProbabillity() {
        //TODO
        return null;
    }
    
    public void createSchedule(Lesson l,DayOfWeeks d, String time) {
        Time t = new Time();
        Schedule.put(l, t);
   }
    
//    It is used to write requests from students to OR. It takes parameters - student and request. Requests are academic mobility, reference and so on.
    public void makeRequests(Student s, Requests r) {
    	OR.getRequests().put(s,r);
    }
    
    public String toString() {
        return super.toString() + ", the degree is " + this.degree;
    }

	@Override
	public int compareTo(Object o) {
		Student s = (Student) o;
		if (this.gpa > s.gpa) return 1;
		else if (this.gpa < s.gpa) return -1;
		else return 0;
	}

//	It allows to evaluate teachers. Again, 2 parameters - Object (may be a teacher) and num (evaluation)
	@Override
	public void takeSurvey(Object o,Integer num) {
		Teacher t = (Teacher) o;
		t.getEvaluationOfTeacher().add(num);
	}
	
//	It is used to print attestations of student. It returns map that is contained of lesson and mark.
	public Map<Lesson, Double> returnAttestations() {
		Map<Lesson, Double> n = new HashMap<Lesson, Double>();
		for (Lesson l : disciplinesGrades.keySet()) {
			Double grade = disciplinesGrades.get(l).calculateFirstAttestation() + disciplinesGrades.get(l).calculateSecondAttestation();
			n.put(l, grade);
		}return n;
	}
	
//	It is used to apply to paid courses from older students, one parameter - course.
	public void applyToCourses(PaidCourse p) {
	    p.addStudent(this);
	  }
	public void vieweMenu(Student s)throws IOException {
		String st = "";
    	st = st+"1.View Schedule" + "\n"+ "2.View attestation"+"\n"+"3.View transcript"+"\n"+"4.View news"+"\n"+"5.View finance cabinet"+"\n"+"6.Take survay"+"\n"+"7.Apply to courses" + "\n" + "8. Register on disciplines" + "\n" + "9. Create schedule";
    	while (true) {
    	System.out.println(st);
    	System.out.println("0 - log in");
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	int number = Integer.parseInt(reader.readLine());
    	if (number == 0) {
    		while (done) {
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
//        				e.vieweMenu(e);
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
		if(number == 1) {
			s.getSchedule();
		}else if(number == 2) {
			s.returnAttestations();
		}else if(number == 3) {
			s.viewTranscript();
		}else if(number == 4) {
			CreateSingleton.getNews();
		}else if(number == 5) {
			System.out.println(s.getFinanceCabinet());
		}else if(number == 6) {
			System.out.println("We are glad to welcome you to the questionnair!Please,write down the teacher firstname");
			String firstname = reader.readLine();
			System.out.println("Please,write down the teacher middle name:");
			String middlename = reader.readLine();
			System.out.println("Please,write down the teacher second name:");
			String secondname = reader.readLine();
			Teacher t = new Teacher(firstname,middlename,secondname);
			System.out.println("Please write a rating from 0 to 10:");
			int numm = Integer.parseInt(reader.readLine());
			s.takeSurvey(t,numm);
		
		}else if(number == 7) {
			s.applyToCourses(null);
		}
		
		else if (number == 8) {
			System.out.println("The names of the courses will be loaded on by one, and you have to type 'yes' or 'no'");
			for (Lesson l : getFaculty().getDisciplines()) {
				System.out.println(l.name);
				String ans = reader.readLine();
				if (ans.equals("yes")) this.registerOnDisciplines(l);
			}
		}
		
		else if (number == 9) {
			int cnt = 1;
			for (Lesson l : this.registrDisc) {
				Time ti = null;
				for (Teacher t : this.faculty.getTeachingStaff()) {
					ti = t.getSchedule().get(l);
					System.out.println(Integer.toString(cnt) + " - " + t.getSchedule().get(l));
					}int x = Integer.parseInt(reader.readLine());
					this.Schedule.put(l, ti);
				}
			}
		}
		
    	}
}
