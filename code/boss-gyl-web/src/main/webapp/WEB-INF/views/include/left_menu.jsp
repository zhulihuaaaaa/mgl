<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--sidebar start-->
<div class="ui-sidebar ui-sidebar-positive sidebar-scroll"
	id="sidebar-menu">
	<div class="sidebar-toggle">
		<i class="icon-sanshuxian"></i>
	</div>
	<!-- sidebar menu start-->
	<ul class="sidebar-menu">
		<li><a class="ui-arrowadd drop" href="${ctx}/contract/main"> <i
				class="icon-iconxuexisel"></i> <span>合同管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/approveContract/main"> <i
				class="icon-iconxuexisel"></i> <span>待审批合同管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/contractBalance/main"> <i
				class="icon-iconxuexisel"></i> <span>合同对账信息</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/instockBill/main"> <i
				class="icon-iconxuexisel"></i> <span>入库管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/stock/main"> <i
				class="icon-iconxuexisel"></i> <span>库存管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/checkInv/main"> <i
				class="icon-iconxuexisel"></i> <span>库存盘点</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/invoice/main"> <i
				class="icon-iconxuexisel"></i> <span>发票管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/stockFinancial/main"> <i
				class="icon-iconxuexisel"></i> <span>金融库存管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/stockStorekeeper/main"> <i
				class="icon-iconxuexisel"></i> <span>仓管库存管理</span>
		</a></li>
		<!-- 交收管理下的列表 -->
		<li><a class="ui-arrowadd drop" href="${ctx}/settle/main"> <i
				class="icon-iconxuexisel"></i> <span>验货单查询</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/financial/main"> <i
				class="icon-iconxuexisel"></i> <span>金融货物信息审核</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/settleAudit/main"> <i
				class="icon-iconxuexisel"></i> <span>结算货物信息审核</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/warranty/main"> <i
				class="icon-iconxuexisel"></i> <span>质保书查询</span>
<!-- 		</a></li> -->
		<li><a class="ui-arrowadd drop" href="${ctx}/redRedeemBill/main"> <i
				class="icon-photogallery"></i> <span>赎货单查询</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/redRedeemBillFinance/main"> <i
				class="icon-photogallery"></i> <span>金融赎货申请审核</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/redRedeemBillBalance/main"> <i
				class="icon-photogallery"></i> <span>结算赎货申请审核</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/outstockBill/main"> <i
				class="icon-iconxuexisel"></i> <span>提货单管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/outstockBills/main"> <i
				class="icon-iconxuexisel"></i> <span>提货委托单管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/approveOutstock/main"> <i
				class="icon-iconxuexisel"></i> <span>待审批提货单管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/approveOutstocks/main"> <i
				class="icon-iconxuexisel"></i> <span>待审批提货委托单管理</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/finance/main"> <i
				class="icon-iconxuexisel"></i> <span>财务单查询</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/balance/main"> <i
				class="icon-iconxuexisel"></i> <span>余额查询</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/deposit/main"> <i
				class="icon-iconxuexisel"></i> <span>保证金查询</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseInfo/main"> <i
				class="icon-iconxuexisel"></i> <span>基础信息设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseProduct/main"> <i
				class="icon-iconxuexisel"></i> <span>品类设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseCost/main"> <i
				class="icon-iconxuexisel"></i> <span>手续费设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseCosts/main"> <i
				class="icon-iconxuexisel"></i> <span>开票费设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseMargin/main"> <i
				class="icon-iconxuexisel"></i> <span>保证金设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseCompany/main"> <i
				class="icon-iconxuexisel"></i> <span>甲方设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/baseApproval/main"> <i
				class="icon-iconxuexisel"></i> <span>审批流程设置</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/overdue/main"> <i
			class="icon-iconxuexisel"></i> <span>逾期合同查询</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/overdueApply/main"> <i
			class="icon-iconxuexisel"></i> <span>逾期延期审核</span>
		</a></li>
		<li><a class="ui-arrowadd drop" href="${ctx}/feeFinalReport/main"> <i
			class="icon-iconxuexisel"></i> <span>期末期初报表</span>
		</a></li>
	</ul>
	<!-- sidebar menu end-->
</div>
<!--sidebar end-->



