package app;

import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
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
                    openAccount(sc);
                    break;
                case "2":
                    deposit(sc);
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
                    listAccounts(sc);
                    break;
                case "7":
                    searchAccounts(sc);
                    break;
               
                    
            }
        }

    }

    private static void openAccount(Scanner sc) {

    }

    private static void deposit(Scanner sc) {

    }

    private static void withdraw(Scanner sc) {

    }

    private static void transfer(Scanner sc) {

    }

    private static void statement(Scanner sc) {

    }

    private static void listAccounts(Scanner sc) {

    }

    private static void searchAccounts(Scanner sc) {

    }


} // banking project
