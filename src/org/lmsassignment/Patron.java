package org.lmsassignment;

import java.util.ArrayList;
import java.util.List;

public class Patron {
	private String patronId;
	private String patronName;
	private String phoneNumber;
	private List<Book> borrowedBooks=null;
	private boolean isMember=false;
	
	public Patron() {
	}

	public Patron(String patronId, String patronName, String phoneNumber, List<Book> borrowedBooks, boolean isMember) {
		this.patronId = patronId;
		this.patronName = patronName;
		this.phoneNumber = phoneNumber;
		this.borrowedBooks = borrowedBooks;
		this.isMember = isMember;
	}

	public String getPatronId() {
		return patronId;
	}

	public void setPatronId(String patronId) {
		this.patronId = patronId;
	}
	
	public String getPatronName() {
		return patronName;
	}

	public void setPatronName(String patronName) {
		this.patronName = patronName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}
	
}	
