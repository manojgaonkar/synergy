/*
 * test.java
 *
 * Created on April 14, 2009, 2:18 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author MD
 */
public class test {
    
    /** Creates a new instance of test */
    public test() {
        
        HashMap<String,Integer> hm = new HashMap<String,Integer>();
        
        hm.put("a",new Integer(10));
        hm.put("b",new Integer(11));
        hm.put("c",new Integer(12));
        
        hm.put("d",new Integer(13));
        hm.put("d",new Integer(26));
        hm.put("d",new Integer(100));
        
        Set s = hm.entrySet();
        
        Iterator itr = s.iterator();
        boolean b = true;
        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();
            System.out.println("Key : "+me.getKey() + " " + " Value :" +me.getValue());
            if(b){
                itr.remove();
                b = false;
            }
        }
        
        System.out.println("After removing elements");
        itr = s.iterator();
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();
            System.out.println("Key : "+me.getKey() + " " + " Value :" +me.getValue());
        }        
        
    }
    
    public static void main(String args[]){
        new test();
    }
    
}
