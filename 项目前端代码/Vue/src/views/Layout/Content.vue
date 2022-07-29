<template>
  <div class="content">
    <div class="header">

       <i v-if="!isCollapse" @click="changeMenu" class="iconfont el-icon-s-fold"></i>
       <i v-else @click="changeMenu" class="iconfont el-icon-s-unfold"></i>
       <div class="ueser">
         <el-dropdown>
           <el-avatar shape="square" :size="32" :src="circleUrl"></el-avatar>
           <el-dropdown-menu slot="dropdown">
             <el-dropdown-item>
               <span @click="gootherpage">个人信息</span>
             </el-dropdown-item>
             <el-dropdown-item>
               <span @click="loginout">退出</span>
             </el-dropdown-item>

           </el-dropdown-menu>
         </el-dropdown>

      </div>
    </div>
    <div class="content1">
      <router-view/>
    </div>

  </div>

</template>

<script>
import {mapState,mapMutations} from 'vuex'


export default {
  props:['isCollapse'],
  data(){
    return{
      circleUrl:"https://img1.baidu.com/it/u=671076267,3648872689&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500"
    }
  },
  computed:{
    ...mapState('loginModule',['userinfo'])
  },
  methods:{
    ...mapMutations('loginModule',['clearUser']),
    changeMenu(){
      this.$emit('changeCollapse')
    },
    loginout(){
      this.clearUser()
      localStorage.removeItem('user')
      this.$router.push('/Login')
    },
    gootherpage(){
      this.$router.push('/Information')
    },

  }

}
</script>

<style scoped>
.el-dropdown-link {
  cursor: pointer;
  color: #409EFF;
}
.el-icon-arrow-down {
  font-size: 12px;
}
.content1{
  padding: 20px;
}
.header{
  height: 50px;
  line-height: 50px;
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  padding: 0 40px 0 20px;
  box-shadow:0px 1px 5px #ccc;
}
.header .iconfont{
  font-size: 24px;
  padding-top: 12px;
}
span{

}
.ueser{
  font-weight: 540;
  padding-top: 9px;
  margin-right: -10px;
}
ul li{
  display: block;
  text-align: center!important;
}
.avatar{
  margin-left: 0;
}
</style>