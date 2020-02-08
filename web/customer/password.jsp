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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background:#B3B366">
    <f:view>    
        <h:messages errorStyle="color: red" infoStyle="color: green;font-size:21px" layout="table"/>                              
        <h:form><center>
            <table>
                <tr>
                    <td>
                        <h:outputText style="color:#F9F900" 
                        value="Enter Magicword : " />
                    </td>
                    <td>
                        <h:inputSecret immediate="true" style="background:#FFB997" 
                            id="pw" maxlength="10" required="true"
                            value="#{password.passwd}" 
                            requiredMessage="Enter Magicword...!!!">                        
                        </h:inputSecret>
                    </td>                
                </tr>
                <tr style="text-align:center">
                    <td></td>
                    <td>
                        <h:commandButton action="#{password.chkCustomerPasswd}" 
                            style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                            value="Submit" />
                    </td>
                </tr>
            </table>                
        </h:form>        
    </f:view>    
    </body>
</html>
