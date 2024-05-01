<template>
  <div class="app">
    <el-container class="home-container">
      <el-header><!-- 头部区 -->
        <div class="bbk">
          <el-page-header @back="goBack">
            <template #content>
              <span class="text-large font-600 mr-3"> 文物检索 </span>
            </template>
          </el-page-header>
        </div>
      </el-header>
      <div class="search-nav">
        <span :class="{'active': searchType === 'arifact'}" @click="setSearchType('arifact')">文物</span>
        <span>|</span>
        <span :class="{'active': searchType === 'museum'}" @click="setSearchType('museum')">博物馆</span>
        <span>|</span>
        <span :class="{'active': searchType === 'relicTime'}" @click="setSearchType('relicTime')">时代</span>
      </div>
      <div class="input-wrapper">
        <div class="search-container">
          <input input type="text" placeholder="输入搜索内容..." v-model="searchInput">
          <button @click="search($event)">搜索</button>
        </div>
      </div>
      <main class="main-content">
        <div class="item" v-for="item in items" :key="item.id">
          <el-card class="card" style="width:1088px;flex:1" >
            <div style="display: flex">
              <div style="flex: 1; padding-right: 5px">
                <img :src="item.image"/>
              </div>
              <div style="flex: 2; display: flex; flex-direction: column;margin-left: 40px ">
                <div style="text-align: left;font-size: 30px;font-weight: 700">
                  <p>{{item.title1}}</p>
                </div>
                <div class="info-container">
                  <div class="info-item">
                    <span class="title">藏品时代:</span>
                    <span class="content">{{ item.time }}</span>
                  </div>
                  <div class="info-item">
                    <span class="title">规格:</span>
                    <span class="content">{{ item.size }}</span>
                  </div>
                  <div class="text-container">
                    <span class="title">简介:</span>
                    <span class="text" :style="{ '-webkit-line-clamp': clampLines }">{{ item.des }}</span>
                  </div>
                </div>

              </div>
            </div>
          </el-card>
        </div>
      </main>
    </el-container>
  </div>
</template>
<script setup>
import { useRouter } from 'vue-router';
import { ref } from 'vue';

const clampLines= 4;


const router = useRouter();

const searchInput = ref('');
const searchType = ref('artifactName'); // Reactive search type state

const goBack = () => {
  router.go(-1);
};

const items = [
  { image: require('@/assets/test/1.png'),size:399, title1: "睡眠与死亡手柄",time:"1967",des:"在石雕中，玛雅统治者用华丽的肖像来庆祝他们统治的里程碑，比如这幅皇室女性的形象，是为了纪念被称为 k'atun 的 20 年时期的过去。她最初站在一个广场上，旁边是她配偶的肖像（见图），她和她一起统治着玛雅省的一个城镇 El Perú-Waka'。作为附近玛雅中心强大王朝的成员，她似乎拥有比丈夫更高的权力，担任军事都督。她的服装反映了她的地位：头饰上有一把绿色的格查尔羽毛，她的首饰可能指的是玉——两者都是最珍贵的古代材料。玉珠也可能在她的衣服上结网，系着鱼状生物的头。完成服装的是她手中握着的权杖和盾牌。她身边的小矮人可能是一名宫廷侍从。象形文字是指重要的朝代日期" },
  { image: require('@/assets/test/2.png'), title1: "约拿吞下",time:"1967" ,des:"尽管这尊国王雕像没有铭文，但其独特的特征毫无疑问地表明它是阿梅内姆哈特三世的肖像。浓重的眉毛，突出的颧骨，凹陷的脸颊，突出的下颚，以及嘴角紧绷的肌肉，给人一种非常逼真的印象。然而，国王的超大耳朵并不现实。相反，它们象征着统治者愿意倾听人民的祈祷。如果这个图像被雕刻成浮雕，国王的双手就会举起敬拜。然而，在这里，为了防止突出的四肢断裂，统治者的手平压在他的苏格兰短裙的前面，其中一部分环绕在他的腰带上"},
  { image: require('@/assets/test/3.png'), title1: "抒情诗的缪斯",time:"1967" ,des:"设计用于连接一个大型青铜cista的盖子，一个圆柱形有盖的盒子，这三个人物可能代表抱着 Sarpedon 身体的睡眠（Hypnos）和死亡（Thanatos）。正如荷马在《伊利亚特》第十六卷中所说，宙斯的儿子帮助保卫特洛伊免受入侵的希腊军队的侵害，“铜盔的神一样的萨佩顿”落入了帕特洛克罗斯的手中。阿波罗随后介入以保护尸体，将其从危险中移除并将其托付给两个有翼的神灵，正如这里和许多其他古代艺术品所描绘的那样，希腊和伊特鲁里亚人都是如此。如果不是萨佩顿，倒下的战士可能是被阿喀琉斯杀死的厄俄斯和提托诺斯的儿子门农。" },
  { image: require('@/assets/test/4.png'), title1: "带浮雕的独立石",time:"1967",des:"旧约先知约拿不服从主的命令宣布对尼尼微城的审判，被抛入海中，被海怪吞下。在这里，野兽一头吞下约拿。"},
  { image: require('@/assets/test/5.png'), title1: "5" ,time:"1967" ,des:"1111"},
];

