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
    <el-menu-item index="1">海外文物服务知识子系统</el-menu-item>
    <el-menu-item index="4">首页</el-menu-item>
    <el-sub-menu index="2">
      <template #title>藏馆信息</template>
      <el-menu-item index="2-1">item one</el-menu-item>
      <el-sub-menu index="2-2">
        <template #title>item four</template>
        <el-menu-item index="2-2-1">item one</el-menu-item>
        <el-menu-item index="2-2-2">item two</el-menu-item>
      </el-sub-menu>
    </el-sub-menu>
    <el-menu-item index="3" disabled>文物信息</el-menu-item>
    <el-menu-item index="4">文物知识图谱</el-menu-item>
    <el-menu-item index="4" >文物时间轴</el-menu-item>
    <el-menu-item index="4">新闻资讯</el-menu-item>
    <el-menu-item index="4">新用户注册</el-menu-item>
    <el-menu-item index="4">app下载</el-menu-item>
    <el-menu-item index="4">问答系统</el-menu-item>
  </el-menu>


</template>

<script lang="ts" setup>

import { ref } from 'vue'

const activeIndex = ref('1')
const activeIndex2 = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>
