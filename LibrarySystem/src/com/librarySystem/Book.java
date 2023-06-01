package com.librarySystem;

import java.util.Scanner;

public class Book {
	public String bookName;
    public String authorName;
 
    Scanner input = new Scanner(System.in);
 
    public Book()
    {
    	System.out.println("Enter Book Name:");
        this.bookName = input.nextLine();
 
        System.out.println("Enter Author Name:");
        this.authorName = input.nextLine();

    }
}
