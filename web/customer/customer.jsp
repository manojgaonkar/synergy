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
        <link rel="stylesheet" href="../css/styleSheet.css" type="text/css"> 
    </head>
    <body style="background:#820041">
        <font style="font-size:20px;color:#ffffff"><em>Customer opening form</em></font>
        <f:view>
            <h:form>
                <h:messages errorStyle="color: red" infoStyle="color: green;font-size:21px" layout="table"/>                              
                <h:panelGrid border="1" 
                    columns="2" headerClass="list-header" 
                    rowClasses="list-row-even, list-row-odd"
                    columnClasses="list-column-right,list-column-left,list-column-center" 
                    styleClass="list-background"
                    title="Customer Basic Information" >
                        
                    <h:outputText style="color: red" value="Title / Name " />
                    <h:inputText required="true" requiredMessage="Customer name is mandatory....!!!!"
                        id="firstname" maxlength="50" size="50" 
                        value="#{customer.customer.firstname}" />  
                    
                    <h:outputText value="Commence Date (dd.mm.yyyy) " />                    
                    <h:inputText immediate="true" required="true" requiredMessage="Commence Date is must...!!! "
                        value="#{customer.customer.comdate}" id="comdate" size="10" maxlength="10" >
                        <f:convertDateTime pattern="dd.MM.yyyy" dateStyle="short"/>
                    </h:inputText>
                    
                    <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                        value="Customer Type " />                    
                    <h:outputText value="" />                    
                    
                    <h:outputText value="Type " />                                        
                    <h:selectOneMenu value="#{customer.customer.custtype}">
                        <f:selectItems value="#{cstType.customerType}"></f:selectItems>
                    </h:selectOneMenu>
                    
                    <h:outputText value="Rate Type " />                                        
                    <h:selectOneMenu value="#{customer.customer.ratetype}">
                        <f:selectItem itemLabel="Dealer Price" itemValue="1"/>
                        <f:selectItem itemLabel="MRP" itemValue="2"/>
                        <f:selectItem itemLabel="TCD" itemValue="3"/>
                        <f:selectItem itemLabel="UTP" itemValue="4"/>
                        <f:selectItem itemLabel="Subsidy" itemValue="5"/>
                        <f:selectItem itemLabel="Spl.Rate" itemValue="6"/>
                    </h:selectOneMenu>                     
                    
                    <h:outputText value="Cash/Credit " />                                        
                    <h:selectOneMenu value="#{customer.customer.cacr}">
                        <f:selectItem itemLabel="cash" itemValue="Cash"/>
                        <f:selectItem itemLabel="credit" itemValue="Credit"/>
                    </h:selectOneMenu> 
                    <h:outputText value="Subsidy "/>                                        
                    <h:inputText dir="RTL" size="10" id="Subsidy" maxlength="10" 
                            value="#{customer.customer.subsidy}"/>                        
<%--                    <h:outputText value="Mid Name : " />
                    <h:inputText id="midname" maxlength="50" size="50" 
                        value="#{customer.customer.midName}" />                                                                    
                    <h:outputText value="Last Name : " />
                    <h:inputText id="lastname" maxlength="50" size="50" 
                        value="#{customer.customer.lastName}" />            --%>                                                        
                    <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                        value="Postal Address " />
                    <h:outputText value="  " />                    
                        
                    <h:outputText value="Address(1) " />
                    <h:inputText id="add1" maxlength="50" size="50" 
                        value="#{customer.customer.add1}" />                    

                    <h:outputText value="Address(2) " />
                    <h:inputText id="add2" maxlength="50" size="50" 
                        value="#{customer.customer.add2}" />                                            
                        
                    <h:outputText value="Address(3) " />
                    <h:inputText id="add3" maxlength="50" size="50" 
                        value="#{customer.customer.add3}" />     
                        
                    <h:outputText value="Address(4) " />
                    <h:inputText id="add4" maxlength="50" size="50" 
                        value="#{customer.customer.add4}" />                             
                        
                    <h:outputText value="Address(5) " />
                    <h:inputText id="add5" maxlength="50" size="50" 
                        value="#{customer.customer.add5}" />                                                     

                    <h:outputText value="State " />                                        
                    <h:selectOneMenu value="#{customer.customer.stateid}">
                        <f:selectItems value="#{stateItems.statelist}"></f:selectItems>
                    </h:selectOneMenu>                         
                        
                    <h:outputText value="Taluka " />                                        
                    <h:selectOneMenu value="#{customer.customer.taluka}">
                        <f:selectItems value="#{talukaItems.talukalist}"></f:selectItems>
                    </h:selectOneMenu> 
                    
                    <h:outputText value="Milk Sales Route " />                                        
                    <h:selectOneMenu value="#{customer.customer.route}">
                        <f:selectItems value="#{route.route}"></f:selectItems>
                    </h:selectOneMenu>                     
                    
                    <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                        value="Contact No " />                    
                    <h:outputText value="  " />                                        
                    
                    <h:outputText value="Home/Parlour " />
                    <h:inputText id="phone" maxlength="15" size="15" 
                        value="#{customer.customer.phone}" />                                                                                            
                    
                    <h:outputText value="Mobile No " />                                        
                    <h:inputText id="mobile" maxlength="15" size="15" 
                        value="#{customer.customer.mobile}" />                                                                                            

                    <h:outputText value="Pan No " />                                        
                    <h:inputText id="panno" maxlength="14" size="14" 
                        value="#{customer.customer.panNo}" />     
                    
                   <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                        value="Bank " />                                        
                    <h:selectOneMenu value="#{customer.customer.bank}">
                        <f:selectItems value="#{bank.banklist}"></f:selectItems>
                    </h:selectOneMenu>                        
                        
                    <h:outputText value="Bank A/c No " />                                        
                    <h:inputText id="acno" maxlength="15" size="15" 
                        value="#{customer.customer.acNo}" />                             
             
                    <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                        value="Payment Details " />
                    <h:outputText value="  " />                                            
                        
                    <h:outputText value="Deposit Amount " />                                        
                    <h:inputText dir="RTL" id="deposit" maxlength="10" size="10" 
                        value="#{customer.customer.deposit}" />                             
                       
                    <h:outputText value="Deposit Date (dd.mm.yyyy) " />                    
                    <h:inputText value="#{customer.customer.depodate}"  
                        id="depodate" size="10" maxlength="10" >
                        <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                    </h:inputText>
                    
                    <h:outputText value="(GR)No " />                    
                    <h:inputText id="GRNO" size="10" value="#{customer.customer.grNo}"/>
                    
                    <h:outputText value="(GR)Date (dd.mm.yyyy) " />                    
                    <h:inputText value="#{customer.customer.grDate}"  
                        id="grdate" size="10" maxlength="10" >
                        <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                    </h:inputText>                    
                    
                    <h:outputText value="Nominee Information " />                    
                    <h:inputText value="#{customer.customer.nominee}" size="45" id="nominee" />                                    
                    
                    <h:outputText value="POLICY.NO"/>
                    <h:inputText maxlength="45" size="25" value="#{customer.customer.policyno}"/>
                    
                    <h:outputText value="OPENING BAL."/>
                    <h:inputText id="openingbal" size="10" value="#{customer.customer.openingbal}">                        
                    </h:inputText>
                    
                    <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                        value="Add Customer" action="#{customer.create}"/>
                    <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                        value="Clear" type="reset"/>
                </h:panelGrid>                                                 
            </h:form>
        </f:view>        
    </body>
</html>
