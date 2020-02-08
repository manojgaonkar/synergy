/*
 * route.java
 *
 * Created on January 29, 2009, 11:55 AM
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
 * Entity class route
 * 
 * @author MD
 */
@Entity
public class route implements Serializable {

   
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    String route;
    private int saletype;
    private int timing;
    private int stateid;
    
    
    /** Creates a new instance of route */
    public route() {
    }

    /**
     * Gets the id of this route.
     * @return the id
     */
     @Id
    public Integer getId() {
        return this.id;
    }

    /**
     * Sets the id of this route to the specified value.
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
   public void setRoute(String route){
        this.route = route;
    }
    
    public String getRoute(){
        return this.route;
    }   
    
    public void setsaletype(int saletype){
        this.saletype = saletype;
    }
    
    public int getsaletype(){
        return this.saletype;
    }
    
    public void settiming(int timing){
        this.timing = timing;
    }

    public int gettiming(){
        return this.timing;
    }
    
    public void setstateid(int stateid){
        this.stateid = stateid;
    }
    
    public int getstateid(){
        return this.stateid;
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
     * Determines whether another object is equal to this route.  The result is 
     * <code>true</code> if and only if the argument is not null and is a route object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof route)) {
            return false;
        }
        route other = (route)object;
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
        return "mktg.persistDatabase.route[id=" + id + "]";
    }
    
}
