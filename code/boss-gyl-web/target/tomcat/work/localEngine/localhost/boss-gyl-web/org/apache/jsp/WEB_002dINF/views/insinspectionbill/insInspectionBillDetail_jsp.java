package org.apache.jsp.WEB_002dINF.views.insinspectionbill;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class insInspectionBillDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(4);
    _jspx_dependants.add("/WEB-INF/views/insinspectionbill/../include/head.jsp");
    _jspx_dependants.add("/WEB-INF/views/insinspectionbill/../include/./include.jsp");
    _jspx_dependants.add("/WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp");
    _jspx_dependants.add("/WEB-INF/custom_common.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey_005fnobody.release();
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
      out.write("<title>验货单详情</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<section id=\"container\">\r\n");
      out.write("\t\t<div id=\"slideEidt\">\r\n");
      out.write("\t\t\t<div class=\"slide-cnt\">\r\n");
      out.write("\t\t\t\t<component-slide   @fetch-data=\"fetchData\" :id=\"model.insInspectionBill.inspectionBillId\"  :show.sync=\"show\" :tab-data.sync=\"tabData\" :active-index.sync=\"activeIndex\">\r\n");
      out.write("\t\t\t\t<div class=\"slideEidt\"></div>\r\n");
      out.write("\t\t\t\t<span class=\"slide-close\" title=\"关闭\">×</span>\r\n");
      out.write("\t\t\t\t\t<div class=\"scroll-wrapper ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"ui-row ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"ui-row ui-pw15\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"scroll-tit ui-col\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1 class=\"ui-mb8\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>{{model.insInspectionBill.inspectionBillCode}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-tag type=\"info\" v-if=\"model.insInspectionBill.inspectionStatus == 'B'\" style=\"display:inline;font-size: 14px;\" >验货中</el-tag>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-tag type=\"info\" v-if=\"model.insInspectionBill.inspectionStatus == 'A'\"  style=\"display:inline;font-size: 14px;\">已验货</el-tag>\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-tag type=\"info\" v-if=\"model.insInspectionBill.inspectionStatus == 'C'\"  style=\"display:inline;font-size: 14px;\">未验货</el-tag>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"ui-col ui-col-70 scroll-info\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>入库单号</label> <span>{{model.instockNo}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>创建时间</label> <span>{{model.insInspectionBill.createDate}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<!-- <p class=\"pull-left ui-mr32\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<label>仓库</label><span v-if=\"model.dictMallDepot!=null\">{{model.dictMallDepot.dptName}}</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</p> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- 删除 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-navgation\">\r\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"scroll-tab\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<li class=\"active\"><p>子验货单</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t<li><p>货物信息</p></li>\r\n");
      out.write("\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" id=\"detailTabType\" value=\"A\">\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"swiper-container tab-container\" v-loading=\"loading\" >\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"swiper-wrapper\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>子验货单\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
      if (_jspx_meth_erp_005fprivilege_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t@fetch-data=\"fetchDataByEdit\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t@detail=\"detail\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t@delete=\"del\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:show-delete-btn=\"showDeleteBtn\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:data=\"tableData\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:operation=\"operation\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:columns=\"tableConfig.columns\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:loading=\"tableConfig.loading\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"contractNo\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"合同编号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.subCode\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"子单单号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.createUser\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"创建人\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"dictMallDepot.dptName\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"仓库\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.instockDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"入库日期\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"100\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.auditStatus\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"审核状态\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t <span  v-if=\"scope.row.insInspectionSub.auditStatus === 'A'\">未提交</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t             <span  v-if=\"scope.row.insInspectionSub.auditStatus === 'B'\">审批中</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t             <span  v-if=\"scope.row.insInspectionSub.auditStatus === 'C'\">已拒绝</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t             <span  v-if=\"scope.row.insInspectionSub.auditStatus === 'D'\">已通过</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t             <span  v-if=\"scope.row.insInspectionSub.auditStatus === 'E'\">已作废</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tv-if=\"false\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"status\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"质保书\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div v-if=\"scope.row.warrantyList != null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-for=\"item in scope.row.warrantyList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img v-if=\"item != null && item != ''\" :src=\"item.filePath\" style=\"width: 100%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tv-if=\"false\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"存货凭证\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<div v-if=\"scope.row.inventoryVoucherList != null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<span v-for=\"item in scope.row.inventoryVoucherList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img v-if=\"item != null && item != ''\" :src=\"item.filePath\" style=\"width: 100%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.voucherNo\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"存货凭证编号\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.createDate\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"创建时间\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.totalNumber\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"总数量\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.totalWeight\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"总重量(吨)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"insInspectionSub.notes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"备注\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"180\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"swiper-slide\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"ui-panel\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"ui-panel-body scroll-body\" v-if=\"activeIndex == 1 && tabData[activeIndex]\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h5 class=\"bg-tit\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span>货物信息</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h5>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<component-table\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t@fetch-data=\"fetchDataByProduct\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:data=\"productData\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:loading=\"tableConfig.loading\" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tprop=\"productName\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlabel=\"品名\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tmin-width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t:show-overflow-tooltip=\"true\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        prop=\"insInspectionDetail.materialId\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        label=\"材质（钢种）\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t        width=\"180\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  prop=\"insInspectionDetail.surfaceId\"\r\n");
      out.write("\t\t\t\t        \t\t\t\t  label=\"表面\"\r\n");
      out.write("\t\t\t\t        \t\t\t\t  width=\"180\"\r\n");
      out.write("\t\t\t\t        \t\t\t\t  > </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column  \r\n");
      out.write("\t\t\t\t\t\t\t\t      v-if=\"false\"\r\n");
      out.write("\t\t\t\t\t\t\t\t      prop=\"insInspectionDetail.labelThick\"\r\n");
      out.write("\t\t\t\t\t\t\t\t      label=\"标准厚度\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"规格(mm)\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        width=\"300\">\r\n");
      out.write("\t\t\t\t\t\t\t\t        <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t   \t\t\t{{scope.row.insInspectionDetail.labelThick}}*{{scope.row.insInspectionDetail.labelWidth}}*{{scope.row.insInspectionDetail.goodsLength}}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      \t prop=\"insInspectionDetail.labelThick\"\r\n");
      out.write("\t\t\t\t\t\t\t\t         width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"边部(mm)\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t       prop=\"insInspectionDetail.referThick\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"参厚(mm)\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t        \t  prop=\"insInspectionDetail.goodsVolume\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"卷号\">\r\n");
      out.write("\t\t\t\t\t\t\t\t        </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t         <el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.trademark\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"牌号\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t         <el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.realWidth\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"实宽(mm)\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t        :show-overflow-tooltip=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          prop=\"dictMallMnfct.mnfctName\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t         label=\"制造商\"> </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t       <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t        prop=\"insInspectionDetail.netWeight\"\r\n");
      out.write("\t\t\t\t\t\t\t\t         width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t       label=\"重量\">\r\n");
      out.write("\t\t\t\t\t\t\t\t       <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t      <span v-if=\"scope.row.insInspectionDetail.netWeight !=null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t        \t{{scope.row.insInspectionDetail.netWeight != null ? util.formatNumber((scope.row.insInspectionDetail.netWeight / scope.row.baseProduct.unitRate), scope.row.baseProduct.precision) : 0}}{{scope.row.baseProduct.weightUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t        \t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t       </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t       </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop=\"insInspectionDetail.amount\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"数量\">\r\n");
      out.write("\t\t\t\t\t\t\t\t         <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t       {{scope.row.insInspectionDetail.amount}}{{scope.row.baseProduct.quantityUnit}}\r\n");
      out.write("\t\t\t\t\t\t\t\t       </template>\r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop=\"insInspectionDetail.grade\"\r\n");
      out.write("\t\t\t\t\t\t\t\t         width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"等级\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t        <div v-if=\"false\">\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.contractUnitPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t         width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"合同单价（元/kg)\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t       <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t       \tprop =\"insInspectionDetail.realUnitPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"150\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"实际单价（元/kg）\"> \r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.floatPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"升贴水\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t         <el-table-column \r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.storePrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"商城价\"></el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      prop =\"insInspectionDetail.basicPrice\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"基价(元)\"> </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.contractMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\t         width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"合同金额\">\r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t      \tprop =\"insInspectionDetail.realMoney\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"实际金额(元)\"> </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t     \tprop =\"insInspectionDetail.serviceFee\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"手续费(元)\"> </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t       <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t       prop =\"insInspectionDetail.invoiceFee\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"开票费(元)\"> </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t        </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t         <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t  prop=\"dictMallDepot.dptName\"\r\n");
      out.write("\t\t\t\t        \t\t\t\t  label=\"仓库\"\r\n");
      out.write("\t\t\t\t        \t\t\t\t  width=\"180\"\r\n");
      out.write("\t\t\t\t        \t\t\t\t  > </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t      <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t       width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t      label=\"货物照片\">\r\n");
      out.write("\t\t\t\t\t\t\t\t      <template slot-scope=\"scope\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!-- <div v-if=\"scope.row.sphotosGoodsList != null\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<span v-for=\"item in scope.row.sphotosGoodsList\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<img v-if=\"item != null && item != ''\" :src=\"item.filePath\" style=\"width: 100%\"/>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<component-images :data=\"scope.row.sphotosGoodsList\" title=\"货物照片\"></component-images>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</template>\r\n");
      out.write("\t\t\t\t\t\t\t\t      \r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t       <el-table-column\r\n");
      out.write("\t\t\t\t\t\t\t\t       :show-overflow-tooltip=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\t\t       \tprop =\"insInspectionDetail.notes\"\r\n");
      out.write("\t\t\t\t\t\t\t\t          width=\"120\"\r\n");
      out.write("\t\t\t\t\t\t\t\t        label=\"备注\">\r\n");
      out.write("\t\t\t\t\t\t\t\t          \r\n");
      out.write("\t\t\t\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t\t\t      </el-table-column>\r\n");
      out.write("\t\t\t\t\t\t\t\t       \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</component-table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
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
    // /WEB-INF/views/insinspectionbill/../include/./include.jsp(8,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /WEB-INF/views/insinspectionbill/../include/./include.jsp(8,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/insinspectionbill/../include/./include.jsp(8,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp(10,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setVar("fileUrlBase");
    // /WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp(10,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f1.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp(10,0) 'http://file.maigangle.com:880'",_el_expressionfactory.createValueExpression("http://file.maigangle.com:880",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    // /WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp(11,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setVar("crmImageUrl");
    // /WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp(11,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f2.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/insinspectionbill/../include/./../include/basePath.jsp(11,0) 'crm'",_el_expressionfactory.createValueExpression("crm",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
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
    com.maigangle.erp.common.tag.PrivilegeTag _jspx_th_erp_005fprivilege_005f0 = (com.maigangle.erp.common.tag.PrivilegeTag) _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey_005fnobody.get(com.maigangle.erp.common.tag.PrivilegeTag.class);
    _jspx_th_erp_005fprivilege_005f0.setPageContext(_jspx_page_context);
    _jspx_th_erp_005fprivilege_005f0.setParent(null);
    // /WEB-INF/views/insinspectionbill/insInspectionBillDetail.jsp(39,8) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f0.setKey("GYL_INSINSPECTIONBILL_DELETE");
    int[] _jspx_push_body_count_erp_005fprivilege_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f0 = _jspx_th_erp_005fprivilege_005f0.doStartTag();
      if (_jspx_th_erp_005fprivilege_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_erp_005fprivilege_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_erp_005fprivilege_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_erp_005fprivilege_005f0.doFinally();
      _005fjspx_005ftagPool_005ferp_005fprivilege_0026_005fkey_005fnobody.reuse(_jspx_th_erp_005fprivilege_005f0);
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
    // /WEB-INF/views/insinspectionbill/insInspectionBillDetail.jsp(59,13) name = key type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_erp_005fprivilege_005f1.setKey("GYL_INSINSPECTIONBILL_ADD");
    int[] _jspx_push_body_count_erp_005fprivilege_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_erp_005fprivilege_005f1 = _jspx_th_erp_005fprivilege_005f1.doStartTag();
      if (_jspx_eval_erp_005fprivilege_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input  v-if=\"isShowAdd\"  type=\"button\" class = \"ui-btn pull-right btn_new_line\" value=\"新增\" @click=\"addProduct\"/>\r\n");
          out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t");
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
