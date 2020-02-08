<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="mktg.backingBean.gatepass,java.util.*"%>

<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fn"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INDENT FORM</title>        
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">         
        <style type="text/css">
           .qty{font-size:20px;text-align: right;background-color: ;color: #954A00;font-weight: 800;}
        </style>        
        <script type="text/javascript">            
            function setFocus(){                 
                indentForm.qty.select();
            }            
        </script>
    </head>      
    
    <jsp:useBean id="utlBen" scope="page" class="mktg.backingBean.utlBean" />        
    <jsp:useBean id="gatepass" scope="session" class="mktg.backingBean.gatepass" />
   
    <jsp:setProperty name="gatepass" property="index" param="index" />      
    <jsp:setProperty name="gatepass" property="prodid" param="prodid" />      
    <jsp:setProperty name="gatepass" property="routeid" param="routeid" />     
    <jsp:setProperty name="gatepass" property="custid" param="custid" />     
    <jsp:setProperty name="gatepass" property="talid" param="talid" />     
    <jsp:setProperty name="gatepass" property="product" param="product" />        
    <jsp:setProperty name="gatepass" property="qty" param="qty" />    
    <jsp:setProperty name="gatepass" property="rate" param="rate"/>    
    <jsp:setProperty name="gatepass" property="comm" param="comm"/>    
    <jsp:setProperty name="gatepass" property="tax" param="tax"/>    
    <jsp:setProperty name="gatepass" property="cst" param="cst"/>    
    <jsp:setProperty name="gatepass" property="cess" param="cess"/>    
    <jsp:setProperty name="gatepass" property="tcd" param="tcd"/>     
    <jsp:setProperty name="gatepass" property="firstname" param="firstname"/>    
    <jsp:setProperty name="gatepass" property="cacr" param="cacr"/>    
    <jsp:setProperty name="gatepass" property="idate" param="idate"/>    
    <jsp:setProperty name="gatepass" property="mdt" param="mdt"/>    
    <jsp:setProperty name="gatepass" property="blnCustList" param="blnCustList"/>    
    <jsp:setProperty name="gatepass" property="blnValue" param="blnValue"/>       
    <jsp:setProperty name="gatepass" property="rtname" param="rtname"/>    
    <jsp:setProperty name="gatepass" property="prodtype" param="prodtype"/>
    <sql:query 
        sql="SELECT product.*
             FROM product               
             WHERE product.stateid = 1      
             ORDER BY product.layoutno  " 
        var="prod" 
        dataSource="jdbc/kmfmktgNew" >                
    </sql:query>  
    <sql:query 
        sql="SELECT route.*
             FROM route                
             WHERE route.saletype = 2 " 
        var="rot" 
        dataSource="jdbc/kmfmktgNew" >                
    </sql:query>    
    <sql:query 
        sql="SELECT customer.id,customer.firstname 
        FROM customer 
        WHERE customer.cacr = 'Credit'
        ORDER BY customer.firstname " 
        var="CreditCustomer" 
        dataSource="jdbc/kmfmktgNew">        
    </sql:query>
    <sql:query 
        sql="SELECT customer.id,customer.firstname 
        FROM customer 
        WHERE customer.cacr = 'Cash' and customer.custtype= 1
        ORDER BY customer.firstname " 
        var="CashCustomer" 
        dataSource="jdbc/kmfmktgNew">        
    </sql:query>    
    <body style="background:#820041">         
        <form name="indentForm">  
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>   
            
       <%--     <%!public int billno = 0;%>
            <%!public int mdt = 0;%> --%>
            <%!public boolean blnCstIndt = false; %>
            <%!public boolean blnNE = false; %>
       <%--     <%!public boolean blnShow = false; %> 
            <%!public boolean blnCstData = false;%>
            
            <%!public String cstname; %>           --%> 
           
            <%      
              // if(request.getParameter("mdt") != null)
                //    mdt = Integer.parseInt(request.getParameter("mdt"));
                                        
               // if(request.getParameter("billno") != null)
                 //   billno = Integer.parseInt(request.getParameter("billno"));
                    
             /*   if(request.getParameter("prodtype") != null)
                    Integer.parseInt(request.getParameter("prodtype"));*/
                    
                if(request.getParameter("blnNE") !=null)
                   blnNE = Boolean.parseBoolean(request.getParameter("blnNE"));                                    
                               
                if(request.getParameter("blnCstIndt") !=null)
                   blnCstIndt = Boolean.parseBoolean(request.getParameter("blnCstIndt"));                    
                
                if(request.getParameter("idate") != null){
                    session.setAttribute("idate",request.getParameter("idate"));
                }
                
             /*   if(request.getParameter("talid") != null)
                    Integer.parseInt(request.getParameter("talid"));

                if(request.getParameter("custid") != null)
                    Integer.parseInt(request.getParameter("custid"));

                if(request.getParameter("prodid") != null)    
                    Integer.parseInt(request.getParameter("prodid"));

                if(request.getParameter("routeid") != null)
                    Integer.parseInt(request.getParameter("routeid")); */

                if(request.getParameter("index") != null){
                    Integer.parseInt(request.getParameter("index")); 
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index").toString()));                       
                }
                //if(request.getParameter("index") != null)                        
                    

            //   if(request.getParameter("qty") != null && request.getParameter("qty").length() >0 )
              //      Double.parseDouble(request.getParameter("qty"));

              //  if(request.getParameter("firstname") != null)
                //    request.getParameter("firstname");                   

              //  if(request.getParameter("blnValue") !=null)
                //    Boolean.parseBoolean(request.getParameter("blnValue"));    
                    
             //   if(request.getParameter("blnCustList") !=null)
               //     Boolean.parseBoolean(request.getParameter("blnCustList"));   
                                        
           //     if(request.getParameter("blnShow") !=null)
               //     blnShow = Boolean.parseBoolean(request.getParameter("blnShow"));   

             /*   if(request.getParameter("rate") !=null && request.getParameter("rate").length() > 0)
                    Double.parseDouble(request.getParameter("rate"));
                
                if(request.getParameter("comm") !=null)
                    Double.parseDouble(request.getParameter("comm"));
                    
                if(request.getParameter("tax") !=null)
                    Double.parseDouble(request.getParameter("tax"));
                    
                if(request.getParameter("cst") !=null)
                    Double.parseDouble(request.getParameter("cst"));
                    
                if(request.getParameter("cess") !=null)
                    Double.parseDouble(request.getParameter("cess"));
                    
                if(request.getParameter("tcd") !=null)
                    Double.parseDouble(request.getParameter("tcd")); 
                    
                if(request.getParameter("cacr") != null)
                    request.getParameter("cacr");*/
                    
             //   if(request.getParameter("cstname") != null)    
               //     cstname = request.getParameter("cstname");
                    
              //  if(request.getParameter("blnCstData") != null)    
                //    blnCstData = Boolean.parseBoolean(request.getParameter("blnCstData"));                       
                
               // out.println(request.getParameter("cacr"));
            %>
            



            <font style="font-size:16px;color:#ffffff">Sales</font>
            <%if(blnNE){%>
                <center>                    
                <table cellpadding="5" width="70%">
                    <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                        <th style="text-align: right">D&nbsp;A&nbsp;Y</th>
                        <th style="text-align: left">S&nbsp;A&nbsp;L&nbsp;E&nbsp;S</th>
                    </tr>                                                            
                    <tr class="list-row-even">
                        <td style="text-align: right;">
                            DATE :
                        </td>
                        <td style="text-align: left;">
                            <input value="<fn:formatDate pattern="dd.MM.yyyy" 
                                value="${utlBen.currentDate}" type="date"/>" type="text" 
                                size="10" name="idate"> 
                        </td> 
                    </tr>
                    <tr class="list-row-odd">
                        <td style="text-align: right;">
                            CUSTOMER NAME :
                        </td>
                        <%if(request.getParameter("cacr").compareTo("Cash") == 0 ){%>
                            <td style="text-align: left;">
                            <select name="firstname">
                                <c:forEach var="book" begin="0" items="${CashCustomer.rows}" >
                                    <option value="${book.firstname}"><c:out value="${book.firstname}" /></option>
                                </c:forEach>
                            </select>                            
                            </td>                                                
                        <%}else if(request.getParameter("cacr").compareTo("Credit") == 0){%>     
                            <td style="text-align: left;">
                            <select name="firstname">
                                <c:forEach var="book" begin="0" items="${CreditCustomer.rows}" >
                                    <option value="${book.firstname}"><c:out value="${book.firstname}" /></option>
                                </c:forEach>
                            </select>                            
                            </td>
                        <%}else{%>
                            <td style="text-align: left;">
                                <input size="50" maxlength="80" name="firstname"> 
                            </td>
                        <%}%>
                    </tr> 
                    <tr class="list-row-even">
                        <td style="text-align: right;">
                            Sales Type :
                        </td>
                        <td style="text-align: left;">
                            <select name="routeid">
                                <c:forEach var="book" begin="0" items="${rot.rows}" >
                                    <option value="${book.id}"><c:out value="${book.route}" /></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>                     
                    <tr class="list-row-odd">
                        <td style="text-align: right;">                              
                        </td>
                        <td style="text-align: left;">
                            <select name="mdt">                            
                                <option value="1">Dealer Price</option>                            
                                <option value="2">MRP</option>                            
                                <option value="3">TCD</option> 
                                <option value="4">UTP</option> 
                                <option value="5">SUBSIDY</option> 
                            </select>
                        </td>
                    </tr> 
            <%--        <tr class="list-row-odd">-------------------------------
                        <td style="text-align: right;">    
                            Cash/Credit
                        </td>
                        <td style="text-align: left;">
                            <select name="cacr">                            
                                <option value="Cash">Cash</option>                            
                                <option value="Credit">Credit</option>                            
                            </select>
                        </td>
                    </tr>  --%>
                    
                    <tr class="list-row-even">                        
                        <td></td>
                        <td style="text-align: left;">
                            <input style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                                type="submit" value="Submit">                         
                            <input type="hidden" value="false" name="blnCustList">
                            <input type="hidden" value="true" name="blnCstIndt">
                            <input type="hidden" value="false" name="blnNE">
                            <input type="hidden" value="1" name="talid">
                        </td>                        
                    </tr>                
                </table>  
                </center>
                <a style="font-size:16px;color:#ffffff" href="newGatepassCaCr.faces">Back</a>
            <%}%>   
            <%if(blnCstIndt){%>
                <table width="90%">
                    <tr style="background-color: #FF9DCE;color: #000000;font-size:18px;">                            
                        <td>
                            <jsp:getProperty name="gatepass" property="firstname"/>  
                        </td>                        
                        <td>DATE :&nbsp;<%=session.getAttribute("idate")%></td>
                        <% if(gatepass.getmdt() == 1 ){%>
                            <td>PRICE :&nbsp;Dealer Price</td>
                        <%}%>
                        <% if(gatepass.getmdt() == 2 ){%>
                            <td>PRICE :&nbsp;MRP</td>
                        <%}%>
                        <% if(gatepass.getmdt() == 3 ){%>
                            <td>PRICE :&nbsp;TCD</td>
                        <%}%>        
                        <% if(gatepass.getmdt() == 4 ){%>
                            <td>PRICE :&nbsp;UTP</td>
                        <%}%>        
                        <% if(gatepass.getmdt() == 5 ){%>
                            <td>PRICE :&nbsp;SUBSIDY</td>
                        <%}%>        
                    </tr>
                </table>    
                <table>
                    <tr>
                        <td >     
                            <a style="color:#ffffff;font-size:16px; text-align: left;width: 5%;" accesskey="s" href="../gatepassSer">Save</a>
                        </td>                       
                        <td style="font-size:14px; text-align: left;width: 6%;">                                 
                        </td>
                        <td style="font-size:14px; text-align: left;width: 3%;">                                     
                            <%--<a href="../Cleargp">Clear List</a>--%>
                        </td>
                    </tr>                    
                </table>                                                                   
                <table cellpadding="3" width="90%">                                                                                                                         
                    <% if(gatepass.getblnValue()){%>                         
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>
                                <th>QUANTITY</th>
                                <th>RATE</th>
                                <th>AMOUNT</th>
                            </tr>                                                
                        </thead>                                                                   
                        <%index = -1;%>
                        <%slno = 0 ;%>    
                        <c:forEach items="${prod.rows}" var="book" varStatus="stat">
                            <%index++;%>    
                            <%slno++;%>    
                            <%gatepass.setindex(index);%>  

                            <% if(gatepass.getmdt() == 1 ){%>
                                <jsp:setProperty name="gatepass" property="rate" value="${book.rate - book.commission}"/>
                            <%}%>
                            <% if(gatepass.getmdt() == 2 ){%>
                                <jsp:setProperty name="gatepass" property="rate" value="${book.rate}"/>
                            <%}%>
                            <% if(gatepass.getmdt() == 3 ){%>
                                <jsp:setProperty name="gatepass" property="rate" value="${book.rate - book.commission - book.tcd}"/>
                            <%}%>
                            <% if(gatepass.getmdt() == 4 ){%>
                                <jsp:setProperty name="gatepass" property="rate" value="${book.utprate}"/> 
                            <%}%>
                            <% if(gatepass.getmdt() == 5 ){%>
                                <jsp:setProperty name="gatepass" property="rate" value="${book.subsidy}"/> 
                            <%}%>                                

                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:18px;text-align:center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:18px;text-align:left;width: 5%;">     
                                    <a href="newGatePass.jsp?prodtype=${book.prodtype}&blnCstIndt=true&tcd=${book.tcd}&comm=0.00&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                </td>                             
                                <td style="font-size:18px;text-align:right;width: 2%;">          
                                    <jsp:getProperty name='gatepass' property='qty'/> 
                                </td>   
                                <td style="font-size:18px;text-align: right;width: 2%;">          
                                    <jsp:getProperty name="gatepass" property="rate"/>
                                </td>
                                <td style="font-size:18px;text-align: right;width: 2%;">                                    
                                    <%= gatepass.getqty() * gatepass.getrate()%>
                                </td>    
                            </tr>
                        </c:forEach>  
                    <%}%>
                </table>
                <table onmouseout="setFocus()" onmouseover="setFocus()" cellpadding="3" width="90%">
                    <%if(!gatepass.getblnValue()){%>                                               
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>                                
                                <th>QUANTITY</th>
                                <th>Change.QTY</th>
                                <th>RATE</th>
                                <th>ADD</th>
                            </tr>                                                
                        </thead>                                                  
                        <%index = -1;%>
                        <%slno = 0 ;%>                            
                        <%tracker = -1 ;%>  
                        <c:forEach items="${prod.rows}" var="book" varStatus="stat">
                            <%index++;%>    
                            <%slno++;%>   
                            <%tracker++;%>   
                            <%gatepass.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:18px; text-align: center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:18px; text-align: left;width: 5%;">     
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <a class="qty" href="newGatePass.jsp?prodtype=${book.prodtype}&blnCstIndt=true&tcd=${book.tcd}&comm=0.00&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                    <%}else{%> 
                                        <a href="newGatePass.jsp?prodtype=${book.prodtype}&blnCstIndt=true&tcd=${book.tcd}&comm=0.00&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                    <%}%>                                                                        
                                </td>                             
                                <td style="font-size:18px; text-align: left;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input size="6" onfocus="this.blur()" class="qty" value="<jsp:getProperty name='gatepass' property='qty'/>">
                                    <%}else{%> 
                                        <jsp:getProperty name='gatepass' property='qty'/>
                                    <%}%>                                    
                                </td>
                                <td style="font-size:18px; text-align: left;width: 3%;">        
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" type="text" size="6" name="qty" value="">                                                                               
                                   <%}else{%> 
                                        <jsp:getProperty name='gatepass' property='qty'/>
                                   <%}%>
                                </td> 
                                <td style="font-size:18px; text-align: right;width: 2%;">                                    
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <%if(gatepass.getrate() > 0 ){%>
                                            <input size="6" name="rate" class="qty" value="${gatepass.rate}">
                                        <%}else{%>
                                            <input size="6" name="rate" class="qty" value="">
                                        <%}%>                                    
                                    <%}else{%> 
                                        <%=gatepass.getrate()%>
                                    <%}%>                                    
                                </td>                                                                                                        
                                <td style=" text-align: left;width: 1%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input type="submit" name="Add" value="Add">                                      
                                        <input type="hidden" name="blnValue" value="true">                               
                                        <input type="hidden" name="prodid"  
                                            value="<jsp:getProperty name="gatepass" property="prodid"/>"  
                                        <input type="hidden" name="custid"  
                                            value="<jsp:getProperty name="gatepass" property="custid"/>"                                              
                                        <input type="hidden" name="product" 
                                            value="<jsp:getProperty name="gatepass" property="product"/>"> 
                                        <input type="hidden" name="index" 
                                            value="<jsp:getProperty name="gatepass" property="index"/>">  
                                    <%}%>
                                </td>
                            </tr>
                        </c:forEach>               
                    <%}%>                        
                </table>                                
            <%}%>   
        </form>
    </body>
</html>
