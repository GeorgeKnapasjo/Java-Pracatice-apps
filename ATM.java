import java.util.Scanner;

public class ATM {

    public static void calculator(int amount){
        int amount50s = 0;
        int amount20s = 0;
        int amount10s = 0;
        int amount5s = 0;
        int amount2s = 0;
        int amount1s = 0;
        if(amount >= 50){
            amount50s = (int)Math.abs(amount/50);
            amount = Math.abs(amount - (amount50s * 50));
            System.out.println("50s = " + amount50s);
        } 
        if(amount >= 20){
            amount20s = (int)Math.abs(amount/20);
            amount = Math.abs(amount - (amount20s * 20));
            System.out.println("20s = " + amount20s);
        }
        if(amount >= 10){
            amount10s = (int)Math.abs(amount/10);
            amount = Math.abs(amount - (amount10s * 10));
            System.out.println("10s = " + amount10s);
        }
        if(amount >= 5){
            amount5s = (int)Math.abs(amount/5);
            amount = Math.abs(amount - (amount5s * 5));
            System.out.println("5s = " + amount5s);
        }
        if(amount >= 2){
            amount2s = (int)Math.abs(amount/2);
            amount = Math.abs(amount - (amount2s * 2));
            System.out.println("2s = " + amount2s);

        }
        if(amount >= 1){
            amount1s = (int)Math.abs(amount/1);
            amount = Math.abs(amount - (amount1s));
            System.out.println("1s = " + amount1s);
        }
    }

    void mainmenu(){
        System.out.println("Please enter a withdrawal ammount");
        Scanner atmScanner = new Scanner(System.in);
        int withdrawAmount = atmScanner.nextInt();
        System.out.println("You will receive");
        calculator(withdrawAmount);
    }
    public static void main(String[] args) {
        ATM test = new ATM();
        test.mainmenu();
    }
}
