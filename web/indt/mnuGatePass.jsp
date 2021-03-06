<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="robots" content="index,follow">
        <meta name="robots" content="index,follow">
        <meta name="date" content="2007-09-01">
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">
        <link rel="stylesheet" type="text/css" href="../css/default.css">
        <link rel="stylesheet" type="text/css" href="../css/ipg.css">
        <link rel="stylesheet" type="text/css" href="../css/j5eetutorial.css">            
    </head>
    <body style="background-color:#F8D583;">      
        <f:view>
            <h:form>
                <table border="0" cellpadding="5" cellspacing="0" width="100%">
                    <tbody>
                        <tr valign="top">
                            <td><p class="toc level1"><a href="docinfo.html">Document Information</a></p>
                                <p class="toc level1"><a href="gexaf.html">Preface</a></p>
                                <p class="toc level1"><h6>Part&nbsp;I&nbsp;Introduction</h6></p>
                                <p class="toc level2"><a href="bnaaw.html">1.&nbsp;&nbsp;Overview</a></p>
                                <p class="toc level2"><a href="gfiud.html">2.&nbsp;&nbsp;Using the Application</a></p>

                                <p class="toc level1 tocsp"><h6>Part&nbsp;II&nbsp;The Day Work</h6></p>                                
                                <p class="selehead">3.&nbsp;&nbsp;Indnet Entry</p>
                <%--                <p class="toc level3">
                                    <h:commandLink  style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 11px" 
                                        target="mainframe" action="#{indent.createSetup}" 
                                        value="Indent" />
                                </P> --%>
<%--                                <p class="toc level3">
                                    <h:commandLink  style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 11px" 
                                        target="mainframe" action="#{indent.createSetup}" 
                                        value="Indent_1" />
                                </P> --%>
                                <p class="toc level3">
                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="statedate.jsp" target="mainframe">&nbsp;Indent</a></p>                                    
                                       <%-- href="selectRoute_1.jsp?file_name=../customerList.jsp&entrytype=1" target="mainframe">&nbsp;Indent</a></p> --%>                                   
                                </p>
                                <p class="toc level3">
                                    <p class="toc level2">&nbsp;<h:commandLink  style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        target="mainframe" action="viewIndent" 
                                        value="View Indent" /></p>
                                </P>
                                <p class="toc level3">
                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="mnuGatePass.faces">&nbsp;Sales</a></p>                                    
                                </p>                                                                                                
                           <%--     <p class="toc level3">
                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="newGatePass.faces?blnNE=true&blnShow=false&blnCstIndt=false&blnCstData=false" target="mainframe" >&nbsp;&nbsp;&nbsp;New</a></p>                                    
                                </p> --%>
                                
                                <p class="toc level3">
                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="newGatepassCaCr.faces" target="mainframe" >&nbsp;&nbsp;&nbsp;New</a></p>                                    
                                </p>

                                <p class="toc level3">
                                 <%--   <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="editGatePass.faces?gatePassList=false&blnEG=true&blnShow=false&blnCstData=false" target="mainframe">&nbsp;&nbsp;&nbsp;Edit</a></p> --%>                                  

                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="password.faces" target="mainframe">&nbsp;&nbsp;&nbsp;Edit</a></p> 

                                </p>                                                                
                                
                                <p class="toc level3">
                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="retnstatedate.jsp" target="mainframe">&nbsp;Return.Sheet</a></p>                                    
                                </p>    
                                <p class="toc level3">
                                    <p class="toc level2"><a style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 12px" 
                                        href="crdrstatedate.jsp" target="mainframe">&nbsp;Credit/Debit</a></p>                                    
                                      <%--  href="selectRoute_2.jsp?blnrec=true&entrytype=3" target="mainframe">&nbsp;Credit/Debit</a></p>  --%>                                  
                                </p>                                    
                                <p class="toc level1 tocsp"><h6>Part&nbsp;III&nbsp;Reports</h6></p>
                                <p class="toc level2"><a target="mainframe" href="../report/rptDistSheet.faces">4.&nbsp;&nbsp;Indent Sheet</a></p>                                
                                
                                <p class="toc level2"><a target="mainframe" href="../report/rptPaySlip.faces">5.&nbsp;&nbsp;Remittance Slip</a></p>
                                <p class="toc level1 tocsp"><h6>Part&nbsp;IV&nbsp;Masters</h6></p>
                                <p class="toc level2"><a href="../customer/mnuCustomer.faces">6.&nbsp;&nbsp;Customer</a></p>

                                <p class="toc level2"><a href="../product/mnuProduct.faces">7.&nbsp;&nbsp;Product</a></p>
                                <p class="toc level2"><a href="../route/mnuRoute.faces">8.&nbsp;&nbsp;Route</a></p>
                                                        
                                <p class="toc level1 tocsp"><h6>Part&nbsp;V&nbsp;Accounts</h6></p>
                                <p class="toc level2"><a href="../cashier/mnuCashier.faces">9.&nbsp;&nbsp;Cashier</a></p>                                
                            </td>
                        </tr>                
                    </tbody>
                </table>
            </h:form>
        </f:view>
    </body>
</html>
