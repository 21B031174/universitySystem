package universitySystem.User;

import java.util.Date;

import universitySystem.Faculty.Lesson;
import universitySystem.Faculty.Mark;
import universitySystem.Faculty.Semester;

public interface Teach {
	
	public void putMark(Student s, Lesson lesson, Mark mark, int week, Semester st);
	

}
