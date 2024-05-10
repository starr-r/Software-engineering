<template>
  <div>
    <iframe :src="iframeUrl" width="800" height="600"></iframe>
  </div>
</template>

<script>
export default {
  data() {
    return {
      iframeUrl: "https://www.shanximuseum.com/sxo//Uploads//3d_show//58qinghuachanzhimudanwenguan//QHG.html"
    };
  }
};
</script>

<style>
/* 根据需要添加样式 */
</style>