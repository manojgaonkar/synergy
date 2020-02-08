/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package serv;

import java.io.*;

import java.sql.Connection;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author xp
 */
public class rptDistSheet extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            int mpono = 0;
        ConnectionPool cp = new ConnectionPool();
        Connection con = cp.getconnection();
        System.out.println("Connection " + con);
    //    
        String filename = "/WEB-INF/report/report/template/rptDistributionSheet_n1.jasper";
        System.out.println("File Name " + filename);
        System.out.println("Route ID " + request.getParameter("route"));
    //    filename = "C:\\reportExample\\web\\WEB-INF\\myWebReport.jasper";
    //     String destfile = "C:\\reportExample\\web\\WEB-INF\\myWebReport.html";
    //   try
    //    {
    //        response.setContentType("application/pdf");
    //        
    //        JasperRunManager.runReportToHtmlFile(filename, destfile,new HashMap(), con);
    //        
    //       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/rptPurchaseOrder.pdf");
    //       rd.include(request, response);
    //    }
    //    catch (JRException e)
    //    {
    //        // display stack trace in the browser
    //        StringWriter stringWriter = new StringWriter();
    //        PrintWriter printWriter = new PrintWriter(stringWriter);
    //        e.printStackTrace(printWriter);
    //        response.setContentType("text/plain");
    //        response.getOutputStream().print("Error : " +stringWriter.toString());
    //    }    







    //    PDF FORMAT

        ServletOutputStream servletOutputStream = response.getOutputStream();
        InputStream reportStream = getServletConfig().getServletContext()
        .getResourceAsStream(filename);
 

        try
        {        

    //        if(con == null)
    //            System.out.println("Connection Objec is NULL");
    //    
    //        if(reportStream == null)
    //            System.out.println("Report is Object Is Null");

            if(request.getParameter("pono") != null)
                mpono = Integer.parseInt(request.getParameter("pono"));        

    //        JasperRunManager.runReportToPdfStream(reportStream , servletOutputStream,
    //        new HashMap(), con);
            HashMap params = new HashMap();
            params.put("m_route",new Long(1));
            params.put("m_date",new String("2010-03-11"));
            params.put("ContSales",new String("NANDINI"));
        
        
            byte buffer[] =  JasperRunManager.runReportToPdf(reportStream, params, con);
        System.out.println("buffer Length " + buffer.length);
//text/html;charset=UTF-8
            response.setContentType("application/pdf");

            servletOutputStream.write(buffer);
            servletOutputStream.flush();
            servletOutputStream.close();
        }
        catch (JRException e)
        {
            // display stack trace in the browser
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print("Error : " +stringWriter.toString());
        }catch(NumberFormatException n){
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            n.printStackTrace(printWriter);
            response.setContentType("text/plain");
            response.getOutputStream().print("Error : " +stringWriter.toString());        
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
