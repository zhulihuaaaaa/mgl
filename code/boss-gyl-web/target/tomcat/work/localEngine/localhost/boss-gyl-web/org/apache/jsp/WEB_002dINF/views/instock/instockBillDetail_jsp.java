package org.apache.jsp.WEB_002dINF.views.instock;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class instockBillDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/WEB-INF/views/instock/../include/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/instock/../include/./include.jsp");
    _jspx_dependants.add("/WEB-INF/views/instock/../include/./../include/basePath.jsp");
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
      out.write("<title>入库详情</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<section id=\"container\">\r\n");
      out.write("\t\t<div id=\"slideEidt\">\r\n");
      out.write("\t\t\t<div class=\"slide-cnt\">\r\n");
      out.write("\t\t\t<component-slide @fetch-data=\"fetchData\" :id=\"instockId\" :show.sync=\"show\" :tab-data.sync=\"tabData\" :active-index.sync=\"activeIndex\">\r\n");
      out.write("\t\t\t\t<span class=\"slide-close\" title=\"关闭\">×</span>\r\n");
      out.write("\t\t\t\t<div class=\"scroll-wrapper ui-pw15\">\r\n");
      out.write("\t\t\t\t\t<div class=\"ui-row ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"scroll-tit ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t<h1 class=\"ui-mb8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<span>{{model.bill.instockCode}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-tag  v-if=\"model.bill.instockStatus == 'B'\" style=\"display:inline;font-size: 14px; color: #409EFF;\" >已完成</el-tag>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-tag  v-if=\"model.bill.instockStatus == 'A'\" style=\"display:inline;font-size: 14px; color: #409EFF;\" >进行中</el-tag>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<el-tag  v-if=\"model.bill.instockStatus == 'C'\" style=\"display:inline;font-size: 14px; color: #409EFF;\" >已作废</el-tag>\r\n");
      out.write("\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-col ui-col-70 scroll-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>创建人</label> <span>{{model.bill.createUser}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<label>业务类型</label> <span>{{businessTypeMap[model.bill.businessType]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-col ui-col-30 ui-txt-right ui-pb6\">\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"swiper-navgation\">\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"scroll-tab\">\r\n");
      out.write("\t\t\t\t\t\t\t<li class=\"active\"><p>概要</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><p>合同信息</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><p>验收货物信息</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><p>打款申请记录</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><p>交易记录</p></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" id=\"detailTabType\" value=\"A\">\r\n");
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
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">入库单号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.bill.instockCode}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">合同编号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.contractNo}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">业务类型</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{businessTypeMap[model.bill.businessType]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">创建人</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.bill.createUser}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">创建日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{model.bill.createDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">入库状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{InstockStateMap[model.bill.instockStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">保证金状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{DepositStateMap[model.bill.depositStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">验货入库状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{InspectionStateMap[model.bill.inspectionStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">融资货款状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-if=\"model.bill.businessType == 'H'\">{{GoodsPaymentStateMap[model.bill.financingLoanStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-else>--</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">钢厂货款状态</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-if=\"model.bill.businessType == 'C' ||model.bill.businessType == 'X'\">{{GoodsPaymentStateMap[model.bill.paymentStatus]}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-else>--</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!--基础信息结束 -->\r\n");
      out.write("\t\t<!-- 合同 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-slide\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 1 && tabData[activeIndex]\">\r\n");
      out.write("\t\t<!-- 合同基础信息 -->\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>合同基础信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">业务类型</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(businessTypeMap[tabData[1].info.contractType])}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">合同编号</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(tabData[1].info.contractNo)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t     <div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">甲方</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{tabData[1].info.seller !=null?util.replaceSpace(tabData[1].info.seller.companyName):\"\"}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">乙方</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{tabData[1].info.buyer!=null? util.replaceSpace(tabData[1].info.buyer.clientName):\"\"}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">签订日期</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(tabData[1].info.signDate)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">供应方</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-if=\"tabData[1].info.mnfct !=null \">{{util.replaceSpace(tabData[1].info.mnfct.mnfctShortName)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">合同原件</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<component-images :data=\"util.replaceSpace(tabData[1].info.attactList)\" title=\"合同原件\"></component-images>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">保证金比例</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(util.formatNumber((tabData[1].info.depositRate*100),0))}}%</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">保证金金额（万元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(util.formatNumber((tabData[1].info.depositFee / 10000), 2))}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">开票费（元）</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(tabData[1].info.invoiceBaseFee)}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-30\">货物总重</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-60 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(util.formatNumber((tabData[1].info.totalWeight / 1000), 3))}}吨</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-form-group ui-col-50\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"ui-label-control ui-col ui-col-40\">货物总价</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-50 ui-label-txt\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <span>{{util.replaceSpace(util.formatNumber((tabData[1].info.totalMoney / 10000), 2))}}万元</span> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span>{{util.replaceSpace(tabData[1].info.totalMoney)}}元 </span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!--合同货物信息-->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>合同货物信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-row\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    <component-table \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t    \t:max-height=\"300\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    :data=\"tabData[1].detail\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    <el-table-column label=\"品类\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.product.productName)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    </el-table-column>  \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t   <el-table-column label=\"材质\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t   \t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.materialId)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    </el-table-column> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"表面\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.surfaceId)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"规格(mm)\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.labelThick)}}*{{util.replaceSpace(scope.row.labelWidth)}}*{{util.replaceSpace(scope.row.goodsLength)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    <el-table-column label=\"边部\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t    \t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.edge)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"厂家\" width=\"200\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{ scope.row.mnfct !=null?util.replaceSpace(scope.row.mnfct.mnfctName):\"\"}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"数量(张/卷)\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.amount)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"重量(kg)\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.netWeight)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"含税单价(元/kg)\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.unitContractPrice)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<el-table-column label=\"含税金额(元)\" width=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.contractMoney)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t   </component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!--合同货物信息结束-->\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 验收货物信息 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-slide\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 2 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>验收货物信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[2]\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:max-height=\"500\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"入库日期\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"100\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.instockDate)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"品类\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.productName)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"材质\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.materialId)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"表面\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"80\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.surfaceId)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"标准厚度(mm)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.labelThick)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"仓库\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.dictMallDepot.dptName)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    <el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"边部(mm)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.edge)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"参厚(mm)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.referThick)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"实宽(mm)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.realWidth)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"牌号\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.trademark)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    <el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"卷号\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.goodsVolume)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"净重\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.netWeight + scope.row.baseProduct.weightUnit)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"数量\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.amount,0)+scope.row.baseProduct.quantityUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"计算方式\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.calcMethod)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"等级\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.grade)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"合同单价\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.contractUnitPrice)}}元/{{scope.row.baseProduct.weightUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"实际单价\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.realUnitPrice,0)}}元/{{scope.row.baseProduct.weightUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"升贴水(元)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.floatPrice,'0')}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"基价(元)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.basicPrice,'0')}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"合同金额(元)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.contractMoney,'0')}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"实际金额(元)\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.realMoney,'0')}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"执行标准\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.implStd)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"备注\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"120\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.insInspectionDetail.notes)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</component-table> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 打款申请记录 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-slide\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 3 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>打款申请记录</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[3]\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"打款额（元）\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.detail.money)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"打款状态\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{DepositStateMap[scope.row.detail.remitStatus]}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"审核状态\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{ApprovalStateMap[scope.row.detail.auditStatus]}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"申请人\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{scope.row.detail.createUser}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"申请日期\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{scope.row.detail.createDate}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"确认人\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"150\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{scope.row.checkMan}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</component-table> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t<!-- 交易记录 -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-slide\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 4 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<span>交易记录</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<template> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:data=\"tabData[4]\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\trow-key=\"ContractRecord\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"打款类型\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{scope.row.remitTypeName}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"金额（元）\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{util.replaceSpace(scope.row.detail.money)}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"交易时间\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{scope.row.detail.remitDate}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tlabel=\"交易状态\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t{{scope.row.remitState}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</component-table> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</component-slide>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</section>\r\n");
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
    // /WEB-INF/views/instock/../include/./include.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/instock/../include/./include.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/instock/../include/./include.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/instock/../include/./../include/basePath.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("fileUrlBase");
    // /WEB-INF/views/instock/../include/./../include/basePath.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/instock/../include/./../include/basePath.jsp(4,0) 'http://192.168.8.206'",_el_expressionfactory.createValueExpression("http://192.168.8.206",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/instock/../include/./../include/basePath.jsp(5,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("gylImageUrl");
    // /WEB-INF/views/instock/../include/./../include/basePath.jsp(5,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/instock/../include/./../include/basePath.jsp(5,0) 'devgyl'",_el_expressionfactory.createValueExpression("devgyl",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/instock/instockBillDetail.jsp(35,8) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f0.setKey("GYL_INSTOCKBILL_UPDATE");
    int[] _jspx_push_body_count_erp_005fprivilege_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f0 = _jspx_th_erp_005fprivilege_005f0.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<button v-if=\"model.bill.instockStatus != 'B'\"  type=\"button\" @click=\"commit\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\tclass=\"ui-btn ui-btn-primary ui-pw28 btn-add\" :disabled=\"completeCommit\">完成入库</button>\r\n");
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
    // /WEB-INF/views/instock/instockBillDetail.jsp(39,8) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f1.setKey("GYL_INSTOCKBILL_ADD_APPLY");
    int[] _jspx_push_body_count_erp_005fprivilege_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f1 = _jspx_th_erp_005fprivilege_005f1.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t<button v-if=\"applyMoney\" type=\"button\" @click=\"applyRemit\"\r\n");
          out.write("\t\t\t\t\t\t\t\t\tclass=\"ui-btn ui-btn-primary ui-pw28 btn-add\">申请打款</button>\r\n");
          out.write("\t\t\t\t\t\t\t\t");
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
}
