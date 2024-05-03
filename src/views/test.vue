<template>
  <div class="right" @click="changeTime">
    时间顺序
    <div class="box-icon">
      <div class="up" :class="{'opacity-5': time_status === 1}"></div>
      <div class="down" :class="{'opacity-1': time_status=== 1}"></div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const time_status = ref(0);

const changeTime = () => {
  time_status.value = time_status.value === 0 ? 1 : 0;
};
</script>

<style scoped>
.right {
  padding: 0 20px;
  height: 32px;
  color: #505363;
  font-weight: 400;
  font-size: 14px;
  margin-left: 10px;
  border: 1px solid rgb(233, 231, 231);
  display: flex;
  justify-content: center;
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
</style>