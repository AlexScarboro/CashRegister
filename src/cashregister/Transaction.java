package cashregister;

import java.util.ArrayList;

/**
 *
 * @author alexs
 */

public class Transaction { //arraylist in Main passes transactions to this class
    
    //fields - All fields should be private
    private double subTotal = 0.0;
    private double total = 0.0;
    private double tax = 0.0;
    private double userPayment;
    private double change = 0.0;
    
    //an arraylist called items of type Item that holds item objs
    private ArrayList<Item> items = new ArrayList<Item>();
    
    //an arraylist called payment of type Payment that holds payment objs
    private ArrayList<Payment> payments = new ArrayList<Payment>();
    
    //default constructor

    /**
     *
     */
    public Transaction(){
    }
    
    //overloaded constructor that has arraylist of items that I work with.

    /**
     *
     * @param subTotal
     * @param total
     * @param tax
     * @param userPayment
     * @param change
     * @param payments
     */
    public Transaction(double subTotal, double total, double tax, double userPayment, double change, ArrayList<Payment> payments){ 
        this.subTotal = subTotal; 
        this.total = total;
        this.tax = tax;
        this.items = items;
    }

    /**
     *
     * @return
     */
    public double getSubTotal() {
        return this.subTotal;
    }

    /**
     *
     */
    public void setSubTotal() {
        this.subTotal = subTotal;
        
        double sum = 0.0;
        
        //go thru items ArrayList, get the content of each item
        for (int i = 0; i < items.size(); i++){
            /**get the item at each index in the items arraylist, get that item's cost,
            and add the costs to the subtotal **/
            sum += items.get(i).getItemCost(); 
        }
        
        //setting the subTotal to be the sum of the cost of the items
        this.subTotal = sum; 
    }
    
    /**
     *
     * @return
     */
    public double getTotal() {
        return this.total;
    }

    /**
     *
     */
    public void setTotal() {
        this.total = this.subTotal + this.tax;
    }
    
    /**
     *
     * @return
     */
    public double getTax() {
        return this.tax;
    }

    /**
     *
     */
    public void setTax() {
        this.tax = this.subTotal * 0.07; 
    }
    
    /**
     *
     * @return
     */
    public double getUserPayment() {
        return userPayment;
    }

    /**
     *
     * @param userPayment
     */
    public void setUserPayment(double userPayment) {
        this.userPayment = userPayment;
    }
    
    /**
     *
     * @param userPayment
     */
    public void addUserPayment(Payment userPayment) {
        //Add the payment to the transaction payment array
        payments.add(userPayment);
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    
    /**
     *
     * @param items
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     *
     * @return
     */
    public double getChange() {
        return change;
    }

    /**
     *
     * @param change
     */
    public void setChange(double change) {
        this.change = change;
    }

    /**
     *
     * @return
     */
    public ArrayList<Payment> getPayments() {
        return payments;
    }
    
    /**
     *
     * @return
     */
    
    public double getSumOfPayments(){ 
       //method to get the sum of the payments
       double sum = 0.0;
       //go thru payments ArrayList, get the amount of each payment
       for (int i = 0; i < payments.size(); i++){ 
           /**get the item at each index in the items arraylist, get that item's cost,
           and add the costs to the subtotal **/
           sum += payments.get(i).getPaymentAmount(); 
       }
       return sum;
    }
   
    /**
     *
     * @return
     */
    public double getPayment(){
        //Method that uses compute subtotal and compute tax, and that takes payment
        double change;
        
        /**while the user's payment is less than the total, keep asking them to choose a payment type
        and an amount to pay with that payment type **/
        while (userPayment < total){ 
            System.out.println("Please enter payment type.");
            System.out.println("Enter the amount to pay with this type.");
            System.out.println("Total after payment: " + getUserPayment());
        }
        
        if (userPayment > total){ 
            //create change var and print change onto receipt
            change = userPayment - total;
        }
        return userPayment;
    }    
        
}