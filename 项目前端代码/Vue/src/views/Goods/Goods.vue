<template>
  <div class="goods">
    <div class="header">

      <el-form ref="form" :model="searchForm"  label-width="80px"  input-width="50px">
        <el-form-item class="search" label="唯一标识">
          <el-input   placeholder="请输入订单唯一标识" v-model="searchForm.productId"></el-input>
        </el-form-item>
        <el-form-item class="search" label="产品名称">
          <el-input placeholder="请输入客户姓名" v-model="searchForm.productName"></el-input>
        </el-form-item>

        <el-form-item class="search" label="工序">
          <el-select v-model="searchForm.haltTheSales" placeholder="请选择">
            <el-option label="无工序" value="0"></el-option>
            <el-option label="有工序" value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item class="search" label="状态">
          <el-select v-model="searchForm.workingProcedure" placeholder="请选择">
            <el-option label="停售" value="0"></el-option>
            <el-option label="在售" value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <el-button type="primary" @click="searchInp(searchForm)">搜索</el-button>
      <el-button  type="primary" @click="dialogVisible=true">添加</el-button>
      <el-button type="primary" @click="exportExcel">导出excel</el-button>
    </div>
    <div class="wrapper">
      <el-table :data="tableData.data" id="vcfResult" border>
        <el-table-column type="selection" width="55"> </el-table-column>
        <el-table-column prop="productId" label="客户唯一标识" ></el-table-column>
        <el-table-column prop="productName" label="产品名称"></el-table-column>
        <el-table-column prop="productType" label="产品类型"></el-table-column>
        <el-table-column prop="lowestSelling" label="单价"></el-table-column>
        <el-table-column prop="maximumStock" label="库存"  width="100"></el-table-column>

        <el-table-column prop="workingProcedure" label="状态" width="120">
          <template #default="scope">
            <span>{{ scope.row.workingProcedure == 0 ?"停售" :scope.row.haltTheSales == 1 ?"在售":''}}</span>
          </template>
        </el-table-column>
        <el-table-column prop="haltTheSales" label="工序"  width="120">
          <template #default="scope">
            <span>{{ scope.row.haltTheSales == 0 ?"无工序" :scope.row.haltTheSales == 1 ?"有工序":''}}</span>
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
        productId:'',
        productName:'',
        haltTheSales:'',
        workingProcedure:''
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
      axios.get(`http://192.168.1.111:8080/product/getProducts`,
          { headers: {  'Content-Type': 'application/x-www-form-urlencoded' } },
          qs.stringify()
      ).then((res)=>{
        this.tableData = res.data
      })
    },
  //  搜索
    searchInp(searchForm) {
      var params = new URLSearchParams()

      axios.post('http://192.168.1.111:8080/product/getProducts',

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
  width: 220px;
}
.el-form-item:nth-child(n + 2){
  margin-left: 30px;
}
/deep/.el-form-item__label{
  text-align: left !important;
}


</style>