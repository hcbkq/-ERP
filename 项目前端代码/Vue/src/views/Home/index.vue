<template>
  <div>
    <div class="box">
      <el-card class="box-card box1">
        <div slot="header" class="text">
          <span>本季度交易额</span>
          <span class="sapncn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;413,222</span>
        </div>
        <div class="text">
          <span>今日交易额：1,111</span>
        </div>
      </el-card>
      <el-card class="box-card box2">
        <div slot="header" class="text">
          <span>本季度生产量</span>
          <span class="sapncn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15,242</span>
        </div>
        <div class="text">
          <span>今日生产量：152</span>
        </div>
      </el-card>
      <el-card class="box-card box3">
        <div slot="header" class="text">
          <span>本季度完成订单量</span>
          <span class="sapncn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8,422</span>
        </div>
        <div class="text">
          <span>今日完成订单量：698</span>
        </div>
      </el-card>
      <el-card class="box-card box4">
        <div slot="header" class="text">
          <span>未完成单量</span>
          <span class="sapncn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;222</span>
        </div>
        <div class="text">
          <span>待审核订单：1</span>
        </div>
      </el-card>
    </div>
    <div class="ecarts">
      <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
      <div id="main" class="ecarts1"></div>
      <div id="main1" class="ecarts1"></div>
    </div>

  </div>

</template>

<script>
import * as echarts from 'echarts'
import axios from 'axios'
import qs from 'qs';
export default {
  data(){
    return{
      data:{
        data1:[120, 132, 101, 134, 90, 230, 210],
        data2:[150, 232, 201, 154, 190, 330, 410],
        data3:[320, 332, 301, 334, 390, 330, 320]
      }
    }
  },

  mounted() {
    this.getcustomerData()
    this.bar()
    this.bar1()
  },
  methods:{
    getcustomerData(){
      axios.post(`http://192.168.1.111:8080/head/viewData`,
          { headers: {  'Content-Type': 'application/x-www-form-urlencoded' } },
          qs.stringify()
      ).then((res)=>{

        console.log(res.data.data)
      })
    },
    bar(){
      var chartDom = document.getElementById('main');
      var myChart = echarts.init(chartDom);
      var option;

      option = {
        title: {
          text: '近半年收支订单量',
          left: 'left'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['月收入', '月支出', '月订单数量']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['11', '12', '1', '2', '3', '4', '5']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '月收入',
            type: 'line',
            stack: 'Total',
            data: this.data.data1
          },

          {
            name: '月支出',
            type: 'line',
            stack: 'Total',
            data: this.data.data2
          },
          {
            name: '月订单数量',
            type: 'line',
            stack: 'Total',
            data: this.data.data3
          }
        ]
      };

      option && myChart.setOption(option);

    },
    bar1(){
      var chartDom = document.getElementById('main1');
      var myChart = echarts.init(chartDom);
      var option;

      option = {
        color:['#adf8e4','#5ec9f1','#f1f8ad','#f8adf7','#adc8f8'],
        title: {
          text: '上季度资金流动占比',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            data: [
              { value: 1048, name: '购买材料' },
              { value: 735, name: '入账' },
              { value: 580, name: '员工薪资' },
              { value: 484, name: '余额' },
              { value: 300, name: '企业支付' }
            ],
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };

      option && myChart.setOption(option);

    },


  },
}
</script>

<style scoped>
.text {
  font-size: 14px;
}
span{
  display: block;
}
.sapncn{
  margin-top: 15px;
  font-size: 18px;
}
.box{
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;

}
.box-card {
  width: 300px;
  border-radius: 10px;
  /*border: 1px solid #a5a1a1;*/
  box-shadow:1px 1px 5px rgba(165, 161, 161, 0.3) !important;
}
.box1{
  background-color: #7f9cd0;
  color: #fff;
  border: 1px solid #7f9cd0;
}
.box2{
  background-color:#64dcd0;
  border: 1px solid #64dcd0;

  color: #fff;
}
.box3{
  background-color: #5ec9f1;
  border: 1px solid #5ec9f1;

  color: #fff;
}
.box4{
   background-color:#dda0e3;
  border: 1px solid #dda0e3;
  color: #fff;
 }

/deep/.el-card__header{
  padding: 13px 20px !important;
}

/deep/.el-card__body{
  padding: 13px 20px !important;

}
.main{
  padding-top: 230px;
}
.ecarts{
  display: flex;
  justify-content: space-between;
  margin-top: 15px;
}
.ecarts1{
 width:47%;
  height:400px;
  background-color: #fff;
  padding: 20px;
  box-shadow:1px 1px 5px #d4d4d4 !important;
  border-radius: 0px;
}

.ecarts1:first-child{
  margin-right: 30px;
}


.wrapper{
  margin-top: 20px;
}
</style>