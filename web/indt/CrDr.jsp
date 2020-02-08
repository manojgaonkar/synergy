
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="mktg.backingBean.CrDr,java.util.Date,mktg.utility.Utility"%>



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
        <title>Return Sheet</title>
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css"> 
       <style type="text/css">
            .qty{text-align: right;background-color: #A0A050;color: #ffffff;font-weight: 700;}
        </style>        
        <script type="text/javascript">            
            function setFocus(){                                 
            }            
        </script>        
    </head>
    <body style="background:#B3B366">
        <form method="get" action="../CrDrSer">       
            
            <jsp:useBean id="crdr" scope="session" class="mktg.backingBean.CrDr" />            
            
            <jsp:setProperty name="crdr" property="idate" param="idate"/>
            
            <%!public int trid = 0; %>
            <%!public int slno = 0; %>                                       
            <%!public int custtype = 0; %>                                       
            <%!public boolean blnrec = true; %>
            <%!public boolean blnCustList = true; %>
            <%!public String firstname ; %>            
            <%!public String rt ; %>
            <%!public int custid; %>
            <%!public int routeid; %>
            <%!public int talid; %>
            <%!public String date;%>
            <%                 
                if(request.getParameter("talid") != null)
                    talid =  Integer.parseInt(request.getParameter("talid"));
                    
                if(request.getParameter("blnrec") != null)
                    blnrec = Boolean.parseBoolean(request.getParameter("blnrec"));
                
                if(request.getParameter("routeid") != null)
                    routeid = Integer.parseInt(request.getParameter("routeid"));                
                
                if(request.getParameter("idate") != null){
                    date = request.getParameter("idate");
                    session.setAttribute("idate",request.getParameter("idate"));
                }                
                
                if(request.getParameter("custid") != null)
                    custid = Integer.parseInt(request.getParameter("custid"));
                    
                if(request.getParameter("firstname") != null)
                    firstname = request.getParameter("firstname");
                
                if(request.getParameter("blnCustList") != null)
                    blnCustList = Boolean.parseBoolean(request.getParameter("blnCustList"));
                    
                if(request.getParameter("custtype") != null)
                    custtype = Integer.parseInt(request.getParameter("custtype"));
                   
                if(request.getParameter("rt") != null)
                    rt = request.getParameter("rt");                                        
            %>  
            
            <c:if test="${param.rt != null}">
                <c:set scope="session" var="rt" value="${param.rt}" />
            </c:if>            
            
            <table width="90%">
                <tr>
                    <td style="text-align: left;width: 3%;"><h4>Short/Excess</h4></td>
                    <td style="text-align: right;width: 3%;"><h4>${rt}</h4></td>
                </tr>
            </table>                                    
            <sql:query 
                sql="SELECT customer.* 
                from customer 
                where route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.ROUTE = ? ) 
                and custtype = ? ORDER BY customer.firstname "
                var="customer" dataSource="jdbc/kmfmktgNew" >        
                <sql:param value="<%=rt%>"/>
                <sql:param value="<%=custtype%>"/>
            </sql:query>                                    
            <%if(blnCustList){%>    
                <center><table cellpadding="3" width="70%">    
                    <tr>
                        <td>
                            <font style="font-size:16px;color:#ffffff">STATE&nbsp;&gt;${st}&nbsp;:Route&nbsp;&gt;${rt}</font>
                        </td>
                        <td>
                            <font style="font-size:16px;color:#ffffff">&nbsp;<%=session.getAttribute("idate")%></font>
                        </td>                    
                        <td>
                            <a style="font-size:16px;color:#ffffff" href="selectRoute_2.jsp">Change Route</a>
                        </td>
                    </tr>
                </table>                               
                <%slno=0;%>
                 <table cellpadding="3" width="70%">  
                    <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                        <th>SL.NO</th>                            
                        <th>CUSTOMERS</th>
                    </tr>                     
                    <c:forEach begin="0" items="${customer.rows}" var="book" >                                            
                        <%slno++;%>
                        <tr style="background-color: #FF9DCE;color: #ffffff;font-size:16px;">
                            <td style="width: 2%" >
                                <%=slno%>
                            </td>
                            <td style="text-align: left;width: 30%">                                                                                                   
                                <a accesskey="${book.firstname}" href="CrDr.jsp?blnrec=true&idate=<%=date%>&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&rtname=${rt}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>
                            </td>     
                        </tr>       
                    </c:forEach>                                                                                  
                </table></center>                                            
            <%}else{%>              
                <sql:query 
                    sql="SELECT indent.id,indent.lessamt,indent.exceamt,indent.crateout,indent.cratein,
                    indent.paidatbank,indent.reclock,indent.user,indent.rectimestamp  
                    FROM indent  
                    WHERE indent.idate = ? 
                    AND indent.customer = ? 
                    AND indent.entrytype = ? "                 
                    var="indent" dataSource="jdbc/kmfmktgNew" >  
                    <sql:param value="${crdr.idate}"/>      
                    <sql:param value="<%=custid%>"/>
                    <sql:param value="3"/>
                </sql:query>                    
                <input type="hidden" name="custid" value="<%=custid%>">
                <input type="hidden" name="firstname" value="<%=firstname%>"> 
                <input type="hidden" name="custtype" value="<%=custtype%>">
                <input type="hidden" name="routeid" value="<%=routeid%>">
                <input type="hidden" name="rt" value="<%=rt%>">  
                <input type="hidden" name="talid" value="<%=talid%>">
                <table width="90%">
                    <tr style="background-color:  #FFFF15;color: #000000;font-size:16px;">
                        <td>
                            <%=firstname%>
                        </td>                        
                         <td>DATE :&nbsp;<%=date%></td>
                         <td></td>
                    </tr>
                </table>                                   
          <%--      <c:if test="${param.reclock}"> --%>
                    
                <table width="90%">
                    <tr>
                        <td style="font-size:14px; text-align: left;width: 5%;">     
                            <a href="CrDr.jsp?blnCustList=true&rt=<%=rt%>&custtype=<%=custtype%>">Customer List</a>
                        </td>                       
                        <td style="font-size:14px; text-align: left;width: 6%;">     
                            <%--<a href="../CrDrSer">Save</a>--%>   
                        </td>
                        <td style="font-size:14px; text-align: left;width: 3%;">    
                            
                         <%--    <input type="submit" name="Add" value="Add"> --%>
                             
                        </td>
                    </tr>                    
                </table>                                                                        
                <table width="90%">
                        
                    
                <% if(true){%> 
                    <thead>
                        <tr style="background-color: #FF8F59">
                            <th>SL.NO</th>                            
                            <th>SHORT.AMT</th>
                            <th>PAID.AMT</th>
                            <th>OUT/CRATE</th>
                            <th>IN/CRATE</th>                        
                            <th>PAID AT BANK</th>
                        </tr>                                                
                    </thead>                      
                    <%slno = 0 ;%>                                                               
                    <c:forEach begin="0" items="#{indent.rows}" var="book" varStatus="stat">
                        <%blnrec = false;%>
                        <%slno++;%>    
                        <input type="hidden" name="trid" value="${book.id}">
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                            <td style="font-size:14px; text-align: left;width: 1%;">     
                                <%=slno%>
                            </td>
                            <td style=" text-align: right;width: 3%;">     
                                <input type="text" size="8" name="lessamt" class="qty" 
                                    value="${book.lessamt}">
                            </td>   
                            <td style="font-size:14px; text-align: center;width: 5%;">     
                                <input type="text" size="8" name="exceamt" class="qty" 
                                    value="${book.exceamt}"> 
                            </td>
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <input type="text" size="8" name="crateout"  class="qty" 
                                    value="${book.crateout}"> 
                            </td>
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <input type="text" size="8" name="cratein"  class="qty" 
                                    value="${book.cratein}"> 
                            </td>                                
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <input  type="text" size="8" name="paidatbank" class="qty"  
                                    value="${book.paidatbank}"> 
                            </td> 
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <c:if test="${!book.reclock}">
                                    <input type="submit" name="Add" value="Add">
                                </c:if>                                
                            </td>
                        </tr>         
                        <jsp:setProperty name="crdr" property="user" value="${book.user}"/>
                        <jsp:setProperty name="crdr" property="rectimestamp" value="${book.rectimestamp}"/>
                    </c:forEach>  
                    <%if(blnrec){%>
                        <input type="hidden" name="trid" value="0">
                        <tr class="list-row-even">
                            <td style="font-size:14px; text-align: left;width: 1%;">     
                                <%=slno%>
                            </td>
                            <td style=" text-align: right;width: 3%;">     
                                <input type="text" size="8" name="lessamt" class="qty" 
                                    value="0.00">
                            </td>   
                            <td style="font-size:14px; text-align: center;width: 5%;">     
                                <input type="text" size="8" name="exceamt" class="qty" 
                                    value="0.00"> 
                            </td>
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <input type="text" size="8" name="crateout"  class="qty" 
                                    value="0"> 
                            </td>
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <input type="text" size="8" name="cratein"  class="qty" 
                                    value="0"> 
                            </td>                                
                            <td style="font-size:14px; text-align: center;width: 5%;">   
                                <input  type="text" size="8" name="paidatbank" class="qty"  
                                    value="0.00"> 
                            </td> 
                            <td style="font-size:14px; text-align: center;width: 5%;">                               
                                <input type="submit" name="Add" value="Add">                            
                            </td>                            
                        </tr>
                    <%}%>
                <%}%>                                                   
                </table> 
                
             <%--       </c:if> --%>

            <%}%>
            <%if(!blnrec){%>
                <font size="1" face="Arial Narrow, System" color="#000000"><b>
                Record last accessed on : <jsp:getProperty name="crdr" property="rectimestamp"/> By <jsp:getProperty name="crdr" property="user"/></b></font>            
            <%}%>
        </form>
    </body>
</html>
