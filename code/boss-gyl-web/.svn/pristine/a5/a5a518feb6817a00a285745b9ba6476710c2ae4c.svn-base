/**
 * 审批按钮
 * @author 张渊
 * @since 2017.12.20
 * @returns
 */
define(['ajax'], function (ajax) {
	return {
		template: `
			<div class="component-approval-btns" style="display: inline-block;">
			    <el-button v-if="showSubmitBtn && flow != null && flow.canSubmit"
			        :size="size"
			        type="primary"
			        :loading="loading.submit"
			        @click="handleApproval('submit')">提交</el-button>
		        <el-button v-if="showSubmitBtn && flow.canRevoke && flow.state === 'A'"
			            :size="size"
			            type="warning"
			            :loading="loading.abandonSubmit"
			            :disabled="isLoading && !loading.abandonSubmit"
			            @click="handleApproval('abandonSubmit')">撤销提交</el-button>
			    <template v-else-if="flow != null && flow.approvalFlowId != null">	
			       <el-popover
			          v-if="showTag"
			          placement="left"
			          width="250"
			          :disabled="(!showInfo || flow.state === 'E')"
			          v-model="showPopover"
			          trigger="hover">
			        <div v-loading ="approvalInfo ==null" class="approval-steps">
				         <el-steps v-if="approvalInfo !=null" :active="stepActiveIndex" :space="120" :finish-status="stepType" direction="vertical">
				            <el-step v-for="(info, index) of approvalInfo" :key="index" :title="index === 0 ? info.privRole.roleName : info.privRole.roleName">
				            	<div slot="description" v-if="info.createDate != null">
					                <span>审批人:{{info.user.userName}}</span>
					                <br>
					                <span>理　由: {{info.remark}}</span>
					                <br>
					                <span class="create-time">{{info.createDate}}</span>
					             </div>
				            </el-step>
				          </el-steps>
			        </div>
			         <el-tag
			        	slot="reference"
			            :size="size"
			            :type="tagType">{{currentStatus}}</el-tag>
			      </el-popover>
			     
			      <template v-if="showApprovalBtn && flow.canRevoke ">
			        <el-button v-if="flow.state !== 'A' "
			            :size="size"
			            type="warning"
			            :loading="loading.abandon"
			            :disabled="isLoading && !loading.abandon"
			            @click="handleApproval('abandon')">撤销审批</el-button>
			      </template>
			      <template v-if="showApprovalBtn && flow.canApproval">
			        <el-button
			            :loading="loading.approval"
			            @click="handleApproval('approvalByPass')"
			            :disabled="isLoading && !loading.approval"
			            :size="size"
			            type="primary">通过</el-button>
		            <el-button
			            :loading="loading.approval"
			            @click="handleApproval('approvalByNoPass')"
			            :disabled="isLoading && !loading.approval"
			            :size="size"
			            type="primary">拒绝</el-button>
			      </template>
			      <div>
			      	<el-dialog
					  title="审批"
					  :modal-append-to-body="false"
					  :visible.sync="dialogVisible"
					  width="30%" center>
					  <el-input type="textarea" v-model="remark" placeholder="请输入审批内容"></el-input>
					  <span slot="footer" class="dialog-footer">
					    <el-button @click="dialogVisible = false">取 消</el-button>
					    <el-button type="primary" @click="approval()">确 定</el-button>
					  </span>
					</el-dialog>
			      </div>
			      
			      
			      
			    </template>
			  </div>
		`,
//		<template v-if="showApprovalBtn && flow.approvalFlowId != null && flow.state !== 'E'">
//			        <el-button
//			        	:size="size" 
//			            type="danger"
//			            @click="handleApproval('cancel')"
//			            :disabled="isLoading && !loading.cancel"
//			            :loading="loading.cancel">作废</el-button>
//			      </template>
		props: {
	    	value: {
	    		type: Object
		    },
		    // 审批项ID
		    itemId: {
		    	type: String,
		    	required: true
		    },
		    // 模块名
		    module: {
		    	type: String,
		    	required: true
		    },
		    // 按钮大小
		    size: {
		    	type: String,
		      	default: 'small'
		    },
		    // 是否显示审批进程信息
		    showInfo: {
		    	type: Boolean,
		      	default: false
		    },
		    // 显示审批状态Tag
		    showTag: {
		    	type: Boolean,
		      	default: false
		    },
		    // 显示提交按钮
		    showSubmitBtn: {
		    	type: Boolean,
		      	default: false
		    },
		    // 显示审批相关按钮（审批/撤销/作废）
		    showApprovalBtn: {
		    	type: Boolean,
		      	default: false
		    }
		  },
		  data () {
			  return {
				  flow: {
					  approvalFlowId: null,
					  canSubmit: false
				  },
				  approvalFlows: [],
				  approvalInfos: [],
				  loading: {
					  submit: false,
					  abandon: false,
					  abandonSubmit: false,
					  approval: false,
					  cancel: false
				  },
				  // 审批信息 
				  remark:"",
				  // dialog 打开与否
				  dialogVisible:false,
				  // 选择项
				  selectOption:"",
				  // 是否显示审批进度
				  showPopover: false,
				  // 审批列表
				  approvalInfo: null
			  }
		  },
		  computed: {
//		    flow () {
//		      let flow = this.approvalFlows[this.itemId]
//		      if (flow != null && flow['approvalItemId'] != null) {
//		        return flow
//		      }
//		      return null
//		    },
		    // 审批流程总体信息
//		    approvalInfo () {
//		    	return null
//		    },
		    currentStatus () {
		      if (this.flow != null) {
		        let state = this.flow.state
		        switch (state) {
		          case 'A':
		            return '未审批'
		          case 'B':
		            return '审批中'
		          case 'C':
		            return '已拒绝'
		          case 'D':
		            return '已通过'
		          case 'E':
		            return '已作废'
		        }
		      }
		    },
		    // 当前状态类型
		    tagType () {
		      if (this.flow != null) {
		        let state = this.flow.state
		        switch (status) {
		          case 'A':
		            return 'gray'
		          case 'B':
		            return 'primary'
		          case 'C':
		            return 'danger'
		          case 'D':
		            return 'success'
		         default:
		            return null
		        }
		      }
		    },
		    stepType () {
		      if (this.flow != null) {
		        let status = this.flow.state
		        switch (status) {
		          case 'A':
		          case 'B':
		          case 'D':
		            return 'success'
		          case 'C':
		            return 'error'
		        }
		      }
		    },
		    // 审批进度
		    stepActiveIndex () {
		      let activeIndex = 0
		      if (this.approvalInfo != null) {
		        let status = this.flow.state
		        let infoLength = this.approvalInfo.length
		        switch (status) {
		          case 0: return 1
		          case 10: return infoLength
		        }
		        for (let i = 0; i < infoLength; i++) {
		          if (this.approvalInfo[i].createDate != null) {
		            activeIndex = i + 1
		          }
		        }
		      }
		      return activeIndex
		    },
		    // 是否处于Loading状态
		    isLoading () {
		      let isLoading = false
		      for (let key of Object.keys(this.loading)) {
		        isLoading = isLoading || this.loading[key]
		        if (isLoading) {
		          break
		        }
		      }
		      return isLoading
		    }
		  },
		  watch: {
		    itemId: {
		      handler: function (val, old) {
		        if (val != null) {
		        	this.flow = {approvalFlowId: null, canSubmit: true}
		        	this.getApprovalFlow()
		        }
		      },
		      immediate: true
		    },
		    value: {
		      handler: function (val, old) {
		    	  this.flow = val
		      }
		    },
		    showPopover (val, old) {
		    	 let vm = this
		      if (val && this.flow.state !== 'A' && this.approvalInfo == null) {
		        window.setTimeout(function () {
		          if (vm.showPopover) {
		            vm.getApprovalInfo()
		          }
		        }, 1000)
		      }else{
		    	 vm.approvalInfo= null
		      }
		    },
		    isLoading (val) {
		      this.$emit('is-loading', val)
		    }
		  },
		  methods: {
		    formatDate (millisecond) {
		      return CommonUtils.formatDate('yyyy-MM-dd hh:mm', new Date(millisecond))
		    },
		    handleApproval (operation) {
		      let vm = this
		      switch (operation) {
		        case 'submit':
		          vm.loading.submit = true
		          ajax.post('/approval/submit', {
		        	  approvalItemId: this.itemId,
		        	  module: this.module
		          }).then(() => {
		            vm.refreshFlow()
		            vm.loading.submit = false
		          }, () => {
		            vm.refreshFlow()
		            vm.loading.submit = false
		          })
		          break
		        case 'cancel':
		        case 'abandon':
		        	this.abandon(operation)
		        	break;
		        case 'approvalByPass':
		        	this.dialogVisible = true
		        	this.selectOption = "approvalByPass"
		        	//this.approvalByPassOrNoPass('D')
		        	break;
		        case 'approvalByNoPass':
		        	this.dialogVisible = true
		        	this.selectOption = "approvalByNoPass"
		        	// this.approvalByPassOrNoPass('C')
		        	break;
		        case 'abandonSubmit':
		          vm.loading[operation] = true
		          this.$confirm(`是否${operation === 'cancel' ? '作废审批' : '撤销' + (operation === 'abandon' ? '审批' : '提交')}？${operation === 'cancel' ? '(该操作不可撤销)' : ''}`, '请确认', {
		            confirmButtonText: '确定',
		            cancelButtonText: '取消',
		            type: 'warning'
		          }).then(() => {
		            ajax.post('/approval/' + operation, {approvalItemId: this.itemId}).then(() => {
		              vm.refreshFlow()
		              vm.loading[operation] = false
		            }, () => {
		            	vm.refreshFlow()
		            	vm.loading[operation] = false
		            })
		          }, () => {
		            vm.loading[operation] = false
		          })
		          break
		        default:
		          if (vm.approvalInfo == null) {
		            this.getApprovalInfo()
		          }
		      }
		    },
		    refreshFlow () {
		      this.getApprovalFlow()
		    },
		    /**
			 * 获取审批进程信息
			 */
		    getApprovalFlow () {
		      if (this.itemId != null) {
		    	  var vm = this
		    	  ajax.get('/approval/findFlow', {approvalItemId: this.itemId}).then(function (result) {
		    		  if (result.data) {
		    			  vm.flow = $.extend({canSubmit: false}, result.data)
		    		  } else {
		    			  vm.flow = {approvalFlowId: null, canSubmit: true}
		    		  }
		    		  vm.$emit('input', vm.flow)
		    	  }, function () {
		    	  })
		      }
		    },
		    /**
			 * 获取整体审批信息
			 */
		    getApprovalInfo () {
//		      if (this.approvalInfo == null) {
////		        this.$store.dispatch(FETCH_APPROVALINFO, this.itemId)
//		      }
		    	this.fomatFlow()
		    },
		    // 审批dialog
		    approval(){
		    	if(this.selectOption === 'approvalByPass'){
//		    		this.approvalByPassOrNoPass('D')
		    		this.approvalByPassOrNoPass('B')
		    	}else if(this.selectOption === 'approvalByNoPass'){
		    		this.approvalByPassOrNoPass('C')
		    	}
		    },
		    // 审批通过
		    approvalByPassOrNoPass(status){
		    	let flow = {
	    			approvalItemId: this.itemId,
		    		state: status,
	        	    module: this.module,
	        	    remark: this.remark
		    	}
	    		var vm = this
	    		ajax.post('/approval/approval',flow).then(function (result) {
	    			vm.getApprovalFlow()
	    			vm.dialogVisible = false
	    			 vm.remark=""
		    	  }, function () {
		    	  })
		    },
		    // 撤销审批
		    abandon(operation){
		    	var vm = this
		    	 vm.loading[operation] = true
		          this.$confirm(`是否${operation === 'cancel' ? '作废审批' : '撤销' + (operation === 'abandon' ? '审批' : '提交')}？${operation === 'cancel' ? '(该操作不可撤销)' : ''}`, '请确认', {
		            confirmButtonText: '确定',
		            cancelButtonText: '取消',
		            type: 'warning'
		          }).then(() => {
		            ajax.post('/approval/' + operation, {approvalItemId: this.itemId,state:this.flow.state}).then(() => {
		              vm.refreshFlow()
		              vm.loading[operation] = false
		            }, () => {
		            	vm.refreshFlow()
		            	vm.loading[operation] = false
		            })
		          }, () => {
		            vm.loading[operation] = false
		          })
		    },
		    fomatFlow(){
		    	let vm = this
		    	let approvalItemId = vm.itemId
		    	let module = vm.flow.module
		    	ajax.post('/approval/findAllProcess',{approvalItemId:approvalItemId,module:module}).then(function (result) {
 		    		  if (result.data) {
 		    			
 		    			vm.approvalInfo = result.data
 		    		  }
 		    	  }, function () {
 		    	  })
		    }
		  },
		  mounted () {
			  this.$emit('input', this.flow)
			
		  }
	}
})