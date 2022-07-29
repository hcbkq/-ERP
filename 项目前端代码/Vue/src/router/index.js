import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '../views/Layout/index.vue'

import Home from "@/views/Home";
import Login from "../views/Login/index.vue";
//异步
const Customer = () => import('@/views/Customer/Customer.vue')

const Order = () => import('@/views/Order/Order.vue')

const Production = () => import('@/views/Production/Production.vue')
const Material = () => import('@/views/Production/Material/index.vue')
const ProductionList = () => import('@/views/Production/ProductionList/index.vue')
const Picking = () => import('@/views/Production/Picking/index.vue')

const Goods = () => import('@/views/Goods/Goods.vue')

const Warehouse = () => import('@/views/Warehouse/Warehouse.vue')
const Record = () => import('@/views/Warehouse/Record/index.vue')
const WarehouseList = () => import('@/views/Warehouse/WarehouseList/index.vue')
const ExwarehouseList = () => import('@/views/Warehouse/ExwarehouseList/index.vue')

const Finance = () => import('@/views/Finance/Finance.vue')
const Payment = () => import('@/views/Finance/Payment/index.vue')
const Profit = () => import('@/views/Finance/Profit/index.vue')




const Information = () =>import('@/views/Information/index.vue')


Vue.use(VueRouter)

const routes = [
  {
    path: '',
    component: Layout,
     //路由原信息
    meta:{
      // isLogin:true
    },
     children:[
       {
         path:'/',
         name:'Home',
         component:Home
       },{
         path:'/customer',
         name:'Customer',
         component:Customer
       },{
         path:'/order',
         name:'Order',
         component:Order
       },{
         path:'/production',
         name:'Production',
         component:Production,
         redirect:'/Production/material',
         children:[
           {
             path:'material',
             component:Material
           },
           {
             path:'production-list',
             component:ProductionList
           }, {
             path:'picking',
             component:Picking
           }
         ]
       },{
         path:'/goods',
         name:'Goods',
         component:Goods
       },{
         path:'/warehouse',
         name:'Warehouse',
         component:Warehouse,
         redirect:'/Warehouse/warehouse-list',
         children:[
           {
             path:'record',
             component:Record
           },
           {
              path:'warehouse-list',
             component:WarehouseList
           }, {
             path:'exwarehouse-list',
             component:ExwarehouseList
           }
         ]
       },{
         path:'/finance',
         name:'Finance',
         component:Finance,
         redirect:'/Finance/payment',
          children: [
            {
              path:'payment',
              component:Payment
            },
            {
              path:'profit',
              component:Profit
            }
          ]

       },
       {
         path:'/information',
         name:'Information',
         component:Information,

       },


     ],
  },
  {
    path: '/Login',
    name: 'Login',
    component: Login
      },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
// //路由拦截
// router.beforeEach((to,from,next)=>{
//     console.log('---------to------',to);
//     // 1.判断是否需要登录
//     if(to.matched.some(ele=>ele.data)){
//     //  判断是否已经登陆
//       let token='';
//           if(token){
//             next()
//           }
//           else{
//             next('/login')
//           }
//     }else{
//       next()
//     }
//
// })

export default router
