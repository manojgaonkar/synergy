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
import mktg.backingBean.retnSheet;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class retnSheetSer extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf; 
    
    private retnSheet id;
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
    
    double leakage;
    double retn;
    double sf;
    double hl;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
                     
        HttpSession hs =  request.getSession();
        id = (retnSheet) hs.getAttribute("retnSheet");
        
        Date idate = utl.ChangeToDate(hs.getAttribute("idate").toString());        
        
        HashMap hmleakage = id.getLeak();
        
        Set s = hmleakage.entrySet();
        Iterator itr = s.iterator();
        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();             
            custtype = id.getcusttype();
            this.leakage = (Double)  hmleakage.get(me.getKey());
            this.retn = (Double) id.getRtn().get(me.getKey());
            this.Qty = (Double) id.getqunatity().get(me.getKey());
            this.Qty = this.Qty - (this.leakage + this.retn);
            this.rate = (Double) id.gethmRate().get(me.getKey());
            this.comm = (Double) id.gethmComm().get(me.getKey());
            this.tax = (Double) id.gethmTax().get(me.getKey());
            this.cst = (Double) id.gethmCst().get(me.getKey()); 
            this.cess = (Double) id.gethmCess().get(me.getKey());
            this.tcd = (Double) id.gethmTcd().get(me.getKey()); 
            
            this.sf = (Double) id.gethmsf().get(me.getKey());
            this.hl = (Double) id.gethmhl().get(me.getKey());
            
            calc.calc(this.Qty,this.rate,this.comm,this.tax,this.cst,this.cess,this.tcd,custtype);
            updateRec((Integer) id.gethmtrID().get(me.getKey()));
            calc.setamount(0.00);
            calc.setcessamt(0.00);
            calc.setcommi(0.00);
            calc.setcstamt(0.00);
            calc.setnetamt(0.00);
            calc.settaxamt(0.00);
            calc.settcdamt(0.00);            
            }        
//        hs.setAttribute("retnSheet",null);
        out.println("<a href='indt/retnSheet.jsp?idate="+utl.ToDate(idate)+"'> Back</a>");            
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
                "SET indt.leakage = :leak," +
                "indt.returnmilk =:rm," +
                "indt.sf =:sf," +
                "indt.hl =:hl," +
                "indt.amount =:amt," +
                "indt.taxamt =:taamt," +
                "indt.cstamt =:csamt," +
                "indt.cessamt =:ceamt," +
                "indt.tcdamt =:tcamt," +
                "indt.netamount =:neamt," +
                "indt.commiamt =:commi," +
                "indt.netqty =:neqty " +
                "WHERE indt.id =:id ");
                qry.setParameter("leak",new Double(this.leakage));
                qry.setParameter("rm",new Double(this.retn));
                qry.setParameter("sf",new Double(this.sf));
                qry.setParameter("hl", new Double(this.hl));
                qry.setParameter("amt",new Double(calc.getamount()));
                qry.setParameter("taamt",new Double(calc.gettaxamt()));
                qry.setParameter("csamt",new Double(calc.getcstamt()));
                qry.setParameter("ceamt",new Double(calc.getcessamt()));
                qry.setParameter("tcamt",new Double(calc.gettcdamt()));
                qry.setParameter("neamt",new Double(calc.getnetamt()));
                qry.setParameter("commi",new Double(calc.getcommi()));
                qry.setParameter("neqty",new Double(Qty));
                qry.setParameter("id",new Integer(TranID));            
            qry.executeUpdate();
            utx.commit();
        } catch (Exception ex) {
            try {
                 ex.printStackTrace();   
                utx.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            em.close();
        }               
    }
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }        
}
