
<%-- 
    Document   : indent_2
    Created on : May 31, 2010, 1:14:24 PM
    Author     : xp
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fn"%>

<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Indent Refresh List</title>
        <script type="text/javascript" >
            function loadImage(){   
            }    
            function disableCtrl(){
              document.forms['refIndent'].elements["refIndent:refreshBtn1"].style.display = "none";
              document.forms['refIndent'].elements["refIndent:refreshBtn1"].style.visibilty = "hidden";
              document.loadingImg.width = 25;
              document.loadingImg.height = 25;                            
            }
        </script>
    </head>
    <body>
        <f:view>
            <h:message for="idnentDate" errorStyle="fornt-size:12px;color:red"/>
            <h:messages layout="table" errorStyle="fornt-size:12px;color:red"/>
            <h:form id="refIndent"><center>
                <h3><em>Refresh Indent Sheet.!</em></h3>
                <table cellpadding="2" cellspacing="2" width="90%">
                    <tr style="background-color:white">
                        <td style="text-align:right"><h:outputText value="DATE :"/></td>
                        <td style="text-align:left"> 
                            <h:inputText size="10" maxlength="10" 
                                requiredMessage="Please Enter-Indent Date.!" 
                                required="true" id="idnentDate" value="#{refreshIndent.indentDate}">
                                <f:convertDateTime pattern="dd.MM.yyyy" type="date"/>
                            </h:inputText>                            
                        </td>
                    </tr>
                    <tr style="background-color:yellow">
                        <td style="text-align:right"><h:outputText value="STATE :"/></td>
                        <td style="text-align:left"> 
                            <h:selectOneMenu id="rl" onchange="this.form.submit()" value="#{refreshIndent.stateId}">
                                <f:selectItems value="#{stateItems.statelist}"/>
                            </h:selectOneMenu>                        
                        </td> 
                    </tr>
                    <tr style="background-color:white">
                        <td style="text-align:right"><h:outputText value="Select Route :"/></td>
                        <td style="text-align:left"> 
                            <h:selectOneMenu onchange="this.form.submit()" value="#{refreshIndent.routeId}">
                                <f:selectItems value="#{refreshIndent.route}"/>
                            </h:selectOneMenu>
                        </td>                        
                    </tr>
                </table><br>                
                <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                    rendered="true" onclick="javascript:disableCtrl()" immediate="true" 
                    actionListener="#{refreshIndent.processActionEvent}" id="refreshBtn1" disabled="false" value="Refresh">
                 </h:commandButton>
                </center>                  
                <center><img name="loadingImg" src="../graphics/ajax-loader2.gif" 
                    id="loadingImg" s height="0" width="0" alt="Loading...." ></center>                
            </h:form>
        </f:view>
    </body>
</html>
