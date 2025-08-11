package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;

public abstract class Account extends Bank{
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	//constructor
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	//getters
	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		//잔액 부족
		if(amount > this.balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %.1f, 현재 잔액: %.1f)", amount, balance);
			// Exception 강제로 발생시킴
			throw new InsufficientBalanceException(errMessage);
		}
		balance -= amount;
	}
	
	public abstract String toString();
	
}
