/*
 * taluka.java
 *
 * Created on January 27, 2009, 3:19 PM
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
 * Entity class taluka
 * 
 * 
 * 
 * 
 * @author MD
 */
@Entity
public class taluka implements Serializable {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String taluka;    
    
    /**
     * Creates a new instance of taluka
     */
    public taluka() {
    }

    /**
     * Gets the id of this taluka.
     * 
     * 
     * 
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * Sets the id of this taluka to the specified value.
     * 
     * 
     * 
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    public void settaluka(String taluka){
        this.taluka = taluka;
    }
    
    public String gettaluka(){
        return this.taluka;
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
     * Determines whether another object is equal to this taluka.  The result is 
     * <code>true</code> if and only if the argument is not null and is a taluka object that 
     * has the same id field values as this object.
     * 
     * 
     * 
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof taluka)) {
            return false;
        }
        taluka other = (taluka)object;
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
        return "mktg.persistDatabase.taluka[id=" + id + "]";
    }
    
}
