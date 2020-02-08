<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fn"%> 
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/styleSheet.css">         
    </head>    
    <%!public int slno = 0; %> 
    <body style="background:#820041">
        <f:view>
            <h:form>
                <f:loadBundle var="bundle" basename="mktg.packageMessages.splPackageMessages" />    
                <h:outputText style="color: #FFFFFF" id="ToDaysDate" value="#{bundle.Sales}"></h:outputText>              
                <h:inputText size="10" immediate="true" value="#{daysales.date}">&nbsp;
                    <f:convertDateTime pattern="dd.MM.yyyy" dateStyle="short" type="date"/>
                </h:inputText>&nbsp;
                <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF"  
                    actionListener="#{daysales.processActionEvent}" type="submit" value="Submit" />
                <table cellpadding="3" width="90%">                                                                                                                                          
                    <thead>
                        <tr style="background-color: #FF8F59">            
                            <th>SL.NO</th> 
                            <th>MILK</th>
                            <th>DEMAND</th>
                            <th>SUPPLY</th>
                            <th>Variation</th>    
                            <th>LEAKAGE</th>
                            <Th>RETURN</Th>                            
                        </tr>                                                
                    </thead>  
                    <%slno = 0 ;%> 
                    <c:forEach items="${daysales.milkQty}" var="book" varStatus="stat">
                        <%slno++;%> 
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">   
                            <td style="font-size:20px; text-align: center;width: 1%;">     
                                <%=slno%>
                            </td>                            
                            <td style="color:#0000D5;font-size:18px;text-align:left;width:9%;font-weight: bold;">                 
                                ${book.key}
                            </td>                             
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.demand}" />
                            </td>   
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.sales}" />                               
                            </td>                               
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${(book.value.sales+book.value.leakage+book.value.retn)-book.value.demand }" />
                            </td>                                                                                       
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.leakage}" />
                            </td>                                                           
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.retn}" />
                            </td>                                                           
                        </tr>
                    </c:forEach>                  
                </table>
                 <table cellpadding="3" width="90%">                                                                                                                                          
                    <tr>
                        <td style="font-size:20px;color: #ffffff;text-align:right;width: 5%;">
                            <h:outputText value="TOTAL MILK QUANTITY IN(Ltrs) : "/>
                        </td>
                        <td style="font-size:20px;color: #ffffff;text-align:left;width: 5%;">
                            <fn:formatNumber value="${daysales.totalQty}" minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" />                                              
                        </td>                        
                    </tr>                                                         
                </table>
               <table cellpadding="3" width="90%">                                                                                                                                          
                    <thead>
                        <tr style="background-color: #FF8F59">      
                            <th>SL.NO</th> 
                            <th>PRODUCT</th>
                            <th>DEMAND</th>
                            <th>SUPPLY</th>
                            <th>Variation</th>
                            <th>LEAKAGE</th>
                            <Th>RETURN</Th>
                        </tr>                                                
                    </thead>            
                    <%slno = 0 ;%>  
                    <c:forEach items="${daysales.prodQty}" var="book" varStatus="stat">
                        <%slno++;%> 
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">   
                            <td style="font-size:20px; text-align: center;width: 1%;">     
                                <%=slno%>
                            </td>                            
                            <td style="color:#0000D5;font-size:18px;text-align:left;width:9%;font-weight: bold;">                 
                                ${book.key}
                            </td>                             
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.demand}" />
                            </td>   
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.sales}" />
                            </td>                               
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${(book.value.sales+book.value.leakage+book.value.retn)-book.value.demand }" />
                            </td>                                                                                       
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.leakage}" />
                            </td>                                                           
                            <td style="color:#0000D5;font-size:18px;text-align:right;width:5%;font-weight: bold;">     
                               <fn:formatNumber minFractionDigits="2" maxFractionDigits="2" type="number" pattern="##########.##" value="${book.value.retn}" />
                            </td>                                                           
                        </tr>
                    </c:forEach>                  
                </table>            
            </h:form>
        </f:view>
    </body>
</html>
