package cashregister;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author alexs
 */

public class Main {

    public static void main(String[] args) {
        int paymentChoice = 1;

        Scanner scan = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<Item>();

        //item objs creation
        Item item1 = new Item("bread", 3.00);
        Item item2 = new Item("ham", 5.00);
        Item item3 = new Item("soda", 4.00);

        //adding the items to the arraylist of items
        items.add(item1);
        items.add(item2);
        items.add(item3);

        //create a transaction object
        Transaction transaction = new Transaction();
        
        //passing the items above into the transaction
        transaction.setItems(items); 

        //calculate subTotal, calc tax, and then the sum of those is the total
        transaction.setSubTotal();
        transaction.setTax();
        transaction.setTotal();

        //while the user has not paid the total amount, ie sum of payments is less than transaction.getTotal()
        while (transaction.getSumOfPayments() < transaction.getTotal()) { 
            //Call printOptions to show the user their options.
            Main.printPaymentChoice();

            //Pause to read user input.
            paymentChoice = scan.nextInt();

            /** Check if the user inputted a number corresponding to an option.
            If they did not, then your code should say they did not enter the
            correct input. **/
            if (paymentChoice < 1 || paymentChoice > 4) { //1 Cash, 2 Debit, 3 Credit, 4 Check
                System.out.println("You did not enter the correct output.");
            } else {
                //Create a payment and call handleSelection if they entered a valid option and did not want to quit.
                Payment payment = Main.handleSelection(paymentChoice);
            
                //adding the payment to the transaction
                transaction.addUserPayment(payment);
                System.out.println("Total after payment: " + (transaction.getTotal() - transaction.getSumOfPayments()) + "\n");
            }
            
        }
        
        //then compute change and set it into transaction
        transaction.setChange(transaction.getSumOfPayments() - transaction.getTotal());
        
        //Adding the transaction to the receipt
        Receipt receipt = new Receipt(transaction);   
        
        //Printing the receipt
        System.out.println(receipt);
    }

    //Printing the payment choices that the user chooses
    public static void printPaymentChoice() {  
        System.out.println("Enter the number for the payment type you want to use.");
        System.out.println("1.Cash" + "\n2.Debit card" + "\n3.Credit card" + "\n4.Check");
    }

    public static Payment handleSelection(int selection) {
        //creating a scanner to read user input
        Scanner scan = new Scanner(System.in);

        System.out.printf("Enter the amount to pay with this type.");
        //capturing the user input
        double amount = scan.nextFloat(); 

        //declare a PaymentType obj called paymentType
        PaymentType paymentType;

        if (selection == 1) {
            paymentType = PaymentType.CASH;
        } else if (selection == 2) {
            paymentType = PaymentType.DEBIT_CARD;
        } else if (selection == 3) {
            paymentType = PaymentType.CREDIT_CARD;
        } else {
            paymentType = PaymentType.CHECK;
        }

        /**create a payment object with the amount and type and add it to the arraylist of payments
        for the transaction **/
        Payment payment = new Payment(paymentType, amount);  

        return payment;

    }
    
}