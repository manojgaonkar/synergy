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
                                    valueChangeListener="#{customer.processValueChangeEvent}">
                                <f:selectItems value="#{route.route}"></f:selectItems>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:commandButton actionListener="#{customer.init}" 
                                type="submit" image="../graphics/reload.GIF"  />
                        </td>
                        <td>
                            <h:commandButton rendered="#{customer.next}" 
                                image="../graphics/next.GIF" 
                                actionListener="#{customer.processNextPageActionEvent}" />                                          
                               <%--     <c:if test="${!customer.next}">
                                        <h:commandButton image="graphics/next_grey.GIF" />                                                                                                                     
                                    </c:if>        --%>
                            <h:commandButton rendered="#{customer.previous}"  
                                image="../graphics/previous.GIF"
                                actionListener="#{customer.processPrevPageActionEvent}"/>                                                                                                                 

                            <c:if test="${!customer.previous}">
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
                                <h:outputText value=" ********* CUSTOMER PERSONAL DETAILS ********* "/></th>
                        </tr>
                        <tr>
                           <th class="list-header">
                                <h:outputText value = "ID" /></th>                            
                           <th class="list-header">
                                <h:outputText value = "TYPE" /></th>
                           <th class="list-header">
                                <h:outputText value="CASH/CREDIT"/></th>
                           <th class="list-header">
                                <h:outputText value="OP.DATE"/></th> 
                           <th class="list-header">
                                <h:outputText value="NAME/TITLE"/></th>
                          <th class="list-header">
                                <h:outputText value="ADDRESS"/></th>
                          <th class="list-header">
                                <h:outputText value="CONTACT NO"/></th>                                
                          <th class="list-header">
                                <h:outputText value="TALUKA"/></th>                                
<%--                          <th class="list-header">
                                <h:outputText value="ROUTE"/></th>                               --%>
                          <th class="list-header"> 
                                <h:outputText value="DEPOSIT AMOUNT"/></th>                                
                          <th class="list-header">
                                <h:outputText value="DEPOSIT DATE"/></th>                                
                          <th class="list-header">
                                <h:outputText value="OPENING BAL."/></th>                                 
                        </tr>                                                
                     </thead>                                                                                                   
                     <c:forEach items="#{customer.customerlist}" var="book" varStatus="stat">
                        <c:set var="book" scope="request" value="${book}"/> 
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="CustId" value="#{book.id}" />                              
                              <%--  <input value="bb" name="chk" type="checkbox"> 
                                <h:selectOneRadio layout="pageDirection" immediate="true" 
                                    valueChangeListener="#{customer.processvalueChangerListener}">
                                    <f:selectItems value="#{customer.alnew}" />
                                </h:selectOneRadio>   --%>
                            </td>
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="CustType" value="#{book.custtype}" />                              
                            </td> 
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="Cacr" value="#{book.cacr}" />                              
                            </td>                             
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="CommDate" value="#{book.comdate}">      
                                    <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                                </h:outputText>
                            </td>                                                            
                            <td class="list-column-left">
                                <h:outputText id="firstName" value="#{book.firstname}"/>
                            </td>
                            <td style=" text-align: left;width: 25%;">
                                <h:outputText id="add1" value="#{book.add1}"/><br>
                                <h:outputText id="add2" value="#{book.add2}"/><br>
                                <h:outputText id="add3" value="#{book.add3}"/>
                            </td>    
                            <td style=" text-align: left;width: 12%;">
                                <h:outputText id="phone" value="#{book.phone}"/><br>
                                <h:outputText id="mobile" value="#{book.mobile}"/>
                            </td>                       
                            <td style=" text-align: left;width: 15%;">
                                <h:outputText id="taluka" value="#{book.taluka}"/>                                
                            </td>
                   <%--         <td style=" text-align: left;width: 15%;">
                                <h:outputText id="route" value="#{book.route}"/>    
                            </td>                            --%>
                            <td class="list-column-right">
                                <h:outputText id="deposit" value="#{book.deposit}">
                                    <f:convertNumber type="currency" currencySymbol="Rs"/>
                                </h:outputText>
                            </td>
                            <td class="list-column-right">
                                <h:outputText id="depodate" value="#{book.depodate}">
                                    <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                                </h:outputText>                                    
                            </td>
                            <td class="list-column-right">
                                <h:outputText id="openingbal" value="#{book.openingbal}">                                    
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
