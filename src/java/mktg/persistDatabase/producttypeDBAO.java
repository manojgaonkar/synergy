/*
 * producttypeDBAO.java
 *
 * Created on February 2, 2009, 5:23 PM
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
public class producttypeDBAO {
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;        
    
    private ArrayList<SelectItem> alProductType ;
    
    private SelectItem Producttype;
    
    /** Creates a new instance of producttypeDBAO */
    public producttypeDBAO() {
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }            
    
    public List getProductTypeList(){
        EntityManager em = getEntityManager();        
        alProductType = new ArrayList<SelectItem>();
        List l =  em.createQuery("SELECT t FROM producttype as t ").getResultList();        
        Iterator itr = l.iterator();        
        while(itr.hasNext()){
            producttype prodtype = (producttype) itr.next();              
            Producttype = new SelectItem(new Long(prodtype.getId()),prodtype.getproducttype());
            alProductType.add(Producttype);    
        }
        return alProductType;
    }      
    
}
