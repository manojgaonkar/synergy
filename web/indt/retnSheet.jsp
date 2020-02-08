<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="mktg.backingBean.retnSheet,java.util.Date,mktg.utility.Utility"%>


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
            <jsp:useBean id="retnSheet" scope="session" class="mktg.backingBean.retnSheet" />
            
            <jsp:setProperty name="retnSheet" property="index" param="index" /> 
            
            <jsp:setProperty name="retnSheet" property="trID" param="trID" />  
            
            <jsp:setProperty name="retnSheet" property="idate" param="idate" />  
             
            <jsp:setProperty name="retnSheet" property="prodid" param="prodid" /> 

            <jsp:setProperty name="retnSheet" property="custid" param="custid" /> 

            <jsp:setProperty name="retnSheet" property="product" param="product" />    

            <jsp:setProperty name="retnSheet" property="leakage" param="leakage"/>
            
            <jsp:setProperty name="retnSheet" property="sf" param="sf"/>
            
            <jsp:setProperty name="retnSheet" property="hl" param="hl"/>
            
            <jsp:setProperty name="retnSheet" property="qty" param="qty" />                

            <jsp:setProperty name="retnSheet" property="retn" param="retn"/>

            <jsp:setProperty name="retnSheet" property="rate" param="rate"/>
 
            <jsp:setProperty name="retnSheet" property="comm" param="comm"/>

            <jsp:setProperty name="retnSheet" property="tax" param="tax"/>

            <jsp:setProperty name="retnSheet" property="cst" param="cst"/>

            <jsp:setProperty name="retnSheet" property="cess" param="cess"/>

            <jsp:setProperty name="retnSheet" property="tcd" param="tcd"/>    

            <jsp:setProperty name="retnSheet" property="routeid" param="routeid" />     

            <jsp:setProperty name="retnSheet" property="talid" param="talid" />       

            <jsp:setProperty name="retnSheet" property="firstname" param="firstname"/>       

            <jsp:setProperty name="retnSheet" property="cacr" param="cacr"/>    

            <jsp:setProperty name="retnSheet" property="blnCustList" param="blnCustList"/>    

            <jsp:setProperty name="retnSheet" property="blnValue" param="blnValue"/>      
            
            <jsp:setProperty name="retnSheet" property="custtype" param="custtype"/>      
            
            <jsp:setProperty name="retnSheet" property="moreve" param="moreve"/>
            
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>   
            <%!public String moreve;%>
            
            <%                    
              if(request.getParameter("moreve") != null)
                    moreve = request.getParameter("moreve");                
                
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

                if(request.getParameter("qty") != null && request.getParameter("qty").length() >0 )
                    Double.parseDouble(request.getParameter("qty"));
                    
                if(request.getParameter("leakage") != null && request.getParameter("leakage").length() >0 )
                    Double.parseDouble(request.getParameter("leakage"));

                if(request.getParameter("sf") != null && request.getParameter("sf").length() >0 )
                    Double.parseDouble(request.getParameter("sf"));                
                    
                if(request.getParameter("hl") != null && request.getParameter("hl").length() >0 )
                    Double.parseDouble(request.getParameter("hl"));                
                    
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
                where route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.ROUTE = ? ) 
                ORDER BY customer.firstname "
                var="customer" dataSource="jdbc/kmfmktgNew" >        
                <sql:param value="${rt}"/>                       
            </sql:query>                        
            <sql:query 
                var="indent"
                dataSource="jdbc/kmfmktgNew"
                sql="SELECT indent.* 
                FROM indent  
                WHERE indent.idate = ? 
                AND indent.customer = ?  
                AND indent.moreve = ? ">           
                <sql:param value="${retnSheet.idate}"/>      
                <sql:param value="${retnSheet.custid}"/>
                <sql:param value="${retnSheet.moreve}"/>
             </sql:query>            
             <%if(retnSheet.getblnCustList()){%>                    
                 <%slno=0;%>
                 <table cellpadding="3" width="70%">      
                    <c:forEach items="${customer.rows}" var="book" >                                            
                        <%slno++;%>
                        <tr style="background-color: #FF9DCE;color: #ffffff;font-size:16px;">
                            <td style="width: 2%" >
                                <%=slno%>
                            </td>
                            <td style="width: 30%">                                                                                                   
                                <a href="retnSheet.jsp?moreve=<%=moreve%>&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&rtname=${rt}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>
                            </td>     
                        </tr>       
                    </c:forEach>                                                                                  
                </table>                                            
            <%}else{%>         
                <table width="90%">
                    <tr style="background-color: #FF9DCE;color: #000000;font-size:16px;">
                        <td>
                            <jsp:getProperty name="retnSheet" property="firstname"/>  
                        </td>                        
                         <td>INDENT DATE :</td>
                         <td>${date}</td>
                    </tr>
                </table>                                   
                <table>
                    <tr>
                        <td style="font-size:14px; text-align: left;width: 5%;">     
                            <a href="retnSheet.jsp?blnCustList=true">Customer List</a>
                        </td>                       
                        <td style="font-size:14px; text-align: left;width: 6%;">                                 
                        </td>
                        <td style="font-size:14px; text-align: left;width: 3%;">     
                            <a href="../retnSheetSer">Save</a>
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
                                <th>LEAKAGE MILK</th>
                                <th>SF</th>
                                <th>HL</th>
                                <th>RETURN MILK</th>                        
                            </tr>                                                
                        </thead>                      
                        <%index = -1;%>
                        <%slno = 0 ;%>                                                
                        <c:forEach items="#{indent.rows}" var="book" varStatus="stat">         
                            <%index++;%>    
                            <%slno++;%>    
                            <%retnSheet.setindex(index);%>  
                            <jsp:setProperty name="retnSheet" property="qty" value="${book.quantity}"/>
                            <jsp:setProperty name="retnSheet" property="rate" value="${book.rate}" /> 
                            <jsp:setProperty name="retnSheet" property="comm" value="${book.commi}" />    
                            <jsp:setProperty name="retnSheet" property="tax" value="${book.tax}"/>    
                            <jsp:setProperty name="retnSheet" property="cst" value="${book.cst}"/>    
                            <jsp:setProperty name="retnSheet" property="cess" value="${book.cess}"/>                                
                            <jsp:setProperty name="retnSheet" property="tcd" value="${book.tcd}"/>                            
                            <jsp:setProperty name="retnSheet" property="trID" value="${book.id}"/>  
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:14px; text-align: left;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:14px; text-align: left;width: 6%;">     
                                    <a href="retnSheet.jsp?hl=${book.hl}&sf=${book.sf}&retn=${book.returnmilk}&leakage=${book.leakage}&qty=${book.quantity}&index=<%=index%>&trID=${book.id}&tcd=${book.tcd}&comm=${book.commi}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.product}&product=${book.prodname}&blnValue=false">${book.prodname}</a> 
                                </td>                             
                                <td style=" text-align: right;width: 3%;">                                         
                                    <jsp:getProperty name='retnSheet' property='qty'/> 
                                </td>   
                                <td style="font-size:14px; text-align: right;width: 5%;">    
                                    <%--<jsp:setProperty name="retnSheet" property="leakage" value="${book.leakage}"/>--%>
                                    <jsp:getProperty name='retnSheet' property='leakage'/>                                     
                                </td>
                                <td style="font-size:14px; text-align: right;width: 3%;">                                      
                                    <jsp:getProperty name="retnSheet" property="sf"/>
                                </td>                                
                                <td style="font-size:14px; text-align: right;width: 3%;">                                        
                                    <jsp:getProperty name="retnSheet" property="hl"/>
                                </td>                                                                
                                <td style="font-size:14px; text-align: right;width: 5%;">     
                                    <%--<jsp:setProperty name="retnSheet" property="retn" value="${book.returnmilk}"/>--%>
                                    <jsp:getProperty name='retnSheet' property='retn'/> 
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
                                <th>LEAKAGE MILK</th>
                                <th>SF</th>
                                <th>HL</th>                                
                                <th>RETURN MILK</th>   
                                <th>Add</th>
                            </tr>                                                
                        </thead>                                                  
                        <%index = -1;%>
                        <%slno = 0 ;%>                            
                        <%tracker = -1 ;%>  
                        <c:forEach items="#{indent.rows}" var="book" varStatus="stat">
                            <%index++;%>    
                            <%slno++;%>   
                            <%tracker++;%>   
                            <%retnSheet.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:14px; text-align: left;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:14px; text-align: left;width: 6%;">     
                                    <a onmouseout="setFocus()" onmouseover="setFocus()"
                                        href="retnSheet.jsp?hl=${book.hl}&sf=${book.sf}&retn=${book.returnmilk}&leakage=${book.leakage}&qty=${book.quantity}&index=<%=index%>&trID=${book.id}&tcd=${book.tcd}&comm=${book.commi}&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&rate=${book.rate}&prodid=${book.product}&product=${book.prodname}&blnValue=false">${book.prodname}</a>
                                </td>                             
                                <td style=" text-align: right;width: 3%;">        
                                    <jsp:getProperty name='retnSheet' property='qty'/>
                                </td>
                                
                                <td style=" text-align: right;width: 3%;">        
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='leakage'/>" type="text" size="5" name="leakage">
                                   <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='leakage'/>
                                   <%}%>                                                                     
                                </td> 
                                <td style="font-size:14px; text-align: right;width: 3%;">                                    
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='sf'/>" type="text" size="5" name="sf">
                                   <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='sf'/>
                                   <%}%>                                                                                                         
                                </td>                                                                
                                <td style="font-size:14px; text-align: right;width: 3%;">   
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='hl'/>" type="text" size="5" name="hl">
                                   <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='hl'/>
                                   <%}%>                                                                                                                                             
                                </td>                                                                                                
                                <td style=" text-align: right;width: 3%;">        
                                   <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>                                        
                                        <input class="qty" value="<jsp:getProperty name='retnSheet' property='retn'/>" type="text" size="5" name="retn">                                        
                                   <%}else{%> 
                                        <jsp:getProperty name='retnSheet' property='retn'/>
                                   <%}%>                                                                     
                                </td>                                 
                                <td style=" text-align: left;width: 1%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input type="submit" name="Add" value="Add">                                      
                                        <input type="hidden" name="blnValue" value="true">                               
                                        <input type="hidden" name="prodid"  
                                            value="<jsp:getProperty name="retnSheet" property="prodid"/>"  
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
        </form>
    </body>
</html>
