import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import shengfen from '@/views/modules/shengfen/list'
    import aboutus from '@/views/modules/aboutus/list'
    import jingdianleixing from '@/views/modules/jingdianleixing/list'
    import discusslvyoujihua from '@/views/modules/discusslvyoujihua/list'
    import jingdianxinxi from '@/views/modules/jingdianxinxi/list'
    import discussjiudianxinxi from '@/views/modules/discussjiudianxinxi/list'
    import jiudianxinxi from '@/views/modules/jiudianxinxi/list'
    import discussmeishixinxi from '@/views/modules/discussmeishixinxi/list'
    import jingdianmenpiao from '@/views/modules/jingdianmenpiao/list'
    import meishifenlei from '@/views/modules/meishifenlei/list'
    import forum from '@/views/modules/forum/list'
    import systemintro from '@/views/modules/systemintro/list'
    import yonghu from '@/views/modules/yonghu/list'
    import lvyoujihua from '@/views/modules/lvyoujihua/list'
    import piaowuleixing from '@/views/modules/piaowuleixing/list'
    import discussjingdianxinxi from '@/views/modules/discussjingdianxinxi/list'
    import meishixinxi from '@/views/modules/meishixinxi/list'
    import jiudianyuding from '@/views/modules/jiudianyuding/list'
    import config from '@/views/modules/config/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '旅游资讯',
        component: news
      }
      ,{
	path: '/shengfen',
        name: '省份',
        component: shengfen
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/jingdianleixing',
        name: '景点类型',
        component: jingdianleixing
      }
      ,{
	path: '/discusslvyoujihua',
        name: '旅游计划评论',
        component: discusslvyoujihua
      }
      ,{
	path: '/jingdianxinxi',
        name: '景点信息',
        component: jingdianxinxi
      }
      ,{
	path: '/discussjiudianxinxi',
        name: '酒店信息评论',
        component: discussjiudianxinxi
      }
      ,{
	path: '/jiudianxinxi',
        name: '酒店信息',
        component: jiudianxinxi
      }
      ,{
	path: '/discussmeishixinxi',
        name: '美食信息评论',
        component: discussmeishixinxi
      }
      ,{
	path: '/jingdianmenpiao',
        name: '景点门票',
        component: jingdianmenpiao
      }
      ,{
	path: '/meishifenlei',
        name: '美食分类',
        component: meishifenlei
      }
      ,{
	path: '/forum',
        name: '旅游论坛',
        component: forum
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/lvyoujihua',
        name: '旅游计划',
        component: lvyoujihua
      }
      ,{
	path: '/piaowuleixing',
        name: '票务类型',
        component: piaowuleixing
      }
      ,{
	path: '/discussjingdianxinxi',
        name: '景点信息评论',
        component: discussjingdianxinxi
      }
      ,{
	path: '/meishixinxi',
        name: '美食信息',
        component: meishixinxi
      }
      ,{
	path: '/jiudianyuding',
        name: '酒店预订',
        component: jiudianyuding
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/newstype',
        name: '旅游资讯分类',
        component: newstype
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
