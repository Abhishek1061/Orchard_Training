package Java.Day2Assignment;

import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. \n" + "New balance is: " + balance);

    }

    public void widthdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " deposited. \n" + "New balance is: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the your account number: ");
        String accNumber = sc.nextLine();

        System.out.print("Enter the your balance: ");
        double accBalance = sc.nextDouble();
        BankAccount bk = new BankAccount(accNumber, accBalance);
        System.out.print("Enter the amount that you want to deposit: ");
        double depositAmount = sc.nextDouble();
        bk.deposit(depositAmount);
        System.out.print("Enter the amount you want to with withdraw: ");
        double withdrawAmount = sc.nextDouble();
        bk.widthdraw(withdrawAmount);

        double balanceFinal = bk.getBalance();
        String accountNum = bk.getAccountNumber();
        System.out.println("Account number is: " + accountNum);
        System.out.println("Current balance is: " + balanceFinal);
    }
}
