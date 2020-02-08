/*
 * producttype.java
 *
 * Created on February 2, 2009, 5:20 PM
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
 * Entity class producttype
 * 
 * @author MD
 */
@Entity
public class producttype implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String producttype;
    
    /** Creates a new instance of producttype */
    public producttype() {
    }

    /**
     * Gets the id of this producttype.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this producttype to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
        
    public void setproducttype(String producttype){
        this.producttype = producttype;
    }
    
    public String getproducttype(){
        return this.producttype;
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
     * Determines whether another object is equal to this producttype.  The result is 
     * <code>true</code> if and only if the argument is not null and is a producttype object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof producttype)) {
            return false;
        }
        producttype other = (producttype)object;
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
        return "mktg.persistDatabase.producttype[id=" + id + "]";
    }
    
}
