package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

import universitySystem.Faculty.DayOfWeeks;
import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.Message;
import universitySystem.Faculty.Requests;
import universitySystem.Faculty.Time;

/**
* @generated
*/

public class OR extends Employee{
    private static final long serialVersionUID = 1L;
	static Map<Student, Requests> requests;
	boolean done = true;
    Vector<Student> v = new Vector<Student>();
    
    public OR(String firstName, String middleName, String secondName, double salary) {
    	super(firstName, middleName, secondName, salary);
    }
    public OR(String firstName, String middleName, String secondName) {
    	super(firstName, middleName, secondName);
    }
    
    public static Map<Student,Requests> getRequests(){
    	return requests;
    }
    
    
//   This method helps to create schedule to student. 4 parameters: student, lesson, day, time.
    public void createSchedule(Student s,Lesson l,DayOfWeeks d, String time) {
        Time t = new Time();
        s.getSchedule().put(l, t);
   }
    
//    The method processes the requests of students. No parameters as requests are stored in map
    public void processRequests() {
        for(Map.Entry<Student, Requests> r : requests.entrySet()) {
         if(r.getValue()== Requests.REFERANCE) {
          sendMessage(new Message(r.getKey(),"You referance will be ready in 3 days,come to OR",this));
         }else if(r.getValue() == Requests.GETRELEASE) {
          sendMessage(new Message(r.getKey(),"You release will be ready in 3 days,come to Dean office",this));
         }else if(r.getValue() == Requests.ACADEMMOBILITY) {
          sendMessage(new Message(r.getKey(),"Okay,thank you for your requests.Your requests will be proccess in 3 days,come to Dince office",this));
          v.add(r.getKey());
         }else if(r.getValue() == Requests.DORMITORIES) {
          sendMessage(new Message(r.getKey(),"Okay,thank you for your requests.Your requests will be proccess in 3 days",this));
          
         }
        }
       }
    
//    The method allows to identify students that have passed to academic mobility using comparator.
    public Vector<Student> academmobility() {
		Comparator<Student> q = new GPAComparator();
		v.sort(q);
		Vector<Student> res = new Vector<Student>();
		int max = 5;
		for(Student s:v) {
			if(max != 0 && s.getGpa() > 3) {
				res.add(s);
				max--;
			}
		}
		return res;
    }   
    
    public void vieweMenu(OR o) throws IOException,NullPointerException {
        String st = "";
        st = st+"1.View news" +"\n"+"2.View finance cabinet"+"\n"+"3.Create schedule"+"\n"+"4.Process requests" + "\n" + "5. Academic mobility";
        while (done) {
            System.out.println(st);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int number = Integer.parseInt(reader.readLine());
            if(number == 1) {
                CreateSingleton.getNews();
            }else if(number == 2) {
                o.getFinanceCabinet();
            }else if(number == 3) {
                while(true){
                    System.out.println("1.Create shedule  2.Quit");
                    int n = Integer.parseInt(reader.readLine());
                    if(n == 1){
                        System.out.println("Please,write down the student first name:");
                        String firstname = reader.readLine();
                        System.out.println("Please,write down the studentrmiddle name:");
                        String middlename = reader.readLine();
                        System.out.println("Please,write down the student second name:");
                        String secondname = reader.readLine();
                        Student s = new Student(firstname,middlename,secondname);
                        System.out.println("Please write down the name of the lesson");
                        String name = reader.readLine();
                        Lesson lesson = new Lesson(name);
                        System.out.println("Please write down the day of week:"+"\n"+"1-Monday, 2-Tuesday, 3-Wednesday, 4-Thursday, 5-Friday, 6-Saturday");
                        int numm = Integer.parseInt(reader.readLine());
                        DayOfWeeks d = null;
                        if(numm == 1) {
                            d = DayOfWeeks.MON;
                        }else if(numm == 2) {
                            d = DayOfWeeks.TUE;
                        }else if(numm == 3) {
                            d = DayOfWeeks.WED;
                        }else if(numm == 4) {
                            d = DayOfWeeks.THU;
                        }else if(numm == 5) {
                            d = DayOfWeeks.FRI;
                        }else if(numm == 6) {
                            d = DayOfWeeks.SAT;
                        }
                        System.out.println("Please write down the time");
                        String time = reader.readLine();
                        o.createSchedule(s,lesson, d, time);
                    }else{
                        break;
                    }}
            }else if(number == 4) {
                o.processRequests();
                System.out.println("All requests have been successfully processed");
            }else if (number == 5) {
            	System.out.println(academmobility());
            }
    }
}}
