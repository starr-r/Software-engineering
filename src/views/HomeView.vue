<template>
  <!--  <el-container class="home-container">-->
  <div class="block text-center">
    <el-carousel height="680px" motion-blur>
      <el-carousel-item v-for="item in items" :key="item">
        <div class="image-container">
          <img :src="item.image" alt="Logo" />
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
  <!--  </el-container>-->
</template>

<script>
import api from "../api/index";

export default {
  name: "home",
  data() {
    return {
      items: [
        { image: "https://www.shanximuseum.com/uploads/20211103/71f4df46f535ac731acc4ea45470045b.jpg", title: "2" },
        { image: " https://www.shanximuseum.com/sxo\/Uploads\/Picture\/2018\/12\/07\/s5c0a19ba25b12.jpg", title: "3" },
        { image: "https://www.shanximuseum.com/sxo\/Uploads\/Picture\/2018\/12\/10\/s5c0de59c93fcf.jpg", title: "4" },
        { image: "https://www.shanximuseum.com/sxo/Uploads/Picture/2018/12/07/s5c09e4ffa836c.jpg", title: "5" },
      ],
    };
  },
  mounted() {
    /*api.getChengpin().then(res => {
      console.log(res.data)
    })*/
  },
};
</script>

<style scoped>
.demonstration {
  color: var(--el-text-color-secondary);
}
template {
  height: 100%;
}
img {
  height: 100%;
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
