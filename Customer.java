import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {
    
    private final int MINDEPOSIT = 0;
    private final int MAXDEPOSIT = 1_000_000;

    private Integer custNumber;
    private Integer pin;
    private int checkingAmount = 0;
    private int savingsAmount = 0;
    private String name;
    

    public Customer(String name, int custNumber, int pin) {
        this.name = name;
        this.custNumber = custNumber;
        this.pin = pin;
        this.checkingAmount = 0;
        this.savingsAmount = 0;
    }

    // Getter method for custNumber
    public String getName() {
        return this.name;
    }

    // Getter method for custNumber
    public Integer getCustNumber() {
        return this.custNumber;
    }
    // Setter method for custNumber
    public void setCustNumber(int custNumber) {
        this.custNumber = custNumber;
    }
    // Getter method for pin
    public Integer getPin() {
        return this.pin;
    }
    // Setter method for pin
    public void setPin(int pin) {
        this.pin = pin;
    }

    
    // Checking deposit
    public void deposit(Scanner scanner, String account) {
        boolean validInput = false;
        int deposit = 0;
        System.out.println("How much would you like to deposit?");
        System.out.print("$: ");
        while (!validInput) {
            try {
                deposit = scanner.nextInt();
                if (deposit > MINDEPOSIT && deposit < MAXDEPOSIT) {
                    System.out.println("Sounds good, Deposited: " + deposit);
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
            }
        }
        if (account.equals("Checking")) {
            this.checkingAmount += deposit;
        } else {
            this.savingsAmount += deposit;
        }
    }

    // Checking withdrawal
    public void withdraw(Scanner scanner, String account) {
        boolean validInput = false;
        int withdraw = 0;
        
        while (!validInput) {
            System.out.println("How much would you like to withdraw?");
            System.out.print("$: ");
            try {
                withdraw = scanner.nextInt();
                switch (account) {
                    case "Checking": {
                        if (withdraw >= 0 && withdraw <= checkingAmount) {
                            System.out.println("Sounds good, Withdrew: " + withdraw);
                            validInput = true;
                            this.checkingAmount -= withdraw;
                            break;
                        }
                    }
                    case "Savings": {
                        if (withdraw >= 0 && withdraw <= savingsAmount) {
                            System.out.println("Sounds good, Withdrew: " + withdraw);
                            validInput = true;
                            this.savingsAmount -= withdraw;
                            break;
                        }
                    } default: {
                        if (withdraw < 0) {
                            System.out.println("You can't withdraw a negative number!");
                        } else {
                            System.out.println("You don't have enough money!");
                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
            }
        }
    }


    // return checking balance
    public int getBalance(String account) {
        if (account.equals("Checking")) {
            return this.checkingAmount;
        } else {
            return this.savingsAmount;
        }
    }
}
