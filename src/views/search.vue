<template>
  <div class="app">
    <el-container class="home-container">
      <el-header
        ><!-- 头部区 -->
        <div class="bbk">
          <el-page-header @back="goBack">
            <template #content>
              <span class="text-large font-600 mr-3"> 文物检索 </span>
            </template>
          </el-page-header>
        </div>
      </el-header>
      <div class="search-nav">
        <span
          :class="{ active: searchType === 'artifact' }"
          @click="setSearchType('artifact')"
          >文物名称</span
        >
        <span>|</span>
        <span
          :class="{ active: searchType === 'museum' }"
          @click="setSearchType('museum')"
          >博物馆</span
        >
        <span>|</span>
        <span
          :class="{ active: searchType === 'relicTime' }"
          @click="setSearchType('relicTime')"
          >文物年代</span
        >
      </div>
      <div class="input-wrapper">
        <div class="search-container">
          <input input type="text" placeholder="输入搜索内容..." v-model="searchInput"   />
          <button class="search1" @click="search">搜索</button>
          <el-button
            size="large"
            style="margin-left: 10px"
            class="search2"
            :icon="Search"
            round
            @click="$router.push('/advanced_search')"
            >Advanced Search</el-button
          >
        </div>
      </div>
      <div class="changeTime_container">
        <el-pagination
          v-model:current-page="currentPage"
          v-model:page-size="pageSize"
          :page-sizes="[5, 10, 20, 30]"
          :disabled="disabled"
          :background="background"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          style="margin-left: 260px"
        />
        <div class="changeTime" style="width: 120px" @click="changeTime">
          时间顺序
          <div class="box-icon">
            <div class="up" :class="{ 'opacity-5': time_status === 1 }"></div>
            <div class="down" :class="{ 'opacity-1': time_status === 1 }"></div>
          </div>
        </div>
      </div>
      <main class="main-content" style="font-family: 宋体, SimSun, sans-serif">
        <div class="item" v-for="item in items" :key="item.id">
          <el-card class="card" style="width: 1088px; flex: 1">
            <div style="display: flex">
              <div style="flex: 1; padding-right: 5px">
                <RouterLink :to="'/artifact/' + item.id">
                  <img :src="item.imageUrl" />
                </RouterLink>
              </div>
              <div
                style="flex: 2; display: flex; flex-direction: column; margin-left: 40px"
              >
                <div style="text-align: left; font-size: 30px; font-weight: 700">
                  <RouterLink :to="'/artifact/' + item.id" style="text-decoration: none">
                    <p style="color: black;">{{ item.artifactNameChinese }}</p>
                  </RouterLink>
                </div>
                <div class="info-container">
                  <div class="info-item">
                    <span class="title">藏品时代:</span>
                    <span class="content">{{ item.relicTime }}</span>
                  </div>
                  <div class="info-item">
                    <span class="title">规格:</span>
                    <span class="content">{{ item.sizeChinese }}</span>
                  </div>
                  <div class="text-container">
                    <span class="title">简介:</span>
                    <span class="text" :style="{ '-webkit-line-clamp': clampLines }">{{
                      item.descriptionChinese
                    }}</span>
                  </div>
                </div>
              </div>
            </div>
          </el-card>
        </div>
      </main>
      <el-backtop :right="100" :bottom="100" style="color: #8c8c45" />
    </el-container>
  </div>
</template>
<script setup>
import { Search } from "@element-plus/icons-vue";
import { useRouter } from "vue-router";
import { ref, onMounted, computed } from "vue";
import Mock from "mockjs";
import axios from "axios";
import request from "@/utils/request";
import { inject } from "vue";

const Url = inject("$Url");
const clampLines = 4;
const total = ref(0);
const router = useRouter();

const searchInput = ref("");
const searchType = ref("artifact");

const nowUrl = ref("");

/*默认0为升序 1为降序*/
const time_status = ref(0);

const goBack = () => {
  router.go(-1);
};

onMounted(searchAll);

const artifacts = ref([]);

const currentPage = ref(1);
const pageSize = ref(5);
const background = ref(false);
const disabled = ref(false);
const startIndex = ref(1);
const handleSizeChange = (val) => {
  pageSize.value = val;
};
const handleCurrentChange = (val) => {
  currentPage.value = val;
};
const items = computed(() => {
  startIndex.value = (currentPage.value - 1) * pageSize.value;
  const endIndex = startIndex.value + pageSize.value;
  return artifacts.value.slice(startIndex.value, endIndex);
});

