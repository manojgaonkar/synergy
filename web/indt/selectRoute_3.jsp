<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
        <title>Select Route</title>                
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">         
    </head>    
    <jsp:useBean id="utlBen" scope="page" class="mktg.backingBean.utlBean" />        

     <sql:query 
        sql="SELECT route.timing from route where route.route = ? " 
        var="MOREVE"         
        dataSource="jdbc/kmfmktgNew" > 
        <sql:param value="${param.rt}"></sql:param>
    </sql:query>
    
    <sql:query 
        sql="SELECT entystate.statename from entystate " 
        var="sta" 
        dataSource="jdbc/kmfmktgNew" >        
    </sql:query>    
    <%
        String state;        
        String idate;
        Integer rtNumber;
        if(request.getParameter("sta") !=null){
            state = request.getParameter("sta");
            session.setAttribute("state",new String(request.getParameter("sta")));            
        }
        if(request.getParameter("idate") !=null){
            idate = request.getParameter("idate");
            session.setAttribute("idate",new String(request.getParameter("idate")));            
        }      

        if(request.getParameter("rt") !=null){
          //  rtNumber = Integer.parseInt(request.getParameter("rt"));
           // session.setAttribute("rtNumber",rtNumber);            
        }                             
    %>    
      
    <body style="background:#B3B366">      
        <form action="retnSheet_1.jsp" method="get"><center>
            <c:forEach var="column" items="${MOREVE.rows}"> 
                <jsp:setProperty name="utlBen" property="timing" value="${column.timing}" />
            </c:forEach>    
            
            <input id="rt" name="rt" type="hidden" value="${param.rt}" />
            
            <table cellpadding="3" width="50%">    
                <tr>
                    <td>
                        <font style="font-size:16px;color:#ffffff;font-weight:bold">STATE&nbsp;${state}</font>
                    </td>
                    <td>
                        <font style="font-size:16px;color:#ffffff;font-weight:bold">Date&nbsp;${idate}</font>
                    </td>                                        
                </tr>
            </table>                                       
            <table width="50%" cellpadding="7%">                
                <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                    <th style="text-align: right">R&nbsp;E&nbsp;T&nbsp;U&nbsp;R&nbsp;N</th>
                    <th style="text-align: left">S&nbsp;H&nbsp;E&nbsp;E&nbsp;T</th>
                </tr>
               <%-- <tr class="list-row-even">
                    <td style="text-align: right;">
                        State :
                    </td>
                    <td style="text-align: left;">
                        <select name="sta">
                            <c:forEach var="row" items="${sta.rowsByIndex}">  
                                <c:forEach var="column" items="${row}">  
                                    <option> <c:out value ="${column}"/> </option>                                        \                                   
                                </c:forEach>                                                                    
                            </c:forEach>                              
                        </select>
                    </td>
                </tr> --%>                
         <%--       <tr class="list-row-odd">
                    <td style="text-align: right;">
                        Milk Sales Route :                                         
                    </td>
                    <td style="text-align: left;">
                        <select name="rt">
                            <c:forEach var="row" items="${rt.rowsByIndex}">  
                                <c:forEach var="column" items="${row}">  
                                    <option> <c:out value ="${column}"/> </option>                                        \                                   
                                </c:forEach>                                                                    
                            </c:forEach>                              
                        </select>
                    </td>
                </tr>  --%>
                
                   <tr class="list-row-odd"> 
                    <td style="text-align: right;">
                        INDENT DATE :
                    </td>
                    <td style="text-align: left;">
                        <input value="<fn:formatDate pattern="dd.MM.yyyy" value="${utlBen.currentDate}" type="date"/>" type="text" size="10" name="idate"> 
                    </td>                       
                </tr>   
                
                
                
            <%--    <tr class="list-row-even"> 
                    <td style="text-align: right;">
                        INDENT DATE :
                    </td>
                    <td style="text-align: left;">
                        <input value="<fn:formatDate pattern="dd.MM.yyyy" value="${utlBen.currentDate}" type="date"/>" type="text" size="10" name="idate"> 
                    </td>                       
                </tr>  --%>          
                <input type="hidden" id="moreve" Name="moreve" value="M">
             <%--   <tr class="list-row-odd">
                    <td style="text-align: right;">
                        
                    </td>
                    <td style="text-align: left;">
                        <SELECT name="moreve">
                            <option value="M">Morning</option>
                            <option value="E">Evening</option>
                        </SELECT>                                          
                        &nbsp;&nbsp;INDENT
                    </td>                       
                </tr>                  
                <tr class="list-row-even">
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
                </tr>--%>                  
                <tr class="list-row-odd">
                    <td></td>
                    <td style="text-align: left;">
                        <input style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                            type="submit" value="Submit"> 
                    </td>                        
                </tr>
            </table>
            <input type="hidden" name="blnCustList" value="true">                               
            <input type="hidden" name="blnCstIndt" value="true">      
            <input type="hidden" name="entrytype" value="1">     
            <input type="hidden" name="sta" value="<%= session.getAttribute("state") %>">                 
            <input type="hidden" name="idate" value="<%= session.getAttribute("idate") %>">                 
        </form>
    </body>
</html>
