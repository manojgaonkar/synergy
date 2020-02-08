<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="mktg.backingBean.editIndent,java.util.Date,mktg.utility.Utility"%>


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
    <body>
        <form>            
            <jsp:useBean id="indtEdit" scope="session" class="mktg.backingBean.editIndent" />
            
            <jsp:setProperty name="indtEdit" property="index" param="index" /> 
            
            <jsp:setProperty name="indtEdit" property="trID" param="trID" />  
            
            <jsp:setProperty name="indtEdit" property="idate" param="idate" />  
             
            <jsp:setProperty name="indtEdit" property="prodid" param="prodid" /> 

            <jsp:setProperty name="indtEdit" property="custid" param="custid" /> 

            <jsp:setProperty name="indtEdit" property="product" param="product" />    

            <jsp:setProperty name="indtEdit" property="leakage" param="leakage"/>
            
            <jsp:setProperty name="indtEdit" property="qty" param="qty" />     
            
            <jsp:setProperty name="indtEdit" property="editqty" param="editqty"/>

            <jsp:setProperty name="indtEdit" property="retn" param="retn"/>

            <jsp:setProperty name="indtEdit" property="rate" param="rate"/>
 
            <jsp:setProperty name="indtEdit" property="commi" param="commi"/>

            <jsp:setProperty name="indtEdit" property="tax" param="tax"/>

            <jsp:setProperty name="indtEdit" property="cst" param="cst"/>

            <jsp:setProperty name="indtEdit" property="cess" param="cess"/>

            <jsp:setProperty name="indtEdit" property="tcd" param="tcd"/>    

            <jsp:setProperty name="indtEdit" property="routeid" param="routeid" />     

            <jsp:setProperty name="indtEdit" property="talid" param="talid" />       

            <jsp:setProperty name="indtEdit" property="firstname" param="firstname"/>       

            <jsp:setProperty name="indtEdit" property="cacr" param="cacr"/>    

            <jsp:setProperty name="indtEdit" property="blnCustList" param="blnCustList"/>    

            <jsp:setProperty name="indtEdit" property="blnValue" param="blnValue"/>
            
            <jsp:setProperty name="indt" property="custtype" param="custtype"/>

            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>                                       
            <%    

                if(request.getParameter("trID") != null)
                    Integer.parseInt(request.getParameter("trID"));
                                        
               if(request.getParameter("custtype") != null)
                    Integer.parseInt(request.getParameter("custtype"));
                    
                if(request.getParameter("idate") != null)
                    session.setAttribute("idate",request.getParameter("idate"));
                     
                if(request.getParameter("custid") != null)
                    Integer.parseInt(request.getParameter("custid"));

                if(request.getParameter("prodid") != null)    
                    Integer.parseInt(request.getParameter("prodid"));
                    
                if(request.getParameter("index") != null)
                    Integer.parseInt(request.getParameter("index"));
             
                if(request.getParameter("index") != null)                        
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index")));                       

                if(request.getParameter("editqty") != null && request.getParameter("editqty").length() >0 )
                    Double.parseDouble(request.getParameter("editqty"));
                    
                if(request.getParameter("qty") != null && request.getParameter("qty").length() >0 )
                    Double.parseDouble(request.getParameter("qty"));
                    
                if(request.getParameter("leakage") != null && request.getParameter("leakage").length() >0 )
                    Double.parseDouble(request.getParameter("leakage"));

               if(request.getParameter("retn") != null && request.getParameter("retn").length() >0 )
                    Double.parseDouble(request.getParameter("retn"));

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

                if(request.getParameter("routeid") != null)
                    Integer.parseInt(request.getParameter("routeid"));        

                if(request.getParameter("talid") != null)
                    Integer.parseInt(request.getParameter("talid"));            

                if(request.getParameter("cacr") != null)
                    request.getParameter("cacr");            

                if(request.getParameter("firstname") != null)
                    request.getParameter("firstname");                   

                if(request.getParameter("blnValue") !=null)
                    Boolean.parseBoolean(request.getParameter("blnValue"));    

                if(request.getParameter("blnCustList") !=null)
                    Boolean.parseBoolean(request.getParameter("blnCustList"));             
            %>  
            <c:if test="${param.rt != null}">
                <c:set scope="session" var="rt" value="${param.rt}" />
                <c:set scope="session" var="date" value="${param.idate}" />               
            </c:if>
            <sql:query 
                sql="SELECT customer.* 
                from customer 
                where route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.ROUTE = ? ) "
                var="customer" dataSource="jdbc/kmfmktgNew" >        
                <sql:param value="${rt}"/>                       
            </sql:query>                        
           <sql:query 
                sql="SELECT indent.* 
                FROM indent  
                WHERE indent.idate = ? and indent.customer = ? " 
                var="indent" dataSource="jdbc/kmfmktgNew" >                  
                <sql:param value="${indtEdit.idate}"/>      
                <sql:param value="${indtEdit.custid}"/>
            </sql:query>            
            <%if(indtEdit.getblnCustList()){%>   
                 <%slno=0;%>
                 <table width="70%">      
                    <c:forEach items="${customer.rows}" var="book" >                                            
                        <%slno++;%>
                        <tr style="background-color: #FF9DCE;color: #ffffff;font-size:14px;">
                            <td style="width: 2%" >
                                <%=slno%>
                            </td>
                            <td style="width: 30%">                                                                                                   
                                <a href="EditIndent.jsp?custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&rtname=${rt}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>
                            </td>     
                        </tr>       
                    </c:forEach>                                                                                  
                </table>                                            
            <%}else{%>         
                <table width="90%">
                    <tr style="background-color: #FF9DCE;color: #000000;font-size:16px;">
                        <td>
                            <jsp:getProperty name="indtEdit" property="firstname"/>  
                        </td>                        
                         <td>INDENT DATE :</td>
                         <td>${date}</td>
                    </tr>
                </table>   
                
                <table>
                    <tr>
                        <td style="font-size:14px; text-align: left;width: 5%;">     
                            <a href="EditIndent.jsp?blnCustList=true">Customer List</a>
                        </td>                       
                        <td style="font-size:14px; text-align: left;width: 6%;">     
                            <a href="../editSheetSer">Save</a>
                        </td>
                        <td style="font-size:14px; text-align: left;width: 3%;">     

                        </td>
                    </tr>                    
                </table>                                                        
                <table>
                    <% if(indtEdit.getblnValue()){%> 
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>
                                <th>Ordered.Qty</th>
                                <th>Edit.Qty</th>
                            </tr>                                                
                        </thead>                      
                        <%index = -1;%>
                        <%slno = 0 ;%>                                                
                        <c:forEach items="#{indent.rows}" var="book" varStatus="stat">
                            <%index++;%>    
                            <%slno++;%>    
                            <%indtEdit.setindex(index);%>                               
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:14px; text-align: left;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:14px; text-align: center;width: 6%;">     
                                    <a href="EditIndent.jsp?retn=${book.returnmilk}&leakage=${book.leakage}&qty=${book.quantity}&index=<%=index%>&trID=${book.id}&tcd=${book.tcd}&commi=${book.commi}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.product}&product=${book.prodname}&blnValue=false">${book.prodname}</a>
                                </td>                             
                                <td style=" text-align: right;width: 3%;">     
                                    <jsp:setProperty name="indtEdit" property="qty" value="${book.quantity}"/>
                                    <jsp:getProperty name='indtEdit' property='qty'/> 
                                </td>   
                                <td style="font-size:14px; text-align: center;width: 5%;">     
                                    <jsp:getProperty name='indtEdit' property='editqty'/> 
                                </td>
                            </tr>
                        </c:forEach>  
                    <%}%>                    
                </table> 
                <table width="90%">
                    <% if(!indtEdit.getblnValue()){%>                                               
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>
                                <th>Ordered.Qty</th>
                                <th>Edit.Qty</th>
                                <th>Update</th>
                            </tr>                                                
                        </thead>                                                  
                        <%index = -1;%>
                        <%slno = 0 ;%>                            
                        <%tracker = -1 ;%>  
                        <c:forEach items="#{indent.rows}" var="book" varStatus="stat">
                            <%index++;%>    
                            <%slno++;%>   
                            <%tracker++;%>   
                            <%indtEdit.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:14px; text-align: left;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:14px; text-align: center;width: 6%;">     
                                    <a onmouseout="setFocus()" onmouseover="setFocus()"
                                        href="EditIndent.jsp?retn=${book.returnmilk}&leakage=${book.leakage}&qty=${book.quantity}&index=<%=index%>&trID=${book.id}&tcd=${book.tcd}&commi=${book.commi}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.product}&product=${book.prodname}&blnValue=false">${book.prodname}</a>
                                </td>                             
                                <td style=" text-align: right;width: 3%;">        
                                    <jsp:getProperty name='indtEdit' property='qty'/>
                                </td>
                                <td style=" text-align: right;width: 3%;">        
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='indtEdit' property='editqty'/>" type="text" size="5" name="editqty">
                                   <%}else{%> 
                                        <jsp:getProperty name='indtEdit' property='editqty'/>
                                   <%}%>                                                                     
                                </td>                                 
                                <td style=" text-align: left;width: 1%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input type="submit" name="Add" value="Update">                                      
                                        <input type="hidden" name="blnValue" value="true">                               
                                        <input type="hidden" name="prodid"  
                                            value="<jsp:getProperty name="indtEdit" property="prodid"/>"  
                                        <input type="hidden" name="product" 
                                            value="<jsp:getProperty name="indtEdit" property="product"/>"> 
                                        <input type="hidden" name="index" 
                                            value="<jsp:getProperty name="indtEdit" property="index"/>">                                             
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
