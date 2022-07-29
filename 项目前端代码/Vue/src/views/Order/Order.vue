<template>
  <div class="order">
    <!-- 搜索 -->
    <div class="header">
    <!--   change   在输入框失去焦点或者按下回车键的时候出发   -->

      <el-form ref="form" :model="searchForm"  label-width="80px"  input-width="50px">
        <el-form-item class="search" label="唯一标识">
          <el-input   placeholder="请输入订单唯一标识" v-model="searchForm.identifierId"></el-input>
        </el-form-item>
        <el-form-item class="search" label="订单客户">
          <el-input placeholder="请输入客户姓名" v-model="searchForm.orderCustomer"></el-input>
        </el-form-item>
        <el-form-item class="search" label="审核人">
          <el-input placeholder="请输入产品类型" v-model="searchForm.reviewer"></el-input>
        </el-form-item>
        <el-form-item class="search" label="是否结单">
          <el-select v-model="searchForm.statement" placeholder="请选择">
            <el-option label="未结单" value="0"></el-option>
            <el-option label="已结单" value="1"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="searchInp(searchForm)">搜索</el-button>
      <el-button  type="primary" @click="dialogVisible=true">添加</el-button>
      <el-button type="primary" @click="exportExcel">导出excel</el-button>
    </div>

    <!--    添加信息的对话框-->
    <el-dialog title="添加订单" :visible.sync="dialogVisible" width="40%" >
      <span>
        <el-form ref="form" :model="form" label-width="80px">

           <el-form-item label="客户唯一标识">
            <el-input v-model="form.cid"></el-input>
          </el-form-item>
          <el-form-item label="订单客户">
            <el-input v-model="form.orderCustomer"></el-input>
          </el-form-item>
          <el-form-item label="商品名称">
            <el-input v-model="form.orderProduct"></el-input>
          </el-form-item>


          <el-form-item label="订单数量">
            <el-input v-model="form.orderQuantity"></el-input>
          </el-form-item>
          <el-form-item label="金额">
            <el-input v-model="form.money"></el-input>
          </el-form-item>
            <el-form-item label="审核人">
            <el-input v-model="form.reviewer"></el-input>
          </el-form-item>
        <el-form-item label="结单">
           <el-select v-model="form.statement" placeholder="请选择">
            <el-option label="未结单" value="0"></el-option>
            <el-option label="已结单" value="1"></el-option>
          </el-select>
        </el-form-item>

           <el-form-item label="单据附注">
            <el-input v-model="form.notesDocuments"></el-input>
          </el-form-item>
        </el-form>
      </span>
    <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary"  @click="addBtn" >确 定</el-button>
    </span>
    </el-dialog>
    <!--修改信息的对话框-->
    <el-dialog title="修改订单" :visible.sync="editDialogVisible" width="40%" >
      <span>
        <el-form ref="editform" :model="editform" label-width="80px">
           <el-form-item label="唯一标识">
            <el-input v-model="editform.cid"></el-input>
          </el-form-item>
          <el-form-item label="客户名称">
            <el-input v-model="editform.identifierId"></el-input>
          </el-form-item>
          <el-form-item label="联系方式">
            <el-input v-model="editform.orderProduct"></el-input>
          </el-form-item>
          <el-form-item label="电子邮箱">
            <el-input v-model="editform.orderCustomer"></el-input>
          </el-form-item>

          <el-form-item label="订单确立时间">
            <el-input v-model="editform.orderDate"></el-input>
          </el-form-item>
          <el-form-item label="交货时间">
            <el-input v-model="editform.deliveryDate"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="editform.orderQuantity"></el-input>
          </el-form-item>
            <el-form-item label="地址">
            <el-input v-model="editform.reviewer"></el-input>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="editform.statement"></el-input>
          </el-form-item>
           <el-form-item label="地址">
            <el-input v-model="editform.notesDocuments"></el-input>
          </el-form-item>
        </el-form>
      </span>
    <span slot="footer" class="dialog-footer">
      <el-button @click="editDialogVisible = false">取 消</el-button>
      <el-button type="primary"    @click="confirmhandleEdit" >确 定</el-button>
    </span>
    </el-dialog>
    <!-- 表格 -->
  <div class="wrapper">
    <el-table :data="tableData.data" id="vcfResult" border>
      <el-table-column type="selection" width="55"> </el-table-column>
      <el-table-column prop="identifierId" label="订单唯一标识"></el-table-column>
      <el-table-column prop="orderCustomer" label="订单客户" width="100px"></el-table-column>
      <el-table-column prop="orderProduct" label="商品名称" width="100px"></el-table-column>
      <el-table-column prop="orderDate" label="订单确立时间"  width="100px"> </el-table-column>
      <el-table-column prop="deliveryDate" label="交货时间"  width="100px"> </el-table-column>
      <el-table-column prop="orderQuantity" label="订单数量" width="100px"> </el-table-column>
      <el-table-column prop="money" label="金额" width="100px"> </el-table-column>
      <el-table-column prop="reviewer" label="审核人" width="100px"> </el-table-column>
      <el-table-column prop="statement" label="是否结单" width="100px">
        <template #default="scope">
          <span>{{ scope.row.statement == 0 ?"未结单" :scope.row.statement == 1 ?"已结单":''}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="notesDocuments" label="单据附注" width="100px"> </el-table-column>
      <el-table-column label="操作"> 
      <template slot-scope="scope">
      <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
      <el-button size="mini" type="danger"  @click="handleDelete(scope.$index, scope.row)">删除</el-button></template></el-table-column>
    </el-table>
  </div>
    <!-- 分页 -->
    <MyPagination :total="total" :pageSize="pageSize"/>
  </div>
</template>

<script>
import axios from 'axios'
import MyPagination from '@/components/MyPagination.vue'
import qs from "qs";
export default {
  components:{
    MyPagination
  },
  data() {
    return {
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
      },
      tableData: [],
      total:1,/* 总页数 */
      pageSize:1,/* 每页展示几条 */

      searchText: '',/* 输入的数据 */

      dialogVisible: false,/* 添加弹窗 */
      editDialogVisible: false,/* 编辑弹窗 */
      searchForm:{
        identifierId:'',
        orderCustomer:'',
        reviewer:'',
        statement:'',
      },
      form: {
        cid: '',

        identifierId: '',
        orderProduct: '',
        orderCustomer: '',
        orderDate: '',
        money:'',
        deliveryDate: '',
        orderQuantity: '',
        reviewer: '',
        statement: '',
        notesDocuments: ''
      },
      editform: {
        cid: '',
        identifierId: '',
        money:'',
        orderProduct: '',
        orderCustomer: '',
        orderDate: '',
        deliveryDate: '',
        orderQuantity: '',
        reviewer: '',
        statement: '',
        notesDocuments: ''
      }
    }

  },
  created(){
    this.getorderData(),
    this.handleEdit()
    this.confirmhandleEdit()
    this.exportExcel()
    this.addBtn()

    this.searchInp()
    this.handleDelete()
  },
  
  methods: {
    open() {
      this.$alert('当前商品库存不足，已为您创建商品生产单，请前往生产管理审核', '迅慧提示', {
        confirmButtonText: '确定',
        callback: action => {
          this.$message({
            type: 'info',
            message: `action: ${ action }`
          });
        }
      });
    },
    /* 获取信息 */
    getorderData(){
      axios.get(`http://192.168.1.111:8080/order/getByOrders`,
          { headers: {  'Content-Type': 'application/x-www-form-urlencoded' } },
          qs.stringify()
      ).then((res)=>{
        this.tableData = res.data
      })
    },
    /* 搜索功能 */
    searchInp(searchForm) {
      var params = new URLSearchParams()

      axios.post('http://192.168.1.111:8080/order/findByOrders',

          qs.stringify(this.searchForm)
      
      ).then((res)=>{
            if(res.data.state===200){
              this.tableData=res.data
            }else{
              this.tableData=[]
            }
      }).catch((res)=>{})

    },
    /* 编辑事件 */
   handleEdit(index, row) {
       console.log("唯一标识符：",row.identifierId)

      //  显示弹窗
      this.editDialogVisible=true;
    //  请求服务器 根据identifierId获取当前要编辑的对象信息

      var params = new URLSearchParams()
      params.append("identifierId", row.identifierId)

      axios.post('http://192.168.1.111:8080/order/findByCustomers',params,
      ).then((res)=>{
        let stuArr=res.data.data
        //
        this.editform ={
          cid:stuArr[0].cid,
          identifierId:stuArr[0].identifierId,
          orderProduct:stuArr[0].orderProduct,
          orderCustomer: stuArr[0].orderCustomer,
          orderDate: stuArr[0].orderDate,
          deliveryDate:stuArr[0].deliveryDate,
          orderQuantity:stuArr[0].orderQuantity,
          reviewer:stuArr[0].reviewer,
          statement:stuArr[0].statement,
          notesDocuments:stuArr[0].notesDocuments,

        }
        //刷新列表信息
        this.getorderData()
        //关闭对话框
        this.dialogVisible=false;
            this.form={ cid:'', username: '', phone: '', email: '', associated:'', cityName: '',
              }
      }).catch((res)=>{})

    },
    /* 点击修改按钮 */
    confirmhandleEdit(){  /* 点击修改按钮 */

      let params = new URLSearchParams();
      params.append("cid",this.editform.cid)
      params.append("identifierId",this.editform.identifierId)

      params.append("orderProduct",this.editform.orderProduct)
      params.append("orderCustomer",this.editform.orderCustomer)
      params.append("orderDate",this.editform.orderDate)
      params.append("deliveryDate",this.editform.deliveryDate)
      params.append("orderQuantity",this.editform.orderQuantity)

      
      params.append("reviewer",this.editform.reviewer)
      params.append("statement",this.editform.statement)
      params.append("notesDocuments",this.editform.notesDocuments)


      //请求axios
      axios.post('http://192.168.1.111:8080/order/xx',
          params,
      ).then((res)=>{
        console.log(6666)
        //刷新列表信息
        this.getorderData()
        //关闭对话框
        this.dialogVisible=false;
        // 清空表单数据
        this.form={ cid:'', identifierId: '', orderProduct: '', orderCustomer: '', orderDate:'', deliveryDate: '',orderQuantity:'', reviewer: '',statement:'', notesDocuments: ''
        }
      }).catch((res)=>{})

    },
   /* 删除事件 */
    handleDelete(index, row) {

      console.log("唯一标识符：",row.identifierId)
      this.$confirm('确定删除该商品数据?','提示',{
        type:'warning'
      }).then(()=>{
        var params = new URLSearchParams()
        params.append("identifierId", row.identifierId)
        console.log(row.identifierId)
        axios.post('http://192.168.1.111:8080/order/deleteOrder',params,

        ).then((response) => {
          
          console.log("删除的结果：", response)
          if (response.data.code == 0) {
            alert(response.data.message)
            this.shopGoods.splice(index, 1)

          } else {
            this.getorderData()
          }
        }).catch((error) => {
          console.log("删除失败的原因：", error)
        })
      })
    },

  /* 添加事件 */
   addBtn(){

      let params = new URLSearchParams();
      params.append("cid",this.form.cid)
      params.append("identifierId",this.form.identifierId)
      params.append("orderProduct",this.form.orderProduct)
      params.append("orderCustomer",this.form.orderCustomer)
      params.append("orderDate",this.form.orderDate)
      params.append("deliveryDate",this.form.deliveryDate)
      params.append("orderQuantity",this.form.orderQuantity)
     params.append("money",this.form.money)

     params.append("reviewer",this.form.reviewer)
      params.append("statement",this.form.statement)
      params.append("notesDocuments",this.form.notesDocuments)
      //请求axios
      axios.post('http://192.168.1.111:8080/order/OrderNetOrder',
          params,
          ).then((res)=>{
            if(res.status === 200){
              const data = res.data;
              if(data.state===4005){
                alert('用户不存在')
              }
              else if(data.state===9015){
                alert('订单所需产品不存在')
              }else{
                alert('出库单创建成功待审核')
                //刷新列表信息
                this.getcustomerData()
                //关闭对话框
                this.dialogVisible=false;
                // 清空表单数据
                this.form={cid: '',identifierId: '',orderProduct: '',orderCustomer: '',orderDate: '',deliveryDate: '',orderQuantity: '',reviewer: '',statement: '',notesDocuments: ''
                }
              }


            }


      }).catch((res)=>{})
    },

//  分页页码
    changepage(mum){
      this.getcustomerData(num)
    },
  //  导出excel
    exportExcel() {
      this.htmlToExcels.exportExcel("订单信息.xlsx", "#vcfResult");
      //第一个引号里面是表格导出时的名字
      //第二个是表格的id，这个插件是通过id导出的
    }
  },
}
</script>

<style scoped>

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
  width: 230px;
}
.el-form-item:nth-child(n + 2){
  margin-left: 30px;
}
/deep/.el-form-item__label{
  text-align: left !important;
}

</style>