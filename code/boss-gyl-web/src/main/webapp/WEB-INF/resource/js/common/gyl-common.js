/**
 * 供应链系统通用方法
 * @author 张渊
 * @since 2017.12.12
 */
require(['component-upload'], function (componentUpload) {
	Vue.component('component-upload', componentUpload)
})
require(['component-select'], function (componentSelect) {
	Vue.component('component-select', componentSelect)
})
require(['component-approval-btn'], function (componentSelect) {
	Vue.component('component-approval-btn', componentSelect)
})
require(['component-images'], function (componentImages) {
	Vue.component('component-images', componentImages)
})
require(['component-import'], function (componentImport) {
	Vue.component('component-import', componentImport)
})