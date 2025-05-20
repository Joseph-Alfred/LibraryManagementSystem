package org.lmsassignment;

public class Book {
	
	private String title;
	private String author;
	private String ISBN;
	private int publicationYear;
	private boolean isBookAvailableInInventory;
	

	public Book() {
	}
	public Book(String title, String author, String iSBN, int publicationYear, boolean isBookAvailableInInventory) {
		this.title = title;
		this.author = author;
		ISBN = iSBN;
		this.publicationYear = publicationYear;
		this.isBookAvailableInInventory = isBookAvailableInInventory;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	
	
	public boolean isBookAvailableInInventory() {
		return isBookAvailableInInventory;
	}
	public void setBookAvailableInInventory(boolean isBookAvailableInInventory) {
		this.isBookAvailableInInventory = isBookAvailableInInventory;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", ISBN=" + ISBN + ", publicationYear=" + publicationYear
				+ ", isBookAvailableInInventory=" + isBookAvailableInInventory + "]";
	}
	
	
	
	
}
