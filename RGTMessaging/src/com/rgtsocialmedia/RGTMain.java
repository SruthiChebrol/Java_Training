package com.rgtsocialmedia;

import java.util.Scanner;

public class RGTMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		RGTMessaging rgtMessaging = new RGTMessaging();
		
		boolean exit = false;
		while(!exit) {
			System.out.println("Welcome to RGT Messaging");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			
			switch(choice) {
			
			case 1 : 
				rgtMessaging.registerUser();
				break;
			case 2 :
				rgtMessaging.login();
			    break;
			case 3 :
				exit = true;
				System.out.println("Existing.....");
				break;
			default :
				System.out.println("Invalid option");
				break;
		}

	}

	}
	
}
