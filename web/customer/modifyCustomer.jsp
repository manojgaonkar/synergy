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
    <body style="background:#820041">
        <font style="font-size:20px;color:#ffffff"><em>Modify Customer details </em></font>
        <f:view>
            <h:form>
                <h:messages errorStyle="color: resd" 
                    infoStyle="color: green;font-size:21px" layout="table"/>                                              
                <table>
                    <tr style="background-color: #FF9DCE;color: #ffffff;font-size:17px;">
                        <td style="width: 15%" >
                            <h:outputText value="Select Customer " />                                        
                        </td>
                        <td>                                                                                    
                            <h:selectOneMenu valueChangeListener="#{customerUpdate.processValueChangeEvent}">
                                <f:selectItems value="#{customerUpdate.customerlist}"/>
                            </h:selectOneMenu>                             
                            
                        </td>
                        <td style="width: 25%">
                            <h:outputText value="#{customerUpdate.routeName}" /> 
                        </td>
                        <td style="width: 15%;">
                            <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                                type="submit" 
                                action="#{customerUpdate.processActionEvent}"
                                value="get Details" /> 
                        </td>
                    </tr>                        
                </table>     
                <c:if test="${customerUpdate.blnRender}" >
                   <h:panelGrid  border="1" 
                        columns="2" headerClass="list-header" 
                        rowClasses="list-row-even, list-row-odd"
                        columnClasses="list-column-right,list-column-left,list-column-center" 
                        styleClass="list-background"
                        title="Update Customer Basic Information" >

                        <h:outputText style="color: red" value="Title / Name " />
                        <h:inputText readonly="true"  required="false" requiredMessage="Customer name is mandatory....!!!!"
                            id="firstname" maxlength="50" size="50" 
                            value="#{customerUpdate.found.firstname}" />  

                        <h:outputText value="Commence Date (dd.mm.yyyy) " />                    
                        <h:inputText immediate="true" required="false" requiredMessage="Commence Date is must...!!! "
                            value="#{customerUpdate.found.comdate}" id="comdate" size="10" maxlength="10" >
                            <f:convertDateTime pattern="dd.MM.yyyy" dateStyle="short"/>
                        </h:inputText>

                        <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                            value="Customer Type " />                    
                        <h:outputText value="  " />   
                                                
                        <h:outputText value="Type " />                                        
                        <h:selectOneMenu value="#{customerUpdate.found.custtype}">
                            <f:selectItems value="#{cstType.customerType}"></f:selectItems>
                        </h:selectOneMenu>
                        
                        <h:outputText value="Rate Type " />                                        
                        <h:selectOneMenu value="#{customerUpdate.found.ratetype}">
                            <f:selectItem itemLabel="Dealer Price" itemValue="1"/>
                            <f:selectItem itemLabel="MRP" itemValue="2"/>
                            <f:selectItem itemLabel="TCD" itemValue="3"/>
                            <f:selectItem itemLabel="UTP" itemValue="4"/>
                            <f:selectItem itemLabel="Subsidy" itemValue="5"/>
                            <f:selectItem itemLabel="Spl.Rate" itemValue="6"/>
                        </h:selectOneMenu>                                             
                        
                        <h:outputText value="Cash/Credit " />                                                                
                        <h:selectOneMenu value="#{customerUpdate.found.cacr}">
                            <f:selectItem itemLabel="cash" itemValue="Cash"/>
                            <f:selectItem itemLabel="credit" itemValue="Credit"/>
                        </h:selectOneMenu>                                                           

                        <h:outputText value="Subsidy " />                                                                                        
                        <h:inputText dir="RTL" id="subsidy" maxlength="10" size="10" 
                            value="#{customerUpdate.found.subsidy}"/>
                        
                        <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                            value="Postal Address " />
                        <h:outputText value="  " />                   

                        <h:outputText value="Address(1) " />
                        <h:inputText id="add1" maxlength="50" size="50" 
                            value="#{customerUpdate.found.add1}" />                    

                        <h:outputText value="Address(2) " />
                        <h:inputText id="add2" maxlength="50" size="50" 
                            value="#{customerUpdate.found.add2}" />                                            

                        <h:outputText value="Address(3) " />
                        <h:inputText id="add3" maxlength="50" size="50" 
                            value="#{customerUpdate.found.add3}" />                                                                                            

                        <h:outputText value="Address(4) " />
                        <h:inputText id="add4" maxlength="50" size="50" 
                            value="#{customerUpdate.found.add4}" />                                                                                            

                        <h:outputText value="Address(5) " />
                        <h:inputText id="add5" maxlength="50" size="50" 
                            value="#{customerUpdate.found.add5}" />                                                                                                                    


                        <h:outputText value="State " />                                        
                            <h:selectOneMenu value="#{customerUpdate.found.stateid}">
                            <f:selectItems value="#{stateItems.statelist}"></f:selectItems>
                        </h:selectOneMenu>                          
                        
                        <h:outputText value="Taluka " />                                        
                        <h:selectOneMenu value="#{customerUpdate.found.taluka}">
                            <f:selectItems value="#{talukaItems.talukalist}"></f:selectItems>
                        </h:selectOneMenu>

                        <h:outputText value="Milk Sales Route " />                                        
                        <h:selectOneMenu value="#{customerUpdate.found.route}">
                            <f:selectItems value="#{route.route}"></f:selectItems>
                        </h:selectOneMenu>                                      
                        
                        <h:outputText style="color:#804040;text-align: left;font-weight: 
                            bold;font-size: 14px" 
                            value="Contact No " />                    
                        <h:outputText value="  " />                                        

                        <h:outputText value="Home/Parlour " />
                        <h:inputText id="phone" maxlength="15" size="15" 
                            value="#{customerUpdate.found.phone}" />                                                                                            

                        <h:outputText value="Mobile No " />                                        
                        <h:inputText id="mobile" maxlength="15" size="15" 
                            value="#{customerUpdate.found.mobile}" />                                                                                            

                        <h:outputText value="Pan No " />                                        
                        <h:inputText id="panno" maxlength="14" size="14" 
                            value="#{customerUpdate.found.panNo}" />                             
                            
                        <h:outputText style="color:#804040;text-align: left;font-weight: 
                            bold;font-size: 14px" 
                            value="Bank " />                                        
                        <h:selectOneMenu value="#{customerUpdate.found.bank}">
                            <f:selectItems value="#{bank.banklist}"></f:selectItems>
                        </h:selectOneMenu>                                           
                        
                        <h:outputText value="Bank A/c No " />                                        
                        <h:inputText id="acno" maxlength="15" size="15" 
                            value="#{customerUpdate.found.acNo}" />       
                            
                        <h:outputText style="color:#804040;text-align: left;font-weight: bold;font-size: 14px" 
                            value="Payment Details " />
                        <h:outputText value="  " />                                            

                        <h:outputText value="Deposit Amount " />                                        
                        <h:inputText dir="RTL" id="deposit" maxlength="10" size="10" 
                            value="#{customerUpdate.found.deposit}" />                             

                        <h:outputText value="Deposit Date (dd.mm.yyyy) " />                    
                        <h:inputText value="#{customerUpdate.found.depodate}"  
                            id="depodate" size="10" maxlength="10" >
                            <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                        </h:inputText>

                        <h:outputText value="(GR)No " />                    
                        <h:inputText id="GRNO" size="10" value="#{customerUpdate.found.grNo}"/>

                        <h:outputText value="(GR)Date (dd.mm.yyyy) " />                    
                        <h:inputText value="#{customerUpdate.found.grDate}"  
                            id="grdate" size="10" maxlength="10" >
                            <f:convertDateTime  pattern="dd.MM.yyyy" dateStyle="short"/>
                        </h:inputText>                    

                        <h:outputText value="Nominee Information " />                    
                        <h:inputText value="#{customerUpdate.found.nominee}" size="45" id="nominee" />                                                                
                        
                        <h:outputText value="POLICY.NO"/>
                        <h:inputText maxlength="45" size="25" 
                            value="#{customerUpdate.found.policyno}"/>   
                            
                        <h:outputText value="OPENING BAL."/>    
                        <h:inputText style="text-align:right" id="openingbal" value="#{customerUpdate.found.openingbal}" size="10"/>
                        
                        <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                            value="Update Customer" action="#{customerUpdate.createUpdate}"/>                                             
                      </h:panelGrid>                          
                </c:if>                    
                 
                <%--    <h:outputText value="Mid Name : " />
                    <h:inputText id="midname" maxlength="50" size="50" 
                        value="#{customerUpdate.found.midName}" />                                                                    
                    <h:outputText value="Last Name : " />
                    <h:inputText id="lastname" maxlength="50" size="50" 
                        value="#{customerUpdate.found.lastName}" />                                                        
                     --%>
                
            </h:form>
        </f:view>        
    </body>
</html>
