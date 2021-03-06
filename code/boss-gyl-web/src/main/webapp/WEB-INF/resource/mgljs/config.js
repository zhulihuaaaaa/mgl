/**
 * ==============
 * 前端模块配置文件
 * ==============
 * @author 詹小灰@461632311
 * @editor Spark
 */
 
var mgljs = {
    base : ctx,
    lib : "./mgljs/lib/",
    css : "./mgljs/css/",
    plugin : './js/plugin/' 
}; 

/*var mgljs = {
    base : "./mgljs",
    lib : "./lib/",
    css : "../mgljs/css/"
};*/

require.config({
    baseUrl: mgljs.base,
    paths: {
        'jquery': [mgljs.lib + 'jquery.min'],
        'css': mgljs.lib + 'css.min',
        'util': mgljs.base + '/mgljs/app/util',
        //上传
        'uploadFile': mgljs.base + '/mgljs/app/uploadFile',
        //日期选择器
        'datepicker': mgljs.lib + 'datepicker.min',
        //slide切换
        'swiper': mgljs.lib + 'swiper.jquery.min',
        //图片预览
        'imagesGrid': mgljs.lib + 'images.grid',
        //上传文件
        'jqFiler': mgljs.lib + 'jquery.filer',
        //消息提示
        'dialog': mgljs.lib + 'dialog',
        //select多选
        'select': mgljs.lib + 'select2.min',
        //distpicker地区联动
        'cityJSON': mgljs.lib + 'cityJSON',
        'city': mgljs.lib + 'distpicker',
        //validate表单验证
        'validate': mgljs.lib + 'jquery.validate',
        //富文本
        'editor': mgljs.lib + 'trumbowyg.min',
        //cookie操作
        'cookie': mgljs.lib + 'js.cookie',
        //Dom加载
        'domReady': mgljs.lib + 'domReady',
        //输入格式化
        'inputformat':  mgljs.lib + 'cleave',
        //拖动滑块
        'drag':  mgljs.lib + 'jquery.slideunlock',
        //中文转换成英文首字母
        'charfirst':  mgljs.lib + 'jquery.charfirst',
        //按字母排序筛选
        'listnav':  mgljs.lib + 'jquery.listnav',
        //列表筛选条件选择
        'mallList':  mgljs.lib + 'mgl.mall',
        //根据div打印页面
        'jqprint':  mgljs.lib + 'jquery.jqprint',
        //自定义的滚动条
        'mScrollbar':  mgljs.lib + 'jquery.mCustomScrollbar',
        //datatable主js
        'datatables':  mgljs.lib + 'datatables',
        //datatable - 固定行列插件
        'datatables-fixed':  mgljs.lib + 'dataTables.fixedColumns',
        //生成二维码
        'qrcode': mgljs.lib + 'qrcode',
        //copy
        'clipboard': mgljs.lib + 'clipboard',
        /*	GYL使用JS	*/
        //封装Ajax
        'ajax': './js/common/AjaxUtils',
        //表格组件
        'component-table': './js/plugin/component-table',
        //下拉组件
        'component-select': './js/plugin/component-select',
        //图片组件
        'component-images': './js/plugin/component-image',
        //Excel导入
        'component-import': './js/plugin/component-import',
        //侧边栏详情组件
        'component-slide': './js/plugin/component-slide',
        // 过滤tableColumn
        'mix-table': './js/plugin/mix-table',
        // 自定义列组件
        'custom-table-column': './js/plugin/custom-table-column',
        // 拖拽组件
        'vue-dragging': './js/plugin/vue-dragging',
        // 表单转JSON
        'jquery-serialize': './js/plugin/jquery-serialize',
        // 上传
        'component-upload': './js/plugin/component-upload',
        // 审批按钮
        'component-approval-btn': './js/plugin/approval/component-approval-btn',
        // 计算费用
        'computed-fee': './js/plugin/computed-fee'
    },
    shim: {
        'jquery': {
            exports: '$'
        },
        'util': {
            exports: 'util',
            deps: ['jquery']
        },
        'datepicker': {
            exports: '',
            deps: ['jquery']
        },
        'swiper': {
            exports: '$',
            deps: ['jquery', 'css!'+ mgljs.css +'swiper.css']
        },
        'imagesGrid': {
            exports: 'imagesGrid',
            deps: ['jquery', 'css!'+ mgljs.css +'images-grid.css']
        },
        'jqFiler': {
            exports: 'jqFiler',
            deps: ['jquery', 'css!'+ mgljs.css +'jquery.filer.css']
        },
        'dialog': {
            exports: 'dialog',
            deps: ['jquery', 'css!'+ mgljs.css +'ui-dialog.css']
        },
        'select': {
            exports: '$',
            deps: ['jquery', 'css!'+ mgljs.css +'select2.css']
        },
        'city': {
            exports: 'distpicker',
            deps: ['select', 'cityJSON']
        },
        'validate': {
            exports: '$',
            deps: ['jquery']
        },
        'editor': {
            exports: 'trumbowyg',
            deps: ['jquery', 'css!'+ mgljs.css +'trumbowyg.css']
        },
        'cookie': {
            exports: 'cookie'
        },
        'drag': {
            deps: ['jquery']
        },
        'listnav': {
            deps: ['jquery', 'charfirst']
        },
        'mallList': {
            deps: ['jquery', 'css!'+ mgljs.css +'mgl.mall.css']
        },
        'jqprint': {
            exports: '',
            deps: ['jquery']
        },
        'mScrollbar': {
            exports: '$',
            deps: ['jquery', 'css!'+ mgljs.css +'jquery.mCustomScrollbar.css']
        },
        'datatables': {
            exports: '$',
            deps: ['jquery', 'css!'+ mgljs.css +'datatables.css']
        },
        'datatables-fixed': {
            exports: '$',
            deps: ['jquery', 'datatables']
        },
        'qrcode': {
            exports: '',
            deps: ['jquery']
        },
        'clipboard': {
            exports: '',
            deps: ['jquery']
        },
        'ajax': {
        	exports: 'ajax',
        	deps: ['jquery']
        },
        'jquery-serialize': {
        	exports: '$',
        	deps: ['jquery']
        }
    }
});
