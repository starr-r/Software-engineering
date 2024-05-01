<template>
  <div class="user-homepage">
    <aside class="sidebar">
      <div class="profile">
        <img :src="user.avatarUrl" alt="User Avatar" class="avatar">
        <h1>{{ user.username }}</h1>
        <button @click="EditProfile">修改个人信息</button>
        <button @click="ReturnToHomePage">返回主页</button>
      </div>
      <!-- 其他个人信息展示 -->
    </aside>

    <main class="comments-main">
      <h1>用户评论</h1>
      <div v-for="comment in comments" :key="comment.id" class="comment">
        <div class="comment-artifact">
          <img :src="comment.artifact_image" alt="Artifact Image" class="artifact-image">
          <div class="artifact-info">
            <h2>{{ comment.artifact_name }}</h2>
          </div>
        </div>
        <p class="comment-text">{{ comment.content }}</p>
        <p class="comment-time">创建时间: {{ comment.create_time }}</p>
      </div>
      <p v-if="comments.length === 0">该用户还没有发表任何评论。</p>
    </main>
  </div>
</template>

<script>
import axiosInstance from '@/utils/request';

export default {
  name: 'UserHomepage',
  data() {
    return {
      user: {
        id: 'user123',
        username: 'test用户名',
        avatarUrl: require('@/assets/img/1.jpg'),
        email: 'user@example.com',
        phone: '1234567890',
        createTime: '2021-01-01',
        updateTime: '2021-02-01',
        abanned: false
      },
      comments: [
      {
        id: 1,
        user_id: 123,
        artifact_id: 1001,
        content: '这是我对这件文物的第一印象，非常震撼！',
        create_time: '2023-04-10T08:00:00Z',
        artifact_name: '秦始皇兵马俑',
        artifact_image: 'https://img.cjyun.org.cn/a/10695/202311/37b7ba2219560491674b04d609451358.jpeg'
      },
      {
        id: 2,
        user_id: 123,
        artifact_id: 1002,
        content: '这件文物的历史背景非常吸引人。',
        create_time: '2023-04-11T09:30:00Z',
        artifact_name: '敦煌莫高窟壁画',
        artifact_image: 'https://img.cjyun.org.cn/a/10695/202311/37b7ba2219560491674b04d609451358.jpeg'
      },
      {
        id: 3,
        user_id: 123,
        artifact_id: 1003,
        content: '我对这件文物的细节处理印象深刻。',
        create_time: '2023-04-12T14:00:00Z',
        artifact_name: '故宫博物院的玉璧',
        artifact_image: 'https://img.cjyun.org.cn/a/10695/202311/37b7ba2219560491674b04d609451358.jpeg'
      },
      {
        id: 4,
        user_id: 123,
        artifact_id: 1004,
        content: '这是我最喜欢的一件文物，每次看都有新的感受。',
        create_time: '2023-04-13T10:15:00Z',
        artifact_name: '三星堆青铜面具',
        artifact_image: 'https://img.cjyun.org.cn/a/10695/202311/37b7ba2219560491674b04d609451358.jpeg'
      }
      ], // 后面要清空,现在用于测试
    };
  },
  created() {
    this.fetchComments();
  },
  methods: {
    EditProfile() {
      alert('跳转到修改个人信息页面');
      this.$router.push('/user_info_change');
    },
    ReturnToHomePage() {
      alert('跳转到主页');
      this.$router.push('/home');
    },
    fetchComments() {
      const userId = this.user.id;
      axiosInstance.get(`/api/comments/${userId}`).then(response => {
        // 假设返回的数据是数组格式，并且每个评论项中都包含了artifact_name和artifact_image
        this.comments = response.data.map(comment => ({
          ...comment,
          create_time: this.formatDateTime(comment.create_time),
        }));
      }).catch(error => {
        console.error('Error fetching comments:', error);
      });
    },
    formatDateTime(dateTimeString) {
      return new Date(dateTimeString).toLocaleString(); // 格式化日期时间
    }
  }
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
  width: 150px; /* 大小可以根据需要调整 */
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
</style>