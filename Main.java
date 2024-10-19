import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        /*
         * Scanner a menu with listed options
         * while
         *  try catch
            * if not an option
            *      please click an option
             
         * click an option: checking, saving, exit
         *         then another option: deposit, withdraw, back
         * 
         * 
         * parts:
         * main menu
         *      checking account
         *      savings account
         *      exit
         * checking menu
         *      check balance
         *      withdraw
         *      deposit
         * savings menu
         *      check balance
         *      withdraw
         *      deposit
         * 
         * CHECK - Log in to the right customer, retaining the customer data throughout
         */

        
        // create 2 Hashmaps of login info, and a combo of integers:customers
        Customer dude = new Customer("dude", 1239999, 1900);
        Customer mike = new Customer("mike", 562434, 6453);
        Customer jazz = new Customer("jazz", 9653657, 8654);
        HashMap<Integer, Integer> customerLogins = new HashMap<>();
        HashMap<Integer, Customer> customers = new HashMap<>();
        customers.put(dude.getCustNumber(), dude);
        customers.put(mike.getCustNumber(), mike);
        customers.put(jazz.getCustNumber(), jazz);
    
        customerLogins.put(dude.getCustNumber(), dude.getPin());
        customerLogins.put(mike.getCustNumber(), mike.getPin());
        customerLogins.put(jazz.getCustNumber(), jazz.getPin());

        Main_Menu.start(customerLogins, customers);

    }
}