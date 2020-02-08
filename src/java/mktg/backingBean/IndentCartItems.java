/*
 * IndentCartItems.java
 *
 * Created on February 5, 2009, 12:31 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

/**
 *
 * @author MD
 */
public class IndentCartItems {
    
    private int Quantity;
    
    /** Creates a new instance of IndentCartItems */
    public IndentCartItems() {        
        Quantity = -1;        
    }
    
    public void setIncreaseQuantity(){
        Quantity++;
    }
    
    public void DecreaseQuantity(){
        Quantity--;
    }
    
    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }
    
    public int getQuantity(){
        return this.Quantity;
    }
    
}
