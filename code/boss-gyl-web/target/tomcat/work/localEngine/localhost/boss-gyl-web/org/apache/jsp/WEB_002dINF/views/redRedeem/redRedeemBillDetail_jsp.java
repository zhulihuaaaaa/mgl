package org.apache.jsp.WEB_002dINF.views.redRedeem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class redRedeemBillDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/WEB-INF/views/redRedeem/../include/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/redRedeem/../include/./include.jsp");
    _jspx_dependants.add("/WEB-INF/views/redRedeem/../include/./../include/basePath.jsp");
    _jspx_dependants.add("/WEB-INF/custom_common.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("<title>赎货详情</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<section id=\"container\">\r\n");
      out.write("\t\t<div id=\"slideEidt\">\r\n");
      out.write("\t\t\t<div class=\"slide-cnt\">\r\n");
      out.write("\t\t\t<component-slide @fetch-data=\"fetchData\" :id=\"model.redeemBillId\" :show.sync=\"show\" :tab-data.sync=\"tabData\" :active-index.sync=\"activeIndex\">\r\n");
      out.write("\t\t\t\t<span class=\"slide-close\" title=\"关闭\">×</span>\r\n");
      out.write("\t\t\t\t<div class=\"scroll-wrapper ui-pw15\">\r\n");
      out.write("\t\t\t\t\t<div class=\"ui-row ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"scroll-tit ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t<h1 class=\"ui-mb8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>{{model.redeemBillCode}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t<el-tag slot=\"reference\"\r\n");
      out.write("\t\t\t\t\t\t            size=\"small\">{{auditStatus}}\r\n");
      out.write("\t\t\t\t\t\t        </el-tag>\r\n");
      out.write("\t\t\t\t\t\t\t\t</component-approval-btn>\r\n");
      out.write("\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-col ui-col-70 scroll-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>创建人</label> <span>{{model.createUser}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t <p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>创建时间</label> <span>{{model.createDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t <p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>对应合同</label> <span>{{model.contractNo}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>货物来源</label> <span>{{goodsSourceMap[model.goodsSource]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-col ui-col-30 ui-txt-right ui-pb6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-navgation\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"scroll-tab\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"active\"><p>概要</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><p>货物信息</p></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-container tab-container\" v-loading=\"loading\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-wrapper\">\r\n");
      out.write("\t<!--基础信息  -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>基础信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">赎货客户</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.buyerName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">创建人</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.createUser}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">创建时间</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.createDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">对应合同</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.contractNo}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">货物来源</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{goodsSourceMap[model.goodsSource]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t \t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">总重量（吨）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.totalWeight)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">审核状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{approvalStateMap[model.auditStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">仓库名</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.dictMallDepot.dptName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">赎货状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{redeemBillState[model.redeemStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 提货人信息\t -->\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>提货人信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">提货人</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.consignee}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">提货人电话</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.consigneeTel}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">提货人身份证号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.consigneeIdNo}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">车牌号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.carNumber}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 费用信息\t -->\t\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>费用信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">货款（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.totalGoodsPayment)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">手续费（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.commissionFee)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">开票费（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.invoiceFee)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">计费天数（天）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.chargingDays)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">其他费用（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.otherFee)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">保证金抵消金额（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.depositFee)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t <div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">总金额（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.totalMoney)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">待付总金额（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(model.realMoney)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 基础信息结束 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 1 && tabData[activeIndex]\">\r\n");
      out.write("\t\t<!-- 货物信息 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>货物信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f3(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t:max-height=\"500\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t:max-height=\"500\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[1]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t <template class=\"detail-table\"></template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 货物信息结束 -->\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</component-slide>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("</body>\r\n");
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
    // /WEB-INF/views/redRedeem/../include/./include.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/redRedeem/../include/./include.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/redRedeem/../include/./include.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/redRedeem/../include/./../include/basePath.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("fileUrlBase");
    // /WEB-INF/views/redRedeem/../include/./../include/basePath.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/redRedeem/../include/./../include/basePath.jsp(4,0) 'http://192.168.8.206'",_el_expressionfactory.createValueExpression("http://192.168.8.206",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/redRedeem/../include/./../include/basePath.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("gylImageUrl");
    // /WEB-INF/views/redRedeem/../include/./../include/basePath.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/redRedeem/../include/./../include/basePath.jsp(5,0) 'devgyl'",_el_expressionfactory.createValueExpression("devgyl",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
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
    // /WEB-INF/views/redRedeem/redRedeemBillDetail.jsp(40,8) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f0.setKey("GYL_REDREDEEM_APPROVAL");
    int[] _jspx_push_body_count_erp_005fprivilege_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f0 = _jspx_th_erp_005fprivilege_005f0.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<el-button\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\tv-if=\"!model.auditStatus\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t        size=\"small\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t        type=\"primary\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t        @click=\"handleSubmit\">提交\r\n");
          out.write("\t\t\t\t\t\t\t\t\t    </el-button>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
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

  private boolean _jspx_meth_erp_005fprivilege_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  erp:privilege
    com.maigangle.erp.common.tag.PrivilegeTag _jspx_th_erp_005fprivilege_005f1 = (com.maigangle.erp.common.tag.PrivilegeTag) _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.get(com.maigangle.erp.common.tag.PrivilegeTag.class);
    _jspx_th_erp_005fprivilege_005f1.setPageContext(_jspx_page_context);
    _jspx_th_erp_005fprivilege_005f1.setParent(null);
    // /WEB-INF/views/redRedeem/redRedeemBillDetail.jsp(50,8) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f1.setKey("GYL_REDREDEEM_EDIT");
    int[] _jspx_push_body_count_erp_005fprivilege_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f1 = _jspx_th_erp_005fprivilege_005f1.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0);\" class=\"a-edit ui-ft13 ui-blue\" @click=\"editInfo\" v-if=\"!model.auditStatus\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icon-coupon ui-blue\"></i>编辑\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_erp_005fprivilege_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_erp_005fprivilege_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_erp_005fprivilege_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_erp_005fprivilege_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_erp_005fprivilege_005f1.doFinally();
      _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.reuse(_jspx_th_erp_005fprivilege_005f1);
    }
    return false;
  }

  private boolean _jspx_meth_erp_005fprivilege_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  erp:privilege
    com.maigangle.erp.common.tag.PrivilegeTag _jspx_th_erp_005fprivilege_005f2 = (com.maigangle.erp.common.tag.PrivilegeTag) _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.get(com.maigangle.erp.common.tag.PrivilegeTag.class);
    _jspx_th_erp_005fprivilege_005f2.setPageContext(_jspx_page_context);
    _jspx_th_erp_005fprivilege_005f2.setParent(null);
    // /WEB-INF/views/redRedeem/redRedeemBillDetail.jsp(55,9) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f2.setKey("GYL_REDREDEEM_DELETE");
    int[] _jspx_push_body_count_erp_005fprivilege_005f2 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f2 = _jspx_th_erp_005fprivilege_005f2.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t<a href=\"javascript:void(0);\" class=\"a-edit ui-ft13 ui-blue\" @click=\"delInfo\" v-if=\"!model.auditStatus\">\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t<i class=\"icon-coupon ui-blue\"></i>删除\r\n");
          out.write("\t\t\t\t\t\t\t\t\t</a>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_erp_005fprivilege_005f2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_erp_005fprivilege_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_erp_005fprivilege_005f2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_erp_005fprivilege_005f2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_erp_005fprivilege_005f2.doFinally();
      _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.reuse(_jspx_th_erp_005fprivilege_005f2);
    }
    return false;
  }

  private boolean _jspx_meth_erp_005fprivilege_005f3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  erp:privilege
    com.maigangle.erp.common.tag.PrivilegeTag _jspx_th_erp_005fprivilege_005f3 = (com.maigangle.erp.common.tag.PrivilegeTag) _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.get(com.maigangle.erp.common.tag.PrivilegeTag.class);
    _jspx_th_erp_005fprivilege_005f3.setPageContext(_jspx_page_context);
    _jspx_th_erp_005fprivilege_005f3.setParent(null);
    // /WEB-INF/views/redRedeem/redRedeemBillDetail.jsp(246,11) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f3.setKey("GYL_REDREDEEM_EDIT");
    int[] _jspx_push_body_count_erp_005fprivilege_005f3 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f3 = _jspx_th_erp_005fprivilege_005f3.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("<!-- \t\t\t\t\t\t\t\t\t\t<input @click=\"add\" type=\"button\" style=\"background-color:#5CB85C;color:#fff;margin-right:5px\" class=\"ui-btn pull-right btn_new_line\" value=\"新增\" />-->\r\n");
          out.write(" \t\t\t\t\t\t\t\t\t\t\t<input @click=\"edit\" v-if=\"!model.auditStatus\" type=\"button\" style=\"background-color:#5CB85C;color:#fff\" class=\"ui-btn pull-right btn_new_line\" value=\"编辑\" />\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_erp_005fprivilege_005f3.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_erp_005fprivilege_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_erp_005fprivilege_005f3[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_erp_005fprivilege_005f3.doCatch(_jspx_exception);
    } finally {
      _jspx_th_erp_005fprivilege_005f3.doFinally();
      _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey.reuse(_jspx_th_erp_005fprivilege_005f3);
    }
    return false;
  }
}