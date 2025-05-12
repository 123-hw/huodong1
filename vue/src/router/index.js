import { createRouter, createWebHistory } from 'vue-router'
import Admin from '../views/Admin.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      {path: '/', redirect:'/manager/home' ,},
    {path: '/manager', name: 'home', component: () => import('../views/manager.vue') ,children:[
        {path: 'home',meta: {name:'主页'},component: ()=> import('../views/Home.vue'),},
        {path: 'admin',meta: {name:'管理员信息'},component: ()=> import('../views/Admin.vue'),},
            {path: 'user',meta: {name:'普通用户信息'},component: ()=> import('../views/User.vue'),},
      ]},
      {path:'/login',component: import('../views/Login.vue'),},
      {path:'/register',component: import('../views/register.vue'),},
    {path:'/notFound',component: import('../views/404.vue'),},
    {path:'/:pathMatch(.*)',redirect:'/notFound'}
  ],
})

export default router
