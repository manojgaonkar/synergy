/*
 * indentCart.java
 *
 * Created on February 5, 2009, 12:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

import java.util.ArrayList;
import mktg.persistDatabase.indent;

/**
 *
 * @author MD
 */
public class indentCart {
    
    /** Creates a new instance of indentCart */
    ArrayList<indent> alIC = new ArrayList<indent>();
    
    IndentCartItems ici = new IndentCartItems();
    
    public indentCart() {
    }
    
    public void AddItem(indent i){
        alIC.add(i);
        ici.setIncreaseQuantity();
    }   
    
    public void RemoveItem(){
        if(ici.getQuantity() > -1){
            alIC.remove(ici.getQuantity());
            ici.DecreaseQuantity();
        }
    }
    
    public void RemoveItem_1(){
        if(ici.getQuantity() > -1){
            alIC.remove(1);
            ici.DecreaseQuantity();
        }        
    }
    
     public ArrayList alIC(){
         return this.alIC;
     }
     
     public void ClearList(){
         ici.setQuantity(0);
         alIC.clear();
     }
    
}
