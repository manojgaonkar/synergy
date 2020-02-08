/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jairam
 */
@Entity
public class useracts implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String name;
    private String pwd;
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    
    public void setname(String name){
        this.name = name;
    }
    
    public String getname(){
        return this.name;
    }
    
    public void setpwd(String pwd){
        this.pwd = pwd;                
    }
    
    public String getpwd(){
        return this.pwd;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof useracts)) {
            return false;
        }
        useracts other = (useracts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mktg.persistDatabase.useracts[id=" + id + "]";
    }

}
