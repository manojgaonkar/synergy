<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select Route</title>                
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">         
    </head>
    <body>        
    <f:view>
        <h:form>
            <h:message for="date" style="color: #BE7C7C" />
            <table width="50%" cellpadding="7%">
                <tr>
                    <td style="background-color: #00CCCC;text-align: right;width: 3%">
                        <h:outputText value="State : " />                                        

                    </td>
                    <td style="background-color: #00CCCC;text-align: left;width: 3%">
                        <h:selectOneMenu>
                            <f:selectItems value="#{stateItems.statelist}"></f:selectItems>
                        </h:selectOneMenu>                                                                                        
                    </td>
                </tr>
                <tr>
                    <td style="background-color: #00CCCC;text-align: right;width: 3%">
                        <h:outputText value="Milk Sales Route : " />                                        
                    </td>
                    <td style="background-color: #00CCCC;text-align: left;width: 3%">
                        <h:selectOneMenu valueChangeListener="#{route.processValueChange}">
                            <f:selectItems value="#{route.route}"></f:selectItems>
                        </h:selectOneMenu>                         
                    </td>
                </tr>
         <%--       <tr>
                    <td style="background-color: #00CCCC;text-align: right;width: 3%">
                        <h:outputText value=" INDENT DATE : " />                                        
                    </td>
                    <td style="background-color: #00CCCC;text-align: left;width: 3%">
                        <h:inputText value="#{route.date}" required="true" 
                            requiredMessage="Indent Date is must...!!! " size="10" id="date">                                    
                            <f:convertDateTime pattern="dd.MM.yyyy" dateStyle="short" />
                        </h:inputText>                         
                    </td>                       
                </tr> --%> 
                <tr style="background-color: #BE7C7C; ">
                    <td></td>
                    <td>
                        <h:commandButton value="submit" action="#{route.submitIndent}" 
                            type="submit" />                        
                    </td>                        
                </tr> 
            </table>
        </h:form>
    </f:view>        
    </body>
</html>
