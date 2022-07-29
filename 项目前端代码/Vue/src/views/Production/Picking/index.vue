<template>
  <div class="material">
    <!-- 搜索 -->
    <div class="header">
      <!-- change	仅在输入框失去焦点或用户按下回车时触发 -->
      <el-input  @change="searchInp" v-model="input" placeholder="请输入唯一标识符"></el-input>
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
            prop="cid"
            label="唯一标识"
        >
        </el-table-column>
        <el-table-column
            prop="name"
            label="材料名称"

            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="mode"
            label="储存方式"
            width="150px"
            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="purchase"
            label="进价"

            show-overflow-tooltip>
        </el-table-column>
        <el-table-column
            prop="stastus"
            label="材料状态"
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
      total:8,/* 总条数 */
      paegtotal:1,/* 总条数 */
      tableData: [{
        cid: '84575214',
        name: '镀锌钢板(纯锌)',
        mode:'常规',
        purchase:'255/kg',
        stastus:'固体'
      },
        {
          cid: '14152566',
          name: '结构钢',
          mode:'常规',
          purchase:'52/kg',
          stastus:'固体'
        }, {
          cid: '85145265',
          name: '合金钢',
          mode:'常规',
          purchase:'85/kg',
          stastus:'固体'
        }, {
          cid: '87452147',
          name: '钛合金',
          mode:'常规',
          purchase:'65/kg',
          stastus:'固体'
        }, {
          cid: '96547825',
          name: '铝合金',
          mode:'常规',
          purchase:'84/kg',
          stastus:'固体'
        }, {
          cid: '12345854',
          name: '工具钢',
          mode:'常规',
          purchase:'985/kg',
          stastus:'固体'
        }, {
          cid: '65412545',
          name: '硅铝合金',
          mode:'常规',
          purchase:'475/kg',
          stastus:'固体'
        }, {
          cid: '25487541',
          name: '镀锌钢板(纯锌)',
          mode:'常规',
          purchase:'45/kg',
          stastus:'固体'
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