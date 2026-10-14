
package BankAccountSimulation;

import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSimulation {

	static class BankAccount {

		int account_number;
		String holdername;
		double balance;

		ArrayList<String> history = new ArrayList<>();

		BankAccount(int account_number, String holdername, double balance) {
			this.account_number = account_number;
			this.holdername = holdername;
			this.balance = balance;

			history.add("Account opened with balance: Rs. " + balance);
		}

		void deposit(double amount) {
			if (amount > 0) {
				balance += amount;
				history.add("Deposited: Rs. " + amount);
				System.out.println("Deposit successful!");
			} else {
				System.out.println("Invalid deposit amount!");
			}
		}

		void withdraw(double amount) {
			if (amount <= 0) {
				System.out.println("Invalid withdrawal amount!");
			} else if (amount > balance) {
				System.out.println("Insufficient balance!");
			} else {
				balance -= amount;
				history.add("Withdrawn: Rs. " + amount);
				System.out.println("Amount withdrawn successfully!");
			}
		}

		void checkbalance() {
			System.out.println("Your balance: Rs. " + balance);
		}

		void showhistory() {
			System.out.println("Transaction History:");

			for (String transaction : history) {
				System.out.println(transaction);
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankAccount account = new BankAccount(101, "Rahul", 1000);

		int choice;

		do {
			System.out.println("\n--- Bank Account Simulation ---");
			System.out.println("1. Account Details");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Check Balance");
			System.out.println("5. Transaction History");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.println("Account Number: " + account.account_number);
				System.out.println("Holder Name: " + account.holdername);
				account.checkbalance();
				break;

			case 2:
				System.out.print("Enter deposit amount: ");
				account.deposit(sc.nextDouble());
				break;

			case 3:
				System.out.print("Enter withdrawal amount: ");
				account.withdraw(sc.nextDouble());
				break;

			case 4:
				account.checkbalance();
				break;

			case 5:
				account.showhistory();
				break;

			case 6:
				System.out.println("Thank you for using our bank!");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 6);

		sc.close();
	}
}
