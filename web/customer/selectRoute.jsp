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
            <center>
            <table>
                <tr>
                    <td>
                        <h:outputText value="Milk Sales Route " />                                        
                        <h:selectOneMenu valueChangeListener="#{route.processValueChange}">
                            <f:selectItems value="#{route.route}"></f:selectItems>
                        </h:selectOneMenu> 
                    </td>
                    <td>
                        <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                            value="submit" action="#{route.submitValue}" 
                            type="submit" />                        
                    </td>
                </tr>
            </table>
        </h:form>
    </f:view>        
    </body>
</html>
