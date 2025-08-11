package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import java.util.ArrayList;
import java.util.List;

public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();
        List<Exception> exceptions = new ArrayList<>(); // 예외를 저장할 리스트 생성

        System.out.println("=== 계좌생성 ===");
        String nextAccNum0 = "AC1000";
        String nextAccNum1 = bank.createSavingAccount(nextAccNum0, "홍길동", 10000, 0.03);
        String nextAccNum2 = bank.createCheckAccount(nextAccNum1, "김철수", 20000, 5000);
        String nextAccnum3 = bank.createSavingAccount(nextAccNum2, "이영희", 30000, 0.02);

        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        
        // 1. 입금
        try {
            bank.deposit(nextAccNum0, 5000);
        } catch (AccountNotFoundException e) {
            exceptions.add(e);
        }
        
        // 2. 출금 (정상 케이스)
        try {
            bank.withdraw(nextAccNum1, 3000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            exceptions.add(e);
        }
        
        // 3. 출금 (잔액 부족 예외 케이스)
        try {
            bank.withdraw(nextAccNum1, 10000); // InsufficientBalanceException 발생
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            exceptions.add(e);
        }
        
        // 4. 입금 (계좌 없음 예외 케이스)
        try {
            bank.deposit("AC9999", 10000); // AccountNotFoundException 발생
        } catch (AccountNotFoundException e) {
            exceptions.add(e);
        }

        System.out.println("\n=== 이자 적용 테스트 ===");
        try {
            SavingAccount acct = (SavingAccount) bank.findAccount(nextAccNum0);
            if (acct != null) {
                acct.applyInterest();
            } else {
                throw new AccountNotFoundException("계좌를 찾을 수 없습니다: " + nextAccNum0);
            }
        } catch (AccountNotFoundException e) {
            exceptions.add(e);
        }
        
        System.out.println("\n=== 계좌 이체 테스트 ===");
        // 5. 계좌 이체 (정상 케이스)
        try {
            bank.transfer(nextAccNum1, nextAccNum2, 5000);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            exceptions.add(e);
        }

        // 6. 계좌 이체 (잔액 부족 예외 케이스)
        try {
            bank.transfer(nextAccNum1, nextAccNum2, 10000); // InsufficientBalanceException 발생
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            exceptions.add(e);
        }


        bank.printAllAccounts();

        if (exceptions.isEmpty()) {
            System.out.println("발생한 예외가 없습니다.");
        } else {
            for (Exception e : exceptions) {
                System.out.println(e.getMessage());
            }
        }
 
    }
}