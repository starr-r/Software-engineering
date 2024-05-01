<template>

  <navigate/>
  <router-view></router-view>
<!--  <home-view/>-->
<!--  <time_line/>-->
<!--  <search/>-->

</template>


<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script setup>

import HomeView from "@/views/HomeView.vue";
import Navigate from "@/components/navigate.vue";
import Time_line from "@/views/time_line.vue";
import time_line from "@/views/time_line.vue";
import search from "@/views/search.vue";
import user from "@/views/user.vue"
</script>