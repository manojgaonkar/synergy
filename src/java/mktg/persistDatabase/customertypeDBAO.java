/*
 * customertypeDBAO.java
 *
 * Created on January 29, 2009, 10:49 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;

/**
 *
 * @author MD
 */
public class customertypeDBAO {
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;        
    
    private SelectItem TypeCustomer;
    
    private ArrayList<SelectItem> alCustomerType;
    
    /** Creates a new instance of customertypeDBAO */
    public customertypeDBAO() {
    }
    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }        
    
    public List getCustomerType(){
        EntityManager em = getEntityManager();        
        alCustomerType = new ArrayList<SelectItem>();
        List l =  em.createQuery("SELECT t FROM customertype as t ").getResultList();        
        Iterator itr = l.iterator();        
        while(itr.hasNext()){
            customertype cst = (customertype) itr.next();              
            TypeCustomer = new SelectItem(new Long(cst.getId()),cst.getCustType());
            alCustomerType.add(TypeCustomer);            
        }
        return alCustomerType;
    }          
    
}
