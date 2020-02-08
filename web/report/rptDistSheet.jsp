<%-- 
    Document   : rptDistSheet
    Created on : Mar 10, 2010, 11:35:11 AM
    Author     : xp
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">                     
        <title>Distribution Sheet Report</title>
    </head>
    <body>
        <h2><I>Distribution Sheet!</I></h2>
        <f:view>
            <h:form>  <center>
                <table cellspacing="5" cellpadding="5">
                    <tr>
                        <td style="text-align: right;" >
                            <h:outputText value="SELECT ROUTE"/>
                        </td>
                        <td align="text-align: left;">
                            <h:selectOneMenu valueChangeListener="#{rptDistBean.processValueChangeListener}" 
                                onchange="this.form.submit()" value="#{rptDistBean.routeId}">
                                <f:selectItems value="#{route.route}"/>                            
                            </h:selectOneMenu>
                        </td>
                    </tr>
                    <tr>
                        <td align="text-align: right;">
                            <h:outputText value="Contarctor/Salesman"/>
                        </td>
                        <td align="text-align: left;">
                            <h:selectOneMenu rendered="#{rptDistBean.blnRenderer}" value="#{rptDistBean.customer}">
                                <f:selectItems value="#{rptDistBean.customerList}"/>
                            </h:selectOneMenu> 
                        </td>
                    </tr>
                    <tr>
                        <td align="text-align: right;">
                            <h:outputText value="DIST.SHEET DATE"/>
                        </td>
                        <td align="text-align: left;">
                            <h:inputText readonly="true" value="#{rptDistBean.date}" id="date" size="10">
                                <f:convertDateTime pattern="dd.MM.yyyy" dateStyle="short"/>
                            </h:inputText>                                 
                        </td>
                    </tr>
                </table>
                <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                type="submit" actionListener="#{rptDistBean.dispReport}" 
                value="Submit"/>                
            </h:form>
        </f:view>
    </body>
</html>
