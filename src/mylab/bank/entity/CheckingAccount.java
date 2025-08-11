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
		//�ܾ� ����
		if(amount > withdrawLimit) {
			String errMessage = String.format("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f)",withdrawLimit);
			// Exception ������ �߻���Ŵ
			throw new WithdrawLimitExceededException(errMessage);
		}
	}
	
	public String toString() {
		return null;
	}
}
