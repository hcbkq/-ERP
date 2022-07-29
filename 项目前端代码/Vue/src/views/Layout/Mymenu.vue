<template>
  <div class="menu">

    <el-menu
        default-active="/"
        class="el-menu-vertical-demo"
        router
        :collapse="isCollapse"
    >
      <el-menu-item>
        <span class="logo" slot="title"><h1>迅慧ERP</h1></span>
      </el-menu-item>
      <el-menu-item index="/">
        <i class="el-icon-menu"></i>
        <span slot="title">首页</span>
      </el-menu-item>
      <el-menu-item index="/customer">
        <i class="el-icon-document"></i>
        <span slot="title">客户管理</span>
      </el-menu-item>
      <el-menu-item index="/order">
        <i class="el-icon-setting"></i>
        <span slot="title">订单管理</span>
      </el-menu-item>
      <el-menu-item index="/goods">
        <i class="el-icon-menu"></i>
        <span slot="title">产品管理</span>
      </el-menu-item>
      <el-submenu index="/production">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>生产管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/production/material">材料</el-menu-item>
          <el-menu-item index="/production/production-list">生产单</el-menu-item>
          <el-menu-item index="/production/picking">领料</el-menu-item>
        </el-menu-item-group>

      </el-submenu>
      <el-submenu index="/warehouse">
        <template slot="title">
          <i class="el-icon-s-opportunity"></i>
          <span>仓库管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/warehouse/record">基本数据</el-menu-item>

          <el-menu-item index="/warehouse/warehouse-list">入库表</el-menu-item>
          <el-menu-item index="/warehouse/exwarehouse-list">出库表</el-menu-item>


        </el-menu-item-group>

      </el-submenu>
      <el-submenu index="/finance">
        <template slot="title">
          <i class="el-icon-thumb"></i>
          <span>财务管理</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/finance/payment">收货款</el-menu-item>

          <el-menu-item index="/finance/profit">出库利润统计</el-menu-item>

        </el-menu-item-group>

      </el-submenu>

      <el-menu-item class="footer">

          <span>Cshdfjs © 2022. 迅慧ERP</span>

      </el-menu-item>
    </el-menu>



  </div>

</template>

<script>
export default {
  name: "Mymenu",
  props:['isCollapse'],
  data(){
    return{
      // isCollapse:false
    }
  }
}
</script>

<style scoped>
.menu{
  box-shadow: 1px 0 5px #ccc;
}
.el-menu{
  border: none;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;

}
.logo{
  height:50px;
  text-align: center;
}
.logo h1{
  line-height: 50px;
  font-size: 18px;
  font-weight: 600;
  text-align: center;
  text-shadow: 5px 5px 5px #33CABB;
}
.footer{
  width: 160px;
  font-size: 12px;
  padding: 20px;
}
</style>