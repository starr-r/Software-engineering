<template>
  <div class="item" v-for="item in items" :key="item.id">
    <el-card class="card" style="width:1088px;flex:1">
      <div style="display: flex">
        <div style="flex: 1; padding-right: 5px">
          <img :src="item.image"/>
        </div>
        <div style="flex: 2; display: flex; flex-direction: column;margin-left: 40px ">
          <div style="text-align: left;font-size: 30px;font-weight: 700">
            <p>{{ item.title1 }}</p>
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
  <el-pagination
      v-model:current-page="currentPage"
      v-model:page-size="pageSize"
      :page-sizes="[100, 200, 300, 400]"
      :small="small"
      :disabled="disabled"
      :background="background"
      layout="total, sizes, prev, pager, next, jumper"
      :total="400"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
  />
  <p>{{currentPage}}</p>
  <p>{{startIndex}}</p>
  <p>{{items}}</p>
</template>

<script setup>
import {ref, computed} from 'vue';
import axiosInstance from "@/utils/request";
const clampLines = 4;
const artifacts = ref([
  {
    image: require('@/assets/test/1.png'),
    size: 399,
    title1: "睡眠与死亡手柄",
    time: "1967",
    des: "在石雕中，玛雅统治者用华丽的肖像来庆祝他们统治的里程碑，比如这幅皇室女性的形象，是为了纪念被称为 k'atun 的 20 年时期的过去。她最初站在一个广场上，旁边是她配偶的肖像（见图），她和她一起统治着玛雅省的一个城镇 El Perú-Waka'。作为附近玛雅中心强大王朝的成员，她似乎拥有比丈夫更高的权力，担任军事都督。她的服装反映了她的地位：头饰上有一把绿色的格查尔羽毛，她的首饰可能指的是玉——两者都是最珍贵的古代材料。玉珠也可能在她的衣服上结网，系着鱼状生物的头。完成服装的是她手中握着的权杖和盾牌。她身边的小矮人可能是一名宫廷侍从。象形文字是指重要的朝代日期"
  },
  {
    image: require('@/assets/test/1.png'),
    size: 399,
    title1: "睡眠与死亡手柄",
    time: "1967",
    des: "在石雕中，玛雅统治者用华丽的肖像来庆祝他们统治的里程碑，比如这幅皇室女性的形象，是为了纪念被称为 k'atun 的 20 年时期的过去。她最初站在一个广场上，旁边是她配偶的肖像（见图），她和她一起统治着玛雅省的一个城镇 El Perú-Waka'。作为附近玛雅中心强大王朝的成员，她似乎拥有比丈夫更高的权力，担任军事都督。她的服装反映了她的地位：头饰上有一把绿色的格查尔羽毛，她的首饰可能指的是玉——两者都是最珍贵的古代材料。玉珠也可能在她的衣服上结网，系着鱼状生物的头。完成服装的是她手中握着的权杖和盾牌。她身边的小矮人可能是一名宫廷侍从。象形文字是指重要的朝代日期"
  },
  {
    image: require('@/assets/test/2.png'),
    title1: "约拿吞下",
    time: "1967",
    des: "尽管这尊国王雕像没有铭文，但其独特的特征毫无疑问地表明它是阿梅内姆哈特三世的肖像。浓重的眉毛，突出的颧骨，凹陷的脸颊，突出的下颚，以及嘴角紧绷的肌肉，给人一种非常逼真的印象。然而，国王的超大耳朵并不现实。相反，它们象征着统治者愿意倾听人民的祈祷。如果这个图像被雕刻成浮雕，国王的双手就会举起敬拜。然而，在这里，为了防止突出的四肢断裂，统治者的手平压在他的苏格兰短裙的前面，其中一部分环绕在他的腰带上"
  },
  {
    image: require('@/assets/test/3.png'),
    title1: "抒情诗的缪斯",
    time: "1967",
    des: "设计用于连接一个大型青铜cista的盖子，一个圆柱形有盖的盒子，这三个人物可能代表抱着 Sarpedon 身体的睡眠（Hypnos）和死亡（Thanatos）。正如荷马在《伊利亚特》第十六卷中所说，宙斯的儿子帮助保卫特洛伊免受入侵的希腊军队的侵害，“铜盔的神一样的萨佩顿”落入了帕特洛克罗斯的手中。阿波罗随后介入以保护尸体，将其从危险中移除并将其托付给两个有翼的神灵，正如这里和许多其他古代艺术品所描绘的那样，希腊和伊特鲁里亚人都是如此。如果不是萨佩顿，倒下的战士可能是被阿喀琉斯杀死的厄俄斯和提托诺斯的儿子门农。"
  },
  {
    image: require('@/assets/test/4.png'),
    title1: "带浮雕的独立石",
    time: "1967",
    des: "旧约先知约拿不服从主的命令宣布对尼尼微城的审判，被抛入海中，被海怪吞下。在这里，野兽一头吞下约拿。"
  },
  {image: require('@/assets/test/5.png'), title1: "5", time: "1967", des: "1111"},
  {
    image: require('@/assets/test/1.png'),
    size: 399,
    title1: "睡眠与死亡手柄",
    time: "1967",
    des: "在石雕中，玛雅统治者用华丽的肖像来庆祝他们统治的里程碑，比如这幅皇室女性的形象，是为了纪念被称为 k'atun 的 20 年时期的过去。她最初站在一个广场上，旁边是她配偶的肖像（见图），她和她一起统治着玛雅省的一个城镇 El Perú-Waka'。作为附近玛雅中心强大王朝的成员，她似乎拥有比丈夫更高的权力，担任军事都督。她的服装反映了她的地位：头饰上有一把绿色的格查尔羽毛，她的首饰可能指的是玉——两者都是最珍贵的古代材料。玉珠也可能在她的衣服上结网，系着鱼状生物的头。完成服装的是她手中握着的权杖和盾牌。她身边的小矮人可能是一名宫廷侍从。象形文字是指重要的朝代日期"
  },
  {
    image: require('@/assets/test/2.png'),
    title1: "约拿吞下",
    time: "1967",
    des: "尽管这尊国王雕像没有铭文，但其独特的特征毫无疑问地表明它是阿梅内姆哈特三世的肖像。浓重的眉毛，突出的颧骨，凹陷的脸颊，突出的下颚，以及嘴角紧绷的肌肉，给人一种非常逼真的印象。然而，国王的超大耳朵并不现实。相反，它们象征着统治者愿意倾听人民的祈祷。如果这个图像被雕刻成浮雕，国王的双手就会举起敬拜。然而，在这里，为了防止突出的四肢断裂，统治者的手平压在他的苏格兰短裙的前面，其中一部分环绕在他的腰带上"
  },
  {
    image: require('@/assets/test/3.png'),
    title1: "抒情诗的缪斯",
    time: "1967",
    des: "设计用于连接一个大型青铜cista的盖子，一个圆柱形有盖的盒子，这三个人物可能代表抱着 Sarpedon 身体的睡眠（Hypnos）和死亡（Thanatos）。正如荷马在《伊利亚特》第十六卷中所说，宙斯的儿子帮助保卫特洛伊免受入侵的希腊军队的侵害，“铜盔的神一样的萨佩顿”落入了帕特洛克罗斯的手中。阿波罗随后介入以保护尸体，将其从危险中移除并将其托付给两个有翼的神灵，正如这里和许多其他古代艺术品所描绘的那样，希腊和伊特鲁里亚人都是如此。如果不是萨佩顿，倒下的战士可能是被阿喀琉斯杀死的厄俄斯和提托诺斯的儿子门农。"
  },
  {
    image: require('@/assets/test/4.png'),
    title1: "带浮雕的独立石",
    time: "1967",
    des: "旧约先知约拿不服从主的命令宣布对尼尼微城的审判，被抛入海中，被海怪吞下。在这里，野兽一头吞下约拿。"
  },
  {image: require('@/assets/test/5.png'), title1: "5", time: "1967", des: "1111"},
])
const currentPage = ref(5)
const pageSize = ref(5)
const small = ref(false)
const background = ref(false)
const disabled = ref(false)
const startIndex=ref(1)
const handleSizeChange = (val) => {
  pageSize.value = val
}
const handleCurrentChange = (val) => {
  currentPage.value = val;
}
const items = computed(() => {
  startIndex.value = (currentPage.value - 1) * pageSize.value;
  const endIndex = startIndex.value + pageSize.value;
  console.log("!!!!!!!!!!!!!!!")
  // console.log(artifacts.value.slice(0, 3))
  // return artifacts.value.slice(0, 3);
  return artifacts.value.slice(startIndex.value, endIndex);
  return artifacts.value.values();
});

/*const fetchitems = () => {
  const userId = this.user.id;
  axiosInstance.get(`/api/items/${userId}`).then(response => {
    this.items = response.data.map(item => ({
      ...item,
      create_time: this.formatDateTime(item.create_time), // 格式化时间
    }));
  }).catch(error => {
    console.error('Error fetching items:', error);
  });
}*/


</script>

<style scoped>
.demo-pagination-block {
  margin-top: 10px;
}
.card {
  flex: 1;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 添加阴影效果 */
  margin-top: 15px;
  margin-left: 56px;
  margin-right: 56px;
  height: 300px;
}
.demo-pagination-block .demonstration {
  margin-bottom: 16px;
}
</style>