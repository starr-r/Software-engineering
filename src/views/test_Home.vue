<!--<template>
  <p class="text-center demonstration">card vertical layout</p>
  <el-carousel
      height="400px"
      direction="vertical"
      type="card"
      :autoplay="false"
  >
    <el-carousel-item v-for="item in items" :key="item">
      <img :src="item.image" alt="Logo" style="height:100%;width: 100%;">
    </el-carousel-item>
  </el-carousel>
</template>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>-->

<template>
  <el-carousel :interval="4000" type="card" height="400px" width="500px">
    <el-carousel-item v-for="item in items" :key="item">
      <div class="image-container">
        <img :src="item.image" alt="Logo" style="object-fit: contain;height: 100%;">
      </div>
    </el-carousel-item>
  </el-carousel>
</template>

<style scoped>
.image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>



<script>

import api from "../api/index"


export default {
  name:"HomeView",
  data(){
    return{
      items:[
        {image:require('@/assets/test/3.png'),title:"1"},
        {image:require('@/assets/test/2.png'),title:"2"},
        {image:require('@/assets/test/1.png'),title:"3"},
        {image:require('@/assets/test/12345.jpeg'),title:"4"},
        {image:require('@/assets/test/23456.jpeg'),title:"5"},
      ]
    }
  },
  mounted() {
    api.getChengpin().then(res=>{
      console.log(res.data)
    })
  }

}
</script>