import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/home',
    name: 'home',
    component: HomeView,
  },
  {
    path: '/time_line',
    name: 'time_line',
    component: () => import('../views/time_line.vue'),
  },
  {
    path: '/search',
    name: 'search',
    component: () => import('../views/search.vue'),
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/login.vue'),
  },
  {
    path: '/register',
    name: 'register',
    component: () => import('../views/register.vue'),
  },
  {
    path: '/search1',
    name: 'search1',
    component: () => import('../views/search1.vue'),
  },
  {
    path: '/test',
    name: 'test',
    component: () => import('../views/test.vue'),
  },
  {
    path: '/',
    redirect:'/home'
  },  
  {
    path: '/user',
    name: 'user',
    component: () => import('../views/user.vue'),
  },
  {
    path: '/user_info_change',
    name: 'user_info_change',
    component: () => import('../views/user_info_change.vue'),
  },
]
const router = createRouter({
  history: createWebHistory(),
  routes
})
export default router
