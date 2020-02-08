<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./css/jquery-3.4.1.min.js"></script>
<title>JSP Page</title>
<script>

function sendSmsMessage(smsMessage,mobileNo){
//&& mobileNo.trim().length==10
if(mobileNo != null && smsMessage != null ){
alert(mobileNo);
alert(smsMessage);
$.ajax('http://msg.icloudsms.com/rest/services/sendSMS/sendGroupSms?AUTH_KEY=1ffe13602151b7f33bb0796456766f&message='+smsMessage+'&senderId=KMFMKT&routeId=1&mobileNos='+mobileNo+'&smsContentType=english', {
header: {'Access-Control-Allow-Origin':'*'},
success: function (data, status, xhr) {
alert('Success');
//alert(data) this is how it works.!;
},
error: function (jqXhr, textStatus, errorMessage) {
console.log('---------------');
console.log(jqXhr);
console.log('---------------');
console.log(textStatus);
console.log('---------------');
console.log(errorMessage);
console.log('---------------');
//alert('error');
}
});
} else {
alert('Mobile number not found or invalid.!');
}
}

</script>
</head>
<body style="background:#820041">
<jsp:useBean id="indt" scope="session" class="mktg.backingBean.Indent_1" />
<jsp:setProperty name="indt" property="moreve" param="moreve"/>
<jsp:setProperty name="indt" property="idate" param="idate"/>
<%
String message = request.getParameter("message");
String mobileNo = request.getParameter("mobileNo");

if(request.getParameter("moreve") != null){
session.setAttribute("moreve",request.getParameter("moreve"));
}
if(request.getParameter("idate") != null){
session.setAttribute("idate",request.getParameter("idate"));
}
%>

<script>
//if(mobileNo){
sendSmsMessage('<%=message%>','<%=mobileNo%>');
//}
</script>

<%!public int slno = 0; %>
<c:if test="${param.rt != null}">
<c:set scope="session" var="st" value="${param.state}" />
<c:set scope="session" var="rt" value="${param.rt}" />
</c:if>
<sql:query
sql="SELECT customer.*
FROM customer
WHERE customer.custtype != 2
and customer.custtype != 3
and route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.id = ? )
ORDER BY customer.firstname "
var="cst" dataSource="jdbc/kmfmktgNew" >
<sql:param value="${rt}"/>
</sql:query>
<center>
<table cellpadding="3" width="70%">
<tr>
<td>
<font style="font-size:16px;color:#ffffff">STATE&nbsp;&gt;${st}&nbsp;:Route&nbsp;&gt;${rtname}</font>
</td>
<td>
<font style="font-size:16px;color:#ffffff">&nbsp;<%=session.getAttribute("idate")%></font>
</td>
<td>
<a style="font-size:16px;color:#ffffff" href="indt/statedate.jsp">Change Route</a>
</td>
</tr>
</table>
<%slno=0;%>
<table cellpadding="3" width="70%">
<tr style="font-size:16px;background-color: #000000;color: #ffffff">
<th>SL.NO</th>
<th>Customers</th>
</tr>
<c:forEach begin="0" var="book" items="${cst.rows}" >
<%slno++;%>
<tr style="font-size:24px;background-color: #00B0B0;color: #ffffff">
<td style="width: 2%" >
<%=slno%>
</td>
<td style="text-align: left;width: 30%">
<%-- <a href="indt/indent_1.jsp?billno=0&reclock=false&mdt=<%=mdt%>&moreve=<%=moreve%>&rtname=${rt}&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a> --%>
<%-- <a style="color:#ffffff" accesskey="${book.firstname}" href="indt/indent_1.jsp?blnSave=false&blnCstIndt=true&idate=<%=session.getAttribute("idate")%>&billno=0&reclock=false&mdt=<%=session.getAttribute("mdt")%>&moreve=<%=session.getAttribute("moreve")%>&rtname=${rt}&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a>
Code of this line changed on 27/06/2013 in next line... "rtname" put in place of rt <a style="color:#ffffff" accesskey="${book.firstname}" href="indt/indent_1.jsp?blnSave=false&blnCstIndt=true&idate=<%=session.getAttribute("idate")%>&billno=0&reclock=false&mdt=${book.ratetype}&moreve=<%=session.getAttribute("moreve")%>&rtname=${rt}&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}">${book.firstname}</a> --%>
<a style="color:#ffffff" accesskey="${book.firstname}" href="indt/indent_1.jsp?blnSave=false&blnCstIndt=true&idate=<%=session.getAttribute("idate")%>&billno=0&reclock=false&mdt=${book.ratetype}&moreve=<%=session.getAttribute("moreve")%>&rtname=<%=session.getAttribute("rtname")%>&subsidy=${book.subsidy}&custtype=${book.custtype}&cacr=${book.cacr}&cc=${book.cacr}&custid=${book.id}&talid=${book.taluka}&routeid=${book.route}&blnValue=true&blnCustList=false&firstname=${book.firstname}&mobileNo=${book.mobile}">${book.firstname}</a>

</td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>