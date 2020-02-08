/*
 * entystateDBAO.java
 *
 * Created on January 29, 2009, 11:06 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

import java.util.ArrayList;
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
public class entystateDBAO {
    
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;        
    
    /** Creates a new instance of entystateDBAO */
    private SelectItem StateItems;
    
    private String lblState;
    private int stateID;
    
    private ArrayList<SelectItem> alStateList;
    private HashMap<Integer,String> hmState = new HashMap<Integer,String>();
    
    public entystateDBAO() {
    }
    
    public List getStatelist(){
        EntityManager em = getEntityManager();        
        alStateList = new ArrayList<SelectItem>();
        List l =  em.createQuery("SELECT t FROM entystate as t ").getResultList();        
        Iterator itr = l.iterator();        
        while(itr.hasNext()){
            entystate es = (entystate) itr.next();              
            StateItems = new SelectItem(new Long(es.getId()),es.getstatename());
            hmState.put(es.getId(),es.getstatename());
            alStateList.add(StateItems);            
        }
        return alStateList;
    }          
        
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }   
    
    public void processValueChangeListener(ValueChangeEvent event){
        if(event.getNewValue() != null){
            stateID = Integer.parseInt(event.getNewValue().toString());
            FacesContext.getCurrentInstance().
                getExternalContext().
                getSessionMap().
                put("stateID",stateID);
        }
    }
    
    public String getlblState(){    
        return this.hmState.get(stateID).toString();
    }
    
}
