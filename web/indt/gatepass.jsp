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
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INDENT FORM</title>        
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">         
        <style type="text/css">
            .qty{text-align: right;background-color: #A0A050;color: #ffffff;font-weight: 700;}
        </style>        
        <script type="text/javascript">            
            function setFocus(){                 
                indentForm.qty.select();
            }            
        </script>
    </head>        
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
    
    <jsp:setProperty name="gatepass" property="blnCustList" param="blnCustList"/>
    
    <jsp:setProperty name="gatepass" property="blnValue" param="blnValue"/>   
    
    <jsp:setProperty name="gatepass" property="rtname" param="rtname"/>
    
    <jsp:setProperty name="gatepass" property="prodtype" param="prodtype"/>
    
    <jsp:setProperty name="gatepass" property="dft" param="dft"/>
    
    <sql:query 
        sql="SELECT product.*
             FROM product               
             WHERE product.stateid = 1      
             ORDER BY product.layoutno  " 
        var="product" 
        dataSource="jdbc/kmfmktgNew" >                
    </sql:query>  
    <sql:query 
        sql="SELECT route.*
             FROM route                
             WHERE route.saletype = 2 " 
        var="route" 
        dataSource="jdbc/kmfmktgNew" >                
    </sql:query>    
    <body>         
        <form name="indentForm">  
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>    
            <%!public boolean blnCstIndt = false; %>
            <%!public boolean blnNE = false; %>
            <%!public boolean blnNE1 = false; %>
            <%!public boolean blngatepassList = false; %>    
            <%!public boolean blnShow = false; %>
            <%!public String cstname; %>
            <%!public boolean blnCstData = false;%>
            <%!public int billno = 0;%>
            <%!public boolean gatePassList = true; %>            
            <%      
                if(request.getParameter("dft") != null)
                    Integer.parseInt(request.getParameter("dft"));
                    
                if(request.getParameter("gatePassList") != null)
                    gatePassList = Boolean.parseBoolean(request.getParameter("gatePassList"));                    
                    
                if(request.getParameter("billno") != null)
                    billno = Integer.parseInt(request.getParameter("billno"));
                    
                if(request.getParameter("prodtype") != null)
                    Integer.parseInt(request.getParameter("prodtype"));
                    
                if(request.getParameter("blnNE1") !=null)                
                   blnNE1 = Boolean.parseBoolean(request.getParameter("blnNE1"));                                    
                   
                if(request.getParameter("blnNE") !=null)
                   blnNE = Boolean.parseBoolean(request.getParameter("blnNE"));                                    
                               
                if(request.getParameter("blnCstIndt") !=null)
                   blnCstIndt = Boolean.parseBoolean(request.getParameter("blnCstIndt"));                    
                
                if(request.getParameter("idate") != null){
                    request.getParameter("idate");
                    session.setAttribute("idate",request.getParameter("idate"));
                }
                
                if(request.getParameter("talid") != null)
                    Integer.parseInt(request.getParameter("talid"));

                if(request.getParameter("custid") != null)
                    Integer.parseInt(request.getParameter("custid"));

                if(request.getParameter("prodid") != null)    
                    Integer.parseInt(request.getParameter("prodid"));

                if(request.getParameter("routeid") != null)
                    Integer.parseInt(request.getParameter("routeid"));

                if(request.getParameter("index") != null)
                    Integer.parseInt(request.getParameter("index"));

                if(request.getParameter("index") != null)                        
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index").toString()));                       

               if(request.getParameter("qty") != null && request.getParameter("qty").length() >0 )
                    Double.parseDouble(request.getParameter("qty"));

                if(request.getParameter("firstname") != null)
                    request.getParameter("firstname");                   

                if(request.getParameter("blnValue") !=null)
                    Boolean.parseBoolean(request.getParameter("blnValue"));    
                    
                if(request.getParameter("blnCustList") !=null)
                    Boolean.parseBoolean(request.getParameter("blnCustList"));   
                    
                if(request.getParameter("blngatepassList") !=null)
                    blngatepassList = Boolean.parseBoolean(request.getParameter("blngatepassList"));   
                    
                if(request.getParameter("blnShow") !=null)
                    blnShow = Boolean.parseBoolean(request.getParameter("blnShow"));   

                if(request.getParameter("rate") !=null)
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
                    request.getParameter("cacr");
                    
                if(request.getParameter("cstname") != null)    
                    cstname = request.getParameter("cstname");
                    
                if(request.getParameter("blnCstData") != null)    
                    blnCstData = Boolean.parseBoolean(request.getParameter("blnCstData"));   
                    
            %>                          
            <%if(gatepass.getblnCustList()){%>
                <a href="gatepass.jsp?blnNE=true&blnNE1=false&blnCstData=false">New GatePass</a>
                <a href="gatepass.jsp?blnNE1=true&blnNE=false&blnCstData=false&blngatepassList=false">Existing GatePass</a>
            <%}%>
            <%if(blnNE){%>
                <table>
                    <tr>
                        <td style="text-align: right;">
                            GATEPASS DATE :
                        </td>
                        <td style="text-align: left;">
                            <input type="text" size="10" name="idate"> 
                        </td> 
                    </tr>
                    <tr>
                        <td style="text-align: right;">
                            CUSTOMER NAME :
                        </td>
                        <td style="text-align: left;">
                            <input size="25" maxlength="50" name="firstname"> 
                        </td>
                    </tr> 
                    <tr>
                        <td style="text-align: right;">
                            GATE PASSE :
                        </td>
                        <td style="text-align: left;">
                            <select name="rtname">
                                <c:forEach var="book" begin="0" items="${route.rows}" >
                                    <option><c:out value="${book.route}" /></option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>                     
                    <tr>
                        <td style="text-align: right;">
                            
                        </td>
                        <td style="text-align: left;">
                            <select name="dft">                            
                                <option value="1">Dealer Price</option>                            
                                <option value="4">Full Amount</option>                            
                                <option value="5">TCD</option> 
                            </select>
                        </td>
                    </tr>                                         
                    <tr>                        
                        <td></td>
                        <td style="text-align: left;">
                            <input type="submit" value="Submit">                         
                            <input type="hidden" value="false" name="blnCustList">
                            <input type="hidden" value="true" name="blnCstIndt">
                            <input type="hidden" value="false" name="blnNE">
                            <input type="hidden" value="1" name="talid">
                        </td>                        
                    </tr>                
                </table>                   
            <%}%>   
            <%if(blnCstIndt){%>
                    <table width="90%">
                        <tr style="background-color: #FF9DCE;color: #000000;font-size:16px;">
                            <td>
                                <jsp:getProperty name="gatepass" property="firstname"/>  
                            </td>                        
                             <td>INDENT DATE :</td>
                             <td><jsp:getProperty name="gatepass" property="idate"/></td>
                        </tr>
                    </table>    
                    <table>
                        <tr>
                            <td style="font-size:14px; text-align: left;width: 5%;">     
                                <%--<a href="gatepass.jsp?blnCustList=true&blnCstIndt=true">Customer List</a>--%>
                                <a href="../gatepassSer">Save</a>
                            </td>                       
                            <td style="font-size:14px; text-align: left;width: 6%;">                                 
                            </td>
                            <td style="font-size:14px; text-align: left;width: 3%;">     
                                <%--<a href="../ClearCart?blnCustList=false">Clear List</a>--%>
                                <a href="../Cleargp">Clear List</a>
                            </td>
                        </tr>                    
                    </table>                                                                   
                    <table width="90%">                                                                                                                         
                        <% if(gatepass.getblnValue()){%>                         
                            <thead>
                                <tr style="background-color: #FF8F59">
                                    <th>SL.NO</th>                            
                                    <th>PRODUCT</th>
                                    <th>QUANTITY</th>
                                    <th>AMOUNT</th>
                                </tr>                                                
                            </thead>                                                                   
                            <%index = -1;%>
                            <%slno = 0 ;%>    
                            <c:forEach items="${product.rows}" var="book" varStatus="stat">
                                <%index++;%>    
                                <%slno++;%>    
                                <%gatepass.setindex(index);%>                               
                                <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                    <td style="font-size:14px; text-align: center;width: 1%;">     
                                        <%=slno%>
                                    </td>
                                    <td style="font-size:14px; text-align: left;width: 5%;">     
                                        <a href="gatepass.jsp?prodtype=${book.prodtype}&blnCstIndt=true&tcd=${book.tcd}&comm=${book.commission}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                        <%--<a href="gatepass.jsp?blnCstIndt=true&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>--%>
                                    </td>                             
                                    <td style=" text-align: right;width: 2%;">          
                                        <jsp:getProperty name='gatepass' property='qty'/> 
                                    </td>    
                                    <td style=" text-align: right;width: 2%;">                                    
                                        <%= gatepass.getqty() * gatepass.getrate()%>
                                    </td>    
                                </tr>
                            </c:forEach>  
                        <%}%>
                </table>
                <table width="90%">
                    <% if(!gatepass.getblnValue()){%>                                               
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>                                
                                <th>QUANTITY</th>
                                <th>Change.QTY</th>
                                <th>ADD</th>
                            </tr>                                                
                        </thead>                                                  
                        <%index = -1;%>
                        <%slno = 0 ;%>                            
                        <%tracker = -1 ;%>  
                        <c:forEach items="${product.rows}" var="book" varStatus="stat">
                            <%index++;%>    
                            <%slno++;%>   
                            <%tracker++;%>   
                            <%gatepass.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:14px; text-align: center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:14px; text-align: left;width: 5%;">     
                                    <a onmouseout="setFocus()" onmouseover="setFocus()" href="gatepass.jsp?prodtype=${book.prodtype}&blnCstIndt=true&tcd=${book.tcd}&comm=${book.commission}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                    <%--<a onmouseout="setFocus()" onmouseover="setFocus()" href="gatepass.jsp?blnCstIndt=true&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>--%>                                    
                                </td>                             
                                <td style=" text-align: left;width: 3%;">        
                                    <jsp:getProperty name='gatepass' property='qty'/>
                                </td>
                                <td style=" text-align: left;width: 3%;">        
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" type="text" size="5" name="qty" 
                                            value="">                                       
                                   <%}else{%> 
                                        <jsp:getProperty name='gatepass' property='qty'/>
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
            
            
            
            
            
            
            
            
            
            
            
            
            <%if(blnNE1){%>
                <table>
                    <tr>
                        <td style="text-align: right;">
                        GATEPASS DATE :
                        </td>
                        <td style="text-align: left;">
                            <input type="text" size="10" name="idate"> 
                        </td>                   
                        <td style="text-align: left;">      
                            <input type="hidden" value="false" name="blnShow">
                            <input type="hidden" value="true" name="gatePassList"> 
                            <input type="hidden" value="true" name="blngatepassList">
                            <input type="hidden" value="false" name="blnCstIndt">
                            <input type="hidden" value="false" name="blnNE">
                            <input type="hidden" value="1" name="talid">
                            <input type="hidden" value="true" name="blnNE1">
                            <input type="submit" value="Submit">
                        </td>                        
                    </tr>                
                </table> 
                
                
                
                
                
                <%if(blngatepassList){%>     
                
                    
                    <%=gatePassList%>
                
                    <%if(gatePassList){%>                                                     
                        <sql:query dataSource="jdbc/kmfmktgNew" 
                            var="ind" 
                            sql="SELECT DISTINCT indent.custname,indent.billno FROM indent                          
                            WHERE indent.idate = ? 
                            AND indent.saletype = 2 ">
                            <sql:param value="${gatepass.idate}"/>                        
                        </sql:query>                
                        <%slno = 0;%>
                        <table width="90%">
                            <thead>
                                <tr style="background-color: #FF8F59">
                                    <th>SL.NO</th>                            
                                    <th>GatePass</th>                                
                                    <th>Customer</th>
                                </tr>                                                
                            </thead>                                                                              
                            <c:forEach items="${ind.rows}" var="book" varStatus="stat">
                                <%slno++;%> 
                                <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                    <td style="font-size:14px; text-align: center;width: 1%;">     
                                        <%=slno%>
                                    </td>
                                    <td style="font-size:14px; text-align: center;width: 1%;">     
                                        ${book.billno}
                                    </td>
                                    <td style="font-size:14px; text-align: center;width: 1%;">     
                                        <a href="gatepass.jsp?gatePassList=false&billno=${book.billno}&blnCstData=true&blnShow=true&cstname=${book.custname}">${book.custname}</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    <%}%>
                    
                    
                    
                    
                    
                    
                    <%if(blnShow){%>                                        
                        <table width="90%">
                            <tr style="background-color: #FF9DCE;color: #000000;font-size:16px;">
                                <td>
                                    <jsp:setProperty name="gatepass" property="firstname" value="<%=cstname%>"/>
                                    <jsp:getProperty name="gatepass" property="firstname"/>  
                                </td>                        
                                <td>GATEPASS DATE :</td>
                                <td>${date}</td>
                            </tr>
                        </table>                                                   
                        <table>
                            <tr>
                                <td style="font-size:14px; text-align: left;width: 5%;">     
                                <a href="gatepass.jsp?gatePassList=true&blnShow=false&blngatepassList=true&blnCstIndt=false">Gatepass List</a>
                                </td>                       
                                <td style="font-size:14px; text-align: left;width: 6%;">     
                                    <a href="../gatepassSer">Save</a>
                                </td>
                                <td style="font-size:14px; text-align: left;width: 3%;">     
                                    <a href="../Cleargp">Clear List</a>
                                </td>
                            </tr>                    
                        </table>                                
                        <%if(blnCstData){%>                                  
                            <sql:query dataSource="jdbc/kmfmktgNew" 
                                var="ind" 
                                sql="SELECT indent.* FROM indent 
                                WHERE indent.custname = ? 
                                AND indent.idate = ? 
                                AND indent.saletype = 2 
                                AND indent.billno = ? ">
                                <sql:param value="<%=cstname%>"/>
                                <sql:param value="${gatepass.idate}"/> 
                                <sql:param value="<%=billno%>"/>
                            </sql:query>
                            <%index = -1;%>
                            <c:forEach items="${product.rows}" var="book" varStatus="stat">
                                <%index++;%>    
                                <%gatepass.setindex(index);%>  
                                <jsp:setProperty name="gatepass" property="prodid"  value="${book.id}" />
                                <jsp:setProperty name="gatepass" property="rate" value="${book.rate}" />    
                                <jsp:setProperty name="gatepass" property="comm" value="${book.commission}" />    
                                <jsp:setProperty name="gatepass" property="tax" value="${book.tax}"/>    
                                <jsp:setProperty name="gatepass" property="cst" value="${book.cst}"/>    
                                <jsp:setProperty name="gatepass" property="cess" value="${book.cess}"/>    
                                <jsp:setProperty name="gatepass" property="tcd" value="${book.tcd}"/>                            
                                <jsp:setProperty name="gatepass" property="product"  value="${book.product}"/> 
                                <jsp:setProperty name="gatepass" property="prodtype" value="${book.prodtype}"/>
                                <jsp:setProperty name="gatepass" property="qty"  value="0.00"/>  
                            </c:forEach>
                            <c:forEach items="${ind.rows}" var="book" >                                                                                                     
                                <jsp:setProperty property="row" name="gatepass" value="${book.prodname}"/>
                                <%gatepass.setindex(gatepass.getrowno());%>                            
                                <jsp:setProperty property="qty" name="gatepass" value="${book.quantity}"/>
                                <jsp:setProperty name="gatepass" property="billno" value="${book.billno}"/>                            
                              <%--  PRODUCT NAME : ${book.prodname}
                                ROW No : <%=gatepass.getrowno()%> <br> --%>
                            </c:forEach>                                                                                                          
                        <%}%>
                        <table width="90%">                                                                                                                         
                            <% if(gatepass.getblnValue()){%>                         
                                <thead>
                                    <tr style="background-color: #FF8F59">
                                        <th>SL.NO</th>                            
                                        <th>PRODUCT</th>
                                        <th>QUANTITY</th>
                                        <th>AMOUNT</th>
                                    </tr>                                                
                                </thead>                                                                   
                                <%index = -1;%>
                                <%slno = 0 ;%>    
                                <c:forEach items="${product.rows}" var="book" varStatus="stat">
                                    <%index++;%>    
                                    <%slno++;%>    
                                    <%gatepass.setindex(index);%>                               
                                    <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                        <td style="font-size:14px; text-align: center;width: 1%;">     
                                            <%=slno%>
                                        </td>
                                        <td style="font-size:14px; text-align: left;width: 5%;">     
                                            <a href="gatepass.jsp?blnCstData=false&tcd=${book.tcd}&comm=${book.commission}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                        </td>                             
                                        <td style=" text-align: right;width: 2%;">          
                                            <jsp:getProperty name='gatepass' property='qty'/> 
                                        </td>    
                                        <td style=" text-align: right;width: 2%;">                                    
                                            <%= gatepass.getqty() * gatepass.getrate()%>
                                        </td>    
                                    </tr>
                                </c:forEach>  
                            <%}%>
                        </table>
                        <table width="90%">
                            <% if(!gatepass.getblnValue()){%>                                               
                                <thead>
                                    <tr style="background-color: #FF8F59">
                                        <th>SL.NO</th>                            
                                        <th>PRODUCT</th>                                
                                        <th>QUANTITY</th>
                                        <th>Change.QTY</th>
                                        <th>ADD</th>
                                    </tr>                                                
                                </thead>                                                  
                                <%index = -1;%>
                                <%slno = 0 ;%>                            
                                <%tracker = -1 ;%>  
                                <c:forEach items="${product.rows}" var="book" varStatus="stat">
                                    <%index++;%>    
                                    <%slno++;%>   
                                    <%tracker++;%>   
                                    <%gatepass.setindex(index);%> 
                                    <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                        <td style="font-size:14px; text-align: center;width: 1%;">     
                                            <%=slno%>
                                        </td>
                                        <td style="font-size:14px; text-align: left;width: 5%;">     
                                            <a onmouseout="setFocus()" onmouseover="setFocus()" href="gatepass.jsp?blnCstData=false&tcd=${book.tcd}&comm=${book.commission}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                            
                                        </td>                             
                                        <td style=" text-align: left;width: 3%;">        
                                             <jsp:getProperty name='gatepass' property='qty'/>
                                        </td>
                                        <td style=" text-align: left;width: 3%;">        
                                            <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                                <input class="qty" type="text" size="5" name="qty" value="">                                       
                                            <%}else{%> 
                                                <jsp:getProperty name='gatepass' property='qty'/>
                                            <%}%>
                                        </td> 
                                        <td style=" text-align: left;width: 1%;">        
                                            <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                                <input type="submit" name="Add" value="Add">                                      
                                                <input type="hidden" name="blnValue" value="true">                               
                                                <input type="hidden" value="false" name="gatePassList">
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
                <%}%> 
            <%}%>             
        </form>
    </body>
</html>
