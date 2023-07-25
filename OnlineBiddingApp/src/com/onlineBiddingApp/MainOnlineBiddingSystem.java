package com.onlineBiddingApp;

import java.util.List;
import java.util.Scanner;

public class MainOnlineBiddingSystem {
	private static User currentUser;
	private static UserManagementService userManagementService;
	private static ItemManagementService itemManagementService;

	public static void main(String[] args) {
		userManagementService = new UserManagementService();
		itemManagementService = new ItemManagementService();
		showInitialMenu();

	}

	private static void showInitialMenu() {
		System.out.println("Welcome to the OnlineBiddingApp");
		System.out.println("1. Login");
		System.out.println("2. Create Account");
		System.out.println("3. Exit");
		System.out.println("Enter your choice:");

		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();

		switch (input) {

		case 1:
			loginUser();
			break;

		case 2:
			createUserAccount();
			break;

		case 3:
			System.out.println("Thank you for using Online Bidding App");
			System.exit(0);
			break;

		default:
			break;

		}

	}

	private static void loginUser() {
		System.out.print("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();

		System.out.print("Enter your password: ");
		String password = scanner.nextLine();
		System.out.println();

		currentUser = userManagementService.authenticateUser(username, password);
		if (currentUser != null) {
			showMainMenu();
		} else {
			System.out.println("Invalid username or password. Please try again.");

		}
		showInitialMenu();

	}

	private static void createUserAccount() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String userName = scanner.next();
		System.out.println("Enter password: ");
		String password = scanner.next();
		userManagementService.createUser(userName, password);
		System.out.println("Account Created Successfully");
		showInitialMenu();

	}

	private static void showMainMenu() {
		Scanner scanner = new Scanner(System.in);

		int option;
		do {
			System.out.println();
			System.out.println("Welcome to the Online Bidding System!");
			System.out.println("1. Search Items:");
			System.out.println("2. View Bidding History:");
			System.out.println("3. Logout");
			System.out.println();
			System.out.print("Choose an option: ");
			option = scanner.nextInt();
			scanner.nextLine();

			switch (option) {

			case 1:
				System.out.print("Enter a search keyword: ");
				String keyword = scanner.nextLine();
				List<Item> searchResults = itemManagementService.searchItems(keyword);
				/**
				 * If items is not there for given the search keyword to display the no items
				 * found
				 */
				if (searchResults.isEmpty()) {
					System.out.println("No items found.");
				} else {
					System.out.println("Search results:");
					for (Item item : searchResults) {
						System.out.println(item.getName() + " - " + item.getDescription() + " - Current highest bid: "
								+ item.getCurrentHighestBid());
					}
				}
				System.out.println();
				System.out.print("Enter an item name to place a bid, or '0' to go back: ");
				String itemName = scanner.nextLine();
				if (!itemName.equals("0")) {
					Item selected = itemManagementService.getItemByName(itemName);
					if (selected != null) {
						System.out.print("Enter a bid amount: ");
						System.out.println();
						double bidAmount = scanner.nextDouble();
						Bid bid = new Bid(selected, currentUser, bidAmount);
						currentUser.addBid(bid);

						scanner.nextLine();
						System.out.println("1. Incremental Bidding");
						System.out.println("2. Automatic Bidding");
						System.out.print("Choose a bidding strategy: ");
						int strategyChoice = scanner.nextInt();
						scanner.nextLine();
						BiddingStrategy biddingStrategy;
						if (strategyChoice == 1) {
							biddingStrategy = new IncrementalBiddingStrategy();

						} else if (strategyChoice == 2) {
							biddingStrategy = new AutomaticBiddingStrategy();
						} else {
							System.out.println("Invalid strategy choice. Skipping bidding.");
							continue;
						}
						double placedBid = biddingStrategy.bid(selected, currentUser, bidAmount);
						System.out.println("bid amount: " + placedBid);
					} else {
						System.out.println("Item not found.");
					}
				}
				break;

			case 2:
				List<Bid> biddingHistory1 = currentUser.getBiddingHistory();
				System.out.println("Your bidding history:");
				if (biddingHistory1.isEmpty()) {
					System.out.println("No bidding history found.");
				} else {
					for (Bid bid : biddingHistory1) {
						System.out.println(bid.getItem().getName() + " - " + bid.getItem().getDescription()
								+ " - Bid amount: " + bid.getAmount() + " - Winning bid: " + bid.isWinningBid());
					}
				}

				break;

			case 3:
				System.out.println("Logout successfully");
				showInitialMenu();
				break;

			default:

				System.out.println("Invalid choice. Choose valid one");
				break;

			}

		} while (option != 3);

	}
}
