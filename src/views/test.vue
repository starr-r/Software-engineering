<template>
  <el-dropdown class="el-dropdown-menu">
    <el-button>
      {{ se_material || '选择文物类型' }}<el-icon class="el-icon--right"><arrow-down /></el-icon>
    </el-button>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item v-for="action in actions" :key="action" @click="handleOptionClick(action)">
          {{ action }}
        </el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>
</template>

<script setup>
import { ref } from 'vue';
import { ArrowDown } from '@element-plus/icons-vue';

const se_material = ref('');
const actions = ref(['Action 1', 'Action 2', 'Action 3', 'Action 4', 'Action 5']);

const handleOptionClick = (option) => {
  se_material.value = option;
  // 发送带有选项参数的请求到后端
  console.log('选中的选项:', option);
  // 发送请求的逻辑...
};
</script>

<style scoped>
.example-showcase .el-dropdown + .el-dropdown {
  margin-left: 15px;
}

.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: var(--el-color-primary);
  display: flex;
  align-items: center;
}

.el-dropdown-menu {
  max-height: 130px; /* 设置菜单高度为200px */
  overflow-y: auto; /* 设置滚动条 */
}

.el-dropdown-menu::-webkit-scrollbar {
  width: 6px; /* 滚动条宽度 */
}

.el-dropdown-menu::-webkit-scrollbar-thumb {
  background-color: #c1c1c1; /* 滚动条颜色 */
  border-radius: 5px; /* 滚动条边角弧度 */
}
</style>