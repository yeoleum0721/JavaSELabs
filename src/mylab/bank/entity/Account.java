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
		//�ܾ� ����
		if(amount > this.balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %.1f, ���� �ܾ�: %.1f)", amount, balance);
			// Exception ������ �߻���Ŵ
			throw new InsufficientBalanceException(errMessage);
		}
		balance -= amount;
	}
	
	public abstract String toString();
	
}
