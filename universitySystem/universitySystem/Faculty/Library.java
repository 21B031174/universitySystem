package universitySystem.Faculty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import universitySystem.Faculty.Book;
import universitySystem.Faculty.Semester;
import universitySystem.User.Student;

/**
* @generated
*/

public class Library {
    
    public Vector<Book> books = new Vector<Book>();
    public static int counter;   
    
//    It is comparing two books. Parameters - book1, book2.
    public boolean equals(Book b1, Book b2){

        if (b1.serialNumber == b2.serialNumber) {
            System.out.println("Book of this serial number already exists");
            return true;
        }
        return false;
    }
    
//    It is used to add new book. Parameter - book (object).
    public void addBook(Book b){
    	
    	for (int i = 0; i < counter; i++){

            if (this.equals(b, books.get(i)) == true)
                return;
        }

        books.add(b);
        counter++;
    }
    
//    This method shows all the books that are stored in the library (vector). No parameters
    public void showAllBooks(){
    	
        for (int i = 0; i < counter; i++){
        	System.out.println(books.elementAt(i).getName() + books.elementAt(i).getAuthor());
        }

    }
    
//    It is used to increase the amount of the books in library. Parameter - book and amount to increase.
    public void increaseBooks(int serialNum, int amount){
    	
        for (int i = 0; i < counter; i++){
            if (serialNum == books.get(i).serialNumber){
            	books.get(i).amount++;
                return;

            }
        }
    }
    
//    This method checks if the book is available to take. 1 parameter - serial num.
    public int isAvailable(int serialNum){
    	
        for (int i = 0; i < counter; i++){
            if (serialNum == books.get(i).serialNumber){
                if(books.get(i).amount > 0){
                    System.out.println("Book is Available.");
                    return i;
                }
                System.out.println("Book is Unavailable");
                return -1;

            }
        }
        System.out.println("No Book of such serial number " + " is available in Library. But you can add this book");
        return -1;

    }
    
//    takeBook - used to Student object as parameter to borrow Book object as parameter, with discrete Date object and Semester object, both as parameters, of taking book. Void.
    public void takeBook(Student s, Date d, Book b, Semester sem) {
    	
    	Date date = new Date();
    	Map<Date, Date> mapDate = new HashMap<Date, Date>();
    	mapDate.put(date, sem.getEndDate());
    	s.getReaderDiary().getDiary().put(b, mapDate);
    	
    	b.amount--;
    }
//    returnBook - used to return Book object as parameter to library from Student object as parameter. Void.
    public void returnBook(Student s, Book b) {
    	b.amount++;
    	Date date = new Date();
    	Map<Date, Date> mapDate = new HashMap<Date, Date>();
    	mapDate.putAll(s.getReaderDiary().getDiary().get(b));
    	Set<Date> d = mapDate.keySet();
    	Date dd = d.iterator().next();
    	int num = date.compareTo(dd);
    	if (num == -1) {
    		System.out.println("You have a debt");
    		s.getFinanceCabinet().addToBalance(-1 * b.price);
    	}
    	else {
    		System.out.println("It`s ok");
    	}
    }


}
