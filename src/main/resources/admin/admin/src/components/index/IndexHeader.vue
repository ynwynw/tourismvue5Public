<template>
	<div class="navbar">
		<div class="title" :style='{"alignItems":"center","left":"20px","display":"flex","width":"auto","position":"absolute","order":"0","height":"100%"}'>
			<el-image v-if="false" class="title-img" :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover" />
			<span class="title-name" :style='{"padding":"0 0 0 12px","fontSize":"24px","color":"#000000","float":"left","fontWeight":"700"}'>{{this.$project.projectName}}</span>
		</div>
		<!--
		<div class="right" :style='{"position":"absolute","right":"20px","top":"8px","display":"flex"}'>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#333"}' class="nickname">{{this.$storage.get('role')}} {{this.$storage.get('adminName')}}</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#666"}' v-if="this.$storage.get('role')!='管理员'" class="logout" @click="onIndexTap">退出到前台</div>
			<div :style='{"cursor":"pointer","margin":"0 5px","lineHeight":"44px","color":"#666"}' class="logout" @click="onLogout">退出登录</div>
		</div>
		-->
		
		<el-dropdown @command="handleCommand" trigger="click" :style='{"fontSize":"14px","position":"absolute","right":"20px","color":"#666","display":"flex"}'>
		  <div class="el-dropdown-link" :style='{"alignItems":"center","display":"flex"}'>
		    <el-image v-if="user" :style='{"width":"32px","margin":"0 10px","objectFit":"cover","display":"inline-block","height":"32px"}' :src="avatar?this.$base.url + avatar : require('@/assets/img/avator.png')" fit="cover"></el-image>
		    <span :style='{"lineHeight":"32px","fontSize":"14px","color":"#000000","fontWeight":"400"}'>{{this.$storage.get('adminName')}}</span>
		    <span class="icon iconfont icon-xiala" :style='{"color":"#666","margin":"0 0 0 5px","fontSize":"14px"}'></span>
		  </div>
		  <el-dropdown-menu class="top-el-dropdown-menu" slot="dropdown">
		    <el-dropdown-item class="item1" :command="''">首页</el-dropdown-item>
		    <el-dropdown-item class="item2" :command="'center'">个人中心</el-dropdown-item>
		    <el-dropdown-item v-if="changeHasChat()" class="item6" :command="'chat'">聊天记录</el-dropdown-item>
		    <el-dropdown-item v-if="this.$storage.get('role')!='管理员'" class="item3" :command="'front'">退出到前台</el-dropdown-item>
		    <el-dropdown-item class="item4" :command="'logout'">退出登录</el-dropdown-item>
		  </el-dropdown-menu>
		</el-dropdown>
		<el-dialog :visible.sync="recordVisible" :title="'聊天记录'" :append-to-body="true">
			<div class="z-box" :style='{"width":"70%","padding":"20px","margin":"0 auto"}'>
				<div class="section-content" v-for="item in recordList" :key="item.id" @click="chatClick(item)">
					<img :src="item.picture?$base.url + item.picture:require('@/assets/img/avator.png')" style="width: 60px;border-radius: 50%;"
						alt="">
					<div style="margin: 0 0 0 10px;display: flex;flex-direction: column;align-items: flex-start;">
						<div :style='{"fontSize":"14px","color":"#000","flex":"1","fontWeight":"bold"}'
							class="item-style">{{item.name}}</div>
						<div :style='{"color":"#666","flex":"1","fontSize":"14px","lineHeight":"1.5","display":"flex","alignItems":"center"}'
							class="item-style">
							<div v-if="item.notreadnum" style="padding: 0 5px;height: 16px;border-radius: 50%;text-align: center;line-height: 16px;font-size: 12px;background: #f00;color:#fff;width: auto;margin: 0 2px 0 0">{{item.notreadnum}}</div>
							{{item.content.split('/').length&&item.content.split('/')[0]=='upload'?'[图片]':item.content}}
						</div>
					</div>
				</div>
				<div class="noList" v-if="!recordList.length">
					暂无聊天记录
				</div>
			</div>
		</el-dialog>
		<el-dialog :visible.sync="chatVisible" @close="clearChat" :title="nowname" :append-to-body="true">
			<div class="chat-content" id="chat-content">
				<div v-bind:key="item.id" v-for="item in chatList">
					<div v-if="item.uid==myid" class="right-content">
						<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
							type="warning"></el-alert>
						<el-image v-else fit="cover" :src="item.content?$base.url + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?$base.url + item.content:'']"></el-image>
						<img :src="avatar?$base.url + avatar:require('@/assets/img/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 0 0 10px;" />
					</div>
					<div v-else class="left-content">
						<img :src="nowfpic?$base.url + nowfpic:require('@/assets/img/avator.png')" alt="" style="width: 30px;border-radius: 50%;height: 30px;margin: 0 10px 0 0;" />
						<el-alert v-if="item.format==1" class="text-content" :title="item.content" :closable="false"
							type="success"></el-alert>
						<el-image v-else fit="cover" :src="item.content?$base.url + item.content:''" style="width: 100px;height: 100px;" :preview-src-list="[item.content?$base.url + item.content:'']"></el-image>
					</div>
					<div class="clear-float"></div>
				</div>
			</div>
			<div slot="footer" class="dialog-footer">
				<el-input @keydown.enter.native="addChat" v-model="chatForm.content" placeholder="请输入内容" style="width: calc(100% - 180px);float: left;">
				</el-input>
				<el-button :disabled="chatForm.content?false:true" type="primary" @click="addChat">发送</el-button>
				<el-upload style="display: inline-block;margin: 0 0 0 6px;" class="upload-demo" :action="uploadUrl" :on-success="uploadSuccess"
				    :show-file-list="false">
				    <el-button type="success">上传图片</el-button>
				</el-upload>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		data() {
			return {
				dialogVisible: false,
				ruleForm: {},
				user: null,
				recordList: [],
				recordVisible: false,
				chatVisible: false,
				nowfid: 0,
				nowfpic:'',
				nowname: '',
				chatList: [],
				chatForm: {
					content: ''
				},
				chatTimer: null,
				uploadUrl: this.$base.url + 'file/upload',
				hasChatList: [
					'yonghu',
				],
			};
		},
		created() {
		},
		computed: {
			avatar(){
				return this.$storage.get('headportrait')?this.$storage.get('headportrait'):''
			},
			myid(){
				return this.$storage.get('userid')?this.$storage.get('userid'):''
			},
		},
		mounted() {
			let sessionTable = this.$storage.get("sessionTable")
			this.$http({
				url: sessionTable + '/session',
				method: "get"
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
					if(sessionTable == 'yonghu') {
						this.$storage.set('headportrait',data.data.touxiang)
					}
					if(sessionTable == 'users') {
						this.$storage.set('headportrait',data.data.image)
					}
					this.$storage.set('userForm',JSON.stringify(data.data))
					this.user = data.data;
					this.$storage.set('userid',data.data.id);
				} else {
					let message = this.$message
					message.error(data.msg);
				}
			});
		},
		methods: {
			changeHasChat(){
				let table = this.$storage.get('sessionTable')
				for(let x in this.hasChatList){
					if(this.hasChatList[x]==table){
						return true
					}
				}
				return false
			},
			handleCommand(name) {
				if (name == 'front') {
					this.onIndexTap()
				} else if (name == 'logout') {
					this.onLogout()
				} else if (name == 'board'){
					this.toBoard()
				} else if (name == 'backUp'){
					this.backUp()
				} 
				else if (name == 'chat'){
					this.getRecordList()
				}
				else {
					let router = this.$router
					name = '/'+name
					router.push(name)
				}
			},
			getRecordList() {
				this.$http.get('friend/page2', {
					params: {
						uid: this.$storage.get('userid'),
						type: 2
					}
				}).then(res => {
					if (res.data && res.data.code == 0) {
						this.recordList = res.data.data.list
						this.recordVisible = true
					}
				})
			},
			chatClick(row) {
				this.nowfid = row.fid
				this.nowfpic = row.picture
				this.nowname = row.name
				this.getChatList()
				this.chatVisible = true
			},
			getChatList() {
				this.$http.get('chatmessage/mlist', {
					params: {
						page: 1,
						limit: 1000,
						uid: this.$storage.get('userid'),
						fid: this.nowfid
					}
				}).then(res => {
					if (res.data && res.data.code == 0) {
						this.chatList = res.data.data.list
						let div = document.getElementsByClassName('chat-content')[0]
						setTimeout(() => {
							if (div)
								div.scrollTop = div.scrollHeight
						}, 0)
						this.chatTimer = setTimeout(() => {
							this.getChatList()
						}, 5000)
					}
				})
			},
			clearChat(){
				clearTimeout(this.chatTimer)
				this.chatList = []
				this.getRecordList()
			},
			uploadSuccess(res) {
				if (res.code == 0) {
					clearTimeout(this.chatTimer)
					this.$http.post('chatmessage/add', {
						uid: this.$storage.get('userid'),
						fid: this.nowfid,
						content: 'upload/' + res.file,
						format: 2
					}).then(res2 => {
						this.chatForm = {
							content: ''
						}
						this.getChatList()
					})
				}
			},
			addChat() {
				clearTimeout(this.chatTimer)
				this.$http.post('chatmessage/add', {
					uid: this.$storage.get('userid'),
					fid: this.nowfid,
					content: this.chatForm.content,
					format: 1
				}).then(res2 => {
					this.chatForm = {
						content: ''
					}
					this.getChatList()
				})
			},
			onLogout() {
				let storage = this.$storage
				let router = this.$router
				storage.clear()
				this.$store.dispatch('tagsView/delAllViews')
				router.replace({
					name: "login"
				});
			},
			onIndexTap(){
				window.location.href = `${this.$base.indexUrl}`
			},
		}
	};
