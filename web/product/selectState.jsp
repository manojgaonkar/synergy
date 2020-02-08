<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Select State</title>
    </head>
    <body>
        
        <f:view>
            <h:form>
                <h:outputText value="Select State"/>
                <h:selectOneMenu valueChangeListener="#{stateItems.processValueChangeListener}">
                    <f:selectItems value="#{stateItems.statelist}"></f:selectItems>
                </h:selectOneMenu>   
                <h:commandButton value="OK" action="ProdLayout"/>
            </h:form>
        </f:view>
  
    </body>
</html>
