package universitySystem.User;

//import java.awt.DisplayMode;

import java.awt.DisplayMode;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import universitySystem.Faculty.Faculty;
import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.Mark;
import universitySystem.Faculty.Message;
import universitySystem.Faculty.Semester;

public class Test {
	
	public static void main(String[] args) throws Exception {
		
//		Faculty fit = new Faculty("FIT");
////		
//		Student u1 = new Student("Inara", "Almagambetova", "Baitasovna", 1, fit, Degree.BACHELOR);
//		Student u2 = new Student("Aitolkyn", "Amantai", "Avc", 1, fit, Degree.BACHELOR);
		
//		System.out.print(u1.getPassword());
//		
//		Message m = new Message(u1, "hey", u2);
//		Message m1 = new Message(u1, "heyyyyy", u2);
//		Message m2 = new Message(u1, "hello", u2);
//		
//		u2.sendMessage(m);
//		u2.sendMessage(m1);
//		
//		System.out.println(u1.getPersonalMessages());
//		System.out.println(u2.getPersonalMessages());
//		
//		System.out.println(u1.getReadMessages());
//		System.out.println(u2.getReadMessages());
		
//		System.out.println(u1.showMessages());
//		System.out.println(u2.showMessages());
		
//		u1.answerToMesage(m1, "hello");
//		
//		System.out.println(u1.showMessages());
//		System.out.println(u2.showMessages());
//		
//		Lesson oop = new Lesson("OOP");
//		
//		Teacher t1 = new Teacher("aaa", "bbb", "ccc", 100, TeachingStatus.ASSISTENT);
//		Teacher t2 = new Teacher("ddd", "eee", "fff", 1000, TeachingStatus.ASSISTENT);
		
//		t1.putMark(u2, oop, new Mark(2), 2, new Semester());
		
//		System.out.println(u2.getDisciplinesGrades());
		
//		System.out.println(t2.compareTo(t1));
//		
		CreateSingleton singleton = CreateSingleton.getInstance("KBTU");
//		
//		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt")))
//        {
//            oos.writeObject(t1.toString());
//        }
//        catch(Exception ex) {
//             
//            System.out.println(ex.getMessage());
//        } 
//		
//		singleton.addStudent(u2);
//		singleton.addStudent(u1);
		
//		System.out.print(u1.getPassword());
		
//	u2.registerOnDisciplines(oop);
		
//t1.putMark(u2, oop, new Mark(2), 2, new Semester());
		
//		System.out.println(u2.getDisciplinesGrades());
//		StudentMenu s = new StudentMenu();
//		Student ss = new Student("Aitolkyn","Amantai","AHJHJH");
////		s.vieweMenu(ss);
//		TeacherMenu t = new TeacherMenu();
//		Teacher tt = new Teacher("Aitolkyn","Amantai","AHJHJH");
//		t.vieweMenu(tt);
//		System.out.print(CreateSingleton.getStudents());
		
		Admin a = new Admin("a", "b", "c", 1200);
		a.vieweMenu();
		
	}
	
}
