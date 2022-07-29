<template>
  <div class="customer">
    <!-- 搜索 -->
    <div class="header">
      <el-form ref="form" :model="searchForm"  label-width="80px">
        <el-form-item class="search" label="唯一标识">
          <!-- change	仅在输入框失去焦点或用户按下回车时触发 -->
<!--          <el-input  @change="searchInp" v-model="input" placeholder="请输入客户唯一标识"></el-input>-->
          <el-input   v-model="searchForm.cid" placeholder="请输入客户唯一标识"></el-input>
        </el-form-item>
        <el-form-item class="search" label="客户姓名">
          <el-input  v-model="searchForm.username" placeholder="请输入客户姓名"></el-input>
        </el-form-item>
        <el-form-item  class="search" label="有无订单">
          <el-select v-model="searchForm.order" placeholder="请选择">
            <el-option label="无" value="0"></el-option>
            <el-option label="有" value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="searchInp(searchForm)">搜索</el-button>
      <el-button  type="primary" @click="dialogVisible=true">添加</el-button>
      <el-button type="primary" @click="exportExcel">导出</el-button>
    </div>

<!--    添加信息的对话框-->
    <el-dialog title="添加客户" :visible.sync="dialogVisible" width="40%" >
      <span>
        <el-form ref="form" :model="form" label-width="80px">
           <el-form-item label="唯一标识">
            <el-input v-model="form.cid"></el-input>
          </el-form-item>
          <el-form-item label="客户名称">
            <el-input v-model="form.username"></el-input>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="form.phone"></el-input>
          </el-form-item>
          <el-form-item label="电子邮箱">
            <el-input v-model="form.email"></el-input>
          </el-form-item>
          <el-form-item label="关联企业">
            <el-input v-model="form.associated"></el-input>
          </el-form-item>

          <el-form-item label="地址">
            <el-input v-model="form.cityName"></el-input>
          </el-form-item>

        </el-form>
    </span>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary"  @click="addBtn" >确 定</el-button>
    </span>
    </el-dialog>
<!--修改信息的对话框-->
    <el-dialog title="编辑客户信息" :visible.sync="editDialogVisible" width="40%" >
      <span>
        <el-form ref="editform" :model="editform" label-width="80px">
           <el-form-item label="唯一标识" >
            <el-input v-model="editform.cid" disabled></el-input>
          </el-form-item>
          <el-form-item label="客户名称">
            <el-input v-model="editform.username"></el-input>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="editform.phone"></el-input>
          </el-form-item>
          <el-form-item label="电子邮箱">
            <el-input v-model="editform.email"></el-input>
          </el-form-item>
          <el-form-item label="关联企业">
            <el-input v-model="editform.associated"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="editform.cityName"></el-input>
          </el-form-item>

    </el-form>

      </span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="editDialogVisible = false">取 消</el-button>
    <el-button type="primary"  @click="confirmhandleEdit" >确 定</el-button>
  </span>
    </el-dialog>
    <!-- 表格 -->
  <div class="wrapper"  >
    <el-table  :data="tableData.data" id="vcfResult" border>
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="cid" label="客户唯一标识" ></el-table-column>
      <el-table-column prop="username" label="客户姓名" width="100px"></el-table-column>
      <el-table-column prop="phone" label="联系方式"></el-table-column>
      <el-table-column prop="email" label="电子邮箱"></el-table-column>
      <el-table-column prop="order" label="有无订单" width="100px">
          <template #default="scope">
            <span>{{ scope.row.order == 0 ?"无" :scope.row.order == 1 ?"有":''}}</span>
          </template>
      </el-table-column>
      <el-table-column prop="associated" label="关联企业"></el-table-column>
      <el-table-column prop="cityName" label="地址"> </el-table-column>
      <el-table-column  label="操作">
        <template slot-scope="scope" >
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
    <!-- 分页 -->
    <MyPagination :total="total" :pageSize="pageSize" @changePage="changePage"/>
  </div>
</template>

<script>
import axios from 'axios'


import qs from 'qs';
import MyPagination from '@/components/MyPagination.vue'

