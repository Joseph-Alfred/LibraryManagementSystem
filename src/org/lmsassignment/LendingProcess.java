package org.lmsassignment;

import java.util.Map;

public class LendingProcess {
	
	public int availableBooks;
	public int borrowedBooks;
    private Map<String, Book> books;
    private Map<String, Patron> patrons;
    
    public LendingProcess(Map<String, Book> books, Map<String, Patron> patrons) {
    	this.availableBooks=10;
    	this.borrowedBooks=0;
        this.books = books;
        this.patrons = patrons;
    }

    public boolean checkoutBook(String isbn, String patronId) {
        Book book = books.get(isbn);
        Patron patron = patrons.get(patronId);
        
        if (book != null && patron != null && !patron.getBorrowedBooks().contains(book) && book.isBookAvailableInInventory()==true) {
            patron.getBorrowedBooks().add(book);
            book.setBookAvailableInInventory(false);
            borrowedBooks++;
            availableBooks--;
             
            return true;
        }
        System.out.println("Enter valid details for book checkout");
        return false;
    }

    public boolean returnBook(String isbn, String patronId) {
        
    	Book book = books.get(isbn);
    	Patron patron = patrons.get(patronId);
    	if (book != null && patron != null && patron.getBorrowedBooks().contains(book)) {
    	    patron.getBorrowedBooks().remove(book);
    	    book.setBookAvailableInInventory(true);
    	    borrowedBooks--;
    	    availableBooks++;
    	    System.out.println("Book returned");
    	    return true;
    	}
    	System.out.println("Enter valid details to return the book");
    	return false;
    }
}