import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import shengfenList from '../pages/shengfen/list'
import shengfenDetail from '../pages/shengfen/detail'
import shengfenAdd from '../pages/shengfen/add'
import meishifenleiList from '../pages/meishifenlei/list'
import meishifenleiDetail from '../pages/meishifenlei/detail'
import meishifenleiAdd from '../pages/meishifenlei/add'
import jingdianleixingList from '../pages/jingdianleixing/list'
import jingdianleixingDetail from '../pages/jingdianleixing/detail'
import jingdianleixingAdd from '../pages/jingdianleixing/add'
import piaowuleixingList from '../pages/piaowuleixing/list'
import piaowuleixingDetail from '../pages/piaowuleixing/detail'
import piaowuleixingAdd from '../pages/piaowuleixing/add'
import jingdianxinxiList from '../pages/jingdianxinxi/list'
import jingdianxinxiDetail from '../pages/jingdianxinxi/detail'
import jingdianxinxiAdd from '../pages/jingdianxinxi/add'
import jingdianmenpiaoList from '../pages/jingdianmenpiao/list'
import jingdianmenpiaoDetail from '../pages/jingdianmenpiao/detail'
import jingdianmenpiaoAdd from '../pages/jingdianmenpiao/add'
import meishixinxiList from '../pages/meishixinxi/list'
import meishixinxiDetail from '../pages/meishixinxi/detail'
import meishixinxiAdd from '../pages/meishixinxi/add'
import jiudianxinxiList from '../pages/jiudianxinxi/list'
import jiudianxinxiDetail from '../pages/jiudianxinxi/detail'
import jiudianxinxiAdd from '../pages/jiudianxinxi/add'
import jiudianyudingList from '../pages/jiudianyuding/list'
import jiudianyudingDetail from '../pages/jiudianyuding/detail'
import jiudianyudingAdd from '../pages/jiudianyuding/add'
import lvyoujihuaList from '../pages/lvyoujihua/list'
import lvyoujihuaDetail from '../pages/lvyoujihua/detail'
import lvyoujihuaAdd from '../pages/lvyoujihua/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussjingdianxinxiList from '../pages/discussjingdianxinxi/list'
import discussjingdianxinxiDetail from '../pages/discussjingdianxinxi/detail'
import discussjingdianxinxiAdd from '../pages/discussjingdianxinxi/add'
import discussmeishixinxiList from '../pages/discussmeishixinxi/list'
import discussmeishixinxiDetail from '../pages/discussmeishixinxi/detail'
import discussmeishixinxiAdd from '../pages/discussmeishixinxi/add'
import discussjiudianxinxiList from '../pages/discussjiudianxinxi/list'
import discussjiudianxinxiDetail from '../pages/discussjiudianxinxi/detail'
import discussjiudianxinxiAdd from '../pages/discussjiudianxinxi/add'
import discusslvyoujihuaList from '../pages/discusslvyoujihua/list'
import discusslvyoujihuaDetail from '../pages/discusslvyoujihua/detail'
import discusslvyoujihuaAdd from '../pages/discusslvyoujihua/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'shengfen',
					component: shengfenList
				},
				{
					path: 'shengfenDetail',
					component: shengfenDetail
				},
				{
					path: 'shengfenAdd',
					component: shengfenAdd
				},
				{
					path: 'meishifenlei',
					component: meishifenleiList
				},
				{
					path: 'meishifenleiDetail',
					component: meishifenleiDetail
				},
				{
					path: 'meishifenleiAdd',
					component: meishifenleiAdd
				},
				{
					path: 'jingdianleixing',
					component: jingdianleixingList
				},
				{
					path: 'jingdianleixingDetail',
					component: jingdianleixingDetail
				},
				{
					path: 'jingdianleixingAdd',
					component: jingdianleixingAdd
				},
				{
					path: 'piaowuleixing',
					component: piaowuleixingList
				},
				{
					path: 'piaowuleixingDetail',
					component: piaowuleixingDetail
				},
				{
					path: 'piaowuleixingAdd',
					component: piaowuleixingAdd
				},
				{
					path: 'jingdianxinxi',
					component: jingdianxinxiList
				},
				{
					path: 'jingdianxinxiDetail',
					component: jingdianxinxiDetail
				},
				{
					path: 'jingdianxinxiAdd',
					component: jingdianxinxiAdd
				},
				{
					path: 'jingdianmenpiao',
					component: jingdianmenpiaoList
				},
				{
					path: 'jingdianmenpiaoDetail',
					component: jingdianmenpiaoDetail
				},
				{
					path: 'jingdianmenpiaoAdd',
					component: jingdianmenpiaoAdd
				},
				{
					path: 'meishixinxi',
					component: meishixinxiList
				},
				{
					path: 'meishixinxiDetail',
					component: meishixinxiDetail
				},
				{
					path: 'meishixinxiAdd',
					component: meishixinxiAdd
				},
				{
					path: 'jiudianxinxi',
					component: jiudianxinxiList
				},
				{
					path: 'jiudianxinxiDetail',
					component: jiudianxinxiDetail
				},
				{
					path: 'jiudianxinxiAdd',
					component: jiudianxinxiAdd
				},
				{
					path: 'jiudianyuding',
					component: jiudianyudingList
				},
				{
					path: 'jiudianyudingDetail',
					component: jiudianyudingDetail
				},
				{
					path: 'jiudianyudingAdd',
					component: jiudianyudingAdd
				},
				{
					path: 'lvyoujihua',
					component: lvyoujihuaList
				},
				{
					path: 'lvyoujihuaDetail',
					component: lvyoujihuaDetail
				},
				{
					path: 'lvyoujihuaAdd',
					component: lvyoujihuaAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussjingdianxinxi',
					component: discussjingdianxinxiList
				},
				{
					path: 'discussjingdianxinxiDetail',
					component: discussjingdianxinxiDetail
				},
				{
					path: 'discussjingdianxinxiAdd',
					component: discussjingdianxinxiAdd
				},
				{
					path: 'discussmeishixinxi',
					component: discussmeishixinxiList
				},
				{
					path: 'discussmeishixinxiDetail',
					component: discussmeishixinxiDetail
				},
				{
					path: 'discussmeishixinxiAdd',
					component: discussmeishixinxiAdd
				},
				{
					path: 'discussjiudianxinxi',
					component: discussjiudianxinxiList
				},
				{
					path: 'discussjiudianxinxiDetail',
					component: discussjiudianxinxiDetail
				},
				{
					path: 'discussjiudianxinxiAdd',
					component: discussjiudianxinxiAdd
				},
				{
					path: 'discusslvyoujihua',
					component: discusslvyoujihuaList
				},
				{
					path: 'discusslvyoujihuaDetail',
					component: discusslvyoujihuaDetail
				},
				{
					path: 'discusslvyoujihuaAdd',
					component: discusslvyoujihuaAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
