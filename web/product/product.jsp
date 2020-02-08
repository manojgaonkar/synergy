<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>

<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Master</title>
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">
        <link rel="stylesheet" type="text/css" href="../css/default.css">
        <link rel="stylesheet" type="text/css" href="../css/ipg.css">
        <link rel="stylesheet" type="text/css" href="../css/j5eetutorial.css">                 
    </head>
    <body>
        <f:view>
            <h:form>
                <em><h:messages errorStyle="color: red" 
                                infoStyle="color: green;font-size:21px"  /></em>  <center>                    
                    <table width="50%" cellpadding="5px"  border="1" class="list-background" >
                        <tr>
                            <td>
                                <h:outputText style="color: #000000;font-size:21px;" 
                                              value="Create new product."/>
                            </td><td></td>
                        </tr>                    
                        <tr>
                            <td class="list-column-right">
                                <h:outputText value="Product Name "/>
                            </td>                                                    
                            <td class="list-column-left">
                                <h:inputText id="product" 
                                    size="40" maxlength="45" 
                                     value="#{product.product.product}" />
                            </td>
                        </tr>  
                       <tr>
                            <td class="list-column-right">
                                <h:outputText value="Product Type "/>
                            </td>                                                    
                            <td class="list-column-left">
                                <h:selectOneMenu value="#{product.product.prodtype}">
                                    <f:selectItems value="#{prodtype.productTypeList}"/>
                                </h:selectOneMenu>                                                                                 
                            </td>
                        </tr>                            
                </table>
                <h:commandButton style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                    action="#{product.create}" value="Add Product" type="submit"/></center>                                                                    
            </h:form>
        </f:view>        
    </body>
</html>
