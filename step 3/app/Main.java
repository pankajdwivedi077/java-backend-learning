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
                    withdraw(sc, bankService);
                    break;
                case "4":
                    transfer(sc, bankService);
                    break;
                case "5":
                    statement(sc, bankService);
                    break;
                case "6": 
                    listAccounts(sc, bankService);
                    break;
                case "7":
                    searchAccounts(sc, bankService);
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
             bankService.deposit(accNumber, initial, "Initial Deposit");

    }

    private static void deposit(Scanner sc, BankService bankService) {
        System.out.println("Account Number: ");
        String accNumber = sc.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.deposit(accNumber, amount, "Deposit");
        System.out.println("Deposited");

    }

    private static void withdraw(Scanner sc, BankService bankService) {
        System.out.println("Account Number: ");
        String accNumber = sc.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.withdraw(accNumber, amount, "withdrawal");
        System.out.println("withdraw");
    }

    private static void transfer(Scanner sc, BankService bankService) {
        System.out.println("From Account: ");
        String from = sc.nextLine().trim();
        System.out.println("To Account: ");
        String to = sc.nextLine().trim();
        System.out.println("Amount:");
        Double amount = Double.valueOf(sc.nextLine().trim());
        bankService.transfer(from, to, amount, "Transfer");
    }

    private static void statement(Scanner sc, BankService bankService) {
        System.out.println("Account Number: ");
        String accNumber = sc.nextLine().trim();
        bankService.getStatement(accNumber).forEach((t) -> {
            System.out.println(t.getTimestamp() + " | " + t.getType() + " | " + t.getAmount() + " | " + t.getNote());
        });

    }

    private static void listAccounts(Scanner sc, BankService bankService) {
      bankService.listAccount().forEach(a -> {
          System.out.println(a.getAccountNumber() + " | " + a.getAccountType() + " | " + a.getBalance());
      });
    }

    private static void searchAccounts(Scanner sc, BankService bankService) {
        System.out.println("Customer name contains: ");
        String q = sc.nextLine().trim();
        bankService.searchAccountsByCustomerName(q);
    }


} // banking project
