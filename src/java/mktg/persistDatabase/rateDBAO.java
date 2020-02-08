/*
 * rateDBAO.java
 *
 * Created on February 3, 2009, 2:19 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.persistDatabase;

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

/**
 *
 * @author MD
 */
public class rateDBAO {
    
    /** Creates a new instance of rateDBAO */
    
    private rate rate;
    private rate p;
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;        
    
    private ArrayList<SelectItem> alProductState ;
    
    private SelectItem ProductItemState;
    
    private boolean blnUpdateBtn = false;
    private boolean blnOk = true;
    
    private int StateId; 
            
    public rateDBAO() {        
    }
        
   private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }        
        
//    public String createSetup() {    
//        this.rate = new rate();
//        return "product_Update";
//    }         
    
//    public void serate(rate rate){
//        this.rate = rate;
//    }
//    
//    public rate getrate(){
//        return this.rate;
//    }
    
//  public void processUpdateRateEvent(){
//        this.blnUpdateBtn = false;           
//        EntityManager em = getEntityManager();                
//        p.setrate(rate.getrate());
//        p.settax(rate.gettax());
//        p.setcst(rate.getcst());
//        p.setcess(rate.getcess());        
//        try {
//            utx.begin();
//            em.joinTransaction();
//            em.merge(p);
//        //            Query qry = em.createQuery("delete from customer as c");
//        //            Query qry = em.createQuery("update customer AS c " +
//        //                    "SET c.firstname = 'xxxxxxxxxxxxxxxxxx'");
//        //            qry.executeUpdate();
//            utx.commit();
//            clearCompts();
//            addSuccessMessage("customer was successfully updated.");
//        } catch (Exception ex) {
//            try {
//                addErrorMessage(ex.getLocalizedMessage());
//                utx.rollback();
//            } catch (Exception e) {
//                addErrorMessage(e.getLocalizedMessage());
//            }
//        } finally {
//            em.close();
//        }                       
//    }
  
// public List getProductListState(){
//        EntityManager em = getEntityManager();        
//        alProductState = new ArrayList<SelectItem>();
//        List l =  em.createQuery("SELECT t FROM rate as t " +
//            "WHERE t.stateid = :StateId")
//            .setParameter(new String("StateId"),new Integer(StateId))
//            .getResultList();                
//        Iterator itr = l.iterator();        
//         if (l.size() > 0)
//            blnOk = true;
//        else
//            blnOk = false;
//        while(itr.hasNext()){
//            rate prod = (rate) itr.next();              
//            ProductItemState = new SelectItem(new Integer(prod.getId()),
//                    new String(""+prod.getprodid()));
//            alProductState.add(ProductItemState);              
//        }            
//        return alProductState;
//   }        
  
//   public static void addErrorMessage(String msg) {
//        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
//        FacesContext fc = FacesContext.getCurrentInstance();
//        fc.addMessage(null, facesMsg);
//     }
//
//    public static void addSuccessMessage(String msg) {
//        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
//        FacesContext fc = FacesContext.getCurrentInstance();
//        fc.addMessage("successInfo", facesMsg);
//    }           
    
//  public void setblnUpdateBtn(boolean blnUpdateBtn){
//        this.blnUpdateBtn = blnUpdateBtn;
//    }
//    
//    public boolean getblnUpdateBtn(){
//        return this.blnUpdateBtn;
//    }
    
//    public void getRateActionEvent(){
//        this.blnUpdateBtn = true;        
//        p = findProd();
//        rate.setrate(p.getrate());
//        rate.settax(p.gettax());
//        rate.setcst(p.getcst());
//        rate.setcess(p.getcess());
//    }    
//        
//    private rate findProd(){
//        EntityManager em = getEntityManager();   
//        try{
//            p = em.find(rate.class , new Integer(rate.getId()));               
//        }catch(IllegalStateException es){            
//        }catch(IllegalArgumentException ea){            
//        }
//        return p;
//    }    
    
//  public void setblnOk(boolean blnOk){
//        this.blnOk = blnOk;
//    }
//    
//    public boolean getblnOk(){
//        return this.blnOk;
//    }  
    
//     private void clearCompts(){
//        rate.setrate(0.00);
//        rate.settax(0.00);
//        rate.setcst(0.00);
//        rate.setcess(0.00);
//    }   
     
//    public void processValueChangeListener(ValueChangeEvent e){
//        if(e.getNewValue()!= null){
//            StateId = Integer.parseInt(e.getNewValue().toString());
//        }    
//    }     
       
}
