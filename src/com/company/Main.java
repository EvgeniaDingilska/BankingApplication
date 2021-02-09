package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BankAcaunt obj = new BankAcaunt("Eva","HELL666");
        obj.shawMenu();


    }
}

class BankAcaunt {

    double balance;
    double getPrevTransaction;
    String custName;
    String custId;

    BankAcaunt(String cname, String cId) {
        custName = cname;
        custId = cId;
    }

    void deposit(double amount) {
        if (amount != 0) {
            balance += amount;
            getPrevTransaction = +amount;
        }
    }

    void withdraw(double amount) {
        if (amount != 0) {
            balance = balance - amount;
            getPrevTransaction = -amount;
        }
    }

    void previosTransaction() {
        if (getPrevTransaction > 0) {
            System.out.println("The deposit is:" + getPrevTransaction);

        } else if (getPrevTransaction < 0) {

            System.out.println("The withdraw is:" + Math.abs(getPrevTransaction));


        } else
            System.out.println("There are no previos transaction!!");
    }

    void shawMenu(){
        char option = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome customer: "+custName);
        System.out.println("ID: "+custId);
        System.out.println("\n-------- Welcome to Calculator --------");
        System.out.printf("%18s%n %7s%n %5s%n %20s%n %8s%n", "A. Check Balance;", "B. Deposit;", "C. Withdraw;", "D. Previous Transaction;", "E. Exit;");


        do {
            System.out.println("========================================");
            System.out.printf("%s","Enter an option:");
            System.out.println("\n========================================");

            option = scanner.next().toUpperCase().charAt(0);

            System.out.println("\n");

            switch (option){
                case 'A':
                    System.out.println("----------------------------------------");
                    System.out.println("The balans is: "+balance);
                    System.out.println("----------------------------------------");
                    System.out.println("\n");break;

                case 'B':
                    System.out.println("----------------------------------------");
                    System.out.println("Enter an amount:");
                    System.out.println("----------------------------------------");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    deposit(amount);
                    System.out.println("\n");break;
                case 'C':
                    System.out.println("----------------------------------------");
                    System.out.println("Enter an amount:");
                    System.out.println("----------------------------------------");
                    double amount2 = scanner.nextDouble();
                    scanner.nextLine();
                    withdraw(amount2);
                    System.out.println("\n");break;
                case 'D':
                    System.out.println("----------------------------------------");
                    previosTransaction();
                    System.out.println("----------------------------------------");
                    System.out.println("\n");break;
                case 'E':
                    System.out.println("****************************************");break;
                default:
                    System.out.println("Goodbye!");
            }



        }while (option!='E');
        System.out.println("Thank you for using our services!");

    }

}