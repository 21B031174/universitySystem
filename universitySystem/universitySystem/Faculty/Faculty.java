package universitySystem.Faculty;

import java.util.Vector;

import universitySystem.Faculty.Lesson;
import universitySystem.User.Student;
import universitySystem.User.Teacher;

/**
* @generated
*/

public class Faculty {
    
	public String name;
    private Vector<Teacher> teachingStaff = new Vector<Teacher>();
    private Vector<Lesson> disciplines = new Vector<Lesson>();
    private Vector<Lesson> electives = new Vector<Lesson>();
    private Student president;
    
    public Faculty(String name) {
    	this.name = name;
    }
    
    
    public Vector<Teacher> getTeachingStaff() {
        return this.teachingStaff;
    }
    
    public void setTeachingStaff(Vector<Teacher> teachingStaff) {
        this.teachingStaff = teachingStaff;
    }
    
    public Vector<Lesson> getDisciplines() {
        return this.disciplines;
    }
    
    public void setDisciplines(Vector<Lesson> disciplines) {
        this.disciplines = disciplines;
    }
    
    public Vector<Lesson> getElectives() {
        return this.electives;
    }
    
    public void setElectives(Vector<Lesson> electives) {
        this.electives = electives;
    }
    
    public Student getPresident() {
        return this.president;
    }
    
    public void setPresident(Student president) {
        this.president = president;
    }
    
}
