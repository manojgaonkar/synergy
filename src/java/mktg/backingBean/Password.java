/*
 * Password.java
 *
 * Created on June 6, 2009, 12:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mktg.backingBean;

import javax.faces.context.FacesContext;

/**
 *
 * @author MD
 */
public class Password {

    /** Creates a new instance of Password */
    private String passwd;

    public Password() {
    }

    public void setpasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getpasswd() {
        return this.passwd;
    }

    public String chkPasswd() {
        if (this.passwd != null && this.passwd.compareTo("fgstock") == 0) {
            return "success";
        } else {
            return "failure";
        }
    }
    
    public String chkRoutePasswd() {
        if (this.passwd != null && this.passwd.compareTo("roadblock") == 0) {
            return "success";
        } else {
            return "failure";
        }
    }  
    
    public String chkCustomerPasswd(){
        if (this.passwd != null && this.passwd.compareTo("angel") == 0) {
            return "success";
        } else if(this.passwd != null && this.passwd.compareTo("editangel") == 0){
            return "esuccess";
        } else {
            return "failure";
        }        
    }
        
    public String chkEditGatepass(){
        if (this.passwd != null && this.passwd.compareTo("gpouter") == 0) {
            return "success";
        } else {
            return "failure";
        }        
    }    
    
}
