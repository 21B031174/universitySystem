package universitySystem.Faculty;

import universitySystem.User.User;

/**
* @generated
*/

public class Message {
	
    private User receiver;
    private String text;
    private User sender;
    
    public Message(User receiver, String text, User sender) {
    	this.receiver = receiver;
    	this.text = text;
    	this.sender = sender;
    }
   
    public User getReceiver() {
        return this.receiver;
    }
    
    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public User getSender() {
        return this.sender;
    }
    
    public void setSender(User sender) {
    	this.sender = sender;
    }
    
    
}
