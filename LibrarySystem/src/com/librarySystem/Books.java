package com.librarySystem;

import java.util.Scanner;

public class Books {
	public String bookName;
	private static final int MAX_PATRONS=5;
	private static  String[] patrons=new String[MAX_PATRONS];
	public String authorName;
	public int patronCount=0;
	public int authorCount=0;
	public int[] author;
	public String auth;
	public static int MAX_BOOKS=10;
	Book[] Allbooks = new Book[MAX_BOOKS]; 
	int bookcount=0;
	Scanner sc = new Scanner(System.in);
	public int compareBookObjects(Book b1, Book b2)
	{
		if (b1.bookName.equalsIgnoreCase(b2.bookName)) 
		{
			System.out.println("This Book name is already exists");
			return 0;
		}
		return 1;
	}

	public void addBook(Book b)
	{

		for (int i = 0; i < bookcount; i++) 
		{
			if (this.compareBookObjects(b, this.Allbooks[i])== 0)
				return;
		}
		Allbooks[bookcount++] = b;
	}
	public boolean count()
	{
		if(bookcount==MAX_BOOKS) {
			return false;
		}
		return true;
	}
	
	public void addPatron()
	{
		System.out.println("Enter the PatronName:");
		auth = sc.nextLine();	
		if(patronCount<=MAX_PATRONS) 
		{
			if(patronCount==0) 
			{
				patrons[patronCount++]=auth;
				System.out.println("Patron added Successfully");
			}
			else {
				if(!patronexist(auth)) {
					patrons[patronCount++]=auth;
					System.out.println("Patron added Successfully");
					System.out.println(" ");
				}
				else {
					System.out.println("Patron already exist");
				}
			}

		}
	}

	public boolean patroncount()
	{
		if(patronCount==MAX_PATRONS) {
			return false;
		}
		return true;
	}
	
	public boolean patronexist(String user) {

		for (int i=0;i<patronCount;i++) 
		{
			if(patrons[i].equalsIgnoreCase(user)) {
				return true;
			}
		}
		return false;
	}
	public void barrowBook() {
		System.out.println("Enter patron name :");
		String patron =sc.next();
		System.out.println("Enter book Name:");
		String bookName=sc.next();
		
	}
	
	public void returnBook() {
		System.out.println("Enter book title:");
		String bookName =sc.next();
		
	}
	
}
