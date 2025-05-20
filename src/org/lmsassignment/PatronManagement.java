package org.lmsassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class PatronManagement {
	
	Scanner sc=new Scanner(System.in);
	
	private Map<String, Patron> patronsMap;
	private int totalPatronMemberShips;
	
	
	public PatronManagement() {
		this.patronsMap = new HashMap<>();
	}
	public boolean addPatron() {
		
		
		System.out.println("Enter patronId");
		String providedPatronId = sc.next();
		if(patronsMap.containsKey(providedPatronId)) {
			System.out.println("Patron is already a member of Library");
			return false;
		}
		
		System.out.println("Enter name of the Patron");
		String providedPatronName = sc.nextLine();
		
		System.out.println("Enter the mobile number of patron");
		String providedPhoneNumber = sc.nextLine();
		
		
		Patron newPatron = new Patron();
		newPatron.setPatronId(providedPatronId);
		newPatron.setPatronName(providedPatronName);
		newPatron.setPhoneNumber(providedPhoneNumber);
		newPatron.setMember(true);
		newPatron.setBorrowedBooks(new ArrayList<>());
		
		if(newPatron==null) {
			System.out.println("Patron is null, Please enter valid Patron details");
			return false;
		}
		if(!patronsMap.containsKey(newPatron.getPatronId())) {
			patronsMap.put(newPatron.getPatronId(), newPatron);
			totalPatronMemberShips++;
			System.out.println("Patron added to Database successfully");
			
			return true;
		}
		System.out.println("Please already existed in Database");
		return false;
		
	}
	public boolean removePatron(String patronId) {
		if(patronId==null || patronId.isEmpty()) {
			System.out.println("PatronID is null, Please enter valid PatronID");
			return false;
		}
		if(patronsMap.containsKey(patronId)) {
			patronsMap.remove(patronId);
			totalPatronMemberShips--;
			System.out.println("Patron removed successfully from the Database");
			return true;
		}
		System.out.println("Please doesn't exists in the Database");
		return false;
	}
	
	public void updatePatronInformation(String patronId, Map<String, Object> updates) {
	    Patron patron = patronsMap.get(patronId);
	    if (patron != null) {
	        if (updates.containsKey("name")) {
	            patron.setPatronName((String) updates.get("name"));
	        }
	        if (updates.containsKey("phoneNumber")) {
	            patron.setPhoneNumber((String) updates.get("phoneNumber"));
	        }
	
	    }
	}
}
