package mylab.bank.entity;

public class SavingAccount extends Account{
	private double interestRate;

	public SavingAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterest() {
		double interestAmount = getBalance() * this.interestRate;
		super.deposit(interestAmount);
		String message1 = String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", interestAmount,super.getBalance());
		System.out.println(message1);
		String message2 = String.format("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원", interestAmount,super.getBalance());
		System.out.println(message2);
	}
	public String toString() {
		return null;
	}
}
