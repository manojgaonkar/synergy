/*
 * indentDBAO.java
 *
 * Created on February 4, 2009, 11:11 AM
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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import mktg.backingBean.Calculation;
import mktg.backingBean.indentCart;

/**
 *
 * @author MD
 */
public class indentDBAO {
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;  
    
//    @Resource javax.sql.DataSource d;
    
    private int RouteID;              
    private int ProdID;
    private int customerID;
    private int Limit_row ;    
    private int Size ;    
    
    private String customerName;
    
    private Date idate;
    private Date Trdate;
       
    private indent indent;
   
    private boolean NEXT;    
    boolean blnShow = true;
    
    private SelectItem customerItems;
    private SelectItem prodItems;
    
    private ArrayList<SelectItem> alCustomerList;    
    private ArrayList<SelectItem> alProductList;                
    
    private HashMap<Integer,String> hmMilk ;    
    private HashMap<Integer,Double> hmRate;
    private HashMap<Integer,Double> hmComm;
    private HashMap<Integer,Double> hmTax;
    private HashMap<Integer,Double> hmCst;
    private HashMap<Integer,Double> hmCess;        
    private HashMap<Integer,Double> hmTcd;
    //private HashMap<Integer,Double> hmsplrate;
    
    private HashMap<Long,Integer> hmCustomerType;    
    private HashMap<Long,String> hmCustomer;    
    private HashMap<Long,String> hmCaCr;
    private HashMap<Long,Integer> hmTaluka;
    
    private double Quantity;
    private double rate;    
    private double comm;
    private double tax;
    private double cst;
    private double cess;
    private double tcd;
    //private double splrate;
    
    indentCart ic = new indentCart();
    Calculation calc = new Calculation();
      
