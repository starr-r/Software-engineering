<template>
<!--  <div class="search-bar">
    <div class="breadcrumbs">
      <span>当前位置: 首页 > 全文检索</span>
    </div>
    <div class="search-container">
      <input
          type="text"
          v-model="searchText"
          placeholder="输入搜索关键词"
          class="search-input"
      />
      <div class="selectors">
        &lt;!&ndash; 可以根据需要复制更多的下拉选择器 &ndash;&gt;
        <select v-model="selectedCategory" class="search-select">
          <option disabled value="">选择分类</option>
          &lt;!&ndash; Option items would be dynamically rendered here &ndash;&gt;
        </select>
        &lt;!&ndash; 添加其他选择器 &ndash;&gt;
      </div>
      <button @click="performSearch" class="search-button">
        <span class="search-icon">🔍</span>
      </button>
    </div>
  </div>-->

  <div class="breadcrumbs">
    <span v-for="(crumb, index) in breadcrumbs" :key="index" class="breadcrumb">
      <a
          href=""
          @click.prevent="navigateTo(crumb)"
          v-if="index < breadcrumbs.length - 1"
      >
        {{ crumb.text }}
      </a>
      <span v-else>{{ crumb.text }}</span>
    </span>
  </div>
</template>

<script>
import { useRoute, useRouter } from 'vue-router';
import { onMounted, ref, computed, getCurrentInstance } from 'vue'
export default {

  data() {
    return {
      searchText: '',
      selectedCategory: '',
      // Add other data properties as needed
    };
  },
  setup() {
    const route = useRoute();
    const router = useRouter();

    // 假设路由元信息中包含了面包屑信息
    const breadcrumbs = computed(() => route.meta.breadcrumbs);

    const navigateTo = (crumb) => {
      router.push(crumb.to);
    };

    return { breadcrumbs, navigateTo };
  },
  methods: {
    performSearch() {
      // Implement search logic here
      console.log('Searching for:', this.searchText);
    },
  },
};
</script>

<style scoped>
.breadcrumbs a {
  cursor: pointer;
  color: #007bff;
  text-decoration: none;
}
.breadcrumbs a:hover {
  text-decoration: underline;
}
.breadcrumb:not(:last-of-type)::after {
  content: ' > ';
}

.breadcrumbs {
  margin-bottom: 12px;
  color: #666;
}

.search-container {
  display: flex;
  gap: 8px;
  align-items: center;
}

.search-input {
  flex-grow: 1;
  padding: 8px 12px;
  border: 1px solid #ccc;
  border-radius: 20px;
}

.search-select {
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 20px;
}

.search-button {
  padding: 8px 16px;
  border: none;
  border-radius: 20px;
  background-color: white;
  cursor: pointer;
}

.search-button .search-icon {
  font-size: 1.2em;
}
</style>