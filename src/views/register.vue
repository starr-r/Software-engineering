<template>
  <div style="padding-left: 430px;padding-top: 120px" id="background">
    <div class="registry-wrapper">
      <div class="header">Register</div>
      <div class="form-wrapper">
        <input type="text" name="username" placeholder="username" class="input-item">
        <input type="password" name="password" placeholder="password" class="input-item">
        <input type="password" name="password" placeholder="confirm you password" class="input-item">
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
  name: "register",
  data(){
    return{
      form:{},
      rules:{
        username:[
          {required:true,message:'请输入用户名',trigger:'blur'},
        ],
        password:[
          {required:true,message:'请输入密码',trigger:'blur'},
        ],
        confirm:[
          {required:true,message:'请确认密码',trigger:'blur'},
        ],
      }
    }
  },
  methods:{
    register(){
      if(this.form.password!==this.form.confirm){
        ElMessage({
          type: 'error',
          message: '两次密码输入不一致',
        })
        return
      }

      this.$refs['form'].validate((valid)=> {

        if(valid){
          request.post("/user/register",this.form).then(res=>{
            if(res.code==0) {
              ElMessage({
                type: 'success',
                message: '注册成功',
              })
              this.$router.push("/login")
            }
            else{
              ElMessage({
                type: 'error',
                message: '用户名已被注册',
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
.registry-wrapper {
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
  background:url("../assets/bg2.jpg");
  width:100%;
height:100%;
position:fixed;
  background-size:100% 100%;}
</style>