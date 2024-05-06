import { createApp } from 'vue'
import { ref } from 'vue';
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

const isLoggedIn=ref(false);
const app=createApp(App)
app.use(router);
app.use(store);
app.use(ElementPlus)
app.provide('$Url', (String)('http://localhost:8080'));
app.provide('$isLoggedIn', isLoggedIn);
app.mount('#app')



