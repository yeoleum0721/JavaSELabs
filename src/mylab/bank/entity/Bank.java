package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;


public class Bank {
	private List<Account> accounts;
	private int nextAccountNumber=1000;

	public Bank() {
		this.accounts = new ArrayList<>();
	}

	public String createSavingAccount(String accountNumber, String ownerName, double balance, double interRate) {
		Account saveacct = new SavingAccount(accountNumber, ownerName,balance, interRate);
		this.accounts.add(saveacct);
		
		String message = String.format("저축 계좌가 생성되었습니다 : 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%",
				accountNumber,ownerName,balance,interRate*100);
		System.out.println(message);
		
		this.nextAccountNumber++;
		String nextAcctNum = String.format("AC%d", this.nextAccountNumber);
		return nextAcctNum;
	}
	
	public String createCheckAccount(String accountNumber, String ownerName, double balance, double withdrawLimit) {
		Account checkAcct = new CheckingAccount(accountNumber,ownerName,balance,withdrawLimit);
		this.accounts.add(checkAcct);
		
		String message = String.format("체킹계좌가 생성되었습니다 : 계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원",
				accountNumber,ownerName,balance,withdrawLimit);
		System.out.println(message);
		
		this.nextAccountNumber++;
		String nextAcctNum = String.format("AC%d", this.nextAccountNumber);
		return nextAcctNum;
	}

	public Account findAccount(String accountNumber) throws AccountNotFoundException{
		for (Account acct:accounts) {
			if(acct.getAccountNumber().equals(accountNumber)) {
				return acct;
				}
		}
		String errMessage = String.format("예외 발생 : 계좌번호 %s에 해당하는 계좌를 찾을 수 없습니다", accountNumber);
		throw new AccountNotFoundException(errMessage);
	}
	
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		Account acct = findAccount(accountNumber);
		acct.deposit(amount);
		String message = String.format("%.1f원이 입금되었습니다. 현재 잔액: %.1f원", amount,acct.getBalance());
		System.out.println(message);
	}

	
	public void withdraw(String accountNumber, double amount) 
			throws AccountNotFoundException, InsufficientBalanceException {
		Account acct = findAccount(accountNumber);
		acct.withdraw(amount);
		String message = String.format("%.1f원이 출금되었습니다. 현재 잔액: %.1f원", amount,acct.getBalance());
		System.out.println(message);
	}

	public void transfer(String accountNumber1, String accountNumber2, double amount) 
			throws AccountNotFoundException, InsufficientBalanceException{
		withdraw(accountNumber1,amount);
		deposit(accountNumber2,amount);
		
		String message = String.format("%.1f원이 %s에서 %s로 송금되었습니다.", amount, accountNumber2, accountNumber1);
		System.out.println(message);
	}
	
	public void printAllAccounts() {
		System.out.println("=== 모든 계좌 목록 ===");
		for (Account acct : accounts) {
			if (acct instanceof CheckingAccount) {
				CheckingAccount checkAcct=(CheckingAccount) acct;
				String message1 = String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 출금 한도: %.1f원",
						checkAcct.getAccountNumber(),checkAcct.getOwnerName(),checkAcct.getBalance(),checkAcct.getWithdrawLimit());
				System.out.println(message1);
			}
			else {
				SavingAccount saveAcct = (SavingAccount)acct;
				String message2 = String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원, 이자율: %.1f%%",
						saveAcct.getAccountNumber(),saveAcct.getOwnerName(),saveAcct.getBalance(),saveAcct.getInterestRate()*100);
				System.out.println(message2);
			}
		}
		System.out.println("=====================");
	}
}


