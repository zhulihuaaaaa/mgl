package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("<!--输当前所在的项目名称  -->\r\n");
      out.write("<!--jquery  -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"");
      out.print(request.getContextPath());
      out.write("/plugin/jquery/jqueryv2.1.4.js\">\r\n");
      out.write("</script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tvar uias,crm,uiasUrlCookie;\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\ttype : \"post\",\r\n");
      out.write("\t\turl : \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/init/initUrl\",\r\n");
      out.write("\t\tasync : false,\r\n");
      out.write("\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\tuias = data.UIAS;\r\n");
      out.write("\t\t\tcrm = data.CRM;\r\n");
      out.write("\t\t\tuiasUrlCookie= data.UIAS_URL_COOKIE;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("\tif (uiasUrlCookie != \"\" && uiasUrlCookie !=null) {\r\n");
      out.write("\t\tvar uiasUrlCookies = uiasUrlCookie.split(',');\r\n");
      out.write("        getCookiePage(uiasUrlCookies);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction getCookiePage(urlJson) {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\tasync : false,\r\n");
      out.write("\t\t\turl : urlJson[0] +\"/auth/getCookie\",\r\n");
      out.write("\t\t\tdataType : \"jsonp\",\r\n");
      out.write("\t\t\tjsonp : \"callback\",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)\r\n");
      out.write("\t\t\tjsonpCallback : \"callbackparam\",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名\r\n");
      out.write("\t\t\tsuccess : function(json) {\r\n");
      out.write("\t\t\t\tdocument.cookie = \"loginName=\" + json.loginName;\r\n");
      out.write("\t\t\t\tdocument.cookie = \"systemCode=\"+ json.systemCode;\r\n");
      out.write("\t\t\t\tdocument.cookie = \"cuu=\"+ encodeURIComponent(urlJson[0]);\r\n");
      out.write("\t\t\t\twindow.location = crm+\"/main\";\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(error) {\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\ttype : \"get\",\r\n");
      out.write("\t\t\t\t\tasync : false,\r\n");
      out.write("\t\t\t\t\turl : urlJson[1] +\"/auth/getCookie\",\r\n");
      out.write("\t\t\t\t\tdataType : \"jsonp\",\r\n");
      out.write("\t\t\t\t\tjsonp : \"callback\",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(默认为:callback)\r\n");
      out.write("\t\t\t\t\tjsonpCallback : \"callbackparam\",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名\r\n");
      out.write("\t\t\t\t\tsuccess : function(json) {\r\n");
      out.write("\t\t\t\t\t\tdocument.cookie = \"loginName=\" + json.loginName;\r\n");
      out.write("\t\t\t\t\t\tdocument.cookie = \"systemCode=\"+ json.systemCode;\r\n");
      out.write("\t\t\t\t\t\tdocument.cookie = \"cuu=\"+ encodeURIComponent(urlJson[1]);\r\n");
      out.write("\t\t\t\t\t\twindow.location = crm+\"/main\";\r\n");
      out.write("\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\terror : function(error) {\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /WEB-INF/index.jsp(6,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/index.jsp(6,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/index.jsp(6,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }
}
