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




<script>
import {ElMessage} from "element-plus";
import request from "@/utils/request";
export default {
  name: "login",
  data() {
    return {
      form: {},
      rules:{
        username:[
          {required:true,message:'请输入用户名',trigger:'blur'},
        ],
        password:[
          {required:true,message:'请输入密码',trigger:'blur'},
        ],
      }
    }

  },
  methods:{
    login(){
      this.$refs['form'].validate((valid)=>{
        if(this.form.username=='admin'&&this.form.password=='666666'){
          this.$router.push("/admin_web"),
              ElMessage({
                type: 'success',
                message: '登录成功',
              })
        }
        else if(valid){
          request.post("/user/login",this.form).then(res=>{
            if(res.code==0){
              ElMessage({
                type: 'success',
                message: '登录成功',
              })
              sessionStorage.setItem("user", JSON.stringify(res.data))  // 缓存用户信息
              this.$router.push("/wen_wu")
            }else{
              ElMessage({
                type: 'error',
                message: '用户名或密码错误',
              })
            }
          })
        }
      })

    }
  }
}
</script>

<style>

html {
  height: 100%;
}
body {
  height: 100%;
}
.container {
  /* margin-top: 5%; */
  height: 980px;
  width: 100%;
  background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
}
.login-wrapper {
  background-color: #fff;
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
  background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
  color: #fff;
}
.msg {
  text-align: center;
  line-height: 88px;
}
a {
  text-decoration-line: none;
  color: #abc1ee;
}

#background{
  background:url("../assets/bg.jpg");
  width:100%;
  height:100%;
  position:fixed;
  background-size:100% 100%;}
</style>