<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="mktg.backingBean.Indent_1,java.util.Date"%>
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
                form.qty.select();
            }             
            function checkNaN(value){
                if(isNaN(value)){
                    alert("invalid quantity..!!! ");
                }
            }
        </script>
    </head>        
    <jsp:useBean id="indt" scope="session" class="mktg.backingBean.Indent_1" />        
    <jsp:setProperty name="indt" property="index" param="index" />          
    <jsp:setProperty name="indt" property="routeid" param="routeid" />     
    <jsp:setProperty name="indt" property="custid" param="custid" />     
    <jsp:setProperty name="indt" property="talid" param="talid" />         
    <jsp:setProperty name="indt" property="qty" param="qty" />    
    <jsp:setProperty name="indt" property="prodid" param="prodid"/>        
    <jsp:setProperty name="indt" property="firstname" param="firstname"/> 
    <jsp:setProperty name="indt" property="mobileNo" param="mobileNo"/> 
    <jsp:setProperty name="indt" property="cacr" param="cacr"/>    
    <jsp:setProperty name="indt" property="idate" param="idate"/>        
    <jsp:setProperty name="indt" property="blnCstIndt" param="blnCstIndt"/>    
    <jsp:setProperty name="indt" property="blnValue" param="blnValue"/>      
    <jsp:setProperty name="indt" property="rtname" param="rtname"/>    
    <jsp:setProperty name="indt" property="custtype" param="custtype"/>    
    <jsp:setProperty name="indt" property="subsidy" param="subsidy"/>    
    <jsp:setProperty name="indt" property="moreve" param="moreve"/>    
    <jsp:setProperty name="indt" property="mdt" param="mdt"/>    
    <jsp:setProperty name="indt" property="reclock" param="reclock"/>    
    <jsp:setProperty name="indt" property="billno" param="billno"/>    
    <jsp:setProperty name="indt" property="blnSave" param="blnSave"/>    
    <sql:query dataSource="jdbc/kmfmktgNew" 
            var="timing"
            sql="SELECT route.* 
               FROM route 
               WHERE route.timing = 2">
    </sql:query>    
    <body style="background:#820041">            
        <form name="form">  
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>    
            <%                   
                if(request.getParameter("index") != null){
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index").toString()));                       
                }    
            %>      
            <table width="90%">
                <tr>
                    <td style="font-size:18px;color:#ffffff;text-align: left;width: 3%;">Day Indent</td>
                    <td style="font-size:18px;color:#ffffff;text-align: right;width: 3%;">${indt.rtname}</td>
                </tr>
            </table>            
            <sql:query 
                sql="SELECT product.*
                FROM product               
                WHERE product.stateid = (SELECT entystate.id FROM entystate 
                WHERE entystate.statename = ? )      
                ORDER BY product.layoutno  " 
                var="product" 
                dataSource="jdbc/kmfmktgNew" >  
                <sql:param value="${st}"/>
            </sql:query>               
            <table width="90%">
                <tr style="background-color: #FFFF15;color: #000000;font-size:20px;font-weight: bold;font-family: Times New Roman;">
                    <td>
                        <jsp:getProperty name="indt" property="firstname"/>  
                    </td>                        
                    <td>DATE :&nbsp;<%=session.getAttribute("idate") %></td>
                    <% if(indt.getmdt() == 1 ){%>
                        <td>PRICE:&nbsp;Dealer Price</td>
                    <%}%>
                    <% if(indt.getmdt() == 2 ){%>                       
                        <td>PRICE:&nbsp;MRP</td>
                    <%}%>
                    <% if(indt.getmdt() == 3 ){%>
                        <td>PRICE:&nbsp;TCD</td>
                    <%}%>                                                     
                    <% if(indt.getmdt() == 4 ){%>
                        <td>PRICE:&nbsp;UTP</td>
                    <%}%>           
                    <% if(indt.getmdt() == 5 ){%>
                        <td>PRICE:&nbsp;Subsidy</td>
                    <%}%>  
                    <% if(indt.getmdt() == 6 ){%>
                        <td>PRICE:&nbsp;Spl.Rate</td>
                    <%}%>                               
                </tr>
            </table>    
            <%if(indt.getblnCstIndt()){%> 
                <sql:query dataSource="jdbc/kmfmktgNew" 
                    var="ind" 
                    sql="SELECT indent.prodname,indent.quantity,indent.billno,
                    indent.reclock,indent.user,indent.rectimestamp 
                    FROM indent 
                    WHERE indent.customer = ? 
                    AND indent.idate = ? 
                    AND indent.moreve = ? ">
                    <sql:param value="${indt.custid}"/>
                    <sql:param value="${indt.idate}"/>                        
                    <sql:param value="${indt.moreve}"/>                        
                </sql:query>
                <%index = -1;%>
                <c:forEach begin="0" items="${product.rows}" var="book" varStatus="stat">
                    <%index++;%>    
                    <%indt.setindex(index);%>                              
                    <jsp:setProperty name="indt" property="prodid"  value="${book.id}" />
                 <%--   <jsp:setProperty name="indt" property="rate" value="${book.rate}" />    --%>
                    <jsp:setProperty name="indt" property="comm" value="${book.commission}" />    
                    <jsp:setProperty name="indt" property="tax" value="${book.tax}"/>    
                    <jsp:setProperty name="indt" property="cst" value="${book.cst}"/>    
                    <jsp:setProperty name="indt" property="cess" value="${book.cess}"/>    
                    <jsp:setProperty name="indt" property="tcd" value="${book.tcd}"/> 
                    <jsp:setProperty name="indt" property="splrate" value="${book.splrate}"/> 
                    <jsp:setProperty name="indt" property="product" value="${book.product}"/>                            
                    <jsp:setProperty name="indt" property="qty" value="0.00"/>  
                    <jsp:setProperty name="indt" property="prodtype" value="${book.prodtype}"/>                    
                </c:forEach>
                <c:forEach items="${ind.rows}" var="book" >                                                                                                     
                    <jsp:setProperty property="row" name="indt" value="${book.prodname}"/>
                    <%indt.setindex(indt.getrowno());%>                            
                    <jsp:setProperty property="qty" name="indt" value="${book.quantity}"/>
                    <jsp:setProperty name="indt" property="billno" value="${book.billno}"/>   
                    <jsp:setProperty name="indt" property="reclock" value="${book.reclock}"/>                                        
                    <jsp:setProperty name="indt" property="rectimestamp" value="${book.rectimestamp}"/>                    
                    <jsp:setProperty name="indt" property="user" value="${book.user}"/>
                </c:forEach>                                                                                                          
            <%}%>            
            <table width="90%">
                <tr>
                    <td>     
                        <a style="font-weight: 600;color:#ffffff;font-size:16px; text-align: left;width: 3%;" 
                            accesskey="c" href="../customerList.jsp">Customer List</a>
                    </td>                       
                    <td>                          
                        <%if(!indt.getreclock()){%>                        
                            <%if(indt.getblnSave()){%>                        
                                <a style="font-weight: 600;color:#ffffff;font-size:16px; text-align: left;width: 3%;" 
                                    accesskey="s" href="../IndentSer">Save</a>
                            <%}%>       
                        <%}%>                                                       
                    </td>
                    <td style="font-size:14px; text-align: left;width: 3%;">   
                        <c:if test="${indt.moreve == 'E'}">
                            <c:forEach begin="0" items="${timing.rows}" var="book">
                                <select name="routeid">
                                <option value="${book.id}"><c:out value="${book.route}"/></option>
                                </select>                                                                    
                            </c:forEach> 
                        </c:if>
                    </td>    
                    <td style="font-size:14px; text-align: left;width: 1%;">                                                                                  
                    </td>                        
                </tr>                    
            </table>                  
            <table cellpadding="3" width="90%">                                                                                                                         
                <% if(indt.getblnValue()){%>    
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
                    <c:forEach items="${product.rows}" var="book" varStatus="stat">
                        <%index++;%>    
                        <%slno++;%>    
                        <%indt.setindex(index);%> 
                        
                        <% if(indt.getmdt() == 1 ){%>
                            <jsp:setProperty name="indt" property="rate" value="${book.rate - book.commission}"/>
                        <%}%>
                        <% if(indt.getmdt() == 2 ){%>
                            <jsp:setProperty name="indt" property="rate" value="${book.rate}"/>
                        <%}%>
                        <% if(indt.getmdt() == 3 ){%>
                            <jsp:setProperty name="indt" property="rate" value="${book.rate - book.commission - book.tcd}"/>
                        <%}%>     
                        <% if(indt.getmdt() == 4 ){%>
                            <jsp:setProperty name="indt" property="rate" value="${book.utprate}"/>
                        <%}%>     
                        <% if(indt.getmdt() == 5 ){%>
                            <jsp:setProperty name="indt" property="rate" value="${book.subsidy}"/>
                        <%}%> 
                        <% if(indt.getmdt() == 6 ){%>
                            <%--<jsp:setProperty name="indt" property="rate" value="0.00" /> --%>
                            <jsp:setProperty name="indt" property="rate" value="${book.rate - book.commission - book.splrate}"/>
                        <%}%> 

                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">                                
                            <td style="font-size:14px; text-align: center;width: 1%;">     
                                <%=slno%>
                            </td>
                            <td style="${indt.qty > 0 ? "color:#F31105;font-size:18px;text-align:left;width:9%;font-weight: bold;" : "font-size:18px;text-align:left;width:9%;"}">     
                                <%--<a href="indent_1.jsp?blnCstIndt=false&tcd=${book.tcd}&comm=${book.commission}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>--%>                                    
                                <%if(indt.getreclock()){%>
                                    ${book.product}                                        
                                <%}else{%>    
                                    <a href="indent_1.jsp?product=${book.product}&blnCstIndt=false&prodid=${book.id}&index=<%=index%>&blnValue=false">${book.product}</a>
                                <%}%>
                            </td>                             
                            <td style="${indt.qty > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <jsp:getProperty name='indt' property='qty'/> 
                            </td>                                  
                            <td style="${indt.qty > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <jsp:getProperty name="indt" property="rate"/>
                            </td>                                  
                            <td style="${indt.qty > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <fn:formatNumber currencySymbol="Rs." type="currency" value="<%= indt.getqty() * indt.getrate()%>" />
                            </td>                                    
                        </tr>
                    </c:forEach>  
                <%}%>
            </table>
            <table onmouseout="setFocus()" onmouseover="setFocus()" cellpadding="3" width="90%">
                <% if(!indt.getblnValue()){%>  
                    <thead>
                        <tr style="background-color: #FF8F59">
                            <th>SL.NO</th>                            
                            <th>PRODUCT</th>                                
                            <th>QUANTITY</th>
                            <th>QTY.</th> 
                            <th>ADD</th>
                        </tr>                                                
                    </thead>                                                  
                    <%index = -1;%>
                    <%slno = 0 ;%>                            
                    <%tracker = -1 ;%>  
                    <c:forEach begin="0" items="${product.rows}" var="book" varStatus="stat">
                        <%index++;%>    
                        <%slno++;%>   
                        <%tracker++;%>   
                        <%indt.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:20px; text-align: center;width: 1%;">     
                                <%=slno%>
                            </td>
                            <td style="font-size:20px; text-align: left;width: 5%;">     
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <a class="qty" href="indent_1.jsp?blnCstIndt=false&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                    
                                <%}else{%>                                         
                                    <a href="indent_1.jsp?blnCstIndt=false&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                                                        
                                <%}%>                                    
                            </td>                             
                            <td style="font-size:20px; text-align: left;width: 3%;">                                          
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input size="5" onfocus="this.blur()" class="qty" value="<jsp:getProperty name='indt' property='qty'/>">
                                <%}else{%>                                                                                 
                                    <jsp:getProperty name='indt' property='qty'/> 
                                <%}%>
                            </td>                                                                
                            <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" onchange="checkNaN(this.value)" type="text" size="5" name="qty" value="">        
                                <%}else{%>                                         
                                    <jsp:getProperty name='indt' property='qty'/>
                                <%}%>
                            </td>                                                                                                                                 
                            <td style=" text-align: left;width: 1%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input type="submit" name="Add" value="Add">                                      
                                    <input type="hidden" name="blnValue" value="true">   
                                    <input type="hidden" name="blnSave" value="true">   
                                    <input type="hidden" name="prodid"  
                                    value="<jsp:getProperty name="indt" property="prodid"/>"  
                                    <input type="hidden" name="custid"  
                                    value="<jsp:getProperty name="indt" property="custid"/>"                                              
                                    <input type="hidden" name="product" 
                                    value="<jsp:getProperty name="indt" property="product"/>"> 
                                    <input type="hidden" name="index" 
                                    value="<jsp:getProperty name="indt" property="index"/>">  
                                <%}%>
                            </td>
                        </tr>
                    </c:forEach>               
                <%}%>                        
            </table>  
            <font size="1" face="Arial Narrow, System" color="#CC99FF"><b>
            Record last accessed on : <jsp:getProperty name="indt" property="rectimestamp"/> By <jsp:getProperty name="indt" property="user"/></b></font>
        </form> 
    </body>
</html>