async function changeTime() {
  time_status.value = time_status.value ^ 1;
  const res = await axios.get(nowUrl.value + time_status.value);
  artifacts.value = res.data.data;
  total.value = res.data.total;
}

async function searchAll() {
  console.log("11111111111");
  nowUrl.value = Url + "/searchAll?order=";
  console.log(nowUrl.value + time_status.value);
  const res = await axios.get(nowUrl.value + time_status.value);
  artifacts.value = res.data.data;
  total.value = res.data.total;
}

const setSearchType = (type) => {
  searchType.value = type;
};

const search = async () => {
  let url = "";
  console.log(searchType.value);
  switch (searchType.value) {
    case "artifact":
      url = Url + "/artifact?artifactName=";
      break;
    case "museum":
      url = Url + "/search_museum?museumName=";
      break;
    case "relicTime":
      url = Url + "/search_relicTime?relicTime=";
      break;
  }
  nowUrl.value = url + searchInput.value + "&" + "order=";
  url = nowUrl.value + time_status.value;
  console.log(url);
  const res = await axios.get(url);
  artifacts.value = res.data.data;
  total.value = res.data.total;
  console.log(artifacts.value);
};
</script>

<style scoped>
.changeTime_container {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.changeTime {
  padding: 0 20px;
  height: 32px;
  color: #505363;
  font-weight: bold;
  font-size: 14px;
  margin-left: auto;
  margin-right: 25px;
  display: flex;
  line-height: 32px;
  cursor: pointer;
}
.right:hover {
  color: #217aff;
  border: 1px solid #217aff;
}
.opacity-5 {
  opacity: 0.5;
}
.opacity-1 {
  opacity: 1 !important;
}
.box-icon {
  height: 30px;
  margin-top: 7px;
}
.box-icon .up {
  width: 0;
  height: 0;
  border-bottom: 6px solid #a3a5b3;
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  margin-bottom: 4px;
}
.box-icon .down {
  width: 0;
  height: 0;
  opacity: 0.5;
  border-top: 6px solid #a3a5b3;
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
}

.text-container {
  display: flex;
  font-size: 20px;
}

.text {
  width: 500px;
  text-align: left;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis; /*省略号设置*/
  -webkit-line-clamp: 4; /* 这里的数字 3 表示最多显示三行，可以根据需要进行调整 */
  line-height: 1.5;
  max-height: 6em;
  /* 这里的数字 4.5em 表示最多显示三行，每行的高度为 1.5em，可以根据需要进行调整 */
}

.info-container {
  display: flex;
  flex-direction: column;
}

.info-item {
  font-size: 20px;
  display: flex;
}

.title {
  font-weight: bold;
  width: 100px;
  text-align: left;
}

.search2:hover {
  background-color: #f2f2f2; /* 设置鼠标悬停时的背景颜色为浅红色 */
  color: #888;
}

.main-content {
  display: flex;
  flex-direction: column;
}
.main-content > div {
  flex: 1;
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
  color: #cccc5c; /* 激活状态的颜色 */
}
el-page-header_header {
  margin-top: 10px;
}
el-header {
  height: 80px;
  background-color: #ececec;
}

.card {
  flex: 1;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
  margin-top: 15px;
  margin-left: 56px;
  margin-right: 56px;
}
/*:deep(.el-card__body){
  padding:0;
}*/

.text-large {
  font-size: 15px;
}

.app {
  background-color: #5b2528;
  display: flex;
}
.home-container {
  height: 100%;
  min-height: 1500px;
  max-width: 1200px; /* 设置最大宽度 */
  min-width: 320px; /* 设置最小宽度 */
  background-color: #ececec; /* 底色 */
  margin: auto;
  width: 50%;
  flex-direction: column; /* 设置为垂直方向布局 */
}

.bbk {
  margin-top: 20px;
}
img {
  margin-top: 20px;
  margin-bottom: 20px;
  width: 350px;
  height: 250px;
  object-fit: contain;
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

.input-wrapper {
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 23px;
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
.item {
  flex-basis: calc(50% - 10px); /* 动态计算宽度减去间隔 */
}
.search-container .search1 {
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
