/*
 * CrDrSer.java
 *
 * Created on March 2, 2009, 5:26 PM
 */

package serv;

import java.io.*;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class adjustment extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;     
    
    private Utility utl = new Utility();
    private indent indent;
    
//    private int custtype;
    
    
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     
        HttpSession hs = request.getSession();
        Date idate = null;
                
        this.indent = new indent();
        
        if(hs.getAttribute("idate") != null)
            idate = utl.ChangeToDate(hs.getAttribute("idate").toString());                             
        
//        try{    
            
            this.indent.setIdate(idate);  
            
            this.indent.setgrdate(idate);  
            
            System.out.print("GR DATE : "+this.indent.getgrdate());
            
            this.indent.setcustomer(Integer.parseInt(request.getParameter("custid")));        
            this.indent.setcustname(request.getParameter("firstname"));        
            this.indent.setcacr("Cash");

            this.indent.settaluka(Integer.parseInt(request.getParameter("talid")));
            this.indent.setroute(Integer.parseInt(request.getParameter("routeid")));
            this.indent.setrtname(request.getParameter("rt")); 

            this.indent.setcusttype(Integer.parseInt(request.getParameter("custtype")));

            if(request.getParameter("lessamt").length() > 0)
                this.indent.setlessamt(Double.parseDouble(request.getParameter("lessamt")));

            if(request.getParameter("exceamt").length() > 0)
                this.indent.setexceamt(Double.parseDouble(request.getParameter("exceamt")));    
            
            
           
            
        System.out.println(request.getParameter("particulars"));
        
            if(request.getParameter("particulars").length() > 0)
                this.indent.setprodname(request.getParameter("particulars"));
            
//                deleteRec(Integer.parseInt(request.getParameter("trid")));
            
            
            this.indent.setentrytype(4);

            this.indent.setuser((String) hs.getAttribute("UserName"));
            this.indent.setrectimestamp(new Date().toString());
            
            appendRec(this.indent);
            
//        }catch(Exception e){ e.printStackTrace(); }        
//        
        
        
        out.println("<a href='cashier/adjustment.jsp?blnCustList=true&idate="+utl.ToDate(idate)+"'> Back</a>");     
        
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
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }            
        
   private synchronized void deleteRec(int trno){
      EntityManager em = null;            
        try {      
            em = getEntityManager();         
            utx.begin();
            em.joinTransaction();                           
            Query qry = em.createQuery("DELETE FROM indent " +
                                       "WHERE indent.id =:trno ");
            
            qry.setParameter("trno",new Integer(trno));  
            qry.executeUpdate();
            utx.commit();                                                                           
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
            }
        } finally {
            em.close();
        }                           
    }    
}
