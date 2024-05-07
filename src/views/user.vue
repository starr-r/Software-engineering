<template>
  <div class="user-homepage">
    <aside class="sidebar">
      <div class="profile">
        <img :src="user.avatarUrl" alt="User Avatar" class="avatar" />
        <h1>{{ user.username }}</h1>
        <div v-if="user.abanned" class="banned-container">
          <span class="banned-text">您已被禁止评论</span>
          <img src="@/assets/img/BannedIcon.png" alt="Banned Icon" class="banned-icon" />
        </div>
        <button @click="EditProfile">修改个人信息</button>
        <button @click="ReturnToHomePage">返回主页</button>
        <router-link to="/home" tag="el-menu-item">
          <button @click="logout">退出登录</button>
        </router-link>
      </div>
      <!-- 其他个人信息展示 -->
    </aside>

    <main class="comments-main">
      <h1>用户评论</h1>
      <div v-for="comment in displayedComments" :key="comment.id" class="comment">
        <div class="comment-artifact">
          <img
            :src="comment.artifact_image"
            alt="Artifact Image"
            class="artifact-image"
          />
          <div class="artifact-info">
            <h2>{{ comment.artifact_name }}</h2>
          </div>
        </div>
        <p class="comment-text">{{ comment.content }}</p>
        <p class="comment-time">创建时间: {{ comment.create_time }}</p>
      </div>
      <p v-if="comments.length === 0">该用户还没有发表任何评论。</p>
      <el-pagination
        v-if="comments.length > 0"
        layout="prev, pager, next"
        :total="comments.length"
        :page-size="pageSize"
        @current-change="handlePageChange"
        :style="{ color: 'red' }"
      />
    </main>
  </div>
</template>

<script>
import axiosInstance from "@/utils/request";
import dayjs from "dayjs";
import { computed } from "vue";
import { useStore } from "vuex";

const Url = "http://localhost:8080"; //inject("$Url");

export default {
  name: "UserHomepage",
  data() {
    return {
      user: {},
      comments: [],
      currentPage: 1,
      pageSize: 4,
    };
  },
  created() {
    const user = computed(() => this.store.state.user);

    if (!user.value || !user.value.id) {
      this.$message.error("用户未登录");
      this.$router.push("/login");
    } else {
      this.fetchComments();
    }
  },
  computed: {
    displayedComments() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.comments.slice(startIndex, endIndex);
    },
  },
  methods: {
    EditProfile() {
      alert("跳转到修改个人信息页面");
      this.$router.push("/user_info_change");
    },
    ReturnToHomePage() {
      alert("跳转到主页");
      this.$router.push("/home");
    },
    fetchComments() {
      const user = computed(() => this.store.state.user);
      const userId = user.value.id;

      axiosInstance
        .get(Url + `/user/space/${userId}`)
        .then((response) => {
          const userData = response.data.data;

          // 获取用户信息
          this.user = {
            id: userData.id,
            username: userData.username,
            avatarUrl: userData.avatarUrl,
            // 其他用户信息属性
          };

          // 处理评论信息
          this.comments = userData.comments.map((comment) => ({
            id: comment.id,
            user_id: comment.userId,
            artifact_id: comment.artifactId,
            content: comment.content,
            create_time: this.formatDateTime(comment.createTime),
            artifact_name: "", // 先设置为空
            artifact_image: "", // 先设置为空
          }));

          // 获取评论对应的 artifact 信息
          this.comments.forEach((comment) => {
            axiosInstance
              .get(`http://localhost:8080/artifact/${comment.artifact_id}`)
              .then((response) => {
                const artifactData = response.data.data.artifact;
                // 更新评论中的 artifact_name 和 artifact_image
                comment.artifact_name = artifactData.artifactName;
                comment.artifact_image = artifactData.imageUrl;
              })
              .catch((error) => {
                console.error("Error fetching artifact details:", error);
              });
          });
        })
        .catch((error) => {
          console.error("Error fetching comments:", error);
        });
    },
    formatDateTime(dateTimeString) {
      return dayjs(dateTimeString).format("YYYY-MM-DD HH:mm:ss");
    },
    handlePageChange(newPage) {
      this.currentPage = newPage;
    },
    logout() {
      this.store.commit("setUser", null); // 清空 store.state.user
      this.$router.push("/home"); // 跳转到 /home 路由
    },
  },
  setup() {
    const store = useStore();
    /*const user = computed(() => store.state.user);*/

    return {
      /*user,*/
      store,
    };
  },
};
</script>
<style scoped>
.user-homepage {
  display: flex;
}

.sidebar {
  width: 200px;
  padding: 20px;
  background-color: #f9f9f9;
}

.profile {
  text-align: center;
}

.avatar {
  width: 100px;
  height: 100px;
  border-radius: 50%;
}

.comments-main {
  flex-grow: 1;
  padding: 20px;
}

.comment {
  margin-bottom: 20px;
  padding: 10px;
  background-color: #e9e9e9;
}

.comment-artifact {
  display: flex;
  align-items: start;
}

.artifact-image {
  width: 150px;
  height: 150px;
  margin-right: 10px;
}

.artifact-info h2 {
  margin: 0;
  color: #333;
}

.comment-text {
  font-size: 16px;
  white-space: pre-wrap;
}

.comment-time {
  font-size: 12px;
  color: #888;
}
@keyframes shake {
  0% {
    transform: translateX(0);
  }
  25% {
    transform: translateX(-5px);
  }
  75% {
    transform: translateX(5px);
  }
  100% {
    transform: translateX(0);
  }
}
.banned-container {
  display: flex;
  align-items: center;
  background-color: #ff0000;
  color: #ffffff;
  padding: 5px 10px;
  border-radius: 4px;
  animation: shake 0.5s infinite;
}

.banned-text {
  color: white;
  margin-right: 5px;
}

.banned-icon {
  width: 50px;
  height: 50px;
}
</style>
