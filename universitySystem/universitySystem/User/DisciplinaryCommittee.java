package universitySystem.User;

import java.util.Date;

/**
* @generated
*/

public class DisciplinaryCommittee extends Employee{

	private static final long serialVersionUID = 1L;

	public DisciplinaryCommittee(String firstName, String middleName, String secondName, double salary) {
		super(firstName, middleName, secondName, salary);
	}
	public DisciplinaryCommittee(String firstName, String middleName, String secondName) {
		super(firstName, middleName, secondName);
	}
	 public void deleteStudent(Student s) {
		 if(s.getBadBehaviourCnt()>5) {
			 CreateSingleton.getStudents().remove(s);
		 }
	 }
	 
}
