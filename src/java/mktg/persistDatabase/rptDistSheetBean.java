/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mktg.persistDatabase;

import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import mktg.utility.Utility;
import net.sf.jasperreports.engine.JasperRunManager;
import serv.ConnectionPool;

/**
 *      mktg.persistDatabase.rptDistSheetBean
 * @author xp
 */
public class rptDistSheetBean {

    @Resource
    private UserTransaction utx;
    
    private ArrayList<SelectItem> alCustomer;
    
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;
    
    private Integer routeId = new Integer(0);
    private String customer ="";
    
    private Date date = new Date();
    
    private Utility utl = new Utility();
    
    private boolean blnRenderer = false;
 
    public Date getdate(){
//        return this.date;
//        System.out.println(utl.ToDate(date));
//        System.out.println(utl.NextDayDate(utl.ChangeFormat(utl.ToDate(date))));
        return utl.NextDayDate(utl.ChangeFormat(utl.ToDate(date)));
    }
//    public void setdate(Date date){
//        this.date = utl.NextDayDate(utl.ChangeFormat(utl.ToDate(date))); //date;
//    }
    
    private EntityManager getEntityManager()  {
        return emf.createEntityManager();
    }  
    
    public Integer getrouteId(){
        return this.routeId;
    }
    public void setrouteId(Integer routeId){
        this.routeId = routeId;
    }
    
    public String getcustomer(){
        return this.customer;
    }
    public void setcustomer(String customer){
        this.customer = customer;
    }
    
    public List getCustomerList(){
        
//   sqlStr = "SELECT customer.id 'id',customer.firstname 'name' " +
//                "FROM customer " +
//                "WHERE customer.route = " + hmRouteList.get(jCmbRoute.getSelectedItem()) + 
//                " AND customer.custtype != 1 ";        
        
        EntityManager em = getEntityManager();        
        alCustomer = new ArrayList<SelectItem>();
        try{
            List l =  em.createQuery("SELECT object(c)FROM customer c " +        
                "WHERE c.custtype <> 1  " +
                    " AND c.route = :ROUTEID")
                    .setParameter("ROUTEID", this.routeId.intValue())
                    .getResultList();        
            Iterator itr = l.iterator();        
            while(itr.hasNext()){
                customer c = (customer) itr.next();              
                SelectItem si = new SelectItem(c.getfirstname(),c.getfirstname());
                alCustomer.add(si);    
            }
        }catch(Exception e){    
            e.printStackTrace();
        }finally{
            em.close();
        }        
        return alCustomer;            
   }   
    
    
    public void dispReport(ActionEvent ae){
        ConnectionPool cp = new ConnectionPool();
        Connection con = cp.getconnection();

        HttpServletRequest request ;
        HttpServletResponse response;        
        
        InputStream is = null;
        String filename = "/WEB-INF/report/report/template/rptDistributionSheet_n1.jasper";        
        try {
            is = FacesContext.getCurrentInstance().getExternalContext()
                    .getResourceAsStream(filename);

            FacesContext fc = FacesContext.getCurrentInstance();
            
           
            request = (HttpServletRequest) fc.getExternalContext().getRequest();
            
            response = (HttpServletResponse) fc.getExternalContext().getResponse();
            
            HashMap params = new HashMap();
            params.put("m_route",new Long(this.routeId.longValue()));
//            System.out.println("DATE " + getdate().toString());
            params.put("m_date",new String(utl.ChangeFormat(getdate())));
            params.put("ContSales",new String(getcustomer()));
       
//            System.out.println(request.getParameter("n"));
            byte buffer[] =  JasperRunManager.runReportToPdf(is, params, con);
            
            response.setBufferSize(1024);
            response.setContentType("application/pdf");
            
            ServletOutputStream os = response.getOutputStream();
            os.write(buffer);
            os.flush();
            fc.responseComplete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }                        
    }
    
    public void processValueChangeListener(ValueChangeEvent ve){
        if(ve.getNewValue() != null){
            blnRenderer = false;
            this.routeId = Integer.parseInt(ve.getNewValue().toString());
            
            if(this.routeId > 0)
                blnRenderer = true;    
        }
    }
    
    public Boolean getblnRenderer(){
        return this.blnRenderer;
    }
}
