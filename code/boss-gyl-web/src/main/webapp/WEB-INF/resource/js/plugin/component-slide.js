/**
 * 侧边栏详情组件
 * @author 张渊
 * @since 2017.12.13
 * @returns
 */
define(['ajax', 'util'], function (ajax, util) {
	return {
		name: 'component-slide',
		template: `
			<div><slot></slot></div>
		`,
		props: {
			/**
			 * 主数据ID
			 */
			id: {
				type: String,
				required: true
			},
			/**
			 * 侧边栏挂载元素
			 */
			selector: {
				type: String
			},
			/**
			 * 显示状态
			 */
			show: {
				type: Boolean,
				required: true
			},
			/**
			 * 侧边栏数据
			 */
			tabData: {
				type: Array
			},
			/**
			 * 当前激活tab索引
			 */
			activeIndex: {
				type: Number,
				required: true
			}
		},
		data () {
			return {
			}
		},
		computed: {
			slide () {
				return this.selector != null ? this.selector : '#slideEidt'
			},
			showTemp: {
				get () {
					return this.show
				},
				set (val) {
					this.$emit('update:show', val)
				}
			},
			tabDataTemp: {
				get () {
					return this.tabData
				},
				set (val) {
					this.$emit('update:tabData', val)
				}
			},
			activeIndexTemp: {
				get () {
					return this.activeIndex
				},
				set (val) {
					this.$emit('update:activeIndex', val)
				}
			}
		},
		watch: {
			show: {
				handler: function (val) {
					var vm = this
					if (val) {
						$(vm.slide + ' .scroll-tab li').eq(0).click()
						// 点击停止冒泡，隐藏侧边页面
						$(".main-content, .ui-header").on("click", vm.toggleSlideFun)
						vm.$nextTick(function () {
							$(vm.slide).animate({
								right: 0
							}, 300)
						})
					} else {
						vm.activeIndexTemp = 0
						vm.tabDataTemp = []
						$(".main-content, .ui-header").off("click", vm.toggleSlideFun)
						// 关闭隐藏侧边页
						$(vm.slide).animate({
							right: -1010
						}, 300)
					}
				},
				immediate: true
			},
			id (val, old) {
				this.$emit('fetch-data', this.activeIndex)
			}
		},
		methods: {
			/**
			 * 侧边栏切换事件
			 * @param event
			 * @returns
			 */
			toggleSlideFun (event) {
				var vm = this
				if($(event.target).closest(".el-table__row").length == 0){
					vm.showTemp = false
					event.stopPropagation();
				}
			}
		},
		mounted () {
			var vm = this
			util.swiperTab({
				containerClass: vm.slide + ' .tab-container',
				// 禁用鼠标拖拽切换
				onlyExternal: true,
				change: function (index) {
					if (!vm.tabData[index]) {
						vm.$emit('fetch-data', index)
					}
					vm.activeIndexTemp = index
				}
			})
			$('.slide-close').on('click', function () {
				vm.showTemp = false
			})
		}
	}
})