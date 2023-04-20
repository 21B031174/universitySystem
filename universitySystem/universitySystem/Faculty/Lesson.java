package universitySystem.Faculty;


import java.util.Map;

import universitySystem.Faculty.Lesson;

/**
* @generated
*/

public class Lesson {
    
    private Integer numberOfCredits;
    private Integer numberOfLectures;
    private Integer numberOfPractices;
    private Integer numberOfLabs;
    private Lesson prerequisite;
    private Map<String, Double> syllabus;
    private Integer numberOfLessonsPerWeek;
    public String name;
    public Integer amountOfLessonPerSemester;
    public Integer amountOfAbsents;
    
    public Lesson(String name) {
    	this.name = name;
    }
    
    public Lesson(String name, Integer numberOfLectures, Integer numberOfPractices, Integer numberOfLabs) {
    	this.name = name;
    	this.numberOfLectures = numberOfPractices;
    	this.numberOfPractices = numberOfPractices;
    	this.numberOfLabs = numberOfLabs;
    }
    
    public void setAmountOfAbsents() {
    	this.amountOfAbsents = amountOfLessonPerSemester * 20 / 100; 
    }
    
    public void setAmountOfLessonPerSemester() {
    	this.amountOfLessonPerSemester = numberOfLessonsPerWeek * 15; 
    }
    
    public Integer getNumberOfCredits() {
        return this.numberOfCredits;
    }
    
    public void setNumberOfCredits(Integer numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
    
    public Integer getNumberOfLectures() {
        return this.numberOfLectures;
    }
    
    public void setNumberOfLectures(Integer numberOfLectures) {
        this.numberOfLectures = numberOfLectures;
    }
    
    public Integer getNumberOfPractices() {
        return this.numberOfPractices;
    }
    
    public void setNumberOfPractices(Integer numberOfPractices) {
        this.numberOfPractices = numberOfPractices;
    }
    
    public Integer getNumberOfLabs() {
        return this.numberOfLabs;
    }
    
    public void setNumberOfLabs(Integer numberOfLabs) {
        this.numberOfLabs = numberOfLabs;
    }
    
    public Lesson getPrerequisite() {
        return this.prerequisite;
    }
    
    public void setPrerequisite(Lesson prerequisite) {
        this.prerequisite = prerequisite;
    }
    
    public Map<String, Double> getSyllabus() {
        return this.syllabus;
    }
    
    public void setSyllabus(Map<String, Double> syllabus) {
        this.syllabus = syllabus;
    }
    
    public Integer getNumberOfLessonsPerWeek() {
        return this.numberOfLessonsPerWeek;
    }
    
    public void setNumberOfLessonsPerWeek(Integer numberOfLessonsPerWeek) {
        this.numberOfLessonsPerWeek = numberOfLectures + numberOfPractices + numberOfLabs;
    }
    
    public String toString() {
    	return this.name;
    }
    
}
