import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        // Scanner bankScanner = new Scanner(System.in);
        // System.out.println("please enter a number");
        // // int a = bankScanner.nextInt();
        // char c = bankScanner.next().charAt(0);
        // System.out.println("value = " + c);
        BankAccount acc = new BankAccount("George", "deez nuts");
        acc.showMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;

    }
    
    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(balance > amount){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited " + previousTransaction);
        } else if(previousTransaction < 0){
            System.out.println("Withdrew " + Math.abs(previousTransaction));
        } else{
            System.out.println("no transactions");
        }
    }

    void showMenu(){
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A: balance check");
        System.out.println("B: deposit");
        System.out.println("C: withdraw");
        System.out.println("D: view prev transaction");
        System.out.println("E: exit");

        do{
            System.out.println("\n");
            System.out.println("please choose an option");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'a':
                    System.out.println('\n');
                    System.out.println("Balance = " + balance);
                    System.out.println('\n');
                    break;
                case 'b':
                    System.out.println('\n');
                    System.out.println("Please enter deposit amount");
                    System.out.println('\n');
                    int amount = scanner.nextInt();
                    System.out.println('\n');
                    deposit(amount);
                    break;
                case 'c':
                    System.out.println('\n');
                    System.out.println("Please enter withdraw amount");
                    System.out.println('\n');
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    break;
                case 'd':
                    System.out.println('\n');
                    System.out.println("Previous transaction = " + previousTransaction);
                    System.out.println('\n');
                    break;
                default:
                    System.out.println("Invalid option, please try again");
                    break;
            }

        } while (option != 'E');
        System.out.println("Thank you for using our services");
    }
}