package com.crudoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
	private String title;
	private String author;
	private boolean isAvailable;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}

	public String getTitle() {
		return title;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}

public class LibraryManagementSystem {
	static List<Book> books = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void addBook() {
		System.out.print("Enter book title: ");
		String title = scanner.next();
		System.out.print("Enter book author: ");
		String author = scanner.next();

		books.add(new Book(title, author));
		System.out.println("Book added successfully.");
	}

	public static Book findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equalsIgnoreCase(title)) {
				return book;
			}
		}
		return null;
	}

	public static void borrowBook() {
		System.out.print("Enter book title to borrow: ");
		String title = scanner.next();
		Book bookToBorrow = findBookByTitle(title);

		if (bookToBorrow != null) {
			if (bookToBorrow.isAvailable()) {
				bookToBorrow.setAvailable(false);
				System.out.println("You have borrowed: " + title);
			} else {
				System.out.println("Sorry, this book is currently unavailable.");
			}
		} else {
			System.out.println("Book not found with this title.");
		}
	}

	public static void returnBook() {
		System.out.print("Enter book title to return: ");
		String title = scanner.nextLine();
		Book bookToReturn = findBookByTitle(title);

		if (bookToReturn != null) {
			if (!bookToReturn.isAvailable()) {
				bookToReturn.setAvailable(true);
				System.out.println("You have returned: " + title);
			} else {
				System.out.println("This book was not borrowed.");
			}
		} else {
			System.out.println("Book not found with this title.");
		}
	}

	public static void removeBook() {
		System.out.print("Enter book title to remove: ");
		String title = scanner.nextLine();
		Book bookToRemove = findBookByTitle(title);

		if (bookToRemove != null) {
			books.remove(bookToRemove);
			System.out.println("Book removed successfully.");
		} else {
			System.out.println("Book not found with this title.");
		}
	}

	public static void main(String[] args) {
		boolean exit = false;
		while (!exit) {
			System.out.println("\nLibrary Management System");
			System.out.println("1. Add Book");
			System.out.println("2. Borrow Book");
			System.out.println("3. Return Book");
			System.out.println("4. Remove Book");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				addBook();
				break;
			case 2:
				borrowBook();
				break;
			case 3:
				returnBook();
				break;
			case 4:
				removeBook();
				break;
			case 5:
				System.out.println("Exiting...");
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
