/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mktg.backingBean;

/**
 *
 * @author xp
 */
public class ClsDaySales {
    
    private String product;
    
    private double demand;
    private double sales;
    
    private double leakage;
    private double retn;
    
    public ClsDaySales(){        
    }
    
    public String getproduct(){
        return this.product;
    }
    public void setproduct(String product){
        this.product = product;
    }
    
    public double getdemand(){
        return this.demand;
    }
    public void setdemand(double demand){
        this.demand = demand;
    }
    
    public double getsales(){
        return this.sales;
    }
    public void setsales(double sales){
        this.sales = sales;
    }
    
    public double getleakage(){
        return this.leakage;
    }
    public void setleakage(double leakage){
        this.leakage = leakage;
    }
    
    public double getretn(){
        return this.retn;
    }
    public void setretn(double retn){
        this.retn = retn;
    }

}
