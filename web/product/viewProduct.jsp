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
                                16px;color: #33CCCC;vertical-align: top;"  value="STATE : " />                                        
                                <h:selectOneMenu style="vertical-align: top;" 
                                    valueChangeListener="#{product.processValueChangeEvent}">
                                <f:selectItems value="#{stateItems.statelist}"></f:selectItems>
                            </h:selectOneMenu>&nbsp;&nbsp;
                            <h:commandButton actionListener="#{product.init}" 
                                type="submit" image="../graphics/reload.GIF"  />
                        </td>
                        <td>
                            <h:commandButton rendered="#{product.next}" 
                                image="../graphics/next.GIF" 
                                actionListener="#{product.processNextPageActionEvent}" />                                          
                               <%--     <c:if test="${!customer.next}">
                                        <h:commandButton image="graphics/next_grey.GIF" />                                                                                                                     
                                    </c:if>       --%>  
                            <h:commandButton rendered="#{product.previous}"  
                                image="../graphics/previous.GIF"
                                actionListener="#{product.processPrevPageActionEvent}"/>                                                                                                                 

                            <c:if test="${!product.previous}">
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
                                <h:outputText value="PRODUCT"/></th>
                           <th class="list-header">
                                <h:outputText value="STATE"/></th> 
                           <th class="list-header">
                                <h:outputText value="RATE"/></th>
                           <th class="list-header">
                                <h:outputText value="COMMISSION"/></th>                                
                           <th class="list-header">
                                <h:outputText value="TCD"/></th>                                
                          <th class="list-header">
                                <h:outputText value="TAX"/></th>
                          <th class="list-header">
                                <h:outputText value="CST"/></th>                                
                          <th class="list-header">
                                <h:outputText value="CESS"/></th>                                
                        </tr>                                                
                     </thead>                         
                     <c:forEach items="#{product.productItems}" var="book" varStatus="stat">
                         <c:set var="book" scope="request" value="${book}"/> 
                         <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                            <td style=" text-align: left;width: 3%;">     
                                <h:outputText id="ProdId" value="#{book.id}" />                              
                            </td> 
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="ProdType" value="#{book.prodtype}" />                              
                            </td>                            
                            <td style=" text-align: left;width: 15%;">     
                                <h:outputText id="prodName" value="#{book.product}" />                              
                            </td>                                                                                     
                             <td style=" text-align: left;width: 10%;">     
                                <h:outputText id="stateid" value="#{book.stateid}">      
                                </h:outputText>
                            </td>                                                                                        
                            <td style=" text-align: left;width: 6%;">
                                <h:outputText id="rate" value="#{book.rate}"/>
                            </td>
                            <td style=" text-align: left;width: 6%;">
                                <h:outputText id="rate" value="#{book.commission}"/>
                            </td>                            
                            <td style=" text-align: left;width: 6%;">
                                <h:outputText id="rate" value="#{book.tcd}"/>
                            </td>                                                        
                            <td style=" text-align: left;width: 6%;">
                                <h:outputText id="tax" value="#{book.tax}"/><br>
                            </td>    
                            <td style=" text-align: left;width: 6%;">
                                <h:outputText id="cst" value="#{book.cst}"/><br>
                            </td>                       
                            <td style=" text-align: left;width: 6%;">
                                <h:outputText id="cess" value="#{book.cess}"/>                                
                            </td>                                                       
                         </tr>                          
                         <c:remove var="book" scope="request"/>
                     </c:forEach>                       
                </table>                                                                               
            </h:form>            
        </f:view>    
    </body>
</html>
