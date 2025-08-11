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
        List<Exception> exceptions = new ArrayList<>(); // ���ܸ� ������ ����Ʈ ����

        System.out.println("=== ���»��� ===");
        String nextAccNum0 = "AC1000";
        String nextAccNum1 = bank.createSavingAccount(nextAccNum0, "ȫ�浿", 10000, 0.03);
        String nextAccNum2 = bank.createCheckAccount(nextAccNum1, "��ö��", 20000, 5000);
        String nextAccnum3 = bank.createSavingAccount(nextAccNum2, "�̿���", 30000, 0.02);

        bank.printAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        
        // 1. �Ա�
        try {
            bank.deposit(nextAccNum0, 5000);
        } catch (AccountNotFoundException e) {
            exceptions.add(e);
        }
        
        // 2. ��� (���� ���̽�)
        try {
            bank.withdraw(nextAccNum1, 3000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            exceptions.add(e);
        }
        
        // 3. ��� (�ܾ� ���� ���� ���̽�)
        try {
            bank.withdraw(nextAccNum1, 10000); // InsufficientBalanceException �߻�
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            exceptions.add(e);
        }
        
        // 4. �Ա� (���� ���� ���� ���̽�)
        try {
            bank.deposit("AC9999", 10000); // AccountNotFoundException �߻�
        } catch (AccountNotFoundException e) {
            exceptions.add(e);
        }

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        try {
            SavingAccount acct = (SavingAccount) bank.findAccount(nextAccNum0);
            if (acct != null) {
                acct.applyInterest();
            } else {
                throw new AccountNotFoundException("���¸� ã�� �� �����ϴ�: " + nextAccNum0);
            }
        } catch (AccountNotFoundException e) {
            exceptions.add(e);
        }
        
        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        // 5. ���� ��ü (���� ���̽�)
        try {
            bank.transfer(nextAccNum1, nextAccNum2, 5000);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            exceptions.add(e);
        }

        // 6. ���� ��ü (�ܾ� ���� ���� ���̽�)
        try {
            bank.transfer(nextAccNum1, nextAccNum2, 10000); // InsufficientBalanceException �߻�
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            exceptions.add(e);
        }


        bank.printAllAccounts();

        if (exceptions.isEmpty()) {
            System.out.println("�߻��� ���ܰ� �����ϴ�.");
        } else {
            for (Exception e : exceptions) {
                System.out.println(e.getMessage());
            }
        }
 
    }
}