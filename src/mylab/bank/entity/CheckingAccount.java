package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawLimitExceededException;

public class CheckingAccount extends Account {
	
	private double withdrawLimit;

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawLimit = withdrawLimit;
	}
	public double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException{
		//잔액 부족
		if(amount > withdrawLimit) {
			String errMessage = String.format("예외 발생: 출금 한도를 초과했습니다. 한도: %.1f)",withdrawLimit);
			// Exception 강제로 발생시킴
			throw new WithdrawLimitExceededException(errMessage);
		}
	}
	
	public String toString() {
		return null;
	}
}
