<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>   

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <title>Login form</title>        
    </head>
    <body bgcolor="#CE6700" onLoad="javascript: document.forms[0].j_username.focus(); return true;">        
        <f:view>
            <h:messages layout="table" errorStyle="color: white;font-size:21px" 
                infoStyle="color: white;font-size:21px"/>
            <f:loadBundle var="bundle" basename="mktg.packageMessages.splPackageMessages"/>    
                <table width="100%">
                    <tr>
                        <td style="font-size:16px;text-align:right" >
                        <a href="newUser.faces" >Create user</a></td>
                    </tr>
                </table>
            <br><br><br><br><br><br><br><br>             
            <h:form><center>                                  
                <table>
                   <h:panelGrid cellpadding="5" columns="2">                     
                       <h:outputText style="font-size:21" value="User Name"></h:outputText>
                        <h:inputText id="userName" 
                                        immediate="true"
                                        size="25"  
                                        required="true" 
                                        requiredMessage="Username is mandatory...!!!"                             
                                        value="#{welcomeBean.userName}" /> 
                            
                        <h:outputText style="font-size:21" value="Password "/>
                        <h:inputSecret required="true"                                        
                                       value="#{welcomeBean.userPwd}" 
                                       requiredMessage="password can not be blank..." 
                                       id="userPassword"  
                                       size="25" />                        
                    </h:panelGrid>  
                    <h:commandButton id="submit" image="/graphics/signup_but.gif"
                            action="#{welcomeBean.authenticateUser}" 
                            actionListener="#{welcomeBean.processActionEvent}"  
                            type="submit">                 
                        </h:commandButton>                                         
                </table>
            </h:form>            
        </f:view></center>        
    </body>
</html>