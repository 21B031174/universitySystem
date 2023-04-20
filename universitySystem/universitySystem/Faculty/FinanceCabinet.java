package universitySystem.Faculty;

import java.util.Date;

import universitySystem.User.Student;

/**
* @generated
*/

public class FinanceCabinet {
    
    private double balance;
    
    
    public double getBalance() {
        return this.balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
//    addToBalance - adds double parameter to current balance field. Void.
    public void addToBalance(double d) {
    	setBalance(getBalance()+d);
    }
    
    public String toString() {
    	return Double.toString(balance);
    }
                                    
    
    
}
