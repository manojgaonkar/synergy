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
    
    <jsp:useBean id="editgatepass" scope="session" class="mktg.backingBean.editgatepass" />
    
    <jsp:setProperty name="editgatepass" property="index" param="index" />      
    <jsp:setProperty name="editgatepass" property="prodid" param="prodid" />      
    <jsp:setProperty name="editgatepass" property="routeid" param="routeid" />     
    <jsp:setProperty name="editgatepass" property="custid" param="custid" />     
    <jsp:setProperty name="editgatepass" property="talid" param="talid" />     
    <jsp:setProperty name="editgatepass" property="product" param="product" />        
    <jsp:setProperty name="editgatepass" property="qty" param="qty" />    
    <jsp:setProperty name="editgatepass" property="rate" param="rate"/>    
    <jsp:setProperty name="editgatepass" property="comm" param="comm"/>    
    <jsp:setProperty name="editgatepass" property="tax" param="tax"/>    
    <jsp:setProperty name="editgatepass" property="cst" param="cst"/>    
    <jsp:setProperty name="editgatepass" property="cess" param="cess"/>    
    <jsp:setProperty name="editgatepass" property="tcd" param="tcd"/>     
    <jsp:setProperty name="editgatepass" property="firstname" param="firstname"/>    
    <jsp:setProperty name="editgatepass" property="cacr" param="cacr"/>    
    <jsp:setProperty name="editgatepass" property="idate" param="idate"/>    
    <jsp:setProperty name="editgatepass" property="blnCustList" param="blnCustList"/>    
    <jsp:setProperty name="editgatepass" property="blnValue" param="blnValue"/>       
    <jsp:setProperty name="editgatepass" property="rtname" param="rtname"/>    
    <jsp:setProperty name="editgatepass" property="prodtype" param="prodtype"/>    
    <jsp:setProperty name="editgatepass" property="dft" param="dft"/>    
    <jsp:setProperty name="editgatepass" property="mdt" param="mdt"/>
    
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
    <body style="background:#820041">         
        <form action="editGatePass.jsp" name="indentForm">  
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>    
            <%!public int mdt = 0;%>
            <%!public boolean blnShow = false; %>
            <%!public boolean blnEG = false; %>
            <%!public boolean blnCstData = false;%>
            <%!public boolean gatePassList = false; %>            
            
            <%!public String cstname; %>            
            <%!public int billno = 0;%>
            
            <%      
                
                if(request.getParameter("mdt") != null)
                    mdt = Integer.parseInt(request.getParameter("mdt"));                
                
                if(request.getParameter("dft") != null)
                    Integer.parseInt(request.getParameter("dft"));
                    
                if(request.getParameter("gatePassList") != null)
                    gatePassList = Boolean.parseBoolean(request.getParameter("gatePassList"));                    
                    
                if(request.getParameter("blnEG") != null)
                    blnEG = Boolean.parseBoolean(request.getParameter("blnEG"));
                    
                if(request.getParameter("billno") != null)
                    billno = Integer.parseInt(request.getParameter("billno"));
                    
                if(request.getParameter("prodtype") != null)
                    Integer.parseInt(request.getParameter("prodtype"));                                                                                                                      
                
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
                    Integer.parseInt(request.getParameter("routeid"));

                if(request.getParameter("index") != null)
                    Integer.parseInt(request.getParameter("index"));*/

                if(request.getParameter("index") != null)                        
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index").toString()));                       

