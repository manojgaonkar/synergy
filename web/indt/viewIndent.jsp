<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>  

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer List</title>
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">                        
        <link rel="stylesheet" type="text/css" href="../css/default.css">
        <link rel="stylesheet" type="text/css" href="../css/ipg.css">
        <link rel="stylesheet" type="text/css" href="../css/j5eetutorial.css">                   
    </head>
    <body>
        <f:view>        
            <h:form>
                <table width="100%">
                    <tr style="background-color: #FF59AC">
                        <td align="left">
                            <h:outputText style="font-family: Arial Black;font-size: 
                                16px;color: #33CCCC;vertical-align: top;" value="ROUTE : " />                                        
                                <h:selectOneMenu style="vertical-align: top;" 
                                    valueChangeListener="#{indent.processValueChangeEvent}">
                                <f:selectItems value="#{route.route}"></f:selectItems>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:inputText value="#{indent.trdate}" style="vertical-align: top;" id="IndtDate" size="10" >                              
                                 <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/> 
                            </h:inputText>&nbsp;&nbsp;                            
                            <h:commandButton actionListener="#{indent.init}" 
                                type="submit" image="../graphics/reload.GIF"  />
                        </td>
                        <td>
                            <h:commandButton rendered="#{indent.next}" 
                                image="../graphics/next.GIF" 
                                actionListener="#{indent.processNextPageActionEvent}" />                                          
                               <%--     <c:if test="${!customer.next}">
                                        <h:commandButton image="graphics/next_grey.GIF" />                                                                                                                     
                                    </c:if>        --%>
                            <h:commandButton rendered="#{indent.previous}"  
                                image="../graphics/previous.GIF"
                                actionListener="#{indent.processPrevPageActionEvent}"/>                                                                                                                 

                            <c:if test="${!indent.previous}">
                                <h:commandButton image="../graphics/previous_grey.GIF" />                                                                                                                     
                            </c:if>  
                        </td>                        
                    </tr>
                </table><BR>                
                <table border="1" class="list-background" 
                     summary="Add books from the catalog to your shopping cart.">     
                     <thead>
                        <tr>
                           <th colspan="6" class="list-header">
                                <h:outputText value=" ********* ROUTE INDENT DETAILS ********* "/></th>
                        </tr>
                        <tr>
                           <th class="list-header">
                                <h:outputText value = "BILL.NO" /></th>                            
                           <th class="list-header">
                                <h:outputText value = "DATE" /></th>
                           <th class="list-header">
                                <h:outputText value="CASH/CREDIT"/></th>
                           <th class="list-header">
                                <h:outputText value="CUSTOMER"/></th> 
                           <th class="list-header">
                                <h:outputText value="PRODUCT"/></th>
                          <th class="list-header">
                                <h:outputText value="QUANTITY"/></th>
                          <th class="list-header">
                                <h:outputText value="RATE"/></th>                                
                          <th class="list-header">
                                <h:outputText value="AMOUNT"/></th>                                
                        </tr>                                                
                     </thead>                                                                                                   
                     <c:forEach items="#{indent.indentList}" var="book" varStatus="stat">
                        <c:set var="book" scope="request" value="${book}"/> 
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="Billno" value="#{book.billno}" />                              
                            </td>
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="Date" value="#{book.idate}">                              
                                     <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                                 </h:outputText>
                            </td> 
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="Cacr" value="#{book.cacr}" />                              
                            </td>                             
                            <td style=" text-align: left;width: 20%;">     
                                <h:outputText id="customer" value="#{book.custname}"/>                                                                         
                            </td>                                                            
                            <td class="list-column-left;width: 10%;">     
                                <h:outputText id="productName" value="#{book.prodname}"/>
                            </td>
                            <td style=" text-align: right;width: 15%;">
                                <h:outputText id="quantity" value="#{book.quantity}"/>                                
                            </td>
                            <td class="list-column-right">
                                <h:outputText id="rate" value="#{book.rate}">
                                    <f:convertNumber type="currency" currencySymbol="Rs"/>
                                </h:outputText>
                            </td>
                            <td class="list-column-right">
                                <h:outputText id="amount" value="#{book.amount}">
                                    <f:convertNumber type="currency" currencySymbol="Rs"/>
                                </h:outputText>                                    
                            </td>
                        </tr>
                        <c:remove var="book" scope="request"/>
                    </c:forEach>                        
                </table>                                                                               
            </h:form>            
        </f:view>    
    </body>
</html>
