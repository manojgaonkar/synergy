/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mktg.backingBean;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import mktg.persistDatabase.customer;
import mktg.persistDatabase.customerDBAO;
import mktg.persistDatabase.indent;
import mktg.persistDatabase.product;
import mktg.persistDatabase.route;
import mktg.utility.Utility;


/**
 *
 * @author xp mktg.backingBean.refreshIndent
 */
public class refreshIndent {
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;      
    private EntityManager em;
    
    private Date indentDate = new Date();
        
    private Integer routeId = 0;    
    private Integer stateId = 1;
    
    private Utility utl = new Utility();
    
    private HashMap<Long,customer> mapCustomer = new HashMap<Long,customer>();
    private HashMap<String,product> mapProduct = new HashMap<String,product>();
    
    private HashMap<Integer,indent> mapIndent = new HashMap<Integer,indent>();
    
    private customerDBAO Obj = new customerDBAO();

    private Boolean disable;
    
    public void setdisable(Boolean disable){
        this.disable = disable;
    }
    public Boolean getdisable(){
        return this.disable;
    }
    
    public Date getindentDate(){
        return this.indentDate;
    }
    public void setindentDate(Date indentDate){
        this.indentDate = indentDate;
    }
      
    public Integer getrouteId(){
        return this.routeId;
    }
    public void setRouteId(Integer routeId){     
        this.routeId = routeId;
    }
    
    public void processActionEvent(ActionEvent ae){
        if(this.routeId > 0){                             
            setdisable(true);
            getCustomerRouteList();
            getProductList();
            getIndentList();
            try{
                Set s = mapIndent.entrySet();
                Iterator itr = s.iterator();
                while(itr.hasNext()){
                    Map.Entry me = (Map.Entry) itr.next();
                    indent Obj = (indent) me.getValue();
                    int pID = Obj.getId();
                    
//                    System.out.println(((customer)mapCustomer.get(new Long(Obj.getcustomer()))));
//                    int pTaluka = ((customer)mapCustomer.get(new Long(Obj.getcustomer()))).getTaluka();
//                    int pRoute = ((customer)mapCustomer.get(new Long(Obj.getcustomer()))).getRoute();                 
//                    System.out.println("Name "+((customer)mapCustomer.get(new Long(Obj.getcustomer()))).getfirstname()+"Route "+((customer)mapCustomer.get(new Long(Obj.getcustomer()))).getRoute());
                    int pProduct = ((product)mapProduct.get(Obj.getprodname())).getId();
                    int pProductType = ((product)mapProduct.get(Obj.getprodname())).getprodtype(); 
                    update_Record(
//                            pRoute,
                        pProduct,
//                        pTaluka,
                        pProductType,
                        pID);            
                }        

            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            FacesContext.getCurrentInstance()
            .addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "SELECT ROUTE ","rl"));            
        }
    }
    
    private void update_Record(int pProduct,
            int pProductType,int pID){       
        try{
            em = getEntityManager();
            utx.begin();
            em.joinTransaction();              
            Query  query = em.createQuery("UPDATE indent AS i " +
//                "SET i.route =:pROUTE," +
                "SET i.product =:pPRODUCT," +
//                "i.taluka =:pTALUKA," +
                "i.prodtype =:pPRODUCTTYPE " +
                "WHERE i.idate =:IDATE " +
                "AND i.id =:ID");
//            query.setParameter("pROUTE", new Integer(pRoute));
            query.setParameter("pPRODUCT", new Integer(pProduct));
//            query.setParameter("pTALUKA", new Integer(pTaluka));
            query.setParameter("pPRODUCTTYPE", new Integer(pProductType));
            query.setParameter("IDATE",indentDate);
            query.setParameter("ID",new Long(pID));
            int resultValue = query.executeUpdate();
            utx.commit();
//            System.out.println("Return Value : " +resultValue);
        }catch(Exception e){
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (IllegalStateException ex) {
                Logger.getLogger(refreshIndent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException ex) {
                Logger.getLogger(refreshIndent.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(refreshIndent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            em.close();
        }        
    }
    
    
    private synchronized void getIndentList(){
        mapIndent.clear();
        List l = null;
        try{            
            em = getEntityManager();                                      
            l = em.createQuery("SELECT object(o)FROM indent o " +        
                "WHERE o.reclock = false " +
                "AND o.route = :ROUTEID " +
                "AND o.idate =:IDATE " +
                "AND o.custtype = 1" +
                "ORDER BY o.custname ")
                .setParameter("ROUTEID",routeId)
                .setParameter("IDATE",indentDate)
                .getResultList();  
            Iterator itr = l.iterator();        
            while(itr.hasNext()){
                indent obj = (indent) itr.next();
                mapIndent.put(obj.getId(), obj);
            }        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
    }
  
    public EntityManager getEntityManager(){
        return this.emf.createEntityManager();
    }
    
    public synchronized void getCustomerRouteList(){ 
        mapCustomer.clear();
        List l = null;
        try{            
            em = getEntityManager();                                      
            l = em.createQuery("SELECT object(o)FROM customer o " +        
                "WHERE o.route = :ROUTEID " +
                "ORDER BY o.firstname ")
                .setParameter("ROUTEID",routeId)
                .getResultList();  
            Iterator itr = l.iterator();        
            while(itr.hasNext()){
                customer Obj = (customer) itr.next();
                mapCustomer.put(Obj.getId(),Obj);
            }        
        }catch(Exception e){
        }finally{
            em.close();
        }
    }      
    
    public synchronized void getProductList(){ 
        mapProduct.clear();
        List l = null;
        try{            
            em = getEntityManager();                                      
            l = em.createQuery("SELECT object(p)FROM product p " +        
                "WHERE p.stateid = :STATEID ")
                .setParameter("STATEID",stateId)
                .getResultList();  
            Iterator itr = l.iterator();
            while(itr.hasNext()){
                product Obj = (product) itr.next();
                mapProduct.put(Obj.getproduct(),Obj);
            }        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
    }   
    
    public void setstateId(Integer stateId){
        this.stateId = stateId;
    }
    
    public Integer getstateId(){
        return this.stateId;
    }
    
    public List getRoute(){
        ArrayList alRoute = null;
        try{            
            em = getEntityManager();        
            alRoute = new ArrayList<SelectItem>();
            List l =  em.createQuery("SELECT t FROM route as t " +
                "where t.stateid =:STATEID " +
                "AND t.saletype = 1 ")        
                .setParameter("STATEID", stateId)
                .getResultList();        
            Iterator itr = l.iterator();  
            SelectItem RouteItem = new SelectItem(new Long(0),
                    "Select-Route");        
            alRoute.add(RouteItem);         
            while(itr.hasNext()){
                route rt = (route) itr.next();              
                RouteItem = new SelectItem(new Long(rt.getId()),
                        rt.getRoute());
                alRoute.add(RouteItem);    
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            em.close();
        }
        return alRoute;            
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
    
    
}
