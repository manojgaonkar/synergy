/*
 * customerDBAO.java
 *
 * Created on January 7, 2009, 4:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author MD
 */
public class customerDBAO {    
    

    /** Creates a new instance of customerDBAO */
    public customerDBAO() {      
    }
        
    private customer customer ;     
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;    
    
//    private int m_talukaId ;
    
    private int routeId ;
    
    private int Limit_row ;
    
    private int Size ;

//    private boolean NEXT;
    
    public List getCustomerlist(){
        EntityManager em = getEntityManager();                              
        List l = em.createQuery("SELECT object(o)FROM customer o " +        
                "WHERE o.route = :ROUTEID " +
                "ORDER BY o.firstname ")
                .setParameter("ROUTEID",routeId)
                .setFirstResult(Limit_row)
                .setMaxResults(10)
                .getResultList();                                
        Size = l.size();                   
        return l;
    }
   
    public void init(ActionEvent e){
        Limit_row = 0;
    }   
    
    public void processNextPageActionEvent(ActionEvent e){        
        Limit_row = Limit_row + 10;
//        System.out.println(" NEXT " + Limit_row );
    }
    
    public void processPrevPageActionEvent(ActionEvent e){        
        if(Limit_row <= 10)
            Limit_row = 0 ;
        else
            Limit_row = Limit_row - 10;        
//         System.out.println(" PREVIOUS " + Limit_row );
    }    
    
    public void processFirstPageActionEvent(ActionEvent e){
        Limit_row = 0;
    }    
    
    public void processLastPageActionEvent(ActionEvent e){
        Limit_row = Limit_row + 10;
    }    
          
    public boolean getNext(){
        if(Size < 10)
            return false;
        else
            return true;
    }
    
    public boolean getPrevious(){        
        if(Limit_row <=0)
            return false;
        else
            return true;        
    }
        
    public void processValueChangeEvent(ValueChangeEvent e){
//        System.out.println(e.getNewValue());
        routeId = Integer.parseInt(e.getNewValue().toString());        
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }    
    
    public void setcustomer(customer customer){
        this.customer = customer;
    }
    
    public customer getcustomer(){
        return this.customer;
    }
    
    public String createSetup() {    
        this.customer = new customer();    
//        return "customer_create";
        return "customerPassword";
    } 
    
     public String create() {        
        EntityManager em = getEntityManager();               
        try {
            utx.begin();
            em.joinTransaction();
            em.persist(customer);
            utx.commit();
            ClearFileds();
            addSuccessMessage("customer was successfully created.");
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
        return "customer_add";
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

    private void ClearFileds() {
        customer.setfirstname("");
        customer.setComdate(null);
        customer.setAdd1("");
        customer.setAdd2("");
        customer.setAdd3("");
        customer.setAdd4("");
        customer.setAdd5("");
        customer.setPhone("");
        customer.setMobile("");
        customer.setPanNo("");
        customer.setAcNo("");
        customer.setDeposit(0.00);
        customer.setDepodate(null);
        customer.setNominee("");
        customer.setpolicyno("");
        customer.setGrNo("");
        customer.setGrDate(null);
        customer.setsubsidy(0.00);
        customer.setopeningbal(new Float(0.00));
    }
    
    
    public List getCustomerLayoutList(){
        
        EntityManager em = getEntityManager();                              
        
        List l = em.createQuery("SELECT object(o)FROM customer o " +        
                "WHERE o.route = :ROUTEID " +
                "ORDER BY o.layoutno ")
                .setParameter("ROUTEID",routeId)
                .setMaxResults(10)
                .getResultList();                                
        Size = l.size();                   
        
        return l;        
        
    }
    
    
    
       
}
