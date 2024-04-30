<template>
  <div class="app">
    <el-container class="home-container">
      <el-header><!-- 头部区 -->
        <el-page-header @back="goBack">
          <template #content>
            <span class="text-large font-600 mr-3"> 文物检索 </span>
          </template>
        </el-page-header>
      </el-header>
      <div class="search-nav">文物|博物馆|年代</div>
      <div class="input-wrapper">
         <div class="search-container">

              <input input type="text" placeholder="输入搜索内容..." v-model="searchInput">
              <button @click="search($event)">搜索</button>
         </div>
      </div>
      <main class="main-content">
        <!-- 主要内容区域 -->
        <div class="item" v-for="item in items" :key="item.id">
          <img :src="item.image">
        </div>
      </main>
    </el-container>
  </div>
</template>
<script setup>
import { useRouter } from 'vue-router';
import { ref } from 'vue';

const router = useRouter();

const searchInput = ref('');
const searchType = ref('artifactName'); // Reactive search type state

const goBack = () => {
  router.go(-1);
};

const items = [
  { image: require('@/assets/test/1.png'), title: "1" },
  { image: require('@/assets/test/2.png'), title: "2" },
  { image: require('@/assets/test/3.png'), title: "3" },
  { image: require('@/assets/test/4.png'), title: "4" },
  { image: require('@/assets/test/5.png'), title: "5" },
];

const search = (event) => {
  event.preventDefault();
  router.push({
    name: 'search', // Assuming search is a named route
    query: {
      searchInput: searchInput.value, // Use value property for reactive refs
      searchType: searchType.value,
    },
  });
  searchInput.value = ''; // Clear search input after submission
};

const setSearchType = (type) => {
  searchType.value = type;
};

</script>

<style>

.main-content{
  display: flex;
}
.search-nav {
  display: flex;
  justify-content: center;
  background-color: #ffffff;
}

.search-nav span {
  color: rgb(128, 128, 128); /* 默认颜色为灰色 */
  cursor: pointer;
  padding: 0.5rem; /* 增加点击区域 */
}

.search-nav span.active {
  color: yellow; /* 激活状态的颜色为黄色 */
}

el-header{
  height: 88px;
  background-color: #ececec;
}
.m-4{
  list-style: none;
  margin: 4px; /* 调整上下间距 */
  display: inline-block;
}

.app {
  background-color: #5b2528;
  display: flex;
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

img{
  width: 170px;
  height: 170px;
  object-fit: cover;
}
.search-container {
      background-color: #ffffff;
      height: 100px;
      width: 100%; /* 设置最大宽度 */
      margin: auto;
      display: flex;
      justify-content: center;
      align-items: center;

}
     
.input-wrapper{
    width: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
  }
     
.search-container input {
      height: 50px;
      box-sizing: border-box;
      outline: none;
      border: none;
      width: 500px;
      border-top-left-radius: 15px;
      border-bottom-left-radius: 15px;
      padding: 0 20px;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.search-container button {
      cursor: pointer;
      height: 50px;
      padding: 0 30px;
      border: none;
      box-sizing: border-box;
      background-color: #5b2528;
      font-size: 24px;
      color: #fff;
      border-top-right-radius: 15px;
      border-bottom-right-radius: 15px;
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
</style>