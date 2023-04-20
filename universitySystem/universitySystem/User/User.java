package universitySystem.User;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Vector;

import universitySystem.Faculty.FinanceCabinet;
import universitySystem.Faculty.Message;

/**
* @generated	
*/

@SuppressWarnings("serial")
public abstract class User implements Comparable<Object>, Serializable {
    
    private String firstName;
    private String middleName;
    private String secondName;
    private String login = String.valueOf(CreateSingleton.getStudents().size() + CreateSingleton.getEmployees().size());
    private Integer id = CreateSingleton.cnt;
    private Boolean isResearcher;
    private String password = String.valueOf(CreateSingleton.getStudents().size() + CreateSingleton.getEmployees().size());
    private String email;
    private Deque<Message> personalMessages = new ArrayDeque<Message>();
    private Vector<Message> readMessages = new Vector<Message>();
    
    public User(String firstName, String middleName, String secondName) {
    	this.firstName = firstName;
    	this.middleName = middleName;
    	this.secondName = secondName;
//    	ArrayDeque<Message> personalMessages = new ArrayDeque<Message>();
//    	Vector<Message> readMessages = new Vector<Message>();
    }
    
    public boolean logIn(String login, String password) {
    	if (this.login.equals(login) && this.password.equals(password)) return true;
    	return false;
    }
    
    public void logOut() {
//    	if (this.login.equals(login) && this.password.equals(password)) return true;
//    	return false;
    }
    
    public void changePassword(String newPassword) {
    	this.setPassword(newPassword);
    	System.out.println("You have successfully changed the password");
    }
    
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getMiddleName() {
        return this.middleName;
    }
    
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    public String getSecondName() {
        return this.secondName;
    }
    
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Boolean getIsResearcher() {
        return this.isResearcher;
    }
    
    public void setIsResearcher(Boolean isResearcher) {
        this.isResearcher = isResearcher;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Deque<Message> getPersonalMessages() {
        return this.personalMessages;
    }
    
    public Vector<Message> getReadMessages() {
        return this.readMessages;
    }
    
    public void sendMessage(Message m) {
    	m.getReceiver().personalMessages.addLast(m);
    	m.getSender().readMessages.add(m);
    }
    
    public void answerToMesage(Message toAnswer, String text) {
    	Message toSend = new Message(toAnswer.getSender(), text, toAnswer.getReceiver());
    	this.sendMessage(toSend);
    	toAnswer.getReceiver().readMessages.add(toAnswer);
    	toAnswer.getReceiver().personalMessages.removeLast();
    }
    
    public String showMessages() {
    	String str = "";
    	for (Message m: personalMessages) {
    		str = str + m.getSender().firstName + " " + m.getSender().secondName + " " + m.getSender().middleName + ": " + m.getText() + "\n";
    	}
    	return str;
    }
	private FinanceCabinet financeCabinet;
	    
	    public FinanceCabinet getFinanceCabinet() {
	    return financeCabinet;
	  }
    @Override
    public boolean equals(Object o) {
    	if (o == this) return true;
		if (o == null || (o.getClass() != this.getClass())) return false;
		User u = (User) o;
		
		return u.id == id;
    }
    
    @Override
    public int hashCode() {
		return Objects.hash(secondName, email);
	}
    
    public String toString() {
        return "Name is " + this.secondName + " " + this.firstName + " " + this.middleName;
    }

	@Override
	public int compareTo(Object o) {
		User u = (User) o;
		if (this.id > u.id) return 1;
		else if (this.id < u.id) return -1;
		else return 0;
	}
	
	public void checkNews() {
        System.out.println(CreateSingleton.getNews());
    }
    
    
}
