/*
 * rate.java
 *
 * Created on February 3, 2009, 2:16 PM
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
 * Entity class rate
 * 
 * @author MD
 */
@Entity
public class rate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer stateid;
    
    private int prodid;

    private double rate;

    private double tax;

    private double cst;

    private double cess;
       
    /** Creates a new instance of rate */
    public rate() {
    }

    /**
     * Gets the id of this rate.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this rate to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    
    public void setprodid(int prodid){
        this.prodid = prodid;
    }
    
    public int getprodid(){
        return this.prodid;
    }
    
    public void setstateid(Integer stateid){
        this.stateid = stateid;
    }
    
    public Integer getstateid(){
        return this.stateid;
    }
    
    public void setrate(double rate){
        this.rate = rate;
    }
    
    public double getrate(){
        return this.rate;
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
     * Determines whether another object is equal to this rate.  The result is 
     * <code>true</code> if and only if the argument is not null and is a rate object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof rate)) {
            return false;
        }
        rate other = (rate)object;
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
        return "mktg.persistDatabase.rate[id=" + id + "]";
    }
    
}
