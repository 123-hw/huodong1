import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/manager', name: 'home', component:import('../views/manager.vue') ,children:[
        {path: 'home',component:import('../views/Home.vue')},
      ]},

    {path:'/notFound',component: import('../views/404.vue'),},
    {path:'/pathMatch(.*)',redirect:'/notFound'}
  ],
})

export default router
