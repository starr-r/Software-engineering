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
      <div class="search-container">
          <input input type="text" placeholder="输入搜索内容..." v-model="searchInput">
          <button @click="search($event)">搜索</button>
<!--        <ul class="m-4">
          <el-select
              v-model="value4"
              multiple
              collapse-tags
              collapse-tags-tooltip
              :max-collapse-tags="3"
              placeholder="Select"
              style="width: 240px"
          >
            <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
        </ul>-->
      </div>
      <main class="main-content">
        <!-- 主要内容区域 -->
<!--        <div class="item" v-for="item in items" :key="item.id">-->
<!--          &lt;!&ndash; 每个项目的内容 &ndash;&gt;-->
<!--        </div>-->
      </main>
    </el-container>
  </div>
</template>

<script>

  import { ref } from 'vue';
  import { useRouter } from 'vue-router';
  export default {
    name: 'search',
    setup() {
      const router = useRouter();
      const goBack = () => {
        router.go(-1);
      };
      const value4 = ref([]);
      /*const options = [
        {
          value: 'Option1',
          label: '全部结果',
        },
        {
          value: 'Option2',
          label: '明',
        },
        {
          value: 'Option3',
          label: '唐',
        },
        {
          value: 'Option4',
          label: 'Option4',
        },
        {
          value: 'Option5',
          label: 'Option5',
        },
      ];*/
      return {
          value4,
          goBack
        };
      },
    // data() {
    //   items
    // },
    methods: {
      setSearchType(type) {
        this.searchType = type;
      },
      data() {
        return {
          searchInput: "",
          searchType: 'artifactName'
        };
      },
      search(event) {
        event.preventDefault();
        this.$router.push({
          name: 'search',
          query: {
            searchInput: this.searchInput ,
            searchType: this.searchType
          }
        });
        this.searchInput="";
      },
    }
  }

</script>

<style>
.search-nav {
  display: flex;
  justify-content: center;
  margin-bottom: 1rem; /* 添加一些间距 */
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

.search-container {
  background-color: #ffffff;
  height: 225px;
  max-width: 1200px; /* 设置最大宽度 */
  min-width: 320px; /* 设置最小宽度 */

  display: flex;
  //align-items: center;
}

.search-container input {
  flex: 1;
  height: 50px;
  box-sizing: border-box;
  outline: none;
  border: none;
  width:500px;
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