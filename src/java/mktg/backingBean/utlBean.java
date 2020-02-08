/*
 * utlBean.java
 *
 * Created on March 21, 2009, 10:24 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

import java.util.Date;
import mktg.utility.Utility;

/**
 *
 * @author MD
 */
public class utlBean {
    
    private Date CurrentDate ;
    private Date IndentDate ;
    private Date BackDate;
    private int timing ;

    Utility utl = new Utility();
    
    /** Creates a new instance of utlBean */
    public utlBean() {
                
        this.CurrentDate = new Date();
        this.IndentDate = new Date() ;
        this.BackDate = utl.BackDate(utl.ChangeFormat(this.CurrentDate));        
        this.CurrentDate = utl.TodaysDate(utl.ChangeFormat(this.CurrentDate));
        this.IndentDate = utl.NextDayDate(utl.ChangeFormat(this.IndentDate));

    }

    public int getTiming() {
        return timing;
    }

    public void setTiming(int timing) {
        System.out.println("TIMING : "+timing);
        System.out.println("CurrentDate : "+CurrentDate);
        this.timing = timing;
    }
    
    
        
    public Date getIndentDate(){
        if(this.timing == 2){
            this.IndentDate = this.CurrentDate;
        }
        return this.IndentDate;
    }
    
    public Date getCurrentDate(){
         System.out.println("TIMING : "+timing);
        System.out.println("CurrentDate : "+CurrentDate);
        if(this.timing == 2){
            this.CurrentDate = BackDate;
        }
        return this.CurrentDate;
    }    
    
    
    
}
