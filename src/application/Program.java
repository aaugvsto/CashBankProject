package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		Account acc = new Account();

		System.out.print("Enter account number: ");
		int accNumber = sc.nextInt();

		System.out.print("Enter account holder: ");
		String name = sc.next();

		System.out.print("Is there na initial deposit? (y/n) ");
		char answer = sc.next().toLowerCase().charAt(0);
		while (answer != 'n' && answer != 'y') {
			System.out.print("Invalid answer: Use 'y' or 'n': ");
			answer = sc.next().toLowerCase().charAt(0);
		}
		if (answer == 'y') {
			double firstDeposit = 0;
			while (firstDeposit <= 0) {
				System.out.print("Enter initial deposit value: ");
				firstDeposit = sc.nextDouble();
				acc = new Account(accNumber, name, firstDeposit);
				if (firstDeposit <= 0) {
					System.out.println("Invalid Value!");
				}
			}
		} else {
			acc = new Account(accNumber, name);
		}

		System.out.println(acc);

		double deposit = 0;
		while (deposit <= 0) {
			System.out.print("Enter a deposit value: ");
			deposit = sc.nextDouble();
			if (deposit <= 0) {
				System.out.println("Deposit failed: Invalid value!");
			} else {
				acc.deposit(deposit);
				System.out.println("Success!");
				System.out.println(acc);
			}
		}
		double withdraw;
		System.out.print("Enter a withdraw value: ");
		withdraw = sc.nextDouble();
		while (withdraw <= 0 || withdraw < 50) {
			if (withdraw <= 0) {
				System.out.print("\nWithdraw failed: Invalid amount!\nEnter a new value: ");
				withdraw = sc.nextDouble();
			} else if (withdraw < 50) {
				System.out.print("\nMinimum withdrawal amount $50\nEnter a new value: ");
				withdraw = sc.nextDouble();
			}
		}

		while (withdraw >= acc.getBalance()) {
			System.out.print("Your bank balance will be negative($"
					+ String.format("%.2f", acc.getBalance() - (withdraw + acc.taxWithdraw))
					+ ")if you make this withdrawal. Do you want to continue? (y/n) ");
			char response = sc.next().toLowerCase().charAt(0);
			while (response != 'y' && response != 'n') {
				System.out.print("Invalid answer: Use 'y' or 'n': ");
				response = sc.next().toLowerCase().charAt(0);
			}
			if (response == 'y') {
				break;
			} else {
				System.out.print("Enter a new withdraw value: ");
				withdraw = sc.nextDouble();
			}
		}

		System.out.println("Withdraw successful!");
		acc.withdraw(withdraw);
		System.out.println(acc);

		System.out.println("\nOperation completed successfully!\nThank you for being part of the Cash Bank :)");

		sc.close();
	}

}
