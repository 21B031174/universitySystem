package universitySystem.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import universitySystem.Lesson.StudentOrganization;
import universitySystem.Faculty.Dormitory;
import universitySystem.Faculty.Faculty;

/**
* @generated
*/

public final class CreateSingleton {
  
	private static CreateSingleton instance;
    private static Vector<Student> students;
    private static Vector<Employee> employees;
    private static Vector<Faculty> faculties;
    private static Vector<StudentOrganization> studentOrganizations;
    private static String generalInfoAboutUni;
    private static Vector<String> news;
    public static int cnt = 0;
    public static Dormitory dormitory;
    
    static{
    	
    	//check ser
		students = new Vector<Student>();
		employees = new Vector<Employee>();
		faculties = new Vector<Faculty>();
		studentOrganizations = new Vector<StudentOrganization>();
		news = new Vector<String>();
		cnt++;
//		if(new File("person").exists()) {
//			try {
//				instance = read();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		else instance = new CreateSingleton(generalInfoAboutUni);

	}
//    public static CreateSingleton read() throws IOException, ClassNotFoundException{
//		FileInputStream fis = new FileInputStream("person");
//		ObjectInputStream oin = new ObjectInputStream(fis);
//		return (CreateSingleton) oin.readObject();
//	}
//	public static void write()throws IOException{
//		FileOutputStream fos = new FileOutputStream("person");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		oos.writeObject(instance);
//		oos.close();
//	}
    private CreateSingleton(String generalInfroAboutUni) {
    	try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        CreateSingleton.generalInfoAboutUni = generalInfroAboutUni;
    }
    
    public static CreateSingleton getInstance(String value) throws IOException, ClassNotFoundException {
        if (instance == null) {
        	try {
            FileInputStream fileInputStream = new FileInputStream("Data.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			instance = (CreateSingleton) objectInputStream.readObject();
			objectInputStream.close();
        	}catch (Exception e) {
				instance = new CreateSingleton(value);
			}
        }
        return instance;
    }
    
    public void addStudent(Student s) {
    	CreateSingleton.students.add(s);
    }
    
    public void addEmployee(Employee e) {
    	CreateSingleton.employees.add(e);
    }
    
    public void addFaculty(Faculty f) {
    	CreateSingleton.faculties.add(f);
    }
    
    public void addStudentOrganization(StudentOrganization s) {
    	CreateSingleton.studentOrganizations.add(s);
    }
    
    public void addNews(String s) {
    	CreateSingleton.news.add(s);
    }
    
    public static Vector<Student> getStudents() {
        return CreateSingleton.students;
    }
    
    public static Vector<Employee> getEmployees() {
        return CreateSingleton.employees;
    }
    
    public static Vector<Faculty> getFaculties() {
        return CreateSingleton.faculties;
    }
    
    public Vector<StudentOrganization> getStudentOrganizations() {
        return CreateSingleton.studentOrganizations;
    }
    
    public static String getGeneralInfoAboutUni() {
        return CreateSingleton.generalInfoAboutUni;
    }
    
    public void setGeneralInfoAboutUni(String generalInfoAboutUni) {
        CreateSingleton.generalInfoAboutUni = generalInfoAboutUni;
    }
    
    public static Vector<String> getNews() {
        return CreateSingleton.news;
    }
    
}
