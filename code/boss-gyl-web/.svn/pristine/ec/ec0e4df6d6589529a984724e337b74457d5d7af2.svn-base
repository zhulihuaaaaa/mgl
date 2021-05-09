/**
 * 导入Excel
 * @returns
 */
define(['ajax','util'], function () {
	return {
		name: 'component-import',
		template: `
			<el-upload type="button"  :action="action" :show-file-list="false"  :on-success="handleSuccess">导入</el-upload>
		`,
		props: {
			/**
			 * insInspection 验货 
			 */
			type: {
				type: String,
				required: true
			},
			accept: {
				type: String,
			}
		},
		data () {
			return {
				action: '',
				showFile: false
			}
		},
		methods: {
		    handleSuccess(response, file, fileList) {
//		    	console.log("response", response)
		    	if(response.state === 0) {
		    		util.promptMsg({
						type: 'tip',
						modal: false,
						content: '文件导入失败'
					})
		    	} else if (response.state === 1) {
		    		this.$emit('success', response)
		    	}
		    }
		},
		mounted() {
			let url = ctx 
			if (this.type == 'insInspection') {
				url += '/import/insInspection'
			} else if (this.type == 'contract') {
				url += '/import/contract'
			}
			this.action = url
		}
	}
})