<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    <jsp:useBean id="indt" scope="session" class="mktg.backingBean.Indent_1" />
        
    <jsp:setProperty name="indt" property="moreve" param="moreve"/>
    
    <jsp:setProperty name="indt" property="mdt" param="mdt"/>
    
    <jsp:setProperty name="indt" property="idate" param="idate"/>
    
    <%!public String moreve;%>
    <%!public int mdt = 0;%>
        
    <%
       if(request.getParameter("mdt") != null){
            mdt = Integer.parseInt(request.getParameter("mdt"));
            session.setAttribute("mdt",Integer.parseInt(request.getParameter("mdt")));
            out.println(mdt);
        }

        if(request.getParameter("moreve") != null){
            moreve = request.getParameter("moreve");
            session.setAttribute("moreve",request.getParameter("moreve"));
            out.println(moreve);
        }
        
        
        if(request.getParameter("idate") != null){
            request.getParameter("idate");
            session.setAttribute("idate",request.getParameter("idate"));                    
        }           
        
       
        
     %>           
     
        <%!public int slno = 0; %>
               <c:if test="${param.rt != null}">
                <c:set scope="session" var="st" value="${param.sta}" />
                <c:set scope="session" var="rt" value="${param.rt}" />
                <c:set scope="session" var="date" value="${param.idate}" />                 
            </c:if>
        
        <sql:query 
            sql="SELECT customer.* 
            FROM customer 
            WHERE route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.ROUTE = ? ) 
            ORDER BY customer.firstname "
            var="cst" dataSource="jdbc/kmfmktgNew" >        
            <sql:param value="${rt}"/>                       
        </sql:query>    
     <%--   <%if(indt.getblnCustList()){%>  --%>         
             <h3>Selected Route :&nbsp;${rt}</h3>
             <%slno=0;%><center>
             <table  cellpadding="3" width="70%">    
                <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                    <th>SL.NO</th>                            
                    <th>Customers</th>
                </tr>
                <c:forEach begin="0" var="book" items="${cst.rows}" >    
                    <%slno++;%>
                    <tr style="font-size:22px;background-color: #FF9DCE;color: #ffffff">
                        <td style="width: 2%" >
                            <%=slno%>
                        </td>
                        <td style="text-align: left;width: 30%">                                                                                                   
                         <%--  <a href="indt/indent_1.jsp?billno=0&reclock=false&mdt=<%=mdt%>&moreve=<%=moreve%>&rtname=${rt}&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>  --%>                      
<a href="indt/indent_1.jsp?blnCstIndt=true&idate=<%=session.getAttribute("idate")%>&billno=0&reclock=false&mdt=<%=session.getAttribute("mdt")%>&moreve=<%=session.getAttribute("moreve")%>&rtname=${rt}&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>                                                 
                        </td>     
                    </tr>                                   
                </c:forEach>                                                                                  
            </table></center>    
        <%--<%}%>                 --%>
    </body>
</html>
