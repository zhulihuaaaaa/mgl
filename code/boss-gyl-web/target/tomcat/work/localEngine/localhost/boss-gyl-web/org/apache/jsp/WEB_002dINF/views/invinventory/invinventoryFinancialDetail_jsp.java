package org.apache.jsp.WEB_002dINF.views.invinventory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class invinventoryFinancialDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/./include.jsp");
    _jspx_dependants.add("/WEB-INF/views/invinventory/../include/./../include/basePath.jsp");
    _jspx_dependants.add("/WEB-INF/custom_common.tld");
  }

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
      out.write("\r\n");
      out.write("<!--æµè¯ç¸å³å¾çå°å  -->\r\n");
      out.write("\r\n");
      out.write("<!--æ­£å¼ç¸å³å¾çå°å  -->\r\n");
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("var showCrmImage = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fileUrlBase}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write('/');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${crmImageUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
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
      out.write("/css/gyl-style.css\" rel=\"stylesheet\" charset=\"utf-8\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/plugin/elementui/index.css\" rel=\"stylesheet\" charset=\"utf-8\">\r\n");
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
      out.write("<title>J金融库存详情</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<section id=\"container\">\r\n");
      out.write("\t\t<div id=\"slideEidt\">\r\n");
      out.write("\t\t\t<div class=\"slide-cnt\">\r\n");
      out.write("\t\t\t\t<component-slide @fetch-data=\"fetchData\"  :id=\"model.invInventory.inventoryId\" :show.sync=\"show\" :tab-data.sync=\"tabData\" :active-index.sync=\"activeIndex\">\r\n");
      out.write("\t\t\t\t\t<span class=\"slide-close\" title=\"关闭\">×</span>\r\n");
      out.write("\t\t\t\t\t<div class=\"scroll-wrapper ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ui-row ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"scroll-tit ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1 class=\"ui-mb8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>{{model.sellerName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-70 scroll-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>买方客户</label> <span>{{model.buyerName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <label>业务类型</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t  \t\t <span  v-if=\"model.invInventory.businessType === 'H'\">货押融资</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'C'\">定向销售</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'X'\">采购自销</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'D'\">仓单质押</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'E'\">商城融资</span>\r\n");
      out.write("\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'F'\">订单交收</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>入库日期</label> \t<span>{{model.invInventory.instockDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>存放仓库</label><span>{{model.dictMallDepot['dptName']}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-navgation\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"scroll-tab\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"active\"><p>概要</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"detailTabType\" value=\"A\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-container tab-container\" v-loading=\"loading\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-wrapper\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>基本信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">卖方客户</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.sellerName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">买方客户</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.buyerName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">业务类型</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t               \t\t\t <span  v-if=\"model.invInventory.businessType === 'H'\">货押融资</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'C'\">定向销售</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'X'\">采购自销</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'D'\">仓单质押</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'E'\">商城融资</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t             <span  v-if=\"model.invInventory.businessType === 'F'\">订单交收</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">入库日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.instockDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>货物信息</span>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">存放仓库</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.storageName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">品名</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.productName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">材质（钢材）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.materialName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">表面</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.surfaceId}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">标准厚度</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.labelThick}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">标签厚度</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.labelThick}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">标准宽度</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.labelWidth}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">标签长度</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.goodsLength}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">边部</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.edge}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">参厚</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.referThick}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">实宽</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.realWidth}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">牌号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.trademark}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">卷号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.volume}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">厂家</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.mnfctName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">净重</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.netWeight}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">数量（张/卷）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.quantity}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">计算方式</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.calcMethod}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">等级</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.grade}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<!--  采购自销等情况下不用出现 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div v-if=\"true\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">升贴水</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.floatPrice}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">基价</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.basicPrice}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">执行标准</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-90 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.implStd}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">备注</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-90 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.notes}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<!-- 合同信息 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>合同信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">合同单价(万元)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.contractUnitPrice}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">合同金额(万元)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.contractMoney}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">实际单价(万元)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.realUnitPrice}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">商城价(元)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-40 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.storePrice}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-10\">实际金额(万元)</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-90 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.invInventory.realMoney}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
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
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(10,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("fileUrlBase");
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(10,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/invinventory/../include/./../include/basePath.jsp(10,0) 'http://file.maigangle.com:880'",_el_expressionfactory.createValueExpression("http://file.maigangle.com:880",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(11,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("crmImageUrl");
    // /WEB-INF/views/invinventory/../include/./../include/basePath.jsp(11,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/invinventory/../include/./../include/basePath.jsp(11,0) 'crm'",_el_expressionfactory.createValueExpression("crm",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f2 = _jspx_th_c_005fset_005f2.doStartTag();
    if (_jspx_th_c_005fset_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f2);
    return false;
  }
}
