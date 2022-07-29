<template>
  <div class="goods">
    <div class="header">

      <el-form ref="form" :model="searchForm"  label-width="80px"  input-width="50px">
        <el-form-item class="search" label="生产编号">
          <el-input   placeholder="请输入生产编号" v-model="searchForm.productionId"></el-input>
        </el-form-item>
        <el-form-item class="search" label="产品名称">
          <el-input placeholder="请输入产品名称" v-model="searchForm.productName"></el-input>
        </el-form-item>
        <el-form-item class="search" label="出库编号">
          <el-input placeholder="请输入出库编号" v-model="searchForm.productNumber"></el-input>
        </el-form-item>

      </el-form>

      <el-button type="primary" @click="searchInp(searchForm)">搜索</el-button>
      <el-button  type="primary" @click="dialogVisible=true">添加</el-button>
      <el-button type="primary" @click="exportExcel">导出excel</el-button>
    </div>
    <div class="wrapper">
      <el-table :data="tableData.data" id="vcfResult" border>
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="productionId" label="生产编号" ></el-table-column>
        <el-table-column prop="productName" label="产品名称"></el-table-column>
        <el-table-column prop="quantity" label="生产数量"></el-table-column>
        <el-table-column prop="orderDate" label="下单日期"></el-table-column>
        <el-table-column prop="examine" label="状态" width="100px">
          <template #default="scope">
            <span>{{ scope.row.examine == 0 ?"未审核" :scope.row.examine == 1 ?"已审核":''}}</span>
          </template>
        </el-table-column>

        <el-table-column prop="username" label="操作"> <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button></template></el-table-column>
      </el-table>
      <div style="margin-top: 20px;padding-left: 10px">
        <el-button @click="toggleSelection([tableData[1], tableData[2]])">批量删除</el-button>
        <el-button @click="toggleSelection()">取消选择</el-button>
      </div>
    </div>

    <!-- 分页 -->
    <MyPagination :total="total" :pageSize="pageSize" @changepage="changepage"/>

  </div>
</template>

<script>
import MyPagination from '@/components/MyPagination.vue'
import axios from "axios";
import qs from "qs";
export default {
  name: "Goods",
  components:{
    MyPagination,
  },
  data() {

    return {
      total:6,/* 总条数 */
      paegtotal:1,/* 总条数 */
      activeName: 'first',
      tableData:[],
      searchForm:{
        productionId:'',
        productName:'',
        productNumber:'',
      }

    };
  },
  created() {
    this.getcustomerData()
  },
  methods: {
    //取消选择
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    /* 获取信息 */
    getcustomerData(){
      axios.get(`http://192.168.1.111:8080/production/getProduction`,
          { headers: {  'Content-Type': 'application/x-www-form-urlencoded' } },
          qs.stringify()
      ).then((res)=>{
        this.tableData = res.data
      })
    },
    //  搜索
    searchInp(searchForm) {
      var params = new URLSearchParams()

      axios.post('http://192.168.1.111:8080/production/getProduction',

          qs.stringify(this.searchForm)

      ).then((res)=>{
        if(res.data.state===200){
          this.tableData=res.data
        }else{
          this.tableData=[]
        }
      }).catch((res)=>{})

    },
  }
}


</script>

<style scoped>

.p{
  line-height: 2.5;
  letter-spacing:5px;
}
.wrapper{
  margin: 20px 0;
  background-color: #FFF;
  padding-bottom: 10px;
}
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.header{
  display: flex;
}

button{
  margin-left: 20px;
}
el-form-item{

}
/deep/.el-form-item__label{
  text-align: left !important;
}

.el-form{
  flex: 1;
}
.wrapper{
  margin: 20px 0;
}
input{
  width: 100px;
}
.search{
  display: inline-block;
  margin-bottom: 0;
  width: 270px;
}
.el-form-item:nth-child(n + 2){
  margin-left: 30px;
}
/deep/.el-form-item__label{
  text-align: left !important;
}


</style>