    /** Creates a new instance of indentDBAO */
    public indentDBAO() {             
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  
    
   public List getCustomerlist(){        
        EntityManager em = getEntityManager();                    

        FacesContext fc = FacesContext.getCurrentInstance();
            RouteID = Integer.parseInt(fc.getExternalContext().
            getSessionMap().
            get(new String("RouteID")).toString()); 
        
  
        alCustomerList = new ArrayList<SelectItem>();
        
        hmCustomer = new HashMap<Long,String>();        
        hmCaCr = new HashMap<Long,String>();        
        hmTaluka = new HashMap<Long,Integer>();
        hmCustomerType = new HashMap<Long,Integer>();
        
        List l = em.createQuery("SELECT object(o)FROM customer o " +
                " " +                           
                "WHERE o.route = :ROUTEID " +
                "ORDER BY o.firstname ")
                .setParameter("ROUTEID",new Integer(RouteID))
                .getResultList();       
        
        Iterator itr = l.iterator();                
        while(itr.hasNext()){
            customer cst = (customer) itr.next();              
            
            customerItems = new SelectItem(new Long(cst.getId()),cst.getfirstname());
            
            hmCustomer.put(new Long(cst.getId()),cst.getfirstname());
          
            hmCaCr.put(new Long(cst.getId()),cst.getcacr());
            
            hmTaluka.put(new Long(cst.getId()),cst.getTaluka());
            
            hmCustomerType.put(new Long(cst.getId()),cst.getcusttype());
            
            alCustomerList.add(customerItems);            
        }                
        return alCustomerList;
    }        
       
    public List getProductList(){
        EntityManager em = getEntityManager();                                      
        alProductList = new ArrayList<SelectItem>();
        hmMilk = new HashMap<Integer,String>();
        hmRate = new HashMap<Integer,Double>();
        hmComm = new HashMap<Integer,Double>();
        hmTax = new HashMap<Integer,Double>();
        hmCst = new HashMap<Integer,Double>();
        hmCess = new HashMap<Integer,Double>();
        hmTcd = new HashMap<Integer,Double>();
//        hmsplrate = new HashMap<Integer,Double>();
                        
        List l = em.createQuery("SELECT object(o)FROM product o " +        
                "WHERE o.stateid = :StateId " +
                "ORDER BY o.layoutno ")
                .setParameter(new String("StateId"),new Integer(1))                
                .getResultList();
        
        Iterator itr = l.iterator();                
        while(itr.hasNext()){
            product prod = (product) itr.next();              
            prodItems = new SelectItem(new Long(prod.getId()),prod.getproduct());
            hmMilk.put(new Integer(prod.getId()),prod.getproduct());
            hmRate.put(new Integer(prod.getId()),prod.getrate());
            hmComm.put(new Integer(prod.getId()),prod.getcommission());
            hmTax.put(new Integer(prod.getId()),prod.gettax());
            hmCst.put(new Integer(prod.getId()),prod.getcst());
            hmCess.put(new Integer(prod.getId()),prod.getcess());
            hmTcd.put(new Integer(prod.getId()),prod.gettcd());
//            hmsplrate.put(new Integer(prod.getId()),prod.getsplrate());
            alProductList.add(prodItems);            
        }                
        return alProductList;
    }       
    
//    public List getProductItems(){
//        EntityManager em = getEntityManager();                              
//        List l = em.createQuery("SELECT object(o)FROM product o " +        
//            "WHERE o.stateid = :StateId " +
//            "ORDER BY o.layoutno ")
//            .setParameter(new String("StateId"),new Integer(1))                
//            .getResultList();                              
//        return l;
//    }  
    
    
    public String createSetup() {    
//        this.indent = new indent();
        return "route_create";
    }  
    
    public void setindent(indent indent){
        this.indent = indent;
    }
    
    public indent getindent(){
        return this.indent; 
    }

    public String create(){
        EntityManager em = null;            
        try {      
            Iterator itr = ic.alIC().iterator();
            while(itr.hasNext()){
                em = getEntityManager();         
                utx.begin();
                em.joinTransaction();                           
                em.persist(itr.next());                                    
                utx.commit();                                                                           
            }   
            this.blnShow = true;   
            Refresh();
            addSuccessMessage("indent was successfully created."); 
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
        return "indent_add";                
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
    
    public void processCustomerValueEvent(ValueChangeEvent e){
        if(e.getNewValue() != null){
            customerID = Integer.parseInt(e.getNewValue().toString());
            customerName = hmCustomer.get(new Long(customerID));
        }
    }
          
    public void RemoveItem(ActionEvent ae){      
        ic.RemoveItem();
    }
    
    public void setQuantity(double Quantity){
        this.Quantity = Quantity;
    }
    
    public double getQuantity(){
        return this.Quantity;
    }
        
    public List getList(){
        return this.ic.alIC();
    }
        
    public void setblnShow(boolean blnShow){
        this.blnShow = blnShow;
    }
    
    public boolean getblnShow(){
        return this.blnShow;
    }    
    
    public void processProductsEvent(ValueChangeEvent e){ 
        if(e.getNewValue() != null){          
            ProdID = Integer.parseInt(e.getNewValue().toString());
            rate = hmRate.get(new Integer(ProdID));
            comm = hmComm.get(new Integer(ProdID));
            tax = hmTax.get(new Integer(ProdID));
            cst = hmCst.get(new Integer(ProdID));
            cess = hmCess.get(new Integer(ProdID));
            tcd = hmTcd.get(new Integer(ProdID));
//            splrate = hmsplrate.get(new Integer(ProdID));
        }
    }
    
    public void setidate(Date idate){
        this.idate = idate;
    }
    
    public Date getidate(){
        return this.idate;
    }
    
    public void setcustomerID(int customerID){
        this.customerID = customerID;
    }
    
    public int getcustomerID(){
        return this.customerID;
    }
    
    public void setcustomerName(String customerName){
        this.customerName = customerName;
    }
    
    public String getcustomerName(){
        return this.customerName;
    }
    
    public void setrate(double rate){
        this.rate = rate;
    }
    
    public double getrate(){
        return this.rate;
    }
    
    public void init(ActionEvent e){
        Limit_row = 0;
    }   
    
    public void processNextPageActionEvent(ActionEvent e){        
        Limit_row = Limit_row + 10;
//        System.out.println(" NEXT " + Limit_row );
    }
    
    public void processPrevPageActionEvent(ActionEvent e){        
        if(Limit_row <= 10)
            Limit_row = 0 ;
        else
            Limit_row = Limit_row - 10;        
//         System.out.println(" PREVIOUS " + Limit_row );
    }    
    
    public void processFirstPageActionEvent(ActionEvent e){
        Limit_row = 0;
    }    
    
    public void processLastPageActionEvent(ActionEvent e){
        Limit_row = Limit_row + 10;
    }    
          
    public boolean getNext(){
        if(Size < 10)
            return false;
        else
            return true;
    }
    
    public boolean getPrevious(){        
        if(Limit_row <=0)
            return false;
        else
            return true;        
    }
        
    public void processValueChangeEvent(ValueChangeEvent e){
        RouteID = Integer.parseInt(e.getNewValue().toString());        
    }    
            
    public List getIndentList(){
        EntityManager em = getEntityManager();                              
        List l = em.createQuery("SELECT object(o)FROM indent o " +        
            "WHERE o.route = :routeid AND o.idate = :idate " +
            "ORDER BY o.customer ")           
            .setParameter(new String("routeid"),new Integer(RouteID))                
            .setParameter("idate",getTrdate())
            .getResultList();            
        return l;
    }
    
    public void setTrdate(Date Trdate){
        this.Trdate = Trdate;
    }
    
    public Date getTrdate(){
        return this.Trdate;
    }
        
    public void Refresh(){
        this.ic.ClearList();
        this.setQuantity(0.00);
//        this.setTrdate(null);        
        this.setcustomerName("");
        this.setcustomerID(0);  
        this.indent = null;
    }   
    
    public void RemoveItem_1(ActionEvent a){
        ic.RemoveItem_1();
    }
    
  public void AddItem(ActionEvent ae){      
        this.blnShow = false;        
//        System.out.println("Quantity : "+ getQuantity());
        if(getQuantity() > 0){
            this.indent = new indent();
            this.indent.setIdate(getTrdate());            
            this.indent.setcustomer(customerID);
            this.indent.setcustname(getcustomerName());            
            this.indent.setproduct(ProdID);  
            this.indent.setprodname((String) hmMilk.get(new Integer(ProdID)));
            calc.calc(getQuantity(),getrate(),this.comm,this.tax,this.cst,this.cess,this.tcd,0);
            this.indent.setquantity(getQuantity());  
            this.indent.setnetqty(getQuantity());  
            this.indent.setrate(getrate());
            this.indent.setamount(calc.getamount());
            this.indent.settax(this.tax);
            this.indent.settaxamt(calc.gettaxamt());
            this.indent.setcst(this.cst);
            this.indent.setcstamt(calc.getcstamt());
            this.indent.setcess(this.cess);
            this.indent.setcessamt(calc.getcessamt());
            this.indent.setcommi(this.comm);
            this.indent.setcommiamt(calc.getcommi());
            this.indent.settcd(this.tcd);
            this.indent.settcdamt(calc.gettcdamt());
            
//            this.indent.setsplrate(this.splrate);
//            this.indent.setsplrateamt(calc.getsplrateamt());
            
            
            this.indent.setnetamount(calc.getnetamt());            
            this.indent.setroute(RouteID);            
            this.indent.settaluka(hmTaluka.get(new Long(customerID)));
            this.indent.setcacr(hmCaCr.get(new Long(customerID)));                        
            ic.AddItem(this.indent);
        }        
    }      
}
