<template>
  <div id="login-wrap">
    <div class="login-box">
      <div class="login-left">
        <el-form :model="loginForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
          <el-form-item prop="username">
            <el-input type="text" placeholder="请输入账号" v-model="loginForm.username" ></el-input>
          </el-form-item>
          <el-form-item  prop="password">
            <el-input type="password" placeholder="请输入密码" v-model="loginForm.password" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button class="el-butotn" type="primary" @click="submitForm('loginForm')">登录</el-button>
            <el-button class="el-butotn" @click="resetForm('ruleForm')">重置</el-button>
          </el-form-item>
        </el-form>
      </div>
      <div class="login-right">
        <h1 class="text-white"> 迅慧ERP </h1>
        <p class="text-white">欢迎您的登录!</p>
      </div>
    </div>

  </div>


</template>

<script>
import axios from "axios";
import qs from 'qs';
import {mapMutations} from 'vuex'
export default {
  data() {
    var validateUser = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        callback();
      }
    };
    return {
      loginForm: {
        username: '',
        password: '',

      },
      rules: {
        username: [
          {validator: validateUser, trigger: 'blur'}
        ],
        password: [
          {validator: validatePass, trigger: 'blur'}
        ]
      }
    };
  },
  methods: {
    ...mapMutations('loginModule',['setuser']),
    //登录
    submitForm(loginForm){
      axios.post(
              "http://192.168.1.111:8080/users/login",
          qs.stringify(this.loginForm)
          ).then(res => {                    //请求成功后执行函数
        if (res.status === 200) {
          const data = res.data;
          if (data.state==4001){
            // alert('登录失败')
            this.$notify({
              title: '提示',
              message: '用户不存在',
              duration: 3000
            });
          }else if(data.state==4002){
            this.$notify({
              title: '提示',
              message: '密码错误',
              duration: 3000
            });

          }
          else{
            this.$notify({
              title: '提示',
              message: '用户登录成功',
              duration: 3000
            });
            window.localStorage.setItem("token",res.data);
            this.$router.push("/");	//登录验证成功路由实现跳转

          }
        } else {
            alert(data)
        }
      }).catch(err => {                   //请求错误后执行函数
        this.$notify({
          title: '提示',
          message: '用户访问错误',
          duration: 3000
        });
        console.log(err)
      })

    },
    //重置
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

  }
  }

</script>

<style scoped>
@media (max-width: 576px) {
  .login-right {
    display: none;
  }
  /deep/.login-left{
    width: 100% !important;
    background-color: #fff;
  }
  /deep/.login-box{
    margin-left:30px !important;
    margin-right:30px !important;

  }

}
#login-wrap {
  width: 100%;
  height: 100%;
  position: fixed;
  left: 0;
  top: 0;
  background: url(images/bacc1.jpg) no-repeat;
  background-size: cover;
  background-position: center;
  background-attachment: fixed;
}
.login-box{
  max-width: 700px;
  height: 340px;
  position: fixed;
  top: 0px;
  left: 0px;
  right: 0px;
  bottom: 0px;
  margin: auto;
  border: 15px solid rgba(255, 255, 255, 0.5);
  display: flex;
  justify-content: space-between;
}

.login-left,.login-right{
  padding: 45px;
  width: 50%;
  background-color: #FFF;
}
.login-left{
  padding-top: 60px;
}
.login-left p{
  font-size: 14px;
}
.login-left a{
  color: #33cabb;
  -webkit-transition: .2s linear;
  transition: .2s linear;
}
.login-right{
  background: linear-gradient(45deg, #67b26f 0, #4ca2cd 100%) !important;
  text-align: center;
  padding-top: 100px;
  color: #FFF;
}

.login-right p{
  line-height: 60px;
  font-size: 20px;
  letter-spacing:5px
}

/deep/.el-form-item__content {
  margin-left: 0 !important;
}
.el-butotn{
  margin-left: 0px;
  width:125px;
}
.el-form-item {
  margin-bottom: 30px;
}
</style>