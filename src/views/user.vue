<template>
    <div id="background">
      <div style="padding: 80px 0 0 480px;">
        <el-card style="width: 50%;" shadow="always">
          <div style="margin: 10px;">
            <div style="width: 100%; text-align: center; font-weight: bolder; color: lightseagreen;">个人信息</div>
          </div>
  
          <el-form ref="form" :model="form" label-width="90px">
            <el-form-item style="text-align: center;" label-width="0">
              <el-avatar :src="form.avatarUrl" :size="100"></el-avatar>
            </el-form-item>
  
            <el-form-item label="用户ID">
              <el-input v-model="form.id" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="用户名">
              <el-input v-model="form.username" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="密码">
              <el-input v-model="form.password" disabled show-password></el-input>
            </el-form-item>
  
            <el-form-item label="邮箱">
              <el-input v-model="form.email" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="手机号">
              <el-input v-model="form.phone" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="创建时间">
              <el-input v-model="form.createTime" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="更新时间">
              <el-input v-model="form.updateTime" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="是否禁止评论">
              <el-input v-model="isBannedText" disabled></el-input>
            </el-form-item>
          </el-form>
  
          <div style="text-align: center;">
            <el-button type="primary" @click="navigateToUserInfoChange">修改信息</el-button>
            <el-button type="info" @click="navigateToHome">返回</el-button>
          </div>
        </el-card>
      </div>
    </div>
  </template>
  
  <script>
  import request from "@/utils/request";
  
  export default {
    name: "UserInfo",
    data() {
      return {
        form: {}
      };
    },
    computed: {
      isBannedText() {
        return this.form.isBanned ? '是' : '否';
      }
    },
    created() {
      const userString = sessionStorage.getItem("user") || "{}";
      this.form = JSON.parse(userString);
    },
    methods: {
      navigateToUserInfoChange() {
        this.$router.push("/user_info_change");
      },
      navigateToHome() {
        this.$router.push("/home");
      }
    }
  };
  </script>
  <style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  
  .avatar-uploader .el-upload:hover {
    border-color: #409eff;
  }
  
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 120px;
    height: 120px;
    line-height: 120px;
    text-align: center;
  }
  
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
  
  #background {
    background: url("/src/assets/bg.jpg");
    width: 100%;
    height: 100%;
    position: fixed;
    background-size: 100% 100%;
  }
  </style>