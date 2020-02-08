<%-- 
    Document   : newUser
    Created on : Jul 22, 2009, 11:40:03 AM
    Author     : jairam
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>   

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body style="background:#B3B366"> 
        <f:view>            
            <h:form>
                <table width="100%">
                    <tr>
                        <td style="font-size:16px;text-align:right">
                            Fields marked with (*) are mandatory...!!!
                        </td>
                    </tr>
                </table><center>  
                <h:messages errorStyle="color: resd" 
                    infoStyle="color: green;font-size:21px" layout="table"/>                                                              
                <h:panelGrid style="color: #000000;text-align: left;font-size:20px" 
                    cellpadding="10" columns="3">  

                    <h:outputText value=" * User Name " />
                    <h:inputText id="un" 
                                 immediate="true"
                                 required="true" 
                                 requiredMessage="User name is required..." 
                                 maxlength="50" 
                                 value="#{newuser.name}" 
                                 size="35" />
                                 <h:message for="un" errorStyle="color: white;font-size:21px" style="color: white;font-size:21px"/>             
                    
                    <h:outputText value=" * Password " />
                    <h:inputSecret id="pwd" 
                                   required="true" 
                                   requiredMessage="Password must be entered..."
                                   maxlength="50"  
                                   value="#{newuser.pwd}" 
                                   size="35"/>
                    <h:message for="pwd" errorStyle="color: white;font-size:21px" style="color: white;font-size:21px"/> 
                    
                    <h:outputText value=" * Re-Enter Password "/>
                    <h:inputSecret id="repwd"
                                   value="#{newuser.repwd}"
                                   required="true"  
                                   requiredMessage="Re-Enter Password..." 
                                   size="35"/>  
                                   <h:message for="repwd" errorStyle="color: white;font-size:21px" style="color: white;font-size:21px"/> 
                    
                    
                    <h:outputText value="Enter Keyword " />
                    <h:inputSecret id="kw" 
                                   value="#{newuser.keyword}"
                                   required="true"  
                                   requiredMessage="Key-Word Is Must...." 
                                   size="20"/>                                          
                                   <h:message for="kw" errorStyle="color: white;font-size:21px" style="color: white;font-size:21px"/>                     
                </h:panelGrid><br>
                <table>
                    <tr style="text-align:left">
                        <td>
                            <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                            type="submit"
                            actionListener="#{newuser.processaddUser}" 
                            value="Submit"/>
                        </td>
                        <td>
                            <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                            type="reset"                             
                            value="Reset"/>                            
                        </td>                        
                    </tr>
                </table>
            </h:form>
        </f:view>
        <a href="index.jsp">Back</a> 
    </body>
</html>
