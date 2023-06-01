package com.librarySystem;

import java.util.Scanner;

public class SimpleLibrarySystem {
	
	private static final int MAX_BOOKS = 2;
	
	private static final int MAX_PATRONS = 2;
	
	private static String[] bookTitles = new String[MAX_BOOKS];

	public static void main(String[] args) {
		Books books = new Books();
		 Scanner scanner = new Scanner(System.in);
		 int choice;
		 do {
	            System.out.println("Library Management System");
	            System.out.println("1. Add Book");
	            System.out.println("2. Add Patron");
	            System.out.println("3. Borrow Book");
	            System.out.println("4. Return Book");
	            System.out.println("5. Exit");
	            System.out.print("Choose an option: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    Book b = new Book();
	                    books.addBook(b);
	                    break;
	                case 2:
	                    books.addPatron();
	                    break;
	                case 3:
	                   books.barrowBook();
	                    System.out.println("Book Borrowed successfully");
	                    break;
	                case 4:
	                	books.returnBook();
	                    System.out.println("Returned book successfully");
	                    break;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }

	            System.out.println();

	        } while (choice != 4);

	        scanner.close();
	    }
		

	}


