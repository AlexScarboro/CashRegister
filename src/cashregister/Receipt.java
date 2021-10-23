package cashregister;

import java.util.ArrayList;

/**
 *
 * @author alexs
 */

public class Receipt {
    
    final private Transaction transaction;
            
    /**
     *
     * @param transaction
     */
    public Receipt(Transaction transaction) {
        this.transaction = transaction;
    }
    
    public String toString(){
       //declaring and initalizing an empty string   
       String result = ("");
       
       /**looping through the items and getting their names and prices.
       Then adding the information to the result String by post-incrementing. **/
       for (int i = 0 ; i < transaction.getItems().size(); i++){
           Item item = transaction.getItems().get(i);
           result += item;
       }
       
       result += "------------------------------------------------\n"; 

       result += "Subtotal:\t" + transaction.getSubTotal() + "\n"; 
       result += "Tax:\t\t" + transaction.getTax() + "\n";
       result += "Total:\t\t" + transaction.getTotal() + "\n";
       
       //looping through the payments and printing their names and prices
       for (int i = 0 ; i < transaction.getPayments().size(); i++){
           Payment payment = transaction.getPayments().get(i);
           result += payment.toString();
       }
       result += "Change: " + transaction.getChange() + "\n";
       
       return result;
    }

}
