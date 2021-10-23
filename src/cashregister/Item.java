package cashregister;

import java.util.ArrayList;

/**
 *
 * @author alexs
 */

public class Item {

    private String itemName;
    private double itemCost;
    
    //default constuctor

    /**
     *
     */
    public Item(){
    }
    
    //overloaded constuctor

    /**
     *
     * @param itemName
     * @param itemCost
     */
    public Item(String itemName, double itemCost){
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    /**
     *
     * @return
     */
    public String getItemName() {
        return itemName;
    }
    
    /**
     *
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     *
     * @return
     */
    public double getItemCost() {
        return itemCost;
    }
    
    /**
     *
     * @param itemCost
     */
    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }    

    public String toString(){
        return "Item: " + itemName + ": " + itemCost + "\n";
    }
    
}
