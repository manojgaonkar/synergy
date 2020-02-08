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
        <title>Home Page</title>            
        <frameset rows="7%,*" border="0">        
            <frame name="menu" src="TopFrame.faces" marginwidth="10" marginheight="10" scrolling="no" frameborder="2" noresize>    
                <frameset cols="19%,*" border="0">
                <frame name="menu" src="./menu.faces" marginwidth="10" marginheight="10" scrolling="auto" frameborder="2" noresize>
                <frameset cols="98%,*" border="0">
                    <frame name="mainframe" src="abc.html" marginwidth="10" marginheight="10" scrolling="auto" frameborder="2" noresize>        
                    <frame name="rfframe" src="./framerightSide.html" marginwidth="10" marginheight="10" frameborder="0" noresize>
                </frameset>           
            </frameset>
        </frameset>    
        <noframes>
            Sorry, this application requires frame support in your browser.
        </noframes>        
    </head> 
</html>
