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
                form.grno.select();
               }            
        </script>
    </head>        
    
    <jsp:useBean id="rcpt" scope="session" class="mktg.backingBean.receipt" />   
    <jsp:setProperty name="rcpt" property="index" param="index" />          
    <jsp:setProperty name="rcpt" property="routeid" param="routeid" />         
    <jsp:setProperty name="rcpt" property="cacr" param="cacr"/>    
    <jsp:setProperty name="rcpt" property="idate" param="idate"/>       
    <jsp:setProperty name="rcpt" property="blnValue" param="blnValue"/>      
    <jsp:setProperty name="rcpt" property="rtname" param="rtname"/>        
    <jsp:setProperty name="rcpt" property="reclock" param="reclock"/>    
    <jsp:setProperty name="rcpt" property="amt" param="amt" />  
    <jsp:setProperty name="rcpt" property="grno" param="grno"/>    
    <jsp:setProperty name="rcpt" property="grdate" param="grdate"/>    
    <jsp:setProperty name="rcpt" property="chequeno" param="chequeno"/>
    <jsp:setProperty name="rcpt" property="gpno" param="gpno"/>    
    <jsp:setProperty name="rcpt" property="lessamt" param="lessamt"/>    
    <jsp:setProperty name="rcpt" property="exceamt" param="exceamt"/>        
    <jsp:setProperty name="rcpt" property="billno" param="billno"/>
    <jsp:setProperty name="rcpt" property="id" param="id"/>
    
    <body>            
        <form name="form">  
            <%!public int tracker = -1; %>
            <%!public int index = -1; %>            
            <%!public int slno = 0; %>   
            <%!public boolean blnCstrcpt = true; %>   
            
            <%        
                if(request.getParameter("rstype") != null)
                    session.setAttribute("type",Integer.parseInt(request.getParameter("rstype")));                    

                if(request.getParameter("idate") != null)
                    session.setAttribute("idate",request.getParameter("idate"));

                if(request.getParameter("blnCstrcpt") !=null)
                    blnCstrcpt = Boolean.parseBoolean(request.getParameter("blnCstrcpt"));                    
                    
                if(request.getParameter("routeid") != null)
                    Integer.parseInt(request.getParameter("routeid"));

                if(request.getParameter("index") != null)
                    Integer.parseInt(request.getParameter("index"));                    
                
                if(request.getParameter("index") != null)
                    session.setAttribute("tracker",Integer.parseInt(request.getParameter("index").toString()));                       

                if(request.getParameter("blnValue") !=null)
                    Boolean.parseBoolean(request.getParameter("blnValue"));    
            %>    
            <h4>Cash Receipt</h4>
            <table width="100%">
                <tr>
                    <td style="font-size:14px; text-align: left;width: 3%;font-weight: 800;">     
                        DATE :&nbsp;<%=session.getAttribute("idate")%>
                    </td>                                        
                    <td style="font-size:14px; text-align: left;width: 3%;font-weight: 800;">     
                        <a href="../CashierSer">Save</a>
                    </td>
                </tr>                    
            </table>
            <%if(Integer.parseInt(session.getAttribute("type").toString()) == 1){%>            
                <sql:query dataSource="jdbc/kmfmktgNew" 
                    var="indt" 
                    sql="SELECT idate,route,rtname,grno,gpno,grdate,chequeno,lessamt,exceamt,   
                        sum(netamount+taxamt-subsidy-lessamt+exceamt) 'amt',reclock 
                        FROM indent 
                        WHERE indent.idate= ? 
                        AND (indent.entrytype = 1 OR indent.entrytype = 3 )  
                        AND indent.cacr= 'Cash' 
                        GROUP by route;">
                    <sql:param value="${rcpt.idate}"/> 
                </sql:query>
            <%}%>  
            <%if(Integer.parseInt(session.getAttribute("type").toString()) == 2){%>            
                <sql:query dataSource="jdbc/kmfmktgNew" 
                    var="indt" 
                    sql="SELECT id,idate,route,custname 'rtname',grno,gpno,chequeno,
                        lessamt,exceamt,grdate,billno,sum(amount) 'amt',reclock
                        FROM indent
                        WHERE idate = ? and saletype = 2 and cacr='Cash' 
                        GROUP BY billno;">
                    <sql:param value="${rcpt.idate}"/> 
                </sql:query>                        
            <%}%>  
            <%if(blnCstrcpt){%>                 
                <%index = -1;%>
                <c:forEach items="${indt.rows}" var="book" >                                                               
                    <%index++;rcpt.setindex(index); %>                         
                    <jsp:setProperty name="rcpt" property="id" value="${book.id}"/>
                    <jsp:setProperty name="rcpt" property="amt" value="${book.amt}"/>
                    <jsp:setProperty name="rcpt" property="reclock" value="${book.reclock}"/>
                    <jsp:setProperty name="rcpt" property="grno" value="${book.grno}"/>
                    <jsp:setProperty name="rcpt" property="grdate" value="${book.grdate}"/>
                    <jsp:setProperty name="rcpt" property="chequeno" value="${book.chequeno}"/>
                    <jsp:setProperty name="rcpt" property="gpno" value="${book.gpno}"/>
                    <jsp:setProperty name="rcpt" property="lessamt" value="${book.lessamt}"/>
                    <jsp:setProperty name="rcpt" property="exceamt" value="${book.exceamt}"/>
                </c:forEach>                 
            <%}%>             
            <table cellpadding="2" width="100%">                                                                                                                         
                <%if(rcpt.getblnValue()){%>    
                    <thead>
                        <tr style="background-color: #FF8F59">
                            <th>SL.NO</th>                            
                            <th>Routes</th>
                            <th>Recvbl.Amt</th>
                            <th>Gatepass No</th>
                            <th>GR.NO</th>
                            <th>GR.DATE</th>
                            <th>CHQ.NO</th>
                            <th>Short.Amt</th>
                            <th>Excess.Amt</th>
                        </tr>                                                
                    </thead>                                                                   
                    <%index = -1;%>
                    <%slno = 0 ;%>    
                    <c:forEach items="${indt.rows}" var="book" varStatus="stat">
                        <%index++;%>    
                        <%slno++;%>    
                        <%rcpt.setindex(index);%>                                
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">                                
                            <td style="font-size:14px; text-align: center;width: 1%;"><%=slno%></td>
                            <td style="${rcpt.amt > 0 ? "color:#F31105;font-size:18px;text-align:left;width:9%;font-weight: bold;" : "font-size:18px;text-align:left;width:9%;"}">                 
                                <a href="receipt.jsp?routeid=${book.route}&blnCstrcpt=false&index=<%=index%>&blnValue=false&billno=${book.billno}">${book.rtname}</a>
                            </td>                             
                            <td style="${rcpt.amt > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <jsp:getProperty name='rcpt' property='amt'/> 
                            </td>   
                            <td style="${rcpt.gpno != null ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <jsp:getProperty name="rcpt" property="gpno"/>
                            </td>                                  
                            
                            <td style="${rcpt.amt > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <jsp:getProperty name="rcpt" property="grno"/>
                            </td>                                  
                            <td style="${rcpt.amt > 0 ? "color:#F31105;font-size:18px;text-align:right;width:7%;font-weight: bold;" : "font-size:18px;text-align:right;width:7%;"}">     
                                ${rcpt.grdate}
                            </td>
                           <td style="${rcpt.amt > 0 ? "color:#F31105;font-size:18px;text-align:right;width:5%;font-weight: bold;" : "font-size:18px;text-align:right;width:5%;"}">     
                                <jsp:getProperty name="rcpt" property="chequeno"/>
                            </td>                              
                            
                            <td style="${rcpt.lessamt > 0 ? "color:#F31105;font-size:18px;text-align:right;width:7%;font-weight: bold;" : "font-size:18px;text-align:right;width:7%;"}">     
                                ${rcpt.lessamt}
                            </td>                            
                            <td style="${rcpt.exceamt > 0 ? "color:#F31105;font-size:18px;text-align:right;width:7%;font-weight: bold;" : "font-size:18px;text-align:right;width:7%;"}">     
                                ${rcpt.exceamt}
                            </td>                                                        
                        </tr>
                    </c:forEach>  
                <%}%>
            </table>
            <table cellpadding="2" width="100%">
                <% if(!rcpt.getblnValue()){%>                  
                    <thead>
                        <tr style="background-color: #FF8F59">
                            <th>SL.NO</th>                            
                            <th>Routes</th>
                            <th>Recvbl.Amt</th>
                            <th>Gatepass No</th>
                            <th>GR.NO</th>
                            <th>GR.DATE</th>
                            <th>CHQ.NO</th>
                            <th>Short.Amt</th>
                            <th>Excess.Amt</th>                            
                            <th>Add</th>
                        </tr>                                                
                    </thead>                        
                    <%index = -1;%>
                    <%slno = 0 ;%>                            
                    <%tracker = -1 ;%>  
                    <c:forEach begin="0" items="${indt.rows}" var="book" varStatus="stat">
                        <%index++;%>    
                        <%slno++;%>   
                        <%tracker++;%>   
                        <%rcpt.setindex(index);%> 
                         <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                            <td style="font-size:20px; text-align: center;width: 1%;"><%=slno%></td>
                            <td style="font-size:20px; text-align: left;width: 5%;">                 
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <a onfocus="setFocus()" class="qty" onmouseout="setFocus()" onmouseover="setFocus()" href="receipt.jsp?routeid=${book.route}&blnCstrcpt=false&prodid=${book.id}&index=<%=index%>&blnValue=false&billno=${book.billno}">${book.rtname}</a>                                    
                                <%}else{%>                                         
                                    <a onmouseout="setFocus()" onmouseover="setFocus()" href="receipt.jsp?routeid=${book.route}&blnCstrcpt=false&prodid=${book.id}&index=<%=index%>&blnValue=false&billno=${book.billno}">${book.rtname}</a>                                                                        
                                <%}%>                                    
                            </td>                             
                            <td style="font-size:20px; text-align: left;width: 3%;">                                          
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input onchange="setFocus()" size="5" onfocus="this.blur()" class="qty" value="<jsp:getProperty name='rcpt' property='amt'/>">
                                <%}else{%>                                                                                 
                                    <jsp:getProperty name='rcpt' property='amt'/> 
                                <%}%>
                            </td>                                 
                            <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" type="text" size="5" name="gpno" value="<jsp:getProperty name="rcpt" property="gpno"/>">        
                                <%}else{%>                                         
                                    <jsp:getProperty name='rcpt' property='gpno'/>
                                <%}%>
                            </td>                                                                                                                                                             
                            
                            <%-- Need to add --%>
                            <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" type="text" size="5" name="grno" value="<jsp:getProperty name="rcpt" property="grno"/>">        
                                <%}else{%>                                         
                                    <jsp:getProperty name='rcpt' property='grno'/>
                                <%}%>
                            </td>                                                                                                                                 
                            <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" type="text" size="10" name="grdate" 
                                        value="${rcpt.grdate}">        
                                <%}else{%>                                         
                                    ${rcpt.grdate}
                                <%}%>
                            </td>  
                           <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" type="text" size="5" name="chequeno" value="<jsp:getProperty name="rcpt" property="chequeno"/>">        
                                <%}else{%>                                         
                                    <jsp:getProperty name='rcpt' property='chequeno'/>
                                <%}%>
                            </td>                    
                            
                            <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" type="text" size="6" name="lessamt" 
                                        value="${rcpt.lessamt}">        
                                <%}else{%>                                         
                                    ${rcpt.lessamt}
                                <%}%>
                            </td>                              
                            <td style="font-size:20px; text-align: left;width: 3%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input class="qty" type="text" size="6" name="exceamt" 
                                        value="${rcpt.exceamt}">        
                                <%}else{%>                                         
                                    ${rcpt.exceamt}
                                <%}%>
                            </td>  
                            <td style=" text-align: left;width: 1%;">        
                                <%if(Integer.parseInt(session.getAttribute("tracker").toString()) == tracker){%>
                                    <input type="hidden" name="index" 
                                    value="<jsp:getProperty name="rcpt" property="index"/>">                                  
                                    <input type="hidden" name="blnValue" value="true">     
                                    <input type="submit" name="Add" value="Add">                                                                                                    
                                <%}%>
                            </td>
                        </tr>
                    </c:forEach>               
                <%}%>                        
            </table>    
        </form>
    </body>
</html>
