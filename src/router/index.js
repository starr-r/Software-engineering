import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/time_line',
    name: 'time_line',
    component: () => import('../views/time_line.vue')
  },
  {
    path: '/search',
    name: 'search',
    component: () => import('../views/search.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
