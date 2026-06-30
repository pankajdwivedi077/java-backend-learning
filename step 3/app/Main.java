package app;

import service.BankService;
import service.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        System.out.println("Welcome to Bank");
        boolean running = true;
        while (running){
            System.out.println("""
               1) Open Account
               2) Deposit
               3) Withdraw
               4) Transfer
               5) Account Statement
               6) List Accounts
               7) Search Accounts by Customer Name
               0) Exist
               """);
            System.out.println("Choose");
            String choice = sc.nextLine().trim();
            System.out.println("Choice " + choice);

            switch (choice){
                case "0":
                    running = false;
                    break;
                case "1":
                    openAccount(sc, bankService);
                    break;
                case "2":
                    deposit(sc, bankService);
                    break;
                case "3":
                    withdraw(sc);
                    break;
                case "4":
                    transfer(sc);
                    break;
                case "5":
                    statement(sc);
                    break;
                case "6": 
                    listAccounts(sc, bankService);
                    break;
                case "7":
                    searchAccounts(sc);
                    break;
               
                    
            }
        }

    }

    private static void openAccount(Scanner sc, BankService bankService) {
         System.out.println("Customer name: ");
         String name = sc.nextLine().trim();
         System.out.println("Customer email: ");
         String email = sc.nextLine().trim();
         System.out.println("Account Type (SAVING/CURRENT) : ");
         String type = sc.nextLine().trim();
         System.out.println("Intial deposit (optional, blank for 0) : ");
         String amountStr = sc.nextLine().trim();
         Double initial = Double.valueOf(amountStr);
         String accNumber = bankService.openAccount(name,email, type);
         System.out.println("Account opened: " + accNumber);
         if(initial > 0)
             deposit(sc, bankService);

    }

    private static void deposit(Scanner sc, BankService bankService) {
        System.out.println("Account Number: ");
        String accNumber = sc.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.deposit(accNumber, amount, "Deposit");
        System.out.println("Deposited: ");

    }

    private static void withdraw(Scanner sc) {

    }

    private static void transfer(Scanner sc) {

    }

    private static void statement(Scanner sc) {

    }

    private static void listAccounts(Scanner sc, BankService bankService) {
      bankService.listAccount().forEach(a -> {
          System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
      });
    }

    private static void searchAccounts(Scanner sc) {

    }


} // banking project
