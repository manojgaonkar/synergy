package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customerList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

public int slno = 0; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_scope_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var_sql_dataSource;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_param_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items_begin;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_set_var_value_scope_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var_sql_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_param_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items_begin = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_set_var_value_scope_nobody.release();
    _jspx_tagPool_sql_query_var_sql_dataSource.release();
    _jspx_tagPool_sql_param_value_nobody.release();
    _jspx_tagPool_c_forEach_var_items_begin.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write(" \n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquqry/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\t<script>\n");
      out.write("\t\tsendSmsMessage(smsMessage,mobileNo){\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$.ajax('http://msg.icloudsms.com/rest/services/sendSMS/sendGroupSms?AUTH_KEY=1ffe13602151b7f33bb0796456766f&message=smsMessage&senderId=KMFMKT&routeId=1&mobilesNos=mobileNo&smsContentType=english', {\n");
      out.write("\t\t\t    type: 'GET',  // http method    \t\t\t    \n");
      out.write("    \t\t\t    success: function (data, status, xhr) {\n");
      out.write("       \t\t\t    \talert(data);\n");
      out.write("    \t\t\t    },\n");
      out.write("\t\t\t    error: function (jqXhr, textStatus, errorMessage) {\n");
      out.write("            \t\t\talert('Error' + errorMessage);\n");
      out.write("    \t\t\t    }\n");
      out.write("\t\t\t});\n");
      out.write("\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"background:#820041\">        \n");
      out.write("    ");
      mktg.backingBean.Indent_1 indt = null;
      synchronized (session) {
        indt = (mktg.backingBean.Indent_1) _jspx_page_context.getAttribute("indt", PageContext.SESSION_SCOPE);
        if (indt == null){
          indt = new mktg.backingBean.Indent_1();
          _jspx_page_context.setAttribute("indt", indt, PageContext.SESSION_SCOPE);
        }
      }
      out.write("        \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("indt"), "moreve", request.getParameter("moreve"), request, "moreve", false);
      out.write("    \n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("indt"), "idate", request.getParameter("idate"), request, "idate", false);
      out.write("    \n");
      out.write("    ");
    
	String message = request.getParameter("message");	
	String mobileNo = request.getParameter("mobileNo");
	
	<script>
		sendSmsMessage('<%= message>','<%= mobileNo>');
	</script>
        if(request.getParameter("moreve") != null){
            session.setAttribute("moreve",request.getParameter("moreve"));
        }                
        if(request.getParameter("idate") != null){
            session.setAttribute("idate",request.getParameter("idate"));                    
        }           
     
      out.write("                \n");
      out.write("        ");
      out.write("        \n");
      out.write("        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("        \n");
      out.write("         ");
      if (_jspx_meth_sql_query_0(_jspx_page_context))
        return;
      out.write("   \n");
      out.write("        <center>\n");
      out.write("            <table cellpadding=\"3\" width=\"70%\">    \n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                        <font style=\"font-size:16px;color:#ffffff\">STATE&nbsp;&gt;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${st}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("&nbsp;:Route&nbsp;&gt;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rtname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font>\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <font style=\"font-size:16px;color:#ffffff\">&nbsp;");
      out.print(session.getAttribute("idate"));
      out.write("</font>\n");
      out.write("                    </td>                    \n");
      out.write("                    <td>\n");
      out.write("                        <a style=\"font-size:16px;color:#ffffff\" href=\"indt/statedate.jsp\">Change Route</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("            </table>   \n");
      out.write("            ");
slno=0;
      out.write("\n");
      out.write("            <table cellpadding=\"3\" width=\"70%\">    \n");
      out.write("                <tr style=\"font-size:16px;background-color: #000000;color: #ffffff\">\n");
      out.write("                    <th>SL.NO</th>                            \n");
      out.write("                    <th>Customers</th>\n");
      out.write("                </tr>\n");
      out.write("                ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items_begin.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setBegin(0);
      _jspx_th_c_forEach_0.setVar("book");
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cst.rows}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("    \n");
            out.write("                    ");
slno++;
            out.write("\n");
            out.write("                    <tr style=\"font-size:24px;background-color: #00B0B0;color: #ffffff\">\n");
            out.write("                        <td style=\"width: 2%\" >\n");
            out.write("                            ");
            out.print(slno);
            out.write("\n");
            out.write("                        </td>\n");
            out.write("                        <td style=\"text-align: left;width: 30%\">                                                                                                   \n");
            out.write("                         ");
            out.write("                      \n");
            out.write("                        ");
            out.write("                                                                        \n");
            out.write("<a style=\"color:#ffffff\" accesskey=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.firstname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\" href=\"indt/indent_1.jsp?blnSave=false&blnCstIndt=true&idate=");
            out.print(session.getAttribute("idate"));
            out.write("&billno=0&reclock=false&mdt=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.ratetype}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&moreve=");
            out.print(session.getAttribute("moreve"));
            out.write("&rtname=");
            out.print(session.getAttribute("rtname"));
            out.write("&subsidy=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.subsidy}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&custtype=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.custtype}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&cacr=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.cacr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&cc=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.cacr}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&custid=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&talid=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.taluka}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&routeid=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.route}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("&blnValue=true&blnCustList=false&firstname=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.firstname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.firstname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</a>                                                 \n");
            out.write("\n");
            out.write("                        </td>     \n");
            out.write("                    </tr>                                   \n");
            out.write("                ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items_begin.reuse(_jspx_th_c_forEach_0);
      }
      out.write("                                                                                  \n");
      out.write("            </table>\n");
      out.write("        </center>    \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.rt != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_set_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("            ");
        if (_jspx_meth_c_set_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_set_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_set_0.setScope("session");
    _jspx_th_c_set_0.setVar("st");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.state}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }

  private boolean _jspx_meth_c_set_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_scope_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_1.setPageContext(_jspx_page_context);
    _jspx_th_c_set_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_set_1.setScope("session");
    _jspx_th_c_set_1.setVar("rt");
    _jspx_th_c_set_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.rt}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_1 = _jspx_th_c_set_1.doStartTag();
    if (_jspx_th_c_set_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
      return true;
    }
    _jspx_tagPool_c_set_var_value_scope_nobody.reuse(_jspx_th_c_set_1);
    return false;
  }

  private boolean _jspx_meth_sql_query_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var_sql_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_0.setParent(null);
    _jspx_th_sql_query_0.setSql("SELECT customer.* \n            FROM customer\n            WHERE customer.custtype != 2 \n            and customer.custtype != 3 \n            and route = (SELECT ROUTE.ID FROM ROUTE WHERE ROUTE.id = ? ) \n            ORDER BY customer.firstname ");
    _jspx_th_sql_query_0.setVar("cst");
    _jspx_th_sql_query_0.setDataSource(new String("jdbc/kmfmktgNew"));
    int[] _jspx_push_body_count_sql_query_0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_0 = _jspx_th_sql_query_0.doStartTag();
      if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_0[0]++;
          _jspx_th_sql_query_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_0.doInitBody();
        }
        do {
          out.write("        \n");
          out.write("            ");
          if (_jspx_meth_sql_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sql_query_0, _jspx_page_context, _jspx_push_body_count_sql_query_0))
            return true;
          out.write("                       \n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_sql_query_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_0[0]--;
      }
      if (_jspx_th_sql_query_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_0.doFinally();
      _jspx_tagPool_sql_query_var_sql_dataSource.reuse(_jspx_th_sql_query_0);
    }
    return false;
  }

  private boolean _jspx_meth_sql_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_query_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_query_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:param
    org.apache.taglibs.standard.tag.rt.sql.ParamTag _jspx_th_sql_param_0 = (org.apache.taglibs.standard.tag.rt.sql.ParamTag) _jspx_tagPool_sql_param_value_nobody.get(org.apache.taglibs.standard.tag.rt.sql.ParamTag.class);
    _jspx_th_sql_param_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_query_0);
    _jspx_th_sql_param_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${rt}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_sql_param_0 = _jspx_th_sql_param_0.doStartTag();
    if (_jspx_th_sql_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_sql_param_value_nobody.reuse(_jspx_th_sql_param_0);
      return true;
    }
    _jspx_tagPool_sql_param_value_nobody.reuse(_jspx_th_sql_param_0);
    return false;
  }
}
