/*
 * welcomeBean.java
*
 * Created on October 31, 2008, 5:25 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package mktg.backingBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import mktg.persistDatabase.useracts;

/**
 *
 * @author MD
 */
public class welcomeBean {

//    @Resource
//    private UserTransaction utx;
    
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;
    
    
    @Resource(name="jdbc/kmfmktgNew")
    private javax.sql.DataSource myDB;    
    
    protected String userName = "";
    protected String userPwd = "";
    
    private Connection con;

    
    HashMap<String,String> hmUP = new HashMap<String,String>();
    
    /**
     * Creates a new instance of welcomeBean
     */
    public welcomeBean() {
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getuserName() {
        return this.userName;
    }
    
    public void setuserPwd(String userPwd){
        this.userPwd = userPwd;
    }
    
    public String getuserPwd(){
        return this.userPwd;
    }

    public void processActionEvent(ActionEvent ae) {
        authenticateUser();
    }
        
    public String authenticateUser(){
        try{            
            EntityManager em = getEntityManager();                
            List l = em.createQuery("SELECT object(o) FROM useracts o ").
                    getResultList();            
            Iterator itr = l.iterator();            
            while(itr.hasNext()){
                useracts ua = (useracts) itr.next();
                hmUP.put(ua.getname(), ua.getpwd());
            }            
            if(hmUP.containsKey(getuserName())){
                if(hmUP.get(getuserName()).compareTo(generatePwd(getuserPwd())) == 0 ){
                    FacesContext.getCurrentInstance().
                        getExternalContext().
                        getSessionMap().
                        put(new String("UserName"), this.userName);                                        
                        return "homepage";                        
                }else{
                    addErrorMessage("Authorisation failed. username or password invalid.");                    
                }
            }            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return "welcomepage";
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
    
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
    }    
                
}
