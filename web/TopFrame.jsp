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
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <script type="text/javascript">  
            function hide(){    
                location.replace("");
                alert("You are about to quit the application...!!!");
            }    
        </script>
    </head>
    <body onunload="hide()" bgcolor="#346767"> 
    <f:view>
        <h:form>
            <f:loadBundle var="bundle" basename="mktg.packageMessages.splPackageMessages" />
            <table width="100%" >
                <tr valign="top"><td align="left" valign="top"><font size="1" color="#FFFFFF" face="Arial Narrow, Book Antiqua, Garamond, cursive"><b><u>
                  WelCome : <h:outputText value="#{welcomeBean.userName}"/>                  
                </u></b></font></td>            
                <td align="center" valign="top"><font size="1" face="Comic Sans MS, 
                        Book Antiqua, Georgia,
                        sans-serif" color="#FF2A00">
                        ${bundle.Title}
                    </font></td>
                    <td>
                        <a title="Todays Sales" 
                        style="color: #ffffff;font-size:14px;;text-align: right" 
                        target="mainframe" href="DaySales.faces">Day Sales</a>
                        <h:commandLink style="color:#3E6B8A; font-family:Monaco,'Courier New','Courier';font-size: 11px" 
                           target="mainframe" value="DaySales" action="DaySales" 
                           actionListener="#{daysales.processActionEvent}" >
                       </h:commandLink>                 
                    </td>
                    <td >                         
                        <a title="Logout application" style="color: #ffffff;font-size:14px;;text-align: right" target="_top" href="welcomeJSF.faces">Logout</a>                           <%--<a href="./logoutSer?Username=<%=request.getSession().getAttribute("Username")%>">Logout</a>--%>
                    </td>
                </tr>
             </table>
         </h:form>
    </f:view>     
    </body>
</html>
