/*
 * retnSheetSer.java
 *
 * Created on February 17, 2009, 5:11 PM
 */

package serv;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import mktg.backingBean.editIndent;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class editSheetSer extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf; 
    
    private editIndent id;
    private indent indent;
    private Calculation calc = new Calculation();
    private Utility utl = new Utility();
    
    int prodid;
    int custtype;
    
    double Qty ;
    double rate;
    double comm ;
    double tax ;
    double cst ;
    double cess;
    double tcd ; 
    double splrate ;
//    double leakage;
//    double retn;
    
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                     
        HttpSession hs =  request.getSession();
        id = (editIndent) hs.getAttribute("indtEdit");
        
        Date idate = utl.ChangeToDate(hs.getAttribute("idate").toString());        
        
        HashMap hmQty = id.getqunatity();
        HashMap hmProd = id.gethmprodid(); 
        HashMap hmRate = id.gethmRate();
        HashMap hmComm = id.gethmComm();
        HashMap hmTax = id.gethmTax();
        HashMap hmCst = id.gethmCst();
        HashMap hmCess = id.gethmCess();
        HashMap hmTcd = id.gethmTcd();
        HashMap hmsplrate = id.gethmsplrate();
        HashMap hmid = id.gethmtrID();
        HashMap hmleakage = id.getLeak();
        HashMap hmreturn = id.getRtn(); 
        HashMap hmEditQty = id.gethmeditqty();
        Set s = hmleakage.entrySet();
        Iterator itr = s.iterator();        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();            
//            out.print("KEY : " + me.getKey() + " VALUE : " + me.getValue());            
//            this.leakage = (Double) hmleakage.get(me.getKey());
//            this.retn = (Double) hmreturn.get(me.getKey());            
            this.Qty = (Double) hmEditQty.get(me.getKey()); //me.getValue();            
//            this.Qty = this.Qty - (this.leakage + this.retn);
            custtype = id.getcusttype();
            this.rate = (Double) hmRate.get(me.getKey());
            this.comm = (Double)  hmComm.get(me.getKey());
            this.tax = (Double) hmTax.get(me.getKey());
            this.cst = (Double) hmCst.get(me.getKey());
            this.cess = (Double) hmCess.get(me.getKey());
            this.tcd = (Double) hmTcd.get(me.getKey());                        
            calc.calc(this.Qty,this.rate,this.comm,this.tax,this.cst,this.cess,this.tcd,custtype);
            updateRec((Integer)hmid.get(me.getKey()));
            calc.setamount(0.00);
            calc.setcessamt(0.00);
            calc.setcommi(0.00);
            calc.setcstamt(0.00);
            calc.setnetamt(0.00);
            calc.settaxamt(0.00);
            calc.settcdamt(0.00);            
        }       ;
//        hs.setAttribute("indtEdit",null);
        out.println("<a href='indt/EditIndent.jsp?idate="+utl.ToDate(idate)+"'> Back</a>");            
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
    
    private synchronized void updateRec(int TranID){  
        EntityManager em = getEntityManager();                

       try {
            utx.begin();
            em.joinTransaction();          
            Query qry = em.createQuery("update indent as indt " +
                "SET indt.quantity = :qty," +
                "indt.amount =:amt," +
                "indt.taxamt =:taxamt," +
                "indt.cstamt =:cstamt," +
                "indt.cessamt =:cessamt," +
                "indt.tcdamt =:tcdamt," +
                "indt.netamount =:netamt," +
                "indt.commiamt =:commi," +
                "indt.netqty =:netqty " +
                "WHERE indt.id =:id ");
                qry.setParameter("qty",new Double(this.Qty));                
                qry.setParameter("amt",new Double(calc.getamount()));
                qry.setParameter("taxamt",new Double(calc.gettaxamt()));
                qry.setParameter("cstamt",new Double(calc.getcstamt()));
                qry.setParameter("cessamt",new Double(calc.getcessamt()));
                qry.setParameter("tcdamt",new Double(calc.gettcdamt()));
                qry.setParameter("netamt",new Double(calc.getnetamt()));
                qry.setParameter("commi",new Double(calc.getcommi()));
                qry.setParameter("netqty",new Double(Qty));
                qry.setParameter("id",new Integer(TranID));            
            qry.executeUpdate();
            utx.commit();
//            addSuccessMessage("customer was successfully updated.");
        } catch (Exception ex) {
            try {
                 ex.printStackTrace();   
//                addErrorMessage(ex.getLocalizedMessage());
                utx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
//                addErrorMessage(e.getLocalizedMessage());
            }
        } finally {
            em.close();
        }               
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }        
}
