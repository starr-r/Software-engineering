<template>
  <p>11111111111</p>
  <div>
    <img v-for="(image, index) in images" :src="image.image" :key="index"
         @mouseover="activeIndex = index" @mouseleave="activeIndex = -1"
         :class="{ active: activeIndex === index }">
  </div>
</template>

<script>
export default {
  data() {
    return {
      images:  [
      { image: require("@/assets/test/1.png"), title: "1" },
      { image: require("@/assets/test/2.png"), title: "2" },
      { image: require("@/assets/test/3.png"), title: "3" },
      { image: require("@/assets/test/4.png"), title: "4" },
      { image: require("@/assets/test/5.png"), title: "5" },
    ],
      activeIndex: -1
    }
  }
};
</script>

<style scoped>
.active {
  transform: scale(1.1);
}
</style>