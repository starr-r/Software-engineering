<template>
  <p>11111111111</p>
  <p>artifact[0].country</p>
</template>

<script>
import axios from "axios";
import {ref} from 'vue';

const artifact=ref([])
const res = await axios.get("http://localhost:8080/searchAll");
artifact.value=res.data.data
console.log("!!!!!!!!!!!!")
console.log(res.data.code)
console.log(artifact.value[0])

</script>

<style scoped>

</style>