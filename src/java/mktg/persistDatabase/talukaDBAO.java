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
public class talukaDBAO {
    
    /** Creates a new instance of talukaDBAO */
    public talukaDBAO() {
    }
    
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;  
    
    private SelectItem TalukaItems ;
    
    private ArrayList<SelectItem> alTalukaList;
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  
        
    public List getTalukalist(){
        EntityManager em = getEntityManager();        
        alTalukaList = new ArrayList<SelectItem>();
        List l =  em.createQuery("SELECT t FROM taluka as t ").getResultList();        
        Iterator itr = l.iterator();        
        while(itr.hasNext()){
            taluka tal = (taluka) itr.next();              
            TalukaItems = new SelectItem(new Integer(tal.getId()),tal.gettaluka());
            alTalukaList.add(TalukaItems);            
        }
        return alTalukaList;
    }      
    
}
