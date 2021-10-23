package cashregister;

import java.util.ArrayList;

/**
 *
 * @author alexs
 */

public class Payment {
    //I'm only declaring one payment because a payment only has one payment type  
    private PaymentType paymentType; 
    private double paymentAmount;
    
    //default constuctor

    /**
     *
     */
    public Payment(){
    }
    
    //overloaded contructor

    /**
     *
     * @param paymentType
     * @param paymentAmount
     */
    public Payment(PaymentType paymentType, double paymentAmount){
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
    }

    /**
     *
     * @return
     */
    public PaymentType getPaymentType() {
        return paymentType;
    }

    /**
     *
     * @param paymentType
     */
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    
    /**
     *
     * @return
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     *
     * @param paymentAmount
     */
    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        String result = "";
        //check to see what the payment type is in order to print that payment type on the receipt
        if (paymentType == PaymentType.CASH) {
            /**Aligning the values for subtotal, tax, total, and payment information. This was done
            with the tab character ‘\t’ in your Strings. I played around with the number of tabs
            for each payment type.**/
            result += "Cash:\t\t";
        } else if (paymentType == PaymentType.DEBIT_CARD) {
            result += "Debit:\t\t";   
        } else if (paymentType == PaymentType.CREDIT_CARD) {
            result += "Credit:\t\t";
        } else {
            result += "Check:\t\t";
        }
        
        //return the payment amount
        result += this.getPaymentAmount() + "\n";
        return result;
    }

}
    