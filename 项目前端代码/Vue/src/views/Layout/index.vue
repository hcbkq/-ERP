<template>
  <div id="layout">
<!--左侧导航-->
    <MyMenu class="menu" :isCollapse='isCollapse'/>

<!--    右侧内容-->
    <Content class="content" :class="{isActive:isCollapse}" @changeCollapse="changeCollapse" :isCollapse='isCollapse'/>
  </div>

</template>

<script>
import MyMenu from '@/views/Layout/Mymenu'
import Content from "@/views/Layout/Content";
export default {
  components:{
    MyMenu,
    Content
  },
  data(){
    return{
      isCollapse:false
    }
  },
  methods:{
    changeCollapse(){
      this.isCollapse = !this.isCollapse
    }

  }
}
</script>

<style scoped>
  #layout{
    display: flex;
  }
  #layout  ::-webkit-scrollbar {
    width: 0 !important;
  }
  #layout ::-webkit-scrollbar {
    width: 0 !important;height: 0;
  }
  .menu{
    min-height: 500px;
    background-color: #FFF;
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
  }
  .content{
    flex: 1;
    margin-left: 200px;

  }
  .isActive{
    margin-left: 64px;
  }


</style>