package entities;

public class Account {
	
	private int number;
	private String holder;
	private double balance;
	public final double taxWithdraw = 5.00;
	
	public Account() {
		
	}
	
	public Account(int numberAccount, String name) {
		this.number = numberAccount;
		this.holder = name;
	}

	public Account(int numberAccount, String name, double initialDeposit) {
		this.number = numberAccount;
		this.holder = name;
		deposit(initialDeposit);
	}

	public int getNumberAccount() {
		return number;
	}

	public String getName() {
		return holder;
	}

	public void setName(String name) {
		this.holder = name;
	}

	public double getBalance() {
		return balance;
	}

	public String toString() {
		return "\nAccount data:\nAccount " + this.number + ", Holder: " + this.holder + ", Balance: $"
				+ String.format("%.2f", this.balance);
	};

	public void deposit(double value) {
		this.balance += value;
	}

	public void withdraw(double value) {
		this.balance -= (value + taxWithdraw);
	}

}
