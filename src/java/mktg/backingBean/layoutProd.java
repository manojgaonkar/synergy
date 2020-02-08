/*
 * layoutProd.java
 *
 * Created on March 30, 2009, 5:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import mktg.persistDatabase.product;

/**
 *
 * @author MD
 */
public class layoutProd {
    
    /** Creates a new instance of layoutProd */
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;   
    
    
    private SelectItem actprodItems;
    private ArrayList<SelectItem> alactprodList;
    
    private SelectItem deactprodItems;
    private ArrayList<SelectItem> aldeactprodList;
    
    private Hashtable<Integer,Integer> htLayoutNo = new Hashtable<Integer,Integer>();
    private Hashtable<Integer,Integer> htProdctNo = new Hashtable<Integer,Integer>();
   
    private int prod_ID1;
    
    private int prod_ID0;

    private int sid;
                
    public layoutProd() {        
        
    }
    
    public List getactProductList(){
       
        sid = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stateID").toString());

        EntityManager em = getEntityManager();           
        alactprodList = new ArrayList<SelectItem>();        
        List l = em.createQuery("SELECT prod  " +
                "FROM product prod " +                      
                "WHERE prod.stateid = :STATEID " +
                "AND prod.status = 1 " +
                "ORDER BY prod.layoutno ")
                .setParameter("STATEID",new Integer(sid))
                .getResultList();  
        
        Iterator itr = l.iterator();                
        while(itr.hasNext()){
            product p = (product) itr.next();  
            htLayoutNo.put(p.getId().intValue(),p.getlayoutno());
            htProdctNo.put(p.getlayoutno(),p.getId().intValue()); 
            
            actprodItems = new SelectItem(p.getId().intValue(),p.getproduct(),"");
            
            alactprodList.add(actprodItems);            
        }                
        return alactprodList;        
    }    
    
   public List getDeactProductList(){
        
        sid = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stateID").toString());
                        
        EntityManager em = getEntityManager();   
        
        aldeactprodList = new ArrayList<SelectItem>();
       
        List l = em.createQuery("SELECT prod  " +
                "FROM product prod " +                    
                "WHERE prod.stateid = :STATEID " +
                "AND prod.status = 0 " +
                "ORDER BY prod.layoutno ")
                .setParameter("STATEID",new Integer(sid))
                .getResultList();          
        
        Iterator itr = l.iterator();                
        
        while(itr.hasNext()){
      
            product p = (product) itr.next();              
            deactprodItems = new SelectItem(p.getId().intValue(),p.getproduct(),"");
            aldeactprodList.add(deactprodItems);            
        }                
        return aldeactprodList;        
    }                
    
