/*
 * talukaDBAO.java
 *
 * Created on January 28, 2009, 12:05 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author MD
 */
public class routeDBAO {
    
    private SelectItem RouteItem;
    
    private ArrayList<SelectItem> alRoute;
    
    private Date date;
    
    Integer RouteID ;
    
    /** Creates a new instance of talukaDBAO */
    public routeDBAO() {
    }
    
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;  
    
    String RouteName;
    
    HashMap<Integer,String> hmRoute = new HashMap<Integer,String>();
    
    private taluka taluka;
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  
    
    public String createSetup() {    
        this.taluka = new taluka();    
        return "route_createJSP";
    }     
        
   public List getRoute(){
        EntityManager em = getEntityManager();        
        alRoute = new ArrayList<SelectItem>();
        List l =  em.createQuery("SELECT t FROM route as t ").getResultList();        
        Iterator itr = l.iterator();  
        RouteItem = new SelectItem(new Long(0),"Select-Route");
        alRoute.add(RouteItem);         
        while(itr.hasNext()){
            route rt = (route) itr.next();              
            RouteItem = new SelectItem(new Long(rt.getId()),rt.getRoute());
            alRoute.add(RouteItem);    
            hmRoute.put(rt.getId(),rt.getRoute());
        }
        return alRoute;            
   }
   
   public String submitValue(){
//       System.out.println("Route Id " + RouteID);
       
       FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().
        getSessionMap().
        put(new String("RouteID"),RouteID);
                    
       return "modify_customer";
   }
   
   public String submitIndent(){
      FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().
        getSessionMap(). 
        put(new String("RouteID"),RouteID);
        
//        System.out.println("DATE " + date);
        fc.getExternalContext().
        getSessionMap().        
        put(new String("INDENTDATE"),date);        
        
        return "create_indent";
   }
     
   public void processValueChange(ValueChangeEvent e){
       RouteID = (Integer) Integer.parseInt(e.getNewValue().toString());                            

        FacesContext  fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().
        getSessionMap().
        put(new String("RouteName"),hmRoute.get(RouteID));       
   }        
   
   public void setdate(Date date){
       this.date = date;
   }
   
   public Date getdate(){
       return this.date;
   }
   
   
  
}
