package universitySystem.User;

public class GPAComparator implements java.util.Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return o1.compareTo(o2);
	}
	
	

}
