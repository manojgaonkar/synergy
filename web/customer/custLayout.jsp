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
        <title>JSP Page</title>
    </head>
    <body>
    <h3>Product Order List</h3>    
    <f:view>        
        <h:form>
            <em><h:outputText value="#{stateItems.lblState}"/></em>
            <em><h:messages errorStyle="color: red" infoStyle="color: green;font-size:21px"/></em>
            <table width="10%" cellpadding="7%">                
                <tr style="background-color: #000000;color: #ffffff">
                    <th><h:outputText value="Customer Layout List"/>
                </tr>  
                <tr>
                    <td>
                        <h:panelGrid  border="1" 
                              columns="2" headerClass="list-header" 
                              rowClasses="list-row-even, list-row-odd"
                              columnClasses="list-column-right,list-column-left,list-column-center" 
                              styleClass="list-background"
                              title="Customer Basic Information"> 
                            <h:selectOneListbox immediate="true" valueChangeListener="#{layout.processValueChangeEvent1}">
                                <f:selectItems value="#{layout.actProductList}"/>
                            </h:selectOneListbox>                
                            <table>
                                <tr>
                                    <td><h:commandButton actionListener="#{layout.UpArrowActionEvent}" image="/graphics/upButton.gif"></h:commandButton></td>
                                </tr>
                                <tr>
                                    <td><h:commandButton actionListener="#{layout.DownArrowActionEvent}" image="/graphics/upButton.gif"></h:commandButton></td>
                                </tr>                                        
                            </table>
                        </h:panelGrid>                                    
                    </td>
                </tr>                
            </table>
        </h:form>        
    </f:view>    
    </body>
</html>
