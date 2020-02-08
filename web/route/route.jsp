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
        <title>Route Master</title>
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">
    </head>
    
    <body>
        
    <f:view>
        <h:messages errorStyle="color: red" infoStyle="color: green;font-size:21px" layout="table"/>                              
        <h:form>
            <h:panelGrid border="1" 
                 columns="2" headerClass="list-header" 
                 rowClasses="list-row-even, list-row-odd"
                 columnClasses="list-column-right,list-column-left,list-column-center" 
                 styleClass="list-background"
                 title="Customer Basic Information" >

                 <h:outputText value="STATE : " />                

                 <h:selectOneMenu value="#{addroute.r.stateid}">
                    <f:selectItems value="#{stateItems.statelist}"></f:selectItems>
                 </h:selectOneMenu>                    

                 <h:outputText value="ROUTE NAME : " />                
                 <h:inputText maxlength="45" size="40" value="#{addroute.r.route}" />

                 <h:outputText value="Sales Type : " />                
                 <h:selectOneMenu value="#{addroute.r.saletype}">
                     <f:selectItem itemValue="1" itemLabel="Route (Direct)"/>
                     <f:selectItem itemValue="2" itemLabel="Sales"/>
                 </h:selectOneMenu>

                 <h:outputText value="Timing : " />                
                 <h:selectOneMenu value="#{addroute.r.timing}">
                     <f:selectItem itemValue="1" itemLabel="Morning"/>
                     <f:selectItem itemValue="2" itemLabel="Evening"/>
                 </h:selectOneMenu>                     
            </h:panelGrid>
            <center><h:commandButton actionListener="#{addroute.processActionListener}" 
                style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                type="Submit" value="Add Route"/></center>
        </h:form>
    </f:view>
    </body>
</html>
