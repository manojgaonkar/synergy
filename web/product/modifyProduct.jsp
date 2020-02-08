<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>


<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">
        <link rel="stylesheet" type="text/css" href="../css/default.css">
        <link rel="stylesheet" type="text/css" href="../css/ipg.css">
        <link rel="stylesheet" type="text/css" href="../css/j5eetutorial.css">         
    </head>
    <body style="background:#820041">
        <f:view>
            <h:form>
                <em><h:messages errorStyle="color: red" 
                                infoStyle="color: green;font-size:21px"  /></em>  <center>                    
                    <table cellpadding="3px"  border="1" class="list-background" >                     
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText style="color: #FFFF00;font-size:21px;" 
                                              value="Update product details."/>
                            </td><td></td><td></td>
                        </tr>                                        
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value="State " />                                        
                            </td>
                            <td class="list-column-left">
                                <h:selectOneMenu 
                                    valueChangeListener="#{product.processValueChangeListener}">
                                    <f:selectItems value="#{stateItems.statelist}"/>
                                </h:selectOneMenu>                                                                               
                            </td>
                            <td>
                               <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                                value="get products" 
                                type="submit"/>     
                            </td>
                        </tr>                                                
                       <tr class="list-row-even">
                            <td class="list-column-right">
                                <h:outputText value="Select product "/>  
                            </td>
                            <td class="list-column-left">
                                <h:selectOneMenu value="#{product.product.id}">
                                    <f:selectItems value="#{product.productListState}"/>
                                </h:selectOneMenu>  
                                &nbsp;&nbsp;<h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF"                                 
                                 action="#{product.getRateActionEvent}"
                                   rendered="#{product.blnOk}"
                                  value="OK" />
                            </td>
                            <td></td>
                        </tr>                          
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value=""/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="true" id="product" dir="LTR" value="#{product.product.product}" />                                
                            </td>
                            <td></td>
                        </tr>                                                                                                                                    
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value="MRP.Rate "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" 
                                             dir="RTL" value="#{product.product.rate}" 
                                             size="8" id="rate">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="#####.##" />
                                </h:inputText>
                            </td>
                            <td></td>
                        </tr>                        
                        <tr class="list-row-even">
                            <td class="list-column-right"> 
                                <h:outputText value="Commission "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" 
                                             dir="RTL" value="#{product.product.commission}" 
                                             size="8" id="comm">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>                                        
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value="TCD "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText dir="RTL" value="#{product.product.tcd}" 
                                             readonly="#{!product.blnUpdateBtn}" 
                                             size="8" id="tcd">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>                                                                                    
                        <tr class="list-row-even">
                            <td class="list-column-right"> 
                                <h:outputText value="TAX(%) "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" 
                                             dir="RTL" value="#{product.product.tax}" 
                                             size="8" id="tax">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>                                        
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value="CST(%) "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText dir="RTL" value="#{product.product.cst}" 
                                             readonly="#{!product.blnUpdateBtn}" 
                                             size="8" id="cst">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>                                                            
                        <tr class="list-row-even">
                            <td class="list-column-right">
                                <h:outputText value="CESS(%) "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" dir="RTL" 
                                             value="#{product.product.cess}" 
                                             size="8" id="cess">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>   
                        
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value="UTP Rate "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" dir="RTL" 
                                             value="#{product.product.utprate}" 
                                             size="8" id="utp">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>  
                        <tr class="list-row-even">
                            <td class="list-column-right">
                                <h:outputText value="Subsidy Rate "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" dir="RTL" 
                                             value="#{product.product.subsidy}" 
                                             size="8" id="subsidy">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>                          
                        <tr class="list-row-odd">
                            <td class="list-column-right">
                                <h:outputText value="Spl. Rate "/>  
                            </td>
                            <td class="list-column-left">
                                <h:inputText readonly="#{!product.blnUpdateBtn}" dir="RTL" 
                                             value="#{product.product.splrate}" 
                                             size="8" id="splrate">
                                    <f:convertNumber minFractionDigits="2" maxFractionDigits="2"
                                                     pattern="##.##" />
                                </h:inputText>                                
                            </td>
                            <td></td>
                        </tr>                          
                        <tr class="list-row-even">
                            <td></td>
                            <td><h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                                 action="#{product.processUpdateRateEvent}" 
                                 rendered="#{product.blnUpdateBtn}" 
                                 value="Update product" type="submit"/></td>
                            <td></td>
                        </tr>                                        
                </table></center>
            </h:form>
        </f:view>        
    </body>
</html>
