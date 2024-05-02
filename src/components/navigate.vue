<template>
  <div class="h-6" />
  <el-menu
      :default-active="activeIndex2"
      class="el-menu-demo"
      mode="horizontal"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      @select="handleSelect"
  >
    <div class="left-items">
      <router-link to="/home" tag="el-menu-item">
        <el-menu-item index="1">海外文物服务知识子系统</el-menu-item>
      </router-link>
      <router-link to="/home" tag="el-menu-item">
        <el-menu-item index="4">首页</el-menu-item>
      </router-link>
      <el-sub-menu index="2">
        <template #title>藏馆信息</template>
        <el-menu-item index="2-1">item one</el-menu-item>
        <el-sub-menu index="2-2">
          <template #title>item four</template>
          <el-menu-item index="2-2-1">item one</el-menu-item>
          <el-menu-item index="2-2-2">item two</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="4">文物知识图谱</el-menu-item>
      <router-link to="/time_line" tag="el-menu-item">
        <el-menu-item index="4" >文物时间轴</el-menu-item>
      </router-link>
      <router-link to="/search" tag="el-menu-item">
        <el-menu-item index="4" >文物查询</el-menu-item>
      </router-link>
      <el-menu-item index="4">问答系统</el-menu-item>
      <el-menu-item index="4">app下载</el-menu-item>
    </div>
    <div class="right-items">
      <router-link v-if="isLoggedIn" to="/user" tag="el-menu-item" index="4" style="flex: 0 0 auto; text-align: right;">
        <el-menu-item index="4" style="text-align: right;">个人中心</el-menu-item>
      </router-link>
      <router-link v-else to="/login" tag="el-menu-item" index="4" style="flex: 0 0 auto; text-align: right;">
        <el-menu-item index="4" style="text-align: right;">登录</el-menu-item>
      </router-link>
    </div>
  </el-menu>


</template>

<script>
import { ref, computed } from 'vue';

export default {

  setup() {
    const isLoggedIn = ref(false);


    const isUserLoggedIn = computed(() => {
      //TODO 写登录逻辑
      return isLoggedIn.value;
    });

    return {
      isLoggedIn,
      isUserLoggedIn,
    };
  },
};
</script>

<style>
.el-menu-demo{
  display: flex;
  justify-content: space-between;
}
.left-items {
  display: flex;
}

.right-items {
  display: flex;
  margin-right: 70px;
}
</style>
