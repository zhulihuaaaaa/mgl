/**
 * 下拉列表组件
 * 
 * @returns
 */
define(['ajax','util'], function (ajax,util) {
	return {
		name: 'component-images',
		template: `
			<div :class="[selector, singleClass]"></div>
		`,
		props: {
			/**
			 * 附件列表
			 */
			data: {
				type: [Array, Object]
			},
			/**
			 * class 选择器
			 */
			selector:{
				type:String,
				default: 'images-grid'
			},
			/**
			 * 标题
			 */
			title:{
				type:String,
				required: true
			}
		},
		data () {
			return {
				//文件服务器的地址
				baseUrl: showGylImage + '/'
			}
		},
		computed: {
			imageUrls () {
				let data = this.data instanceof Array ? this.data : [this.data]
				return this.fomat(data)
			},
			singleClass () {
				return 'img-grid-' + util.guid()
			}
		},
		watch: {
			data: {
				handler: function(val, old) {
					let s = '.' + this.singleClass
					let vm = this
					var options={
						// 挂载点
						selector: s ,
						// 页面路径数组
				        images: this.imageUrls,
				        // 显示几张
				        cells: 2,
				        align: true,
				        nextOnClick: true,
				        bgClose: true,
				        getViewAllText: function(imagesCount) {
				          	return '查看全部 ' + imagesCount + '张';
				        }
					}
					 vm.$nextTick(function () {
						 util.imagesGrid(options)
					 })
				},
				deep: true
			}
		},
		methods: {
			fomat(one){
				var three = []
				for(var i  in one){
					let two = {
						// 图片路径 由文件服务器路径跟 文件名组成
//						 src: one[i].filePath,
						src: this.baseUrl + one[i].fileName,
						// 图片名 
						title: one[i].fileName,
						// 标题
						caption: this.title
					}
					three.push(two)
				}
				
				return three;
			}
		},
		mounted () {
			let s = '.' + this.singleClass
			let vm = this
			var options={
				// 挂载点
				selector: s ,
				// 页面路径数组
		        images: this.imageUrls,
		        // 显示几张
		        cells: 2,
		        
		        align: true,
		        nextOnClick: true,
		        bgClose: true,
		        getViewAllText: function(imagesCount) {
		          	return '查看全部 ' + imagesCount + '张';
		        }
			}
			 vm.$nextTick(function () {
				 util.imagesGrid(options)
			 })
		}
	}
})