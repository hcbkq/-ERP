<template>
  <div class="material">
    <!-- 搜索 -->
    <div class="header">
      <!-- change	仅在输入框失去焦点或用户按下回车时触发 -->
      <el-input  @change="searchInp" v-model="input" placeholder="请输入凭证"></el-input>
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
            prop="iid"
            label="凭证"
            width="100px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="opposiiteUnit"
            label="甲方单位"
            width="120px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="account"
            label="甲方账户"

            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="amount"
            label="金额"
            width="120px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="reviewer"
            label="审核状态（成功/失败）"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
          prop="createdUser"
          label="结单人"
          width="120px"
          show-overflow-tooltip>
      </el-table-column>
        <el-table-column
            prop="createdTime"
            label="结单时间"
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
      total:6,/* 总条数 */
      paegtotal:1,/* 总条数 */
      tableData: [
        {
          iid: '1100',
          opposiiteUnit: '海南万物',
          account:'41254112741221',
          amount:'32,123',
          reviewer: '成功',
          createdUser: '王伟',
          createdTime:'2022-01-21',

        }, {
          iid: '5120',
          opposiiteUnit: '河南千里',
          account:'41524112415241',
          amount:'45，121',
          reviewer: '成功',
          createdUser: '张千',
          createdTime:'2022-04-21',
        }, {
          iid: '4125',
          opposiiteUnit: '海南科讯',
          account:'41521542154652',
          amount:'51,123',
          reviewer: '失败',
          createdUser: '张红',
          createdTime:'2021-01-22',
        }, {
          iid: '7845',
          opposiiteUnit: '海南新团',
          account:'54124512365478',
          amount:'32,412',
          reviewer: '成功',
          createdUser: '王涵',
          createdTime:'2021-10-12',
        }, {
          iid: '4125',
          opposiiteUnit: '宁夏万物',
          account:'12345125478456',
          amount:'1,123',
          reviewer: '成功',
          createdUser: '张琳',
          createdTime:'2022-10-12',
        },{
          iid: '6325',
          opposiiteUnit: '江苏万科',
          account:'41587545698456',
          amount:'4,154',
          reviewer: '成功',
          createdUser: '王伟',
          createdTime:'2020-10-04',

        }
      ],
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