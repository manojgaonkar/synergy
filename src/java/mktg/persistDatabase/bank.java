/*
 * bank.java
 *
 * Created on January 20, 2009, 11:58 AM
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
 * Entity class bank
 * 
 * @author MD
 */
@Entity
public class bank implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String bank;
    
    /** Creates a new instance of bank */
    public bank() {
    }

    /**
     * Gets the id of this bank.
     * @return the id
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this bank to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setBank(String bank){
        this.bank = bank;
    }
    
    public String getBank(){
        return this.bank;
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
     * Determines whether another object is equal to this bank.  The result is 
     * <code>true</code> if and only if the argument is not null and is a bank object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof bank)) {
            return false;
        }
        bank other = (bank)object;
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
        return "mktg.persistDatabase.bank[id=" + id + "]";
    }
    
}
