import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
Vue.use(ElementUI);
import './assets/css/reset.css'
import './assets/css/iconfont.css'
import './assets/them/index.css'
import * as echarts from 'echarts'
Vue.prototype.$echarts=echarts;


import axios from 'axios'
axios.defaults.withCredentials = true;// 允许跨域携带cookie
import VueAxios from 'vue-axios'
Vue.use(VueAxios, axios)

import htmlToExcel from "@/excel/htmlToExcel";
Vue.prototype.htmlToExcels = htmlToExcel;

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
