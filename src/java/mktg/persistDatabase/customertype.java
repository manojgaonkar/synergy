/*
 * customertype.java
 *
 * Created on January 17, 2009, 3:22 PM
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
 * Entity class customertype
 * 
 * 
 * @author MD
 */
@Entity
public class customertype implements Serializable {

   
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String custtype;
    
    /**
     * Creates a new instance of customertype
     */
    public customertype() {
    }

    /**
     * Gets the id of this customertype.
     * 
     * @return the id
     */
    @Id    
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this customertype to the specified value.
     * 
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setCustType(String custtype){
        this.custtype = custtype;
    }
    
    public String getCustType(){
        return this.custtype;
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
     * Determines whether another object is equal to this customertype.  The result is 
     * <code>true</code> if and only if the argument is not null and is a customertype object that 
     * has the same id field values as this object.
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof customertype)) {
            return false;
        }
        customertype other = (customertype)object;
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
        return "mktg.persistDatabase.custtype[id=" + id + "]";
    }
    
}
