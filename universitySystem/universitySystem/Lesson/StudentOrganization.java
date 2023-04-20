package universitySystem.Lesson;

import java.util.Vector;

import universitySystem.User.Student;

/**
* @generated
*/

public class StudentOrganization {
    
    private Vector<Student> team;
    private Student president;
    private String name;
    private Section section;
    
  
    public Vector<Student> getTeam() {
        return this.team;
    }
    
    public void setTeam(Vector<Student> team) {
        this.team = team;
    }
    
    public Student getPresident() {
        return this.president;
    }
    
    public void setPresident(Student president) {
        this.president = president;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Section getSection() {
        return this.section;
    }
    
    public void setSection(Section section) {
        this.section = section;
    }
    
}
