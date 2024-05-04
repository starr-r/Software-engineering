<template>
    <div id="background">
      <div style="padding: 80px 0 0 480px;">
        <el-card style="width: 40%;" shadow="always">
          <div style="margin: 10px;">
            <div style="width: 100%; text-align: center; font-weight: bolder; color: lightseagreen;">个人信息修改</div>
          </div>
  
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item style="text-align: center;" label-width="0"></el-form-item>
  
            <el-form-item label="用户名">
              <el-input v-model="form.username"></el-input>
            </el-form-item>
  
            <el-form-item label="密码">
              <el-input v-model="form.password" show-password></el-input>
            </el-form-item>
  
            <el-form-item label="头像">
              <el-upload
                class="avatar-uploader"
                action=""
                :show-file-list="false"
                :auto-upload="false"
                :on-change="handleAvatarChange"
              >
                <img v-if="form.avatarUrl" :src="form.avatarUrl" class="avatar" />
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
            </el-form-item>
  
            <el-form-item label="邮箱">
              <el-input v-model="form.email"></el-input>
            </el-form-item>
  
            <el-form-item label="手机号">
              <el-input v-model="form.phone"></el-input>
            </el-form-item>
            
            <el-form-item label="性别">
              <el-input v-model="form.gender"></el-input>
            </el-form-item>

            <el-form-item label="年龄">
              <el-input v-model="form.age"></el-input>
            </el-form-item>

            <el-form-item label="创建时间">
              <el-input v-model="form.createTime" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="更新时间">
              <el-input v-model="updatedTime" disabled></el-input>
            </el-form-item>
  
            <el-form-item label="是否禁止评论">
              <el-input v-model="isBannedText" disabled></el-input>
            </el-form-item>
          </el-form>
  
          <div style="padding-left: 90px;">
            <el-button type="primary" @click="updateUserInfo">保存</el-button>
            <el-button type="info" @click="$router.push('/user')">返回个人主页</el-button>
          </div>
        </el-card>
      </div>
    </div>
  </template>
  
  <script>
  import request from "@/utils/request";
  
  export default {
    name: "UserInfoChange",
    data() {
      return {
        form: {
          id: '',
          username: '',
          password: '',
          avatarUrl: '',
          email: '',
          phone: '',
          gender:'',
          age:'',
          createTime: '',
          updateTime: '',
          isBanned: false,
        },
        updatedTime: '',
        isBannedText: ''
      };
    },
    created() {
      const userString = sessionStorage.getItem("user") || "{}";
      const user = JSON.parse(userString);
      this.form = {
        ...this.form,
        ...user
      };
      this.isBannedText = this.form.isBanned ? '是' : '否';
    },
    methods: {
      updateUserInfo() {
        // 创建需要发送到后端的用户信息对象
        const updatedUser = {
          id: this.form.id,
          username: this.form.username,
          password: this.form.password,
          avatarUrl: this.form.avatarUrl,
          email: this.form.email,
          phone: this.form.phone,
          gender: this.form.gender,
          age: this.form.age,
          createTime: this.form.createTime,
          isBanned: this.form.isBanned
        };

        request.post("`http://localhost:8080/user/modify", updatedUser)
          .then(res => {
            console.log(res);
            if (res.code === '0') {
              this.$message({
                type: "success",
                message: "更新成功"
              });
              // 更新 sessionStorage 中的用户信息
              sessionStorage.setItem("user", JSON.stringify(res.data));
              this.$emit("userInfo");
              this.$router.push('/user');
            } else {
              this.$message({
                type: "error",
                message: res.msg
              });
            }
          })
          .catch(error => {
            console.error(error);
            this.$message.error("更新失败,请稍后重试");
          });
      }
    }
  };
  </script>
  <style scoped>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #303133;
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
  </style>