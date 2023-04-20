package universitySystem.Faculty;

import java.util.Date;

/**
* @generated
*/

public class Semester {
    
    private Date beginningDate;
    private Date addDropStart;
    private Date createSchedule;
    private Date endDate;
    private Date endOfFirstAtt;
    private Date endOfSecondAtt;
    public int currentWeek;
    
    
    Semester(Date beginningDate){
        this.beginningDate = beginningDate;
    }
    
    Semester(Date beginningDate,Date addDropStart){
        this(beginningDate);
        this.addDropStart = addDropStart;
    }
    
    Semester(Date beginningDate,Date addDropStart,Date createSchedule){
        this(beginningDate,addDropStart);
        this.createSchedule = createSchedule;
    }
    
    Semester(Date beginningDate,Date addDropStart,Date createSchedule,Date endDate){
        this(beginningDate,addDropStart,createSchedule);
        this.endDate = endDate;
    }
       
    
    public Semester() {
	}
    
	public Date getBeginningDate() {
        return this.beginningDate;
    }
    
    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }
    
    public Date getAddDropStart() {
        return this.addDropStart;
    }
    
    public void setAddDropStart(Date addDropStart) {
        this.addDropStart = addDropStart;
    }
    
    public Date getCreateSchedule() {
        return this.createSchedule;
    }
    
    public void setCreateSchedule(Date createSchedule) {
        this.createSchedule = createSchedule;
    }
    
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public int number() {
        //TODO
        return 0;
    }
    
	public Date getEndOfSecondAtt() {
		return endOfSecondAtt;
	}
	
	public void setEndOfSecondAtt(Date endOfSecondAtt) {
		this.endOfSecondAtt = endOfSecondAtt;
	}
	
	public Date getEndOfFirstAtt() {
		return endOfFirstAtt;
	}
	
	public void setEndOfFirstAtt(Date endOfFirstAtt) {
		this.endOfFirstAtt = endOfFirstAtt;
	}
    
    
}
