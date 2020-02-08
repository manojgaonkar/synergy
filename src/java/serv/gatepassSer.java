/*
 * IndentSer.java
 *
 * Created on February 9, 2009, 12:41 PM
 */

package serv;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;
import mktg.backingBean.Calculation;
import mktg.backingBean.gatepass;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class gatepassSer extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf; 
    
    private gatepass id;
    private indent indent;
    private Calculation calc = new Calculation();
    private Utility utl = new Utility();
    
    String product;
    int prodid;
    int prodtype;    
    long billno;
    int customerId = 0;
    
    double Qty ;
    double rate;
    double comm ;
    double tax ;
    double cst ;
    double cess;
    double tcd ; 
    double splrate ;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // TODO output your page here
                              
        HttpSession hs =  request.getSession();
        id = (gatepass) hs.getAttribute("gatepass");
        Date idate = utl.ChangeToDate(hs.getAttribute("idate").toString());
//        Date idate = utl.ChangeToDate("01.04.2008");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet IndentSer</title>");
        out.println("</head>");
        out.println("<body>");      
        
        HashMap hmQty = id.getqunatity();       
        customerId = 0;
        if(id.getcacr().compareTo("Cash") == 0){
            customerId = customerId();
        }else if(id.getcacr().compareTo("Credit") == 0){
            customerId = customerId();
        }else {
            
        }    
        if(id.getbillno() > 0 ){
            billno = id.getbillno();
            deleteRec();
        }else
            billno = billno();
        
        Set s = hmQty.entrySet(); 
        Iterator itr = s.iterator();                
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();
            Qty = (Double) me.getValue();            
            if(Qty > 0 ){
                this.product = (String) id.gethmProduct().get(me.getKey());
                this.prodid = (Integer) id.gethmprodid().get(me.getKey());
                this.prodtype = (Integer) id.gethmProdType().get(me.getKey());
                this.rate = (Double) id.gethmRate().get(me.getKey()); 
                this.comm = (Double) id.gethmComm().get(me.getKey()); 
                this.tax = (Double) id.gethmTax().get(me.getKey()); 
                this.cst = (Double) id.gethmCst().get(me.getKey()); 
                this.cess = (Double) id.gethmCess().get(me.getKey()); 
                this.tcd = (Double) id.gethmTcd().get(me.getKey());
                this.indent = new indent();
                this.indent.setbillno(billno);
                this.indent.setIdate(idate);            
//                this.indent.setcustomer(id.getcustid());
                this.indent.setcustomer(customerId > 0 ? customerId : 0);
                this.indent.setcustname(id.getfirstname());
                this.indent.setproduct(prodid);
                this.indent.setprodname(product);
                this.indent.setprodtype(prodtype);
                this.indent.setrtname(id.getrtname());
                if(id.getrouteid() == 16)
                    calc.TaxInvoice(this.Qty,this.rate,this.comm,this.tax,this.cst,this.cess,this.tcd);                          
                else
                    calc.calc(this.Qty,this.rate,this.comm,this.tax,this.cst,this.cess,this.tcd,id.getmdt());
                
                this.indent.setquantity(this.Qty);   
                this.indent.setnetqty(this.Qty);
                this.indent.setrate(this.rate);
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
                this.indent.setnetamount(calc.getnetamt());            
                this.indent.setroute(id.getrouteid());
                this.indent.settaluka(id.gettalid());   
                this.indent.setsaletype(2);
                this.indent.setentrytype(2);
                this.indent.setcacr(id.getcacr());
                if(id.getcacr().compareTo("Walkin") ==0 ){
                    this.indent.setcacr("Cash");    
                }
                this.indent.setratetype(id.getmdt());
                this.indent.setuser((String) hs.getAttribute("UserName"));
                this.indent.setrectimestamp(new Date().toString());
                appendRec(this.indent);
                calc.setamount(0.00);
                calc.setcessamt(0.00);
                calc.setcommi(0.00);
                calc.setcstamt(0.00);
                calc.setnetamt(0.00);
                calc.settaxamt(0.00);
                calc.settcdamt(0.00);
                this.Qty = 0.00;
            }
        }         
//        hs.setAttribute("gatepass",null);  
        id.reInit();
          out.println("<a href='indt/newGatepassCaCr.jsp'>Back</a>"); 
//        out.println("<a href='indt/newGatePass.jsp?blnCstIndt=false&blnNE=true&blnShow=false&blnCstData=false&blnShow=false&idate="+utl.ToDate(idate)+"'> Back</a>"); 
        out.println("</body>");                                             
        out.println("</html>");
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }     
        
    private synchronized void appendRec(indent indent){          
        EntityManager em = null;            
        try {      
            em = getEntityManager();         
            utx.begin();
            em.joinTransaction();                           
            em.persist(indent);                                    
            utx.commit();                                                                           
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception e1) {
            }
        } finally {
            em.close();
        }                          
    }
    
    private synchronized void deleteRec(){
      EntityManager em = null;            
        try {      
            em = getEntityManager();         
            utx.begin();
            em.joinTransaction();                           
            Query qry = em.createQuery("DELETE FROM indent " +
                                       "WHERE indent.billno =:BILLNO " +
                                       "AND indent.reclock =:RECLOCK ");
            qry.setParameter("BILLNO",new Long(billno));  
            qry.setParameter("RECLOCK",new Boolean(false));
            qry.executeUpdate();
            utx.commit();                                                                           
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception e1) {
            }
        } finally {
            em.close();
        }                           
    }
    
   private synchronized long billno(){
        long billno = 0;
        EntityManager em = getEntityManager();   
        
        List l = em.createQuery("SELECT distinct o.billno FROM indent o " +
//                "WHERE o.route = :r_id " +                             
                "WHERE o.saletype = 2 " +
                "ORDER BY o.billno DESC ")
             //   .setParameter("r_id",new Integer(id.getrouteid()))                
                .setMaxResults(1)
                .getResultList();               
        Iterator itr = l.iterator(); 
        if(itr.hasNext())
            billno = (Long) itr.next();
        
        return billno + 1;
   }
   
    private synchronized Integer customerId(){
        int customer = 0;
        EntityManager em = getEntityManager();   
        List l = em.createQuery("SELECT c.id " +
                "FROM customer c " +
                "WHERE c.firstname = :Customer ")                
                .setParameter("Customer",new String(id.getfirstname()))                
                .setMaxResults(1)
                .getResultList();               
        Iterator itr = l.iterator(); 
        if(itr.hasNext())
            customer =  Integer.parseInt(itr.next().toString());
        
        return customer;
   }   
   
}
