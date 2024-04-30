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
    path: '/login1',
    name: 'login1',
    component: () => import('../views/login1.vue'),
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
    path: '/',
    redirect:'/home'
  }
]
const router = createRouter({
  history: createWebHistory(),
  routes
})
export default router