//               if(request.getParameter("qty") != null && request.getParameter("qty").length() >0 )
  //                  Double.parseDouble(request.getParameter("qty"));

                if(request.getParameter("firstname") != null)
                    request.getParameter("firstname");                   

                if(request.getParameter("blnValue") !=null)
                    Boolean.parseBoolean(request.getParameter("blnValue"));    
                    
                if(request.getParameter("blnCustList") !=null)
                    Boolean.parseBoolean(request.getParameter("blnCustList"));   
                                        
                if(request.getParameter("blnShow") !=null)
                    blnShow = Boolean.parseBoolean(request.getParameter("blnShow"));   

           /*     if(request.getParameter("rate") !=null)
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
                    
                    
                if(request.getParameter("blnCstData") != null)    
                    blnCstData = Boolean.parseBoolean(request.getParameter("blnCstData"));                     
                
                
                
                if(request.getParameter("cstname") != null)    
                    cstname = request.getParameter("cstname");
            %>   
            <font style="font-size:16px;color:#ffffff">Editing Sales</font>
            <%if(blnEG){%>
                <center><table width="70%" cellpadding="5">
                    <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                        <th style="text-align: right">E&nbsp;D&nbsp;I&nbsp;T</th>
                        <th style="text-align: left">S&nbsp;A&nbsp;L&nbsp;E&nbsp;S</th>
                    </tr>                                                                                
                    <tr>
                        <td class="list-row-odd" style="text-align: right;">
                            SALES DATE :
                        </td>
                        <td style="text-align: left;">
                            <input value="<fn:formatDate pattern="dd.MM.yyyy" value="${utlBen.currentDate}" type="date"/>" type="text" size="10" name="idate"> 
                        </td>                           
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
                        </tr> 
                       <tr class="list-row-odd">
                            <td style="text-align: right;">    
                                Cash/Credit
                            </td>
                            <td style="text-align: left;">
                                <select name="cacr">                            
                                    <option value="Cash">Cash</option>                            
                                    <option value="Credit">Credit</option>                            
                                </select>
                            </td>
                        </tr>  
                        <td></td>
                        <td style="text-align: left;">  
                            <input type="hidden" value="false" name="blnShow">
                            <input type="hidden" value="true" name="gatePassList"> 
                            <input type="hidden" value="1" name="talid">  
                            <input type="hidden" value="false" name="blnEG">                            
                            <input style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                                type="submit" value="Submit">
                        </td>                        
                    </tr>                
                </table></center>  
            <%}%>
            <%if(gatePassList){%>   
                <sql:query dataSource="jdbc/kmfmktgNew" 
                    var="ind" 
                    sql="SELECT DISTINCT indent.custname,indent.customer,
                    indent.billno,route.id 'rtid',route.route 
                    FROM indent,route                          
                    WHERE indent.idate = ? 
                    AND indent.cacr = ?
                    AND indent.saletype = 2 
                    AND indent.route = route.id 
                    ORDER BY route.route ">
                    <sql:param value="${editgatepass.idate}"/>                        
                    <sql:param value="${editgatepass.cacr}"/>                        
                </sql:query>                
                <%slno = 0;%>                
                <a style="margin-left:500px;color:white;font-size:16px" href="editGatePass.faces?gatePassList=false&blnEG=true&blnShow=false&blnCstData=false">Back</a>                
                <table width="90%">
                    <thead>
                        <tr style="background-color: #FF8F59">
                            <th>SL.NO</th>                            
                            <th>BILL NO</th>                                
                            <th>CUSTOMER</th>
                            <th>TYPE</th>
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
                                <a href="editGatePass.jsp?custid=${book.customer}&routeid=${book.rtid}&blnEG=false&gatePassList=false&billno=${book.billno}&blnCstData=true&blnShow=true&cstname=${book.custname}">${book.custname}</a>
                            </td>
                            <td style="font-size:14px; text-align: center;width: 1%;">    
                                ${book.route}
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            <%}%>
            <%if(blnShow){%>                                        
                <table width="90%">
                    <tr style="background-color: #FF9DCE;color: #000000;font-size:18px;">
                        <td>
                            <jsp:setProperty name="editgatepass" property="firstname" value="<%=cstname%>"/>
                            <jsp:getProperty name="editgatepass" property="firstname"/>  
                        </td>                        
                        <td>
                            GATEPASS DATE :&nbsp;<%=session.getAttribute("idate")%>
                        </td>
                        <td>
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
                        <sql:param value="${editgatepass.idate}"/> 
                        <sql:param value="<%=billno%>"/>
                    </sql:query>
                    <%index = -1;%>
                    <c:forEach items="${product.rows}" var="book" varStatus="stat">
                        <%index++;%>    
                        <%editgatepass.setindex(index);%>  
                        <jsp:setProperty name="editgatepass" property="prodid"  value="${book.id}" />
                 <%--       <jsp:setProperty name="editgatepass" property="rate" value="${book.rate}" />    
                            <jsp:setProperty name="editgatepass" property="comm" value="${book.commission}" />    --%>
                        <jsp:setProperty name="editgatepass" property="tax" value="${book.tax}"/>    
                        <jsp:setProperty name="editgatepass" property="cst" value="${book.cst}"/>    
                        <jsp:setProperty name="editgatepass" property="cess" value="${book.cess}"/>    
                        <jsp:setProperty name="editgatepass" property="tcd" value="${book.tcd}"/>                            
                        <jsp:setProperty name="editgatepass" property="product"  value="${book.product}"/> 
                        <jsp:setProperty name="editgatepass" property="prodtype" value="${book.prodtype}"/>
                        <jsp:setProperty name="editgatepass" property="qty"  value="0.00"/>  
                    </c:forEach>
                    <c:forEach items="${ind.rows}" var="book">       
                        <jsp:setProperty name="editgatepass" property="row" value="${book.prodname}"/>
                        <%editgatepass.setindex(editgatepass.getrowno());%>                          
                        <jsp:setProperty name="editgatepass" property="qty"  value="${book.quantity}"/>
                        <jsp:setProperty name="editgatepass" property="rate" value="${book.rate}"/>
                        <jsp:setProperty name="editgatepass" property="comm" value="${book.commi}" />
                        <jsp:setProperty name="editgatepass" property="billno" value="${book.billno}"/>   
                        <jsp:setProperty name="editgatepass" property="reclock" value="${book.reclock}"/>
                        <jsp:setProperty name="editgatepass" property="user" value="${book.user}"/>
                        <jsp:setProperty name="editgatepass" property="rectimestamp" value="${book.rectimestamp}"/>
                        
                      <%--  <jsp:setProperty name="editgatepass" property="mdt" value="${book.ratetype}"/> 
                        <jsp:setProperty name="editgatepass" property="cacr" value="${book.cacr}"/>--%>
                      <%--  PRODUCT NAME : ${book.prodname}
                        ROW No : <%=editgatepass.getrowno()%> <br> --%>
                    </c:forEach>                                                                                                          
                <%}%>
                <table width="90%">
                    <tr>
                        <td>     
                            <a style="color:#ffffff;font-size:16px; text-align: left;width: 5%;" 
                                accesskey="c" href="editGatePass.jsp?gatePassList=true&blnShow=false">Customer List</a>
                        </td>                       
                        <td>   
                            <c:if test="${!editgatepass.reclock}">
                                <a style="color:#ffffff;font-size:16px; text-align: left;width: 5%;"
                                    accesskey="s" href="../editgatepassSer">Save</a>
                            </c:if>                            
                        </td>
                        <td style="font-size:14px; text-align: left;width: 3%;">     
                            <%--<a href="../Cleargp">Clear List</a>--%>
                        </td>
                    </tr>                    
                </table>                                               
                <table cellpadding="3" width="90%">                                                                                                                         
                    <%if(editgatepass.getblnValue()){%>                         
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
                            <%editgatepass.setindex(index);%>                                                            
                            <% if(mdt == 1 ){%>
                                <jsp:setProperty name="editgatepass" property="rate" value="${book.rate - book.commission}"/>
                            <%}%>
                            <% if(mdt == 2 ){%>
                                <jsp:setProperty name="editgatepass" property="rate" value="${book.rate}"/>
                            <%}%>
                            <% if(mdt == 3 ){%>
                                <jsp:setProperty name="editgatepass" property="rate" value="${book.rate - book.commission - book.tcd}"/>
                            <%}%>
                            <% if(mdt == 4 ){%>
                                <jsp:setProperty name="editgatepass" property="rate" value="${book.utprate}"/> 
                            <%}%>         
                            <% if(mdt == 5 ){%>
                                <jsp:setProperty name="editgatepass" property="rate" value="${book.subsidy}"/> 
                            <%}%>                            
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:18px;text-align: center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:18px;text-align: left;width: 5%;">   
                                    <%if(editgatepass.getreclock()){%>
                                        ${book.product}                                        
                                    <%}else{%>    
                                        <a href="editGatePass.jsp?blnCstData=false&tcd=${book.tcd}&comm=0.00&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>
                                    <%}%>    
                                </td>                             
                                <td style="font-size:18px;text-align:right;width: 2%;">          
                                    <jsp:getProperty name='editgatepass' property='qty'/> 
                                </td> 
                                
                                <td style="font-size:18px;text-align: right;width: 2%;">          
                                    <jsp:getProperty name="editgatepass" property="rate"/>
                                </td>    
                                <td style="font-size:18px;text-align:right;width: 2%;">                                    
                                    <%= editgatepass.getqty() * editgatepass.getrate()%>
                                </td>    
                            </tr>
                        </c:forEach>  
                    <%}%>                    
                </table>
                <font size="1" face="Arial Narrow, System" color="#CC99FF"><b>
                Record last accessed on : <jsp:getProperty name="editgatepass" property="rectimestamp"/> By <jsp:getProperty name="editgatepass" property="user"/></b></font>                        
                <table onmouseout="setFocus()" onmouseover="setFocus()" cellpadding="3" width="90%">
                    <% if(!editgatepass.getblnValue()){%>                                               
                        <thead>
                            <tr style="background-color: #FF8F59">
                                <th>SL.NO</th>                            
                                <th>PRODUCT</th>                                
                                <th>QUANTITY</th>
                                <th>Change.QTY</th>
                                <th>Rate</th>
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
                            <%editgatepass.setindex(index);%> 
                            <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                                <td style="font-size:18px; text-align: center;width: 1%;">     
                                    <%=slno%>
                                </td>
                                <td style="font-size:18px; text-align: left;width: 5%;">     
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <a class="qty" href="editGatePass.jsp?blnCstData=false&tcd=${book.tcd}&comm=0.00&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                            
                                    <%}else{%> 
                                        <a href="editGatePass.jsp?blnCstData=false&tcd=${book.tcd}&comm=0.00&cess=${book.cess}&cst=${book.cst}&tax=${book.tax}&prodid=${book.id}&product=${book.product}&index=<%=index%>&blnValue=false">${book.product}</a>                                            
                                    <%}%>
                                </td>                             
                                <td style="font-size:18px; text-align: left;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input size="6" onfocus="this.blur()" class="qty" value="<jsp:getProperty name='editgatepass' property='qty'/>">
                                    <%}else{%> 
                                        <jsp:getProperty name='editgatepass' property='qty'/>
                                    <%}%>
                                </td>
                                <td style="font-size:18px;text-align: left;width: 3%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input class="qty" type="text" size="6" name="qty" value="">                                       
                                    <%}else{%> 
                                        <jsp:getProperty name='editgatepass' property='qty'/>
                                    <%}%>                                                                        
                                </td> 
                              <td style="font-size:18px; text-align: right;width: 2%;">                                    
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input size="6" name="rate" class="qty" value="${editgatepass.rate}">
                                    <%}else{%> 
                                        <%=editgatepass.getrate()%>
                                    <%}%>                                    
                                </td>                                                               
                                
                                <td style=" text-align: left;width: 1%;">        
                                    <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                        <input type="submit" name="Add" value="Add">                                      
                                        <input type="hidden" name="blnValue" value="true">                               
                                        <input type="hidden" value="false" name="gatePassList">
                                        <input type="hidden" name="prodid"  
                                        value="<jsp:getProperty name="editgatepass" property="prodid"/>"  
                                        <input type="hidden" name="custid"  
                                        value="<jsp:getProperty name="editgatepass" property="custid"/>"                                              
                                        <input type="hidden" name="product" 
                                        value="<jsp:getProperty name="editgatepass" property="product"/>"> 
                                        <input type="hidden" name="index" 
                                        value="<jsp:getProperty name="editgatepass" property="index"/>">  
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
