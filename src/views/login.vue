<template>
  <div style="padding-left: 430px;padding-top: 120px" id="background">
    <div class="login-wrapper">
      <div class="header">Login</div>
      <div class="form-wrapper">
        <!-- 使用 v-model 来绑定输入框的值 -->
        <input type="text" name="username" placeholder="username" class="input-item" v-model="form.username">
        <input type="password" name="password" placeholder="password" class="input-item" v-model="form.password"><!--本来输入框中内容没有绑定-->
        <input style="visibility: hidden;" type="password" name="password" placeholder="password" class="input-item" v-model="form.password">
        <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 15px;">
          <bl class="btn" @click="login()">登录</bl>
          <bl class="btn" @click="$router.push('/register')">注册</bl>
        </div>
      </div>
    </div>
  </div>
</template>


<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import request from '@/utils/request'; 
import { ElMessage, ElNotification } from 'element-plus'; // 使用 Element Plus 的消息提示

const router = useRouter();
const form = ref({
  username: '',
  password: ''
});

function login() {
  request.post('/login', form.value)
    .then((res) => {
      if (res.code === 0 && res.data) {
        // 假设后端返回的用户信息在 res.data 中
        localStorage.setItem('userInfo', JSON.stringify(res.data));
        ElMessage.success('登录成功');
        router.push('/home'); // 或者任何用户登录后应该重定向到的路由
      } else {
        // 后端返回的 code 不是 0，表示登录失败
        ElMessage.error(res.message || '登录失败，请检查用户名和密码');
      }
    })
    .catch((error) => {
      // 网络请求失败
      ElNotification({
        title: '错误',
        message: '请求服务失败，请稍后再试',
        type: 'error'
      });
      console.error('登录请求失败:', error);
    });
}
</script>
<!--<script setup> //这里测试了一下
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { ElMessage} from 'element-plus';

const router = useRouter();
const form = ref({
  username: '',
  password: ''
});

function login() {
  // 模拟网络请求的延迟
  setTimeout(() => {
    // 假设用户名是 'admin' 且密码是 'admin' 时登录成功
    if (form.value.username === 'admin' && form.value.password === 'admin') {
      // 模拟登录成功的响应
      const mockSuccessResponse = {
        code: 0,
        data: { userId: 1, username: 'admin', token: 'mock-token' }
      };
      // 存储用户信息
      localStorage.setItem('userInfo', JSON.stringify(mockSuccessResponse.data));
      ElMessage.success('登录成功');
      // 重定向到主页
      router.push('/home');
    } else {
      // 模拟登录失败的响应
      const mockErrorResponse = {
        code: 1,
        message: '用户名或密码错误'
      };
      ElMessage.error(mockErrorResponse.message);
    }
  }, 1000); // 1秒延迟
}
</script> -->
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
  height: 550px;
  border-radius: 15px;
  padding: 0 50px;
  position: absolute;
  left: 50%;
  top: 45%;
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
  background:url("../assets/img/background1.jpg");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;}
</style>