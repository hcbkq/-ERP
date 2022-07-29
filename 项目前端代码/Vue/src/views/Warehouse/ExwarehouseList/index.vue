<template>
  <div class="material">
    <!-- 搜索 -->
    <div class="header">
      <!-- change	仅在输入框失去焦点或用户按下回车时触发 -->
      <el-input  @change="searchInp" v-model="input" placeholder="请输入ID"></el-input>
      <el-button type="primary">搜索</el-button>
      <el-button  type="primary" @click="dialogVisible=true">添加</el-button>
      <el-button type="primary" @click="exportExcel">导出excel</el-button>
    </div>
    <!--    表格-->
    <div class="wrapper">
      <el-table
          ref="multipleTable"
          :data="tableData"
          tooltip-effect="dark"

          @selection-change="handleSelectionChange">
        <el-table-column
            type="selection"
            width="55">
        </el-table-column>

        <el-table-column
            prop="Id"
            label="Id"
        >
        </el-table-column>
        <el-table-column
            prop="productName"
            label="材料名称"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="specification"
            label="规格型号"
            width="150px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="danjia"
            label="单价"

            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="quantity"
            label="数量"
            width="180px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="createdUser"
            label="创建人"
            width="180px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column label="操作">
          <template slot-scope="scope">
            <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin-top: 20px">
        <el-button @click="toggleSelection([tableData[1], tableData[2]])">批量删除</el-button>
        <el-button @click="toggleSelection()">取消选择</el-button>
      </div>
    </div>

    <!-- 分页 -->
    <MyPagination :total="total" :pageSize="pageSize" @changepage="changepage"/>
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
      total:4,/* 总条数 */
      paegtotal:1,/* 总条数 */
      tableData: [{
        Id: '21541124415',
        productName: '听筒',
        specification:'v7',
        danjia:'255/kg',
        quantity:'12kg',
        createdUser:'李铭'

      },
        {
          Id: '21541141255',
          productName:'手机指环扣',
          specification:'c1',
          danjia:'255/kg',
          quantity:'15kg',
          createdUser:'李铭'
        }, {
          Id: '21541184574',
          productName: '卡座',
          specification:'b2',
          danjia:'255/kg',
          quantity:'200kg',
          createdUser:'李铭'
        }, {
          Id: '21541184512',
          productName: '转接头',
          specification:'d1',
          danjia:'45/kg',
          quantity:'21kg',
          createdUser:'李铭'
        }],
      multipleSelection: []
    }

  },
  methods:{
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }

  },



}
</script>

<style scoped>

.header{
  display: flex;
}
.wrapper{
  margin: 20px 0;
  background-color: #FFF;
  padding: 10px 0;
}
button{
  margin-left:20px ;
}
</style>