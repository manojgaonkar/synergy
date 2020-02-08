 <%-- 
    Document   : statedate
    Created on : Jun 15, 2009, 1:27:06 PM
    Author     : jairam
--%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fn"%>    
<sql:query 
        sql="SELECT entystate.statename from entystate " var="sta" dataSource="jdbc/kmfmktgNew" >        
</sql:query>
<jsp:useBean id="utlBen" scope="page" class="mktg.backingBean.utlBean" /> 
 <sql:query 
        sql="SELECT route.route,route.timing FROM route 
            WHERE saletype = 1 " 
            var="rt" dataSource="jdbc/kmfmktgNew" >                    
    </sql:query>      
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="selectRoute_3.jsp" method="get">  
            <h4>RETURN SHEET</h4>
            <center><TABLE CELLPADDING="3" CELLSPACING="5">
                <tr class="list-row-odd">
                    <td style="text-align: right;">
                        STATE :
                    </td>
                    <td style="text-align: left;">
                        <select name="sta">
                            <c:forEach var="row" items="${sta.rowsByIndex}">  
                                <c:forEach var="column" items="${row}">  
                                    <option value="${column}"> <c:out value ="${column}"/> </option>                                        \                                   
                                </c:forEach>                                                                    
                            </c:forEach>                              
                        </select>
                    </td>
                </tr>            
             <%--   <tr class="list-row-odd"> 
                    <td style="text-align: right;">
                        INDENT DATE :
                    </td>
                    <td style="text-align: left;">
                        <input value="<fn:formatDate pattern="dd.MM.yyyy" value="${utlBen.currentDate}" type="date"/>" type="text" size="10" name="idate"> 
                    </td>                       
                </tr>                     --%>
                
                
                 <tr class="list-row-odd">
                    <td style="text-align: right;">
                        Milk Sales Route :                                         
                    </td>
                    <td style="text-align: left;">
                        <select name="rt">
                            <c:forEach var="row" items="${rt.rows}">  
                                <c:forEach var="column" items="${row.route}">  
                                    <option value="${row.route}"> <c:out value ="${column}"/> </option>                                        \                                   
                                </c:forEach>                                                                    
                            </c:forEach>                              
                        </select>
                    </td>
                </tr>                    
                
                
                <tr class="list-row-odd">
                    <td></td>
                    <td style="text-align: left;">
                        <input style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" type="submit" value="SUBMIT"> 
                    </td>                        
                </tr>                
            </TABLE>        
        </form>
    </body>
</html>
