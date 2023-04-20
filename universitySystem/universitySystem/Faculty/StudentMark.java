package universitySystem.Faculty;


import java.util.Vector;

import universitySystem.Faculty.Attendance;
import universitySystem.Faculty.Mark;

/**
* @generated
*/

public class StudentMark {
    
    private Vector<Mark> firstAttestation = new Vector<Mark>();
    private Vector<Mark> secondAttestation;
    private double finalExam;
    private Vector<Attendance> attendance;
    private double totalMark;
    
    public StudentMark(){
    	
    }
    
    
    public double calculateFirstAttestation() {
     double sumOfFirstAttestation = 0;
     for(Mark m : firstAttestation) {
    	 sumOfFirstAttestation += m.getPoint();
     }
        return sumOfFirstAttestation;
    }
    
    public Vector<Mark> getFirstAttestation() {
    	return firstAttestation;
    }
    
    public double calculateSecondAttestation() {
    	double sumOfSecondAttestation = 0;
    	for(Mark m : secondAttestation) {
    		sumOfSecondAttestation += m.getPoint();
    	}
        return sumOfSecondAttestation;
    }
    
    public Vector<Mark> getSecondAttestation() {
    	return secondAttestation;
    }
    
    public double getFinalExam() {
        return this.finalExam;
    }
    
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }
    
    public Vector<Attendance> getAttendance() {
        return this.attendance;
    }
    
    public double getTotalMark() {
        return finalExam + calculateFirstAttestation() + calculateSecondAttestation();
    }
    
    public int calculateAbsents() {
    	int cnt = 0;
        for(Attendance a : attendance) {
        	if(a == Attendance.ABSENT) {
        		cnt++;
        	}
        }
        return cnt;
    }
    
}
