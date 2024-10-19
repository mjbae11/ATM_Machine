
import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

public class Main_Menu implements menuInterface {
    
       
    // start the mainmenu, with logins hashmap as keys and values, and arraylist customers
    // takes the customer number, AND takes a pin number, and then says try again if its wrong
    static void start(HashMap<Integer, Integer> logins, HashMap<Integer, Customer> customers) {
        
        Integer guessedNum;
        Integer guessedPin;
        Customer loggedInCustomer = null;
        System.out.println("Welcome to the ATM project!");

        try (Scanner scanner = new Scanner(System.in)) {
            boolean validInput = false;
            // while not valid input, run the loop
            while (!validInput) {
                try {
                    System.out.println("Enter your customer number: ");
                    guessedNum = scanner.nextInt();
                    System.out.println("Enter your pin number: ");
                    guessedPin = scanner.nextInt();
                    // check if Hashmap contains guessed number, and guessed customer number Integer object is same as guessed Pin Integer object
                    if ((logins.containsKey(guessedNum) && (logins.get(guessedNum).equals(guessedPin)))) {
                        validInput = true;
                        System.out.println("Log in successful!");
                        loggedInCustomer = customers.get(guessedNum);
                    } else {
                        System.out.println("Username or password incorrect, Try again: ");
                    }
                // catch if its not a number
                } catch(InputMismatchException e) {
                    System.out.println("Please enter a number! Try again: ");
                    scanner.nextLine();
                // catch if its something completely different
                } catch(NoSuchElementException e) {
                    System.out.println("Please enter a number! Try again: ");
                    scanner.nextLine();
                }
            }    
            if (loggedInCustomer != null) {
                System.out.println(loggedInCustomer.getName());
                menuInterface.MainMenu(loggedInCustomer, scanner);
            } else {
                System.out.println("Error: could not get the logged-in customer.");
            }
            
        }
    }
}
