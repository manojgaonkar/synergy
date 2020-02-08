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
import mktg.backingBean.retnSheet_1;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class retnSheetSer_1 extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf; 
    
    private retnSheet_1 id;
    private indent indent;
    private Calculation calc = null;
    private Utility utl = new Utility();
    
    String product;
    int prodid;
    int prodtype;
    long billno;
    int custtype;
    
    double extQty;
    double Qty ;
    double rate;
    double comm ;
    double tax ;
    double cst ;
    double cess;
    double tcd ;
    double splrate ;
    double subsidy;
    
    double leakage;
    double retn;
    double sf;
    double hl;    
    double demand;
    
    double netqty;
    
    private int serviceCounter = 0;

    // Access methods for serviceCounter
    protected synchronized void enteringServiceMethod() {
        serviceCounter++;
    }
    
    protected synchronized void leavingServiceMethod() {
        serviceCounter--;
    }
    
    protected synchronized int numServices() {
        return serviceCounter;
    }
        
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)        
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // TODO output your page here
        
        calc = new Calculation();
        HttpSession hs =  request.getSession();
        id = (retnSheet_1) hs.getAttribute("retnSheet");
        Date idate = utl.ChangeToDate(hs.getAttribute("idate").toString());
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet IndentSer</title>");
        out.println("</head>");
        out.println("<body>");    
        
        HashMap hmQty = id.getqunatity();
        
        subsidy = 0.00;
        subsidy = id.getmoreve().compareTo("M") == 0 ? id.getsubsidy() : 0.00 ;
                               
        if(id.getbillno() > 0 ){
//            System.out.println("TRUE");
            billno = id.getbillno();
            deleteRec();
        }else{            
            billno = billno();
//            System.out.println("FALSE");
        }    
        Set s = hmQty.entrySet(); 
        Iterator itr = s.iterator();                
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();
//            System.out.println(me.getKey()+"     "+me.getValue());
            this.Qty = (Double) me.getValue();  
            
            if(this.Qty > 0 ){
                this.product = (String) id.gethmProduct().get(me.getKey());
                this.prodid = (Integer) id.gethmprodid().get(me.getKey());
                this.prodtype = (Integer) id.gethmProdType().get(me.getKey());
                this.rate = (Double) id.gethmRate().get(me.getKey()); 
                this.tax = (Double) id.gethmTax().get(me.getKey());
                this.cst = (Double) id.gethmCst().get(me.getKey());
                this.cess = (Double) id.gethmCess().get(me.getKey());
                this.tcd = (Double) id.gethmTcd().get(me.getKey());
//                this.splrate = (Double) id.gethmsplrate().get(me.getKey());
                this.comm = (Double) id.gethmComm().get(me.getKey());                 
                this.leakage = (Double) id.getLeak().get(me.getKey());
                this.retn = (Double) id.getRtn().get(me.getKey());
                this.sf = (Double) id.gethmsf().get(me.getKey());
                this.hl = (Double) id.gethmhl().get(me.getKey());     
                this.extQty = (Double) id.getqunatity().get(me.getKey());
                this.demand = (Double) id.getdemand().get(me.getKey());
                
                custtype = id.getcusttype();
                this.indent = new indent();
                this.indent.setbillno(billno);
                this.indent.setIdate(idate);            
                this.indent.setcustomer(id.getcustid());
                this.indent.setcustname(id.getfirstname());
                this.indent.setmoreve(id.getmoreve());
                this.indent.setcacr(id.getcacr());
                this.indent.setproduct(prodid);
                this.indent.setprodname(product);
                this.indent.setprodtype(prodtype);
                this.indent.setrtname(id.getrtname());       
                this.indent.setquantity(this.Qty); 
                demand = this.demand > 0 ? demand : this.Qty;
                this.indent.setdemand(demand);
                this.netqty = this.Qty - (this.leakage + this.retn);
                
                this.indent.setnetqty(this.netqty);

                calc.calc(this.netqty,
                        this.rate,
                        this.comm,
                        this.tax,
                        this.cst,
                        this.cess,
                        this.tcd,
                        id.getmdt());
                                 
                this.indent.setrate(this.rate);

                this.indent.setamount(this.Qty * this.rate);
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
                this.indent.setsaletype(1);  
                this.indent.setsubsidy(this.prodid == 1 ? subsidy : 0.00);
                this.indent.setcusttype(custtype);
                this.indent.setentrytype(1);
                this.indent.setleakage(this.leakage);
                this.indent.setsf(this.sf);
                this.indent.sethl(this.hl);
                this.indent.setreturnmilk(this.retn);
                this.indent.setratetype(id.getmdt());
                this.indent.setrectimestamp(new Date().toString());
                this.indent.setuser((String) hs.getAttribute("UserName"));
                appendRec(this.indent);         
//                this.subsidy = 0.00;
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
//        hs.setAttribute("retnSheet",null);          
        hs.removeAttribute("retnSheet");        
//        id.reInit();
        out.println("<a href='indt/retnSheet_1.jsp?mdt="+id.getmdt()+"&blnCustList=true&blnCstIndt=true&idate="+utl.ToDate(idate)+"'> Back</a>"); 
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
                                       "WHERE indent.billno =:bilno " +
                                       "AND indent.reclock =:RECLOCK ");
            qry.setParameter("bilno",new Long(billno));  
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
                "ORDER BY o.billno DESC ")
                .setMaxResults(1)
                .getResultList();               
        Iterator itr = l.iterator();  
        if(itr.hasNext())
            billno = (Long) itr.next();
        return billno + 1;
   }
   
}
