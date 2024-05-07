<template>
  <div class="bullet-comment-container">
    <div
      v-for="(comment, index) in visibleComments"
      :key="index"
      class="bullet-comment"
      :style="{ top: `${index * 30}px`, animationDelay: `${index * 1}s` }"
      @animationend="removeComment(index)"
    >
      {{ comment }}
    </div>
    <input
      v-model="newComment"
      @keyup.enter="addComment"
      placeholder="请输入弹幕..."
      class="bullet-comment-input"
    />
  </div>
</template>

<script>
export default {
  data() {
    return {
      comments: [],
      newComment: "",
    };
  },
  computed: {
    visibleComments() {
      return this.comments.slice(0, 5); // 限制显示的弹幕数量为5个
    },
  },
  methods: {
    addComment() {
      if (this.newComment.trim() !== "") {
        this.comments.push(this.newComment.trim());
        this.newComment = "";
      }
    },
    removeComment(index) {
      this.comments.splice(index, 1);
    },
  },
};
</script>

<style>
.bullet-comment-container {
  position: relative;
  height: 100vh;
  overflow: hidden;
}

.bullet-comment {
  position: absolute;
  right: 0;
  white-space: nowrap;
  animation: fly-in 5s linear;
}

@keyframes fly-in {
  from {
    right: 100%;
  }
  to {
    right: 0;
  }
}

.bullet-comment-input {
  position: fixed;
  bottom: 10px;
  right: 10px;
}
</style>
