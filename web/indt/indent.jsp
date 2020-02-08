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
        <title>CUSTOMER DETAILS</title>        
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">
    </head>
    <body>                
        <f:view>
            <h:form>          
                <h:messages errorStyle="color: resd" 
                    infoStyle="color: green;font-size:21px" layout="table"/>                                              
                <table width="90%">
                   <%-- <c:if var="blnShowValue" test="${indent.blnShow}">   --%>                     
                        <tr style="background-color: #FF9DCE;color: #ffffff;font-size:17px;">
                            <td style="width: 15%" >
                                <h:outputText value="Customer List" />                                        
                            </td>
                            <td style="width: 30%">                                                                                    
                                <h:selectOneMenu value="#{indent.customerID}" 
                                    valueChangeListener="#{indent.processCustomerValueEvent}">
                                    <f:selectItems value="#{indent.customerlist}"/>
                                </h:selectOneMenu>                                                         
                            </td>
                            <td style="width: 30%"> 
                                <h:outputText value="Date :" />&nbsp;  
                            </td>    
                            <td style="width: 20%"> 
                                <h:inputText required="true" requiredMessage="Invalid Indent-Date...!!!" 
                                    value="#{indent.trdate}" size="10" id="date" >                                    
                                    <f:convertDateTime pattern="dd.MM.yyyy" dateStyle="short" />
                                </h:inputText>
                            </td>
                        </tr>  
                </table>
                <table width="90%">
                    <tr style="background-color: #FFFF51;color: #000000;font-size:17px;">
                        <td style="width: 15%" >
                            <h:outputText value="Products : "/>
                        </td>
                        <td style="width: 30%">    
                            <h:selectOneMenu valueChangeListener="#{indent. processProductsEvent}" >
                                <f:selectItems value="#{indent.productList}"/>
                            </h:selectOneMenu>                                                                                     
                        </td>                        
                        <td style="width: 15%"> 
                            <h:outputText value="Quantity : "/>
                        </td>
                        <td style="width: 15%"> 
                            <h:inputText  value="#{indent.quantity}" size="6" />
                        </td>
                        <td style="width: 20%"> 
                            &nbsp;&nbsp;&nbsp;<h:commandButton alt="add item" 
                                image="../graphics/add_16.gif" actionListener="#{indent.AddItem}"/>&nbsp;&nbsp;&nbsp;                        
                            <h:commandButton alt="remove item"   image="../graphics/redo_116.gif" 
                                actionListener="#{indent.RemoveItem}"/>                            
                        </td>
                    </tr>
                </table><br>    
                <table width="90%">
                    <tr>
                        <td style="width: 20%"> 
                            <h:outputText style="color: #CA00CA;font-size:16px;" 
                                value="  I N D E N T   C A R T  "/>                                            
                        </td>
                        <td style="align-text: right;width: 5%">
                            <h:commandLink value="Clear Cart" action="#{indent.Refresh}"/>
                        </td>
                    </tr>
                 </table>
                 <table width="90%">            
                     <thead>
                        <tr style="background-color: #FF8F59">
                           <th>PRODUCT</th>
                           <th>QUANTITY</th>
                           <th>RATE</th>                           
                           <th>AMOUNT</th>
                        </tr>                                                
                    </thead>                                  
                    <c:forEach items="#{indent.list}" var="book" varStatus="stat">
                        <c:set var="book" scope="request" value="${book}"/> 
                        <tr class="${(stat.index % 2) == 0 ? "list-row-even" : "list-row-odd"}">
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="ProductName" value="#{book.prodname}" />                              
                            </td>
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="qty" value="#{book.quantity}" />
                            </td> 
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="rate" value="#{book.rate}" />                              
                            </td>                             
                            <td style=" text-align: left;width: 6%;">     
                                <h:outputText id="amt" value="#{book.amount}" />                              
                            </td> 
                        </tr>                         
                        <c:remove var="book" scope="request"/>
                    </c:forEach>                                                
                </table>                
                <h:commandButton action="#{indent.create}" type="submit" 
                    value="Submit Indent"/>
            </h:form>
        </f:view>        
    </body>
</html>
