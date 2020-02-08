/*
 * addRoute.java
 *
 * Created on June 4, 2009, 12:03 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author MD
 */
public class addRoute {
        
   @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;      
    
    private route r;
    
    /** Creates a new instance of addRoute */
    public addRoute() {
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  
    
    public String createSetup(){
        this.r = new route();
//        return "addRoute";
        return "routePassword";
    }
    
    public route getr(){
        return this.r;
    }
    
    public void processActionListener(ActionEvent ae){        
       EntityManager em = getEntityManager();               
        try {
            utx.begin();
            em.joinTransaction();
            em.persist(r);
            utx.commit();
            addSuccessMessage("route was successfully created.");
        } catch (Exception ex) {
            try {
                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                addErrorMessage(e.getLocalizedMessage());
            }
        } finally {
            em.close();
        }                 
    }
    
     public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, facesMsg);
     }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage("successInfo", facesMsg);
    }         
    
}
