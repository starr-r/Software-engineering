<script setup>
import { provide, ref } from "vue";
const radio = ref(["包含"]);

const option = ref([]);
option.value.push([
  { value: "选项1", label: "黄金糕" },
  { value: "选项2", label: "双皮奶" },
  { value: "选项3", label: "蚵仔煎" },
]);
const searchText = ref([]);
searchText.value.push("");
const value = ref([]);
value.value.push("");
const cnts = ref(1);
const add = () => {
  radio.value.push("包含");
  option.value.push([
    { value: "选项1", label: "黄金糕" },
    { value: "选项2", label: "双皮奶" },
    { value: "选项3", label: "蚵仔煎" },
  ]);
  value.value.push("");
  cnts.value++;
};
const sub = () => {
  radio.value.pop();
  option.value.pop();
  value.value.pop();
  cnts.value--;
};
</script>
<template>
  <main>
    <div class="container">
      <h1>高级搜索</h1>
      <div style="display: flex; justify-content: space-between">
        <el-button round @click="add()">增加条件</el-button>
        <el-button round @click="sub()">-</el-button>
      </div>
      <form action="#">
        <div v-for="cnt in cnts" class="input-group">
          <p>{{ searchText[cnt - 1] }}</p>
          <el-select
            style="display: block; width: 120px"
            v-model="value[cnt - 1]"
            placeholder="请选择"
          >
            <el-option
              v-for="item in option[cnt - 1]"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
          <input
            v-model="searchText[cnt - 1]"
            type="text"
            id="keywords"
            name="keywords"
            placeholder="请输入关键词"
          />
          <div>
        
            <el-radio-group v-model="radio[cnt - 1]" fill="#5b2528">
              <el-radio-button label="包含"></el-radio-button>
              <el-radio-button label="精确"></el-radio-button>
            </el-radio-group>
          </div>
        </div>

        <div class="input-group">
          <input type="submit" value="搜索" />
        </div>
      </form>
    </div>
  </main>
</template>

<style scoped>
.el-button {
  border: none;
  padding: auto;
  width: 80px;
  height: 50px;
  cursor: pointer;
  background-color: #5b2528;
  border-radius: 5px;
  color: white;
  /* font-size: 10px; */
  margin-bottom: 20px;
  margin-left: 10px;
}
main {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  background-color: #f4f4f4;
}
.container {
  max-width: 800px;
  margin: 20px auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.container h1 {
  font-size: 24px;
  margin-bottom: 20px;
}
.el-radio-button :hover{
    color: #cc8d8f;
    /* background-color: rgba(238, 185, 185, 0.8); */
}
.input-group {
  display: flex;
  flex-wrap: nowrap;
  gap: 10px;
  margin-bottom: 20px;
}

.input-group .param {
  flex: 0 0 120px;
  text-align: start;
}

.input-group input {
  flex: 1;
  padding: 5px;
  border-radius: 3px;
  border: 1px solid #ccc;
  margin-left: 5px;
}

.input-group input[type="submit"] {
  flex: 1 0 100%;
  background-color: #5b2528;
  color: #fff;
  border: none;
  cursor: pointer;
  padding: 10px;
  border-radius: 3px;
}

.input-group input[type="submit"]:hover {
  background-color: #e4ae7b;
}

@media (max-width: 600px) {
  .input-group input {
    flex: 1 0 100%;
  }
}
</style>
