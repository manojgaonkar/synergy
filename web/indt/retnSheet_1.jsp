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
            .qty{font-size:20px;text-align: right;background-color: ;color: #954A00;font-weight: 900;}
        </style>        
        <script type="text/javascript">            
            function setFocus(){                 
                indentForm.qty.select();
            }            
        </script>
    </head>        
    <jsp:useBean id="retnSheet" scope="session" class="mktg.backingBean.retnSheet_1" />   
    <jsp:setProperty name="retnSheet" property="index" param="index" />          
    <jsp:setProperty name="retnSheet" property="routeid" param="routeid" />     
    <jsp:setProperty name="retnSheet" property="custid" param="custid" />     
    <jsp:setProperty name="retnSheet" property="talid" param="talid" />         
    <jsp:setProperty name="retnSheet" property="qty" param="qty" />
    <jsp:setProperty name="retnSheet" property="dmd" param="dmd" />    
    <jsp:setProperty name="retnSheet" property="rate" param="rate" />
    <jsp:setProperty name="retnSheet" property="firstname" param="firstname"/>    
    <jsp:setProperty name="retnSheet" property="cacr" param="cacr"/>    
    <jsp:setProperty name="retnSheet" property="idate" param="idate"/>    
    <jsp:setProperty name="retnSheet" property="blnCustList" param="blnCustList"/>    
    <jsp:setProperty name="retnSheet" property="blnValue" param="blnValue"/>      
    <jsp:setProperty name="retnSheet" property="blnCstIndt" param="blnCstIndt"/>  
    <jsp:setProperty name="retnSheet" property="rtname" param="rtname"/>    
    <jsp:setProperty name="retnSheet" property="custtype" param="custtype"/>    
    <jsp:setProperty name="retnSheet" property="subsidy" param="subsidy"/>    
    <jsp:setProperty name="retnSheet" property="moreve" param="moreve"/>    
    <jsp:setProperty name="retnSheet" property="leakage" param="leakage"/>
    <jsp:setProperty name="retnSheet" property="sf" param="sf"/>            
    <jsp:setProperty name="retnSheet" property="hl" param="hl"/>                        
    <jsp:setProperty name="retnSheet" property="retn" param="retn"/>        
    <jsp:setProperty name="retnSheet" property="mdt" param="mdt"/>    
    <jsp:setProperty name="retnSheet" property="reclock" param="reclock"/>    
    <jsp:setProperty name="retnSheet" property="billno" param="billno"/>    
    
    <sql:query dataSource="jdbc/kmfmktgNew" 
            var="timing"
            sql="SELECT route.* 
               FROM route 
               WHERE route.timing = 2">
    </sql:query>    
    <body style="background:#820041">            
        <form name="indentForm">  
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>  
            <%!public String rt; %>  
            <%!public String moreve;%>                                 
            <%!public int mdt = 0;%>            
            <%!public boolean blnCstIndt = true; %>           
            <%               
                if(request.getParameter("moreve") != null)
                    moreve = request.getParameter("moreve");

                if(request.getParameter("mdt") != null)
                    mdt = Integer.parseInt(request.getParameter("mdt"));
                
                if(request.getParameter("blnCstIndt") !=null)
                  blnCstIndt = Boolean.parseBoolean(request.getParameter("blnCstIndt"));                    

                if(request.getParameter("idate") != null){
                    session.setAttribute("idate",request.getParameter("idate"));
                }
                
                if(request.getParameter("index") != null){
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index").toString()));                       
                }    
                if(request.getParameter("blnValue") !=null)
                    Boolean.parseBoolean(request.getParameter("blnValue"));    

                if(request.getParameter("blnCustList") !=null)
                    Boolean.parseBoolean(request.getParameter("blnCustList"));   
                
                  if(request.getParameter("rt") !=null)
                    rt = request.getParameter("rt");
  
            %>               
            <c:if test="${param.rt != null}">
                <c:set scope="session" var="st" value="${param.sta}" />
                <c:set scope="session" var="rt" value="${param.rt}" />
                <c:set scope="session" var="date" value="${param.idate}" />                 
            </c:if>            

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
            <sql:query 
                sql="SELECT customer.* 
                FROM customer 
                WHERE customer.custtype != 2 
                and customer.custtype != 3  
                and route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.ROUTE = ? ) 
                ORDER BY customer.firstname "
                var="cst" dataSource="jdbc/kmfmktgNew" >        
                <sql:param value="${rt}"/>                       
            </sql:query>  
            <table width="90%">
                <tr>
                    <td style="font-weight: 600;color:#ffffff;text-align: left;width: 3%;">Return Sheet</td>
                    <td style="font-weight: 600;color:#ffffff;text-align: right;width: 3%;">${retnSheet.rtname}</td>
                </tr>
            </table>                        
            <center>
            <%if(retnSheet.getblnCustList()){%>  
                <table cellpadding="3" width="70%">    
                    <tr>
                        <td>
                            <font style="font-size:16px;color:#ffffff">STATE&nbsp;&gt;${st}&nbsp;:Route&nbsp;&gt;${rt}</font>
                        </td>
                        <td>
                            <font style="font-size:16px;color:#ffffff">&nbsp;<%=session.getAttribute("idate")%></font>
                        </td>                    
                        <td>
                            <a style="font-size:16px;color:#ffffff" href="retnstatedate.jsp">Change Route</a>
                        </td>
                    </tr>
                </table>               
                <%slno=0;%>
                <table cellpadding="3" width="70%">  
                    <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                        <th>SL.NO</th>                            
                        <th>CUSTOMERS</th>
                    </tr>                     
                    <c:forEach begin="0" var="book" items="${cst.rows}" >    
                        <%slno++;%>
                        <tr style="font-size:24px;background-color:#00B0B0 ;color: #ffffff">
                            <td style="width: 2%">
                                <%=slno%>
                            </td>
                            <td style="text-align: left;width: 30%">                                                                                                   
                                <a style="color:#ffffff" accesskey="${book.firstname}" href="retnSheet_1.jsp?billno=0&reclock=false&mdt=${book.ratetype}&moreve=<%=moreve%>&rtname=${rt}&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>
                            </td>     
                        </tr>                                   
                    </c:forEach>                                                                                  
                </table></center>
            <%}else{%>     
                <table width="90%">
                    <tr style="background-color: #FFFF15;color: #000000;font-size:20px;font-weight: bold;font-family: Times New Roman;">
                        <td>
                            <jsp:getProperty name="retnSheet" property="firstname"/>  
                        </td>                        
                        <td>
                            DATE:&nbsp;${date}
                        </td>
                        <% if(mdt == 1 ){%>
                            <td>PRICE:&nbsp;Dealer Price</td>
                        <%}%>
                        <% if(mdt == 2 ){%>
                            <td>PRICE:&nbsp;MRP</td>
                        <%}%>
                        <% if(mdt == 3 ){%>
                            <td>PRICE:&nbsp;TCD</td>
                        <%}%>  
                        <% if(mdt == 4 ){%>
                            <td>PRICE:&nbsp;UTP</td>
                        <%}%> 
                        <% if(mdt == 5 ){%>
                            <td>PRICE:&nbsp;SUBSIDY</td>
                        <%}%>  
                        <% if(mdt == 6 ){%>
                            <td>PRICE:&nbsp;Spl.Rate</td>
                        <%}%>                          
                    </tr>
                </table>                           
                <%if(retnSheet.getblnCstIndt()){%>                   
                    <sql:query dataSource="jdbc/kmfmktgNew" 
                        var="ind" 
                        sql="SELECT indent.prodname,indent.quantity,indent.rate,indent.billno,indent.leakage,
                            indent.returnmilk,indent.sf,indent.hl,indent.reclock,indent.user,indent.demand,
                            indent.rectimestamp  
                            FROM indent 
                            WHERE indent.customer = ? 
                            AND indent.idate = ? 
                            AND indent.moreve = ? ">
                        <sql:param value="${retnSheet.custid}"/>
                        <sql:param value="${retnSheet.idate}"/>                        
                        <sql:param value="${retnSheet.moreve}"/>                        
                    </sql:query>
                    <%index = -1;%>
                    <c:forEach begin="0" items="${product.rows}" var="book" varStatus="stat">
                        <%index++;%>    
                        <%retnSheet.setindex(index);%>                              
                        <jsp:setProperty name="retnSheet" property="prodid"  value="${book.id}" />
                      <%--  <jsp:setProperty name="retnSheet" property="rate" value="${book.rate}" />    --%>
                        <jsp:setProperty name="retnSheet" property="comm" value="${book.commission}" />    
                        <jsp:setProperty name="retnSheet" property="tax" value="${book.tax}"/>    
                        <jsp:setProperty name="retnSheet" property="cst" value="${book.cst}"/>    
                        <jsp:setProperty name="retnSheet" property="cess" value="${book.cess}"/>    
                        <jsp:setProperty name="retnSheet" property="tcd" value="${book.tcd}"/>                            
                        <jsp:setProperty name="retnSheet" property="product"  value="${book.product}"/>                            
                        <jsp:setProperty name="retnSheet" property="qty"  value="0.00"/>  
                        <jsp:setProperty name="retnSheet" property="dmd" value="0.00"/>
                        <jsp:setProperty name="retnSheet" property="prodtype" value="${book.prodtype}"/>
                    </c:forEach>
                    <c:forEach items="${ind.rows}" var="book" >                                                                                                     
                        <jsp:setProperty property="row" name="retnSheet" value="${book.prodname}"/>
                        <%retnSheet.setindex(retnSheet.getrowno());%>                          
                        <jsp:setProperty property="qty" name="retnSheet" value="${book.quantity}"/>
                        <jsp:setProperty property="dmd" name="retnSheet" value="${book.demand}"/>
                        <jsp:setProperty property="rate" name="retnSheet" value="${book.rate}"/>
                        <jsp:setProperty property="billno" name="retnSheet"  value="${book.billno}"/>   
                        <jsp:setProperty property="leakage" name="retnSheet" value="${book.leakage}"/>
                        <jsp:setProperty property="retn" name="retnSheet" value="${book.returnmilk}"/>
                        <jsp:setProperty property="sf" name="retnSheet" value="${book.sf}"/>
                        <jsp:setProperty property="hl" name="retnSheet" value="${book.hl}"/>
                        <jsp:setProperty property="reclock" name="retnSheet" value="${book.reclock}"/>                            
                        <jsp:setProperty property="user" name="retnSheet" value="${book.user}"/>
                        <jsp:setProperty property="rectimestamp" name="retnSheet" value="${book.rectimestamp}"/>
                    </c:forEach>                                                                                                          
                <%}%>                       
                <table width="90%">
                    <tr>
                        <td>     
                            <a style="font-weight: 600;color:#ffffff;font-size:14px; text-align: left;width: 3%;" 
                                accesskey="c" href="retnSheet_1.jsp?blnCustList=true&blnCstIndt=true">Customer List</a>
                        </td>                       
                        <td style="font-size:14px; text-align: left;width: 3%;">   
                        </td>
                        <td>   
                            <c:if test="${retnSheet.moreve == 'E'}">
                                <c:forEach begin="0" items="${timing.rows}" var="book">
                                    <select name="routeid">
                                        <option value="${book.id}"><c:out value="${book.route}"/></option>
                                    </select>                                                                    
                                </c:forEach> 
                            </c:if>
                        </td>    
                        <td style="font-weight: 600;font-size:14px; text-align: left;width: 1%;">     
                            <%if(!retnSheet.getreclock()){%>
                                <a style="color:#ffffff;font-size:14px; text-align: left;width: 3%;" 
                                    accesskey="s" href="../retnSheetSer_1">Save</a>
                            <%}%>                                                       
                        </td>                        
                    </tr>                    
                </table>                                                        
                <table cellpadding="3" width="90%">                                                                                                                         
                    <% if(retnSheet.getblnValue()){%>                         
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
                            <%retnSheet.setindex(index);%>                                
                            <% if(mdt == 1 ){%>
                                <jsp:setProperty name="retnSheet" property="rate" value="${book.rate - book.commission}"/>
                            <%}%>
                            <% if(mdt == 2 ){%>
                                <jsp:setProperty name="retnSheet" property="rate" value="${book.rate}"/>
                            <%}%>
                            <% if(mdt == 3 ){%>
                                <jsp:setProperty name="retnSheet" property="rate" value="${book.rate - book.commission - book.tcd}"/>
                            <%}%>     
                            <% if(mdt == 4 ){%>
                                <jsp:setProperty name="retnSheet" property="rate" value="${book.utprate}"/> 
                            <%}%>     
                            <% if(mdt == 5 ){%>
                                <jsp:setProperty name="retnSheet" property="rate" value="${book.subsidy}"/> 
                            <%}%>    
                             <% if(mdt == 6 ){%>
                               <%-- <jsp:setProperty name="retnSheet" property="rate"/>--%>
                            <%}%>    
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:18px; text-align: center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="${ retnSheet.qty > 0 ? "color:#F31105;font-size:18px;text-align:left;width:9%;font-weight: bold;" : "font-size:18px;text-align:left;width:9%;"}">     
                                    <%if(retnSheet.getreclock()){%>
                                        ${book.product}                                        
                                    <%}else{%>                                        
                                        <a href="retnSheet_1.jsp?blnCstIndt=false&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                    <%}%>
                                </td>                             
                                <td style="${ retnSheet.qty > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                    <jsp:getProperty name='retnSheet' property='qty'/> 
                                </td>                                  
                                <td style="${ retnSheet.qty > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                    <jsp:getProperty name="retnSheet" property="rate"/>
                                </td>                                  
                                <td style="${ retnSheet.qty > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                    <fn:formatNumber currencySymbol="Rs." type="currency" value="<%= retnSheet.getqty() * retnSheet.getrate()%>" />
                                </td>                                    
                            </tr>
                        </c:forEach>  
                    <%}%>
                </table>
                <table cellpadding="3" width="90%">
                    <% if(!retnSheet.getblnValue()){%>                                               
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>                                
                                <th>QUANTITY</th>
                                <th>QTY.</th>                                
                                <th>LEAKAGE MILK</th>
                                <th>SF</th>
                                <th>HL</th>
                                <th>RETURN MILK</th>                                                        
                                <th>RATE</th>
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
                            <%retnSheet.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:14px; text-align: center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:18px; text-align: left;width: 5%;">     
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <a class="qty" onmouseout="setFocus()" onmouseover="setFocus()" href="retnSheet_1.jsp?blnCstIndt=false&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                    
                                    <%}else{%>                                         
                                        <a onmouseout="setFocus()" onmouseover="setFocus()" href="retnSheet_1.jsp?blnCstIndt=false&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                                                        
                                    <%}%>                                    
                                </td>                             
                                <td style="font-size:18px; text-align: left;width: 3%;">                                          
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input size="5" onfocus="this.blur()" class="qty" value="<jsp:getProperty name='retnSheet' property='qty'/>">
                                    <%}else{%>                                         
                                        <jsp:getProperty name='retnSheet' property='qty'/>
                                    <%}%>
                                </td>                                                                
                                <td style="font-size:18px; text-align: left;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" type="text" size="5" name="qty" value="">        
                                    <%}else{%>                                         
                                        <jsp:getProperty name='retnSheet' property='qty'/>
                                    <%}%>
                                </td>    
                               

                                
                                <td style="font-size:18px;text-align: right;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='leakage'/>" type="text" size="5" name="leakage"> <!--  disabled="disabled" -->
                                    <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='leakage'/>
                                    <%}%>                                                                     
                                </td> 
                                <td style="font-size:18px; text-align: right;width: 3%;">                                    
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='sf'/>" type="text" size="5" name="sf">
                                    <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='sf'/>
                                    <%}%>                                                                                                         
                                </td>                                                                
                                <td style="font-size:18px; text-align: right;width: 3%;">   
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='hl'/>" type="text" size="5" name="hl">
                                    <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='hl'/>
                                    <%}%>                                                                                                                                             
                                </td>                                                                                                
                                <td style="font-size:18px;text-align: right;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>                                        
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='retn'/>" type="text" size="5" name="retn">                                        
                                    <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='retn'/>
                                    <%}%>                                                                     
                                </td>  
                                
                                
                               <td style="font-size:18px; text-align: left;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" type="text" size="5" name="rate" value="">        
                                    <%}else{%>                                         
                                        <jsp:getProperty name='retnSheet' property='rate'/>
                                    <%}%>
                                </td>                                                                                                                                    
                                
                                <td style="font-size:18px;text-align: left;width: 1%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input type="submit" name="Add" value="Add">                                      
                                        <input type="hidden" name="blnValue" value="true">                               
                                        <input type="hidden" name="prodid"  
                                        value="<jsp:getProperty name="retnSheet" property="prodid"/>"  
                                        <input type="hidden" name="custid"  
                                        value="<jsp:getProperty name="retnSheet" property="custid"/>"                                              
                                        <input type="hidden" name="product" 
                                        value="<jsp:getProperty name="retnSheet" property="product"/>"> 
                                        <input type="hidden" name="index" 
                                        value="<jsp:getProperty name="retnSheet" property="index"/>">  
                                    <%}%>
                                </td>
                            </tr>
                        </c:forEach>               
                    <%}%>                        
                </table>    
            <%}%> 
            <font size="1" face="Arial Narrow, System" color="#CC99FF"><b>
                Record last accessed on : <jsp:getProperty name="retnSheet" property="rectimestamp"/> By <jsp:getProperty name="retnSheet" property="user"/>
            </b></font>            
        </form>
    </body>
</html>
