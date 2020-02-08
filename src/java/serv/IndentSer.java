/*
 * IndentSer.java
 *
 * Created on February 9, 2009, 12:41 PM
 */
package serv;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import mktg.backingBean.Indent_1;
import mktg.persistDatabase.indent;
import mktg.utility.Utility;

/**
 *
 * @author MD
 * @version
 */
public class IndentSer extends HttpServlet {

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    @Resource
    private UserTransaction utx;
    @PersistenceUnit(unitName = "kmfmktgNewPU")
    private EntityManagerFactory emf;
    private Indent_1 id;
    private indent indent;
    private Calculation calc = null;
    private Utility utl = new Utility();
    String product;
    int prodid;
    int prodtype;
    long billno;
    int custtype;
    double Qty;
    double rate;
    double comm;
    double tax;
    double cst;
    double cess;
    double tcd;
    //double splrate;
    double subsidy;
//    private boolean lock;
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
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        // TODO output your page here

        HttpSession hs = request.getSession();
        id = (Indent_1) hs.getAttribute("indt");
        Date idate = utl.ChangeToDate(hs.getAttribute("idate").toString());


//        HashMap hmQty = id.getqunatity();


        StringBuffer sms = new StringBuffer("");
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd/MM/yyyy");
        calc = new Calculation();
        subsidy = 0.00;
        if(id.gethmx().containsKey(new Integer(1)))
            subsidy = id.getmoreve().compareTo("M") == 0 ? id.getsubsidy() : 0.00;

        if (id.getbillno() > 0) {
            billno = id.getbillno();
            deleteRec();
        } else {
            if (id.getrouteid() != 16) {
                billno = billno();
            } else {
                billno = TaxInvoiceNo();
            }
        }

