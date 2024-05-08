html
复制
<template>
  <div>
    <!-- 图片和查看按钮 -->
    <p>1111111111</p>
    <div v-for="item in items" :key="item">
      <p>{{item.image}}</p>

      <div class="image-container">
        <img :src="item.image" alt="Sample Image" @click="openModal" />
        <button @click="openModal">查看</button>
      </div>

      <!-- 模态框，用于全屏显示图片 -->
      <div v-if="isModalOpen" class="modal">
        <div class="modal-content">
          <img :src="item.image" alt="Sample Image" :style="imageStyles" />
          <div class="button-container">
            <button @click="rotateImage">旋转</button>
            <button @click="zoomIn">放大</button>
            <button @click="zoomOut">缩小</button>
            <button @click="closeModal">关闭</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue';

const items = [
  { image: require('@/assets/test/1.png'), title: '1' },
  { image: require('@/assets/test/2.png'), title: '2' },
  { image: require('@/assets/test/3.png'), title: '3' },
  { image: require('@/assets/test/4.png'), title: '4' },
  { image: require('@/assets/test/5.png'), title: '5' },
];
const isModalOpen = ref(false);
const scale = ref(1);
const rotation = ref(0);
const currentItem = ref(null);

const imageStyles = computed(() => {
  return {
    transform: `scale(${scale.value}) rotate(${rotation.value}deg)`,
  };
});

const openModal = (item) => {
  currentItem.value = item;
  isModalOpen.value = true;
};

const closeModal = () => {
  isModalOpen.value = false;
};

const rotateImage = () => {
  rotation.value += 90;
};

const zoomIn = () => {
  scale.value += 0.1;
};

const zoomOut = () => {
  scale.value = Math.max(0.1, scale.value - 0.1);
};
</script>

<style>
.modal {
  position: fixed; /* 固定位置 */
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* 半透明背景 */
  display: flex;
  align-items: center;
  justify-content: center;
}

.modal-content {
  position: relative;
  padding: 20px;
  background: white;
  border-radius: 10px;
}

.modal-content img {
  max-width: 90vw; /* 控制图片最大宽度 */
  max-height: 90vh; /* 控制图片最大高度 */
}
</style>