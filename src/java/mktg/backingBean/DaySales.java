/*
 * DaySales.java
 *
 * Created on May 28, 2009, 5:22 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mktg.backingBean;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 */
public class DaySales {
    
    /** Creates a new instance of DaySales */
    
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;   
        
    private EntityManager em;
    
    private Date date;
    private double TotalQty;    
    
    private HashMap<String,ClsDaySales> MilkQty = new HashMap<String,ClsDaySales>();
    private HashMap<String,ClsDaySales> ProdQty = new HashMap<String,ClsDaySales>();
    private Utility utl = new Utility();
    
    private EntityManager getEntityManager() {
        return em = emf.createEntityManager();        
    }
    
    public DaySales() {        
        date = new Date();
    }
    
    public Date getdate(){
        return this.date;
    }    
    public void setdate(Date date){
        this.date = date;
    }    
    public double getTotalQty(){
        return this.TotalQty;
    }   
    public void setTotalQty(double TotalQty){
        this.TotalQty = TotalQty;
    }
        
    public void processActionEvent(ActionEvent ae){  
        DaySales();        
    }
    
    public void setMilkQty(HashMap MilkQty){
        this.MilkQty = MilkQty;
    }
    
    public HashMap getMilkQty(){
        return this.MilkQty;
    }
    
    public void setProdQty(HashMap ProdQty){
        this.ProdQty = ProdQty;
    }
    
    public HashMap getProdQty(){
        return this.ProdQty;
    }    
    
    private synchronized void DaySales(){
        double tq = 0.00;
        double mtq = 0.00;
        double demand = 0.00;
        double leakage = 0.00;
        double retn = 0;
        this.setTotalQty(0.00);
        this.MilkQty.clear();
        this.ProdQty.clear();
        
        Date mdate = utl.ChangeToDate(utl.ToDate(this.getdate()));
        EntityManager em = getEntityManager();
        try{                                
            Query q = em.createQuery("SELECT object(o) FROM indent o " +
                    " WHERE o.idate =:MDATE  " +
                    " ORDER BY o.product ");
            q.setParameter("MDATE",mdate);
            List l = q.getResultList();
                        
            Iterator itr = l.iterator();
                        
            while(itr.hasNext()){
                indent indt = (indent) itr.next();                
                switch(indt.getprodtype()){
                    case 1:                        
                        tq = tq + indt.getnetqty();                        
                        if(this.MilkQty.containsKey(indt.getprodname())){                            
                            ClsDaySales dsQty = MilkQty.get(indt.getprodname());                            
                            mtq = indt.getnetqty();
                            demand = indt.getdemand() + dsQty.getdemand();                                                        
                            mtq = mtq + dsQty.getsales();       
                            leakage = indt.getleakage() + dsQty.getleakage();
                            retn = indt.getreturnmilk() + dsQty.getretn();                          
                            dsQty.setdemand(demand);
                            dsQty.setsales(mtq);  
                            dsQty.setleakage(leakage);
                            dsQty.setretn(retn);                            
                            this.MilkQty.put(indt.getprodname(),dsQty);                            
                        }else{
                            ClsDaySales ds = new ClsDaySales();
                            demand = 0.00;
                            mtq = 0.00;                   
                            leakage = 0.00;
                            retn = 0.00;
                            mtq = indt.getnetqty();
                            demand =  indt.getdemand();
                            leakage =  indt.getleakage();
                            retn = indt.getreturnmilk();
                            ds.setproduct(indt.getprodname());
                            ds.setdemand(demand);
                            ds.setsales(mtq);
                            ds.setleakage(leakage);
                            ds.setretn(retn);
                            this.MilkQty.put(indt.getprodname(),ds);                                        
                        }                            
                        break;
                    case 2:
                        if(this.ProdQty.containsKey(indt.getprodname())){                            
                            ClsDaySales dsQty = ProdQty.get(indt.getprodname());                            
                            mtq = indt.getnetqty();
                            demand = indt.getdemand() + dsQty.getdemand();                                                        
                            leakage = indt.getleakage() + dsQty.getleakage();
                            retn = indt.getreturnmilk() + dsQty.getretn();                            
                            mtq = mtq + dsQty.getsales();                                                       
                            dsQty.setdemand(demand);
                            dsQty.setsales(mtq);                                                        
                            dsQty.setleakage(leakage);
                            dsQty.setretn(retn);
                            this.ProdQty.put(indt.getprodname(),dsQty);
                        }else{
                            ClsDaySales ds = new ClsDaySales();
                            demand = 0.00;
                            mtq = 0.00;   
                            leakage = 0.00;
                            retn = 0.00;                            
                            mtq =  indt.getnetqty();
                            demand = indt.getdemand();
                            leakage = indt.getleakage();
                            retn = retn + indt.getreturnmilk();
                            ds.setproduct(indt.getprodname());
                            ds.setdemand(demand);
                            ds.setsales(mtq);                                                        
                            ds.setleakage(leakage);
                            ds.setretn(retn);
                            this.ProdQty.put(indt.getprodname(),ds);
                        }                               
                    break;
                }
            }            
            this.setTotalQty(tq);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }        
    }
        
}
