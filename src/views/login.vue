<template>
  <div style="padding-left: 430px;padding-top: 120px" id="background">
    <div class="login-wrapper">
      <div class="header">Login</div>
      <div class="form-wrapper">
        <input type="text" name="username" placeholder="username" class="input-item">
        <input type="password" name="password" placeholder="password" class="input-item">
        <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 15px;">
          <bl class="btn" @click="$router.push('/login')">登录</bl>
          <bl class="btn"  @click="$router.push('/register')">注册</bl>
        </div>
      </div>
    </div>

  </div>
</template>

<script setup>

import { ref } from 'vue';
import request from '@/utils/request'; // 假设你有一个封装了请求的工具函数，类似 axios
import { inject } from 'vue';

const Url = inject('$Url');
const form = ref({
  username: '',
  password: ''
});

function login() {
  request.post(Url+'/login', form.value).then((res) => {
    if (res.code === 0) {
        // 登录成功逻辑
      }
    })
    .catch((error) => {
      // 错误处理逻辑
    });
}
</script>


<style scoped>

html {
  height: 100%;
}
body {
  height: 100%;
}
.login-wrapper {
  background-color:rgba(255,255,255,0.9);
  width: 358px;
  height: 588px;
  border-radius: 15px;
  padding: 0 50px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.header {
  font-size: 38px;
  font-weight: bold;
  text-align: center;
  line-height: 200px;
}
.input-item {
  display: block;
  width: 100%;
  margin-bottom: 20px;
  border: 0;
  padding: 10px;
  border-bottom: 1px solid rgb(128, 125, 125);
  font-size: 15px;
  outline: none;
}
.input-item::placeholder {
  text-transform: uppercase;
}
.btn {
  text-align: center;
  padding: 10px;
  margin: 0 auto;
  width: 100%;
  margin-top: 40px;
  background-image: linear-gradient(to right, rgba(10,2,5,0.8), rgb(0,4,15,0.8));
  color: #fff;
}
.btn:hover {
  color: yellow;
}
a{
  text-decoration-line: none;
  color: #abc1ee;
}

#background{
  background:url("../assets/bg1.png");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;}
</style>