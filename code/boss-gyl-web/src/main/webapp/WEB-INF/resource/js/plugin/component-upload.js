/**
 * 上传组件
 * @author 汪玮琦
 * @since 2017.12.15
 * @returns
 */
define([], function () {
	return {
		name: 'component-upload',
		template: `
			<el-upload
			  class="form-upload"
			  ref="upload"
			  :file-list="fileList"
			  :data="params"
			  :multiple="multiple"
			  :action="action"
			  :accept="accept"
			  name="file"
			  :on-success="handleSuccess"
			  :on-error="handleError"
			  :before-upload="handleBeforeUpload"
			  :auto-upload="autoUpload"
			  :on-change="fileChange"
			  :on-remove="onRemove">
			  <el-button slot="trigger" size="small" type="success">选取文件</el-button>
			</el-upload>
		`,
		props: {
			// 是否自动上传
			autoUpload: {
				type: Boolean,
				default: false
			},
			accept: {
				type: String,
				default: 'image/gif,image/jpeg'
			},
			multiple: {
				type: Boolean,
				default: false
			},
			uploadData: [String, Number, Object],
			fileList: Array
		},
		data () {
			return {
				action: ctx + "/base/upload",
				params: {data: null}
			}
		},
		methods: {
			submitUpload() {
		        this.$refs.upload.submit();
		    },
		    handleSuccess(response, file, fileList) {
		    	this.$emit('success', response)
		    	this.$emit('update:uploading', false)
		    },
		    fileChange(file, fileList) {
		    	if (!this.multiple) {
		    		if (fileList.length > 1) {
		    			fileList.splice(0, 1)
		    		}
		    	}
		    	this.$emit('change', fileList.length)
		    	this.$emit('change-file', fileList)
		    },
		    onRemove (file, fileList) {
		    	this.$emit('remove', file)
		    },
		    handleBeforeUpload (file) {
		    	this.$emit('update:uploading', true)
		    },
		    handleError () {
		    	this.$emit('update:uploading', false)
		    }
		},
		mounted() {
			this.params = {
				data:  this.uploadData 
			}
		}
	}
})