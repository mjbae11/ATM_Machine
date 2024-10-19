
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public interface menuInterface {

    /**
     * outlineMenu helps the other menus dynamically display the options and records an int value of the persons choice.
     * @param scanner customer object that carries the account information for amounts in checking and savings
     * @param intro scanner object passed in the beginning to keep track of input without having to create a new one
     * @param options scanner object passed in the beginning to keep track of input without having to create a new one
     * @return int returns 1 through options.length
     * */ 
    static public int outlineMenu(Scanner scanner, String intro, String... options) {
        boolean validInput = false;
        int choice = 0;

        while (!validInput) {
            try {
                System.out.println(intro);
                for (int i = 0; i < options.length; i++) {
                    System.out.println("Type " + (i+1) + " - " + options[i]);
                }
                choice = scanner.nextInt();
                scanner.nextLine();
                if (choice >= 1 && choice <= options.length) {
                    validInput = true;
                } else {
                    System.out.println("Not a valid input.");
                }
            // catch if its not a number (like a string)
            } catch(InputMismatchException e) {
                System.out.println("Please enter a number! Try again: ");
                scanner.nextLine();
            // catch if its something completely different
            } catch(NoSuchElementException e) {
                System.out.println("Please enter a number! Try again: ");
                scanner.nextLine();
            }
        }
        return choice;
    }

    /**
     * MainMenu is after the customer has logged in and is used to access the options of their bank account.
     * @param customer customer object that carries the account information for amounts in checking and savings
     * @param scanner scanner object passed in the beginning to keep track of input without having to create a new one
     * @return void
     * */ 
    static public void MainMenu(Customer customer, Scanner scanner) {
        boolean exit = false;
        String typeOfAccount;
        
        while (!exit) {
            int result = menuInterface.outlineMenu(
                    scanner,
                    "Welcome to your Bank Account!",
                    "Checking Account",
                    "Savings Account",
                    "Exit"
            );
            switch (result) {
                case 1:
                    typeOfAccount = "Checking";
                    AccountMenu(customer, scanner, typeOfAccount);
                    break;
                case 2:
                    typeOfAccount = "Savings";
                    AccountMenu(customer, scanner, typeOfAccount);
                    break;
                case 3:
                    System.out.println("exiting");
                    exit = true;
                    break;
                default: 
                    System.out.println("invalid input, try again");
                    scanner.nextInt();
                    break;
            }
        }
    }

    public static void AccountMenu(Customer customer, Scanner scanner, String account) {
        boolean exit = false;
        
        while (!exit) {
            try {
                int result = menuInterface.outlineMenu(
                        scanner,
                        "Welcome to your " + account + " Account!",
                        "View Balance",
                        "Deposit",
                        "Withdraw",
                        "Exit"
        );
                switch (result) {
                    case 1:
                        System.out.print("Here is your balance: ");
                        System.out.println(customer.getBalance(account));
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    case 2: 
                        customer.deposit(scanner, account);
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    case 3: 
                        customer.withdraw(scanner, account);
                        TimeUnit.SECONDS.sleep(1);
                        break;
                    case 4: 
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default: 
                        System.out.println("invalid input, try again");
                        scanner.nextInt();
                        break;
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted SLEEP timeout");
            }
        }
    }
}
