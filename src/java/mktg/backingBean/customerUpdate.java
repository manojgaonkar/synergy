/*
 * customerUpdate.java
 *
 * Created on January 28, 2009, 4:49 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import mktg.persistDatabase.customer;

/**
 *
 * @author MD
 */
public class customerUpdate {
    
    private SelectItem cstItems;
    private ArrayList<SelectItem> alcstList;
    
    /**
     * Creates a new instance of customerUpdate
     */
    public customerUpdate() {           
    }
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;   
    
    int RouteId;
    String RouteName;
    
    Long CustId;
    
    customer found;
    
    boolean blnRender;
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }      
        
    public List getCustomerlist(){        
        EntityManager em = getEntityManager();            
        blnRender = false;
        
        FacesContext fc = FacesContext.getCurrentInstance();
            RouteId = Integer.parseInt(fc.getExternalContext().
            getSessionMap().
            get(new String("RouteID")).toString()); 
        
        RouteName = fc.getExternalContext().
            getSessionMap().
            get(new String("RouteName")).toString();        
                       
        alcstList = new ArrayList<SelectItem>();
        
        List l = em.createQuery("SELECT object(o)FROM customer o " +
                " " +                           
                "WHERE o.route = :ROUTEID " +
                "ORDER BY o.firstname ")
                .setParameter("ROUTEID",new Integer(RouteId))
                .getResultList();       
        
        Iterator itr = l.iterator();        
        
        while(itr.hasNext()){
            customer cst = (customer) itr.next();              
            cstItems = new SelectItem(new Long(cst.getId()),cst.getfirstname());
            alcstList.add(cstItems);            
        }                
        return alcstList;
    }    
        
    public void processActionEvent(){   
//        System.out.println("Event From ActionListener Customer ID " + CustId);
        blnRender = true;        
        found = findCust(CustId);
//        System.out.println(found);
    }
    
    public void processValueChangeEvent(ValueChangeEvent e){
        CustId = Long.parseLong(e.getNewValue().toString());
//        System.out.println("Customer Id " + CustId);
    }
    
    public void setfound(customer found){
        this.found = found;
    }
    
    public customer getfound(){
        return this.found;
    }
    
    private customer findCust(Long CustId)throws NullPointerException{
        
        EntityManager em = getEntityManager();        
        
        customer foundcst = em.find(customer.class , new Long(CustId));
        return foundcst;
    }    
    
    public void setRouteId(int RouteId){
        this.RouteId = RouteId;
    }
        
    public int getRouteId(){
        return this.RouteId;
    }
    
    public void setblnRender(boolean blnRender){
        this.blnRender = blnRender;
    }
    
    public boolean getblnRender(){
        return this.blnRender;
    }
    
    
    public void createUpdate(){
        EntityManager em = getEntityManager();                
        
       try {
            utx.begin();
            em.joinTransaction();
            found = em.merge(found);
//            Query qry = em.createQuery("delete from customer as c");
//            Query qry = em.createQuery("update customer AS c " +
//                    "SET c.firstname = 'xxxxxxxxxxxxxxxxxx'");
//            qry.executeUpdate();
            utx.commit();
            addSuccessMessage("customer was successfully updated.");
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
    
    public void setRouteName(String RouteName){
        this.RouteName = RouteName;
    }
    
    public String getRouteName(){
        return this.RouteName;
    }
    
    
    public List exa(){
        EntityManager em = getEntityManager();            
        
        List l = em.createQuery("SELECT c.firstname,t.taluka " +
                "FROM customer c,taluka t " +
                " " +                           
                "WHERE o.route = :ROUTEID " +
                "ORDER BY o.firstname ")
                .setParameter("ROUTEID",new Integer(4))
                .getResultList();              
        return l;
    }
    
}