    public void UpArrowActionEvent(ActionEvent e){
        
        try {            
            if(prod_ID1 > 0 ){
                
                 EntityManager em = getEntityManager();
                 utx.begin();
                         
                 em.joinTransaction();                  
                 int m_layout = htLayoutNo.get(prod_ID1).intValue() ;
                 
                 if(m_layout > 0 && htProdctNo.containsKey(m_layout - 1)){                

                     int prod_ID_1 = htProdctNo.get(m_layout - 1);                        
                     m_layout = m_layout - 1;                     
                     Query qry = em.createQuery("UPDATE product as p " +
                        "SET p.layoutno = :Mlayoutno " +
                        "WHERE p.id = :Mid ");

                      qry.setParameter("Mlayoutno",new Integer(m_layout));  
                      qry.setParameter("Mid",new Integer(prod_ID1));                

                      m_layout = m_layout + 1;
                      
                      Query qry1 = em.createQuery("UPDATE product as p " +
                        "SET p.layoutno = :Mlayoutno " +
                        "WHERE p.id = :Mid ");

                      qry1.setParameter("Mlayoutno",new Integer(m_layout));  
                      qry1.setParameter("Mid",new Integer(prod_ID_1));  
                      
                      qry.executeUpdate();
                      qry1.executeUpdate();
                      utx.commit();                                              
                 }
            }              
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        } catch (HeuristicRollbackException ex) {
            ex.printStackTrace();
        } catch (HeuristicMixedException ex) {
            ex.printStackTrace();
        } catch (RollbackException ex) {
            ex.printStackTrace();
        } catch (NotSupportedException ex) {
            ex.printStackTrace();
        }              
    }
    
    
    public void DownArrowActionEvent(ActionEvent e){        
        try {            
            if(prod_ID1 > 0 ){                
                 EntityManager em = getEntityManager();
                 utx.begin();                         
                 em.joinTransaction();                  

                 int m_layout = htLayoutNo.get(prod_ID1).intValue() ;

                 if(m_layout > 0 && htProdctNo.containsKey(m_layout + 1)){
//                 if(htProdctNo.containsKey(m_layout + 1)){
                     int prod_ID_1 = htProdctNo.get(m_layout + 1);   
                     
                     
                     m_layout = m_layout + 1;
                     System.out.println("After Addition " + m_layout);
                     
                     Query qry = em.createQuery("UPDATE product as p " +
                        "SET p.layoutno = :Mlayoutno " +
                        "WHERE p.id = :Mid ");

                      qry.setParameter("Mlayoutno",new Integer(m_layout));  

                      qry.setParameter("Mid",new Integer(prod_ID1));                

                      m_layout = m_layout - 1;
                      System.out.println("After Substraction " + m_layout);
                      
                      Query qry1 = em.createQuery("UPDATE product as p " +
                        "SET p.layoutno = :Mlayoutno " +
                        "WHERE p.id = :Mid ");

                      qry1.setParameter("Mlayoutno",new Integer(m_layout));  
                      qry1.setParameter("Mid",new Integer(prod_ID_1));  
                      
                      qry.executeUpdate();
                      qry1.executeUpdate();

                      utx.commit();                                              
                 }
            }              
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        } catch (HeuristicRollbackException ex) {
            ex.printStackTrace();
        } catch (HeuristicMixedException ex) {
            ex.printStackTrace();
        } catch (RollbackException ex) {
            ex.printStackTrace();
        } catch (NotSupportedException ex) {
            ex.printStackTrace();
        }        
    }
    
    
    public void RightArrowActionEvent(ActionEvent e){        
        try {            
            if(prod_ID1 > 0 ){                
                 EntityManager em = getEntityManager();

                 utx.begin();                         

                 em.joinTransaction();                  

                 Query qry = em.createQuery("UPDATE product as p " +
                    "SET p.status = false " +
                    "WHERE p.id = :Mid ");
                  qry.setParameter("Mid",new Integer(prod_ID1));                
                  qry.executeUpdate();
                  utx.commit();                                              
                 }
            } catch (Exception ex) {
                ex.printStackTrace();              
            }        
            updateLayoutNo();
    }
    
    
    public void LeftArrowActionEvent(ActionEvent e){        
        try {            
            if(prod_ID0 > 0 ){                
                 EntityManager em = getEntityManager();

                 utx.begin();                         

                 em.joinTransaction();                  

                 Query qry = em.createQuery("UPDATE product as p " +
                    "SET p.status = true " +
                    "WHERE p.id = :Mid ");
                  qry.setParameter("Mid",new Integer(prod_ID0));                
                  qry.executeUpdate();
                  utx.commit();                                              
             }
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (IllegalStateException ex1) {
            } catch (SecurityException ex2) {
            } catch (SystemException ex3) {
            }
            ex.printStackTrace();                          
        }        
        updateLayoutNo();
    }    
    
    public void processValueChangeEvent1(ValueChangeEvent event){                
        if(event.getNewValue() != null)
            prod_ID1 = Integer.parseInt(event.getNewValue().toString());
    }    
           
   public void processValueChangeEvent0(ValueChangeEvent event){                
        if(event.getNewValue() != null)
            prod_ID0 = Integer.parseInt(event.getNewValue().toString());
    }    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }         
        
    
//    public void updateLayoutNo(ActionEvent e){
    public void updateLayoutNo(){    
        int i = 1;        
        try {                    
             EntityManager em = getEntityManager();
             
             List l = em.createQuery("SELECT prod " +
                "FROM product prod " +                    
                "WHERE prod.stateid = :STATEID " +
                "AND prod.status = 1 " +
                "ORDER BY prod.layoutno ")
                .setParameter("STATEID",new Integer(2))
                .getResultList();          
             
                Iterator itr = l.iterator();                
                while(itr.hasNext()){                    
                     product prod = (product) itr.next();                     
                     x(prod.getId(),i);                     
                     i++;
                }                
        } catch (Exception ex) {
            ex.printStackTrace();              
        }                        
    }
    
    
    private void x(int prod,int lay){
 
        try {            
            
            EntityManager em = getEntityManager();
            
            utx.begin();                         
           
            em.joinTransaction();                              
        
            Query qry = em.createQuery("update product as p " +
                "SET p.layoutno = :Layoutno " +
                "WHERE p.id = :id");                     

            qry.setParameter("Layoutno",new Integer(lay));                
            qry.setParameter("id",new Integer(prod));                
            qry.executeUpdate();            

            utx.commit();               
            
        } catch (IllegalStateException ex) {
            ex.printStackTrace();
        } catch (SecurityException ex) {
            ex.printStackTrace();
        } catch (SystemException ex) {
            ex.printStackTrace();
        } catch (HeuristicRollbackException ex) {
            ex.printStackTrace();
        } catch (RollbackException ex) {
            ex.printStackTrace();
        } catch (HeuristicMixedException ex) {
            ex.printStackTrace();
        } catch (NotSupportedException ex) {
            ex.printStackTrace();
        }          
        
    }
   
}
