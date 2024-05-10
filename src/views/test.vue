<template>
  <el-select
      v-model="value"
      placeholder="Select"
      size="large"
      style="width: 240px"
  >
    <el-option
        v-for="item in options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
    />

  </el-select>
</template>

<script>

</script>

<style>
/* 根据需要添加样式 */
</style>