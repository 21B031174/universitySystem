package universitySystem.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.Random;
import java.util.Vector;

/**
* @generated
*/

@SuppressWarnings("serial")
public class Abiturient extends User implements Serializable {
	
	boolean done = true;
	
	  public Abiturient(String firstName, String middleName, String secondName) {
	      super(firstName, middleName, secondName);
	  }
	  
	  public boolean submitDocuments(Vector<String> vect) {
	    if (!vect.isEmpty()) {
	      return true;
	    }
	    return false;
	  }
	  
	  public Student consultationFromStudent() {
		  int num = (int) (Math.random() * CreateSingleton.getStudents().size());
 	      return CreateSingleton.getStudents().get(num);
	  }
	  
	  public void consultationFromAdmissionComittee() {
		  System.out.println(CreateSingleton.getGeneralInfoAboutUni());
//	    We'll think about it
	  }
	  
	  public void vieweMenu() throws NumberFormatException, IOException {
	      String st = "";
	      st = st+"1.Submit Documents"+"\n"+"3.View news"+"\n"+"3.View information about university";
	      while (done) {
	             System.out.println(st);
	             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	             int number = Integer.parseInt(reader.readLine());
	             if(number == 1) {
	              Vector<String> docum = new Vector<String>();
	                 String doc = "";
	                 System.out.println("Please write what documents you want to upload:");
	                 while(doc != "break") {
	                   doc = reader.readLine();
	                   docum.add(doc);
	                 }
	                 submitDocuments(docum);
	                 System.out.println("Your documents have been uploaded successfully");
	             }else if(number == 2) {
	                 System.out.println(CreateSingleton.getNews());
	             }else if(number == 3) {
	              System.out.println(CreateSingleton.getGeneralInfoAboutUni());
	             }
	      }
	      
	   }
	    

	}