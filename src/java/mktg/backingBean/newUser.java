/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mktg.backingBean;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import mktg.persistDatabase.useracts;

/**
 *
 * @author jairam
 */


public class newUser {
    
    private String name ;
    private String pwd ;
    
    private String repwd;
    private String keyword; 
    
    private useracts userac ;
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;       
    
    
    @Resource(name="jdbc/kmfmktgNew")
    private javax.sql.DataSource myDB;

    private Connection con;
    
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
        
    public void setrepwd(String repwd){
        this.repwd = repwd;
    }    
    public String getrepwd(){
        return this.repwd;
    }        
    
    public void setkeyword(String keyword){
        this.keyword = keyword;
    }    
    public String getkeyword(){
        return this.keyword;
    }            
    
    
    public void processaddUser(ActionEvent ae){

        if(getkeyword().compareTo("intel") == 0 && getrepwd().compareTo(getpwd()) == 0){
                    
            EntityManager em = getEntityManager();          
            try {            
                utx.begin();                
                this.userac = new useracts();                            
                userac.setname(getname());
                userac.setpwd(generatePwd(getpwd()));        
                em.persist(userac);
                utx.commit();  
                addSuccessMessage("New user created successfully.");
            } catch (Exception ex) {
                try {
                    utx.rollback();
                } catch (IllegalStateException ex1) {
                    Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex1);
                } catch (SecurityException ex1) {
                    Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex1);
                } catch (SystemException ex1) {
                    Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex1);
                }
            }finally{
                em.close();
            }        
        }else{
            addSuccessMessage("Sorry Worng inputs.Try Again");
        }
        
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }     
    
    
    private synchronized String generatePwd(String password){        
        
        String passwd = null;
        try {
            con = myDB.getConnection(new String("root"),new String("syncomp"));
            
            Statement stmt = con.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT SHA1('"+password+"')");
            
            while(rs.next())
                passwd = rs.getString(1);
//                System.out.println("Pwd : " + rs.getString(1));
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(newUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
        return passwd;        
    }
    
   public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("successInfo", facesMsg);
    }           
    
}
