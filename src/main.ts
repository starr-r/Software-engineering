import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'

const app=createApp(App)
app.use(router);
app.use(store);
app.use(ElementPlus)
app.provide('$Url', (String)('https://d031-124-126-98-171.ngrok-free.app'));
app.mount('#app')



