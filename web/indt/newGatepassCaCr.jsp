<%-- 
    Document   : newGatepassCaCr
    Created on : Dec 5, 2009, 12:07:36 PM
    Author     : Vijay
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>New Gatepass</title>
    </head>
    <body>
        <h4>SALES</h4>
        <form method="get" action="newGatePass.faces">
            <center><table>
                <tr class="list-row-odd">
                    <td style="text-align: right;">    
                        Cash/Credit
                    </td>
                    <td style="text-align: left;">
                        <select name="cacr">                            
                            <option value="Cash">Cash</option>                            
                            <option value="Credit">Credit</option> 
                            <option value="Walkin">Walk-in</option> 
                        </select>
                    </td>
                </tr>
            </table>
            <input name="blnNE" type="hidden" value="true">
            <input name="blnShow" type="hidden" value="false">
            <input name="blnCstIndt" type="hidden" value="false">
            <input name="blnCstData" type="hidden" value="false">     
            <p>
            <input style="cursor:pointer;background:#594FBF;color:#FBE249;font-weight:bold;padding:1px 5px;margin-right:2px;border:1px solid #594FBF" 
                type="submit" value="Submit"> </p>
        </form>
    </body>
</html>