</script>


<style lang="scss" scoped>
	.top-el-dropdown-menu {
				border: 1px solid #EBEEF5;
				border-radius: 4px;
				padding: 10px 0;
				box-shadow: 0 2px 12px 0 rgba(0,0,0,.1);
				margin: 18px 0;
				background: #FFF;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item1 {
				cursor: pointer;
				padding: 0 20px;
				margin: 0;
				outline: 0;
				color: #606266;
				background: #fff;
				font-size: 14px;
				line-height: 36px;
				list-style: none;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item1:hover {
				background: #ecf5ff;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item2 {
				cursor: pointer;
				padding: 0 20px;
				margin: 0;
				outline: 0;
				color: #606266;
				background: #fff;
				font-size: 14px;
				line-height: 36px;
				list-style: none;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item2:hover {
				background: #ecf5ff;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item3 {
				cursor: pointer;
				padding: 0 20px;
				margin: 0;
				outline: 0;
				color: #606266;
				background: #fff;
				font-size: 14px;
				line-height: 36px;
				list-style: none;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item3:hover {
				background: #ecf5ff;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item4 {
				cursor: pointer;
				padding: 0 20px;
				margin: 0;
				outline: 0;
				color: #606266;
				background: #fff;
				font-size: 14px;
				line-height: 36px;
				list-style: none;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item4:hover {
				background: #ecf5ff;
			}
	.top-el-dropdown-menu li.el-dropdown-menu__item.item5 {
				cursor: pointer;
				padding: 0 20px;
				margin: 0;
				outline: 0;
				color: #606266;
				background: #fff;
				font-size: 14px;
				line-height: 36px;
				list-style: none;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item5:hover {
				background: #ecf5ff;
			}
	.top-el-dropdown-menu li.el-dropdown-menu__item.item6 {
				cursor: pointer;
				padding: 0 20px;
				margin: 0;
				outline: 0;
				color: #606266;
				background: #fff;
				font-size: 14px;
				line-height: 36px;
				list-style: none;
			}
	
	.top-el-dropdown-menu li.el-dropdown-menu__item.item6:hover {
				background: #ecf5ff;
			}
	.section-content {
		cursor: pointer;
		padding: 20px;
		box-shadow: 0px 4px 10px 0px rgba(0, 0, 0, 0.3);
		margin: 0 0 20px;
		color: #333;
		background: #fff;
		display: flex;
		width: 100%;
		border-color: #efefef;
		border-width: 0;
		align-items: center;
		border-style: solid;
		position: relative;
	}
	
	.section-content:hover {
		color: #fff;
		background: #DF847F10;
	}
	.chat-content {
		padding-bottom: 20px;
		width: 100%;
		margin-bottom: 10px;
		max-height: 300px;
		height: 300px;
		overflow-y: scroll;
		border: 1px solid #eeeeee;
		background: #fff;
	
		.left-content {
			float: left;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	
		.right-content {
			float: right;
			margin-bottom: 10px;
			padding: 10px;
			max-width: 80%;
			display: flex;
			align-items: center;
		}
	}
	
	.clear-float {
		clear: both;
	}
	.noList {
		color: #9e9e9e;
		width: 100%;
		text-align: center;
		padding: 60px 0;
	}
</style>
