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
import {ref} from "vue";

let temp=ref([]);
temp.value=res_artifacts.value
console.log(se_material.value)
if (se_material.value != ""&& se_material.value!="材质") {
  temp.value = temp.value.filter((artifact) => {
    return artifact.se_materialChinese === se_material.value
  });
}
if(se_relic.value != ""&&se_relic.value != '年代') {
  temp.value = temp.value.filter((artifact) => {
    return artifact.se_relicTime === se_relic.value;
  });
}
if(se_museum.value != ""&& se_museum.value!='博物馆'){
  temp.value = temp.value.filter((artifact) => {

    return artifact.libraryChinese === se_museum.value;
  });
}
total.value=temp.value.length
artifacts.value=temp.value;
</script>

<style>
/* 根据需要添加样式 */
</style>