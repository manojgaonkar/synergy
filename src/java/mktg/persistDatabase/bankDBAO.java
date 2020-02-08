/*
 * bankDBAO.java
 *
 * Created on January 29, 2009, 11:40 AM
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
public class bankDBAO {
    
    private SelectItem BankItem;
    
    private ArrayList<SelectItem> alBank;
    
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;        
    
    /** Creates a new instance of bankDBAO */
    public bankDBAO() {
    }
    
    public List getBanklist(){
        EntityManager em = getEntityManager();        
        alBank = new ArrayList<SelectItem>();
        List l =  em.createQuery("SELECT t FROM bank as t ").getResultList();        
        Iterator itr = l.iterator();        
        while(itr.hasNext()){
            bank bnk = (bank) itr.next();              
            BankItem = new SelectItem(new Integer(bnk.getId()),bnk.getBank());
            alBank.add(BankItem);            
        }
        return alBank;
    }         
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }        
}
