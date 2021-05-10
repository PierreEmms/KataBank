package bank;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        int input;
        int deposit;
        int withdraw;

        Account account = new Account();
        scanner = new Scanner(System.in);

        do {
            showMenu();
            isNumber();
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    account.getBalance();
                    break;
                case 2:
                    System.out.println("Enter the amount you want to deposit : ");
                    isNumber();
                    deposit = scanner.nextInt();
                    account.deposit(deposit);
                    account.getBalance();
                    break;
                case 3:
                    System.out.println("Enter the amount you want to withdraw : ");
                    isNumber();
                    withdraw = scanner.nextInt();
                    account.withDraw(withdraw);
                    account.getBalance();
                    break;
                case 4:
                    account.seeHistory();
                    break;
            }
        } while (input != 5);
    }

    static void showMenu() {
        System.out.println("Welcome to your bank account: ");
        System.out.println("1. See your balance");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdraw");
        System.out.println("4. See your history");
        System.out.println("5. Exit");
        System.out.println("--------------------------");
        System.out.println("Enter a number to select an option : ");
    }

    static void isNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Input is not a number.");
            scanner.nextLine();
        }
    }
}
