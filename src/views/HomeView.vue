<template>
<!--  <el-container class="home-container">-->
    <div class="block text-center">
      <el-carousel height="680px" motion-blur>
        <el-carousel-item v-for="item in items" :key="item">
          <div class="image-container">
            <img :src="item.image" alt="Logo">
          </div>
        </el-carousel-item>
      </el-carousel>
    </div>
<!--  </el-container>-->
</template>

<script>
import api from "../api/index"

export default {
  name: "home",
  data() {
    return {
      items: [
        { image: require('@/assets/test/1.png'), title: "1" },
        { image: require('@/assets/test/2.png'), title: "2" },
        { image: require('@/assets/test/3.png'), title: "3" },
        { image: require('@/assets/test/4.png'), title: "4" },
        { image: require('@/assets/test/5.png'), title: "5" },
      ]
    }
  },
  mounted() {
    /*api.getChengpin().then(res => {
      console.log(res.data)
    })*/
  }
}
</script>


<style scoped>
.demonstration {
  color: var(--el-text-color-secondary);
}
template{
  height: 100%;
}
img{
  height:100%
}
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.5;
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
.home-container {
  height: 100%;
  max-width: 1200px; /* 设置最大宽度 */
  min-width: 320px; /* 设置最小宽度 */
  background-color: #ececec; /* 底色 */
  margin: auto;
  width: 50%;
  flex-direction: column; /* 设置为垂直方向布局 */
}

.image-container {
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}

.image-container img {
  object-fit: cover;
  height: 100vh;
  width: 100%;
}
</style>