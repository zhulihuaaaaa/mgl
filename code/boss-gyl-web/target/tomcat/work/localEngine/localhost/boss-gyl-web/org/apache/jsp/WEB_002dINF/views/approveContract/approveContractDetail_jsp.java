package org.apache.jsp.WEB_002dINF.views.approveContract;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class approveContractDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/WEB-INF/views/approveContract/../include/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/approveContract/../include/./include.jsp");
    _jspx_dependants.add("/WEB-INF/views/approveContract/../include/./../include/basePath.jsp");
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
      out.write("<meta name=\"keywords\" content=\"?????????,erp,?????????,??????,??????\">\r\n");
      out.write("<meta name=\"description\" content=\"?????????????????????\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path=request.getContextPath();/* ??????????????????????????? */

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("<!--??????????????????????????????  -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--????????????????????????????????????????????????  -->\r\n");
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!--????????????????????????????????????????????????  -->\r\n");
      out.write("\r\n");
      out.write("<!--????????????????????????????????????????????????  -->\r\n");
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
      out.write("<!-- HTML5shiv ??? Respond.js IE9??????HTML5 tooltipss??????????????? -->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("    <script src=\"http://cdn.maigangle.com/js/common/html5.js\"></script>\r\n");
      out.write("<![endif]-->");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    // ????????????\r\n");
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
      out.write("<title>????????????</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<section id=\"container\">\r\n");
      out.write("\t\t<div id=\"slideEidt\">\r\n");
      out.write("\t\t\t<div class=\"slide-cnt\">\r\n");
      out.write("\t\t\t\t<component-slide @fetch-data=\"fetchData\" :id=\"model.contractId\" :show.sync=\"show\" :tab-data.sync=\"tabData\" :active-index.sync=\"activeIndex\">\r\n");
      out.write("\t\t\t\t\t<span class=\"slide-close\" title=\"??????\">??</span>\r\n");
      out.write("\t\t\t\t\t<div class=\"scroll-wrapper ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ui-row ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"scroll-tit ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1 class=\"ui-mb8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>{{model.contractNo}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<component-approval-btn\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tv-model=\"flow\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:item-id=\"model.contractId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmodule=\"contract\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-tag=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t:show-info=\"true\"></component-approval-btn>\r\n");
      out.write("\t\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 scroll-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>?????????</label> <span>{{model.createUser}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>????????????</label> <span>{{model.contractStateName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>????????????</label> <span>{{model.contractPeriod}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-txt-right ui-pb6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-navgation\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"scroll-tab\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"active\"><p>??????</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><p>????????????</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><p>??????????????????</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><p>?????????????????????</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"detailTabType\" value=\"A\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-container tab-container\" v-loading=\"loading\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>????????????</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.contractTypeName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.contractCode}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">??????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.buyer.clientName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">??????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.seller.clientName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.signDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.contractPeriod}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">?????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.mnfct != null ? model.mnfct.mnfctShortName : ''}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span v-if=\"hiddenFee\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">???????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.depositRate != null ? util.formatNumber((model.depositRate * 100), 0) : 0}}%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">???????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.depositFee != null ? util.formatNumber((model.depositFee / 10000), 2) : 0}}??????</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">?????????(???/???)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invoiceBaseFee}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">????????????(0~60???)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.feeRates[0].feeValue != null ? util.formatNumber((model.feeRates[0].feeValue * 10000), 2) : 0}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">????????????(61~90???)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.feeRates[1].feeValue != null ? util.formatNumber((model.feeRates[1].feeValue * 10000), 2) : 0}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.totalWeight != null ? util.formatNumber((model.totalWeight / 1000), 3) : 0}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.totalMoney != null ? model.totalMoney : 0}}???</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-100\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col-10\">??????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{ model.notes }}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">????????????</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<component-images :data=\"model.attactList\" title=\"????????????\"></component-images>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 1 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>????????????</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"main-cnt-scroll\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:max-height=\"500\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[1]\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trow-key=\"contractDetailId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"product.productName\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"orderCode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"materialId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"surfaceId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????(mm)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.labelThick + \" * \" + scope.row.labelWidth + \" * \" + scope.row.goodsLength }}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"edge\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.amount == null? 0 : scope.row.amount + scope.row.product.quantityUnit }}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.netWeightDisplay + scope.row.product.weightUnit }}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"????????????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.unitContractPrice ==null? 0 : scope.row.unitContractPrice + \"???/\" +  scope.row.product.weightUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"contractMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tsortable=\"custom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"????????????(???)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"170\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- ???????????? -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 2 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>??????????????????</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"main-cnt-scroll\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:max-height=\"500\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[2]\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trow-key=\"paymentDetailId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"money\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????(???)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"state\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"100\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.state === 'Y' ? '?????????' : '?????????' }}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"createUser\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"?????????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"createDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"????????????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- ??????????????? -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 3 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>?????????????????????</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"main-cnt-scroll\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:max-height=\"500\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[3]\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\trow-key=\"depositDetailId\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"money\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????(???)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"state\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"??????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"100\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.state === 'Y' ? '?????????' : '?????????' }}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"createUser\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"?????????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tprop=\"createDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"????????????\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
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
    // /WEB-INF/views/approveContract/../include/./include.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/approveContract/../include/./include.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/approveContract/../include/./include.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/approveContract/../include/./../include/basePath.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("fileUrlBase");
    // /WEB-INF/views/approveContract/../include/./../include/basePath.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/approveContract/../include/./../include/basePath.jsp(4,0) 'http://192.168.8.206'",_el_expressionfactory.createValueExpression("http://192.168.8.206",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/approveContract/../include/./../include/basePath.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("gylImageUrl");
    // /WEB-INF/views/approveContract/../include/./../include/basePath.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/approveContract/../include/./../include/basePath.jsp(5,0) 'devgyl'",_el_expressionfactory.createValueExpression("devgyl",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/approveContract/approveContractDetail.jsp(39,10) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f0.setKey("GYL_CONTRACT_APPROVAL");
    int[] _jspx_push_body_count_erp_005fprivilege_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f0 = _jspx_th_erp_005fprivilege_005f0.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t<div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t<component-approval-btn\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tv-model=\"flow\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t:item-id=\"model.contractId\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\tmodule=\"contract\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t:show-approval-btn=\"true\"></component-approval-btn>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t");
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
