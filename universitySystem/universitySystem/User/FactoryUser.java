package universitySystem.User;

/**
* @generated
*/

public class FactoryUser {
	
	public static  User getUser(String userType, String firstName, String middleName, String secondName) {
	
		if (userType == null) {
			return null;
		}
		if (userType.equalsIgnoreCase("STUDENT")) {
		   Student s = new Student(firstName, middleName, secondName);
		   CreateSingleton.getStudents().add(s);
		   return s;
			
		}
		if (userType.equalsIgnoreCase("EMPLOYEE")) {
			Employee e = new Employee(firstName, middleName, secondName);
			   CreateSingleton.getEmployees().add(e);
			   return e;
		}
		if (userType.equalsIgnoreCase("TEACHER")) {
			Teacher t  = new Teacher(firstName, middleName, secondName);
			   CreateSingleton.getEmployees().add(t);
			   return t;
		}
		if (userType.equalsIgnoreCase("OR")) {
			OR o = new OR(firstName, middleName, secondName);
		   CreateSingleton.getEmployees().add(o);
		   return o;
		}
		if (userType.equalsIgnoreCase("ACCOUNTER")) {
			Accounter a = new Accounter(firstName, middleName, secondName);
			   CreateSingleton.getEmployees().add(a);
			   return a;
		}
		if (userType.equalsIgnoreCase("LIBRARIAN")) {
			Librarian l = new Librarian(firstName, middleName, secondName);
			   CreateSingleton.getEmployees().add(l);
			   return l;
		}
		if (userType.equalsIgnoreCase("ABITURIENT")) {
			Abiturient ab = new Abiturient(firstName, middleName, secondName);
//			   CreateSingleton.getStudents().add(ab);
			   return ab;
		}
		if (userType.equalsIgnoreCase("DISCIPCOMMIT")) {
			DisciplinaryCommittee d = new DisciplinaryCommittee(firstName, middleName, secondName);
			   CreateSingleton.getEmployees().add(d);
			   return d;
		}
		return null;
	}
      
}
