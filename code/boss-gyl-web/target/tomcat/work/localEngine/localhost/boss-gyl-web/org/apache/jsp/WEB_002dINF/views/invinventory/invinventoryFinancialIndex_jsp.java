package org.apache.jsp.WEB_002dINF.views.invinventory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class invinventoryFinancialIndex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(7);
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/./include.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/./../include/basePath.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/navgation.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/left_menu.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/footer.jsp");
    _jspx_dependants.add("/WEB-INF/custom_common.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge, chrome=1\">\r\n");
      out.write("<meta name=\"renderer\" content=\"webkit\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\">\r\n");
      out.write("<meta content=\"telephone=no\" name=\"format-detection\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-capable\" content=\"yes\">\r\n");
      out.write("<meta name=\"apple-mobile-web-app-status-bar-style\" content=\"black\">\r\n");
      out.write("<meta name=\"keywords\" content=\"买钢乐,erp,不锈钢,钢铁,电商\">\r\n");
      out.write("<meta name=\"description\" content=\"买钢乐客源系统\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path=request.getContextPath();/* 获取当前的系统路径 */

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("<!--输当前所在的项目名称  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--å¼åç¸å³å¾çå°å  -->\r\n");
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!--æµè¯ç¸å³å¾çå°å  -->\r\n");
      out.write("\r\n");
      out.write("<!--æ­£å¼ç¸å³å¾çå°å  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var showGylImage = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fileUrlBase}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${gylImageUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\";\r\n");
      out.write("</script>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- MglUI core CSS -->\r\n");
      out.write("<link rel=\"icon\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/favicon.png\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/mgl-style.css\" rel=\"stylesheet\" charset=\"utf-8\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/plugin/elementui/index.css\" rel=\"stylesheet\" charset=\"utf-8\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/gyl-style.css\" rel=\"stylesheet\" charset=\"utf-8\">\r\n");
      out.write("\r\n");
      out.write("<!-- HTML5shiv 和 Respond.js IE9支持HTML5 tooltipss和媒体查询 -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"http://cdn.maigangle.com/js/common/html5.js\"></script>\r\n");
      out.write("<![endif]-->");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    // 百度统计\r\n");
      out.write("    var _hmt = _hmt || [];\r\n");
      out.write("    (function() {\r\n");
      out.write("        var hm = document.createElement(\"script\");\r\n");
      out.write("        hm.src = \"https://hm.baidu.com/hm.js?be559848fda14738459ab27a4db1be48\";\r\n");
      out.write("        var s = document.getElementsByTagName(\"script\")[0];\r\n");
      out.write("        s.parentNode.insertBefore(hm, s);\r\n");
      out.write("    })();\r\n");
      out.write("</script>\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<title>金融库存管理</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id='slideEidt'></div>\r\n");
      out.write("\t<section id=\"container\">\r\n");
      out.write("\t\t<!--header start-->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--header start-->\r\n");
      out.write("<header class=\"ui-header ui-header-positive clearfix\">\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("    \tfunction changeUrl(uiasUrl,code){\r\n");
      out.write("    \t\tvar URL = uiasUrl+\"/auth/setCookie\";\r\n");
      out.write("    \t\t//JSON跨域解决getScript动态添加脚本 \r\n");
      out.write("    \t\t$.ajax({\r\n");
      out.write("    \t\t\ttype : \"get\",\r\n");
      out.write("    \t\t\tasync : false,\r\n");
      out.write("    \t\t\turl : URL,\r\n");
      out.write("    \t\t\tdataType : \"jsonp\",\r\n");
      out.write("    \t\t\tjsonp : \"systemCode\",\r\n");
      out.write("    \t\t\tjsonpCallback : code,\r\n");
      out.write("    \t\t\tsuccess : function(json) {\r\n");
      out.write("    \t\t\t\twindow.location = uiasUrl;\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\t\r\n");
      out.write("    \t}\r\n");
      out.write("    </script>\r\n");
      out.write("\t<div class=\"ui-col ui-col-20\">\r\n");
      out.write("\t\t<h2 class=\"logo\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/main\">BOSS管理系统</a>\r\n");
      out.write("\t\t</h2>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"ui-col ui-col-60\">\r\n");
      out.write("\t\t<ul class=\"header-nav-sys\">\r\n");
      out.write("\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"ui-col ui-col-80\">\r\n");
      out.write("\t\t<ul class=\"top-menu pull-right\">\r\n");
      out.write("\t\t\t<li>\r\n");
      out.write("\t\t\t\t<a class=\"menu-down\" href=\"javascript:;\"><i class=\"icon-people\"></i>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${loginName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</a>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\">\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uiasUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/auth/edPwdShow\">修改密码</a>\r\n");
      out.write("\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uiasUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/auth/logout\">退出</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t</div>\r\n");
      out.write("</header>");
      out.write("\r\n");
      out.write("\t\t<!--header end-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!--sidebar start-->\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--sidebar start-->\r\n");
      out.write("<div class=\"ui-sidebar ui-sidebar-positive sidebar-scroll\"\r\n");
      out.write("\tid=\"sidebar-menu\">\r\n");
      out.write("\t<div class=\"sidebar-toggle\">\r\n");
      out.write("\t\t<i class=\"icon-sanshuxian\"></i>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- sidebar menu start-->\r\n");
      out.write("\t<ul class=\"sidebar-menu\">\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/contract/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>合同管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/approveContract/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>待审批合同管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/contractBalance/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>合同对账信息</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/instockBill/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>入库管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/stock/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>库存管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/checkInv/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>库存盘点</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/invoice/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>发票管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/stockFinancial/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>金融库存管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/stockStorekeeper/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>仓管库存管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<!-- 交收管理下的列表 -->\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/settle/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>验货单查询</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/financial/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>金融货物信息审核</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/settleAudit/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>结算货物信息审核</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/warranty/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>质保书查询</span>\r\n");
      out.write("<!-- \t\t</a></li> -->\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/redRedeemBill/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-photogallery\"></i> <span>赎货单查询</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/redRedeemBillFinance/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-photogallery\"></i> <span>金融赎货申请审核</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/redRedeemBillBalance/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-photogallery\"></i> <span>结算赎货申请审核</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/outstockBill/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>提货单管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/outstockBills/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>提货委托单管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/approveOutstock/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>待审批提货单管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/approveOutstocks/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>待审批提货委托单管理</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/finance/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>财务单查询</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/balance/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>余额查询</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/deposit/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>保证金查询</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseInfo/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>基础信息设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseProduct/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>品类设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseCost/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>手续费设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseCosts/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>开票费设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseMargin/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>保证金设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseCompany/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>甲方设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/baseApproval/main\"> <i\r\n");
      out.write("\t\t\t\tclass=\"icon-iconxuexisel\"></i> <span>审批流程设置</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/overdue/main\"> <i\r\n");
      out.write("\t\t\tclass=\"icon-iconxuexisel\"></i> <span>逾期合同查询</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/overdueApply/main\"> <i\r\n");
      out.write("\t\t\tclass=\"icon-iconxuexisel\"></i> <span>逾期延期审核</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t\t<li><a class=\"ui-arrowadd drop\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/feeFinalReport/main\"> <i\r\n");
      out.write("\t\t\tclass=\"icon-iconxuexisel\"></i> <span>期末期初报表</span>\r\n");
      out.write("\t\t</a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("\t<!-- sidebar menu end-->\r\n");
      out.write("</div>\r\n");
      out.write("<!--sidebar end-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<!--sidebar end-->\r\n");
      out.write("\r\n");
      out.write("\t\t<section class=\"main-content\">\r\n");
      out.write("\t\t\t<footer class=\"warp-footer\"></footer>\r\n");
      out.write("\t\t\t<section class=\"wrapper\">\r\n");
      out.write("\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t<!-- title start -->\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-tit clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ui-col-50 ui-pt6\">\r\n");
      out.write("\t\t\t\t\t\t\t<label>金融库存管理</label>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<!-- title end -->\r\n");
      out.write("\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"panel-control clearfix\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"search-opt ui-pw20 ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-col ui-mb16\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col col-240 ui-border-r\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"ui-col-10 tip-label\">业务类型：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-col-70\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- <select data-placeholder=\"客户来源\"\r\n");
      out.write("                                                 class=\"chosen-select\"\r\n");
      out.write("                                                 v-model=\"searchParam.dto.businessType\" @change=\"fetchData\">\r\n");
      out.write("                                                 <option value=\"\">全部</option>\r\n");
      out.write("                                                 <option v-for=\"item of options.BusinessType\" :key=\"item[0]\" :value='item[0]'>{{item[1]}}</option>\r\n");
      out.write("                                         </select> -->\r\n");
      out.write("                                         <component-select v-model=\"searchParam.dto.businessType\" type=\"BusinessType\"  @change=\"fetchData()\">\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col col-240 ui-border-r\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label class=\"ui-col-10 tip-label\">库存状态：</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-col-70\">\r\n");
      out.write("                                         <component-select v-model=\"searchParam.dto.stats\" type=\"InOrNotStock\"  @change=\"fetchData()\">\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col col-240 ui-ml28\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"ui-btn btn-opt-link btn-opt-screen\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icon-paixujiang\"></i>筛选\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-col search-criter ui-hidden\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col-90\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">买方客户:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <component-select v-model=\"searchParam.dto.buyerId\" type=\"crmClients\" :search=\"true\" :remoteseach=\"true\" >\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">卖方客户:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <component-select v-model=\"searchParam.dto.sellerId\" type=\"crmClients\" :search=\"true\" :remoteseach=\"true\" >\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">存放仓库:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  <component-select v-model=\"searchParam.dto.storageId\" type=\"DictMallDepot\">\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">入库日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr12 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" v-model=\"searchParam.dto.instockStartDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"ui-input-control daterange-start\" placeholder=\"起始时间\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" v-model=\"searchParam.dto.instockEndDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tclass=\"ui-input-control daterange-end\" placeholder=\"结束时间\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col-90\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">表面:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <component-select v-model=\"searchParam.dto.surfaceId\" type=\"baseProcess\" :search=\"true\" :remoteseach=\"true\" >\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">品类:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <component-select v-model=\"searchParam.dto.productId\" type=\"baseProduct\" :search=\"true\" :remoteseach=\"true\" >\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">材质:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  <component-select v-model=\"searchParam.dto.materialId\" type=\"DictMallSpec\"  >\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">厂商:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  <component-select v-model=\"searchParam.dto.mnfctId\" type=\"mallMnfcts\"  >\r\n");
      out.write("                                         </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">卷号:</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" class=\"ui-input-control\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tplaceholder=\"请输入卷号\" v-model=\"searchParam.dto.volume\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">合同自编号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <component-select v-model=\"searchParam.dto.contractId\" type=\"contractCode\" :search=\"true\" :remoteseach=\"true\">\r\n");
      out.write("                                       \t\t\t </component-select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group pull-left\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control pull-left\">合同编号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col col-160 ui-mr24 ui-ml4\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<component-select v-model=\"searchParam.dto.contractId\" type=\"contractNum\" :search=\"true\">\r\n");
      out.write("                                       \t\t\t </component-select>\r\n");
      out.write("                                       \t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col-10 ui-txt-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"ui-btn ui-btn-primary btn-search-data\" @click=\"fetchData()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icon-sousuo\"></i>搜索\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <div class=\"ui-col-10 ui-txt-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<button type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tclass=\"ui-btn ui-btn-primary btn-search-data\" @click=\"reset()\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icon-sousuo\"></i>重置\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ui-col slide-overflow\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"main-cnt-scroll\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tid=\"invinventoryFinancialIndex\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t@fetch-data=\"fetchData\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t@detail=\"detail\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:data=\"tableData\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\trow-key=\"invInventory.inventoryId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:loading=\"tableConfig.loading\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:columns=\"tableConfig.columns\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:pagination=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"contractId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"合同自编号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t<span v-if=\"scope.row.conContract!=null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t\t{{scope.row.conContract.contractCode}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"合同编号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t<span v-if=\"scope.row.conContract!=null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t\t{{scope.row.conContract.contractNo}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"sellerId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"卖方客户\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"110\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.sellerName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"buyerId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"买方客户\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"110\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.buyerName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"businessType\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"业务类型\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"110\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <span  v-if=\"scope.row.invInventory.businessType === 'H'\">货押融资</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"scope.row.invInventory.businessType === 'C'\">定向销售</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"scope.row.invInventory.businessType === 'X'\">采购自销</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"scope.row.invInventory.businessType === 'D'\">仓单质押</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"scope.row.invInventory.businessType === 'E'\">商城融资</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"scope.row.invInventory.businessType === 'F'\">订单交收</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"instockDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"入库日期\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\twidth=\"200\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t{{scope.row.invInventory.instockDate}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"createDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"创建时间\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\twidth=\"200\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t{{scope.row.invInventory.createDate}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"ownCargo\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"是否是自有货物\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.ownCargo =='Y'?\"是\":\"否\"}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"库存状态\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"110\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <div v-if=\"scope.row.invInventory.quantity == 0 || scope.row.invInventory.quantity == null \">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  \t已出库\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <div v-if=\"scope.row.invInventory.quantity != 0 && scope.row.invInventory.quantity != null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t仓库中\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"quantity\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"数量\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"140\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span v-if=\"scope.row.invInventory.quantity !=null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t\t{{scope.row.invInventory.quantity}} {{scope.row.baseProduct.quantityUnit}} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"nextUnlockQuantity\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"待解锁数量\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t{{(scope.row.invInventory.nextUnlockQuantity==null? 0 :scope.row.invInventory.nextUnlockQuantity) +\"  \"+ scope.row.baseProduct.quantityUnit}} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"nextOutstockQuantity\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"待出库数量\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{(scope.row.invInventory.nextOutstockQuantity==null? 0 :scope.row.invInventory.nextOutstockQuantity)  +\"  \"+ scope.row.baseProduct.quantityUnit}} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"enableNum\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"可供数量\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <span v-if=\"scope.row.enableNum !=null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t{{scope.row.enableNum}} {{scope.row.baseProduct.quantityUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"storageId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"存放仓库\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"170\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.storageName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"productId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"品类\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.productName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"materialId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"材质\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.materialId}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"surfaceId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"表面\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.surfaceId}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tv-if=\"false\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"labelThick\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"标准厚度\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.labelThick}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"labelWidth\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"规格(mm)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"210\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t \t{{scope.row.invInventory.labelThick}} * {{scope.row.invInventory.labelWidth}} * {{scope.row.invInventory.goodsLength}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"edge\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"边部(mm)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.edge}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"referThick\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"参厚(mm)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.referThick}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"realWidth\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"实宽(mm)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.realWidth}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"trademark\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"牌号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.trademark}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"volume\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"卷号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.volume}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!--  -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\tprop=\"mnfctId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlabel=\"厂家\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tmin-width=\"200\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<span v-if=\"scope.row.dictMallMnfct !=null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.dictMallMnfct.mnfctName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"netWeight\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"净重\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  {{scope.row.invInventory.netWeight != null ? util.formatNumber((scope.row.invInventory.netWeight / scope.row.baseProduct.unitRate), scope.row.baseProduct.precision) : 0}}  {{scope.row.baseProduct.weightUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"calcMethod\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"计算方式\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"110\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.calcMethod}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"grade\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"等级\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.grade}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"contractUnitPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"合同单价\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.contractUnitPrice==null?util.replaceSpace(scope.row.invInventory.contractUnitPrice,'0'):scope.row.invInventory.contractUnitPrice + '元/'+scope.row.baseProduct.weightUnit}} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"realUnitPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"实际单价\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.contractUnitPrice==null?util.replaceSpace(scope.row.invInventory.contractUnitPrice,'0'):scope.row.invInventory.contractUnitPrice + '元/'+scope.row.baseProduct.weightUnit}} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"contractMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"合同金额(元)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.contractMoney==null?util.replaceSpace(scope.row.invInventory.contractMoney,'0'):scope.row.invInventory.contractMoney }} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"realMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"实际金额(元)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.realMoney==null?util.replaceSpace(scope.row.invInventory.realMoney,'0'):scope.row.invInventory.realMoney }} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"storePrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"商城价(元)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.storePrice==null?util.replaceSpace(scope.row.invInventory.storePrice,'0'):scope.row.invInventory.storePrice }} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"basicPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"基价(元)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.basicPrice==null?util.replaceSpace(scope.row.invInventory.basicPrice,'0'):scope.row.invInventory.basicPrice }} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"floatPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"升贴水(元)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.floatPrice==null?util.replaceSpace(scope.row.invInventory.floatPrice,'0'):scope.row.invInventory.floatPrice }} \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"implStd\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"执行标准\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"110\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.implStd}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tprop=\"notes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tlabel=\"备注\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmin-width=\"80\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t {{scope.row.invInventory.notes}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</section>\r\n");
      out.write("\t\t</section>\r\n");
      out.write("\t</section>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- mgljs -->\r\n");
      out.write("<script>\r\n");
      out.write("var ctx = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/mgljs/app/util.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/plugin/vue/vue.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/plugin/elementui/index.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/mgljs/require.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/mgljs/config.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/common/mgui.js\"></script>\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/common/gyl-common.js\"></script>\r\n");
      out.write("<!-- 快速新建 -->\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 私有JS -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/invinventory/invinventoryFinancialIndex.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- 模块部分公用js -->\r\n");
      out.write("\r\n");
      out.write("</html>");
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
    // /WEB-INF/views/invinventory/../include/./include.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/invinventory/../include/./include.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/invinventory/../include/./include.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f1.setParent(null);
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("fileUrlBase");
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/invinventory/../include/./../include/basePath.jsp(4,0) 'http://192.168.8.206'",_el_expressionfactory.createValueExpression("http://192.168.8.206",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
    if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f2 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f2.setParent(null);
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("gylImageUrl");
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/invinventory/../include/./../include/basePath.jsp(5,0) 'devgyl'",_el_expressionfactory.createValueExpression("devgyl",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/views/invinventory/../include/navgation.jsp(31,3) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/invinventory/../include/navgation.jsp(31,3) '${privSystem}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${privSystem}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/views/invinventory/../include/navgation.jsp(31,3) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("item");
    // /WEB-INF/views/invinventory/../include/navgation.jsp(31,3) name = varStatus type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVarStatus("status");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t<li>\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("\t\t\t\t\t<a href=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.systemUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\" onclick=\"changeUrl('");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${uiasUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.systemCode}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("')\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.systemName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</a>\r\n");
          out.write("\t\t\t\t</li>\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvarStatus_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/invinventory/../include/navgation.jsp(33,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.systemCode == 'CRM'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<i class=\"ico-crm-sprite ico-crm-sys\"></i>\r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /WEB-INF/views/invinventory/../include/navgation.jsp(36,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${item.systemCode == 'SETTLEMENT'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t\t\t<i class=\"ico-crm-sprite ico-settle-sys\"></i> \r\n");
        out.write("\t\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_erp_005fprivilege_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  erp:privilege
    com.maigangle.erp.common.tag.PrivilegeTag _jspx_th_erp_005fprivilege_005f0 = (com.maigangle.erp.common.tag.PrivilegeTag) _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.get(com.maigangle.erp.common.tag.PrivilegeTag.class);
    _jspx_th_erp_005fprivilege_005f0.setPageContext(_jspx_page_context);
    _jspx_th_erp_005fprivilege_005f0.setParent(null);
    // /WEB-INF/views/invinventory/invinventoryFinancialIndex.jsp(31,6) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f0.setKey("GYL_INVENTORY_FINANCIAL_VIEW");
    int[] _jspx_push_body_count_erp_005fprivilege_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f0 = _jspx_th_erp_005fprivilege_005f0.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t<span data-privilege=\"view\"></span>\r\n");
          out.write("\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_erp_005fprivilege_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_erp_005fprivilege_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_erp_005fprivilege_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_erp_005fprivilege_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_erp_005fprivilege_005f0.doFinally();
      _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.reuse(_jspx_th_erp_005fprivilege_005f0);
    }
    return false;
  }
}