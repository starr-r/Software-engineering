<template>
  <div class="text-container">
    <p class="text" :style="{ '-webkit-line-clamp': clampLines }">{{ content }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      content: '这里是一段很长的中文字符文本，超过三行时将在第本，超过三行时将在第本，超过三行时将在第本，超过三行时将在第本，超过三行时将在第本，超过三行时将在第ddddddddddddddddddddddddddddddd本，超过三行时将在第ddddddddddddddddddddddddddddddd本，超过三行时将在第ddddddddddddddddddddddddddddddd本，超过三行时将在第dddddddddddddddddddddddddddddddddddddddddddddddddddddd三行显示省略号。',
      clampLines: 3,
    };
  }
};
</script>

<style>
.text-container {
  width:500px;
}

.text {
  text-align: left;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  overflow: hidden;
  text-overflow: ellipsis;  /*省略号设置*/
  -webkit-line-clamp: 3;  /* 这里的数字 3 表示最多显示三行，可以根据需要进行调整 */
  line-height: 1.5;
  max-height: 4.5em;
  /* 这里的数字 4.5em 表示最多显示三行，每行的高度为 1.5em，可以根据需要进行调整 */
}
</style>