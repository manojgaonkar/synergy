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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="../css/styleSheet.css">  
    </head>
    <body bgcolor="#555555">
    <jsp:useBean id="utlBen" scope="page" class="mktg.backingBean.utlBean" />    
    <center><form action="receipt.jsp" method="get">
        <input type="hidden" name="blnCstrcpt" value="true">
        <table width="50%" cellpadding="7%">  
            <tr style="font-size:16px;background-color: #000000;color: #ffffff">
                <th style="text-align: right">D&nbsp;A&nbsp;Y</th>
                <th style="text-align: left">C&nbsp;A&nbsp;S&nbsp;H&nbsp</th>
            </tr>                            
            <tr>
                <td  style="text-align: right;">
                    DATE :
                </td>
                <td style="text-align: left;">
                    <input type="text" size="10" name="idate" > 
                </td>            
            </tr>
            <tr>
                <td  style="text-align: right;">
                    TYPE :
                </td>
                <td style="text-align: left;">
                    <select name="rstype">
                        <option value="1">Routes</option>
                        <option value="2">Sales</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td  style="text-align: right;"></td>
                <td style="text-align: left;">
                    <input style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                        type="submit" value="Submit">
                </td>
            </tr>            
        </table>
        
    </form></center>
    </body>
</html>