export default {
    name: "Customer",
  components:{
    MyPagination
  },

  data() {
    return {
      cid:"",
      username:"",
      total:1,/* 总页数 */
      pageSize:1,/* 每页展示几条 */
      pageCount:'1',// 总页数
      tableData:{},
      dialogVisible:false,/* 添加弹窗 */
      editDialogVisible:false,/* 编辑弹窗 */
      searchForm:{
        cid:'',
        username:'',
        order:'',
      },
      form: {
        cid:'',
        username: '',
        phone: '',
        email: '',
        associated:'',
        cityName: '',
      },
      editform:{
        cid:'',
        username: '',
        phone: '',
        email: '',
        associated:'',
        cityName: '',
      }
    }
  },
  //组件加载时被触发
  created(){
    this.pagination(1)
    this.getcustomerData()
    this.handleDelete()
    this.addBtn()
    this.handleEdit()
    this.confirmhandleEdit()
    this.exportExcel()
    this.getList()
  },
  methods: {
    //获取和分页
    pagination(page){

   //    axios.get(`http://192.168.1.111:8080/customer/getByCustomerPage?page=1`,
   //        page
   //
   //    ).then((res)=>{
   //      this.tableData = res.data
   //      console.log(res.data)
   //      this.total=res.data.data.pageCount
   //
   // console.log(total)
   //
   //    })
      axios.get(`http://192.168.1.111:8080/customer/getByCustomer`,
          { headers: {  'Content-Type': 'application/x-www-form-urlencoded' } },
          qs.stringify()
      ).then((res)=>{
        this.tableData = res.data
      })
    },
    //分页

    /* 获取信息 */
    // getcustomerData(){
    //   axios.get(`http://192.168.1.102:8080/customer/getByCustomer`,
    //       { headers: {  'Content-Type': 'application/x-www-form-urlencoded' } },
    //       qs.stringify()
    //   ).then((res)=>{
    //     this.tableData = res.data
    //   })
    // },
    /* 搜索功能 */
    searchInp(searchForm){
      var params = new URLSearchParams()
      axios.post('http://192.168.1.111:8080/customer/findByCustomers',
          qs.stringify(this.searchForm),
      ).then((res)=>{
        console.log(res.data)
        if(res.data.state===200){
          this.tableData=res.data
        }else{
          this.tableData=[]
        }
      }).catch((res)=>{})

    },
    /* 删除事件 */
    handleDelete(index, row) {
      console.log("唯一标识符：",row.cid)
      this.$confirm('确定删除该商品数据?','提示',{
        type:'warning'
      }).then(()=>{

        var params = new URLSearchParams()
        params.append("cid", row.cid)
        console.log(row.cid)
        axios.post('http://192.168.1.111:8080/customer/deleteCustomer',params,

        ).then((response) => {
          
          console.log("删除的结果：", response)
          if (response.data.code == 0) {
            alert(response.data.message)
            this.shopGoods.splice(index, 1)

          } else {
            this.pagination()
          }
        }).catch((error) => {
          console.log("删除失败的原因：", error)
        })
      })
    },
    //添加信息
    addBtn(){
      let params = new URLSearchParams();
      params.append("cid",this.form.cid)
      params.append("username",this.form.username)
      params.append("phone",this.form.phone)
      params.append("email",this.form.email)
      params.append("associated",this.form.associated)
      params.append("cityName",this.form.cityName)
      //请求axios
      axios.post('http://192.168.1.111:8080/customer/customer_new_customer',
          params,
          ).then((res)=>{
        //刷新列表信息
        this.pagination()
      //关闭对话框
        this.dialogVisible=false;
      // 清空表单数据
        this.form={ cid:'', username: '', phone: '', email: '', associated:'', cityName: '',
        }
      }).catch((res)=>{})
    },
    /* 编辑事件 */
    handleEdit(index, row) {
      console.log("唯一标识符：",row.cid)

      //  显示弹窗
      this.editDialogVisible=true;
    //  请求服务器 根据cid获取当前要编辑的对象信息

      var params = new URLSearchParams()
      params.append("cid", row.cid)

      axios.post('http://192.168.1.111:8080/customer/findByCustomers',params,
      ).then((res)=>{
        let stuArr=res.data.data
        //
        this.editform ={
          cid:stuArr[0].cid,
          username:stuArr[0].username,
          phone: stuArr[0].phone,
          email: stuArr[0].email,
          associated:stuArr[0].associated,
          cityName:stuArr[0].cityName,
        }
        //刷新列表信息
        this.pagination()
        //关闭对话框
        this.dialogVisible=false;


      }).catch((res)=>{})

    },
    confirmhandleEdit(){  /* 点击修改按钮 */

      let params = new URLSearchParams();
      params.append("cid",this.editform.cid)
      params.append("username",this.editform.username)
      params.append("phone",this.editform.phone)
      params.append("email",this.editform.email)
      params.append("associated",this.editform.associated)
      params.append("cityName",this.editform.cityName)

      //请求axios
      axios.post('http://192.168.1.111:8080/customer/updateCustomer',
          params,
      ).then((res)=>{
        console.log(6666)
        //刷新列表信息
        this.pagination()
        //关闭对话框
        this.editDialogVisible=false;
        // 清空表单数据
        this.form={ cid:'', username: '', phone: '', email: '', associated:'', cityName: '',
        }
      }).catch((res)=>{})

    },
    //  导出
    getList(){

    },
    exportExcel() {
      this.htmlToExcels.exportExcel("客户信息.xlsx", "#vcfResult");
      //第一个引号里面是表格导出时的名字
      //第二个是表格的id，这个插件是通过id导出的
    },


    }

}
</script>

<style scoped>

.header{
  display: flex;
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
.search{
  display: inline-block;
  margin-bottom: 0;
  padding-left:0;
}
.el-form-item:nth-child(n + 2){
  margin-left: 30px;
}

button{
  margin-left: 20px;
}
</style>