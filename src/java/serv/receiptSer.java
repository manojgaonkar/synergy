/*
 * receiptSer.java
 *
 * Created on April 16, 2009, 11:37 AM
 */

package serv;

import java.io.*;
import java.util.Date;
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
import mktg.backingBean.receipt;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class receiptSer extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    @Resource
    private UserTransaction utx;
       
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;     
    
    private receipt id;
    private Utility utl = new Utility();
    
    private Date grdate = null;
    private Date idate;
    private int type = 0;
    
    protected synchronized void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {                
        HttpSession hs =  request.getSession();
        id = (receipt) hs.getAttribute("rcpt");
       
        idate = utl.ChangeToDate(hs.getAttribute("idate").toString());        
                
        Set s = id.gethmrouteid().entrySet();
        Iterator itr = s.iterator();
        type = (Integer) hs.getAttribute("type");

        while(itr.hasNext()){    
            
            Map.Entry me = (Map.Entry) itr.next();            
            int m_route = (Integer) id.gethmrouteid().get(me.getKey());
            String grno = (String) id.gethmgrno().get(me.getKey());
            String gpno = (String) id.gethmgpno().get(me.getKey());
            String chequeno = (String) id.gethmchequeno().get(me.getKey());

//            if(id.gethmgrdate().get(me.getKey()).toString().length() > 0){
           
            grdate = utl.ChangeToDate((String) id.gethmgrdate().get(me.getKey()));
          
                
//            }
            
//            int billno = (Integer)id.gethmBillno().get(me.getKey());

            if(type == 1)
              
                updateGRno(m_route,grno,chequeno,grdate,gpno);
            else{
                long billno = (Long)id.gethmBillno().get(me.getKey());
            
                updateGRno(m_route,grno,chequeno,grdate,billno,gpno);
            }
        }
        
        s = id.gethmid().entrySet();
        itr = s.iterator();
        
        while(itr.hasNext()){
            Map.Entry me = (Map.Entry) itr.next();
            
            double excessamt = (Double) id.gethmexceamt().get(me.getKey());            
            double shortamt = (Double)  id.gethmlessamt().get(me.getKey());
//            System.out.println(me.getValue()+" "+excessamt+" "+shortamt);
            if(excessamt > 0 || shortamt > 0 )
                updateShortExcess((Integer)me.getValue(),shortamt,excessamt);
            
        }
        
        hs.removeAttribute("rcpt");
//        hs.setAttribute("rcpt",null);
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

    private synchronized void updateGRno(int routeid ,String grno,String chequeno,
               Date grdate,String gpno){
      EntityManager em = null;            
        try {      
            em = getEntityManager();         
            utx.begin();
            em.joinTransaction();                           
            Query qry = em.createQuery("update indent as indt " +
                "SET indt.grno =:GRNO," +
                "indt.chequeno =:CHEQUENO,"+
                "indt.grdate =:MGRDATE,"+
                "indt.reclock =:MRECLOCK,"+
                "indt.gpno =:GPNO"+
                "WHERE indt.route =:MROUTEID " +
                "AND indt.idate =:MIDATE ");
                qry.setParameter("MGRNO",new String(grno));  
                qry.setParameter("MCHEQUENO",new String(chequeno));
                qry.setParameter("MGRDATE",grdate);  
                qry.setParameter("MRECLOCK",new Boolean(true));  
                qry.setParameter("GPNO",new String(gpno));  
                qry.setParameter("MROUTEID",new Integer(routeid));  
                qry.setParameter("MIDATE",idate);
                qry.executeUpdate();
                utx.commit();                                                                           
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }                                             
    }    
    
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }    
  
    private synchronized void updateGRno(int routeid ,String grno,String chequeno,Date grdate,
            long billno,String gpno){
      EntityManager em = null;            
        try {      
            em = getEntityManager();         
            utx.begin();
            em.joinTransaction();                           
            Query qry = em.createQuery("update indent as indt " +
                "SET indt.grno =:GRNO," +    
                "indt.chequeno =:CHEQUENO,"+
                "indt.grdate =:MGRDATE,"+
                "indt.reclock =:MRECLOCK,"+
                "indt.gpno =:GPNO"+                
                "WHERE indt.route =:MROUTEID " +
                "AND indt.idate =:MIDATE " +
                "AND indt.billno =:BILLNO " +
                "AND indt.saletype =:SALETYPE");
                qry.setParameter("MGRNO",new String(grno));
                qry.setParameter("MCHEQUENO",new String(chequeno));
                qry.setParameter("MGRDATE",grdate);  
                qry.setParameter("MRECLOCK",new Boolean(true));
                qry.setParameter("GPNO",new String(gpno)); 
                qry.setParameter("MROUTEID",new Integer(routeid));  
                qry.setParameter("MIDATE",idate);
                qry.setParameter("BILLNO",new Long(billno));
                qry.setParameter("SALETYPE",new Integer(2));
                qry.executeUpdate();
                utx.commit();                                                                           
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }                                             
    }    
    
    
    private void updateShortExcess(int id,double shortamt, double excessamt){
        
      EntityManager em = null;            
        try {      
            em = getEntityManager();         
            utx.begin();
            em.joinTransaction();                           
            Query qry = em.createQuery("update indent as indt " +
                "SET indt.lessamt =:LESSAMT,"+
                "indt.exceamt =:EXCEAMT "+                                
                "WHERE indt.id =:ID " +
                "AND indt.idate =:MIDATE " +
                "AND indt.saletype =:SALETYPE");                
                qry.setParameter("LESSAMT",new Double(shortamt));  
                qry.setParameter("EXCEAMT",new Double(excessamt));                  
                qry.setParameter("ID",new Integer(id));                
                qry.setParameter("MIDATE",idate);
                qry.setParameter("SALETYPE",new Integer(2));
                qry.executeUpdate();
                utx.commit();                                                                           
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }                                                             
        
    }
    
    
}



