package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.WithdrawException;

public class App {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter account data");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Holder: ");
        sc.nextLine();
        String holder = sc.nextLine();
        System.out.print("Initial balance: ");
        double initialBalance = sc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = sc.nextDouble();

        Account account = new Account(number, holder, initialBalance, withdrawLimit);

        try{
            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();

            account.withdraw(amount);

            System.out.println(account);
        }
        catch(WithdrawException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }

        sc.close();
    }
}
