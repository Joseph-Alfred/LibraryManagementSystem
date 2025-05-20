package org.lmsassignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LibraryManagementClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome to Library Management System");

		Map<String, Book> bookDataBase = new HashMap<>();

		Map<String, Patron> patronMap = new HashMap<>();
		List<Book> emptyBorrowedList = new ArrayList<>();

		patronMap.put("P001", new Patron("P001", "Alice Johnson", "9876543210", emptyBorrowedList, true));
		patronMap.put("P002", new Patron("P002", "Bob Smith", "8765432109", emptyBorrowedList, true));
		patronMap.put("P003", new Patron("P003", "Charlie Brown", "7654321098", emptyBorrowedList, true));
		patronMap.put("P004", new Patron("P004", "Diana Prince", "6543210987", emptyBorrowedList, true));
		patronMap.put("P005", new Patron("P005", "Ethan Hunt", "5432109876", emptyBorrowedList, true));
		patronMap.put("P006", new Patron("P006", "Fiona Gallagher", "4321098765", emptyBorrowedList, true));
		patronMap.put("P007", new Patron("P007", "George Michael", "3210987654", emptyBorrowedList, true));
		patronMap.put("P008", new Patron("P008", "Hannah Baker", "2109876543", emptyBorrowedList, true));
		patronMap.put("P009", new Patron("P009", "Ivan Drago", "1098765432", emptyBorrowedList, true));
		patronMap.put("P010", new Patron("P010", "Julia Roberts", "1987654321", emptyBorrowedList, true));

		LendingProcess lendingProcess = new LendingProcess(bookDataBase, patronMap);

		Inventory inventory = new Inventory(new HashMap<>(), 10, false);
		PatronManagement patronManagement = new PatronManagement();

		while (true) {
			System.out.println("\n===== Library Management System =====");
			System.out.println("1. Add Book");
			System.out.println("2. Remove Book");
			System.out.println("3. Show All Books");
			System.out.println("4. Add Patron");
			System.out.println("5. Remove Patron");
			System.out.println("6. Lend Book");
			System.out.println("7. Return Book");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				inventory.addBook();
				break;

			case 2:
				System.out.print("Enter ISBN to remove: ");
				String isbnToRemove = sc.next();
				inventory.removeBook(isbnToRemove);
				break;

			case 3:
				inventory.showAllBooks();
				break;

			case 4:
				patronManagement.addPatron();
				break;

			case 5:
				System.out.print("Enter Patron ID to remove: ");
				String removePatronId = sc.next();
				if (patronMap.containsKey(removePatronId)) {
					patronMap.remove(removePatronId);
					System.out.println("Patron removed successfully.");
				} else {
					System.out.println("Patron not found.");
				}
				break;

			case 6:
				System.out.print("Enter ISBN to checkout: ");
				String lendIsbn = sc.next();
				System.out.print("Enter Patron ID: ");
				String lendPatronId = sc.next();
				if (lendingProcess.checkoutBook(lendIsbn, lendPatronId)) {
					System.out.println("Book checked out successfully.");
				} else {
					System.out.println("Failed to checkout book.");
				}
				break;

			case 7:
				System.out.print("Enter ISBN to return: ");
				String returnIsbn = sc.next();
				System.out.print("Enter Patron ID: ");
				String returnPatronId = sc.next();
				if (lendingProcess.returnBook(returnIsbn, returnPatronId)) {
					System.out.println("Book returned successfully.");
				} else {
					System.out.println("Failed to return book.");
				}
				break;

			case 8:
				System.out.println("Exiting Library System. Goodbye!");
				sc.close();
				System.exit(0);

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

}
