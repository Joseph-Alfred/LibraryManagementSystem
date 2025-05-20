package org.lmsassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
	
	Scanner sc=new Scanner(System.in);
	
	Map<String, Book> bookMap;
	public int totalBooks;
	public boolean isBookAvailableInInventory;
	
	
	public Inventory(Map<String, Book> bookMap, int totalBooks, boolean isBookAvailableInInventory) {
		super();
		this.bookMap = bookMap;
		this.totalBooks = totalBooks;
		this.isBookAvailableInInventory = isBookAvailableInInventory;
	}
	public boolean addBook() {
		
		System.out.println("Enter ISBN");
		String isbn = sc.next();
		if(bookMap.containsKey(isbn)) {
			System.out.println("Book already exists in the Inventory");
			return false;
		}
		System.out.println("Enter name of the Book");
		String bookName = sc.nextLine();
		
		System.out.println("Enter the name of the Author");
		String authorName = sc.nextLine();
		
		System.out.println("Year of publication");
		int yop = sc.nextInt();
		
		Book book = new Book();
		book.setTitle(bookName);
		book.setAuthor(authorName);
		book.setISBN(isbn);
		book.setPublicationYear(yop);
		book.setBookAvailableInInventory(true);
		
		if(!bookMap.containsKey(book.getISBN())) {
			bookMap.put(book.getISBN(), book);
			System.out.println("New book added into Inventory");
			isBookAvailableInInventory=true;
			totalBooks++;
			Inventory inventory = new Inventory(bookMap, totalBooks, isBookAvailableInInventory);
			return true;
		}
		if (book == null) {
	        System.out.println("Cannot add a null book to the inventory.");
	        return false;
	    }
		
		System.out.println("Book already exists in the Inventory");
		return false;
	}
	public boolean removeBook(String isbn) {
		
		if(isbn == null || isbn.isEmpty()) {
			System.out.println("Entered invalid ISBN");
			return false;
		}
		
		if(bookMap.containsKey(isbn)) {
			bookMap.remove(isbn);
			isBookAvailableInInventory=false;
			totalBooks--;
			Inventory inventory = new Inventory(bookMap, totalBooks, isBookAvailableInInventory);
			System.out.println("Book removed successfully from the Inventory");
			return true;
		}
		
		System.out.println("Book doesn't exists in the Inventory");
		return false;
	}
	public boolean updateBook(String isbn) {
		
		Book book = bookMap.get(isbn);
		System.out.println("Enter new title:");
		book.setTitle(sc.next());
		System.out.println("Enter new author:");
		book.setAuthor(sc.next());
		System.out.println("Enter new publication year:");
		book.setPublicationYear(sc.nextInt());
		
		
		if(isbn == null || isbn.isEmpty()) {
			System.out.println("Entered invalid ISBN");
			return false;
		}
		
		if(bookMap.containsKey(isbn)) {
			
			System.out.println("Book updated successfully in the Inventory");
			return true;
		}
		
		System.out.println("Book doesn't exists in the Inventory");
		return false;
	}

	private List<Book> searchBookByTitle(String title) {
		if(title==null || title.isEmpty()) {
			System.out.println("Invalid title");
			return null;
		}
		List<Book> resultList = new ArrayList<>();
		for(Book book: bookMap.values()) {
			
			if(book.getTitle().equalsIgnoreCase(title)) {
				resultList.add(book);
			}
		}
		return resultList;
	}
	
	private List<Book> searchBookByAuthor(String author) {
		if(author==null || author.isEmpty()) {
			System.out.println("Invalid title");
			return null;
		}
		List<Book> resultList = new ArrayList<>();
		for(Book book: bookMap.values()) {
			
			if(book.getAuthor().equalsIgnoreCase(author)) {
				resultList.add(book);
			}
		}
		return resultList;
	}
	
	private Book searchBookByISBN(String isbn) {
		return bookMap.get(isbn);
	}
	
	public void showAllBooks() {
        if (bookMap.isEmpty()) {
            System.out.println("No books available in inventory.");
            return;
        }

        System.out.println("Books in Inventory:");
        for (Book book : bookMap.values()) {
            System.out.println(book);
        }
    }
	
}
