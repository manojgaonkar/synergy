/*
 * Calculation.java
 *
 * Created on February 14, 2009, 10:45 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

/**
 *
 * @author MD
 */
public class Calculation {
       
    private double qty;
    private double rate;
    private double amount;
    private double commi;
    private double taxamt;
    private double cstamt;
    private double cessamt;
    private double tcdamt;    
    private double splrateamt;
    private double netamt;
    
    /** Creates a new instance of Calculation */
    public Calculation() {
        this.qty = 0.00;
        this.rate = 0.00;        
        this.amount = 0.00;
        this.commi = 0.00;
        this.taxamt = 0.00;
        this.cstamt = 0.00;
        this.cessamt = 0.00;
        this.tcdamt = 0.00;
        this.splrateamt = 0.00;
        this.netamt = 0.00;
    }
    
     public double gettaxamt(){
        return this.taxamt;
    }
    
    public void settaxamt(double taxamt){
        this.taxamt = taxamt;
    }
    
    public double getcstamt(){
        return this.cstamt;
    }
    
    public void setcstamt(double cstamt){
        this.cstamt = cstamt;
    }
    
    public double getcessamt(){
        return this.cessamt;
    }
    
    public void setcessamt(double cessamt){
        this.cessamt = cessamt;
    }
    
    public double gettcdamt(){
        return this.tcdamt;
    }
    
    public void settcdamt(double tcdamt){
        this.tcdamt = tcdamt;
    }
    
    public double getcommi(){
        return this.commi;
    }
    
    public void setcommi(double commi){
        this.commi = commi;
    }
    
    public double getamount(){
        return this.amount;
    }
    
    public void setamount(double amount){
        this.amount = amount;
    }
    
    public double getnetamt(){
        return this.netamt;
    }
    
    public void setnetamt(double netamt){
        this.netamt = netamt;
    }
                        
    public synchronized void calc(double qty,
                    double rate,
                    double comm,
                    double tax,
                    double cst,
                    double cess, 
                    double tcd,
                    int mdt){
        

        
        double amt = 0.00;
        
        switch(mdt){
            //Dealer Price
            case 1:

                this.amount = qty * rate;
                
                this.commi = qty * comm;
                
                amt = this.amount; 
                
                this.netamt  = amt + this.commi;
                
                amt = this.amount - this.commi;                 
                
                if(tax > 0){

                    tax = tax + 100;
                    
                    double a = (amt + this.commi);

                    double b = (amt + this.commi) * 100 / tax;

                    this.taxamt = a - b ;

                }   
                
                this.netamt = this.netamt - (this.taxamt + this.commi);
                
                break;
            //MRP    
            case 2:               
                
                this.amount = qty * rate;
                
                this.commi = qty * comm;
                
                amt = this.amount;
                
                this.netamt  = amt - this.commi;
                
                if(tax > 0){
                
                    tax = tax + 100;
                
                    double a = (amt );
                    
                    double b = (amt ) * 100 / tax;
                    
                    this.taxamt = a - b ;
                }                            
                
                this.netamt = (this.netamt + this.commi) - this.taxamt ;
                
                break;
            //TCD
            case 3:             
                
                this.amount = qty * rate;                
                
                this.commi = qty * comm;
                
                amt = this.amount ; 
                
                this.netamt  = amt + this.commi;
               
                amt = this.amount - this.commi;
            
                if(tax > 0){
                
                    tax = tax + 100;
                    
                    double a = (amt + this.commi);

                    double b = (amt + this.commi) * 100 / tax;

                    this.taxamt = a - b ;                    
                }   
                
                this.netamt = this.netamt - (this.taxamt + this.commi);                
                
                break;
            //UTP    
            case 4:
                    
                this.amount = qty * rate;                                
                
                if(tax > 0){
                    
                    this.taxamt = this.amount * tax / 100 ;                    
                }                   
                
                this.netamt = this.amount + this.taxamt ;
                
                break;
                
            //Subsidy    
            case 5:
                
//                this.amount = qty * rate;                                                
//                this.netamt = this.amount;                
//                break;
                
                this.amount = qty * rate;
                
//                this.commi = qty * comm;
                
                amt = this.amount;
                
                this.netamt  = amt - this.commi;
                
                if(tax > 0){
                
                    tax = tax + 100;
                
                    double a = (amt );
                    
                    double b = (amt ) * 100 / tax;
                    
                    this.taxamt = a - b ;
                }                            
                
                this.netamt = (this.netamt + this.commi) - this.taxamt ;

                break;  
            // Spl.Rate    
            case 6:
             
                this.amount = qty * rate;                
                
                this.commi = qty * comm;
                
                amt = this.amount ; 
                
                this.netamt  = amt + this.commi;
               
                amt = this.amount - this.commi;
            
                if(tax > 0){
                
                    tax = tax + 100;
                    
                    double a = (amt + this.commi);

                    double b = (amt + this.commi) * 100 / tax;

                    this.taxamt = a - b ;                    
                }   
                
                this.netamt = this.netamt - (this.taxamt + this.commi);                
                
                break;
             
        }
    }
        
   public synchronized void TaxInvoice(double qty,
                    double rate,
                    double comm,
                    double tax,
                    double cst,
                    double cess, 
                    double tcd){
        
        double amt = 0.00;
        
        this.amount = qty * rate;

        this.commi = qty * comm;

        this.taxamt = this.amount * tax / 100;
          
        this.netamt = this.amount + (this.taxamt);
    }    
            
}
