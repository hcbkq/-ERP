<template>
    <div class="pagination">
        <el-pagination background layout="prev, pager, next,jumper"
    :total="total" :page-size="pageSize" @current-change="changePage">
</el-pagination>
    </div>
</template>

<script>
export default {
    props:{
        total:{
            type:Number,
            default:100
        },
        pageSize:{
            type:Number,
            default:10
        }
    },
  created() {
      this.changePage(1)
  },
  methods:{
    changePage(page){
      this.$emit('changePage',page)
    }

  }

}
</script>

<style scoped>
.pagination{
    text-align: center;
    margin: 20px;
}
</style>