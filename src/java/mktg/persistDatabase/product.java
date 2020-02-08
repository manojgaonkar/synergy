/*
 * product.java
 *
 * Created on January 30, 2009, 6:01 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity class product
 * 
 * @author MD
 */
@Entity
public class product implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    
    private Integer id;
    
    private String product;
        
    private Integer stateid;
        
    private double rate;

    private double commission;
    
    private double tcd;
    
    private double splrate;
    
    private double tax;

    private double cst;

    private double cess;
           
    private int prodtype;
    
    private int layoutno;
    
    private boolean status;
    
    private double utprate;
    
    private double subsidy;
    
    /** Creates a new instance of product */
    public product() {
    }

    /**
     * Gets the id of this product.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }
    /**
     * Sets the id of this product to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setproduct(String product){
        this.product = product;
    }
    
    public String getproduct(){
        return this.product;
    }

    public void setrate(double rate){
        this.rate = rate;
    }
    
    public double getrate(){
        return this.rate;
    }
    
    public void setprodtype(int prodtype){
        this.prodtype = prodtype;
    }
    
    public int getprodtype(){
        return this.prodtype;
    }
    
    
    public void setstateid(Integer stateid){
        this.stateid = stateid;
    }
    
    public Integer getstateid(){
        return this.stateid;
    }      
    
    public void settax(double tax){
        this.tax = tax;
    }

    public double gettax(){
        return this.tax;
    }    

    public void setcst(double cst){
        this.cst = cst;
    }

    public double getcst(){
        return this.cst;
    }        
    
    public void setcess(double cess){
        this.cess = cess;
    }

    public double getcess(){
        return this.cess;
    }             
    
    public void setlayoutno(int layoutno){
        this.layoutno = layoutno;
    }
    
    public int getlayoutno(){
        return this.layoutno;
    }
    
    public void setcommission(double commission){
        this.commission = commission;
    }
      
    public double getcommission(){
        return this.commission;
    }
    
    public void settcd(double tcd){
        this.tcd = tcd;
    }
    
    public double gettcd(){
        return this.tcd;
    }
    
    public void setsplrate(double splrate){
        this.splrate = splrate;
    }
    
    public double getsplrate(){
        return this.splrate;
    }
    
    
    
    public void setstatus(boolean status){
        this.status = status;
    }
    
    public boolean getstatus(){
        return this.status;
    }
        
    public void setutprate(double utprate){
        this.utprate = utprate;
    }
    
    public double getutprate(){
        return this.utprate;
    }
        
    public void setsubsidy(double subsidy){
        this.subsidy = subsidy;
    }
    
    public double getsubsidy(){
        return this.subsidy;
    }

    /**   
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this product.  The result is 
     * <code>true</code> if and only if the argument is not null and is a product object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof product)) {
            return false;
        }
        product other = (product)object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "mktg.persistDatabase.product[id=" + id + "]";
    }
    
}