/*
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
*/

const setSearchType = (type) => {
  searchType.value = type;
};

/*
let url;
switch (type) {
  case 'arifact':
    url = `http://192.168.31.53:8000/web/search/?query=${encodeURIComponent(query)}`;
    break;
  case 'museum':
    url = `http://192.168.31.53:8000/web/search_museum/?query=${encodeURIComponent(query)}`;
    break;
  case 'relicTime':
    url = `http://192.168.31.53:8000/web/search_relicTime/?query=${encodeURIComponent(query)}`;
    break;
}
try {
  const response = await axios.post(url, {
    searchText: query,
    cancelToken: this.cancelTokenSource.token
  });

  if (response.data.status === "数据已经成功接收") {
    console.log("数据成功发送到服务器并被接收。");
  } else {
    console.log("数据发送失败。");
  }
  switch (type) {
    case 'arifact':
      this.searchResult = {
        db6: response.data.db6,
        db5: response.data.db5,
      };
      break;
    case 'museum':
      this.searchResult = {
        museum: response.data.museum,
      };
      console.log(this.searchResult);
      console.log(this.searchResult.museum[0])
      break;
    case 'relicTime':
      this.searchResult = {
        relicTime: response.data.relicTime,
      };
      console.log(this.searchResult);
      console.log(this.searchResult.relicTime[0])
      break;
    }
}catch (error) {
  if (axios.isCancel(error)) {
    console.log('Request canceled', error.message);
  } else {
    this.error = "搜索出错：" + error;
    console.log(error);
  }
} finally {
  this.loading = false;
}
*/

</script>

<style scoped>

.text-container {
  display: flex;
  font-size: 20px;
  margin: 10px 0;
}

.text {
  margin-left: 50px;
  text-align: left;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;  /*省略号设置*/
  -webkit-line-clamp: 4;  /* 这里的数字 3 表示最多显示三行，可以根据需要进行调整 */
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


.main-content{
  display: flex;
  flex-direction: column;
}
.main-content> div {
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
el-page-header_header{
  margin-top: 10px;
}
el-header{
  height: 80px;
  background-color: #ececec;
}

.card {
  flex: 1;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
  margin-top:15px;
  margin-left: 56px;
  margin-right: 56px;

}
/*:deep(.el-card__body){
  padding:0;
}*/


.text-large{
  font-size:15px;
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

.bbk{
  margin-top: 20px;
}
img {
  margin:5px;
  width: 350px;
  height: 300px;
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

.input-wrapper{
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