        Set x = id.gethmx().entrySet();
        Iterator itr = x.iterator();

//        while(itrx.hasNext()){
//            Map.Entry me = (Map.Entry) itrx.next();
//            System.out.println("Key : " + me.getKey() + " value : " + me.getValue() + " Qty : "+ hmQty.get(me.getValue()));   
//           
//        }
//       Old code Changed to avoid Double entry problem       
//        Set s = hmQty.entrySet(); 
//        Iterator itr = s.iterator(); 

double billAmount =0;
            while (itr.hasNext()) {
    //            Map.Entry me = (Map.Entry) itr.next();  Changed to avoid Double entry problem
    //            this.Qty = (Double) me.getValue();                 
    //------------- Start of new written Code ----------------------       

                Map.Entry me = (Map.Entry) itr.next();
//                System.out.println("Key : " + me.getKey() + " VAlue " + me.getValue()  );
                this.Qty = (Double) id.getqunatity().get(me.getValue());
    //            System.out.println("Key : " + me.getKey() + " value : " + me.getValue() + " Qty : "+ this.Qty);                       
    //------------- End of new written Code ----------------------           
                if (this.Qty > 0) {                   
                    EntityManager em = null;                   
                    try {
                        em = getEntityManager();
                        utx.begin();
                        this.product = (String) id.gethmProduct().get(me.getValue());
                        this.prodid = (Integer) id.gethmprodid().get(me.getValue());
                        this.prodtype = (Integer) id.gethmProdType().get(me.getValue());
                        this.rate = (Double) id.gethmRate().get(me.getValue());
                        this.tax = (Double) id.gethmTax().get(me.getValue());
                        this.cst = (Double) id.gethmCst().get(me.getValue());
                        this.cess = (Double) id.gethmCess().get(me.getValue());
                        this.tcd = (Double) id.gethmTcd().get(me.getValue());
                        //this.splrate = (Double) id.gethmsplrate().get(me.getValue());
                        this.comm = (Double) id.gethmComm().get(me.getValue());
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
                        calc.calc(this.Qty,
                                this.rate,
                                this.comm,
                                this.tax,
                                this.cst,
                                this.cess,
                                this.tcd,
                                id.getmdt());
                        this.indent.setquantity(this.Qty);
                        this.indent.setdemand(this.Qty);
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
                        //this.indent.setsplrate(this.splrate);
                        //this.indent.setsplrateamt(calc.getsplrateamt());
                        this.indent.setnetamount(calc.getnetamt());
                        this.indent.setroute(id.getrouteid());
                        this.indent.settaluka(id.gettalid());
                        this.indent.setsaletype(1);
//                        System.out.println("Subsidy " + subsidy + " Product " + prodid);
                        this.indent.setsubsidy(prodid == 1 ? subsidy : 0.00);
                        this.indent.setcusttype(custtype);
                        this.indent.setentrytype(1);
                        this.indent.setratetype(id.getmdt());
                        this.indent.setrectimestamp(new Date().toString());
                        this.indent.setuser((String) hs.getAttribute("UserName"));
    //                    appendRec(this.indent);
                        em.persist(indent);
                        utx.commit();
                        billAmount=billAmount+calc.getamount();
                        sms.append(product);
                        sms.append(":");
                        sms.append(this.Qty);
                        sms.append(", ");


                    } catch (Exception ex) {
                        try {
                            ex.printStackTrace();
                            utx.rollback();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    } finally {
                        em.close();
                    }                                             
//                    this.subsidy = 0.00;
                    calc.setamount(0.00);
                    calc.setcessamt(0.00);
                    calc.setcommi(0.00);
                    calc.setcstamt(0.00);
                    calc.setnetamt(0.00);
                    calc.settaxamt(0.00);
                    calc.settcdamt(0.00);
                    //calc.setsplrateamt(0.00);
                    this.Qty = 0.00;
                }
            }
sms.append(" Amt:Rs");
sms.append(Math.round(billAmount));
sms.append(" DOD:");
sms.append(format.format(idate));
sms.append(" Route:");
sms.append(id.getrtname());


//            id.gethmx().clear();
//            hs.setAttribute("indt", null);

           hs.removeAttribute("indt");
//            id.reInit();       
            RequestDispatcher rd = request.getRequestDispatcher("/customerList.jsp?message="+sms.toString()+"&mobileNo="+id.getmobileNo()+"");
            rd.forward(request, response);       
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

//    private synchronized void appendRec(indent indent) {
//        EntityManager em = null;
//        try {
//            em = getEntityManager();
//            utx.begin();
////            em.joinTransaction();
//            em.persist(indent);
//            utx.commit();
//        } catch (Exception ex) {
//            try {
//                utx.rollback();
//            } catch (Exception e1) {
//            }
//        } finally {
//            em.close();
//        }
//    }

    private synchronized void deleteRec() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            utx.begin();
            em.joinTransaction();
            Query qry = em.createQuery("DELETE FROM indent " +
                    "WHERE indent.billno =:bilno " +
                    "AND indent.reclock =:RECLOCK ");
            qry.setParameter("bilno", new Long(billno));
            qry.setParameter("RECLOCK", new Boolean(false));

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

    private synchronized long billno() {
        long billno = 0;
        EntityManager em = getEntityManager();
        List l = em.createQuery("SELECT distinct o.billno " +
                "FROM indent o " +
                "WHERE o.saletype = 1 " +
//                "AND o.reclock = false " +
                "ORDER BY o.billno DESC ").setMaxResults(1).getResultList();
        Iterator itr = l.iterator();
        if (itr.hasNext()) {
            billno = (Long) itr.next();
//            System.out.println(billno);
        }
        return billno + 1;
    }

    private synchronized long TaxInvoiceNo() {
        long billno = 0;
        EntityManager em = getEntityManager();
        List l = em.createQuery("SELECT distinct o.billno " +
                "FROM indent o " +
                "WHERE o.route = :r_id " +
//                "AND o.reclock = false " +
                "ORDER BY o.billno DESC ")
                .setParameter("r_id", new Integer(id.getrouteid())).setMaxResults(1).getResultList();
        Iterator itr = l.iterator();
        if (itr.hasNext()) {
            billno = (Long) itr.next();
        }
        return billno + 1;
    }

}
